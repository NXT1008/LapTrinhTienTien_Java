
package Views.Main.component;
import Views.Main.Model.Menu_Model_2;
import Views.Main.component.Event.EventMenuCallBack;
import Views.Main.component.Event.EventMenuSelected_2;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
public class ListMenu_2<E extends Object> extends JList<E> {

    public void addEventSelectedMenu(EventMenuSelected_2 event) {
        events.add(event);
    }
    
    private final DefaultListModel model;
    private final List<EventMenuSelected_2> events;
    private int selectedIndex = -1;

    public ListMenu_2() {
        model = new DefaultListModel();
        events = new ArrayList<>();
        super.setModel(model);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    int index = locationToIndex(me.getPoint());
                    Object obj = model.getElementAt(index);
                    if (obj instanceof Menu_Model_2) {
                        Menu_Model_2 data = (Menu_Model_2) obj;
                        if (data.getType() == Menu_Model_2.MenuType.MENU) {
                            if (index != selectedIndex) {
                                selectedIndex = -1;
                                runEvent(index);
                            }
                        }
                    } else {
                        if (index != selectedIndex) {
                            selectedIndex = -1;
                            runEvent(index);
                        }
                    }
                }
            }
        });
    }
    
    private void runEvent(int indexChange) {
        for (EventMenuSelected_2 event : events) {
            event.menuSelected(indexChange, new EventMenuCallBack() {
                @Override
                public void call(int index) {
                    //  This call back event run when animation done
                    selectedIndex = index;
                    repaint();
                }
            });
        }
    }

    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int index, boolean selected, boolean focus) {
                Menu_Model_2 data;
                if (o instanceof Menu_Model_2) {
                    data = (Menu_Model_2) o;
                } else {
                    data = new Menu_Model_2("agency", o + "", Menu_Model_2.MenuType.MENU);
                }
                MenuItem_2 item = new MenuItem_2(data);
                item.setSelected(index == selectedIndex);
                return item;
            }

        };
    }

    @Override
    public void setModel(ListModel<E> lm) {
        for (int i = 0; i < lm.getSize(); i++) {
            model.addElement(lm.getElementAt(i));
        }
    }

    public void addItem(Menu_Model_2 data) {
        model.addElement(data);
    }
}

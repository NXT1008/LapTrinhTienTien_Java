
package Views.Main.component;

import Views.Main.Model.Menu_Model_2;
import Views.Main.component.Event.EventMenu;
import Views.Main.component.Event.EventMenuCallBack;
import Views.Main.component.Event.EventMenuSelected_2;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Path2D;
import javax.swing.JFrame;
import javax.swing.Timer;


public class Menu_2 extends javax.swing.JPanel {

    public void addEventMenu(EventMenu event) {
        this.event = event;
    }
    
    private int selectedIndex = -1;
    private final Timer timer;
    private boolean toUp;   //  For animation is go up
    private int menuYTarget;
    private int menuY;
    private int speed = 2;
    private EventMenuCallBack callBack;
    private EventMenu event;

    public Menu_2() {
        initComponents();
        setOpaque(false);
        listMenu_2.setOpaque(false);
        listMenu_2.addEventSelectedMenu(new EventMenuSelected_2() {
            @Override
            public void menuSelected(int index, EventMenuCallBack callBack) {
                if (index != selectedIndex) {
                    Menu_2.this.callBack = callBack;
                    toUp = selectedIndex > index;
                    if (selectedIndex == -1) {
                        speed = 20;
                    } else {
                        speed = selectedIndex - index;
                        if (speed < 0) {
                            speed *= -1;
                            //  If speed valus <0 change it to <0   Ex : -1 to 1
                        }
                    }
                    speed++;    //  Add 1 speed
                    selectedIndex = index;
                    menuYTarget = selectedIndex * 35 + listMenu_2.getY(); //  menuYTarget is location y
                    if (!timer.isRunning()) {
                        timer.start();
                    }
                }
            }
        });
        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (toUp) {
                    if (menuY <= menuYTarget - 5) {
                        menuY = menuYTarget;
                        repaint();
                        timer.stop();
                        callBack.call(selectedIndex);
                        if (event != null) {
                            event.menuIndexChange(selectedIndex);
                        }
                    } else {
                        menuY -= speed;
                        repaint();
                    }
                } else {
                    if (menuY >= menuYTarget + 5) { //  Add style
                        menuY = menuYTarget;
                        repaint();
                        timer.stop();
                        callBack.call(selectedIndex);
                        if (event != null) {
                            event.menuIndexChange(selectedIndex);
                        }
                    } else {
                        menuY += speed;
                        repaint();
                    }
                }
            }
        });
        init();
    }
    
    private void init() {
        listMenu_2.addItem(new Menu_Model_2("employee", "Quản Lý Nhân Viên", Menu_Model_2.MenuType.MENU));
        listMenu_2.addItem(new Menu_Model_2("car", "Quản Lý Ô Tô", Menu_Model_2.MenuType.MENU));
        listMenu_2.addItem(new Menu_Model_2("customer", "Khách Hàng", Menu_Model_2.MenuType.MENU));
        listMenu_2.addItem(new Menu_Model_2("agency", "Chi Nhánh", Menu_Model_2.MenuType.MENU));
        listMenu_2.addItem(new Menu_Model_2("supplier", "Nhà Cung Cấp", Menu_Model_2.MenuType.MENU));
        listMenu_2.addItem(new Menu_Model_2("invoice", "Hóa Đơn", Menu_Model_2.MenuType.MENU));
        listMenu_2.addItem(new Menu_Model_2("receipt", "Phiếu Nhập", Menu_Model_2.MenuType.MENU));
        listMenu_2.addItem(new Menu_Model_2("warehouse", "Kho", Menu_Model_2.MenuType.MENU));
        listMenu_2.addItem(new Menu_Model_2("maintaince", "Dịch Vụ Bảo Dưỡng", Menu_Model_2.MenuType.MENU));
        listMenu_2.addItem(new Menu_Model_2("maintaince_bill", "Phiếu Bảo Dưỡng", Menu_Model_2.MenuType.MENU));
        listMenu_2.addItem(new Menu_Model_2("revenue", "Doanh Số", Menu_Model_2.MenuType.MENU));
        listMenu_2.addItem(new Menu_Model_2("analyze", "Thống Kê", Menu_Model_2.MenuType.MENU));
        listMenu_2.addItem(new Menu_Model_2("chart", "Lập Biểu Đồ", Menu_Model_2.MenuType.MENU));
        listMenu_2.addItem(new Menu_Model_2("logout", "Đăng Xuất", Menu_Model_2.MenuType.MENU));
        listMenu_2.addItem(new Menu_Model_2("", "", Menu_Model_2.MenuType.EMPTY));
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // chống nhòe
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#a8c0ff"), 0, getHeight(), Color.decode("#3f2b96"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        if (selectedIndex >= 0) {
            int menuX = 10; // tọa độ x  của khung chữ nhật
            int height = 35; // chiều cao của khung chữ nhật = Chiều cao của Menu Item
            int width = getWidth(); // chiều rộng của khung chữ nhật
            g2.setColor(new Color(242, 242, 242)); // đặt màu vẽ cho khung chữ nhật
            g2.fillRoundRect(menuX, menuY, width, height, 35, 35);
            Path2D.Float f = new Path2D.Float();
            f.moveTo(width - 30, menuY);
            f.curveTo(width - 10, menuY, width, menuY, width, menuY - 30);
            f.lineTo(width, menuY + height + 30);
            f.curveTo(width, menuY + height, width - 10, menuY + height, width - 30, menuY + height);
                
            g2.fill(f);
        }
        super.paintComponent(grphcs);
    }

    private int x;
    private int y;

    public void initMoving(JFrame fram) {
        panelMoving.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                x = me.getX() + 6;
                y = me.getY() + 6;
            }

        });
        panelMoving.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                fram.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMoving = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        listMenu_2 = new Views.Main.component.ListMenu_2<>();

        panelMoving.setOpaque(false);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Main/icon/logo.png"))); // NOI18N
        jLabel1.setText("Application");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(listMenu_2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(listMenu_2, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private Views.Main.component.ListMenu_2<String> listMenu_2;
    private javax.swing.JPanel panelMoving;
    // End of variables declaration//GEN-END:variables
}

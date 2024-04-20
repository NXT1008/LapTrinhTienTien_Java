
package Views.Main.component;

import Views.Main.Model.Menu_Model;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;

public class Menu extends javax.swing.JPanel {

    private EventMenuSelected event;
    
    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
        listMenu1.addEventMenuSelected(event);
    }
    
//    private int selectedIndex = -1;
//    private final Timer timer;
//    private boolean toUp;   //  For animation is go up
//    private int menuYTarget;
//    private int menuY;
//    private int speed = 2;
//    private EventMenuCallBack callBack;
//    private EventMenu events;
   
    public Menu() {
        initComponents();
        setOpaque(false);
        listMenu1.setOpaque(false);
        init();
    }
    
    private void init() {
        listMenu1.addItem(new Menu_Model("employee", "Quản Lý Nhân Viên", Menu_Model.MenuType.MENU));
        listMenu1.addItem(new Menu_Model("car", "Quản Lý Ô Tô", Menu_Model.MenuType.MENU));
        listMenu1.addItem(new Menu_Model("customer", "Khách Hàng", Menu_Model.MenuType.MENU));
        listMenu1.addItem(new Menu_Model("agency", "Chi Nhánh", Menu_Model.MenuType.MENU));
        listMenu1.addItem(new Menu_Model("supplier", "Nhà Cung Cấp", Menu_Model.MenuType.MENU));
        listMenu1.addItem(new Menu_Model("invoice", "Hóa Đơn", Menu_Model.MenuType.MENU));
        listMenu1.addItem(new Menu_Model("receipt", "Phiếu Nhập", Menu_Model.MenuType.MENU));
        listMenu1.addItem(new Menu_Model("warehouse", "Kho", Menu_Model.MenuType.MENU));
        listMenu1.addItem(new Menu_Model("maintaince", "Dịch Vụ Bảo Dưỡng", Menu_Model.MenuType.MENU));
        listMenu1.addItem(new Menu_Model("maintaince_bill", "Phiếu Bảo Dưỡng", Menu_Model.MenuType.MENU));
        listMenu1.addItem(new Menu_Model("revenue", "Doanh Số", Menu_Model.MenuType.MENU));
        listMenu1.addItem(new Menu_Model("analyze", "Thống Kê", Menu_Model.MenuType.MENU));
        listMenu1.addItem(new Menu_Model("chart", "Lập Biểu Đồ", Menu_Model.MenuType.MENU));
        listMenu1.addItem(new Menu_Model("logout", "Đăng Xuất", Menu_Model.MenuType.MENU));
        listMenu1.addItem(new Menu_Model("", "", Menu_Model.MenuType.EMPTY));
    }

    @Override
    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#1CB5E0"), 0, getHeight(), Color.decode("#000046"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(grphcs);
    }

    private int x;
    private int y;

    public void initMoving(JFrame fram) {
        panelMoving.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                x = me.getX();
                y = me.getY();
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
        lbLogo = new javax.swing.JLabel();
        listMenu1 = new Views.Main.component.ListMenu<>();

        panelMoving.setOpaque(false);

        lbLogo.setBackground(new java.awt.Color(255, 255, 255));
        lbLogo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbLogo.setForeground(new java.awt.Color(255, 255, 255));
        lbLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Main/icon/logo.png"))); // NOI18N
        lbLogo.setText("Car Store");

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMovingLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbLogo;
    private Views.Main.component.ListMenu<String> listMenu1;
    private javax.swing.JPanel panelMoving;
    // End of variables declaration//GEN-END:variables
}

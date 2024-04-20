package Views.Main.component;

import Models.NhanVien;
import Models.TaiKhoan;
import Services.NhanVienService;
import Views.Login.LoginForm.fLogin;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Window;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import raven.alerts.MessageAlerts;
import raven.popup.component.PopupController;

public class Header extends javax.swing.JPanel {

    public JMenuItem getMenuItemProfile() {
        return menuItemProfile;
    }

    
    private TaiKhoan tk;
    
    public Header() {
        initComponents();
        setOpaque(false);
        //initData();

    }
    
    private void initData(){
        tk = fLogin.getTk();
        NhanVien nv = NhanVienService.getInstance().findOne(tk.getMaNhanVien());
        lblUsername.setText(nv.getHoTenNhanVien());
        loadImage(nv.getGioiTinh());
    }

    private void loadImage(String gioiTinh){
        if (gioiTinh.equals("Nam")){
            imageProfile.setImage(new ImageIcon(getClass().getResource("/Views/OtherForm/Icon/user_2.png")));
        }
        else{
            imageProfile.setImage(new ImageIcon(getClass().getResource("/Views/OtherForm/Icon/woman.png")));
        }
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#1CB5E0"), 0, getHeight(), Color.decode("#19A6D3"));
        g2.setPaint(g);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(grphcs);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenuProfile = new javax.swing.JPopupMenu();
        menuItemProfile = new javax.swing.JMenuItem();
        menuItemExit = new javax.swing.JMenuItem();
        lblUsername = new javax.swing.JLabel();
        imageProfile = new Views.OtherForm.swing.PictureBox();

        menuItemProfile.setLabel("Thông tin cá nhân");
        popupMenuProfile.add(menuItemProfile);

        menuItemExit.setLabel("Đăng Xuất");
        menuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExitActionPerformed(evt);
            }
        });
        popupMenuProfile.add(menuItemExit);

        setBackground(new java.awt.Color(255, 255, 255));

        lblUsername.setForeground(new java.awt.Color(242, 242, 242));
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsername.setText("Nguyễn Xuân Thể");

        imageProfile.setImage(new javax.swing.ImageIcon(getClass().getResource("/Views/OtherForm/Icon/user_2.png"))); // NOI18N
        imageProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageProfileMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(366, Short.MAX_VALUE)
                .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imageProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(imageProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void imageProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageProfileMouseClicked
        popupMenuProfile.show(imageProfile, evt.getX(), evt.getY());
    }//GEN-LAST:event_imageProfileMouseClicked

    private void menuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExitActionPerformed
        MessageAlerts.getInstance().showMessage("Cảnh báo", "Bạn có thật sự muốn thoát?", MessageAlerts.MessageType.WARNING, MessageAlerts.YES_NO_OPTION, (PopupController pc, int i) -> {
            if (i == MessageAlerts.YES_OPTION) {
                SwingUtilities.invokeLater(() -> {
                    // Tìm cửa sổ cha và gọi dispose() trên nó
                    Window window = SwingUtilities.getWindowAncestor(Header.this);
                    if (window != null) {
                        window.dispose();
                    }
                    new fLogin().setVisible(true);
                });
            }
        });
    }//GEN-LAST:event_menuItemExitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Views.OtherForm.swing.PictureBox imageProfile;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JMenuItem menuItemProfile;
    private javax.swing.JPopupMenu popupMenuProfile;
    // End of variables declaration//GEN-END:variables
}

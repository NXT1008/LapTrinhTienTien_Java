package Views.Main;

import Models.TaiKhoan;
import Views.Login.LoginForm.fLogin;
import Views.OtherForm.fChiNhanh;
import Views.OtherForm.fDichVuBaoDuong;
import Views.OtherForm.fDoanhThu;
import Views.OtherForm.fHoaDon;
import Views.OtherForm.fHome;
import Views.OtherForm.fKhachHang;
import Views.OtherForm.fLapBieuDo;
import Views.OtherForm.fNhaCungCap;
import Views.OtherForm.fNhanVien;
import Views.OtherForm.fOTo;
import Views.OtherForm.fPhieuBaoDuong;
import Views.OtherForm.fPhieuNhap;
import Views.OtherForm.fProfile;
import Views.OtherForm.fThongKe;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import raven.alerts.MessageAlerts;
import raven.popup.GlassPanePopup;
import raven.popup.component.PopupCallbackAction;
import raven.popup.component.PopupController;
import raven.toast.Notifications;

public class MainController extends javax.swing.JFrame {

    private fNhanVien fNhanVien;
    private fOTo fOTo;
    private fKhachHang fKhachhang;
    private fChiNhanh fChiNhanh;
    private fHoaDon fHoaDon;
    private fDichVuBaoDuong fDichVuBaoDuong;
    private fNhaCungCap fNhaCungCap;
    private fPhieuNhap fPhieuNhap;
    private fPhieuBaoDuong fPhieuBaoDuong;
    private fThongKe fThongKe;
    private fDoanhThu fDoanhThu;
    private fLapBieuDo fBieuDo;
    private fHome fHome;
    private fProfile fProfile;

    public MainController() {
//        // Thiết lập kích thước cửa sổ mặc định
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        setPreferredSize(screenSize);
//        
//        // Mở rộng cửa sổ ra toàn bộ màn hình
//        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        
        // Install to custom message
        GlassPanePopup.install(this);
        
        TaiKhoan tk = fLogin.getTk();
        
        fNhanVien = new fNhanVien();
        fOTo = new fOTo();
        fKhachhang = new fKhachHang();
        fChiNhanh = new fChiNhanh();
        fHoaDon = new fHoaDon();
        fDichVuBaoDuong = new fDichVuBaoDuong();
        fNhaCungCap = new fNhaCungCap();
        fPhieuNhap = new fPhieuNhap();
        fPhieuBaoDuong = new fPhieuBaoDuong();
        fThongKe = new fThongKe();
        //fchart = new fChartHoaDon();
        fDoanhThu = new fDoanhThu();
        fBieuDo = new fLapBieuDo();
        
        fHome = new fHome();
        fProfile = new fProfile(tk.getMaNhanVien());
        
        initComponents();
        
        //setForm(fchart);
        setBackground(new Color(0, 0, 0, 0));
        menu.initMoving(MainController.this);
        
        // Event để mở Menu
        menu.addEventMenuSelected((int index) -> {
            System.out.println(String.valueOf(index));
            //System.out.println(tk.getTenDangNhap());
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, (long)200,"Message");
            
            switch (index) {
                case 0 ->{
                    fNhanVien.loadData();
                    setForm(fNhanVien);
                }
                case 1 ->
                    setForm(fOTo);
                case 2 -> // Khách Hàng
                    setForm(fKhachhang);
                case 3 ->
                    setForm(fChiNhanh);
                case 4 ->
                    setForm(fNhaCungCap);
                case 5 ->
                    setForm(fHoaDon);
                case 6 ->
                    setForm(fPhieuNhap);
                case 8 ->
                    setForm(fDichVuBaoDuong);
                case 9 ->
                    setForm(fPhieuBaoDuong);
                case 10 ->
                    setForm(fDoanhThu);
                case 11 ->
                    setForm(fThongKe);
                case 12 ->
                    setForm(fBieuDo);
                case 13 -> {
                    MessageAlerts.getInstance().showMessage("Cảnh báo", "Bạn có thật sự muốn thoát?", MessageAlerts.MessageType.WARNING, MessageAlerts.YES_NO_OPTION, new PopupCallbackAction() {
                        @Override
                        public void action(PopupController pc, int i) {
                            if (i == MessageAlerts.YES_OPTION){
                                setVisible(false);
                                new fLogin().setVisible(true);
                            }
                        }
                    });
                }
                default -> {
                    
                }
            }
        });
        
        // Event to open profile
        JMenuItem menuItemProfile = header.getMenuItemProfile();
        menuItemProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setForm(fProfile);
            }
        });
    }

    private void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBoder1 = new Views.Main.swing.PanelBoder();
        mainPanel = new javax.swing.JPanel();
        header = new Views.Main.component.Header();
        menu = new Views.Main.component.Menu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(243, 243, 243));
        setUndecorated(true);

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());

        header.setBackground(new java.awt.Color(26, 169, 214));
        header.setOpaque(true);

        javax.swing.GroupLayout panelBoder1Layout = new javax.swing.GroupLayout(panelBoder1);
        panelBoder1.setLayout(panelBoder1Layout);
        panelBoder1Layout.setHorizontalGroup(
            panelBoder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoder1Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBoder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 892, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelBoder1Layout.setVerticalGroup(
            panelBoder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoder1Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBoder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBoder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainController().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Views.Main.component.Header header;
    private javax.swing.JPanel mainPanel;
    private Views.Main.component.Menu menu;
    private Views.Main.swing.PanelBoder panelBoder1;
    // End of variables declaration//GEN-END:variables
}

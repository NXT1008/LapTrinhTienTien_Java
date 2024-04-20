
package Views.Login.LoginForm;

import DAO.TaiKhoanDAO;
import Models.TaiKhoan;
import Services.TaiKhoanService;
import Views.Login.components.*;
import Views.Main.MainController;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.JLayeredPane;
import javax.swing.UIManager;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import raven.alerts.MessageAlerts;
import raven.popup.GlassPanePopup;

public class fLogin extends javax.swing.JFrame {

    private final DecimalFormat df = new DecimalFormat("##0.###", DecimalFormatSymbols.getInstance(Locale.US));
    private MigLayout layout;
    private PanelCover cover;
    private PanelLoading loading;
    private PanelVerifyCode verifyCode;
    private PanelLoginAndRegister loginAndRegister;
    private boolean isLogin; // check status fLogin or Register
    private final double addSize = 30;
    private final double coverSize = 40; 
    private final double loginSize = 60;
    
    //TaiKhoan
    private static TaiKhoan tk;
    
    public fLogin() {
        // Install to custom message
        GlassPanePopup.install(this);
        
        initComponents();
        init();
    }

    private void init(){
        
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCover();
        loading = new PanelLoading();
        verifyCode = new PanelVerifyCode();
        
        // Event Click Button Sign Up
        ActionListener eventRegister = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                register();
            }
        };
        
        //Event Click to Sign In
        ActionListener eventLogin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                login();
            }
        };
        
        loginAndRegister = new PanelLoginAndRegister(eventRegister, eventLogin);
        
        // Code for Animation
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double fractionCover;
                double fractionLogin;
                double size = coverSize;
                if (fraction <= 0.5f) {
                    size += fraction * addSize;
                } else {
                    size += addSize - fraction * addSize;
                }
                if (isLogin) {
                    fractionCover = 1f - fraction;
                    fractionLogin = fraction;
                    if (fraction >= 0.5f) {
                        cover.registerRight(fractionCover * 100);
                    } else {
                        cover.loginRight(fractionLogin * 100);
                    }
                } else {
                    fractionCover = fraction;
                    fractionLogin = 1f - fraction;
                    if (fraction <= 0.5f) {
                        cover.registerLeft(fraction * 100);
                    } else {
                        cover.loginLeft((1f - fraction) * 100);
                    }
                }
                
                // Cover Green ở giữa thì chuyển đổi Login sang Register
                if (fraction >= 0.5f) {
                    loginAndRegister.showRegister(isLogin);
                }
                fractionCover = Double.parseDouble(df.format(fractionCover));
                fractionLogin = Double.parseDouble(df.format(fractionLogin));
                layout.setComponentConstraints(cover, "width " + size + "%, pos " + fractionCover + "al 0 n 100%");
                layout.setComponentConstraints(loginAndRegister, "width " + loginSize + "%, pos " + fractionLogin + "al 0 n 100%");
                bg.revalidate();
            }

            @Override
            public void end() {
                isLogin = !isLogin;
            }
        };
        
        // Add animate
        Animator animator = new Animator(800, target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0);  //  for smooth animation
        
        
        bg.setLayout(layout);
        bg.setLayer(loading, JLayeredPane.POPUP_LAYER);
        bg.setLayer(verifyCode, JLayeredPane.POPUP_LAYER);
        
        bg.add(loading, "pos 0 0 100% 100%");
        bg.add(verifyCode, "pos 0 0 100% 100%");
        bg.add(cover, "width " + coverSize + "%, pos 0al 0 n 100%");
        bg.add(loginAndRegister, "width " + loginSize + "%, pos 1al 0 n 100%");

        
        // Event for animate
        cover.addEvent(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!animator.isRunning())
                animator.start();
            }
            
        });
    }
    
    private void register(){
        TaiKhoan taiKhoan = loginAndRegister.getUser();
        
        if (taiKhoan.getMaNhanVien().equals("") || taiKhoan.getTenDangNhap().equals("") || taiKhoan.getMatKhau().equals("")){
            MessageAlerts.getInstance().showMessage("Fail", "Vui lòng điền đầy đủ thông tin!", 
                    MessageAlerts.MessageType.ERROR);
            return;
        }
        
        TaiKhoan tmp = TaiKhoanService.getInstance().findByMaNhanVien(taiKhoan.getMaNhanVien());
        if (tmp != null){
            MessageAlerts.getInstance().showMessage("Lỗi", "Mã nhân viên này đã được sử dụng!", 
                    MessageAlerts.MessageType.ERROR);
            return;
        }
        // Check trùng mã Nhân viên, trùng tài khoản
        boolean isDuplicate = TaiKhoanService.getInstance().login(taiKhoan.getTenDangNhap(), taiKhoan.getMatKhau());
        if (isDuplicate){
            MessageAlerts.getInstance().showMessage("Lỗi", "Tài khoản đã được sử dụng, vui lòng sử dụng tài khoản khác!", 
                    MessageAlerts.MessageType.ERROR);
            return;
        }
        boolean res = TaiKhoanService.getInstance().register(taiKhoan);
        if (res){
            MessageAlerts.getInstance().showMessage("Success", "Đăng ký thành công!!", 
                    MessageAlerts.MessageType.SUCCESS);
        }
        else{
            MessageAlerts.getInstance().showMessage("Fail!", "Đăng ký thất bại, vui lòng kiểm tra chính xác Mã nhân viên!!", 
                    MessageAlerts.MessageType.ERROR);
        }
        
    }
    
    private void login(){
        String username = loginAndRegister.getUsernameLogin();
        String passwd = loginAndRegister.getPasswordLogin();
        boolean res = TaiKhoanService.getInstance().login(username, passwd);
        if (res) {
            tk = TaiKhoanDAO.getInstance().login(username, passwd);
            //setVisible(false);
            this.dispose();
            new MainController().setVisible(true);
        } else {
            MessageAlerts.getInstance().showMessage("Fail", "Tài khoản hoặc mật khẩu không chính xác!",
                    MessageAlerts.MessageType.ERROR);
        }

    }

    public static TaiKhoan getTk() {
        return tk;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 728, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 409, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
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
            java.util.logging.Logger.getLogger(fLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("raven.themes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 12));
        FlatMacLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}

package Views.Login.LoginForm;

import Views.Login.components.PanelCover;
import Views.Login.components.PanelLoading;
import Views.Login.components.PanelLoginAndRegister;
import Views.Login.components.PanelVerifyCode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.JLayeredPane;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class fLogin extends javax.swing.JFrame {

    private final DecimalFormat df = new DecimalFormat("##0.###", DecimalFormatSymbols.getInstance(Locale.US));
    private MigLayout layout;
    private PanelCover cover; // Vẽ màu xanh
    private PanelLoading loading;
    private PanelVerifyCode verifyCode;
    private PanelLoginAndRegister loginAndRegister;
    private boolean isLogin;
    private final double addSize = 30;
    private final double coverSize = 40;
    private final double loginSize = 60;

    public fLogin() {
        initComponents();
        init();
    }

    private void init() {
        // Khai báo
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCover();
        loading = new PanelLoading();
        verifyCode = new PanelVerifyCode();
        
        // Sự kiện khi nhấn đăng ký
        ActionListener eventRegister = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register();
            }
        };
        
        loginAndRegister = new PanelLoginAndRegister(eventRegister);
        
        //Sự kiện cho animation
        TimingTarget target = new TimingTargetAdapter(){
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
                if (fraction >= 0.5f) {
                    loginAndRegister.showRegister(isLogin);
                }
                fractionCover = Double.parseDouble(df.format(fractionCover)); // Ep kieu
                fractionLogin = Double.parseDouble(df.format(fractionLogin));
                layout.setComponentConstraints(cover, "width " + size + "%, pos " + fractionCover + "al 0 n 100%");
                layout.setComponentConstraints(loginAndRegister, "width " + loginSize + "%, pos " + fractionLogin + "al 0 n 100%");
                layoutPanelBackgroundLogin.revalidate();
            }

            @Override
            public void end() {
                isLogin = !isLogin;
            }
        };
        
        Animator animator = new Animator(800, target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0); // for smooth animation
        
        // Add Panel vào Giao diện
        layoutPanelBackgroundLogin.setLayout(layout);
        layoutPanelBackgroundLogin.setLayer(loading, JLayeredPane.POPUP_LAYER);
        layoutPanelBackgroundLogin.setLayer(verifyCode, JLayeredPane.POPUP_LAYER);
        layoutPanelBackgroundLogin.add(loading, "pos 0 0 100% 100%");
        layoutPanelBackgroundLogin.add(verifyCode, "pos 0 0 100% 100%");
        layoutPanelBackgroundLogin.add(cover, "width " + coverSize + "%, pos 0al 0 n 100%");
        layoutPanelBackgroundLogin.add(loginAndRegister, "width " + loginSize + "%, pos " + (isLogin ? "0al" : "1al") + " 0 n 100%"); //  1al as 100%
        
        
        // Add event
        cover.addEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()){
                    animator.start();
                }
            }
        });
    }

    // Function đăng ký tài khoản
    private void register() {
        //Hiển thị message để thông báo đăng kí có thành công hay không
        //showMessage(Message.MessageType.ERROR, "Test Message");
        //loading.setVisible(true);
        verifyCode.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layoutPanelBackgroundLogin = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        layoutPanelBackgroundLogin.setBackground(new java.awt.Color(255, 255, 255));
        layoutPanelBackgroundLogin.setOpaque(true);
        layoutPanelBackgroundLogin.setPreferredSize(new java.awt.Dimension(719, 460));

        javax.swing.GroupLayout layoutPanelBackgroundLoginLayout = new javax.swing.GroupLayout(layoutPanelBackgroundLogin);
        layoutPanelBackgroundLogin.setLayout(layoutPanelBackgroundLoginLayout);
        layoutPanelBackgroundLoginLayout.setHorizontalGroup(
            layoutPanelBackgroundLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
        );
        layoutPanelBackgroundLoginLayout.setVerticalGroup(
            layoutPanelBackgroundLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layoutPanelBackgroundLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layoutPanelBackgroundLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane layoutPanelBackgroundLogin;
    // End of variables declaration//GEN-END:variables

}

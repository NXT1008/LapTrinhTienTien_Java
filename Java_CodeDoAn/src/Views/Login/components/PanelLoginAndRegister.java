package Views.Login.components;

import Views.Login.swing.Button;
import Views.Login.swing.MyPasswordField;
import Views.Login.swing.MyTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class PanelLoginAndRegister extends javax.swing.JLayeredPane {

    public PanelLoginAndRegister(ActionListener eventRegister) {
        initComponents();
        
        //Khởi tạo giao diện cho Login & Register
        initRegisterForm(eventRegister);
        initLoginForm();
        
        //Hiển thị
        pnlLogin.setVisible(false);
        pnlRegister.setVisible(true);
    }
    
    private void initRegisterForm(ActionListener eventRegister){
        pnlRegister.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        
        JLabel label = new JLabel("Create Account");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        pnlRegister.add(label);
        
        // txtUsername
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/Views/Login/Icon/user.png")));
        txtUser.setHint("Name");
        pnlRegister.add(txtUser, "w 60%");
        
        // txtEmail
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/Views/Login/Icon/mail.png")));
        txtEmail.setHint("Email");
        pnlRegister.add(txtEmail, "w 60%");
        
        //txtPassword
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/Views/Login/Icon/pass.png")));
        txtPass.setHint("Password");
        pnlRegister.add(txtPass, "w 60%");
        
        //btnDangKy
        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("SIGN UP");
        cmd.addActionListener(eventRegister); // Thêm sự kiện cho nút Đăng ký
        pnlRegister.add(cmd, "w 40%, h 40");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                String userName = txtUser.getText().trim();
//                String email = txtEmail.getText().trim();
//                String password = String.valueOf(txtPass.getPassword());
//                user = new ModelUser(0, userName, email, password);
                    
            }
        });
    }
    
    private void initLoginForm(){
        pnlLogin.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        
        JLabel label = new JLabel("Sign In");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        pnlLogin.add(label);
        
        //txtEmail
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/Views/Login/Icon/mail.png")));
        txtEmail.setHint("Email");
        pnlLogin.add(txtEmail, "w 60%");
        
        //txtPassword
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/Views/Login/Icon/pass.png")));
        txtPass.setHint("Password");
        pnlLogin.add(txtPass, "w 60%");
        
         //btnForgotPass
        JButton cmdForget = new JButton("Forgot your password ?");
        cmdForget.setForeground(new Color(100, 100, 100));
        cmdForget.setFont(new Font("sansserif", 1, 12));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlLogin.add(cmdForget);
        
        //btnDangNhap
        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("SIGN IN");
        pnlLogin.add(cmd, "w 40%, h 40");
    }
    
    public void showRegister(boolean show) {
        if (show) {
            pnlRegister.setVisible(true);
            pnlLogin.setVisible(false);
        } else {
            pnlRegister.setVisible(false);
            pnlLogin.setVisible(true);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLogin = new javax.swing.JPanel();
        pnlRegister = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        pnlLogin.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlLoginLayout = new javax.swing.GroupLayout(pnlLogin);
        pnlLogin.setLayout(pnlLoginLayout);
        pnlLoginLayout.setHorizontalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 289, Short.MAX_VALUE)
        );
        pnlLoginLayout.setVerticalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 249, Short.MAX_VALUE)
        );

        add(pnlLogin, "card3");

        pnlRegister.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlRegisterLayout = new javax.swing.GroupLayout(pnlRegister);
        pnlRegister.setLayout(pnlRegisterLayout);
        pnlRegisterLayout.setHorizontalGroup(
            pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 289, Short.MAX_VALUE)
        );
        pnlRegisterLayout.setVerticalGroup(
            pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 249, Short.MAX_VALUE)
        );

        add(pnlRegister, "card2");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPanel pnlRegister;
    // End of variables declaration//GEN-END:variables
}

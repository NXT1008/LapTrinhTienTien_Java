
package Views.Login.components;

import Models.TaiKhoan;
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

    public TaiKhoan getUser() {
        return user;
    }

    public String getUsernameLogin() {
        return usernameLogin;
    }

    public String getPasswordLogin() {
        return passwordLogin;
    }
    
    private TaiKhoan user;
    private String usernameLogin, passwordLogin;
    
    public PanelLoginAndRegister(ActionListener eventRegister, ActionListener eventLogin) {
        initComponents();
        initRegister(eventRegister);
        initLogin(eventLogin);
        
        login.setVisible(true);
        register.setVisible(false);
    }

    private void initRegister(ActionListener eventRegister){
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        
        JLabel label = new JLabel("Đăng Ký Tài Khoản");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        register.add(label);
        
        MyTextField tfMaNhanVien = new MyTextField();
        tfMaNhanVien.setPrefixIcon(new ImageIcon(getClass().getResource("/Views/Login/Icon/user.png")));
        tfMaNhanVien.setHint("Mã nhân viên");
        register.add(tfMaNhanVien, "w 60%");
        
        MyTextField tfUserName = new MyTextField();
        tfUserName.setPrefixIcon(new ImageIcon(getClass().getResource("/Views/Login/Icon/mail.png")));
        tfUserName.setHint("Tài khoản");
        register.add(tfUserName, "w 60%");
        
        MyPasswordField tfPassword = new MyPasswordField();
        tfPassword.setPrefixIcon(new ImageIcon(getClass().getResource("/Views/Login/Icon/pass.png")));
        tfPassword.setHint("Mật khẩu");
        register.add(tfPassword, "w 60%");
        
        Button btnRegister = new Button();
        btnRegister.setBackground(new Color(7, 164, 121));
        btnRegister.setForeground(new Color(250, 250, 250));
        btnRegister.addActionListener(eventRegister);
        btnRegister.setText("ĐĂNG KÝ");
        register.add(btnRegister, "w 40%, h 40");
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String maNV = tfMaNhanVien.getText().trim();
                String username = tfUserName.getText().trim();
                String password = String.valueOf(tfPassword.getPassword());
                user = new TaiKhoan(username, password, maNV, false);
                clear(tfUserName, tfMaNhanVien, tfPassword);
            }
        });
    }
    
    private void initLogin(ActionListener eventLogin){
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        
        JLabel label = new JLabel("Đăng Nhập");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        login.add(label);
        
        MyTextField tfUsernameLogin = new MyTextField();
        tfUsernameLogin.setPrefixIcon(new ImageIcon(getClass().getResource("/Views/Login/Icon/mail.png")));
        tfUsernameLogin.setHint("Tài Khoản");
        tfUsernameLogin.setText("admin");
        login.add(tfUsernameLogin, "w 60%");
        
        MyPasswordField tfPasswordLogin = new MyPasswordField();
        tfPasswordLogin.setPrefixIcon(new ImageIcon(getClass().getResource("/Views/Login/Icon/pass.png")));
        tfPasswordLogin.setHint("Mật Khẩu");
        tfPasswordLogin.setText("1");
        login.add(tfPasswordLogin, "w 60%");
        
        JButton cmdForget = new JButton("Forgot your password?");
        cmdForget.setForeground(new Color(100, 100, 100));
        cmdForget.setFont(new Font("sansserif", 1, 12));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.add(cmdForget);
        
        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("ĐĂNG NHẬP");
        cmd.addActionListener(eventLogin);
        
        login.add(cmd, "w 40%, h 40");
        
        cmd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                usernameLogin = tfUsernameLogin.getText();
                passwordLogin = String.valueOf(tfPasswordLogin.getPassword()).trim();
                tfUsernameLogin.setText("");
                tfPasswordLogin.setText("");
            }
        });
        
       
    }
    
    
    public void showRegister(boolean show) {
        if (!show) {
            register.setVisible(true);
            login.setVisible(false);
        } else {
            register.setVisible(false);
            login.setVisible(true);
        }
    }
    
    public void clear(MyTextField tfUsername, MyTextField tfMaNV, MyPasswordField tfPasswd){
        tfUsername.setText("");
        tfMaNV.setText("");
        tfPasswd.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}

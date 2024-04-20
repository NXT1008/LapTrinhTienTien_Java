
package Views.OtherForm;

import Models.NhanVien;
import Models.TaiKhoan;
import Services.ChiNhanhService;
import Services.NhanVienService;
import Services.TaiKhoanService;
import Views.OtherForm.swing.TextField;
import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import raven.alerts.MessageAlerts;

public class fProfile extends javax.swing.JPanel {

    private final String maNhanVien;
    
    public fProfile(String maNhanVien) {
        initComponents();
        this.maNhanVien = maNhanVien;
        initAll();
    }
    
    private void initAll(){
        loadMaChiNhanh();
        setData();
        DisableTextFieldTaiKhoan();
        DisableTextFieldNhanVien();
        btnLuuMK.setEnabled(false);
        btnLuuTT.setEnabled(false);
    }
    
    public void setData(){
        NhanVien nv = NhanVienService.getInstance().findOne(maNhanVien);
        if (nv != null){
            TaiKhoan tk = TaiKhoanService.getInstance().findByMaNhanVien(maNhanVien);
            tfTenDangNhap.setText(tk.getTenDangNhap());
            tfMatKhau.setText(tk.getMatKhau());
            
            tfHoTen.setText(nv.getHoTenNhanVien());
            tfCCCD.setText(nv.getCccd());
            tfNgaySinh.setText(nv.getNgaySinh().toString());
            tfGioiTinh.setText(nv.getGioiTinh());
            tfDiaChi.setText(nv.getDiaChi());
            tfSoDienThoai.setText(nv.getSoDienThoai());
            tfChucVu.setText(nv.getChucVu());
            cbbMaChiNhanh.setSelectedItem(nv.getMaChiNhanh());
        }
    }
    
    private void loadMaChiNhanh(){
        List<String> list = ChiNhanhService.getInstance().listMaChiNhanh();
        String[] arr = new String[list.size()];
        for (int i=0; i<list.size(); i++){
            arr[i] = list.get(i);
        }
        ComboBoxModel<String> model = new DefaultComboBoxModel<>(arr);
        cbbMaChiNhanh.setModel(model);
    }
    
    private void EnableTextFieldTaiKhoan() {
        for (Component c : panelRoundTaiKhoan.getComponents()) {
            if (c instanceof TextField textField) {
                textField.setEditable(true);
            }
        }
    }

    private void DisableTextFieldTaiKhoan() {
        for (Component c : panelRoundTaiKhoan.getComponents()) {
            if (c instanceof TextField textField) {
                textField.setEditable(false);
                textField.setBackground(Color.WHITE);
            }
        }
    }
    
    private void EnableTextFieldNhanVien() {
        for (Component c : panelRoundNhanVien.getComponents()) {
            if (c instanceof TextField textField) {
                textField.setEditable(true);
            }
        }
    }

    private void DisableTextFieldNhanVien() {
        for (Component c : panelRoundNhanVien.getComponents()) {
            if (c instanceof TextField textField) {
                textField.setEditable(false);
                textField.setBackground(Color.WHITE);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelRoundTaiKhoan = new Views.OtherForm.swing.PanelRound();
        tfTenDangNhap = new Views.OtherForm.swing.TextField();
        tfMatKhau = new Views.OtherForm.swing.TextField();
        jLabel3 = new javax.swing.JLabel();
        btnDoiMatKhau = new Views.OtherForm.swing.MyButton();
        btnLuuMK = new Views.OtherForm.swing.MyButton();
        panelRoundNhanVien = new Views.OtherForm.swing.PanelRound();
        tfNgaySinh = new Views.OtherForm.swing.TextField();
        tfDiaChi = new Views.OtherForm.swing.TextField();
        tfChucVu = new Views.OtherForm.swing.TextField();
        tfHoTen = new Views.OtherForm.swing.TextField();
        tfCCCD = new Views.OtherForm.swing.TextField();
        tfSoDienThoai = new Views.OtherForm.swing.TextField();
        tfGioiTinh = new Views.OtherForm.swing.TextField();
        jLabel4 = new javax.swing.JLabel();
        btnLuuTT = new Views.OtherForm.swing.MyButton();
        btnCapNhatThongTin = new Views.OtherForm.swing.MyButton();
        cbbMaChiNhanh = new Views.OtherForm.component.Combobox.Combobox();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG TIN CÁ NHÂN");

        panelRoundTaiKhoan.setBackground(new java.awt.Color(255, 255, 255));
        panelRoundTaiKhoan.setRoundBottomLeft(20);
        panelRoundTaiKhoan.setRoundBottomRight(20);
        panelRoundTaiKhoan.setRoundTopLeft(20);
        panelRoundTaiKhoan.setRoundTopRight(20);

        tfTenDangNhap.setLabelText("Tên Đăng Nhập");

        tfMatKhau.setLabelText("Mật Khẩu");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("Thông tin tài khoản");

        btnDoiMatKhau.setBackground(new java.awt.Color(204, 255, 255));
        btnDoiMatKhau.setForeground(new java.awt.Color(51, 51, 255));
        btnDoiMatKhau.setText("Đổi Mật Khẩu");
        btnDoiMatKhau.setBorderColor(new java.awt.Color(255, 255, 255));
        btnDoiMatKhau.setColor(new java.awt.Color(204, 255, 255));
        btnDoiMatKhau.setColorOver(new java.awt.Color(102, 204, 255));
        btnDoiMatKhau.setRadius(20);
        btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhauActionPerformed(evt);
            }
        });

        btnLuuMK.setBackground(new java.awt.Color(204, 255, 255));
        btnLuuMK.setForeground(new java.awt.Color(51, 51, 255));
        btnLuuMK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/OtherForm/Icon/save.png"))); // NOI18N
        btnLuuMK.setText("Lưu");
        btnLuuMK.setBorderColor(new java.awt.Color(255, 255, 255));
        btnLuuMK.setColor(new java.awt.Color(204, 255, 255));
        btnLuuMK.setColorOver(new java.awt.Color(102, 204, 255));
        btnLuuMK.setRadius(20);
        btnLuuMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuMKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRoundTaiKhoanLayout = new javax.swing.GroupLayout(panelRoundTaiKhoan);
        panelRoundTaiKhoan.setLayout(panelRoundTaiKhoanLayout);
        panelRoundTaiKhoanLayout.setHorizontalGroup(
            panelRoundTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundTaiKhoanLayout.createSequentialGroup()
                .addGroup(panelRoundTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRoundTaiKhoanLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(tfTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRoundTaiKhoanLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel3))
                    .addGroup(panelRoundTaiKhoanLayout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(btnDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(panelRoundTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLuuMK, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        panelRoundTaiKhoanLayout.setVerticalGroup(
            panelRoundTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundTaiKhoanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(panelRoundTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRoundTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuuMK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        panelRoundNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        panelRoundNhanVien.setRoundBottomLeft(20);
        panelRoundNhanVien.setRoundBottomRight(20);
        panelRoundNhanVien.setRoundTopLeft(20);
        panelRoundNhanVien.setRoundTopRight(20);

        tfNgaySinh.setLabelText("Ngày Sinh");

        tfDiaChi.setLabelText("Địa Chỉ");

        tfChucVu.setLabelText("Chức Vụ");

        tfHoTen.setLabelText("Họ Tên");

        tfCCCD.setLabelText("CCCD");

        tfSoDienThoai.setLabelText("Số Điện Thoại");

        tfGioiTinh.setLabelText("Giới Tính");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("Thông tin chi tiết");

        btnLuuTT.setBackground(new java.awt.Color(204, 255, 255));
        btnLuuTT.setForeground(new java.awt.Color(51, 51, 255));
        btnLuuTT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/OtherForm/Icon/save.png"))); // NOI18N
        btnLuuTT.setText("Lưu");
        btnLuuTT.setBorderColor(new java.awt.Color(255, 255, 255));
        btnLuuTT.setColor(new java.awt.Color(204, 255, 255));
        btnLuuTT.setColorOver(new java.awt.Color(102, 204, 255));
        btnLuuTT.setRadius(20);
        btnLuuTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuTTActionPerformed(evt);
            }
        });

        btnCapNhatThongTin.setBackground(new java.awt.Color(204, 255, 255));
        btnCapNhatThongTin.setForeground(new java.awt.Color(51, 51, 255));
        btnCapNhatThongTin.setText("Cập Nhật Thông Tin");
        btnCapNhatThongTin.setBorderColor(new java.awt.Color(255, 255, 255));
        btnCapNhatThongTin.setColor(new java.awt.Color(204, 255, 255));
        btnCapNhatThongTin.setColorOver(new java.awt.Color(102, 204, 255));
        btnCapNhatThongTin.setRadius(20);
        btnCapNhatThongTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatThongTinActionPerformed(evt);
            }
        });

        cbbMaChiNhanh.setLabeText("Chi Nhánh Làm Việc");

        javax.swing.GroupLayout panelRoundNhanVienLayout = new javax.swing.GroupLayout(panelRoundNhanVien);
        panelRoundNhanVien.setLayout(panelRoundNhanVienLayout);
        panelRoundNhanVienLayout.setHorizontalGroup(
            panelRoundNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundNhanVienLayout.createSequentialGroup()
                .addGroup(panelRoundNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRoundNhanVienLayout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(btnCapNhatThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(btnLuuTT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRoundNhanVienLayout.createSequentialGroup()
                        .addGroup(panelRoundNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRoundNhanVienLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel4)
                                .addGap(107, 107, 107))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundNhanVienLayout.createSequentialGroup()
                                .addGroup(panelRoundNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                    .addComponent(tfGioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(44, 44, 44)))
                        .addGroup(panelRoundNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfCCCD, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                        .addGap(48, 48, 48)
                        .addGroup(panelRoundNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfSoDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addGroup(panelRoundNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfChucVu, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(cbbMaChiNhanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        panelRoundNhanVienLayout.setVerticalGroup(
            panelRoundNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundNhanVienLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRoundNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbMaChiNhanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(panelRoundNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(panelRoundNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCapNhatThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuuTT, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelRoundNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRoundTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(panelRoundTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(panelRoundNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMatKhauActionPerformed
        tfMatKhau.setEditable(true);
        btnDoiMatKhau.setEnabled(false);
        btnLuuMK.setEnabled(true);
    }//GEN-LAST:event_btnDoiMatKhauActionPerformed

    private void btnCapNhatThongTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatThongTinActionPerformed
        EnableTextFieldNhanVien();
        btnLuuTT.setEnabled(true);
        btnCapNhatThongTin.setEnabled(false);
    }//GEN-LAST:event_btnCapNhatThongTinActionPerformed

    private void btnLuuMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuMKActionPerformed
        String matKhau = tfMatKhau.getText();
        
        TaiKhoan tk = TaiKhoanService.getInstance().findByMaNhanVien(maNhanVien);
        tk.setMatKhau(matKhau);
        
        boolean res = TaiKhoanService.getInstance().updatePassword(tk);
        if (res) {
            MessageAlerts.getInstance().showMessage("Success!", "Đổi mật khẩu thành công!",
                    MessageAlerts.MessageType.SUCCESS);
        } else {
            MessageAlerts.getInstance().showMessage("Fail!", "Đổi mật khẩu thất bại!",
                    MessageAlerts.MessageType.ERROR);
        }
        tfMatKhau.setText(tk.getMatKhau());
        btnLuuMK.setEnabled(false);
        btnDoiMatKhau.setEnabled(true);
        DisableTextFieldTaiKhoan();
        
    }//GEN-LAST:event_btnLuuMKActionPerformed

    private void btnLuuTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuTTActionPerformed
        String maNV = maNhanVien;
        String hoTen = tfHoTen.getText();
        String ngSinh = tfNgaySinh.getText();
        String gt = tfGioiTinh.getText();
        String cccd = tfCCCD.getText();
        String dc = tfDiaChi.getText();
        String sdt = tfSoDienThoai.getText();
        String chucVu = tfChucVu.getText();
        boolean tinhTrang = true;
        String maCN = cbbMaChiNhanh.getSelectedItem().toString();
        
        if (CheckEmptyInput()) { // Empty Input
            MessageAlerts.getInstance().showMessage("Fail!", "Vui lòng nhập đầy đủ thông tin",
                    MessageAlerts.MessageType.ERROR);
            return;
        }
        
        java.sql.Date date = null;
        try {
            Date d = new SimpleDateFormat("yyyy-MM-dd").parse(ngSinh);
            date = new java.sql.Date(d.getTime());
        } catch (Exception e) {
            MessageAlerts.getInstance().showMessage("Fail!", "Nhập ngày tháng không đúng định dạng yyyy-MM-dd!",
                    MessageAlerts.MessageType.ERROR);
            tfNgaySinh.requestFocus();
            return;
        }
        
        // Check SDT hợp lệ, CCCD hợp lệ
        if(!checkLegalNumberPhone(sdt)){
            MessageAlerts.getInstance().showMessage("Fail!", "Số điện thoại phải đúng 10 ký tự số!",
                    MessageAlerts.MessageType.ERROR);
            tfSoDienThoai.requestFocus();
            return;
        }
        
        // Check Trùng CCCD, sdt ...
        if (!checkLegalCCCD(cccd)){
            MessageAlerts.getInstance().showMessage("Fail!", "CCCD phải đúng 12 ký tự số!",
                    MessageAlerts.MessageType.ERROR);
            tfCCCD.requestFocus();
            return;
        }
        
        
        NhanVien nv = new NhanVien(maNV, hoTen, cccd, date, gt, dc, sdt, chucVu, tinhTrang, maCN, "");
        boolean result = NhanVienService.getInstance().update(nv);
        if (result) {
            MessageAlerts.getInstance().showMessage("Success!", "Cập nhật thông tin thành công!",
                    MessageAlerts.MessageType.SUCCESS);
        } else {
            MessageAlerts.getInstance().showMessage("Fail!", "Cập nhật thất bại!",
                    MessageAlerts.MessageType.ERROR);
        }
        
        DisableTextFieldNhanVien();
        btnLuuTT.setEnabled(false);
        btnCapNhatThongTin.setEnabled(true);
        
    }//GEN-LAST:event_btnLuuTTActionPerformed

    private boolean checkLegalNumberPhone(String phone){
        if (phone.length() != 10){
            return false;
        }
        try {
            long i = (long) Double.parseDouble(phone);
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    private boolean checkLegalCCCD(String CCCD){
        if (CCCD.length() != 12){
            return false;
        }
        try {
            long i = (long) Double.parseDouble(CCCD);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    private boolean CheckEmptyInput() {
        for (Component c : panelRoundNhanVien.getComponents()) {
            if (c instanceof TextField) {
                if (((TextField) c).getText().equals("")) {
                    return true;
                }
            }
        }
        return false;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Views.OtherForm.swing.MyButton btnCapNhatThongTin;
    private Views.OtherForm.swing.MyButton btnDoiMatKhau;
    private Views.OtherForm.swing.MyButton btnLuuMK;
    private Views.OtherForm.swing.MyButton btnLuuTT;
    private Views.OtherForm.component.Combobox.Combobox cbbMaChiNhanh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private Views.OtherForm.swing.PanelRound panelRoundNhanVien;
    private Views.OtherForm.swing.PanelRound panelRoundTaiKhoan;
    private Views.OtherForm.swing.TextField tfCCCD;
    private Views.OtherForm.swing.TextField tfChucVu;
    private Views.OtherForm.swing.TextField tfDiaChi;
    private Views.OtherForm.swing.TextField tfGioiTinh;
    private Views.OtherForm.swing.TextField tfHoTen;
    private Views.OtherForm.swing.TextField tfMatKhau;
    private Views.OtherForm.swing.TextField tfNgaySinh;
    private Views.OtherForm.swing.TextField tfSoDienThoai;
    private Views.OtherForm.swing.TextField tfTenDangNhap;
    // End of variables declaration//GEN-END:variables
}

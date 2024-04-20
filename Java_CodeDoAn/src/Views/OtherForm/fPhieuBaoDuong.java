
package Views.OtherForm;

import Models.ChiNhanh;
import Models.PhieuBaoDuong;
import Services.ChiNhanhService;
import Services.DichVuBaoDuongService;
import Services.KhachHangService;
import Services.NhanVienService;
import Services.PhieuBaoDuongService;
import Views.OtherForm.component.CustomJTable.TableActionCellEditor;
import Views.OtherForm.component.CustomJTable.TableActionCellRender;
import Views.OtherForm.component.CustomJTable.TableActionEvent;
import Views.OtherForm.component.JTable.TableCustom;
import Views.OtherForm.swing.TextField;
import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import raven.alerts.MessageAlerts;
import raven.popup.component.PopupCallbackAction;
import raven.popup.component.PopupController;


public class fPhieuBaoDuong extends javax.swing.JPanel {

    private DefaultTableModel dtm = new DefaultTableModel();
    String strBtn = "";
    
    public fPhieuBaoDuong() {
        initComponents();
        initAll();
    }

    private void initAll() {
        initColumn();
        loadMaBaoDuong();
        loadMaKhachHang();
        loadMaNhanVien();
        loadData();
        DisableTextField();
        DisableButtonSystem();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnAdd = new Views.OtherForm.swing.MyButton();
        btnEdit = new Views.OtherForm.swing.MyButton();
        btnSave = new Views.OtherForm.swing.MyButton();
        btnCancel = new Views.OtherForm.swing.MyButton();
        btnReset = new Views.OtherForm.swing.MyButton();
        tableScrollButton1 = new Views.OtherForm.component.JTable.TableScrollButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuBaoDuong = new javax.swing.JTable();
        panelRound = new Views.OtherForm.swing.PanelRound();
        tfMaPhieuBD = new Views.OtherForm.swing.TextField();
        tfTongTien = new Views.OtherForm.swing.TextField();
        tfNgayLapPhieu = new Views.OtherForm.swing.TextField();
        cbbMaBaoDuong = new Views.OtherForm.component.Combobox.Combobox();
        cbbMaNhanVienThucHien = new Views.OtherForm.component.Combobox.Combobox();
        cbbMaKhachHang = new Views.OtherForm.component.Combobox.Combobox();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ PHIẾU BẢO DƯỠNG");

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/OtherForm/Icon/addmini.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.setBorderColor(new java.awt.Color(51, 153, 255));
        btnAdd.setRadius(20);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/OtherForm/Icon/note.png"))); // NOI18N
        btnEdit.setText("Sửa");
        btnEdit.setBorderColor(new java.awt.Color(51, 153, 255));
        btnEdit.setRadius(20);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/OtherForm/Icon/save.png"))); // NOI18N
        btnSave.setText("Lưu");
        btnSave.setBorderColor(new java.awt.Color(51, 153, 255));
        btnSave.setRadius(20);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/OtherForm/Icon/cancel.png"))); // NOI18N
        btnCancel.setBorderColor(new java.awt.Color(51, 153, 255));
        btnCancel.setLabel("Hủy");
        btnCancel.setRadius(20);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/OtherForm/Icon/undo.png"))); // NOI18N
        btnReset.setBorderColor(new java.awt.Color(51, 153, 255));
        btnReset.setLabel("Nhập lại");
        btnReset.setRadius(20);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        tblPhieuBaoDuong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPhieuBaoDuong.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblPhieuBaoDuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuBaoDuongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhieuBaoDuong);

        tableScrollButton1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelRound.setBackground(new java.awt.Color(255, 255, 255));
        panelRound.setRoundBottomLeft(20);
        panelRound.setRoundBottomRight(20);
        panelRound.setRoundTopLeft(20);
        panelRound.setRoundTopRight(20);

        tfMaPhieuBD.setLabelText("Mã Phiếu Bảo Dưỡng");

        tfTongTien.setLabelText("Tổng Tiền");

        tfNgayLapPhieu.setLabelText("Ngày Lập Phiếu");

        cbbMaBaoDuong.setLabeText("Dịch Vụ Bảo Dưỡng");

        cbbMaNhanVienThucHien.setLabeText("Nhân Viên Thực Hiện");

        cbbMaKhachHang.setLabeText("Khách Hàng");

        javax.swing.GroupLayout panelRoundLayout = new javax.swing.GroupLayout(panelRound);
        panelRound.setLayout(panelRoundLayout);
        panelRoundLayout.setHorizontalGroup(
            panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfMaPhieuBD, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(cbbMaBaoDuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(98, 98, 98)
                .addGroup(panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRoundLayout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(tfNgayLapPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbbMaKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(81, 81, 81)
                .addGroup(panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(cbbMaNhanVienThucHien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );
        panelRoundLayout.setVerticalGroup(
            panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfMaPhieuBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNgayLapPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbMaBaoDuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbMaNhanVienThucHien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(panelRound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(panelRound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(tableScrollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        strBtn = "Add";
        ClearText();
        EnableTextField();
        EnableButtonSystem();
        DisableButtonEditData();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        strBtn = "Edit";
        EnableTextField();
        EnableButtonSystem();
        DisableButtonEditData();
        tfMaPhieuBD.setEditable(false);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String maPBD = tfMaPhieuBD.getText();
        String maBD = cbbMaBaoDuong.getSelectedItem().toString();
        String ngayLap = tfNgayLapPhieu.getText();
        String maKH = cbbMaKhachHang.getSelectedItem().toString();
        String maNV = cbbMaNhanVienThucHien.getSelectedItem().toString();
        
        java.sql.Date date = null;
        try {
            Date d = new SimpleDateFormat("yyyy-MM-dd").parse(ngayLap);
            date = new java.sql.Date(d.getTime());
        } catch (Exception e) {
            MessageAlerts.getInstance().showMessage("Fail!", "Nhập ngày tháng không đúng định dạng yyyy-MM-dd!",
                    MessageAlerts.MessageType.ERROR);
            tfNgayLapPhieu.requestFocus();
            return;
        }
        
        // Kiểm tra số tiền nhập có hợp lệ
        long tongTien = 0;
        try {
            tongTien = (long) Double.parseDouble(tfTongTien.getText());
        } catch (Exception e) {
            MessageAlerts.getInstance().showMessage("Fail!", "Vui lòng nhập giá trị số cho tổng tiền!",
                    MessageAlerts.MessageType.ERROR);
            tfTongTien.requestFocus();
            return;
        }
        
        if (CheckEmptyInput()) { // Empty Input
            MessageAlerts.getInstance().showMessage("Fail!", "Vui lòng nhập đầy đủ thông tin",
                    MessageAlerts.MessageType.ERROR);
            return;
        }
        
        PhieuBaoDuong pbd = new PhieuBaoDuong(maPBD, maBD, date, tongTien, maKH, maNV);
        if (strBtn.equals("Add")) {
            // Kiểm tra Phiếu bảo dưỡng đã tồn tại chưa
            PhieuBaoDuong tmp = PhieuBaoDuongService.getInstance().findOne(maPBD);

            if (tmp != null) { // Already Exist
                MessageAlerts.getInstance().showMessage("Fail!", "Phiếu bảo dưỡng đã tồn tại!",
                        MessageAlerts.MessageType.ERROR);
                return;
            }
            
            boolean res = PhieuBaoDuongService.getInstance().insert(pbd);
            if (res) {
                MessageAlerts.getInstance().showMessage("Success!", "Thêm phiếu bảo dưỡng thành công!",
                        MessageAlerts.MessageType.SUCCESS);
            } else {
                MessageAlerts.getInstance().showMessage("Fail!", "Thêm thất bại!",
                        MessageAlerts.MessageType.ERROR);
            }
            
        } 
        else if (strBtn.equals("Edit")) {
            boolean res = PhieuBaoDuongService.getInstance().update(pbd);
            if (res) {
                MessageAlerts.getInstance().showMessage("Success!", "Cập nhật thành công!",
                        MessageAlerts.MessageType.SUCCESS);
            } else {
                MessageAlerts.getInstance().showMessage("Fail!", "Cập nhật thất bại!",
                        MessageAlerts.MessageType.ERROR);
            }
        }
        ClearText();
        DisableTextField();
        DisableButtonSystem();
        EnableButtonEditData();
        loadData();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        ClearText();
        DisableButtonSystem();
        DisableTextField();
        EnableButtonEditData();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        ClearText();
    }//GEN-LAST:event_btnResetActionPerformed

    private void tblPhieuBaoDuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuBaoDuongMouseClicked
        binding(tblPhieuBaoDuong.getSelectedRow());
    }//GEN-LAST:event_tblPhieuBaoDuongMouseClicked

    private void loadData() {
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
        List<PhieuBaoDuong> list = PhieuBaoDuongService.getInstance().danhSachPhieuBaoDuong();
        for (PhieuBaoDuong o : list) {
            dtm.addRow(new Object[]{
                o.getMaPhieuBaoDuong(), o.getMaBaoDuong(), o.getNgayLapPhieu(), 
                o.getTongTien(), o.getMaKhachHang(), o.getMaNhanVienThucHien()
            });
        }
    }
    
    private void loadMaBaoDuong() {
        List<String> list = DichVuBaoDuongService.getInstance().listMaBaoDuong();
        String[] arr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        ComboBoxModel<String> model = new DefaultComboBoxModel<>(arr);
        cbbMaBaoDuong.setModel(model);
    }
    
    private void loadMaKhachHang() {
        List<String> list = KhachHangService.getInstance().listMaKhachHang();
        String[] arr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        ComboBoxModel<String> model = new DefaultComboBoxModel<>(arr);
        cbbMaKhachHang.setModel(model);
    }

    private void loadMaNhanVien() {
        List<String> list = NhanVienService.getInstance().listMaNhanVien();
        String[] arr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        ComboBoxModel<String> model = new DefaultComboBoxModel<>(arr);
        cbbMaNhanVienThucHien.setModel(model);
    }

    private void initColumn() {
        // Custom Table
        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
        tblPhieuBaoDuong.setModel(dtm);

        dtm.addColumn("Mã Phiếu Bảo Dưỡng");
        dtm.addColumn("Mã Bảo Dưỡng");
        dtm.addColumn("Ngày Lập Phiếu");
        dtm.addColumn("Tổng Tiền");
        dtm.addColumn("Mã Khách Hàng");
        dtm.addColumn("Mã Nhân Viên");
        dtm.addColumn("");

//        tblPhieuBaoDuong.getColumnModel().getColumn(0).setPreferredWidth(40);
//        tblPhieuBaoDuong.getColumnModel().getColumn(1).setPreferredWidth(70);
//        tblPhieuBaoDuong.getColumnModel().getColumn(2).setPreferredWidth(40);
//        tblPhieuBaoDuong.getColumnModel().getColumn(3).setPreferredWidth(70);
//        tblPhieuBaoDuong.getColumnModel().getColumn(4).setPreferredWidth(60);

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onDelete(int row) {
                if (tblPhieuBaoDuong.isEditing()) {
                    tblPhieuBaoDuong.getCellEditor().stopCellEditing();
                }
                MessageAlerts.getInstance().showMessage("Cảnh báo", "Bạn có muốn xóa phiếu bảo dưỡng này khỏi hệ thống?",
                        MessageAlerts.MessageType.ERROR, MessageAlerts.YES_NO_OPTION, new PopupCallbackAction() {
                    @Override
                    public void action(PopupController pc, int i) {
                        if (i == MessageAlerts.YES_OPTION) {
                            String maPBD = tfMaPhieuBD.getText();
                            boolean res = PhieuBaoDuongService.getInstance().delete(maPBD);
                            if (res) {
                                MessageAlerts.getInstance().showMessage("Success!", "Xóa thành công!",
                                        MessageAlerts.MessageType.SUCCESS);
                            } else {
                                MessageAlerts.getInstance().showMessage("Fail!", "Xóa thất bại!",
                                        MessageAlerts.MessageType.ERROR);
                            }
                        }
                        ClearText();
                        loadData();
                    }
                });
            }
        };
        tblPhieuBaoDuong.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
        tblPhieuBaoDuong.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(event));
    }

    // Method Binding Data
    private void binding(int idx) {
        tfMaPhieuBD.setText(tblPhieuBaoDuong.getValueAt(idx, 0).toString());
        cbbMaBaoDuong.setSelectedItem(tblPhieuBaoDuong.getValueAt(idx, 1).toString());
        tfNgayLapPhieu.setText(tblPhieuBaoDuong.getValueAt(idx, 2).toString());
        tfTongTien.setText(tblPhieuBaoDuong.getValueAt(idx, 3).toString());
        cbbMaKhachHang.setSelectedItem(tblPhieuBaoDuong.getValueAt(idx, 4).toString());
        cbbMaNhanVienThucHien.setSelectedItem(tblPhieuBaoDuong.getValueAt(idx, 5).toString());
    }

    private boolean CheckEmptyInput() {
        for (Component c : panelRound.getComponents()) {
            if (c instanceof TextField) {
                if (((TextField) c).getText().equals("")) {
                    return true;
                }
            }
        }
        return false;
    }

    private void ClearText() {
        for (Component c : panelRound.getComponents()) {
            if (c instanceof TextField) {
                ((TextField) c).setText("");
            }
        }
    }

    private void EnableTextField() {
        for (Component c : panelRound.getComponents()) {
            if (c instanceof TextField textField) {
                textField.setEditable(true);
            }
        }
    }

    private void DisableTextField() {
        for (Component c : panelRound.getComponents()) {
            if (c instanceof TextField textField) {
                textField.setEditable(false);
                textField.setBackground(Color.WHITE);
            }
        }
    }
    

    private void EnableButtonEditData() {
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(true);
    }

    private void DisableButtonEditData() {
        btnAdd.setEnabled(false);
        btnEdit.setEnabled(false);
        ImageIcon iconAdd = new ImageIcon(getClass().getResource("/Views/OtherForm/Icon/addmini.png"));
        btnAdd.setDisabledIcon(iconAdd);
        ImageIcon iconEdit = new ImageIcon(getClass().getResource("/Views/OtherForm/Icon/note.png"));
        btnEdit.setDisabledIcon(iconEdit);
    }

    private void EnableButtonSystem() {
        btnSave.setEnabled(true);
        btnCancel.setEnabled(true);
        btnReset.setEnabled(true);

    }

    private void DisableButtonSystem() {
        btnSave.setEnabled(false);
        btnCancel.setEnabled(false);
        btnReset.setEnabled(false);
        ImageIcon iconSave = new ImageIcon(getClass().getResource("/Views/OtherForm/Icon/save.png"));
        btnSave.setDisabledIcon(iconSave);
        ImageIcon iconCancel = new ImageIcon(getClass().getResource("/Views/OtherForm/Icon/cancel.png"));
        btnCancel.setDisabledIcon(iconCancel);
        ImageIcon iconReset = new ImageIcon(getClass().getResource("/Views/OtherForm/Icon/undo.png"));
        btnReset.setDisabledIcon(iconReset);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Views.OtherForm.swing.MyButton btnAdd;
    private Views.OtherForm.swing.MyButton btnCancel;
    private Views.OtherForm.swing.MyButton btnEdit;
    private Views.OtherForm.swing.MyButton btnReset;
    private Views.OtherForm.swing.MyButton btnSave;
    private Views.OtherForm.component.Combobox.Combobox cbbMaBaoDuong;
    private Views.OtherForm.component.Combobox.Combobox cbbMaKhachHang;
    private Views.OtherForm.component.Combobox.Combobox cbbMaNhanVienThucHien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private Views.OtherForm.swing.PanelRound panelRound;
    private Views.OtherForm.component.JTable.TableScrollButton tableScrollButton1;
    private javax.swing.JTable tblPhieuBaoDuong;
    private Views.OtherForm.swing.TextField tfMaPhieuBD;
    private Views.OtherForm.swing.TextField tfNgayLapPhieu;
    private Views.OtherForm.swing.TextField tfTongTien;
    // End of variables declaration//GEN-END:variables
}


package Views.OtherForm;

import Models.PhieuBaoDuong;
import Models.PhieuNhap;
import Services.ChiNhanhService;
import Services.DichVuBaoDuongService;
import Services.KhachHangService;
import Services.NhaCungCapService;
import Services.NhanVienService;
import Services.PhieuBaoDuongService;
import Services.PhieuNhapService;
import Services.XeService;
import Views.OtherForm.component.CustomJTable.TableActionCellEditor;
import Views.OtherForm.component.CustomJTable.TableActionCellRender;
import Views.OtherForm.component.CustomJTable.TableActionEvent;
import Views.OtherForm.component.JTable.TableCustom;
import Views.OtherForm.swing.TextField;
import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
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


public class fPhieuNhap extends javax.swing.JPanel {

    private DefaultTableModel dtm = new DefaultTableModel();
    String strBtn = "";
    
    public fPhieuNhap() {
        initComponents();
        initAll();
    }

    private void initAll() {
        initColumn();
        loadData();
        loadMaXe();
        loadMaNhaCungCap();
        loadMaChiNhanh();
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
        tblPhieuNhap = new javax.swing.JTable();
        panelRound = new Views.OtherForm.swing.PanelRound();
        tfMaPhieuNhap = new Views.OtherForm.swing.TextField();
        tfGiaNhap = new Views.OtherForm.swing.TextField();
        tfNgayNhap = new Views.OtherForm.swing.TextField();
        cbbMaNhaCungCap = new Views.OtherForm.component.Combobox.Combobox();
        cbbMaChiNhanh = new Views.OtherForm.component.Combobox.Combobox();
        cbbMaXe = new Views.OtherForm.component.Combobox.Combobox();
        tfSoLuong = new Views.OtherForm.swing.TextField();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ PHIẾU NHẬP Ô TÔ");

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

        tblPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPhieuNhap.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuNhapMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhieuNhap);

        tableScrollButton1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelRound.setBackground(new java.awt.Color(255, 255, 255));
        panelRound.setRoundBottomLeft(20);
        panelRound.setRoundBottomRight(20);
        panelRound.setRoundTopLeft(20);
        panelRound.setRoundTopRight(20);

        tfMaPhieuNhap.setLabelText("Mã Phiếu Nhập");

        tfGiaNhap.setLabelText("Giá Nhập");

        tfNgayNhap.setLabelText("Ngày Nhập");

        cbbMaNhaCungCap.setLabeText("Mã Nhà Cung Cấp");

        cbbMaChiNhanh.setLabeText("Chi Nhánh");

        cbbMaXe.setLabeText("Mã Ô Tô");

        tfSoLuong.setLabelText("Số Lượng");

        javax.swing.GroupLayout panelRoundLayout = new javax.swing.GroupLayout(panelRound);
        panelRound.setLayout(panelRoundLayout);
        panelRoundLayout.setHorizontalGroup(
            panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfMaPhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(cbbMaNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbbMaXe, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRoundLayout.createSequentialGroup()
                        .addComponent(tfNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59)
                .addGroup(panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfGiaNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(cbbMaChiNhanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );
        panelRoundLayout.setVerticalGroup(
            panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfMaPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbMaNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbMaChiNhanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbMaXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        tfMaPhieuNhap.setEditable(false);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String maPN = tfMaPhieuNhap.getText();
        String maXe = cbbMaXe.getSelectedItem().toString();
        String ngayNhap = tfNgayNhap.getText();
        String maNCC = cbbMaNhaCungCap.getSelectedItem().toString();
        String maCN = cbbMaChiNhanh.getSelectedItem().toString();
        
        long giaNhap = 0;
        try {
            giaNhap = (long) Double.parseDouble(tfGiaNhap.getText());
        } catch (NumberFormatException e) {
            MessageAlerts.getInstance().showMessage("Fail!", "Vui lòng nhập giá trị số cho Giá nhập",
                    MessageAlerts.MessageType.ERROR);
            return;
        }
        
        int soLuong = 0;
        try {
            soLuong = Integer.parseInt(tfSoLuong.getText());
        } catch (NumberFormatException e) {
            MessageAlerts.getInstance().showMessage("Fail!", "Vui lòng nhập giá trị số Số lượng",
                    MessageAlerts.MessageType.ERROR);
            return;
        }

        if (CheckEmptyInput()) { // Empty Input
            MessageAlerts.getInstance().showMessage("Fail!", "Vui lòng nhập đầy đủ thông tin",
                    MessageAlerts.MessageType.ERROR);
            return;
        }
        
        java.sql.Date date = null;
        try {
            Date d = new SimpleDateFormat("yyyy-MM-dd").parse(ngayNhap);
            date = new java.sql.Date(d.getTime());
        } catch (ParseException e) {
            MessageAlerts.getInstance().showMessage("Fail!", "Nhập ngày tháng không đúng định dạng yyyy-MM-dd!",
                    MessageAlerts.MessageType.ERROR);
            tfNgayNhap.requestFocus();
            return;
        }
        
        PhieuNhap pn = new PhieuNhap(maPN, maXe, date, giaNhap, soLuong, maNCC, maCN);
        if (strBtn.equals("Add")) { // Add
            PhieuNhap tmp = PhieuNhapService.getInstance().findOne(maPN);
            if (tmp != null) { // Already Exist ChiNhanh
                MessageAlerts.getInstance().showMessage("Fail!", "Phiếu nhập đã tồn tại!",
                        MessageAlerts.MessageType.ERROR);
                return;
            }
            boolean result = PhieuNhapService.getInstance().insert(pn);
            if (result) {
                MessageAlerts.getInstance().showMessage("Success!", "Thêm phiếu nhập mới thành công!",
                        MessageAlerts.MessageType.SUCCESS);
            } else {
                MessageAlerts.getInstance().showMessage("Fail!", "Thêm thất bại!",
                        MessageAlerts.MessageType.ERROR);
            }
            
        } else if (strBtn.equals("Edit")) {
            boolean result = PhieuNhapService.getInstance().update(pn);
            if (result) {
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

    private void tblPhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuNhapMouseClicked
        binding(tblPhieuNhap.getSelectedRow());
    }//GEN-LAST:event_tblPhieuNhapMouseClicked

    private void loadData() {
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }

        List<PhieuNhap> list = PhieuNhapService.getInstance().danhSachPhieuNhap();
        for (PhieuNhap o : list){
            dtm.addRow(new Object[]{
                o.getMaPhieuNhap(), o.getMaXe(), o.getNgayNhap(), o.getGiaNhap(), 
                o.getSoLuong(), o.getMaNhaCungCap(), o.getMaChiNhanh()
            });
        }
    }
    
    private void loadMaXe() {
        List<String> list = XeService.getInstance().listMaXe();
        String[] arr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        ComboBoxModel<String> model = new DefaultComboBoxModel<>(arr);
        cbbMaXe.setModel(model);
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
    
    private void loadMaNhaCungCap(){
        List<String> list = NhaCungCapService.getInstance().listMaNhaCungCap();
        String[] arr = new String[list.size()];
        for (int i=0; i<list.size(); i++){
            arr[i] = list.get(i);
        }
        ComboBoxModel<String> model = new DefaultComboBoxModel<>(arr);
        cbbMaNhaCungCap.setModel(model);
    }

    private void initColumn() {
        // Custom Table
        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);

        tblPhieuNhap.setModel(dtm);

        dtm.addColumn("Mã Phiếu Nhập");
        dtm.addColumn("Mã Xe");
        dtm.addColumn("Ngày Lập Phiếu");
        dtm.addColumn("Giá Nhập");
        dtm.addColumn("Số Lượng");
        dtm.addColumn("Mã Nhà Cung Cấp");
        dtm.addColumn("Mã Chi Nhánh");
        dtm.addColumn("");

//        tblPhieuNhap.getColumnModel().getColumn(0).setPreferredWidth(30);
//        tblPhieuNhap.getColumnModel().getColumn(1).setPreferredWidth(70);
//        tblPhieuNhap.getColumnModel().getColumn(2).setPreferredWidth(150);
//        tblPhieuNhap.getColumnModel().getColumn(3).setPreferredWidth(30);
//        tblPhieuNhap.getColumnModel().getColumn(4).setPreferredWidth(10);

        // Add event delete
        TableActionEvent event = new TableActionEvent() {
            public void onDelete(int row) {
                if (tblPhieuNhap.isEditing()) {
                    tblPhieuNhap.getCellEditor().stopCellEditing();
                }
                MessageAlerts.getInstance().showMessage("Cảnh báo", "Bạn có thật sự muốn xóa phiếu nhập này không?",
                        MessageAlerts.MessageType.ERROR, MessageAlerts.YES_NO_OPTION, new PopupCallbackAction() {
                    @Override
                    public void action(PopupController pc, int i) {
                        if (i == MessageAlerts.YES_OPTION) {
                            String maPN = tfMaPhieuNhap.getText();
                            boolean res = PhieuNhapService.getInstance().delete(maPN);
                            if (res){
                                MessageAlerts.getInstance().showMessage("Success!", "Xóa thành công!",
                                MessageAlerts.MessageType.SUCCESS);
                            }
                            else{
                                MessageAlerts.getInstance().showMessage("Fail!", "Xóa thất bại!",
                                MessageAlerts.MessageType.ERROR);
                            }
                        }
                        loadData();
                        ClearText();
                    }
                });
            }
        };

        tblPhieuNhap.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRender());
        tblPhieuNhap.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditor(event));

    }

    // Method Binding Data
    private void binding(int idx) {
        tfMaPhieuNhap.setText(tblPhieuNhap.getValueAt(idx, 0).toString());
        cbbMaXe.setSelectedItem(tblPhieuNhap.getValueAt(idx, 1).toString());
        tfNgayNhap.setText(tblPhieuNhap.getValueAt(idx, 2).toString());
        tfGiaNhap.setText(tblPhieuNhap.getValueAt(idx,3).toString());
        tfSoLuong.setText(tblPhieuNhap.getValueAt(idx,4).toString());
        cbbMaNhaCungCap.setSelectedItem(tblPhieuNhap.getValueAt(idx, 5).toString());
        cbbMaChiNhanh.setSelectedItem(tblPhieuNhap.getValueAt(idx, 6).toString());
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
    private Views.OtherForm.component.Combobox.Combobox cbbMaChiNhanh;
    private Views.OtherForm.component.Combobox.Combobox cbbMaNhaCungCap;
    private Views.OtherForm.component.Combobox.Combobox cbbMaXe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private Views.OtherForm.swing.PanelRound panelRound;
    private Views.OtherForm.component.JTable.TableScrollButton tableScrollButton1;
    private javax.swing.JTable tblPhieuNhap;
    private Views.OtherForm.swing.TextField tfGiaNhap;
    private Views.OtherForm.swing.TextField tfMaPhieuNhap;
    private Views.OtherForm.swing.TextField tfNgayNhap;
    private Views.OtherForm.swing.TextField tfSoLuong;
    // End of variables declaration//GEN-END:variables
}

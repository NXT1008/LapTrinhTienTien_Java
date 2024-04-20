
package Views.OtherForm;

import Models.ChiNhanh;
import Models.NhaCungCap;
import Services.ChiNhanhService;
import Services.NhaCungCapService;
import Views.OtherForm.component.CustomJTable.TableActionCellEditor;
import Views.OtherForm.component.CustomJTable.TableActionCellRender;
import Views.OtherForm.component.CustomJTable.TableActionEvent;
import Views.OtherForm.component.JTable.TableCustom;
import Views.OtherForm.swing.TextField;
import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import raven.alerts.MessageAlerts;
import raven.popup.component.PopupCallbackAction;
import raven.popup.component.PopupController;


public class fNhaCungCap extends javax.swing.JPanel {

    private DefaultTableModel dtm = new DefaultTableModel();
    String strBtn = "";
    
    public fNhaCungCap() {
        initComponents();
        initAll();
    }

    private void initAll() {
        initColumn();
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
        tblNhaCungCap = new javax.swing.JTable();
        panelRound = new Views.OtherForm.swing.PanelRound();
        tfMaNhaCungCap = new Views.OtherForm.swing.TextField();
        tfSoDienThoai = new Views.OtherForm.swing.TextField();
        tfTenNhaCungCap = new Views.OtherForm.swing.TextField();
        tfDiaChi = new Views.OtherForm.swing.TextField();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NHÀ CUNG CẤP Ô TÔ");

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

        tblNhaCungCap.setModel(new javax.swing.table.DefaultTableModel(
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
        tblNhaCungCap.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblNhaCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhaCungCapMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhaCungCap);

        tableScrollButton1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelRound.setBackground(new java.awt.Color(255, 255, 255));
        panelRound.setRoundBottomLeft(20);
        panelRound.setRoundBottomRight(20);
        panelRound.setRoundTopLeft(20);
        panelRound.setRoundTopRight(20);

        tfMaNhaCungCap.setLabelText("Mã Nhà Cung Cấp");

        tfSoDienThoai.setLabelText("Số Điện Thoại");

        tfTenNhaCungCap.setLabelText("Tên Nhà Cung Cấp");

        tfDiaChi.setLabelText("Địa Chỉ");

        javax.swing.GroupLayout panelRoundLayout = new javax.swing.GroupLayout(panelRound);
        panelRound.setLayout(panelRoundLayout);
        panelRoundLayout.setHorizontalGroup(
            panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfMaNhaCungCap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSoDienThoai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTenNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRoundLayout.setVerticalGroup(
            panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfMaNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTenNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
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
                        .addContainerGap(77, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelRound, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 74, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(panelRound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
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
        tfMaNhaCungCap.setEditable(false);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String maNCC = tfMaNhaCungCap.getText();
        String tenNCC = tfTenNhaCungCap.getText();
        String soDT = tfSoDienThoai.getText();
        String dchi = tfDiaChi.getText();

        if (CheckEmptyInput()) { // Empty Input
            MessageAlerts.getInstance().showMessage("Fail!", "Vui lòng nhập đầy đủ thông tin",
                    MessageAlerts.MessageType.ERROR);
            return;
        }
        
        NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC, dchi, soDT);
        if (strBtn.equals("Add")) { // Add
            NhaCungCap tmp = NhaCungCapService.getInstance().findOne(maNCC);
            if (tmp != null) { // Already Exist ChiNhanh
                MessageAlerts.getInstance().showMessage("Fail!", "Nhà cung cấp đã tồn tại!",
                        MessageAlerts.MessageType.ERROR);
                return;
            }
            
            boolean result = NhaCungCapService.getInstance().insert(ncc);
            if (result) {
                MessageAlerts.getInstance().showMessage("Success!", "Thêm nhà cung cấp mới thành công!",
                        MessageAlerts.MessageType.SUCCESS);
            } else {
                MessageAlerts.getInstance().showMessage("Fail!", "Thêm thất bại!",
                        MessageAlerts.MessageType.ERROR);
            }
            
        } else if (strBtn.equals("Edit")) {
            boolean result = NhaCungCapService.getInstance().update(ncc);
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

    private void tblNhaCungCapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhaCungCapMouseClicked
        binding(tblNhaCungCap.getSelectedRow());
    }//GEN-LAST:event_tblNhaCungCapMouseClicked

    private void loadData() {
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }

        List<NhaCungCap> list = NhaCungCapService.getInstance().danhSachNhaCungCap();
        for (NhaCungCap o : list) {
            dtm.addRow(new Object[]{
                o.getMaNhaCungCap(), o.getTenNhaCungCap(), o.getDiaChi(), o.getSoDienThoai()
            });
        }
    }

    private void initColumn() {
        // Custom Table
        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);

        tblNhaCungCap.setModel(dtm);

        dtm.addColumn("Mã Nhà Cung Cấp");
        dtm.addColumn("Tên Nhà Cung Cấp");
        dtm.addColumn("Địa Chỉ");
        dtm.addColumn("Số Điện Thoại");
        dtm.addColumn("");

        tblNhaCungCap.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblNhaCungCap.getColumnModel().getColumn(1).setPreferredWidth(70);
        tblNhaCungCap.getColumnModel().getColumn(2).setPreferredWidth(150);
        tblNhaCungCap.getColumnModel().getColumn(3).setPreferredWidth(30);
        tblNhaCungCap.getColumnModel().getColumn(4).setPreferredWidth(10);

        // Add event delete
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onDelete(int row) {
                if (tblNhaCungCap.isEditing()) {
                    tblNhaCungCap.getCellEditor().stopCellEditing();
                }
                MessageAlerts.getInstance().showMessage("Cảnh báo", "Bạn có thật sự muốn xóa nhà cung cấp này không?",
                        MessageAlerts.MessageType.ERROR, MessageAlerts.YES_NO_OPTION, new PopupCallbackAction() {
                    @Override
                    public void action(PopupController pc, int i) {
                        if (i == MessageAlerts.YES_OPTION) {
                            String maNCC = tfMaNhaCungCap.getText();
                            boolean res = NhaCungCapService.getInstance().delete(maNCC);
                            if (res) {
                                MessageAlerts.getInstance().showMessage("Success!", "Xóa thành công!",
                                        MessageAlerts.MessageType.SUCCESS);
                            } else {
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

        tblNhaCungCap.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
        tblNhaCungCap.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
    }

    // Method Binding Data
    private void binding(int idx) {
        tfMaNhaCungCap.setText(tblNhaCungCap.getValueAt(idx, 0).toString());
        tfTenNhaCungCap.setText(tblNhaCungCap.getValueAt(idx, 1).toString());
        tfDiaChi.setText(tblNhaCungCap.getValueAt(idx, 2).toString());
        tfSoDienThoai.setText(tblNhaCungCap.getValueAt(idx, 3).toString());
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private Views.OtherForm.swing.PanelRound panelRound;
    private Views.OtherForm.component.JTable.TableScrollButton tableScrollButton1;
    private javax.swing.JTable tblNhaCungCap;
    private Views.OtherForm.swing.TextField tfDiaChi;
    private Views.OtherForm.swing.TextField tfMaNhaCungCap;
    private Views.OtherForm.swing.TextField tfSoDienThoai;
    private Views.OtherForm.swing.TextField tfTenNhaCungCap;
    // End of variables declaration//GEN-END:variables
}

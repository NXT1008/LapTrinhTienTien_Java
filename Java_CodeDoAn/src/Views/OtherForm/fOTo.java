
package Views.OtherForm;

import DAO.ImageUtils;
import Models.Xe;
import Services.XeService;
import Views.OtherForm.component.CustomJTable.TableActionCellEditor;
import Views.OtherForm.component.CustomJTable.TableActionCellRender;
import Views.OtherForm.component.CustomJTable.TableActionEvent;
import Views.OtherForm.component.JTable.TableCustom;
import Views.OtherForm.swing.TextField;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import raven.alerts.MessageAlerts;
import raven.popup.component.PopupCallbackAction;
import raven.popup.component.PopupController;


public class fOTo extends javax.swing.JPanel {

    private DefaultTableModel dtm = new DefaultTableModel();
    String strBtn = "";
    
    public fOTo() {
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
        tblOTo = new javax.swing.JTable();
        panelRound = new Views.OtherForm.swing.PanelRound();
        tfMaXe = new Views.OtherForm.swing.TextField();
        tfGiaBan = new Views.OtherForm.swing.TextField();
        tfCongSuatDongCo = new Views.OtherForm.swing.TextField();
        tfTrongLuong = new Views.OtherForm.swing.TextField();
        tfTenXe = new Views.OtherForm.swing.TextField();
        tfXuatXu = new Views.OtherForm.swing.TextField();
        tfHangXe = new Views.OtherForm.swing.TextField();
        tfLoaiDongCo = new Views.OtherForm.swing.TextField();
        btnChooseFile = new Views.OtherForm.swing.MyButton();
        picHinhAnh = new Views.OtherForm.swing.PictureBox();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ Ô TÔ");

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

        tblOTo.setModel(new javax.swing.table.DefaultTableModel(
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
        tblOTo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblOTo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOToMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblOTo);

        tableScrollButton1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelRound.setBackground(new java.awt.Color(255, 255, 255));
        panelRound.setRoundBottomLeft(20);
        panelRound.setRoundBottomRight(20);
        panelRound.setRoundTopLeft(20);
        panelRound.setRoundTopRight(20);

        tfMaXe.setLabelText("Mã Ô Tô");

        tfGiaBan.setLabelText("Giá Bán");

        tfCongSuatDongCo.setLabelText("Công Suất");

        tfTrongLuong.setLabelText("Trọng Lượng");

        tfTenXe.setLabelText("Tên Oto");

        tfXuatXu.setLabelText("Xuất Xứ");

        tfHangXe.setLabelText("Tên Hãng");

        tfLoaiDongCo.setLabelText("Loại Động Cơ");

        btnChooseFile.setText("...");
        btnChooseFile.setBorderColor(new java.awt.Color(255, 255, 255));
        btnChooseFile.setColor(new java.awt.Color(153, 204, 255));
        btnChooseFile.setRadius(5);
        btnChooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRoundLayout = new javax.swing.GroupLayout(panelRound);
        panelRound.setLayout(panelRoundLayout);
        panelRoundLayout.setHorizontalGroup(
            panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfMaXe, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfTenXe, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(tfTrongLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(picHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfXuatXu, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(tfHangXe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCongSuatDongCo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfLoaiDongCo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
            .addGroup(panelRoundLayout.createSequentialGroup()
                .addGap(393, 393, 393)
                .addComponent(btnChooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRoundLayout.setVerticalGroup(
            panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfMaXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCongSuatDongCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTenXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTrongLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfHangXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfLoaiDongCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 37, Short.MAX_VALUE))
            .addGroup(panelRoundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelRound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(panelRound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
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
        picHinhAnh.setImage(null);
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
        tfMaXe.setEditable(false);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String maXe = tfMaXe.getText();
        String tenXe = tfTenXe.getText();
        String xuatXu = tfXuatXu.getText();
        String tenHang = tfHangXe.getText();
        String dongCo = tfLoaiDongCo.getText();

        // Kiểm tra nhập
        if (CheckEmptyInput()) { // Empty Input
            MessageAlerts.getInstance().showMessage("Fail!", "Vui lòng nhập đầy đủ thông tin",
                    MessageAlerts.MessageType.ERROR);
            return;
        }
        
        // Check Valid Number Input
        long giaBan = 0;
        try {
            giaBan = (long)Double.parseDouble(tfGiaBan.getText());
        } catch (NumberFormatException e) {
            MessageAlerts.getInstance().showMessage("Fail!", "Giá bán phải là giá trị tiền tệ!",
                    MessageAlerts.MessageType.ERROR);
            return;
        }
        
        int trongLuong = 0;
        try {
            trongLuong = Integer.parseInt(tfTrongLuong.getText());
            if (trongLuong <= 0){
                MessageAlerts.getInstance().showMessage("Fail!", "Trọng lượng ô tô phải là số nguyên dương!",
                    MessageAlerts.MessageType.ERROR);
                return;
            }
        } catch (NumberFormatException e) {
            MessageAlerts.getInstance().showMessage("Fail!", "Trọng lượng ô tô phải là số nguyên dương!",
                    MessageAlerts.MessageType.ERROR);
            return;
        }
        
        int congSuat = 0;
        try {
            congSuat = Integer.parseInt(tfCongSuatDongCo.getText());
            if (congSuat <= 0){
                MessageAlerts.getInstance().showMessage("Fail!", "Công suất ô tô phải là số nguyên dương!",
                    MessageAlerts.MessageType.ERROR);
            return;
            }
        } catch (NumberFormatException e) {
            MessageAlerts.getInstance().showMessage("Fail!", "Công suất ô tô phải là số nguyên dương!",
                    MessageAlerts.MessageType.ERROR);
            return;
        }
        
        byte[] hinhAnh = null;
        try {
            Icon icon = picHinhAnh.getImage();
            if (icon instanceof ImageIcon) {
                hinhAnh = ImageUtils.imageToByteArray((ImageIcon) icon);
            }
        } catch (Exception e) {
        }
        
        
        Xe xe = new Xe(maXe, tenXe, giaBan, xuatXu, tenHang, trongLuong, congSuat, dongCo, hinhAnh);
        if (strBtn.equals("Add")) {
            // Kiểm tra khách hàng đã tồn tại chưa
            Xe tmp = XeService.getInstance().findOne(maXe);

            if (tmp != null) { // Nếu đã tồn tại
                MessageAlerts.getInstance().showMessage("Fail!", "Mã ô tô đã tồn tại!",
                        MessageAlerts.MessageType.ERROR);
                return;
            }
            
            // Chưa tồn tại thì insert
            boolean res = XeService.getInstance().insert(xe);
            if (res) {
                MessageAlerts.getInstance().showMessage("Success!", "Thêm ô tô mới thành công!",
                        MessageAlerts.MessageType.SUCCESS);
            } else {
                MessageAlerts.getInstance().showMessage("Fail!", "Thêm thất bại!",
                        MessageAlerts.MessageType.ERROR);
            }

        } else if (strBtn.equals("Edit")) {
            Xe xe_update = XeService.getInstance().findOne(maXe); // Giữ lại các trường dữ liệu cũ
            xe_update.setTenXe(tenXe);
            xe_update.setGiaBan(giaBan);
            xe_update.setXuatXu(xuatXu);
            xe_update.setHangXe(tenHang);
            xe_update.setTrongLuong(trongLuong);
            xe_update.setCongSuatDongCo(congSuat);
            xe_update.setLoaiDongCo(dongCo);
            xe_update.setHinhAnh(hinhAnh);
            boolean res = XeService.getInstance().update(xe_update);
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

    private void tblOToMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOToMouseClicked
        binding(tblOTo.getSelectedRow());
    }//GEN-LAST:event_tblOToMouseClicked

    private void btnChooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseFileActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
//            try{
//                BufferedImage b = ImageIO.read(selectedFile);
//                
//                int x = picHinhAnh.getSize().width;
//                int y = picHinhAnh.getSize().height;
//                int ix = b.getWidth();
//                int iy = b.getHeight();
//                int dx = 0, dy = 0;
//                if (x / y > ix / iy){
//                    dy = y;
//                    dx = dy * ix / iy;
//                }
//                else{
//                    dx = x;
//                    dy = dx * iy / ix;
//                }
//                ImageIcon icon = new ImageIcon(b.getScaledInstance(dx, dy, BufferedImage.SCALE_SMOOTH));
//                
//                picHinhAnh.setImage(icon);
//                picHinhAnh.repaint();
//            }
            try {
                BufferedImage b = ImageIO.read(selectedFile);
                ImageIcon icon = new ImageIcon(b.getScaledInstance(-1, -1, BufferedImage.SCALE_SMOOTH));
                picHinhAnh.setImage(icon);
                picHinhAnh.setBackground(Color.WHITE);
                picHinhAnh.repaint();
                picHinhAnh.setBackground(Color.WHITE);
            }
            catch(Exception e){
                
            }
        }
        
    }//GEN-LAST:event_btnChooseFileActionPerformed

    private void loadData() {
        while (dtm.getRowCount() > 0){
            dtm.removeRow(0);
        }
        
        List<Xe> list = XeService.getInstance().danhSachXe();
        for (Xe o : list) {
            dtm.addRow(new Object[]{
                o.getMaXe(), o.getTenXe(), o.getGiaBan(), o.getXuatXu(), o.getHangXe(),
                o.getTrongLuong(), o.getCongSuatDongCo(), o.getLoaiDongCo(), o.getHinhAnh()
            });
        }
    }

    private void initColumn() {
        // Custom Table
        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
        tblOTo.setModel(dtm);

        dtm.addColumn("Mã OTo");
        dtm.addColumn("Tên OTo");
        dtm.addColumn("Giá");
        dtm.addColumn("Xuất Xứ");
        dtm.addColumn("Tên Hãng");
        dtm.addColumn("Trọng Lượng");
        dtm.addColumn("Công Suất");
        dtm.addColumn("Động Cơ");
        dtm.addColumn("Hình Ảnh");
        dtm.addColumn("");

        tblOTo.getColumnModel().getColumn(0).setPreferredWidth(40);
        tblOTo.getColumnModel().getColumn(1).setPreferredWidth(60);
        tblOTo.getColumnModel().getColumn(2).setPreferredWidth(30);
        tblOTo.getColumnModel().getColumn(3).setPreferredWidth(20);
        tblOTo.getColumnModel().getColumn(4).setPreferredWidth(50);
        tblOTo.getColumnModel().getColumn(5).setPreferredWidth(40);
        tblOTo.getColumnModel().getColumn(6).setPreferredWidth(35);
        tblOTo.getColumnModel().getColumn(7).setPreferredWidth(40);
        tblOTo.getColumnModel().getColumn(8).setPreferredWidth(30);
        tblOTo.getColumnModel().getColumn(9).setPreferredWidth(10);

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onDelete(int row) {
                if (tblOTo.isEditing()) {
                    tblOTo.getCellEditor().stopCellEditing();
                }
                MessageAlerts.getInstance().showMessage("Cảnh báo", "Bạn có muốn xóa ô tô này khỏi hệ thống?",
                        MessageAlerts.MessageType.ERROR, MessageAlerts.YES_NO_OPTION, new PopupCallbackAction() {
                    @Override
                    public void action(PopupController pc, int i) {
                        if (i == MessageAlerts.YES_OPTION) {
                            String maXe = tfMaXe.getText();
                            boolean res = XeService.getInstance().delete(maXe);
                            if (res){
                                MessageAlerts.getInstance().showMessage("Success!", "Xóa ô tô thành công!",
                                MessageAlerts.MessageType.SUCCESS);
                            }
                            else{
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
        tblOTo.getColumnModel().getColumn(9).setCellRenderer(new TableActionCellRender());
        tblOTo.getColumnModel().getColumn(9).setCellEditor(new TableActionCellEditor(event));
    }

    // Method Binding Data
    private void binding(int idx) {
        String maXe = dtm.getValueAt(idx, 0).toString();
        String tenXe = dtm.getValueAt(idx, 1).toString();
        long giaBan = (long)Double.parseDouble(dtm.getValueAt(idx, 2).toString());
        String xuatXu = dtm.getValueAt(idx, 3).toString();
        String tenHang = dtm.getValueAt(idx, 4).toString();
        int trongLuong = Integer.parseInt(dtm.getValueAt(idx, 5).toString());
        int congSuat = Integer.parseInt(dtm.getValueAt(idx, 6).toString());
        String dongCo = dtm.getValueAt(idx, 7).toString();
        byte[] hinhAnh = null;
        
        Object hinhAnhObject = dtm.getValueAt(idx, 8); // Lấy dữ liệu từ ô trong JTable
        if (hinhAnhObject instanceof byte[] bs) { // Kiểm tra xem dữ liệu có phải là mảng byte không
            hinhAnh = bs; // Ép kiểu sang mảng byte
        }
        
        tfMaXe.setText(maXe);
        tfTenXe.setText(tenXe);
        tfGiaBan.setText(String.valueOf(giaBan));
        tfXuatXu.setText(xuatXu);
        tfHangXe.setText(tenHang);
        tfTrongLuong.setText(String.valueOf(trongLuong));
        tfCongSuatDongCo.setText(String.valueOf(congSuat));
        tfLoaiDongCo.setText(dongCo);
        
        if (hinhAnh != null) {
            try {
                // Chuyển đổi mảng byte thành Image
                ByteArrayInputStream bis = new ByteArrayInputStream(hinhAnh);
                Image image = ImageIO.read(bis);
                if (image == null){
                    picHinhAnh.setImage(null); // Xóa bỏ hình ảnh hiện tại nếu có
                    picHinhAnh.setBackground(Color.WHITE);
                    picHinhAnh.repaint();
                    picHinhAnh.setBackground(Color.WHITE);
                }

                else{
                    // Chuyển đổi Image thành ImageIcon
                    ImageIcon icon = new ImageIcon(image);

                    // Đặt ImageIcon vào JLabel để hiển thị hình ảnh
                    picHinhAnh.setImage(icon);
                    picHinhAnh.setBackground(Color.WHITE);
                    picHinhAnh.repaint();
                    picHinhAnh.setBackground(Color.WHITE);
                }
            } catch (IOException ex) {
            }
        } else {
            // Nếu không có dữ liệu hình ảnh, có thể hiển thị một hình ảnh mặc định hoặc làm gì đó khác
            picHinhAnh.setImage(null); // Xóa bỏ hình ảnh hiện tại nếu có
            picHinhAnh.setBackground(Color.WHITE);
            picHinhAnh.repaint();
            picHinhAnh.setBackground(Color.WHITE);
        }
        
    }
    
    // Hiển thị hình ảnh
    private ImageIcon loadImage(File file){
        try {
            Image img = ImageIO.read(file);
            ImageIcon icon = new ImageIcon(img);
            return icon;
        } catch (Exception e) {
        }
        return null;
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
    private Views.OtherForm.swing.MyButton btnChooseFile;
    private Views.OtherForm.swing.MyButton btnEdit;
    private Views.OtherForm.swing.MyButton btnReset;
    private Views.OtherForm.swing.MyButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private Views.OtherForm.swing.PanelRound panelRound;
    private Views.OtherForm.swing.PictureBox picHinhAnh;
    private Views.OtherForm.component.JTable.TableScrollButton tableScrollButton1;
    private javax.swing.JTable tblOTo;
    private Views.OtherForm.swing.TextField tfCongSuatDongCo;
    private Views.OtherForm.swing.TextField tfGiaBan;
    private Views.OtherForm.swing.TextField tfHangXe;
    private Views.OtherForm.swing.TextField tfLoaiDongCo;
    private Views.OtherForm.swing.TextField tfMaXe;
    private Views.OtherForm.swing.TextField tfTenXe;
    private Views.OtherForm.swing.TextField tfTrongLuong;
    private Views.OtherForm.swing.TextField tfXuatXu;
    // End of variables declaration//GEN-END:variables
}

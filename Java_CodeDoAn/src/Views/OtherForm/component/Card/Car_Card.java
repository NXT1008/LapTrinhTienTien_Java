
package Views.OtherForm.component.Card;

import Models.Xe;
import javax.swing.ImageIcon;


public class Car_Card extends javax.swing.JPanel {

    public Car_Card() {
        initComponents();
    }

    public void setData(Xe xe){
        lblName.setText(xe.getTenXe());
        lblDescription.setText("Hãng xe: " + xe.getHangXe() + "\n" + "Xuất xứ: " + xe.getXuatXu());
        try {
            //String path = xe.getHinhAnh();
            String path = "";
            ImageIcon icon = new ImageIcon(path);
            image.setImage(icon);
            //image.setImage(image);
        } catch (Exception e) {
            image.setImage(new ImageIcon(getClass().getResource("/Views/OtherForm/Image/1.png")));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblName = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        image = new Views.OtherForm.swing.PictureBox();
        lblPrice = new javax.swing.JLabel();

        lblName.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblName.setForeground(new java.awt.Color(76, 76, 76));
        lblName.setText("Item Name");

        lblDescription.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblDescription.setForeground(new java.awt.Color(178, 178, 178));
        lblDescription.setText("Description");

        image.setImage(new javax.swing.ImageIcon(getClass().getResource("/Views/OtherForm/Image/10.png"))); // NOI18N

        lblPrice.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblPrice.setForeground(new java.awt.Color(142, 102, 115));
        lblPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrice.setText("1,000,000,000 VND");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescription, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Views.OtherForm.swing.PictureBox image;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPrice;
    // End of variables declaration//GEN-END:variables
}

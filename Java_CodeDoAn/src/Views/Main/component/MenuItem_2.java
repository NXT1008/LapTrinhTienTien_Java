
package Views.Main.component;

import Views.Main.Model.Menu_Model_2;
import java.awt.Color;

public class MenuItem_2 extends javax.swing.JPanel {
    
    private final Menu_Model_2 data;
    
    public MenuItem_2(Menu_Model_2 data) {
        this.data = data;
        initComponents();
        setOpaque(false);
        if (data.getType() == Menu_Model_2.MenuType.MENU) {
            lbicon.setIcon(data.toIcon());
            lblMenuName.setText(data.getName());
        } else {
            lblMenuName.setText(" ");
        }
    }
    
    public void setSelected(boolean selected) {
        if (data.getType() == Menu_Model_2.MenuType.MENU) {
            if (selected) {
                lbicon.setIcon(data.toIconSelected());
                lblMenuName.setForeground(new Color(60, 60, 60));
            } else {
                lbicon.setIcon(data.toIcon());
                lblMenuName.setForeground(new Color(214, 217, 223));
            }
        }
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbicon = new javax.swing.JLabel();
        lblMenuName = new javax.swing.JLabel();

        lblMenuName.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuName.setText("Menu Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbicon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMenuName)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMenuName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(lbicon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbicon;
    private javax.swing.JLabel lblMenuName;
    // End of variables declaration//GEN-END:variables
}

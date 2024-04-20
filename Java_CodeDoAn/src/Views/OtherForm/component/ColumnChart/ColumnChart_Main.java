
package Views.OtherForm.component.ColumnChart;

import DAO.chartDAO;
import Models.chartHoaDon;
import Models.chartPhieuNhap;
import java.awt.Color;
import java.util.List;
import javax.swing.Timer;


public class ColumnChart_Main extends javax.swing.JPanel {

    private String year;
    public ColumnChart_Main(String year) {
        initComponents();
        
        this.year = year;
//        Timer timer = new Timer(1000 * 2 * 1, (e) -> { // Cập nhật sau mỗi giờ (1000ms * 60s * 60min)
//            setData();
//        });
//        timer.start();
        loadChart();
    }

    
    private void loadChart() {
        chart.clear();
        chart.addLegend("Income", new Color(12, 84, 175), new Color(0, 108, 247));
        chart.addLegend("Expense", new Color(54, 4, 143), new Color(104, 49, 200));
        setData();
        chart.repaint();
    }
    
    private void setData(){
        //chart.clear();
        List<chartHoaDon> listHD = chartDAO.getInstance().listChartHoaDon(year);
        List<chartPhieuNhap> listPN = chartDAO.getInstance().listChartPhieuNhap(year);
        for (int i = listHD.size() - 1; i>=0; i--){
            chartHoaDon u = listHD.get(i);
            chartPhieuNhap v = listPN.get(i);
            chart.addData(new ModelChart(u.getMonth(), new double[]{u.getTotal(), v.getTotal()}));
        }
        
//        chart.addData(new ModelChart("January", new double[]{500, 200, 80, 89}));
//        chart.addData(new ModelChart("February", new double[]{600, 750, 90, 150}));
//        chart.addData(new ModelChart("March", new double[]{200, 350, 460, 900}));
//        chart.addData(new ModelChart("April", new double[]{480, 150, 750, 700}));
//        chart.addData(new ModelChart("May", new double[]{350, 540, 300, 150}));
//        chart.addData(new ModelChart("June", new double[]{190, 280, 81, 200}));

        chart.start();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        chart = new Views.OtherForm.component.ColumnChart.ColumnChart();

        setBackground(new java.awt.Color(17, 38, 47));
        setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(17, 38, 47));

        chart.setBackground(new java.awt.Color(255, 255, 255));
        chart.setForeground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Views.OtherForm.component.ColumnChart.ColumnChart chart;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

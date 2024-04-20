
package Views.OtherForm.component.Chart;

import DAO.chartDAO;
import Models.chartHoaDon;
import java.awt.Color;
import java.util.List;
import javax.swing.Timer;


public class CurveChart extends javax.swing.JPanel {

    private String year;
    public CurveChart(String year) {
        initComponents();
//        Timer timer = new Timer(5000 * 1 * 1, (e) -> { // Cập nhật sau mỗi giờ (1000ms * 60s * 60min)
//            setData();
//        });
//        timer.start();
        this.year = year;
        loadChart();
    }

    private void loadChart(){
        chart.clear();
        chart.setTitle("Thống Kê Hóa Đơn Theo Năm");
        chart.addLegend("Amount", Color.decode("#7b4397"), Color.decode("#dc2430"));
        setData();
        chart.repaint();
    }
    
    private void setData() {
        List<chartHoaDon> list = chartDAO.getInstance().listChartHoaDon(year);
        chart.clear();
        //  Add Data to chart
        for (int i = list.size() - 1; i >= 0; i--) {
            chartHoaDon d = list.get(i);
            chart.addData(new ModelChart(d.getMonth(), new double[]{d.getTotal(), d.getTotal(), d.getTotal()}));
        }
        //  Start to show data with animation
        chart.start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow1 = new Views.OtherForm.component.Chart.PanelShadow();
        chart = new Views.OtherForm.component.Chart.CurveLineChart();

        panelShadow1.setBackground(new java.awt.Color(34, 59, 69));
        panelShadow1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelShadow1.setColorGradient(new java.awt.Color(17, 38, 47));

        chart.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Views.OtherForm.component.Chart.CurveLineChart chart;
    private Views.OtherForm.component.Chart.PanelShadow panelShadow1;
    // End of variables declaration//GEN-END:variables
}

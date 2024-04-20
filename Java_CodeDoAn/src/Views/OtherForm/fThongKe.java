
package Views.OtherForm;

import Models.HoaDon;
import Models.KhachHang;
import Models.NhanVien;
import Models.PhieuBaoDuong;
import Models.PhieuNhap;
import Models.Xe;
import Services.HoaDonService;
import Services.KhachHangService;
import Services.NhanVienService;
import Services.PhieuBaoDuongService;
import Services.PhieuNhapService;
import Services.XeService;
import Views.Main.Model.Model_Card;
import java.util.List;
import javax.swing.ImageIcon;


public class fThongKe extends javax.swing.JPanel {


    public fThongKe() {
        initComponents();
        LoadDataToCard();
        
    }

    private void LoadDataToCard(){
        List<KhachHang> listKH = KhachHangService.getInstance().danhSachKhachHang();
        List<NhanVien> listNV = NhanVienService.getInstance().danhSachNhanVien();
        List<Xe> listOto = XeService.getInstance().danhSachXe();
        List<HoaDon> listHD = HoaDonService.getInstance().danhSachHoaDon();
        List<PhieuNhap> listPN = PhieuNhapService.getInstance().danhSachPhieuNhap();
        List<PhieuBaoDuong> listPBD = PhieuBaoDuongService.getInstance().danhSachPhieuBaoDuong();
        
        int soLuongKH = listKH.size();
        int soLuongHD = listHD.size();
        int soluongOTo = listOto.size();
        int soLuongNV = listNV.size();
        int soLuongPN = listPN.size();
        int soLuongPBD = listPBD.size();
        
        cardTongNhanVien.setData(new Model_Card(new ImageIcon(getClass().getResource("/Views/Main/icon/customer.png")), "Số Lượng Nhân Viên", String.valueOf(soLuongNV), "Increased by 25%"));
        cardTongKhachHang.setData(new Model_Card(new ImageIcon(getClass().getResource("/Views/Main/icon/employee.png")), "Số Lượng Khách Hàng", String.valueOf(soLuongKH) + " khách", "Increased by 60%"));
        cardTongOTo.setData(new Model_Card(new ImageIcon(getClass().getResource("/Views/Main/icon/car.png")), "Số Lượng Ô Tô", String.valueOf(soluongOTo) + " chiếc", "Increased by 70%"));
        cardTongHoaDon.setData(new Model_Card(new ImageIcon(getClass().getResource("/Views/Main/icon/invoice.png")), "Tổng Hóa Đơn", String.valueOf(soLuongHD) + " hóa đơn", "Increased by 25%"));
        cardTongPhieuNhap.setData(new Model_Card(new ImageIcon(getClass().getResource("/Views/Main/icon/receipt.png")), "Tổng Phiếu Nhập", String.valueOf(soLuongPN) + " phiếu", "Increased by 25%"));
        cardTongPhieuBaoDuong.setData(new Model_Card(new ImageIcon(getClass().getResource("/Views/Main/icon/maintaince_bill.png")), "Tổng Phiếu Bảo Dưỡng", String.valueOf(soLuongPBD) + " phiếu", "Increased by 25%"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        cardTongNhanVien = new Views.Main.component.Card();
        cardTongKhachHang = new Views.Main.component.Card();
        cardTongOTo = new Views.Main.component.Card();
        cardTongHoaDon = new Views.Main.component.Card();
        cardTongPhieuNhap = new Views.Main.component.Card();
        cardTongPhieuBaoDuong = new Views.Main.component.Card();
        jLabel1 = new javax.swing.JLabel();

        jLayeredPane1.setLayout(new java.awt.GridLayout(2, 2, 10, 40));

        cardTongNhanVien.setColor1(new java.awt.Color(236, 56, 188));
        cardTongNhanVien.setColor2(new java.awt.Color(115, 3, 192));
        jLayeredPane1.add(cardTongNhanVien);

        cardTongKhachHang.setColor1(new java.awt.Color(186, 123, 247));
        cardTongKhachHang.setColor2(new java.awt.Color(167, 94, 236));
        jLayeredPane1.add(cardTongKhachHang);

        cardTongOTo.setColor1(new java.awt.Color(56, 239, 125));
        cardTongOTo.setColor2(new java.awt.Color(17, 153, 142));
        jLayeredPane1.add(cardTongOTo);

        cardTongHoaDon.setColor1(new java.awt.Color(18, 194, 233));
        cardTongHoaDon.setColor2(new java.awt.Color(196, 113, 237));
        jLayeredPane1.add(cardTongHoaDon);

        cardTongPhieuNhap.setColor1(new java.awt.Color(28, 181, 224));
        cardTongPhieuNhap.setColor2(new java.awt.Color(0, 0, 70));
        jLayeredPane1.add(cardTongPhieuNhap);

        cardTongPhieuBaoDuong.setColor1(new java.awt.Color(252, 53, 76));
        cardTongPhieuBaoDuong.setColor2(new java.awt.Color(10, 191, 188));
        jLayeredPane1.add(cardTongPhieuBaoDuong);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THỐNG KÊ SỐ LƯỢNG");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 892, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Views.Main.component.Card cardTongHoaDon;
    private Views.Main.component.Card cardTongKhachHang;
    private Views.Main.component.Card cardTongNhanVien;
    private Views.Main.component.Card cardTongOTo;
    private Views.Main.component.Card cardTongPhieuBaoDuong;
    private Views.Main.component.Card cardTongPhieuNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    // End of variables declaration//GEN-END:variables
}

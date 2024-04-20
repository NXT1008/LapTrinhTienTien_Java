
package Models;

import java.util.Date;
import java.sql.*;


public class PhieuBaoDuong {
    private String maPhieuBaoDuong;
    private String maBaoDuong;
    private Date ngayLapPhieu;
    private long tongTien;
    private String maKhachHang;
    private String maNhanVienThucHien;

    public PhieuBaoDuong(String maPhieuBaoDuong, String maBaoDuong, Date ngayLapPhieu, long tongTien, String maKhachHang, String maNhanVienThucHien) {
        this.maPhieuBaoDuong = maPhieuBaoDuong;
        this.maBaoDuong = maBaoDuong;
        this.ngayLapPhieu = ngayLapPhieu;
        this.tongTien = tongTien;
        this.maKhachHang = maKhachHang;
        this.maNhanVienThucHien = maNhanVienThucHien;
    }
    
    public PhieuBaoDuong(ResultSet resultSet) throws SQLException {
        this.maPhieuBaoDuong = resultSet.getString("maPhieuBaoDuong");
        this.maBaoDuong = resultSet.getString("maBaoDuong");
        this.ngayLapPhieu = resultSet.getDate("ngayLapPhieu"); // Use getDate for Date type
        this.tongTien = resultSet.getLong("tongTien");
        this.maKhachHang = resultSet.getString("maKhachHang");
        this.maNhanVienThucHien = resultSet.getString("MaNhanVienThucHien");
    }
    
    public String getMaPhieuBaoDuong() {
        return maPhieuBaoDuong;
    }

    public void setMaPhieuBaoDuong(String maPhieuBaoDuong) {
        this.maPhieuBaoDuong = maPhieuBaoDuong;
    }

    public String getMaBaoDuong() {
        return maBaoDuong;
    }

    public void setMaBaoDuong(String maBaoDuong) {
        this.maBaoDuong = maBaoDuong;
    }
    
    public Date getNgayLapPhieu() {
        return ngayLapPhieu;
    }

    public void setNgayLapPhieu(Date ngayLapPhieu) {
        this.ngayLapPhieu = ngayLapPhieu;
    }

    public long getTongTien() {
        return tongTien;
    }

    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaNhanVienThucHien() {
        return maNhanVienThucHien;
    }

    public void setMaNhanVienThucHien(String maNhanVienThucHien) {
        this.maNhanVienThucHien = maNhanVienThucHien;
    }

    @Override
    public String toString() {
        return "PhieuBaoDuong{" + "maPhieuBaoDuong=" + maPhieuBaoDuong + ", ngayLapPhieu=" + ngayLapPhieu + ", tongTien=" + tongTien + ", maKhachHang=" + maKhachHang + ", maNhanVienThucHien=" + maNhanVienThucHien + '}';
    }
    
    
}

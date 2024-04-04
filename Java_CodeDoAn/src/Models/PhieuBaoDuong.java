/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;
import java.sql.*;

/**
 *
 * @author WIN 10
 */
public class PhieuBaoDuong {
    private String maPhieuBaoDuong;
    private Date ngayLapPhieu;
    private float tongTien;
    private String maKhachHang;
    private String maNhanVienThucHien;

    public PhieuBaoDuong(ResultSet resultSet) throws SQLException {
        this.maPhieuBaoDuong = resultSet.getString("maPhieuBaoDuong");
        this.ngayLapPhieu = resultSet.getDate("ngayLapPhieu"); // Use getDate for Date type
        this.tongTien = resultSet.getFloat("tongTien");
        this.maKhachHang = resultSet.getString("maKhachHang");
        this.maNhanVienThucHien = resultSet.getString("MaNhanVienThucHien");
    }
    
    public String getMaPhieuBaoDuong() {
        return maPhieuBaoDuong;
    }

    public void setMaPhieuBaoDuong(String maPhieuBaoDuong) {
        this.maPhieuBaoDuong = maPhieuBaoDuong;
    }

    public Date getNgayLapPhieu() {
        return ngayLapPhieu;
    }

    public void setNgayLapPhieu(Date ngayLapPhieu) {
        this.ngayLapPhieu = ngayLapPhieu;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
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

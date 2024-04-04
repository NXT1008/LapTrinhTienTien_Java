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
public class HoaDon {

    private String maHoaDon;
    private Date ngayLapHoaDon;
    private float tongTien;
    private String tinhTrang;
    private String maKhachHang;
    private String maNhanVienThucHien;

    public HoaDon(String maHoaDon, Date ngayLapHoaDon, float tongTien, String tinhTrang, String maKhachHang, String maNhanVienThucHien) {
        this.maHoaDon = maHoaDon;
        this.ngayLapHoaDon = ngayLapHoaDon;
        this.tongTien = tongTien;
        this.tinhTrang = tinhTrang;
        this.maKhachHang = maKhachHang;
        this.maNhanVienThucHien = maNhanVienThucHien;
    }

    public HoaDon(ResultSet rs) throws SQLException {
        this.maHoaDon = rs.getString("maHoaDon");
        this.ngayLapHoaDon = rs.getDate("ngayLapHoaDon");
        this.tongTien = rs.getFloat("tongTien");
        this.tinhTrang = rs.getString("tinhTrang");
        this.maKhachHang = rs.getString("maKhachHang");
        this.maNhanVienThucHien = rs.getString("maNhanVienThucHien");
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Date getNgayLapHoaDon() {
        return ngayLapHoaDon;
    }

    public void setNgayLapHoaDon(Date ngayLapHoaDon) {
        this.ngayLapHoaDon = ngayLapHoaDon;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
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
        return "HoaDon{" + "maHoaDon=" + maHoaDon + ", ngayLapHoaDon=" + ngayLapHoaDon + ", tongTien=" + tongTien + ", tinhTrang=" + tinhTrang + ", maKhachHang=" + maKhachHang + ", maNhanVienThucHien=" + maNhanVienThucHien + '}';
    }

}

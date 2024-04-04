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
public class PhieuNhap {

    private String maPhieuNhap;
    private Date ngayNhap;
    private String maNhaCungCap;
    private String maChiNhanh;

    public PhieuNhap(String maPhieuNhap, Date ngayNhap, String maNhaCungCap, String maChiNhanh) {
        this.maPhieuNhap = maPhieuNhap;
        this.ngayNhap = ngayNhap;
        this.maNhaCungCap = maNhaCungCap;
        this.maChiNhanh = maChiNhanh;
    }

    public PhieuNhap(ResultSet rs) throws SQLException {
        this.maPhieuNhap = rs.getString("maPhieuNhap");
        this.ngayNhap = rs.getDate("ngayNhap");
        this.maNhaCungCap = rs.getString("maNhaCungCap");
        this.maChiNhanh = rs.getString("maChiNhanh");
    }

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public String getMaChiNhanh() {
        return maChiNhanh;
    }

    public void setMaChiNhanh(String maChiNhanh) {
        this.maChiNhanh = maChiNhanh;
    }

    @Override
    public String toString() {
        return "PhieuNhap{" + "maPhieuNhap=" + maPhieuNhap + ", ngayNhap=" + ngayNhap + ", maNhaCungCap=" + maNhaCungCap + ", maChiNhanh=" + maChiNhanh + '}';
    }

}

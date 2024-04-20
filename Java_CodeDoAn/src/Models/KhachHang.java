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
public class KhachHang {
    private String maKhachHang;
    private String hoTenKhachHang;
    private Date ngaySinh;
    private String gioiTinh;
    private String cCCD;
    private String diaChi;
    private String soDienThoai;

    public KhachHang() {
    }

    
    public KhachHang(String maKhachHang, String hoTenKhachHang, Date ngaySinh, String gioiTinh, String cCCD, String diaChi, String soDienThoai) {
        this.maKhachHang = maKhachHang;
        this.hoTenKhachHang = hoTenKhachHang;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.cCCD = cCCD;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    
    
    public KhachHang(ResultSet resultSet) throws SQLException {
        this.maKhachHang = resultSet.getString("maKhachHang");
        this.hoTenKhachHang = resultSet.getString("hoTenKhachHang");
        this.ngaySinh = resultSet.getDate("ngaySinh"); // Use getDate for Date type
        this.gioiTinh = resultSet.getString("gioiTinh");
        this.cCCD = resultSet.getString("CCCD");
        this.diaChi = resultSet.getString("diaChi");
        this.soDienThoai = resultSet.getString("soDienThoai");
    }
    
    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getHoTenKhachHang() {
        return hoTenKhachHang;
    }

    public void setHoTenKhachHang(String hoTenKhachHang) {
        this.hoTenKhachHang = hoTenKhachHang;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getcCCD() {
        return cCCD;
    }

    public void setcCCD(String cCCD) {
        this.cCCD = cCCD;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "maKhachHang=" + maKhachHang + ", hoTenKhachHang=" + hoTenKhachHang + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", cCCD=" + cCCD + ", diaChi=" + diaChi + ", soDienThoai=" + soDienThoai + '}';
    }
    
    
}

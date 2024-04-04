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
public class NhanVien {
    private String maNhanVien;
    private String hoTenNhanVien;
    private String cccd;
    private Date ngaySinh;
    private String gioiTinh;
    private String diaChi;
    private String soDienThoai;
    private String chucVu;
    private boolean tinhTrangLamViec; // 1: Còn làm || 0: Đã nghỉ
    private String maChiNhanh;
    private String hinhAnh;

    public NhanVien() {
    }

    public NhanVien(String maNhanVien, String hoTenNhanVien, String cccd, Date ngaySinh, String gioiTinh, String diaChi, String soDienThoai, String chucVu, boolean tinhTrangLamViec, String maChiNhanh, String hinhAnh) {
        this.maNhanVien = maNhanVien;
        this.hoTenNhanVien = hoTenNhanVien;
        this.cccd = cccd;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.chucVu = chucVu;
        this.tinhTrangLamViec = tinhTrangLamViec;
        this.maChiNhanh = maChiNhanh;
        this.hinhAnh = hinhAnh;
    }

    public NhanVien(ResultSet rs) throws SQLException {
        maNhanVien = rs.getString("maNhanVien");
        hoTenNhanVien = rs.getString("hoTenNhanVien");
        cccd = rs.getString("cccd");
        ngaySinh = rs.getDate("ngaySinh");
        gioiTinh = rs.getString("gioiTinh");
        diaChi = rs.getString("diaChi");
        soDienThoai = rs.getString("soDienThoai");
        chucVu = rs.getString("chucVu");
        tinhTrangLamViec = rs.getBoolean("tinhTrangLamViec");
        maChiNhanh = rs.getString("maChiNhanh");
        hinhAnh = rs.getString("hinhAnh");
    }   

    
    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTenNhanVien() {
        return hoTenNhanVien;
    }

    public void setHoTenNhanVien(String hoTenNhanVien) {
        this.hoTenNhanVien = hoTenNhanVien;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
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

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public boolean isTinhTrangLamViec() {
        return tinhTrangLamViec;
    }

    public void setTinhTrangLamViec(boolean tinhTrangLamViec) {
        this.tinhTrangLamViec = tinhTrangLamViec;
    }

    public String getMaChiNhanh() {
        return maChiNhanh;
    }

    public void setMaChiNhanh(String maChiNhanh) {
        this.maChiNhanh = maChiNhanh;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "maNhanVien=" + maNhanVien + ", hoTenNhanVien=" + hoTenNhanVien + ", cccd=" + cccd + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", soDienThoai=" + soDienThoai + ", chucVu=" + chucVu + ", tinhTrangLamViec=" + tinhTrangLamViec + ", maChiNhanh=" + maChiNhanh + ", hinhAnh=" + hinhAnh + '}';
    }
    
    
}

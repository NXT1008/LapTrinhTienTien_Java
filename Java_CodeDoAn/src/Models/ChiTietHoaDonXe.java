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
public class ChiTietHoaDonXe {

    private String maChiTietHoaDonXe;
    private String maHoaDon;
    private String maXe;
    private Date ngayNhanXe;
    private float soTienDaTra;
    private float phiDangKyBienSo;
    private float phiDangKiem;
    private float phiTruocBa;
    private float phiBaoHiemTrachNhiemDanSu;
    private float phiSuDungDuongBo;

    public String getMaChiTietHoaDonXe() {
        return maChiTietHoaDonXe;
    }

    public void setMaChiTietHoaDonXe(String maChiTietHoaDonXe) {
        this.maChiTietHoaDonXe = maChiTietHoaDonXe;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaXe() {
        return maXe;
    }

    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }

    public Date getNgayNhanXe() {
        return ngayNhanXe;
    }

    public void setNgayNhanXe(Date ngayNhanXe) {
        this.ngayNhanXe = ngayNhanXe;
    }

    public float getSoTienDaTra() {
        return soTienDaTra;
    }

    public void setSoTienDaTra(float soTienDaTra) {
        this.soTienDaTra = soTienDaTra;
    }

    public float getPhiDangKyBienSo() {
        return phiDangKyBienSo;
    }

    public void setPhiDangKyBienSo(float phiDangKyBienSo) {
        this.phiDangKyBienSo = phiDangKyBienSo;
    }

    public float getPhiDangKiem() {
        return phiDangKiem;
    }

    public void setPhiDangKiem(float phiDangKiem) {
        this.phiDangKiem = phiDangKiem;
    }

    public float getPhiTruocBa() {
        return phiTruocBa;
    }

    public void setPhiTruocBa(float phiTruocBa) {
        this.phiTruocBa = phiTruocBa;
    }

    public float getPhiBaoHiemTrachNhiemDanSu() {
        return phiBaoHiemTrachNhiemDanSu;
    }

    public void setPhiBaoHiemTrachNhiemDanSu(float phiBaoHiemTrachNhiemDanSu) {
        this.phiBaoHiemTrachNhiemDanSu = phiBaoHiemTrachNhiemDanSu;
    }

    public float getPhiSuDungDuongBo() {
        return phiSuDungDuongBo;
    }

    public void setPhiSuDungDuongBo(float phiSuDungDuongBo) {
        this.phiSuDungDuongBo = phiSuDungDuongBo;
    }

    public ChiTietHoaDonXe(ResultSet resultSet) throws Exception{
        maChiTietHoaDonXe = resultSet.getString("maChiTietHoaDonXe");
        maHoaDon = resultSet.getString("maHoaDon");
        maXe = resultSet.getString("maXe");
        ngayNhanXe = resultSet.getTimestamp("ngayNhanXe"); // Sử dụng getTimestamp cho ngày tháng
        soTienDaTra = resultSet.getFloat("soTienDaTra");
        phiDangKyBienSo = resultSet.getFloat("phiDangKyBienSo");
        phiDangKiem = resultSet.getFloat("phiDangKiem");
        phiTruocBa = resultSet.getFloat("phiTruocBa");
        phiBaoHiemTrachNhiemDanSu = resultSet.getFloat("phiBaoHiemTrachNhiemDanSu");
        phiSuDungDuongBo = resultSet.getFloat("phiSuDungDuongBo");
    }
    
    
    
}

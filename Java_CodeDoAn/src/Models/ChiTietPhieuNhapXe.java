/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;
import java.sql.*;

/**
 *
 * @author WIN 10
 */
public class ChiTietPhieuNhapXe {
    private String maChiTietPhieuNhapXe;
    private String maXe;
    private String maPhieuNhap;
    private float giaNhap;
    private int soLuong;

    public ChiTietPhieuNhapXe(ResultSet resultSet) throws SQLException {
        this.maChiTietPhieuNhapXe = resultSet.getString("maChiTietPhieuNhapXe");
        this.maXe = resultSet.getString("maXe");
        this.maPhieuNhap = resultSet.getString("maPhieuNhap");
        this.giaNhap = resultSet.getFloat("giaNhap");
        this.soLuong = resultSet.getInt("soLuong");
    }
    
    
    public String getMaChiTietPhieuNhapXe() {
        return maChiTietPhieuNhapXe;
    }

    public void setMaChiTietPhieuNhapXe(String maChiTietPhieuNhapXe) {
        this.maChiTietPhieuNhapXe = maChiTietPhieuNhapXe;
    }

    public String getMaXe() {
        return maXe;
    }

    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    
}

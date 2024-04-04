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
public class ChiTietPhieuBaoDuong {
    private String maChiTietPhieuBaoDuong;
    private String maBaoDuong;
    private String maPhieuBaoDuong;
    private float thanhTien;

    public ChiTietPhieuBaoDuong(ResultSet resultSet) throws Exception{
        maChiTietPhieuBaoDuong = resultSet.getString("maChiTietPhieuBaoDuong");
        maBaoDuong = resultSet.getString("maBaoDuong");
        maPhieuBaoDuong = resultSet.getString("maPhieuBaoDuong");
        thanhTien = resultSet.getFloat("thanhTien");
    }

    public String getMaChiTietPhieuBaoDuong() {
        return maChiTietPhieuBaoDuong;
    }

    public void setMaChiTietPhieuBaoDuong(String maChiTietPhieuBaoDuong) {
        this.maChiTietPhieuBaoDuong = maChiTietPhieuBaoDuong;
    }

    public String getMaBaoDuong() {
        return maBaoDuong;
    }

    public void setMaBaoDuong(String maBaoDuong) {
        this.maBaoDuong = maBaoDuong;
    }

    public String getMaPhieuBaoDuong() {
        return maPhieuBaoDuong;
    }

    public void setMaPhieuBaoDuong(String maPhieuBaoDuong) {
        this.maPhieuBaoDuong = maPhieuBaoDuong;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return "ChiTietPhieuBaoDuong{" + "maChiTietPhieuBaoDuong=" + maChiTietPhieuBaoDuong + ", maBaoDuong=" + maBaoDuong + ", maPhieuBaoDuong=" + maPhieuBaoDuong + ", thanhTien=" + thanhTien + '}';
    }
    
}

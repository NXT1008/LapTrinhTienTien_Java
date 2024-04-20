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
public class ChiNhanh {
    private String maChiNhanh;
    private String tenChiNhanh;
    private String diaChi;
    private String soDienThoai;

    public ChiNhanh() {
    }

    public ChiNhanh(String maChiNhanh, String tenChiNhanh, String diaChi, String soDienThoai) {
        this.maChiNhanh = maChiNhanh;
        this.tenChiNhanh = tenChiNhanh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }
    

    public ChiNhanh(ResultSet resultSet) throws SQLException {
        maChiNhanh = resultSet.getString("maChiNhanh");
        tenChiNhanh = resultSet.getString("tenChiNhanh");
        diaChi = resultSet.getString("diaChi");
        soDienThoai = resultSet.getString("soDienThoai");
    }
    
    public String getMaChiNhanh() {
        return maChiNhanh;
    }

    public void setMaChiNhanh(String maChiNhanh) {
        this.maChiNhanh = maChiNhanh;
    }

    public String getTenChiNhanh() {
        return tenChiNhanh;
    }

    public void setTenChiNhanh(String tenChiNhanh) {
        this.tenChiNhanh = tenChiNhanh;
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
    
}

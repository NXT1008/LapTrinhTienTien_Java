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
public class KhoXe {
    private String maXe;
    private String tenXe;
    private int soLuongXeCon;
    private int soLuongXeDaBan;
    private String hinhAnh;

    public KhoXe(ResultSet resultSet) throws SQLException {
        this.maXe = resultSet.getString("maXe");
        this.tenXe = resultSet.getString("tenXe");
        this.soLuongXeCon = resultSet.getInt("soLuongXeCon");
        this.soLuongXeDaBan = resultSet.getInt("soLuongXeDaBan");
        this.hinhAnh = resultSet.getString("hinhAnh");
    }
    
    public String getMaXe() {
        return maXe;
    }

    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public int getSoLuongXeCon() {
        return soLuongXeCon;
    }

    public void setSoLuongXeCon(int soLuongXeCon) {
        this.soLuongXeCon = soLuongXeCon;
    }

    public int getSoLuongXeDaBan() {
        return soLuongXeDaBan;
    }

    public void setSoLuongXeDaBan(int soLuongXeDaBan) {
        this.soLuongXeDaBan = soLuongXeDaBan;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    @Override
    public String toString() {
        return "KhoXe{" + "maXe=" + maXe + ", tenXe=" + tenXe + ", soLuongXeCon=" + soLuongXeCon + ", soLuongXeDaBan=" + soLuongXeDaBan + ", hinhAnh=" + hinhAnh + '}';
    }
    
    
}

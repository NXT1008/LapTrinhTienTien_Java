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

    public ChiNhanh() {
    }

    public ChiNhanh(String maChiNhanh, String tenChiNhanh, String diaChi) {
        this.maChiNhanh = maChiNhanh;
        this.tenChiNhanh = tenChiNhanh;
        this.diaChi = diaChi;
    }

    public ChiNhanh(ResultSet resultSet) throws SQLException {
        //resultSet.next(); // Di chuyển con trỏ đến dòng đầu tiên (nếu có)
        maChiNhanh = resultSet.getString("maChiNhanh");
        tenChiNhanh = resultSet.getString("tenChiNhanh");
        diaChi = resultSet.getString("diaChi");
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

    @Override
    public String toString() {
        return "ChiNhanh{" + "maChiNhanh=" + maChiNhanh + ", tenChiNhanh=" + tenChiNhanh + ", diaChi=" + diaChi + '}';
    }
    
}

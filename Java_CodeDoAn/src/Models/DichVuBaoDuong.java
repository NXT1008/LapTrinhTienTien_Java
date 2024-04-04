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
public class DichVuBaoDuong {
    private String maBaoDuong;
    private String tenBaoDuong;
    private String loaiBaoDuong;
    private float phiBaoDuong;

    public DichVuBaoDuong(ResultSet resultSet) throws SQLException {
        this.maBaoDuong = resultSet.getString("maBaoDuong");
        this.tenBaoDuong = resultSet.getString("tenBaoDuong");
        this.loaiBaoDuong = resultSet.getString("loaiBaoDuong");
        this.phiBaoDuong = resultSet.getFloat("phiBaoDuong");
    }
    
    public String getMaBaoDuong() {
        return maBaoDuong;
    }

    public void setMaBaoDuong(String maBaoDuong) {
        this.maBaoDuong = maBaoDuong;
    }

    public String getTenBaoDuong() {
        return tenBaoDuong;
    }

    public void setTenBaoDuong(String tenBaoDuong) {
        this.tenBaoDuong = tenBaoDuong;
    }

    public String getLoaiBaoDuong() {
        return loaiBaoDuong;
    }

    public void setLoaiBaoDuong(String loaiBaoDuong) {
        this.loaiBaoDuong = loaiBaoDuong;
    }

    public float getPhiBaoDuong() {
        return phiBaoDuong;
    }

    public void setPhiBaoDuong(float phiBaoDuong) {
        this.phiBaoDuong = phiBaoDuong;
    }

    @Override
    public String toString() {
        return "DichVuBaoDuong{" + "maBaoDuong=" + maBaoDuong + ", tenBaoDuong=" + tenBaoDuong + ", loaiBaoDuong=" + loaiBaoDuong + ", phiBaoDuong=" + phiBaoDuong + '}';
    }
    
    
}

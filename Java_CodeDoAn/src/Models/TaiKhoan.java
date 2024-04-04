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
public class TaiKhoan {
    private String tenDangNhap;
    private String matKhau;
    private String maNhanVien;

    public TaiKhoan(ResultSet resultSet) throws SQLException {
        tenDangNhap = resultSet.getString("tenDangNhap");
        matKhau = resultSet.getString("matKhau");
        maNhanVien = resultSet.getString("maNhanVien");
    }
    
    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
    
    
}

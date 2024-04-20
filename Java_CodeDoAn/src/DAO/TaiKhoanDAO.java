/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class TaiKhoanDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    private static TaiKhoanDAO Instance;

    public static TaiKhoanDAO getInstance() {
        if (Instance == null)
            Instance = new TaiKhoanDAO();
        return Instance;
    }
    
    public List<TaiKhoan> danhSachTaiKhoan(){
        List<TaiKhoan> list = new ArrayList<>();
        String query = "";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                TaiKhoan i = new TaiKhoan(rs);
                list.add(i);
            }
            
            conn.close();
        } catch (Exception e) {
        }
        
        return list;
    }
    
    public TaiKhoan login(String username, String password){
        TaiKhoan tk;
        String query = "select * from TAIKHOAN where tenDangNhap = ? and matKhau = ?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()){
                tk = new TaiKhoan(rs);
                return tk;
            }
            conn.close();
        } catch (Exception e) {
        }
        return null;
    }
    
    public boolean register(TaiKhoan tk){
        String query = "insert into TAIKHOAN(tenDangNhap, matKhau, maNhanVien) values (?,?,?)";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, tk.getTenDangNhap());
            ps.setString(2, tk.getMatKhau());
            ps.setString(3, tk.getMaNhanVien());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public TaiKhoan findByMaNhanVien(String maNV){
        TaiKhoan tk;
        String query = "select * from TAIKHOAN where maNhanVien = ?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maNV);
            rs = ps.executeQuery();
            while (rs.next()){
                tk = new TaiKhoan(rs);
                return tk;
            }
            conn.close();
        } catch (Exception e) {
        }
        return null;
    }
    
    public boolean update(TaiKhoan tk){
        String query = "update TAIKHOAN set tenDangNhap = ?, matKhau = ? where maNhanVien = ?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, tk.getTenDangNhap());
            ps.setString(2, tk.getMatKhau());
            ps.setString(3, tk.getMaNhanVien());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
}

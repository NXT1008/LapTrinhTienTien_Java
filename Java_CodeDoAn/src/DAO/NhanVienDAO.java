/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author WIN 10
 */
public class NhanVienDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    private static NhanVienDAO Instance;

    public static NhanVienDAO getInstance() {
        if (Instance == null)
            Instance = new NhanVienDAO();
        return Instance;
    }
    
    public List<NhanVien> danhSachNhanVien(){
        List<NhanVien> list = new ArrayList<>();
        String query = "exec List_NhanVien";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                NhanVien i = new NhanVien(rs);
                list.add(i);
            }
            
            conn.close();
        } catch (Exception e) {
        }
        
        return list;
    }
    
    public boolean insert(NhanVien model){
        String query = "exec Insert_NhanVien ?,?,?,?,?,?,?,?,?,?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, model.getHoTenNhanVien());
            ps.setString(2, model.getCccd());
            ps.setDate(3, (Date) model.getNgaySinh());
            ps.setString(4, model.getGioiTinh());
            ps.setString(5, model.getDiaChi());
            ps.setString(6, model.getSoDienThoai());
            ps.setString(7, model.getChucVu());
            ps.setBoolean(8, model.isTinhTrangLamViec());
            ps.setString(9, model.getMaChiNhanh());
            ps.setString(10, model.getHinhAnh());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean update(NhanVien model){
        String query = "exec Update_NhanVien ?,?,?,?,?,?,?,?,?,?,?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, model.getMaNhanVien());
            ps.setString(2, model.getHoTenNhanVien());
            ps.setString(3, model.getCccd());
            ps.setDate(4, (Date) model.getNgaySinh());
            ps.setString(5, model.getGioiTinh());
            ps.setString(6, model.getDiaChi());
            ps.setString(7, model.getSoDienThoai());
            ps.setString(8, model.getChucVu());
            ps.setBoolean(9, model.isTinhTrangLamViec());
            ps.setString(10, model.getMaChiNhanh());
            ps.setString(11, model.getHinhAnh());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean delete(String ma){
        String query = "exec Delete_NhanVien ?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, ma);
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.PhieuNhap;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WIN 10
 */
public class PhieuNhapDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    private static PhieuNhapDAO Instance;

    public static PhieuNhapDAO getInstance() {
        if (Instance == null)
            Instance = new PhieuNhapDAO();
        return Instance;
    }
    
    public List<PhieuNhap> danhSachPhieuNhap(){
        List<PhieuNhap> list = new ArrayList<>();
        String query = "exec List_PhieuNhap";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                PhieuNhap i = new PhieuNhap(rs);
                list.add(i);
            }
            
            conn.close();
        } catch (Exception e) {
        }
        
        return list;
    }
    
    public boolean insert(PhieuNhap model){
        String query = "exec Insert_PhieuNhap ?,?,?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setDate(1, (Date) model.getNgayNhap());
            ps.setString(2, model.getMaChiNhanh());
            ps.setString(3, model.getMaNhaCungCap());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean update(PhieuNhap model){
        String query = "exec Update_PhieuNhap ?,?,?,?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, model.getMaPhieuNhap());
            ps.setDate(2, (Date) model.getNgayNhap());
            ps.setString(3, model.getMaChiNhanh());
            ps.setString(4, model.getMaNhaCungCap());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean delete(String ma){
        String query = "exec Delete_PhieuNhap ?";
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

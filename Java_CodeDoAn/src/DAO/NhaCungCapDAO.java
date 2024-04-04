/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.NhaCungCap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WIN 10
 */
public class NhaCungCapDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    private static NhaCungCapDAO Instance;

    public static NhaCungCapDAO getInstance() {
        if (Instance == null)
            Instance = new NhaCungCapDAO();
        return Instance;
    }
    
    public List<NhaCungCap> danhSachNhaCungCap(){
        List<NhaCungCap> list = new ArrayList<>();
        String query = "exec List_NhaCungCap";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                NhaCungCap i = new NhaCungCap(rs);
                list.add(i);
            }
            
            conn.close();
        } catch (Exception e) {
        }
        
        return list;
    }
    
    public boolean insert(NhaCungCap model){
        String query = "exec Insert_NhaCungCap ?,?,?,?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, model.getMaNhaCungCap());
            ps.setString(2, model.getTenNhaCungCap());
            ps.setString(3, model.getDiaChi());
            ps.setString(4, model.getSoDienThoai());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean update(NhaCungCap model){
        String query = "exec Update_NhaCungCap ?,?,?,?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, model.getMaNhaCungCap());
            ps.setString(2, model.getTenNhaCungCap());
            ps.setString(3, model.getDiaChi());
            ps.setString(4, model.getSoDienThoai());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean delete(String ma){
        String query = "exec Delete_NhaCungCap ?";
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

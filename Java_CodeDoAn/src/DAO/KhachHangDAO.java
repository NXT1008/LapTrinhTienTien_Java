/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.KhachHang;
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
public class KhachHangDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    private static KhachHangDAO Instance;

    public static KhachHangDAO getInstance() {
        if (Instance == null)
            Instance = new KhachHangDAO();
        return Instance;
    }
    
    public List<String> listMaKhachHang(){
        List<String> list = new ArrayList<>();
        String query = "select maKhachHang from KHACHHANG";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                list.add(rs.getString(1));
            }
            
            conn.close();
        } catch (Exception e) {
        }
        
        return list;
    }
    
    public List<KhachHang> danhSachKhachHang(){
        List<KhachHang> list = new ArrayList<>();
        String query = "exec List_KhachHang";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                KhachHang i = new KhachHang(rs);
                list.add(i);
            }
            
            conn.close();
        } catch (Exception e) {
        }
        
        return list;
    }
    
    public KhachHang findOne(String maKH){
        KhachHang kh;
        String query = "select * from KHACHHANG where maKhachHang = ?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maKH);
            rs = ps.executeQuery();
            while (rs.next()){
                kh = new KhachHang(rs);
                return kh;
            }
            
            
            conn.close();
        } catch (Exception e) {
        }
        return null;
    }
    
    public boolean insert(KhachHang model){
        String query = "exec Insert_KhachHang ?,?,?,?,?,?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, model.getHoTenKhachHang());
            ps.setDate(2, (Date) model.getNgaySinh());
            ps.setString(3, model.getGioiTinh());
            ps.setString(4, model.getcCCD());
            ps.setString(5, model.getDiaChi());
            ps.setString(6, model.getSoDienThoai());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean update(KhachHang model){
        String query = "exec Update_KhachHang ?,?,?,?,?,?,?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, model.getMaKhachHang());
            ps.setString(2, model.getHoTenKhachHang());
            ps.setDate(3, (Date) model.getNgaySinh());
            ps.setString(4, model.getGioiTinh());
            ps.setString(5, model.getcCCD());
            ps.setString(6, model.getDiaChi());
            ps.setString(7, model.getSoDienThoai());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean delete(String ma){
        String query = "exec Delete_KhachHang ?";
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

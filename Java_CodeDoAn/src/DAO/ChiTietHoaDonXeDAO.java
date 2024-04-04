/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Models.ChiTietHoaDonXe;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author WIN 10
 */
public class ChiTietHoaDonXeDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    private static ChiTietHoaDonXeDAO Instance;

    public static ChiTietHoaDonXeDAO getInstance() {
        if (Instance == null)
            Instance = new ChiTietHoaDonXeDAO();
        return Instance;
    }
    
    public List<ChiTietHoaDonXe> danhSachChiTietHoaDonXe(){
        List<ChiTietHoaDonXe> list = new ArrayList<>();
        String query = "exec list_CHITIETHOADONXE";
        
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                ChiTietHoaDonXe i = new ChiTietHoaDonXe(rs);
                list.add(i);
            }
            
            conn.close();
        } catch (Exception e) {
        
        }
        
        return list;
    }
    
    public ChiTietHoaDonXe findOne(String maCTHDX){
        ChiTietHoaDonXe model;
        String query = "select * from CHITIETHOADONXE where maChiTietHoaDonXe = ?";
        
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maCTHDX);
            rs = ps.executeQuery();
            while(rs.next()){
                model = new ChiTietHoaDonXe(rs);
                return model;
            }
            
            conn.close();
        } catch (Exception e) {
        
        }
        return null;
    }
    
    public boolean insert(ChiTietHoaDonXe model){
        String query = "exec Insert_CHITIETHOADONXE ?, ?, ?, ?, ?, ?, ?, ?, ?";
        try 
        {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, model.getMaHoaDon());
            ps.setString(2, model.getMaXe());
            ps.setDate(3, (Date)model.getNgayNhanXe());
            ps.setFloat(4, model.getSoTienDaTra());
            ps.setFloat(5, model.getPhiDangKyBienSo());
            ps.setFloat(6, model.getPhiDangKiem());
            ps.setFloat(7, model.getPhiTruocBa());
            ps.setFloat(8, model.getPhiBaoHiemTrachNhiemDanSu());
            ps.setFloat(9, model.getPhiSuDungDuongBo());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean update(ChiTietHoaDonXe model){
        String query = "exec Update_CHITIETHOADONXE ?,?,?,?,?,?,?,?,?,?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, model.getMaChiTietHoaDonXe());
            ps.setString(2, model.getMaHoaDon());
            ps.setString(3, model.getMaXe());
            ps.setDate(4, (Date)model.getNgayNhanXe());
            ps.setFloat(5, model.getSoTienDaTra());
            ps.setFloat(6, model.getPhiDangKyBienSo());
            ps.setFloat(7, model.getPhiDangKiem());
            ps.setFloat(8, model.getPhiTruocBa());
            ps.setFloat(9, model.getPhiBaoHiemTrachNhiemDanSu());
            ps.setFloat(10, model.getPhiSuDungDuongBo());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean delete(String maCTHDX){
        String query = "exec Delete_CHITIETHOADONXE @maChiTietHoaDonXe ";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maCTHDX);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}

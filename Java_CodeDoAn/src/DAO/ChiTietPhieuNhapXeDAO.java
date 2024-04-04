/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Models.ChiTietPhieuNhapXe;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author WIN 10
 */
public class ChiTietPhieuNhapXeDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    private static ChiTietPhieuNhapXeDAO Instance;

    public static ChiTietPhieuNhapXeDAO getInstance() {
        if (Instance == null)
            Instance = new ChiTietPhieuNhapXeDAO();
        return Instance;
    }
    
    public List<ChiTietPhieuNhapXe> danhSachPhieuNhapXe(){
        List<ChiTietPhieuNhapXe> list = new ArrayList<>();
        String query = "";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                ChiTietPhieuNhapXe i = new ChiTietPhieuNhapXe(rs);
                list.add(i);
            }
            
            conn.close();
        } catch (Exception e) {
        }
        
        return list;
    }
    
    public boolean insert(ChiTietPhieuNhapXe model){
        String query = "exec Insert_CHITIETPHIEUNHAPXE ?,?,?,?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, model.getMaXe());
            ps.setString(2, model.getMaPhieuNhap());
            ps.setFloat(3,  model.getGiaNhap());
            ps.setInt(4,  model.getSoLuong());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean update(ChiTietPhieuNhapXe model){
        String query = "exec Update_CHITIETPHIEUNHAPXE ?,?,?,?,?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, model.getMaChiTietPhieuNhapXe());
            ps.setString(2, model.getMaXe());
            ps.setString(3, model.getMaPhieuNhap());
            ps.setFloat(4,  model.getGiaNhap());
            ps.setInt(5,  model.getSoLuong());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean delete(String ma){
        String query = "exec Delete_CHITIETPHIEUNHAPXE ?";
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

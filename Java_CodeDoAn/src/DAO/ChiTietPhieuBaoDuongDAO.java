/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Models.ChiTietPhieuBaoDuong;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author WIN 10
 */
public class ChiTietPhieuBaoDuongDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    private static ChiTietPhieuBaoDuongDAO Instance;

    public static ChiTietPhieuBaoDuongDAO getInstance() {
        if (Instance == null)
            Instance = new ChiTietPhieuBaoDuongDAO();
        return Instance;
    }
    
    public List<ChiTietPhieuBaoDuong> danhSachPhieuBaoDuong(){
        List<ChiTietPhieuBaoDuong> list = new ArrayList<>();
        String query = "exec list_CHITIETPHIEUBAODUONG";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                ChiTietPhieuBaoDuong i = new ChiTietPhieuBaoDuong(rs);
                list.add(i);
            }
            conn.close();
        } catch (Exception e) {
        }
        
        return list;
    }
    
    public ChiTietPhieuBaoDuong findOne(String maCTPBD){
        String query = "select * from CHITIETPHIEUBAODUONG where maChiTietPhieuBaoDuong = ?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maCTPBD);
            rs = ps.executeQuery();
            while (rs.next()){
                ChiTietPhieuBaoDuong i = new ChiTietPhieuBaoDuong(rs);
                return i;
            }
            conn.close();
        } catch (Exception e) {
        }
        
        return null;
    }
    
    public boolean insert(ChiTietPhieuBaoDuong model){
        String query = "exec Insert_CHITIETPHIEUBAODUONG ?,?,?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, model.getMaBaoDuong());
            ps.setString(2, model.getMaPhieuBaoDuong());
            ps.setFloat(3,  model.getThanhTien());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean update(ChiTietPhieuBaoDuong model){
        String query = "exec Update_CHITIETPHIEUBAODUONG ?,?,?,?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, model.getMaChiTietPhieuBaoDuong());
            ps.setString(2, model.getMaBaoDuong());
            ps.setString(3, model.getMaPhieuBaoDuong());
            ps.setFloat(4,  model.getThanhTien());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean delete(String ma){
        String query = "exec Delete_CHITIETPHIEUBAODUONG ?";
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;
import Models.DichVuBaoDuong;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author WIN 10
 */
public class DichVuBaoDuongDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    private static DichVuBaoDuongDAO Instance;

    public static DichVuBaoDuongDAO getInstance() {
        if (Instance == null)
            Instance = new DichVuBaoDuongDAO();
        return Instance;
    }
    
    public List<DichVuBaoDuong> danhSachDichVuBaoDuong(){
        List<DichVuBaoDuong> list = new ArrayList<>();
        String query = "";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                DichVuBaoDuong i = new DichVuBaoDuong(rs);
                list.add(i);
            }
            
            conn.close();
        } catch (Exception e) {
        }
        
        return list;
    }
    
    public boolean insert(DichVuBaoDuong model){
        String query = "exec Insert_DICHVUBAODUONG ?,?,?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, model.getTenBaoDuong());
            ps.setString(2, model.getLoaiBaoDuong());
            ps.setFloat(3,  model.getPhiBaoDuong());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean update(DichVuBaoDuong model){
        String query = "exec Insert_DICHVUBAODUONG ?,?,?,?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, model.getMaBaoDuong());
            ps.setString(2, model.getTenBaoDuong());
            ps.setString(3, model.getLoaiBaoDuong());
            ps.setFloat(4,  model.getPhiBaoDuong());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean delete(String ma){
        String query = "exec Delete_DICHVUBAODUONG ?";
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

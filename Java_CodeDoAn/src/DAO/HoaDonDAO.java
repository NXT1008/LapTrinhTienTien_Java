/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;
import Models.HoaDon;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author WIN 10
 */
public class HoaDonDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    private static HoaDonDAO Instance;

    public static HoaDonDAO getInstance() {
        if (Instance == null)
            Instance = new HoaDonDAO();
        return Instance;
    }
    
    public List<HoaDon> danhSachHoaDon(){
        List<HoaDon> list = new ArrayList<>();
        String query = "";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                HoaDon i = new HoaDon(rs);
                list.add(i);
            }
            
            conn.close();
        } catch (Exception e) {
        }
        
        return list;
    }
    
    public boolean insert(HoaDon model){
        String query = "exec Insert_HOADON ?,?,?,?,?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setDate(1, (Date) model.getNgayLapHoaDon());
            ps.setFloat(2, model.getTongTien());
            ps.setString(3, model.getTinhTrang());
            ps.setString(4, model.getMaHoaDon());
            ps.setString(5, model.getMaNhanVienThucHien());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean update(HoaDon model){
        String query = "exec Update_HOADON ?,?,?,?,?,?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, model.getMaHoaDon());
            ps.setDate(2, (Date) model.getNgayLapHoaDon());
            ps.setFloat(3, model.getTongTien());
            ps.setString(4, model.getTinhTrang());
            ps.setString(5, model.getMaHoaDon());
            ps.setString(6, model.getMaNhanVienThucHien());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean delete(String ma){
        String query = "exec Delete_HOADON ?";
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

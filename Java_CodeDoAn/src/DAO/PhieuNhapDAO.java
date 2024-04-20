
package DAO;

import Models.PhieuNhap;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import raven.alerts.MessageAlerts;

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
    
    public PhieuNhap findOne(String maPN){
        PhieuNhap pn;
        String query = "select * from PHIEUNHAP where maPhieuNhap = ?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maPN);
            rs = ps.executeQuery();
            while (rs.next()){
                pn = new PhieuNhap(rs);
                return pn;
            }
            
            conn.close();
        } catch (Exception e) {
        }
        
        return null;
    }
    
    public boolean insert(PhieuNhap model){
        String query = "exec Insert_PhieuNhap ?,?,?,?,?,?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, model.getMaXe());
            ps.setDate(2, (Date) model.getNgayNhap());
            ps.setLong(3, model.getGiaNhap());
            ps.setInt(4, model.getSoLuong());
            ps.setString(5, model.getMaNhaCungCap());
            ps.setString(6, model.getMaChiNhanh());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean update(PhieuNhap model){
        String query = "exec Update_PhieuNhap ?,?,?,?,?,?,?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, model.getMaPhieuNhap());
            ps.setString(2, model.getMaXe());
            ps.setDate(3, (Date) model.getNgayNhap());
            ps.setLong(4, model.getGiaNhap());
            ps.setInt(5, model.getSoLuong());
            ps.setString(6, model.getMaNhaCungCap());
            ps.setString(7, model.getMaChiNhanh());
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

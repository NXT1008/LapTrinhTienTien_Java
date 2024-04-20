
package DAO;

import Models.PhieuBaoDuong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;


public class PhieuBaoDuongDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    private static PhieuBaoDuongDAO Instance;

    public static PhieuBaoDuongDAO getInstance() {
        if (Instance == null)
            Instance = new PhieuBaoDuongDAO();
        return Instance;
    }
    
    public List<PhieuBaoDuong> danhSachPhieuBaoDuong(){
        List<PhieuBaoDuong> list = new ArrayList<>();
        String query = "exec List_PHIEUBAODUONG";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                PhieuBaoDuong i = new PhieuBaoDuong(rs);
                list.add(i);
            }
            
            conn.close();
        } catch (Exception e) {
        }
        
        return list;
    }
    
    public PhieuBaoDuong findOne(String maPBD){
        PhieuBaoDuong pbd;
        String query = "select * from PHIEUBAODUONG where maPhieuBaoDuong = ?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maPBD);
            rs = ps.executeQuery();
            while (rs.next()){
                pbd = new PhieuBaoDuong(rs);
                return pbd;
            }
            
            conn.close();
        } catch (Exception e) {
        }
        
        return null;
    }
    
    public boolean insert(PhieuBaoDuong model){
        String query = "exec Insert_PHIEUBAODUONG ?,?,?,?,?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, model.getMaBaoDuong());
            ps.setDate(2, (Date) model.getNgayLapPhieu());
            ps.setLong(3, model.getTongTien());
            ps.setString(4, model.getMaKhachHang());
            ps.setString(5, model.getMaNhanVienThucHien());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean update(PhieuBaoDuong model){
        String query = "exec Update_PHIEUBAODUONG ?,?,?,?,?,?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, model.getMaPhieuBaoDuong());
            ps.setDate(2, (Date) model.getNgayLapPhieu());
            ps.setLong(3, model.getTongTien());
            ps.setString(4, model.getMaKhachHang());
            ps.setString(5, model.getMaNhanVienThucHien());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean delete(String ma){
        String query = "exec Delete_PHIEUBAODUONG ?";
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

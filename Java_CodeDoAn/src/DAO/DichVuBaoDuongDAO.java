
package DAO;
import java.sql.*;
import Models.DichVuBaoDuong;
import java.util.ArrayList;
import java.util.List;

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
        String query = "exec list_DICHVUBAODUONG";
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
    
    public List<String> listMaBaoDuong(){
        List<String> list = new ArrayList<>();
        String query = "select maBaoDuong from DICHVUBAODUONG";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                list.add(rs.getString("maBaoDuong"));
            }
            conn.close();
        } catch (Exception e) {
        }
        
        return list;
    }
    
    public DichVuBaoDuong findOne(String maBD){
        DichVuBaoDuong dvbd;
        String query = "select * from DICHVUBAODUONG where maBaoDuong = ?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maBD);
            rs = ps.executeQuery();
            while (rs.next()){
                dvbd = new DichVuBaoDuong(rs);
                return dvbd;
            }
            
            conn.close();
        } catch (Exception e) {
        }
        
        return null;
    }
    
    public boolean insert(DichVuBaoDuong model){
        String query = "exec Insert_DICHVUBAODUONG ?,?,?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, model.getTenBaoDuong());
            ps.setString(2, model.getLoaiBaoDuong());
            ps.setLong(3,  model.getPhiBaoDuong());
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
            ps.setLong(4,  model.getPhiBaoDuong());
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

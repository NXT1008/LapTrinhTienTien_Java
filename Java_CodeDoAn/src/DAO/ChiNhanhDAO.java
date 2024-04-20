
package DAO;
import Models.ChiNhanh;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChiNhanhDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    private static ChiNhanhDAO Instance;

    public static ChiNhanhDAO getInstance() {
        if (Instance == null)
            Instance = new ChiNhanhDAO();
        return Instance;
    }
    
    public List<ChiNhanh> danhSachChiNhanh(){
        List<ChiNhanh> list = new ArrayList<>();
        String query = "exec list_ChiNhanh";
        try {
            conn = DBConnection.getConnection();
            
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                ChiNhanh cn = new ChiNhanh(rs);
                list.add(cn);
            }
            
            conn.close();
        } catch (Exception e) {
        }
        
        return list;
    }
    
    public List<String> listMaChiNhanh(){
        List<String> list = new ArrayList<>();
        String query = "select maChiNhanh from CHINHANH";
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
    
    public ChiNhanh findOne(String maCN){
        ChiNhanh cn;
        String query = "select * from CHINHANH where maChiNhanh = ?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maCN);
            rs = ps.executeQuery();
            while (rs.next()){
                cn = new ChiNhanh(rs);
                return cn;
            }
            conn.close();
        } catch (Exception e) {
            
        }
        
        return null;
    }
    
    public boolean insert(ChiNhanh cn){
        String query = "exec Insert_CHINHANH ? , ? , ?, ?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, cn.getMaChiNhanh());
            ps.setString(2, cn.getTenChiNhanh());
            ps.setString(3, cn.getDiaChi());
            ps.setString(4, cn.getSoDienThoai());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean update(ChiNhanh cn){
        String query = "exec Update_CHINHANH ? , ? , ?, ?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, cn.getMaChiNhanh());
            ps.setString(2, cn.getTenChiNhanh());
            ps.setString(3, cn.getDiaChi());
            ps.setString(4, cn.getSoDienThoai());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean delete(String maCN){
        String query = "exec Delete_CHINHANH ?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maCN);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
}

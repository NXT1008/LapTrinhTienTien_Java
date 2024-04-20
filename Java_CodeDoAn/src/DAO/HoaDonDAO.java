
package DAO;
import java.sql.*;
import Models.HoaDon;
import java.util.ArrayList;
import java.util.List;

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
        String query = "exec list_HOADON";
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
    
    public HoaDon findOne(String maHD){
        HoaDon hd;
        String query = "select * from HOADON where maHoaDon = ?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maHD);
            rs = ps.executeQuery();
            while (rs.next()){
                hd = new HoaDon(rs);
                return hd;
            }
            
            conn.close();
        } catch (Exception e) {
        }
        
        return null;
    }
    
    public boolean insert(HoaDon model){
        String query = "exec Insert_HOADON ?,?,?,?,?,?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setDate(1, (Date) model.getNgayLapHoaDon());
            ps.setString(2, model.getMaXe());
            ps.setLong(3, model.getTongTien());
            ps.setString(4, model.getTinhTrang());
            ps.setString(5, model.getMaKhachHang());
            ps.setString(6, model.getMaNhanVienThucHien());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean update(HoaDon model){
        String query = "exec Update_HOADON ?,?,?,?,?,?,?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, model.getMaHoaDon());
            ps.setDate(2, (Date) model.getNgayLapHoaDon());
            ps.setString(3, model.getMaXe());
            ps.setLong(4, model.getTongTien());
            ps.setString(5, model.getTinhTrang());
            ps.setString(6, model.getMaKhachHang());
            ps.setString(7, model.getMaNhanVienThucHien());
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

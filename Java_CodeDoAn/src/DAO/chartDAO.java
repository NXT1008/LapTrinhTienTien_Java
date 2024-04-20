
package DAO;

import Models.chartHoaDon;
import Models.chartPhieuNhap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class chartDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    private static chartDAO Instance;

    public static chartDAO getInstance() {
        if (Instance == null)
            Instance = new chartDAO();
        return Instance;
    }
    
    public List<chartHoaDon> listChartHoaDon(String year){
        List<chartHoaDon> list = new ArrayList<>();
        String query = """
                       SELECT FORMAT(ngayLapHoaDon, 'MM/yyyy') AS MonthYear, Sum(tongTien) AS TotalHoaDon 
                       FROM HOADON 
                       WHERE YEAR(ngayLapHoaDon) = ?
                       GROUP BY FORMAT(ngayLapHoaDon, 'MM/yyyy')
                       ORDER BY MIN(ngayLapHoaDon) DESC
                       """;
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, year);
            rs = ps.executeQuery();
            while(rs.next()){
                chartHoaDon model = new chartHoaDon(rs.getString(1), rs.getLong(2));
                list.add(model);
            }
            
            conn.close();
        } catch (Exception e) {
        }
        return list;
    }
    
    public List<chartPhieuNhap> listChartPhieuNhap(String year){
        List<chartPhieuNhap> list = new ArrayList<>();
        String query = """
                       select FORMAT(ngayNhap, 'MM/yyyy') as MonthYear, Sum(giaNhap * soLuong) as TotalPhieuNhap 
                       from PHIEUNHAP 
                       where YEAR(ngayNhap) = ?
                       GROUP BY FORMAT(ngayNhap, 'MM/yyyy')
                       ORDER BY MIN(ngayNhap) DESC
                       """;
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, year);
            rs = ps.executeQuery();
            while(rs.next()){
                chartPhieuNhap model = new chartPhieuNhap(rs.getString(1), rs.getLong(2));
                list.add(model);
            }
            
            conn.close();
        } catch (Exception e) {
        }
        return list;
    }
}

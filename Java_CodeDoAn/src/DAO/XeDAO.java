/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.Xe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WIN 10
 */
public class XeDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    private static XeDAO Instance;

    public static XeDAO getInstance() {
        if (Instance == null)
            Instance = new XeDAO();
        return Instance;
    }
    
    public List<Xe> danhSachXe(){
        List<Xe> list = new ArrayList<>();
        String query = "";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                Xe i = new Xe(rs);
                list.add(i);
            }
            
            conn.close();
        } catch (Exception e) {
        }
        
        return list;
    }
    
    public boolean insert(Xe model){
        String query = "exec Insert_XE ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, model.getTenXe());
            ps.setString(2, model.getMauSac());
            ps.setFloat(3, model.getGiaBan());
            ps.setInt(4, model.getSoChoNgoi());
            ps.setString(5, model.getXuatXu());
            ps.setString(6, model.getHangXe());
            ps.setString(7, model.getLoaiXe());
            ps.setString(8, model.getPhienBanXe());
            ps.setInt(9, model.getTrongLuong());
            ps.setString(10, model.getLoaiNhienLieu());
            ps.setInt(11, model.getCongSuatDongCo());
            ps.setInt(12, model.getDungTichDongCo());
            ps.setString(13, model.getLoaiDongCo());
            ps.setInt(14, model.getKhoangSangGam());
            ps.setInt(15, model.getChieuDai());
            ps.setInt(16, model.getChieuRong());
            ps.setInt(17, model.getChieuCao());
            ps.setString(18, model.getHinhAnh());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean update(Xe model){
        String query = "exec Update_XE ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, model.getMaXe());
            ps.setString(2, model.getTenXe());
            ps.setString(3, model.getMauSac());
            ps.setFloat(4, model.getGiaBan());
            ps.setInt(5, model.getSoChoNgoi());
            ps.setString(6, model.getXuatXu());
            ps.setString(7, model.getHangXe());
            ps.setString(8, model.getLoaiXe());
            ps.setString(9, model.getPhienBanXe());
            ps.setInt(10, model.getTrongLuong());
            ps.setString(11, model.getLoaiNhienLieu());
            ps.setInt(12, model.getCongSuatDongCo());
            ps.setInt(13, model.getDungTichDongCo());
            ps.setString(14, model.getLoaiDongCo());
            ps.setInt(15, model.getKhoangSangGam());
            ps.setInt(16, model.getChieuDai());
            ps.setInt(17, model.getChieuRong());
            ps.setInt(18, model.getChieuCao());
            ps.setString(19, model.getHinhAnh());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean delete(String ma){
        String query = "exec Delete_XE ?";
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

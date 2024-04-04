/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DAO.ChiTietHoaDonXeDAO;
import Models.ChiTietHoaDonXe;
import java.util.List;

/**
 *
 * @author WIN 10
 */
public class ChiTietHoaDonXeService {
    private static ChiTietHoaDonXeService instance;

    public static ChiTietHoaDonXeService getInstance() {
        if (instance == null)
            instance = new ChiTietHoaDonXeService();
        return instance;
    }
    
    
    public List<ChiTietHoaDonXe> danhSachChiTietHoaDonXe(){
        return ChiTietHoaDonXeDAO.getInstance().danhSachChiTietHoaDonXe();
    }
    
    public boolean insert(ChiTietHoaDonXe model){
        return ChiTietHoaDonXeDAO.getInstance().insert(model);
    }
    
    public boolean update(ChiTietHoaDonXe model){
        return ChiTietHoaDonXeDAO.getInstance().update(model);
    }
    
    public boolean delete(String model){
        return ChiTietHoaDonXeDAO.getInstance().delete(model);
    }
    
}

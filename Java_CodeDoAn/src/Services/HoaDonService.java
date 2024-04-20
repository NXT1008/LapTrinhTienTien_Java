/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Models.HoaDon;
import DAO.HoaDonDAO;
import java.util.List;

/**
 *
 * @author WIN 10
 */
public class HoaDonService {
    private static HoaDonService instance;

    public static HoaDonService getInstance() {
        if (instance == null)
            instance = new HoaDonService();
        return instance;
    }
    
    public List<HoaDon> danhSachHoaDon(){
        return HoaDonDAO.getInstance().danhSachHoaDon();
    }
    
    public HoaDon findOne(String maHD){
        return HoaDonDAO.getInstance().findOne(maHD);
    }
    
    public boolean insert(HoaDon model){
        return HoaDonDAO.getInstance().insert(model);
    }
    
    public boolean update(HoaDon model){
        return HoaDonDAO.getInstance().update(model);
    }
    
    public boolean delete(String model){
        return HoaDonDAO.getInstance().delete(model);
    }
}

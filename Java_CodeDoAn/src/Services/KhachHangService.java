/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import Models.KhachHang;
import DAO.KhachHangDAO;
import java.util.List;
/**
 *
 * @author WIN 10
 */
public class KhachHangService {
    private static KhachHangService instance;

    public static KhachHangService getInstance() {
        if (instance == null)
            instance = new KhachHangService();
        return instance;
    }
    
    public List<KhachHang> danhSachKhachHang(){
        return KhachHangDAO.getInstance().danhSachKhachHang();
    }
    
    public List<String> listMaKhachHang(){
        return KhachHangDAO.getInstance().listMaKhachHang();
    }
    
    public KhachHang findOne(String maKH){
        return KhachHangDAO.getInstance().findOne(maKH);
    }
    
    public boolean insert(KhachHang model){
        return KhachHangDAO.getInstance().insert(model);
    }
    
    public boolean update(KhachHang model){
        return KhachHangDAO.getInstance().update(model);
    }
    
    public boolean delete(String model){
        return KhachHangDAO.getInstance().delete(model);
    }
}

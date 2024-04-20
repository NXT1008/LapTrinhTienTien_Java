/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import Models.PhieuNhap;
import DAO.PhieuNhapDAO;
import java.util.List;
/**
 *
 * @author WIN 10
 */
public class PhieuNhapService {
    private static PhieuNhapService instance;

    public static PhieuNhapService getInstance() {
        if (instance == null)
            instance = new PhieuNhapService();
        return instance;
    }
    
    public List<PhieuNhap> danhSachPhieuNhap(){
        return PhieuNhapDAO.getInstance().danhSachPhieuNhap();
    }
    
    public PhieuNhap findOne(String maPN){
        return PhieuNhapDAO.getInstance().findOne(maPN);
    }
    
    public boolean insert(PhieuNhap model){
        return PhieuNhapDAO.getInstance().insert(model);
    }
    
    public boolean update(PhieuNhap model){
        return PhieuNhapDAO.getInstance().update(model);
    }
    
    public boolean delete(String model){
        return PhieuNhapDAO.getInstance().delete(model);
    }
}

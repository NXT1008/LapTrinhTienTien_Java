/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import Models.PhieuBaoDuong;
import DAO.PhieuBaoDuongDAO;
import java.util.List;
/**
 *
 * @author WIN 10
 */
public class PhieuBaoDuongService {
    private static PhieuBaoDuongService instance;

    public static PhieuBaoDuongService getInstance() {
        if (instance == null)
            instance = new PhieuBaoDuongService();
        return instance;
    }
    
    public List<PhieuBaoDuong> danhSachPhieuBaoDuong(){
        return PhieuBaoDuongDAO.getInstance().danhSachPhieuBaoDuong();
    }
    
    public boolean insert(PhieuBaoDuong model){
        return PhieuBaoDuongDAO.getInstance().insert(model);
    }
    
    public boolean update(PhieuBaoDuong model){
        return PhieuBaoDuongDAO.getInstance().update(model);
    }
    
    public boolean delete(String model){
        return PhieuBaoDuongDAO.getInstance().delete(model);
    }
}

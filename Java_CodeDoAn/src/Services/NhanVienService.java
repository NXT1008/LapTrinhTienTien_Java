/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import Models.NhanVien;
import DAO.NhanVienDAO;
import java.util.List;
/**
 *
 * @author WIN 10
 */
public class NhanVienService {
    private static NhanVienService instance;

    public static NhanVienService getInstance() {
        if (instance == null)
            instance = new NhanVienService();
        return instance;
    }
    
    public List<NhanVien> danhSachNhanVien(){
        return NhanVienDAO.getInstance().danhSachNhanVien();
    }
    
    public boolean insert(NhanVien model){
        return NhanVienDAO.getInstance().insert(model);
    }
    
    public boolean update(NhanVien model){
        return NhanVienDAO.getInstance().update(model);
    }
    
    public boolean delete(String model){
        return NhanVienDAO.getInstance().delete(model);
    }
}

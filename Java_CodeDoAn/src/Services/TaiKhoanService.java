/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import Models.TaiKhoan;
import DAO.TaiKhoanDAO;
import java.util.List;
/**
 *
 * @author WIN 10
 */
public class TaiKhoanService {
    private static TaiKhoanService instance;

    public static TaiKhoanService getInstance() {
        if (instance == null)
            instance = new TaiKhoanService();
        return instance;
    }
    
    public List<TaiKhoan> danhSachTaiKhoan(){
        return TaiKhoanDAO.getInstance().danhSachTaiKhoan();
    }
}

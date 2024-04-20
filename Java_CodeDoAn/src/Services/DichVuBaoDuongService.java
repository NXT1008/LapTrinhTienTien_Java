/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DAO.DichVuBaoDuongDAO;
import Models.DichVuBaoDuong;
import java.util.List;

/**
 *
 * @author WIN 10
 */
public class DichVuBaoDuongService {
    private static DichVuBaoDuongService instance;

    public static DichVuBaoDuongService getInstance() {
        if (instance == null)
            instance = new DichVuBaoDuongService();
        return instance;
    }
    
    
    public List<DichVuBaoDuong> danhSachDichVuBaoDuong(){
        return DichVuBaoDuongDAO.getInstance().danhSachDichVuBaoDuong();
    }
    
    public List<String> listMaBaoDuong(){
        return DichVuBaoDuongDAO.getInstance().listMaBaoDuong();
    }
    
    public DichVuBaoDuong findOne(String maBD){
        return DichVuBaoDuongDAO.getInstance().findOne(maBD);
    }
    
    public boolean insert(DichVuBaoDuong model){
        return DichVuBaoDuongDAO.getInstance().insert(model);
    }
    
    public boolean update(DichVuBaoDuong model){
        return DichVuBaoDuongDAO.getInstance().update(model);
    }
    
    public boolean delete(String model){
        return DichVuBaoDuongDAO.getInstance().delete(model);
    }
}

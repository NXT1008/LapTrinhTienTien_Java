/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DAO.ChiTietPhieuBaoDuongDAO;
import Models.ChiTietPhieuBaoDuong;
import java.util.List;

/**
 *
 * @author WIN 10
 */
public class ChiTietPhieuBaoDuongService {
    private static ChiTietPhieuBaoDuongService instance;

    public static ChiTietPhieuBaoDuongService getInstance() {
        if (instance == null)
            instance = new ChiTietPhieuBaoDuongService();
        return instance;
    }
    
    public List<ChiTietPhieuBaoDuong> danhSachPhieuBaoDuong(){
        return ChiTietPhieuBaoDuongDAO.getInstance().danhSachPhieuBaoDuong();
    }
    
    public boolean insert(ChiTietPhieuBaoDuong model){
        return ChiTietPhieuBaoDuongDAO.getInstance().insert(model);
    }
    
    public boolean update(ChiTietPhieuBaoDuong model){
        return ChiTietPhieuBaoDuongDAO.getInstance().update(model);
    }
    
    public boolean delete(String model){
        return ChiTietPhieuBaoDuongDAO.getInstance().delete(model);
    }
}

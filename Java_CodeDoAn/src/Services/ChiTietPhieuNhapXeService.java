/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Models.ChiTietPhieuNhapXe;
import DAO.ChiTietPhieuNhapXeDAO;
import java.util.List;

/**
 *
 * @author WIN 10
 */
public class ChiTietPhieuNhapXeService {
    private static ChiTietPhieuNhapXeService instance;

    public static ChiTietPhieuNhapXeService getInstance() {
        if (instance == null)
            instance = new ChiTietPhieuNhapXeService();
        return instance;
    }
    
    public List<ChiTietPhieuNhapXe> danhSachPhieuNhapXe(){
        return ChiTietPhieuNhapXeDAO.getInstance().danhSachPhieuNhapXe();
    }
    
    public boolean insert(ChiTietPhieuNhapXe model){
        return ChiTietPhieuNhapXeDAO.getInstance().insert(model);
    }
    
    public boolean update(ChiTietPhieuNhapXe model){
        return ChiTietPhieuNhapXeDAO.getInstance().update(model);
    }
    
    public boolean delete(String model){
        return ChiTietPhieuNhapXeDAO.getInstance().delete(model);
    }
}

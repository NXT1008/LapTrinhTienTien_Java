/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DAO.ChiNhanhDAO;
import Models.ChiNhanh;
import java.util.List;

/**
 *
 * @author WIN 10
 */
public class ChiNhanhService {
    
    private static ChiNhanhService instance;

    public static ChiNhanhService getInstance() {
        if (instance == null)
            instance = new ChiNhanhService();
        return instance;
    }
    
    
    public List<ChiNhanh> danhSachChiNhanh(){
        return ChiNhanhDAO.getInstance().danhSachChiNhanh();
    }
    
    public List<String> listMaChiNhanh(){
        return ChiNhanhDAO.getInstance().listMaChiNhanh();
    }
    
    public ChiNhanh findOne(String macn){
        return ChiNhanhDAO.getInstance().findOne(macn);
    }
    
    public boolean insert(ChiNhanh cn){
        return ChiNhanhDAO.getInstance().insert(cn);
    }
    
    public boolean update(ChiNhanh cn){
        return ChiNhanhDAO.getInstance().update(cn);
    }
    
    public boolean delete(String ma){
        return ChiNhanhDAO.getInstance().delete(ma);
    }
    
}

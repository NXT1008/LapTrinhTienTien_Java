/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import Models.NhaCungCap;
import DAO.NhaCungCapDAO;
import java.util.List;
/**
 *
 * @author WIN 10
 */
public class NhaCungCapService {
    private static NhaCungCapService instance;

    public static NhaCungCapService getInstance() {
        if (instance == null)
            instance = new NhaCungCapService();
        return instance;
    }
    
    public List<NhaCungCap> danhSachNhaCungCap(){
        return NhaCungCapDAO.getInstance().danhSachNhaCungCap();
    }
    
    public List<String> listMaNhaCungCap(){
        return NhaCungCapDAO.getInstance().listMaNhaCungCap();
    }
    
    public NhaCungCap findOne(String maNCC){
        return NhaCungCapDAO.getInstance().findOne(maNCC);
    }
    
    public boolean insert(NhaCungCap model){
        return NhaCungCapDAO.getInstance().insert(model);
    }
    
    public boolean update(NhaCungCap model){
        return NhaCungCapDAO.getInstance().update(model);
    }
    
    public boolean delete(String model){
        return NhaCungCapDAO.getInstance().delete(model);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import Models.Xe;
import DAO.XeDAO;
import java.util.List;
/**
 *
 * @author WIN 10
 */
public class XeService {
    private static XeService instance;

    public static XeService getInstance() {
        if (instance == null)
            instance = new XeService();
        return instance;
    }
    
    public List<Xe> danhSachXe(){
        return XeDAO.getInstance().danhSachXe();
    }
    
    public boolean insert(Xe model){
        return XeDAO.getInstance().insert(model);
    }
    
    public boolean update(Xe model){
        return XeDAO.getInstance().update(model);
    }
    
    public boolean delete(String model){
        return XeDAO.getInstance().delete(model);
    }
}

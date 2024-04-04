/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import Models.KhoXe;
import DAO.KhoXeDAO;
import java.util.List;
/**
 *
 * @author WIN 10
 */
public class KhoXeService {
    private static KhoXeService instance;

    public static KhoXeService getInstance() {
        if (instance == null)
            instance = new KhoXeService();
        return instance;
    }
    
    public List<KhoXe> danhSachKhoXe(){
        return KhoXeDAO.getInstance().danhSachKhoXe();
    }
}

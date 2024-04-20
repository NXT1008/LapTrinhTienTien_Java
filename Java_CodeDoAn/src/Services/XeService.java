
package Services;
import Models.Xe;
import DAO.XeDAO;
import java.util.List;

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
    
    public List<String> listMaXe(){
        return XeDAO.getInstance().listMaXe();
    }
    
    public Xe findOne(String maXe){
        return XeDAO.getInstance().findOne(maXe);
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

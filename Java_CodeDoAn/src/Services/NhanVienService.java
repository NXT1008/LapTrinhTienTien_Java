
package Services;
import Models.NhanVien;
import DAO.NhanVienDAO;
import java.util.List;

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
    
    public NhanVien findOne(String maNV){
        return NhanVienDAO.getInstance().findOne(maNV);
    }
    
    public List<String> listMaNhanVien(){
        return NhanVienDAO.getInstance().listMaNhanVien();
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
    
    public boolean checkSameCCCD(String CCCD){
        // Same -> True
        return (NhanVienDAO.getInstance().findByCCCD(CCCD) != null);
    }
    
//    public static void main(String[] args) {
//        java.sql.Date date = null;
//        try {
//            Date d = new SimpleDateFormat("dd/MM/yyyy").parse("10/08/2003");
//            date = new java.sql.Date(d.getTime());
//        } catch (Exception e) {
//        }
//        NhanVien nv = new NhanVien("a", "1", "1",date, "1", "1","a", "1", true,"CNHN", "1");
//        boolean res = NhanVienService.getInstance().insert(nv);
//        if (res){
//            System.out.println("OK");
//        }
//        else{
//            System.out.println("Cancel");
//        }
//    }
}

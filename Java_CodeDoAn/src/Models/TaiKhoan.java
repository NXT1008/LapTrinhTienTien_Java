
package Models;
import java.sql.*;

public class TaiKhoan {
    private String tenDangNhap;
    private String matKhau;
    private String maNhanVien; // dùng để đăng ký
    private boolean isAdmin;

    public TaiKhoan(String tenDangNhap, String matKhau, String maNhanVien, boolean isAdmin) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.maNhanVien = maNhanVien;
        this.isAdmin = isAdmin;
    }
    
    public TaiKhoan(ResultSet resultSet) throws SQLException {
        tenDangNhap = resultSet.getString("tenDangNhap");
        matKhau = resultSet.getString("matKhau");
        maNhanVien = resultSet.getString("maNhanVien");
    }
    
    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}

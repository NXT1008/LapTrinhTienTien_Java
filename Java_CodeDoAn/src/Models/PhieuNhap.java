package Models;

import java.util.Date;
import java.sql.*;

public class PhieuNhap {

    private String maPhieuNhap;
    private String maXe;
    private Date ngayNhap;
    private long giaNhap;
    private int soLuong;
    private String maNhaCungCap;
    private String maChiNhanh;

    public PhieuNhap(String maPhieuNhap, String maXe, Date ngayNhap, long giaNhap, int soLuong, String maNhaCungCap, String maChiNhanh) {
        this.maPhieuNhap = maPhieuNhap;
        this.maXe = maXe;
        this.ngayNhap = ngayNhap;
        this.giaNhap = giaNhap;
        this.soLuong = soLuong;
        this.maNhaCungCap = maNhaCungCap;
        this.maChiNhanh = maChiNhanh;
    }

    public PhieuNhap(ResultSet rs) throws SQLException {
        this.maPhieuNhap = rs.getString("maPhieuNhap");
        this.maXe = rs.getString("maXe");
        this.ngayNhap = rs.getDate("ngayNhap");
        this.giaNhap = rs.getLong("giaNhap");
        this.soLuong = rs.getInt("soLuong");
        this.maNhaCungCap = rs.getString("maNhaCungCap");
        this.maChiNhanh = rs.getString("maChiNhanh");
    }

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public String getMaChiNhanh() {
        return maChiNhanh;
    }

    public void setMaChiNhanh(String maChiNhanh) {
        this.maChiNhanh = maChiNhanh;
    }

    public String getMaXe() {
        return maXe;
    }

    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }

    public long getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(long giaNhap) {
        this.giaNhap = giaNhap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    @Override
    public String toString() {
        return "PhieuNhap{" + "maPhieuNhap=" + maPhieuNhap + ", ngayNhap=" + ngayNhap + ", maNhaCungCap=" + maNhaCungCap + ", maChiNhanh=" + maChiNhanh + '}';
    }

}

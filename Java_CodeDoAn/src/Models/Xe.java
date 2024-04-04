/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;
import java.sql.*;
/**
 *
 * @author WIN 10
 */
public class Xe {
    private String maXe;
    private String tenXe;
    private String mauSac;
    private float giaBan;
    private int soChoNgoi;
    private String xuatXu;
    private String hangXe;
    private String loaiXe;
    private String phienBanXe;
    private int trongLuong;
    private String loaiNhienLieu;
    private int congSuatDongCo;
    private int dungTichDongCo;
    private String loaiDongCo;
    private int khoangSangGam;
    private int chieuDai;
    private int chieuRong;
    private int chieuCao;
    private String hinhAnh;

    public Xe(ResultSet resultSet) throws SQLException {
        this.maXe = resultSet.getString("maXe");
        this.tenXe = resultSet.getString("tenXe");
        this.mauSac = resultSet.getString("mauSac");
        this.giaBan = resultSet.getFloat("giaBan");
        this.soChoNgoi = resultSet.getInt("soChoNgoi");
        this.xuatXu = resultSet.getString("xuatXu");
        this.hangXe = resultSet.getString("hangXe");
        this.loaiXe = resultSet.getString("loaiXe");
        this.phienBanXe = resultSet.getString("phienBanXe");
        this.trongLuong = resultSet.getInt("trongLuong");
        this.loaiNhienLieu = resultSet.getString("loaiNhienLieu");
        this.congSuatDongCo = resultSet.getInt("congSuatDongCo");
        this.dungTichDongCo = resultSet.getInt("dungTichDongCo");
        this.loaiDongCo = resultSet.getString("loaiDongCo");
        this.khoangSangGam = resultSet.getInt("khoangSangGam");
        this.chieuDai = resultSet.getInt("chieuDai");
        this.chieuRong = resultSet.getInt("chieuRong");
        this.chieuCao = resultSet.getInt("chieuCao");
        this.hinhAnh = resultSet.getString("hinhAnh");
    }
    
    public String getMaXe() {
        return maXe;
    }

    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public String getHangXe() {
        return hangXe;
    }

    public void setHangXe(String hangXe) {
        this.hangXe = hangXe;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

    public String getPhienBanXe() {
        return phienBanXe;
    }

    public void setPhienBanXe(String phienBanXe) {
        this.phienBanXe = phienBanXe;
    }

    public int getTrongLuong() {
        return trongLuong;
    }

    public void setTrongLuong(int trongLuong) {
        this.trongLuong = trongLuong;
    }

    public String getLoaiNhienLieu() {
        return loaiNhienLieu;
    }

    public void setLoaiNhienLieu(String loaiNhienLieu) {
        this.loaiNhienLieu = loaiNhienLieu;
    }

    public int getCongSuatDongCo() {
        return congSuatDongCo;
    }

    public void setCongSuatDongCo(int congSuatDongCo) {
        this.congSuatDongCo = congSuatDongCo;
    }

    public int getDungTichDongCo() {
        return dungTichDongCo;
    }

    public void setDungTichDongCo(int dungTichDongCo) {
        this.dungTichDongCo = dungTichDongCo;
    }

    public String getLoaiDongCo() {
        return loaiDongCo;
    }

    public void setLoaiDongCo(String loaiDongCo) {
        this.loaiDongCo = loaiDongCo;
    }

    public int getKhoangSangGam() {
        return khoangSangGam;
    }

    public void setKhoangSangGam(int khoangSangGam) {
        this.khoangSangGam = khoangSangGam;
    }

    public int getChieuDai() {
        return chieuDai;
    }

    public void setChieuDai(int chieuDai) {
        this.chieuDai = chieuDai;
    }

    public int getChieuRong() {
        return chieuRong;
    }

    public void setChieuRong(int chieuRong) {
        this.chieuRong = chieuRong;
    }

    public int getChieuCao() {
        return chieuCao;
    }

    public void setChieuCao(int chieuCao) {
        this.chieuCao = chieuCao;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
    
    
}

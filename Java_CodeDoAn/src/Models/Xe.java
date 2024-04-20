/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
/**
 *
 * @author WIN 10
 */
public class Xe {
    private String maXe;
    private String tenXe;
    private String mauSac;
    private long giaBan;
    private String xuatXu;
    private String hangXe;
    private String phienBanXe;
    private int trongLuong;
    private int congSuatDongCo;
    private String loaiDongCo;
    private int chieuDai;
    private int chieuRong;
    private int chieuCao;
    private byte[] hinhAnh;

    public Xe(String tenXe, long giaBan, String xuatXu, String hangXe, byte[] hinhAnh) {
        this.tenXe = tenXe;
        this.giaBan = giaBan;
        this.xuatXu = xuatXu;
        this.hangXe = hangXe;
        this.hinhAnh = hinhAnh;
    }

    
    
    public Xe(String maXe, String tenXe, long giaBan, String xuatXu, String hangXe, int trongLuong, int congSuatDongCo, String loaiDongCo, byte[] hinhAnh) {
        this.maXe = maXe;
        this.tenXe = tenXe;
        this.giaBan = giaBan;
        this.xuatXu = xuatXu;
        this.hangXe = hangXe;
        this.trongLuong = trongLuong;
        this.congSuatDongCo = congSuatDongCo;
        this.loaiDongCo = loaiDongCo;
        this.hinhAnh = hinhAnh;
    }

    
    
    public Xe(String maXe, String tenXe, String mauSac, long giaBan, String xuatXu, String hangXe, String phienBanXe, int trongLuong, int congSuatDongCo, String loaiDongCo, int chieuDai, int chieuRong, int chieuCao, byte[] hinhAnh) {
        this.maXe = maXe;
        this.tenXe = tenXe;
        this.mauSac = mauSac;
        this.giaBan = giaBan;
        this.xuatXu = xuatXu;
        this.hangXe = hangXe;
        this.phienBanXe = phienBanXe;
        this.trongLuong = trongLuong;
        this.congSuatDongCo = congSuatDongCo;
        this.loaiDongCo = loaiDongCo;
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
        this.chieuCao = chieuCao;
        this.hinhAnh = hinhAnh;
    }
    
    public Xe(ResultSet resultSet) throws SQLException {
        this.maXe = resultSet.getString("maXe");
        this.tenXe = resultSet.getString("tenXe");
        this.mauSac = resultSet.getString("mauSac");
        this.giaBan = resultSet.getLong("giaBan");
        this.xuatXu = resultSet.getString("xuatXu");
        this.hangXe = resultSet.getString("hangXe");
        this.phienBanXe = resultSet.getString("phienBanXe");
        this.trongLuong = resultSet.getInt("trongLuong");
        this.congSuatDongCo = resultSet.getInt("congSuatDongCo");
        this.loaiDongCo = resultSet.getString("loaiDongCo");
        this.chieuDai = resultSet.getInt("chieuDai");
        this.chieuRong = resultSet.getInt("chieuRong");
        this.chieuCao = resultSet.getInt("chieuCao");
        
        InputStream inputStream = resultSet.getBinaryStream("hinhAnh");
        if (inputStream == null){
            this.hinhAnh = null;
        }
        else{
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead;
        try {
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            byte[] data = outputStream.toByteArray();
            this.hinhAnh = data;
        } catch (IOException e) {
            this.hinhAnh = null;
        }
        }
        
        
        //this.hinhAnh = resultSet.getString("hinhAnh");
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

    public long getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(long giaBan) {
        this.giaBan = giaBan;
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

    public int getCongSuatDongCo() {
        return congSuatDongCo;
    }

    public void setCongSuatDongCo(int congSuatDongCo) {
        this.congSuatDongCo = congSuatDongCo;
    }

    public String getLoaiDongCo() {
        return loaiDongCo;
    }

    public void setLoaiDongCo(String loaiDongCo) {
        this.loaiDongCo = loaiDongCo;
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

    public byte[] getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(byte[] hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    @Override
    public String toString() {
        return "Xe{" + "maXe=" + maXe + ", tenXe=" + tenXe + ", mauSac=" + mauSac + ", giaBan=" + giaBan + ", xuatXu=" + xuatXu + ", hangXe=" + hangXe + ", phienBanXe=" + phienBanXe + ", trongLuong=" + trongLuong + ", congSuatDongCo=" + congSuatDongCo + ", loaiDongCo=" + loaiDongCo + ", chieuDai=" + chieuDai + ", chieuRong=" + chieuRong + ", chieuCao=" + chieuCao + ", hinhAnh=" + hinhAnh + '}';
    }
    
    
    
}

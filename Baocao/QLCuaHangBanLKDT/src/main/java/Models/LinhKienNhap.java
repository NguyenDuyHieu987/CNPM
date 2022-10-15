/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ddom6
 */
public class LinhKienNhap {

    private String MaNhap;
    private String MaLK;
    private int SoLuong;
    private double GiaNhap;
    private double TongTien;
    private String NgayNhap;
    private String NguonNhap;
    private String NguoiNhap;

    public LinhKienNhap() {
    }

    public LinhKienNhap(String MaNhap, String MaLK, int SoLuong, double GiaNhap, double TongTien, String NgayNhap, String NguonNhap, String NguoiNhap) {
        this.MaNhap = MaNhap;
        this.MaLK = MaLK;
        this.SoLuong = SoLuong;
        this.GiaNhap = GiaNhap;
        this.TongTien = TongTien;
        this.NgayNhap = NgayNhap;
        this.NguonNhap = NguonNhap;
        this.NguoiNhap = NguoiNhap;
    }

    public String getMaNhap() {
        return MaNhap;
    }

    public void setMaNhap(String MaNhap) {
        this.MaNhap = MaNhap;
    }

    public String getMaLK() {
        return MaLK;
    }

    public void setMaLK(String MaLK) {
        this.MaLK = MaLK;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(double GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public String getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(String NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public String getNguonNhap() {
        return NguonNhap;
    }

    public void setNguonNhap(String NguonNhap) {
        this.NguonNhap = NguonNhap;
    }

    public String getNguoiNhap() {
        return NguoiNhap;
    }

    public void setNguoiNhap(String NguoiNhap) {
        this.NguoiNhap = NguoiNhap;
    }

}

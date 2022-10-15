/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ddom6
 */
public class HoaDon {

    private String MaHD;
    private String MaLK;
    private String TenLK;
    private int SoLuong;
    private double DonGia;
    private double TongTien;
    private String NgayMua;
    private String HanBaoHanh;
    private String HinhThuc;
    private String MaGiamGia;

    public HoaDon() {
    }

    public HoaDon(String MaHD, String MaLK, String TenLK, int SoLuong, double DonGia, double TongTien, String NgayMua, String HanBaoHanh, String HinhThuc, String MaGiamGia) {
        this.MaHD = MaHD;
        this.MaLK = MaLK;
        this.TenLK = TenLK;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.TongTien = TongTien;
        this.NgayMua = NgayMua;
        this.HanBaoHanh = HanBaoHanh;
        this.HinhThuc = HinhThuc;
        this.MaGiamGia = MaGiamGia;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaLK() {
        return MaLK;
    }

    public void setMaLK(String MaLK) {
        this.MaLK = MaLK;
    }

    public String getTenLK() {
        return TenLK;
    }

    public void setTenLK(String TenLK) {
        this.TenLK = TenLK;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getDonGia() {
        return DonGia;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public String getNgayMua() {
        return NgayMua;
    }

    public void setNgayMua(String NgayMua) {
        this.NgayMua = NgayMua;
    }

    public String getHanBaoHanh() {
        return HanBaoHanh;
    }

    public void setHanBaoHanh(String HanBaoHanh) {
        this.HanBaoHanh = HanBaoHanh;
    }

    public String getHinhThuc() {
        return HinhThuc;
    }

    public void setHinhThuc(String HinhThuc) {
        this.HinhThuc = HinhThuc;
    }

    public String getMaGiamGia() {
        return MaGiamGia;
    }

    public void setMaGiamGia(String MaGiamGia) {
        this.MaGiamGia = MaGiamGia;
    }

}

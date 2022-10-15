/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ddom6
 */
public class LinhKien {

    private String MaLK;
    private String TenLK;
    private String Loai;
    private String HanBaoHanh;
    private String Hang;
    private int SoLuong;
    private double GiaBan;

    public LinhKien() {
    }

    public LinhKien(String MaLK, String TenLK, String Loai, String HanBaoHanh, String Hang, int SoLuong, double GiaBan) {
        this.MaLK = MaLK;
        this.TenLK = TenLK;
        this.Loai = Loai;
        this.HanBaoHanh = HanBaoHanh;
        this.Hang = Hang;
        this.SoLuong = SoLuong;
        this.GiaBan = GiaBan;
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

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String Loai) {
        this.Loai = Loai;
    }

    public String getHanBaoHanh() {
        return HanBaoHanh;
    }

    public void setHanBaoHanh(String HanBaoHanh) {
        this.HanBaoHanh = HanBaoHanh;
    }

    public String getHang() {
        return Hang;
    }

    public void setHang(String Hang) {
        this.Hang = Hang;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(double GiaBan) {
        this.GiaBan = GiaBan;
    }

}

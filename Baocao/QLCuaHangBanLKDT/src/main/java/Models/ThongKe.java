/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ADMIN
 */
public class ThongKe {

    private String MaThongKe;
    private String TenThongKe;
    private String GhiChu;
    private double TongTien;

    public ThongKe() {
    }

    public ThongKe(String MaThongKe, String TenThongKe, String GhiChu, double TongTien) {
        this.MaThongKe = MaThongKe;
        this.TenThongKe = TenThongKe;
        this.GhiChu = GhiChu;
        this.TongTien = TongTien;
    }

    public String getMaThongKe() {
        return MaThongKe;
    }

    public void setMaThongKe(String MaThongKe) {
        this.MaThongKe = MaThongKe;
    }

    public String getTenThongKe() {
        return TenThongKe;
    }

    public void setTenThongKe(String TenThongKe) {
        this.TenThongKe = TenThongKe;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

}

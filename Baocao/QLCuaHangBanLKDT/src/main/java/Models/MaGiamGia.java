/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ddom6
 */
public class MaGiamGia {

    private String MaGiamGia;
    private String Ten;
    private int PhanTram;
    private String HieuLuc;

    public MaGiamGia() {
    }

    public MaGiamGia(String MaGiamGia, String Ten, int PhanTram, String HieuLuc) {
        this.MaGiamGia = MaGiamGia;
        this.Ten = Ten;
        this.PhanTram = PhanTram;
        this.HieuLuc = HieuLuc;
    }

    public String getMaGiamGia() {
        return MaGiamGia;
    }

    public void setMaGiamGia(String MaGiamGia) {
        this.MaGiamGia = MaGiamGia;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public int getPhanTram() {
        return PhanTram;
    }

    public void setPhanTram(int PhanTram) {
        this.PhanTram = PhanTram;
    }

    public String getHieuLuc() {
        return HieuLuc;
    }

    public void setHieuLuc(String HieuLuc) {
        this.HieuLuc = HieuLuc;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ddom6
 */
public class ThongTinDangNhap {

    private String TaiKhoan;
    private String MatKhau;
    private String Quyen;

    public ThongTinDangNhap(String TaiKhoan, String MatKhau, String Quyen) {

        this.TaiKhoan = TaiKhoan;
        this.MatKhau = MatKhau;
        this.Quyen = Quyen;
    }

    public ThongTinDangNhap() {
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String TaiKhoan) {
        this.TaiKhoan = TaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getQuyen() {
        return Quyen;
    }

    public void setQuyen(String Quyen) {
        this.Quyen = Quyen;
    }

}

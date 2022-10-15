/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Database.ConnectDB;
import Models.ThongTinDangNhap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ddom6
 */
public class DangNhapController {

    public boolean DangNhapHeThong(String Taikhoan, String Matkhau) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT COUNT(*) FROM DangNhap WHERE TaiKhoan = ? AND MatKhau = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, Taikhoan);
            preparedStatement.setString(2, Matkhau);

            ResultSet rs = preparedStatement.executeQuery();
            int kt = 0;
            while (rs.next()) {
                kt = rs.getInt(1);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            if (kt == 1) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return false;

    }

    public boolean ThemTaiKhoan(ThongTinDangNhap thongTinDangNhap) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "INSERT INTO DangNhap(TaiKhoan, MatKhau, Quyen, NhoMatKhau) VALUES\n"
                    + "(?, ?, ?, ?);";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, thongTinDangNhap.getTaiKhoan());
            preparedStatement.setString(2, thongTinDangNhap.getMatKhau());
            preparedStatement.setString(3, thongTinDangNhap.getQuyen());
            preparedStatement.setInt(4, 0);

            int kt = preparedStatement.executeUpdate();

            conn.commit();
            conn.setAutoCommit(true);
            conn.close();

            if (kt == 1) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return false;

    }

    public List<ThongTinDangNhap> GetAllAccount() {
        List<ThongTinDangNhap> listtThongTinDangNhaps = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM DangNhap";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ThongTinDangNhap thongTinDangNhap = new ThongTinDangNhap();
                thongTinDangNhap.setTaiKhoan(rs.getString("TaiKhoan"));
                thongTinDangNhap.setMatKhau(rs.getString("MatKhau"));
                thongTinDangNhap.setQuyen(rs.getString("Quyen"));

                listtThongTinDangNhaps.add(thongTinDangNhap);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return listtThongTinDangNhaps;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public List<ThongTinDangNhap> SearchTaiKhoan(String TK) {
        List<ThongTinDangNhap> listtThongTinDangNhaps = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM DangNhap WHERE TaiKhoan = ?;";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, TK);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ThongTinDangNhap thongTinDangNhap = new ThongTinDangNhap();
                thongTinDangNhap.setTaiKhoan(rs.getString("TaiKhoan"));
                thongTinDangNhap.setMatKhau(rs.getString("MatKhau"));
                thongTinDangNhap.setQuyen(rs.getString("Quyen"));

                listtThongTinDangNhaps.add(thongTinDangNhap);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return listtThongTinDangNhaps;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public boolean UpdateAccount(ThongTinDangNhap thongTinDangNhap, String MK, String MKUpdate) {

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "UPDATE DangNhap SET TaiKhoan = ? , MatKhau = ?, Quyen = ? WHERE  TaiKhoan = ? AND MatKhau = ?;";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, thongTinDangNhap.getTaiKhoan());
            preparedStatement.setString(2, MKUpdate);
            preparedStatement.setString(3, thongTinDangNhap.getQuyen());
            preparedStatement.setString(4, thongTinDangNhap.getTaiKhoan());
            preparedStatement.setString(5, MK);

            int kt = preparedStatement.executeUpdate();

            conn.commit();
            conn.setAutoCommit(true);
            conn.close();

            if (kt == 1) {
                return true;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return false;

    }

    public boolean ChangPassword(String TK, String OldMK, String NewMK) {

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "UPDATE DangNhap SET MatKhau = ?  WHERE TaiKhoan = ? AND MatKhau = ?;";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, NewMK);
            preparedStatement.setString(2, TK);
            preparedStatement.setString(3, OldMK);

            int kt = preparedStatement.executeUpdate();

            conn.commit();
            conn.setAutoCommit(true);
            conn.close();

            if (kt == 1) {
                return true;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return false;

    }

    public boolean DeleteAccount(String TK, String MK) {

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "DELETE FROM DangNhap WHERE TaiKhoan = ? AND MatKhau = ?;";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, TK);
            preparedStatement.setString(2, MK);

            int kt = preparedStatement.executeUpdate();

            conn.commit();
            conn.setAutoCommit(true);
            conn.close();

            if (kt == 1) {
                return true;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return false;

    }

    public void UpdateRememberAccount(String Taikhoan, String Matkhau, int isSelected) {

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "UPDATE DangNhap SET NhoMatKhau = ? WHERE TaiKhoan = ? AND MatKhau = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setInt(1, isSelected);
            preparedStatement.setString(2, Taikhoan);
            preparedStatement.setString(3, Matkhau);

            preparedStatement.executeUpdate();

            conn.commit();
            conn.setAutoCommit(true);
            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
    }

    public void UpdateRemainAccount(String Taikhoan, String Matkhau) {

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "UPDATE DangNhap SET NhoMatKhau = 0 WHERE TaiKhoan != ? AND MatKhau != ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, Taikhoan);
            preparedStatement.setString(2, Matkhau);

            preparedStatement.executeUpdate();

            conn.commit();
            conn.setAutoCommit(true);
            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
    }

    public ThongTinDangNhap GetRememberAccount() {
        ThongTinDangNhap thongTinDangNhap = new ThongTinDangNhap();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT TaiKhoan, MatKhau FROM DangNhap WHERE NhoMatKhau = 1";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                thongTinDangNhap.setTaiKhoan(rs.getString("TaiKhoan"));
                thongTinDangNhap.setMatKhau(rs.getString("MatKhau"));
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            if (thongTinDangNhap.getTaiKhoan() == null || thongTinDangNhap.getMatKhau() == null) {
                return null;

            }
            return thongTinDangNhap;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }

        return null;
    }

    public String GetRoleCurrentAcount(String TK, String MK) {
        ThongTinDangNhap thongTinDangNhap = new ThongTinDangNhap();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT Quyen FROM DangNhap WHERE TaiKhoan = ? AND MatKhau = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, TK);
            preparedStatement.setString(2, MK);

            ResultSet rs = preparedStatement.executeQuery();

            String check = "";
            while (rs.next()) {
                check = rs.getString("Quyen");
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return check;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }

        return null;
    }
}

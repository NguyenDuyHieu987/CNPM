/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Database.ConnectDB;
import Models.ThongKe;
import Models.HoaDon;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class ThongKeController {

    public double ThongKeDoanhThu_Thang(int Month, int MonthEnd, int Year, int YearEnd) {
        try {
            Connection conn = ConnectDB.GetConnection();

            conn.setAutoCommit(false);
            CallableStatement cs = conn.prepareCall("{CALL Select_TongDoanhThu_Thang(?, ?, ?, ?)}");
            cs.setInt(1, Month);
            cs.setInt(2, MonthEnd);
            cs.setInt(3, Year);
            cs.setInt(4, YearEnd);

            ResultSet rs = cs.executeQuery();
            double DoanhThu = 0;
            while (rs.next()) {
                DoanhThu = rs.getFloat(1);
            }

            conn.commit();
            conn.setAutoCommit(true);
            conn.close();

            return DoanhThu;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return 0;

    }

    public double ThongKeDoanhThu_Nam(int Year, int YearEnd) {
        try {
            Connection conn = ConnectDB.GetConnection();

            conn.setAutoCommit(false);
            CallableStatement cs = conn.prepareCall("{CALL Select_TongDoanhThu_Nam(?, ?)}");
            cs.setInt(1, Year);
            cs.setInt(2, YearEnd);

            ResultSet rs = cs.executeQuery();
            double DoanhThu = 0;
            while (rs.next()) {
                DoanhThu = rs.getFloat(1);
            }

            conn.commit();
            conn.setAutoCommit(true);
            conn.close();

            return DoanhThu;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return 0;

    }

    public double ThongKeChiTieu_Thang(int Month, int MonthEnd, int Year, int YearEnd) {
        try {
            Connection conn = ConnectDB.GetConnection();

            conn.setAutoCommit(false);
            CallableStatement cs = conn.prepareCall("{CALL Select_TongChiTieu_Thang(?, ?, ?, ?)}");
            cs.setInt(1, Month);
            cs.setInt(2, MonthEnd);
            cs.setInt(3, Year);
            cs.setInt(4, YearEnd);

            ResultSet rs = cs.executeQuery();
            double DoanhThu = 0;
            while (rs.next()) {
                DoanhThu = rs.getFloat(1);
            }

            conn.commit();
            conn.setAutoCommit(true);
            conn.close();

            return DoanhThu;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return 0;

    }

    public double ThongKeChiTieu_Nam(int Year, int YearEnd) {
        try {
            Connection conn = ConnectDB.GetConnection();

            conn.setAutoCommit(false);
            CallableStatement cs = conn.prepareCall("{CALL Select_TongChiTieu_Nam(?, ?)}");
            cs.setInt(1, Year);
            cs.setInt(2, YearEnd);

            ResultSet rs = cs.executeQuery();
            double DoanhThu = 0;
            while (rs.next()) {
                DoanhThu = rs.getFloat(1);
            }

            conn.commit();
            conn.setAutoCommit(true);
            conn.close();

            return DoanhThu;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return 0;

    }

    public boolean ThemThongKe(ThongKe thongKe) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "INSERT INTO ThongKe (MaThongKe, TenThongKe, GhiChu, TongTien) VALUES"
                    + "(?, ?, ?, ?)";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, thongKe.getMaThongKe());
            preparedStatement.setString(2, thongKe.getTenThongKe());
            preparedStatement.setString(3, thongKe.getGhiChu());
            preparedStatement.setDouble(4, thongKe.getTongTien());

            int kt = preparedStatement.executeUpdate();

            conn.commit();
            conn.setAutoCommit(true);
            conn.close();

            if (kt > 0) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return false;

    }

    public boolean SuaThongKe(ThongKe thongKe) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "UPDATE ThongKe SET TenThongKe = ?, GhiChu = ? WHERE MaThongKe =?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, thongKe.getTenThongKe());
            preparedStatement.setString(2, thongKe.getGhiChu());
            preparedStatement.setString(3, thongKe.getMaThongKe());

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

    public boolean XoaThongKe(String MaThongKe) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "DELETE FROM ThongKe WHERE MaThongKe = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, MaThongKe);

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

    public List<ThongKe> GetAllThongKe() {
        List<ThongKe> listThiThongKes = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM ThongKe";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ThongKe thongKe = new ThongKe();

                thongKe.setMaThongKe(rs.getString("MaThongKe"));
                thongKe.setTenThongKe(rs.getString("TenThongKe"));
                thongKe.setGhiChu(rs.getString("GhiChu"));
                thongKe.setTongTien(rs.getDouble("TongTien"));

                listThiThongKes.add(thongKe);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return listThiThongKes;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Database.ConnectDB;
import Models.LinhKien;
import Models.LinhKienDaBan;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ddom6
 */
public class LinhKienDaBanController {

    public boolean ThemLinhKienDaBan(LinhKienDaBan linhKienDaBan) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "INSERT INTO LinhKienDaBan (MaLK, SoLuong, TongTien) VALUES"
                    + "(?, ?, ?)";

            String SqlQueryUpdate = "UPDATE LinhKienDaBan SET SoLuong = SoLuong + ? WHERE MaLK = ?";

            String SqlQuerySelect = "SELECT MaLK FROM LinhKienDaBan";

            conn.setAutoCommit(false);

            PreparedStatement preparedStatement1 = conn.prepareStatement(SqlQuerySelect);
            ResultSet rs = preparedStatement1.executeQuery();

            List<String> listMaLK = new ArrayList<>();
            while (rs.next()) {
                String MaLKdaNhap = rs.getString("MaLK");
                listMaLK.add(MaLKdaNhap);

            }

            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            PreparedStatement preparedStatemen2 = conn.prepareStatement(SqlQueryUpdate);
            int kt = 0, kt1 = 0;
            if (!listMaLK.contains(linhKienDaBan.getMaLK())) {
                preparedStatement.setString(1, linhKienDaBan.getMaLK());
                preparedStatement.setInt(2, linhKienDaBan.getSoLuong());
                preparedStatement.setDouble(3, 0);

                kt = preparedStatement.executeUpdate();

            } else {
                preparedStatemen2.setInt(1, linhKienDaBan.getSoLuong());
                preparedStatemen2.setString(2, linhKienDaBan.getMaLK());
                kt1 = preparedStatemen2.executeUpdate();
            }

            conn.commit();
            rs.close();
            conn.setAutoCommit(true);
            conn.close();

            if (kt > 0 || kt1 > 0) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return false;
    }

    public List<LinhKienDaBan> GetAllLinhKienDaBan() {
        List<LinhKienDaBan> lisLinhKienDaBans = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT LinhKienDaBan.MaLK, TenLK, LinhKienDaBan.SoLuong, GiaBan, TongTien \n"
                    + "    FROM LinhKienDaBan, LinhKien\n"
                    + "    WHERE LinhKienDaBan.MaLK = LinhKien.MaLK";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                LinhKienDaBan linhKienDaBan = new LinhKienDaBan();

                linhKienDaBan.setMaLK(rs.getString("MaLK"));
                linhKienDaBan.setTenLK(rs.getString("TenLK"));
                linhKienDaBan.setSoLuong(rs.getInt("SoLuong"));
                linhKienDaBan.setDonGia(rs.getDouble("GiaBan"));
                linhKienDaBan.setTongTien(rs.getDouble("TongTien"));

                lisLinhKienDaBans.add(linhKienDaBan);

            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return lisLinhKienDaBans;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public List<LinhKienDaBan> GetAllLinhKienDaBan_BanChayNhat() {
        List<LinhKienDaBan> lisLinhKienDaBans = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT LinhKienDaBan.MaLK, TenLK, LinhKienDaBan.SoLuong, GiaBan, TongTien \n"
                    + "    FROM LinhKienDaBan, LinhKien\n"
                    + "    WHERE LinhKienDaBan.MaLK = LinhKien.MaLK AND LinhKienDaBan.SoLuong = (SELECT MAX(SoLuong) FROM LinhKienDaBan)";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                LinhKienDaBan linhKienDaBan = new LinhKienDaBan();

                linhKienDaBan.setMaLK(rs.getString("MaLK"));
                linhKienDaBan.setTenLK(rs.getString("TenLK"));
                linhKienDaBan.setSoLuong(rs.getInt("SoLuong"));
                linhKienDaBan.setDonGia(rs.getDouble("GiaBan"));
                linhKienDaBan.setTongTien(rs.getDouble("TongTien"));

                lisLinhKienDaBans.add(linhKienDaBan);

            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return lisLinhKienDaBans;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public List<LinhKienDaBan> GetAllLinhKienDaBan_BanItNhat() {
        List<LinhKienDaBan> lisLinhKienDaBans = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT LinhKienDaBan.MaLK, TenLK, LinhKienDaBan.SoLuong, GiaBan, TongTien \n"
                    + "    FROM LinhKienDaBan, LinhKien\n"
                    + "    WHERE LinhKienDaBan.MaLK = LinhKien.MaLK AND LinhKienDaBan.SoLuong = (SELECT MIN(SoLuong) FROM LinhKienDaBan)";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                LinhKienDaBan linhKienDaBan = new LinhKienDaBan();

                linhKienDaBan.setMaLK(rs.getString("MaLK"));
                linhKienDaBan.setTenLK(rs.getString("TenLK"));
                linhKienDaBan.setSoLuong(rs.getInt("SoLuong"));
                linhKienDaBan.setDonGia(rs.getDouble("GiaBan"));
                linhKienDaBan.setTongTien(rs.getDouble("TongTien"));

                lisLinhKienDaBans.add(linhKienDaBan);

            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return lisLinhKienDaBans;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public List<LinhKienDaBan> GetAllLinhKienDaBan_DoanhThuNhieuNhat() {
        List<LinhKienDaBan> lisLinhKienDaBans = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT LinhKienDaBan.MaLK, TenLK, LinhKienDaBan.SoLuong, GiaBan, TongTien \n"
                    + "    FROM LinhKienDaBan, LinhKien\n"
                    + "    WHERE LinhKienDaBan.MaLK = LinhKien.MaLK AND TongTien = (SELECT MAX(TongTien) FROM LinhKienDaBan)";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                LinhKienDaBan linhKienDaBan = new LinhKienDaBan();

                linhKienDaBan.setMaLK(rs.getString("MaLK"));
                linhKienDaBan.setTenLK(rs.getString("TenLK"));
                linhKienDaBan.setSoLuong(rs.getInt("SoLuong"));
                linhKienDaBan.setDonGia(rs.getDouble("GiaBan"));
                linhKienDaBan.setTongTien(rs.getDouble("TongTien"));

                lisLinhKienDaBans.add(linhKienDaBan);

            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return lisLinhKienDaBans;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public List<LinhKienDaBan> GetAllLinhKienDaBan_DoanhThuItNhat() {
        List<LinhKienDaBan> lisLinhKienDaBans = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT LinhKienDaBan.MaLK, TenLK, LinhKienDaBan.SoLuong, GiaBan, TongTien \n"
                    + "    FROM LinhKienDaBan, LinhKien\n"
                    + "    WHERE LinhKienDaBan.MaLK = LinhKien.MaLK AND TongTien = (SELECT MIN(TongTien) FROM LinhKienDaBan)";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                LinhKienDaBan linhKienDaBan = new LinhKienDaBan();

                linhKienDaBan.setMaLK(rs.getString("MaLK"));
                linhKienDaBan.setTenLK(rs.getString("TenLK"));
                linhKienDaBan.setSoLuong(rs.getInt("SoLuong"));
                linhKienDaBan.setDonGia(rs.getDouble("GiaBan"));
                linhKienDaBan.setTongTien(rs.getDouble("TongTien"));

                lisLinhKienDaBans.add(linhKienDaBan);

            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return lisLinhKienDaBans;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public boolean XoaLinhKienDaBan(String MaLK) {

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "DELETE FROM LinhKienDaBan WHERE MaLK = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, MaLK);

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
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Database.ConnectDB;
import Models.LinhKien;
import Models.LinhKienNhap;
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
public class LinhKienController {

    public boolean ThemLinhKien(LinhKien linhKien) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "INSERT INTO LinhKien (MaLK, TenLK, Loai, SoLuong, GiaBan, Hang, HanBaoHanh) VALUES"
                    + "(?, ?, ?, ?, ?, ?, ?)";

            String SqlQueryUpdate = "UPDATE LinhKien SET SoLuong = SoLuong + ? WHERE MaLK = ?";

            String SqlQuerySelect = "SELECT MaLK FROM LinhKien ";

            conn.setAutoCommit(false);
//            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

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
            if (!listMaLK.contains(linhKien.getMaLK())) {
                preparedStatement.setString(1, linhKien.getMaLK());
                preparedStatement.setString(2, linhKien.getTenLK());
                preparedStatement.setString(3, linhKien.getLoai());
                preparedStatement.setInt(4, linhKien.getSoLuong());
                preparedStatement.setDouble(5, linhKien.getGiaBan());
                preparedStatement.setString(6, linhKien.getHang());
                preparedStatement.setString(7, linhKien.getHanBaoHanh());

                kt = preparedStatement.executeUpdate();

            } else {
                preparedStatemen2.setInt(1, linhKien.getSoLuong());
                preparedStatemen2.setString(2, linhKien.getMaLK());
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

    public List<LinhKien> GetAllLinhKien() {
        List<LinhKien> líLinhKiens = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM LinhKien";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                LinhKien linhKien = new LinhKien();

                linhKien.setMaLK(rs.getString("MaLK"));
                linhKien.setTenLK(rs.getString("TenLK"));
                linhKien.setLoai(rs.getString("Loai"));
                linhKien.setSoLuong(rs.getInt("SoLuong"));
                linhKien.setGiaBan(rs.getDouble("GiaBan"));
                linhKien.setHang(rs.getString("Hang"));
                linhKien.setHanBaoHanh(rs.getString("HanBaoHanh"));

                líLinhKiens.add(linhKien);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return líLinhKiens;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public List<LinhKien> SearchLinhKien_Loai(String Loai) {
        List<LinhKien> linhKiens = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM LinhKien WHERE Loai = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setString(1, Loai);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                LinhKien linhKien = new LinhKien();

                linhKien.setMaLK(rs.getString("MaLK"));
                linhKien.setTenLK(rs.getString("TenLK"));
                linhKien.setLoai(rs.getString("Loai"));
                linhKien.setSoLuong(rs.getInt("SoLuong"));
                linhKien.setGiaBan(rs.getDouble("GiaBan"));
                linhKien.setHang(rs.getString("Hang"));
                linhKien.setHanBaoHanh(rs.getString("HanBaoHanh"));

                linhKiens.add(linhKien);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return linhKiens;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public List<LinhKien> SearchLinhKien_Loai_Hang(String Loai, String Hang) {
        List<LinhKien> linhKiens = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM LinhKien WHERE Loai = ? AND Hang = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setString(1, Loai);
            preparedStatement.setString(2, Hang);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                LinhKien linhKien = new LinhKien();

                linhKien.setMaLK(rs.getString("MaLK"));
                linhKien.setTenLK(rs.getString("TenLK"));
                linhKien.setLoai(rs.getString("Loai"));
                linhKien.setSoLuong(rs.getInt("SoLuong"));
                linhKien.setGiaBan(rs.getDouble("GiaBan"));
                linhKien.setHang(rs.getString("Hang"));
                linhKien.setHanBaoHanh(rs.getString("HanBaoHanh"));

                linhKiens.add(linhKien);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return linhKiens;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public List<LinhKien> SearchLinhKien_MaLK(String MaLK) {
        List<LinhKien> linhKiens = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM LinhKien WHERE MaLK = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setString(1, MaLK);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                LinhKien linhKien = new LinhKien();

                linhKien.setMaLK(rs.getString("MaLK"));
                linhKien.setTenLK(rs.getString("TenLK"));
                linhKien.setLoai(rs.getString("Loai"));
                linhKien.setSoLuong(rs.getInt("SoLuong"));
                linhKien.setGiaBan(rs.getDouble("GiaBan"));
                linhKien.setHang(rs.getString("Hang"));
                linhKien.setHanBaoHanh(rs.getString("HanBaoHanh"));

                linhKiens.add(linhKien);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return linhKiens;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public List<String> GetAllLoaiLinhKien() {
        List<String> lisLoai = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT Loai FROM LinhKien GROUP BY Loai";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String loai = "";

                loai = rs.getString("Loai");

                lisLoai.add(loai);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return lisLoai;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public List<String> GetAllHang() {
        List<String> lisLoai = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT Hang FROM LinhKien GROUP BY Hang";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String loai = "";

                loai = rs.getString("Hang");

                lisLoai.add(loai);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return lisLoai;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public boolean SuaLinhKien(LinhKien linhKien) {

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "UPDATE LinhKien SET TenLK = ? , Loai = ?, SoLuong = ?, GiaBan = ?, Hang = ?, HanBaoHanh = ? WHERE MaLK = ? ;";

            conn.setAutoCommit(false);

            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, linhKien.getTenLK());
            preparedStatement.setString(2, linhKien.getLoai());
            preparedStatement.setInt(3, linhKien.getSoLuong());
            preparedStatement.setDouble(4, linhKien.getGiaBan());
            preparedStatement.setString(5, linhKien.getHang());
            preparedStatement.setString(6, linhKien.getHanBaoHanh());
            preparedStatement.setString(7, linhKien.getMaLK());

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

    public boolean XoaLinhKien(String MaLK) {

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "DELETE FROM LinhKien WHERE MaLK = ?";

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

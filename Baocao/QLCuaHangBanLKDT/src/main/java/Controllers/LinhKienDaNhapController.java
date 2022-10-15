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
 * @author ddom6
 */
public class LinhKienDaNhapController {

    public boolean NhapLinhKien(LinhKienNhap linhKienNhap) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "INSERT INTO LinhKienNhap (MaNhap, MaLK, SoLuong, GiaNhap, TongTien, NgayNhap, NguonNhap, NguoiNhap) VALUES"
                    + "(?, ?, ?, ?, ?, ?, ?, ?)";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, linhKienNhap.getMaNhap());
            preparedStatement.setString(2, linhKienNhap.getMaLK());
            preparedStatement.setInt(3, linhKienNhap.getSoLuong());
            preparedStatement.setDouble(4, linhKienNhap.getGiaNhap());
            preparedStatement.setDouble(5, 0);
            preparedStatement.setString(6, linhKienNhap.getNgayNhap());
            preparedStatement.setString(7, linhKienNhap.getNguonNhap());
            preparedStatement.setString(8, linhKienNhap.getNguoiNhap());

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

    public List<LinhKienNhap> GetAllLinhKienDaNhap() {
        List<LinhKienNhap> linhKienNhaps = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM LinhKienNhap";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                LinhKienNhap linhKienNhap = new LinhKienNhap();

                linhKienNhap.setMaNhap(rs.getString("MaNhap"));
                linhKienNhap.setMaLK(rs.getString("MaLK"));
                linhKienNhap.setSoLuong(rs.getInt("SoLuong"));
                linhKienNhap.setGiaNhap(rs.getDouble("GiaNhap"));
                linhKienNhap.setTongTien(rs.getDouble("TongTien"));
                linhKienNhap.setNgayNhap(rs.getString("NgayNhap"));
                linhKienNhap.setNguonNhap(rs.getString("NguonNhap"));
                linhKienNhap.setNguoiNhap(rs.getString("NguoiNhap"));

                linhKienNhaps.add(linhKienNhap);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return linhKienNhaps;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public List<LinhKienNhap> SearchLinhKienDaNhap_MaNhap(String MaNhap) {
        List<LinhKienNhap> linhKienNhaps = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM LinhKienNhap WHERE MaNhap = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setString(1, MaNhap);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                LinhKienNhap linhKienNhap = new LinhKienNhap();

                linhKienNhap.setMaNhap(rs.getString("MaNhap"));
                linhKienNhap.setMaLK(rs.getString("MaLK"));
                linhKienNhap.setSoLuong(rs.getInt("SoLuong"));
                linhKienNhap.setGiaNhap(rs.getDouble("GiaNhap"));
                linhKienNhap.setTongTien(rs.getInt("TongTien"));
                linhKienNhap.setNgayNhap(rs.getString("NgayNhap"));
                linhKienNhap.setNguonNhap(rs.getString("NguonNhap"));
                linhKienNhap.setNguoiNhap(rs.getString("NguoiNhap"));

                linhKienNhaps.add(linhKienNhap);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return linhKienNhaps;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public List<LinhKienNhap> SearchLinhKienDaNhap_MaLK(String MaLK) {
        List<LinhKienNhap> linhKienNhaps = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM LinhKienNhap WHERE MaLK = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setString(1, MaLK);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                LinhKienNhap linhKienNhap = new LinhKienNhap();

                linhKienNhap.setMaNhap(rs.getString("MaNhap"));
                linhKienNhap.setMaLK(rs.getString("MaLK"));
                linhKienNhap.setSoLuong(rs.getInt("SoLuong"));
                linhKienNhap.setGiaNhap(rs.getDouble("GiaNhap"));
                linhKienNhap.setTongTien(rs.getInt("TongTien"));
                linhKienNhap.setNgayNhap(rs.getString("NgayNhap"));
                linhKienNhap.setNguonNhap(rs.getString("NguonNhap"));
                linhKienNhap.setNguoiNhap(rs.getString("NguoiNhap"));

                linhKienNhaps.add(linhKienNhap);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return linhKienNhaps;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public boolean SuaLinhKienDaNhap(LinhKienNhap linhKienNhap) {

        try {
            Connection conn = ConnectDB.GetConnection();

            conn.setAutoCommit(false);

//            String SqlQuery = "UPDATE LinhKienNhap SET SoLuong = ?, GiaNhap = ?, NgayNhap = ?, NguoiNhap = ? WHERE MaNhap = ?;";
//
//            conn.setAutoCommit(false);
//
//            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
//
//            preparedStatement.setInt(1, linhKienNhap.getSoLuong());
//            preparedStatement.setDouble(2, linhKienNhap.getGiaNhap());
//            preparedStatement.setString(3, linhKienNhap.getNgayNhap());
//            preparedStatement.setString(4, linhKienNhap.getNguoiNhap());
//            preparedStatement.setString(5, linhKienNhap.getMaNhap());
//
//            int kt = preparedStatement.executeUpdate();
            CallableStatement cs = conn.prepareCall("{CALL CapNhatGia_SoLuong_LinhKien(?, ?, ?, ?, ?, ?, ?)}");
            cs.setString(1, linhKienNhap.getMaNhap());
            cs.setString(2, linhKienNhap.getMaLK());
            cs.setInt(3, linhKienNhap.getSoLuong());
            cs.setDouble(4, linhKienNhap.getGiaNhap());
            cs.setString(5, linhKienNhap.getNgayNhap());
            cs.setString(6, linhKienNhap.getNguonNhap());
            cs.setString(7, linhKienNhap.getNguoiNhap());
            int kt = cs.executeUpdate();

            conn.commit();
            cs.close();
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

    public boolean XoaLinhKienDaNhap(String MaNhap) {

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "DELETE FROM LinhKienNhap WHERE MaNhap = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, MaNhap);

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

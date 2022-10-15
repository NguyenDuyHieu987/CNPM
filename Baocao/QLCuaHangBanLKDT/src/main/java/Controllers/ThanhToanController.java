/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Database.ConnectDB;
import Models.HoaDon;
import java.math.BigDecimal;
import java.math.BigInteger;
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
public class ThanhToanController {

    public boolean ThanhToan_HoaDon(HoaDon hoaDon) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "INSERT INTO HoaDon (MaHD, MaLK, SoLuong, TongTien, NgayMua, HinhThuc, MaGiamGia) VALUES"
                    + "(?, ?, ?, ?, ?, ?, ?)";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, hoaDon.getMaHD());
            preparedStatement.setString(2, hoaDon.getMaLK());
            preparedStatement.setInt(3, hoaDon.getSoLuong());
            preparedStatement.setDouble(4, hoaDon.getTongTien());
            preparedStatement.setString(5, hoaDon.getNgayMua());
            preparedStatement.setString(6, hoaDon.getHinhThuc());
            if (hoaDon.getMaGiamGia().length() == 0) {
                preparedStatement.setString(7, null);
            } else {
                preparedStatement.setString(7, hoaDon.getMaGiamGia());
            }

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

    public List<HoaDon> GetAllHoaDon() {
        List<HoaDon> hoaDons = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM HoaDon";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                HoaDon hoaDon = new HoaDon();

                hoaDon.setMaHD(rs.getString("MaHD"));
                hoaDon.setMaLK(rs.getString("MaLK"));
                hoaDon.setSoLuong(rs.getInt("SoLuong"));
                hoaDon.setTongTien(rs.getDouble("TongTien"));
                hoaDon.setNgayMua(rs.getString("NgayMua"));
                hoaDon.setHinhThuc(rs.getString("HinhThuc"));
                hoaDon.setMaGiamGia(rs.getString("MaGiamGia"));

                hoaDons.add(hoaDon);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return hoaDons;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public List<HoaDon> SearchThue_MaHD(String MaHD) {
        List<HoaDon> hoaDons = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM HoaDon WHERE MaHD = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setString(1, MaHD);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                HoaDon hoaDon = new HoaDon();

                hoaDon.setMaHD(rs.getString("MaHD"));
                hoaDon.setMaLK(rs.getString("MaLK"));
                hoaDon.setSoLuong(rs.getInt("SoLuong"));
                hoaDon.setTongTien(0);
                hoaDon.setNgayMua(rs.getString("NgayMua"));
                hoaDon.setHinhThuc(rs.getString("HinhThuc"));
                hoaDon.setMaGiamGia(rs.getString("MaGiamGia"));

                hoaDons.add(hoaDon);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return hoaDons;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public boolean SuaHoaDon(HoaDon hoaDon) {

        try {
            Connection conn = ConnectDB.GetConnection();

            conn.setAutoCommit(false);
            CallableStatement cs = conn.prepareCall("{CALL CapNhatGia_SoLuong_HoaDon(?, ?, ?, ?, ?, ?, ?)}");
            cs.setString(1, hoaDon.getMaHD());
            cs.setString(2, hoaDon.getMaLK());
            cs.setInt(3, hoaDon.getSoLuong());
            cs.setDouble(4, hoaDon.getTongTien());
            cs.setString(5, hoaDon.getNgayMua());
            cs.setString(6, hoaDon.getHinhThuc());
            cs.setString(7, hoaDon.getMaGiamGia());
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

    public boolean XoaHD(String MaHD) {

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "DELETE FROM HoaDon WHERE MaHD = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, MaHD);

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

    public List<String> InHoaDon(String MaHD) {
        List<String> listHoaDons = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT MaHD, LinhKien.TenLK, HoaDon.SoLuong, LinhKien.GiaBan, HoaDon.TongTien, NgayMua, HanBaoHanh, HinhThuc, MaGiamGia.Ten\n"
                    + "    FROM HoaDon, LinhKien, MaGiamGia \n"
                    + "    WHERE HoaDon.MaLK = LinhKien.MaLK AND HoaDon.MaGiamGia = MaGiamGia.Ma AND MaHD = ?;";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setString(1, MaHD);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                listHoaDons.add(rs.getString("MaHD"));
                listHoaDons.add(rs.getString("TenLK"));
                listHoaDons.add(String.valueOf(rs.getInt("SoLuong")));
                long GiaBan = new BigDecimal(rs.getDouble("GiaBan")).longValue();
                listHoaDons.add(String.valueOf(GiaBan));
                long tongtien = new BigDecimal(rs.getDouble("TongTien")).longValue();
                listHoaDons.add(String.valueOf(tongtien));
                listHoaDons.add(rs.getString("NgayMua"));
                listHoaDons.add(rs.getString("HanBaoHanh"));
                listHoaDons.add(rs.getString("HinhThuc"));
                listHoaDons.add(rs.getString("Ten"));
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return listHoaDons;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public List<String> InHoaDon1(String MaHD) {
        List<String> listHoaDons = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT MaHD, LinhKien.TenLK, HoaDon.SoLuong, LinhKien.GiaBan, HoaDon.TongTien, NgayMua, HanBaoHanh, HinhThuc \n"
                    + "                    FROM HoaDon, LinhKien \n"
                    + "                       WHERE HoaDon.MaLK = LinhKien.MaLK  AND MaHD = ?;";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setString(1, MaHD);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                listHoaDons.add(rs.getString("MaHD"));
                listHoaDons.add(rs.getString("TenLK"));
                listHoaDons.add(String.valueOf(rs.getInt("SoLuong")));
                long GiaBan = new BigDecimal(rs.getDouble("GiaBan")).longValue();
                listHoaDons.add(String.valueOf(GiaBan));
                long tongtien = new BigDecimal(rs.getDouble("TongTien")).longValue();
                listHoaDons.add(String.valueOf(tongtien));
                listHoaDons.add(rs.getString("NgayMua"));
                listHoaDons.add(rs.getString("HanBaoHanh"));
                listHoaDons.add(rs.getString("HinhThuc"));
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return listHoaDons;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }
}

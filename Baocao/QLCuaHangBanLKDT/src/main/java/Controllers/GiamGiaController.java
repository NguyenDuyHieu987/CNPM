/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Database.ConnectDB;
import Models.MaGiamGia;
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
public class GiamGiaController {

    public boolean ThemMaGiamGia(MaGiamGia maGiamGia) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "INSERT INTO MaGiamGia (Ma, Ten, PhanTram, HieuLuc) VALUES"
                    + "(?, ?, ?, ?)";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, maGiamGia.getMaGiamGia());
            preparedStatement.setString(2, maGiamGia.getTen());
            preparedStatement.setInt(3, maGiamGia.getPhanTram());
            preparedStatement.setString(4, maGiamGia.getHieuLuc());

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

    public List<MaGiamGia> GetAllMaGiamGia() {
        List<MaGiamGia> maGiamGias = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM MaGiamGia";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                MaGiamGia maGiamGia = new MaGiamGia();

                maGiamGia.setMaGiamGia(rs.getString("Ma"));
                maGiamGia.setTen(rs.getString("Ten"));
                maGiamGia.setPhanTram(rs.getInt("PhanTram"));
                maGiamGia.setHieuLuc(rs.getString("HieuLuc"));

                maGiamGias.add(maGiamGia);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return maGiamGias;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public List<String> GetAllMaGiamGia_Ma() {
        List<String> maGiamGias = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT Ma FROM MaGiamGia";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String ma = rs.getString("Ma");
                maGiamGias.add(ma);

            }
            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return maGiamGias;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public List<MaGiamGia> SearchMaGiamGia(String MaGiamGia) {
        List<MaGiamGia> maGiamGias = new ArrayList<>();

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT * FROM MaGiamGia WHERE Ma = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setString(1, MaGiamGia);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                MaGiamGia maGiamGia = new MaGiamGia();

                maGiamGia.setMaGiamGia(rs.getString("Ma"));
                maGiamGia.setTen(rs.getString("Ten"));
                maGiamGia.setPhanTram(rs.getInt("PhanTram"));
                maGiamGia.setHieuLuc(rs.getString("HieuLuc"));

                maGiamGias.add(maGiamGia);
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return maGiamGias;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public String SearchHieuLuc(String MaGiamGia) {
        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "SELECT HieuLuc FROM MaGiamGia WHERE Ma = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setString(1, MaGiamGia);
            ResultSet rs = preparedStatement.executeQuery();

            String HieuLuc = "";
            while (rs.next()) {
                HieuLuc = rs.getString("HieuLuc");
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return HieuLuc;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }

    public boolean SuaMaGiamGia(MaGiamGia maGiamGia) {

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "UPDATE MaGiamGia SET Ten = ?, PhanTram = ?, HieuLuc = ? WHERE Ma = ?;";

            conn.setAutoCommit(false);

            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, maGiamGia.getTen());
            preparedStatement.setInt(2, maGiamGia.getPhanTram());
            preparedStatement.setString(3, maGiamGia.getHieuLuc());
            preparedStatement.setString(4, maGiamGia.getMaGiamGia());

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

    public boolean XoaMaGiamGia(String MaGiamGia) {

        try {
            Connection conn = ConnectDB.GetConnection();

            String SqlQuery = "DELETE FROM MaGiamGia WHERE Ma = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, MaGiamGia);

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

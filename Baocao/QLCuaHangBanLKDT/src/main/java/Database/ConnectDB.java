/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ddom6
 */
public class ConnectDB {

    public static Connection GetConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String DbUrl = "jdbc:sqlserver://localhost:1433; DataBaseName = QLCuaHangBanLKDT; encrypt=false;"
                + " user = sa; password = hieusen123";
        conn = DriverManager.getConnection(DbUrl);
//        conn = DriverManager.getConnection(DbUrl, "sa", "hieusen123");
        return conn;
    }
}

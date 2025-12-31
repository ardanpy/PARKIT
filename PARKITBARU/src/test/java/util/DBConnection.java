package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
        "jdbc:mysql://localhost:3307/parkit?useSSL=false&serverTimezone=UTC"; // ⚠️ Port 3306 + UTC

    private static final String USER = "root";
    private static final String PASS = "";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ MySQL Driver Loaded");
        } catch (ClassNotFoundException e) {
            System.err.println("❌ MySQL Driver NOT FOUND");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        System.out.println("🔗 [DBConnection] Membuka koneksi...");
        Connection conn = DriverManager.getConnection(URL, USER, PASS);
        System.out.println("✅ [DBConnection] Koneksi BERHASIL!");
        return conn;
    }
}
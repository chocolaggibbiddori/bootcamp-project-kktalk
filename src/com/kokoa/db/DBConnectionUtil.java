package com.kokoa.db;

import java.sql.*;

public class DBConnectionUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/db_kktalk?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String ID = "root";
    private static final String PASSWORD = "tkfkdgo486";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, ID, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new IllegalStateException(e);
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new IllegalStateException(e);
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new IllegalStateException(e);
            }
        }
    }
}

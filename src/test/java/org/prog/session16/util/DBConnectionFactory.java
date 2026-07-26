package org.prog.session16.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionFactory {

    public static Connection getConnection() throws SQLException {
        String envType = System.getProperty("env.type", "local");
        if ("jenkins".equalsIgnoreCase(envType)) {
            return DriverManager.getConnection(
                    "jdbc:mysql://docker-db-1:3306/db", "root", "password");
        } else {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db", "root", "password");
        }
    }
}

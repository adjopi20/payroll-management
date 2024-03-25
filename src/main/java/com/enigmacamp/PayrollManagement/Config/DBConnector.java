package com.enigmacamp.PayrollManagement.Config;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@AllArgsConstructor
@NoArgsConstructor
public class DBConnector {
    private static final String URL = "payroll_management_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "bisa";

    public Connection connect() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/payroll_management_db", "postgres", "bisa");
            System.out.println();
            return conn;
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }
    }
}


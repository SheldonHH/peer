package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMgr {
    private final String url = "jdbc:postgresql://localhost:5432/demodb";
    private final String user = "postgres";
    private final String password = "password";
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}

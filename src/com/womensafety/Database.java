package com.womensafety;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    private static final String URL = "jdbc:mysql://localhost:3306/womensafety";
    private static final String USER = "root";
    private static final String PASSWORD = "123@123";

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
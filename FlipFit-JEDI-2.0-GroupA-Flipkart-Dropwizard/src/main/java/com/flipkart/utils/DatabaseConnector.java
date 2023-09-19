package com.flipkart.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnector {

    private static Connection connection = null;

    /**
     * Retrieves a database connection.
     *
     * @return The database connection.
     */
    public static Connection getConnection() {

        if(connection != null) {
            return connection;
        }else {
            try {
                Properties prop = new Properties();
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "Fk!_197972");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return connection;
        }
    }
}
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseControl {
    private static final String path = "jdbc:sqlite:moviesDB.sqlite3";
    private Statement stmt;
    public void connect(){
        Connection conn;
        try {
            conn = DriverManager.getConnection(path);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}

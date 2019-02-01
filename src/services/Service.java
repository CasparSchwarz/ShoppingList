package services;

import database_helpers.DatabaseHelper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Service {
    private DatabaseHelper dh;
    String url = "jdbc:sqlite:src\\saves\\Main.db";
    
    public void connect() throws SQLException{
        Connection conn = DriverManager.getConnection(url);
        dh = new DatabaseHelper(conn);
    }
    
    public void addSL(String name){
        dh.addSL(name);
    }
    
    public void addItem(String name){
        
    }
}
    

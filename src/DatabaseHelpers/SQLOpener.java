/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author smg
 */
public class SQLOpener {
    private String url = "jdbc:sqlite:src\\saves\\test.db";
    
    public Connection connect(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
        return conn;
    }
    
    public void openSL(){
        String sql = "SELECT SL_ID, SL_NAME from sl_TABLE";
        
        try(Connection conn = this.connect()){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                System.out.println(rs.getString("SL_ID") + "\t" +
                                   rs.getString("SL_NAME"));
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

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
    private Connection conn;
    
    public static final String OPEN_SL_SQL =  "SELECT SL_ID, SL_NAME FROM sl_TABLE ORDER BY SL_ID;";
    public static final String OPEN_ITEM_SQL = "SELECT ITEM_ID, SL, ITEM_NAME, ITEM_CATEGORY, ITEM_AMOUNT, ITEM_PRICE, ITEM_PRIORITY, ITEM_CHECK FROM item_table ORDER BY ITEM_ID;";
    
    public SQLOpener(Connection conn){
        // Connect to databse
        this.conn = conn;
    }
    
    // Print values of ShoppingList table
    public void openSL() throws SQLException {
        
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(OPEN_SL_SQL);
            
            while(rs.next()){
                System.out.println(rs.getString("SL_ID") + "\t" +
                        rs.getString("SL_NAME"));
            }
    }
    
    public void openItem()throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(OPEN_ITEM_SQL);
        
        while(rs.next()){
            System.out.println(rs.getString("ITEM_ID")+ "\t" 
                    + rs.getString("ITEM_NAME") + "\t" 
                    + rs.getString("ITEM_AMOUNT") + "\t" 
                    + rs.getString("ITEM_PRICE") + "\t" 
                    + rs.getString("ITEM_PRIORITY") + "\t" 
                    + rs.getString("ITEM_CHECK"));
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;

/**
 *
 * @author caspa
 */
public class DatabaseHelper {
    
    public static final String DATABASE_NAME = "Main.db";

    public static final String TABLE1_NAME = "sL_table";
    public static final String TABLE2_NAME = "item_table";

    public static final String COL_1_1 = "SL_ID";
    public static final String COL_1_2 = "SL_NAME";

    public static final String COL_2_1 = "ITEM_ID";
    public static final String COL_2_2 = "SL";
    public static final String COL_2_3 = "ITEM_NAME";
    public static final String COL_2_4 = "ITEM_CATEGORY";
    public static final String COL_2_5 = "ITEM_AMOUNT";
    public static final String COL_2_6 = "ITEM_PRICE";
    public static final String COL_2_7 = "ITEM_PRIORITY";
    public static final String COL_2_8 = "ITEM_CHECK";
    private String url = "jdbc:sqlite:src\\saves\\test.db";
    /**
     * Connect to a database
     */
    public Connection connect(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public void onCreate(){
        String shoppingLists = "CREATE TABLE " + TABLE1_NAME + " (" + COL_1_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_1_2 + " TEXT)";
        String items = "CREATE TABLE " + TABLE2_NAME + " (" + COL_2_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_2_2  + " TEXT, "
                + COL_2_3 + " TEXT, " + COL_2_4 + " TEXT, " + COL_2_5 + " TEXT, " + COL_2_6 + " INTEGER, " + COL_2_7 + " TEXT, " + COL_2_8 + " INTEGER)";
        
        try {
        Connection conne = DriverManager.getConnection(url);
        Statement stmt = conne.createStatement();
        stmt.execute(shoppingLists);
        stmt.execute(items);
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void addSL(String slName){
        String newSL = "INSERT  " + slName + "(" 
                + COL_1_1 + ", "
                + COL_1_2 + ") VALUES ("
                + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                + slName + ");";
        
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(newSL);
        } catch (SQLException exe){
            System.out.println(exe.getMessage());
        }
    }
    
    public void addItem(String shoppingList, String itemName, String itemCategory, String itemAmount, String itemPrice, int itemPriority){
        String newItem = "INSERT INTO " + TABLE2_NAME + "("
                + COL_2_1 + ", "
                + COL_2_2 + ", "
                + COL_2_3 + ", "
                + COL_2_4 + ", "
                + COL_2_5 + ", "
                + COL_2_6 + ", "
                + COL_2_7 + ")"
                + "VALUES ("
                + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                + shoppingList + ", "
                + itemName + ", "
                + itemCategory + ", "
                + itemAmount + ", "
                + itemPrice + ", "
                + itemPriority + ");";
        
        try {
            Statement stmt = connect().createStatement();
            stmt.execute(newItem);
        } catch (SQLException exe){
            System.out.println(exe.getMessage());
        }
    }
}

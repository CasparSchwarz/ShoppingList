package database_helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    
    public static final String INSERT_SL_SQL = "INSERT INTO sl_table (SL_NAME) VALUES (?);";
    public static final String INSERT_ITEM_SQL = "INSERT INTO item_table (SL, ITEM_NAME, ITEM_CATEGORY, ITEM_AMOUNT, ITEM_PRICE, ITEM_PRIORITY)"
            + " VALUES (?, ?, ?, ?, ?, ?);";
    
    public static final String VACUUM = "VACUUM;";
    
    private Connection conn;
    
    public DatabaseHelper(Connection conn){
        // Connect to database
        this.conn = conn;
    }
    
    // Create the tables
    public void onCreate(){
        String shoppingLists = "CREATE TABLE IF NOT EXISTS " + TABLE1_NAME + " (" + COL_1_1 + " INTEGER PRIMARY KEY, " + COL_1_2 + " TEXT)";
        String items = "CREATE TABLE IF NOT EXISTS " + TABLE2_NAME + " (" + COL_2_1 + " INTEGER PRIMARY KEY, " + COL_2_2  + " TEXT, "
                + COL_2_3 + " TEXT, " + COL_2_4 + " TEXT, " + COL_2_5 + " TEXT, " + COL_2_6 + " INTEGER, " + COL_2_7 + " TEXT, " + COL_2_8 + " INTEGER)";
        
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(shoppingLists);
            stmt.execute(items);
            stmt.close();
            
            System.out.println("List created");
        } catch (SQLException ex){
            System.out.println(ex.getMessage() + "in onCreate");
        }
    }
    
    // Add a ShoppingList to table
    public void addSL(String slName){
        PreparedStatement ps = null;
        try {
            ps = this.conn.prepareStatement(INSERT_SL_SQL);
            ps.setString(1, slName);
            ps.execute();
            ps.close();
            System.out.println("ShoppingList added");
        } catch (SQLException exe){
            System.out.println(exe.getMessage() + "in addSL");
        }
    }
    
    // Add an Item to table
    public void addItem(String shoppingList, String itemName, String itemCategory, String itemAmount, String itemPrice, int itemPriority){
        PreparedStatement ps = null;
        try {
            ps = this.conn.prepareStatement(INSERT_ITEM_SQL);
            ps.setString(1, shoppingList);
            ps.setString(2, itemName);
            ps.setString(3, itemCategory);
            ps.setString(4, itemAmount);
            ps.setString(5, itemPrice);
            ps.setInt(6, itemPriority);
            ps.execute();
            ps.close();
            System.out.println("Item added");
        } catch (SQLException exe){
            System.out.println(exe.getMessage() + "in addItem");
        }
    }
    
    // Delete one ShoppingList from table
    public void deleteSL(String id){
        String DELETE_SL_SQL = "DELETE FROM sl_table WHERE SL_ID = " + id + ";";
        String DELETE_ITEM_SQL = "DELETE FROM item_table WHERE SL = " + id + ";";
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(DELETE_SL_SQL);
            stmt.execute(DELETE_ITEM_SQL);
        } catch(SQLException e){
            System.out.println(e.getMessage() + "In deleteSL");
        }
    }
    
    // Delete one Item from table
    public void deleteItem(String id){
        String DELETE_ITEM_SQL = "DELETE FROM item_table WHERE ITEM_ID = " + id + ";";
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(DELETE_ITEM_SQL);
        } catch(SQLException e){
            System.out.println(e.getMessage() + "In deleteItem");
        }
    }
    
    // Update an Item in the table
    public void updateItem(String id, String shoppingList, String itemName, String itemCategory, String itemAmount, String itemPrice, int itemPriority, int itemCheck){
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ITEM_ID, SL, ITEM_NAME, ITEM_CATEGORY, ITEM_AMOUNT, ITEM_PRICE, ITEM_PRIORITY, ITEM_CHECK FROM item_table WHERE " + id);
            
            if(shoppingList == null){
                shoppingList = rs.getString("SL");
            } if (itemName == null){
                itemName = rs.getString("ITEM_NAME");
            } if (itemCategory == null){
                itemCategory = rs.getString("ITEM_CATEGORY");
            } if (itemAmount == null){
                itemAmount = rs.getString("ITEM_AMOUNT");
            } if (itemPrice == null){
                itemPrice = rs.getString("ITEM_PRICE");
            } if (itemPriority == 2){
                itemPriority = Integer.valueOf(rs.getString("ITEM_PRIORITY"));
            } if (itemCheck == 2){
                itemCheck = Integer.valueOf(rs.getString("ITEM_CHECK"));
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        String UPDATE_ITEM_SQL = "UPDATE item_table SET"
                + " SL = " + shoppingList
                + " ITEM_NAME = " + itemName
                + " ITEM_CATEGORY = " + itemCategory
                + " ITEM_AMOUNT = " + itemAmount
                + " ITEM_PRICE = " + itemPrice
                + " ITEM_PRIORITY = " + itemPriority
                + " ITEM_CHECK = " + itemCheck
                + " WHERE ITEM_ID = " + id;
    }
    
    public String getSLID(String SLName){
        return null;
    }
}

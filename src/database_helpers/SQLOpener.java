package database_helpers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Item;
import models.ShoppingList;

public class SQLOpener {
    private Connection conn;
    
    public static final String OPEN_SL_SQL =  "SELECT SL_ID, SL_NAME FROM sl_TABLE ORDER BY SL_ID;";
    public static final String OPEN_ITEM_SQL = "SELECT ITEM_ID, SL, ITEM_NAME, ITEM_CATEGORY, ITEM_AMOUNT, ITEM_PRICE, ITEM_PRIORITY, ITEM_CHECK FROM item_table ORDER BY ITEM_ID;";
    
    public SQLOpener(Connection conn){
        // Connect to databse
        this.conn = conn;
    }
    
    // Print values from the ShoppingList table
    public ArrayList<ShoppingList> openSL() throws SQLException {
        ArrayList<ShoppingList> shoppingLists = new ArrayList<>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(OPEN_SL_SQL);
        int i = 0;
        ShoppingList sl;
        while(rs.next()){
            System.out.println(rs.getString("SL_ID") + "\t" +
                    rs.getString("SL_NAME"));
            shoppingLists.add(i, sl = new ShoppingList(rs.getString("SL_ID"), rs.getString("SL_NAME")));
            i++;
        }
        return shoppingLists;
    }
    
    // Print values from the Items table
    public ArrayList<Item> openItem()throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(OPEN_ITEM_SQL);
        
        ArrayList<Item> itemList = new ArrayList<>();
        Item item;
        int i = 0;
        while(rs.next()){
            System.out.println(rs.getString("ITEM_ID")+ "\t" 
                    + rs.getString("ITEM_NAME") + "\t"
                    + rs.getString("ITEM_CATEGORY") + "\t"
                    + rs.getString("ITEM_AMOUNT") + "\t" 
                    + rs.getString("ITEM_PRICE") + "\t" 
                    + rs.getString("ITEM_PRIORITY") + "\t" 
                    + rs.getString("ITEM_CHECK"));
            itemList.add(i, item = new Item(rs.getString("ITEM_ID"),
                rs.getString("ITEM_NAME"),
                rs.getString("ITEM_CATEGORY"),
                rs.getString("ITEM_AMOUNT"),
                rs.getString("ITEM_PRICE"),
                rs.getInt("ITEM_PRIORITY"),
                rs.getInt("ITEM_CHECK")));
            i++;
        }
        return itemList;
    }
}

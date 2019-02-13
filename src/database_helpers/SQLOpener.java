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
    // Preparing SQL Statements
    public static final String OPEN_SL_SQL =  "SELECT SL_ID, SL_NAME FROM sl_TABLE ORDER BY SL_ID;";
    public static final String OPEN_ITEM_SQL = "SELECT ITEM_ID, SL, ITEM_NAME, ITEM_CATEGORY, ITEM_AMOUNT, ITEM_PRICE, ITEM_PRIORITY, ITEM_CHECK FROM item_table ORDER BY ITEM_ID;";
    
    public ArrayList<Item> itemList = new ArrayList<>();
    public ArrayList<ShoppingList> shoppingLists = new ArrayList<>();
    
    public SQLOpener(Connection conn){
        // Connect to databse
        this.conn = conn;
    }
    
    // Copy ShoppingLists from DB to ArrayList
    public ArrayList<ShoppingList> openSL() throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(OPEN_SL_SQL);
        int i = 0;
        ShoppingList sl;
        while(rs.next()){
            shoppingLists.add(i, sl = new ShoppingList(rs.getString("SL_ID"), rs.getString("SL_NAME")));
            i++;
        }
        return shoppingLists;
    }
    
    // Copy Items from Database to ArrayList
    public ArrayList<Item> openItem()throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(OPEN_ITEM_SQL);
        
        Item item;
        int i = 0;
        while(rs.next()){
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
    
    // Return ShoppingLists in an ArrayList
    public ArrayList<ShoppingList> getSList(){
        return shoppingLists;
    }
    
    // Return Items in an ArrayList
    public ArrayList<Item> getItem(){
        return itemList;
    }
    
    // Print out every Item
    public void printItemList(){
        for(int i = 0; i < itemList.size(); i++){
            System.out.println(itemList.get(i).getId() + "\t"
                + itemList.get(i).getName() + "\t"
                + itemList.get(i).getCategory() + "\t"
                + itemList.get(i).getAmount() + "\t"
                + itemList.get(i).getPrice() + "\t"
                + Integer.toString(itemList.get(i).getPriority()) + "\t"
                + Integer.toString(itemList.get(i).getCheck()));
        }
    }
    
    // Print out every ShoppingList
    public void printSList(){
        for(int i = 0; i < shoppingLists.size(); i++){
            System.out.println(shoppingLists.get(i).getSlID() + "\t"
                + shoppingLists.get(i).getName());
        }
    }
}

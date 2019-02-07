package services;

import database_helpers.DatabaseHelper;
import database_helpers.SQLOpener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Item;
import models.ShoppingList;

public class Service {
    private DatabaseHelper dh;
    private SQLOpener so;
    String url = "jdbc:sqlite:src/saves/Main.db";
    
    // Establish connection to Main.db via DbH & SQLO
    public void connect() throws SQLException{
        Connection conn = DriverManager.getConnection(url);
        dh = new DatabaseHelper(conn);
        dh.onCreate();
        so = new SQLOpener(conn);
    }
    
    // Add a ShoppingList
    public void addSL(String name){
        dh.addSL(name);
    }
    
    // Add one Item
    public void addItem(ShoppingList sl, Item item){
        dh.addItem(sl.getName(), item.getName(), item.getCategory(), item.getAmount(), item.getPrice(), item.getPriority());
    }
    
    // Delete one ShoppingList
    public void deleteSL(String id){
        dh.deleteSL(id);
    }
    
    // Delete one Item
    public void deleteItem(String id){
        dh.deleteItem(id);
    }
    
    // Set check to 1
    public void check(String id){
        dh.updateItem(id, null, null, null, null, null, 2, 1);
    }
    
    // Update one Item
    public void update(String id, String sl, String itemName, String itemCategory, String itemAmount, String itemPrice, int itemPriority){
        dh.updateItem(id, sl, itemName, itemCategory, itemAmount, itemPrice, itemPriority, 2);
    }
    
    // Print out all ShoppingLists and Items
    public void print() throws SQLException{
        so.openSL();
        so.openItem();
    }
    
    // Return an ArrayList containing all Items
    public ArrayList<Item> getItems() throws SQLException{
        return so.openItem();
    }
    
    // Return an ArrayList returning all ShoppingLists
    public ArrayList<ShoppingList> getSL() throws SQLException{
        return so.openSL();
    }
}
    

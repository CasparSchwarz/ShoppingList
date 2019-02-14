package services;

import database_helpers.DatabaseHelper;
import database_helpers.SQLOpener;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Item;
import models.ShoppingList;

public abstract class Service {
    private DatabaseHelper dh;
    private SQLOpener so;
    String path = "src/saves/Main.db";
    String url = "jdbc:sqlite:" + path;
    
    // Establish connection to Main.db via DbH & SQLO
    public abstract void connect() throws SQLException;
    
    // Add a ShoppingList
    public abstract void addSL(String name);
    
    // Add one Item
    public abstract void addItem(ShoppingList sl, Item item);
    
    // Delete one ShoppingList
    public abstract void deleteSL(ShoppingList SL);
    
    // Delete one Item
    public abstract void deleteItem(Item item);
    
    // Set check to 1
    public abstract void check(Item item);
    
    // Update one Item
    public abstract void update(Item item, String sl, String itemName, String itemCategory, String itemAmount, String itemPrice, int itemPriority);
    
    // Return an ArrayList containing all Items
    public abstract ArrayList<Item> getItems() throws SQLException;
    
    // Return an ArrayList returning all ShoppingLists
    public abstract ArrayList<ShoppingList> getSL() throws SQLException;
    
    // Get ShoppingLists ArrayList
    public ArrayList<ShoppingList> getSList(){
        return so.getSList();
    }
    
    // Get ItemLists
    public ArrayList<Item> getItemList(){
        return so.getItem();
    }
    // Print all ShoppingLists and Items
    public abstract void print();
}
    

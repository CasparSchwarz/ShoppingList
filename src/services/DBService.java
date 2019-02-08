/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import database_helpers.DatabaseHelper;
import database_helpers.SQLOpener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Item;
import models.ShoppingList;

/**
 *
 * @author smg
 */
public class DBService extends Service{
    private DatabaseHelper dh;
    private SQLOpener so;
    String path = "src/saves/Main.db";
    String url = "jdbc:sqlite:" + path;
    
    private boolean isSL = false;
    private boolean isItem = false;
    
    // Establish connection to Main.db via DbH & SQLO
    @Override
    public void connect() throws SQLException{
        File db = new File(path);
        try{
            db.getParentFile().mkdirs();
            db.createNewFile();
        } catch (IOException ex){
            System.out.println(ex);
        }
        Connection conn = DriverManager.getConnection(url);
        dh = new DatabaseHelper(conn);
        dh.onCreate();
        so = new SQLOpener(conn);
    }
    
    // Add a ShoppingList
    @Override
    public void addSL(String name){
        dh.addSL(name);
    }
    
    // Add one Item
    @Override
    public void addItem(ShoppingList sl, Item item){
        dh.addItem(sl.getName(), item.getName(), item.getCategory(), item.getAmount(), item.getPrice(), item.getPriority());
    }
    
    // Delete one ShoppingList
    @Override
    public void deleteSL(String id){
        dh.deleteSL(id);
    }
    
    // Delete one Item
    @Override
    public void deleteItem(String id){
        dh.deleteItem(id);
    }
    
    // Set check to 1
    @Override
    public void check(String id){
        dh.updateItem(id, null, null, null, null, null, 2, 1);
    }
    
    // Update one Item
    @Override
    public void update(String id, String sl, String itemName, String itemCategory, String itemAmount, String itemPrice, int itemPriority){
        dh.updateItem(id, sl, itemName, itemCategory, itemAmount, itemPrice, itemPriority, 2);
    }
    
    // Print out all ShoppingLists and Items
    @Override
    public void print(){
        if(!isSL && !isItem){
            try {
                so.openItem();
                so.openSL();
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
        so.printSList();
        so.printItemList();
    }
    
    // Return an ArrayList containing all Items
    @Override
    public ArrayList<Item> getItems() throws SQLException{
        return so.openItem();
    }
    
    // Return an ArrayList returning all ShoppingLists
    @Override
    public ArrayList<ShoppingList> getSL() throws SQLException{
        return so.openSL();
    }
}
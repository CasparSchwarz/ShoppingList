package services;

import database_helpers.DatabaseHelper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import models.Item;
import models.ShoppingList;

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
    
    public void addItem(ShoppingList sl, Item item){
        dh.addItem(sl.getName(), item.getName(), item.getCategory(), item.getAmount(), item.getPrice(), item.getPriority());
    }
    
    public void deleteSL(String id){
        dh.deleteSL(id);
    }
    
    public void deleteItem(String id){
        dh.deleteItem(id);
    }
    
    public void check(String id){
        dh.updateItem(id, null, null, null, null, null, 2, 1);
    }
    
    public void update(String id, String sl, String itemName, String itemCategory, String itemAmount, String itemPrice, int itemPriority){
        dh.updateItem(id, sl, itemName, itemCategory, itemAmount, itemPrice, itemPriority, 2);
    }
    
    
}
    

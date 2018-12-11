/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingList;

import java.io.IOException;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author caspa
 */
public class Test {
    
    public static void main(String[] args) throws IOException {
        //test1();
        //test2();
        sqliteTest();
    }
    
    // Item (String name, Category category, int priority, String amount)
    // Milch;;;Drinks;;;0;;;null;;;false

    public static void test1() throws IOException{
        ShoppingList shoppingList = new ShoppingList("List1");
        Item milk = new Item("Milch", "drinks", false, null);
        Item honey = new Item("Honig", "food", true, null);
        Item nutella = new Item("Nutella", "food", false, "3");
        Item cheese = new Item("Käse", "food", false, "5");
        
        shoppingList.addItem(milk);
        shoppingList.addItem(new Item("Nusseis", "food", true, "10"));
        shoppingList.replaceItem(milk, cheese);
        shoppingList.addItem(honey);
        shoppingList.addItem(nutella);
        shoppingList.removeItem(milk);
        
        // public void editItem(Item item, String name, Category category, Integer priority, String amount, Boolean check)
        shoppingList.editItem(cheese, "Gouda", "drinks", false, "1", true);
        
        List<Item> it = shoppingList.getItems();
        for (int i = 0; i < it.size(); i++){
            System.out.println(it.get(i).toString());
        }
        
        List<Item> ifi = shoppingList.filter("Nu");
        for (int i = 0; i < ifi.size(); i++){
            System.out.println(ifi.get(i).toString());
        }
        
        /*List<Item> is = shoppingList.pSorter();
        System.out.println("Sort by Priority: ");
        for (int i = 0; i < is.size(); i++){
            System.out.println(is.get(i).toString());
        }*/
        
    }
    
    public static void test2() throws IOException {
        FileScanner fs = new FileScanner();
        fs.openShoppingList();
        
    }
    
    public static void sqliteTest(){
        /* 
        *  Create a table
        */
        
        // SQLite connection string
        String url = "jdbc:sqlite:F:\\Desktop\\AASchule\\MSS\\MSS13\\Informatiik\\ShoppingList\\src\\saves";
        
        // Creating a new table
        String sql = "CREATE TABLE IF NOT EXIST shoppingList (\n"
                + " col_1 PRIMARY KEY,\n"
                + " name text NOT NULL, \n"
                + "capacity real\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

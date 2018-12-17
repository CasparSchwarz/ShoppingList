package shopping_list;

import database_helpers.DatabaseHelper;
import database_helpers.SQLOpener;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
    
    public static void main(String[] args) throws IOException {
        //test1();
        //test2();
        sqliteTest();
    }
    
    // Item (String name, Category category, int priority, String amount)
    // Milch;;;Drinks;;;0;;;null;;;false

//    public static void test1() throws IOException{
//        ShoppingList shoppingList = new ShoppingList("List1");
//        Item milk = new Item("Milch", "drinks", "", "w", 0. "w", 0);
//        Item honey = new Item("Honig", "food", true, null);
//        Item nutella = new Item("Nutella", "food", false, "3");
//        Item cheese = new Item("Käse", "food", false, "5");
//        
//        shoppingList.addItem(milk);
//        shoppingList.addItem(new Item("Nusseis", "food", true, "10"));
//        shoppingList.replaceItem(milk, cheese);
//        shoppingList.addItem(honey);
//        shoppingList.addItem(nutella);
//        shoppingList.removeItem(milk);
//        
//        // public void editItem(Item item, String name, Category category, Integer priority, String amount, Boolean check)
//        shoppingList.editItem(cheese, "Gouda", "drinks", false, "1", true);
//        
//        List<Item> it = shoppingList.getItems();
//        for (int i = 0; i < it.size(); i++){
//            System.out.println(it.get(i).toString());
//        }
//        
//        List<Item> ifi = shoppingList.filter("Nu");
//        for (int i = 0; i < ifi.size(); i++){
//            System.out.println(ifi.get(i).toString());
//        }
//        
//        /*List<Item> is = shoppingList.pSorter();
//        System.out.println("Sort by Priority: ");
//        for (int i = 0; i < is.size(); i++){
//            System.out.println(is.get(i).toString());
//        }*/
//        
//    }
    
    public static void sqliteTest(){
        String url = "jdbc:sqlite:src\\saves\\Main.db";
        try {
        Connection conn = DriverManager.getConnection(url);
        DatabaseHelper dbh = new DatabaseHelper(conn);
        
        dbh.onCreate();
        dbh.addSL("Einkauf");
        dbh.addSL("test2");
        dbh.deleteSL("3");
        dbh.addItem("1", "Milch", "Drinks", "Drei Tetrapacks", "5€", 1);
        dbh.addItem("26", "Nutella", "Food", "50 Gläser", "4€", 1);
        SQLOpener sqlo = new SQLOpener(conn);
        sqlo.openSL();
        sqlo.openItem();
        } catch (SQLException e){
            System.out.println(e.getMessage() + "in sqliteTest");
        }
    }
}

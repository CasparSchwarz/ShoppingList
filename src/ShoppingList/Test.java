/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingList;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author caspa
 */
public class Test {
    
    public static void main(String[] args) throws IOException {
        test1();
    }
    
    // Item (String name, Category category, int priority, String amount)
    // Milch;;;Drinks;;;0;;;null;;;false

    public static void test1() throws IOException{
        ShoppingList shoppingList = new ShoppingList("List1");
        Category drinks = new Category("Drinks");
        Category food = new Category("Food");
        Item milk = new Item("Milch", drinks, 0, null);
        Item honey = new Item("Honig", food, 1, null);
        Item nutella = new Item("Nutella", food, 0, "3");
        Item cheese = new Item("Käse", food, 0, "5");
        
        shoppingList.addItem(milk);
        shoppingList.addItem(honey);
        shoppingList.addItem(nutella);
        shoppingList.removeItem(milk);
        shoppingList.addItem(cheese);
        
        List<Item> it = shoppingList.getItems();
        System.out.println(it.toString());
        
    }
}

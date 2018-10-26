/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingList;

import java.io.IOException;

/**
 *
 * @author caspa
 */
public class Test {
    
    public static void main(String[] args) throws IOException {
        test1();
    }
    
    public static void test1() throws IOException{
        ShoppingList shoppingList = new ShoppingList("List1");
        Category drinks = new Category("Drinks");
        Item milk = new Item("Milch", null, 0, null);
        shoppingList.addItem(milk);
    }
}

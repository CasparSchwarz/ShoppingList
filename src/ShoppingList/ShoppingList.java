/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingList;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author smg
 */
public class ShoppingList {
    
    private String name;
    private List<Item> items;
    
    public ShoppingList(String name){
        name = this.name;
        items = new ArrayList<>();
    }
    
    public void addItem(Item item){
     items.add(item);
    }
    
    public void removeItem(Item item){
        items.remove(item);
    }
    
}

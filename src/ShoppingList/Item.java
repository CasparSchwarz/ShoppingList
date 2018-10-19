/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingList;
/**
 *
 * @author smg
 */
public class Item {
    private String name;
    private Category category;
    private Store store;
    private int priority;
    private String amount;
    private boolean check;
    
    public Item (String name, Category category, int priority, String amount){
        name = this.name;
        category = this.category;
        priority = this.priority;
        amount = this.amount;
        check = false;
    }
    
    public void check(){
        check = true;
    }
    
    public void changeAmount(String amount){
        amount = this.amount;
    }
}

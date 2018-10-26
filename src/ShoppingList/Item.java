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
        this.name = name;
        this.category = category;
        this.priority = priority;
        this.amount = amount;
        check = false;
    }
    
    // Marking an item as bought [check]
    public void check(){
        check = true;
    }
    
    // Chaning the amount of an item
    public void changeAmount(String amount){
        amount = this.amount;
    }

    public String getName() {
        return name;
    }
    
    // Preparing of Attributes for the text file
    public String txtFormat(){
        String txtF = name + ";;;" 
                + category.getName() + ";;;"
                + store.getName() + ";;;"
                + String.valueOf(priority)+ ";;;"
                + String.valueOf(amount) + ";;;"
                + String.valueOf(check) + "::::";
        return txtF;
    }
}

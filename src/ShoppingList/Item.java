/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingList;

import java.util.Comparator;

/**
 *
 * @author smg
 */
public class Item {
    private String name;
    private Store store;
    private String category;
    private boolean priority;
    private String amount;
    private String seperator;
    private boolean check;
    
    public Item (String name, String category, boolean priority, String amount){
        this.name = name;
        this.category = category;
        this.priority = priority;
        this.amount = amount;
        this.seperator = ";;;";
        check = false;
    }

    public String getName() {
        return name;
    }
    
    public void setAmount(String amount){
        this.amount = amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public boolean getPriority() {
        return priority;
    }

    public boolean isCheck() {
        return check;
    }
    
    // Preparing of Attributes for the text file
    @Override
    public String toString(){
        String txtF = name + seperator 
                + category + seperator
                + String.valueOf(priority)+ seperator
                + String.valueOf(amount) + seperator
                + String.valueOf(check);
        return txtF;
    }
}

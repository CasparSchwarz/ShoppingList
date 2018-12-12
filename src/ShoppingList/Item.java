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
    
    private String id;
    private String name;
    
    private String category;
    private String amount;
    private boolean priority;
    private String price;
    private boolean check;
    
    // "überflüssig"
    private Store store;
    private String seperator;
    
    public Item (String id, String name, String category, String amount, String price , int priority, int check){
        this.id = id;
        this.name = name;
        this.category = category;
        this.amount = amount;
        if(priority == 1){
            this.priority = true;
        } else {
            this.priority = false;
        }
        this.price = price;
        this.check = check == 1;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public String getAmount() {
        return amount;
    }

    public String getPrice() {
        return price;
    }

    public String getId() {
        return id;
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

    public void setPriority(int priority) {
        if(priority == 1){
            this.priority = true;
        } else{
            this.priority = false;
        }
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
    
    // Preparing of attributes for the text file
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

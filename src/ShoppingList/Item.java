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
    private String seperator;
    private boolean check;
    
    public Item (String name, Category category, int priority, String amount){
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

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public boolean isCheck() {
        return check;
    }
    
    // Preparing of Attributes for the text file
    @Override
    public String toString(){
        String txtF = name + seperator 
                + category.getName() + seperator
                + String.valueOf(priority)+ seperator
                + String.valueOf(amount) + seperator
                + String.valueOf(check);
        return txtF;
    }
}

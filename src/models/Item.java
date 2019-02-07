package models;

public class Item {
    
    private String id;
    private String name;
    
    private String category;
    private String amount;
    private int priority;
    private String price;
    private int check;
    private String seperator;
    
    public Item (String id, 
            String name, 
            String category, 
            String amount, 
            String price , 
            int priority, 
            int check){
        this.id = id;
        this.name = name;
        this.category = category;
        this.amount = amount;
        
        this.priority = priority;
        
        this.price = price;
        this.check = check;
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

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public int getPriority() {
        return priority;
    }

    public int getCheck() {
        return check;
    }
    
    // Preparing of attributes for the text file
    @Override
    public String toString(){
        String txtF = amount
                + "   "
                + String.valueOf(name);
        return txtF;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author smg
 */
public class ShoppingList {
    
    private String name;
    private String fileName;
    private String dir;
    private List<Item> items;
    // private int position;
    private PrintWriter out;
    private File list;
    
    public ShoppingList(String name){
        this.name = name;
        this.dir = "src/saves/";
        this.fileName = dir + name + ".txt";
        
        // Creating new dir if given dir doesn't exist, creating new file
        try{
            new File(dir).mkdirs();
            new File(fileName).createNewFile();
            list = new File(fileName);
            items = new ArrayList<>();
        } catch(IOException e){
            System.out.println(e);
        }
    }
    
    // Adding an Item and writing to .txt
    public void addItem(Item item) throws IOException{
        items.add(item);
        try(FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw)){
            pw.println(item.toString());
        }
    }
    
    // Refreshing .txt
    public void saveList() throws IOException{
        list.delete();
        out = new PrintWriter(fileName);
        for (int i = 0; i < items.size(); i++){
            out.println(items.get(i).toString());
        }
        out.close();
    }
    
    public void removeItem(Item item)throws IOException {
        items.remove(item);
        saveList();
    }
    
    public void replaceItem(Item oldItem, Item newItem) throws IOException{
        addItem(newItem);
        removeItem(oldItem);
    }
    
    public void editItem(Item item, String name, Category category, Integer priority, String amount, Boolean check) throws IOException{
        if(name != null){
            item.setName(name);
        } else if(category.getName() != null){
            item.setCategory(category);
        } else if(priority != null){
            item.setPriority(priority.intValue());
        } else if(amount != null){
            item.setAmount(amount);
        } else if(check != null){
            item.setCheck(check.booleanValue());
        }
        saveList();
    }

    public List<Item> getItems() {
        return items;
    }
    
    
}

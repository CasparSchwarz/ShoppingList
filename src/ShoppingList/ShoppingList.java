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
import java.util.Collections;
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
    private PrintWriter out;
    private File list;
    private String seperator;
    
    public ShoppingList(String name){
        this.name = name;
        this.dir = "src/saves/";
        this.fileName = dir + name + ".txt";
        this.seperator = seperator;
        
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
    public void addItem(Item item){
        items.add(item);
        try{
            FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(item.toString());
        } catch(IOException e){
            System.out.println(e);
        }
    }
    
    // Adds Items to the ArrayList in FileScanner
    public void addItemFS(Item item){
        items.add(item);
    }
    
    // Refreshing .txt
    public void saveList(){
        list.delete();
        try{
            out = new PrintWriter(fileName);
            for (int i = 0; i < items.size(); i++){
                out.println(items.get(i).toString());
            }
            out.close();
        } catch(IOException e){
            System.out.println(e);
        }
    }

    public String getName() {
        return name;
    }
    
    // Removes item from List and refreshes .txt
    public void removeItem(Item item){
        items.remove(item);
        saveList();
    }
    
    // Replaces oldItem with newItem
    public void replaceItem(Item oldItem, Item newItem){
        addItem(newItem);
        removeItem(oldItem);
    }
    
    // Changes Item-properties and refreshes .txt
    public void editItem(Item item, String name, String category, boolean priority, String amount, Boolean check){
        if(name != null) item.setName(name);
        if(category != null) item.setCategory(category);
        item.setPriority(priority);
        if(amount != null) item.setAmount(amount);
        if(check != null) item.setCheck(check);
        saveList();
    }

    public List<Item> getItems() {
        return items;
    }
    
    // Clearing the ArrayList from all the checked Items
    public void clear(){
        int i = 0;
        if(!items.isEmpty()){
            while(items.get(i) != null){
                if(items.get(i).isCheck()){
                    items.remove(items.get(i));
                }
                i++;
            }
            
        }
    }
    public String toString(){
        String txtF = name + seperator 
                + getItems() + seperator;
        return txtF;
    }
    
    // Filter Items by a certain String
    public List<Item> filter(String fi){
        System.out.println("Filter: "+fi+" :");
        List<Item> flist = new ArrayList<>();
        for(Item fitem : items){
            if(fitem.getName().toLowerCase().startsWith(fi.toLowerCase())){
                flist.add(fitem);
            }
        }
        //Collections.sort(flist, new Item.PriorityComparator());
        return flist;
    }    
}

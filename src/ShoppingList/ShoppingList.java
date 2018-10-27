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
        dir = "src/savess/";
        this.name = name;
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
            PrintWriter out = new PrintWriter(bw)){
            out.println(item.toString());
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

    public List<Item> getItems() {
        return items;
    }
    
    
}

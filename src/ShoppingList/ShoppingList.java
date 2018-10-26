/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingList;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
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
    
    // Adding an Item
    public void addItem(Item item){
     items.add(item);
    }
    
    // Removing an Item
    public void removeItem(Item item){
        items.remove(item);
    }
    
    public void editTxt(String filename, String data, long position) 
        throws IOException{
            RandomAccessFile writer = new RandomAccessFile(filename, "rw");
            writer.seek(position);
            writer.writeUTF(data);
            writer.close();
        }
}

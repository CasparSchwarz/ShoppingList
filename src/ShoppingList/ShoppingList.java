/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
    private int position;
    private File shoppingList;
    private FileWriter writer;
    
    public ShoppingList(String name) throws IOException{
        this.name = name;
        items = new ArrayList<>();
        shoppingList = new File("ShoppingList.txt");
        writer = new FileWriter(shoppingList);
        position = 1;
    }
    
    // Adding an Item
    public void addItem(Item item) throws IOException{
     items.add(item);
     String itemName = item.getName();
     writer.write(item.txtFormat());
        System.out.println(itemName);
     writer.close();
     position++;
    }
    
    // Removing an Item
    public void removeItem(Item item){
        items.remove(item);
    }
    
    public void editTxt(String filename, String data, int position) 
        throws IOException{
            RandomAccessFile writer = new RandomAccessFile(filename, "rw");
            writer.seek(position);
            writer.writeUTF(data);
            writer.close();
        }
}

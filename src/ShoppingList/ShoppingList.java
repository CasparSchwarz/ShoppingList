/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
    private List<Item> items;
    // private int position;
    private PrintWriter out;
    
    public ShoppingList(String name) throws IOException{
        this.name = name;
        this.fileName = name + ".txt";
        
        items = new ArrayList<>();
        out = new PrintWriter(fileName);
    }
    
    // Adding an Item
    public void addItem(Item item) throws IOException{
     items.add(item);
     out.println(item.toString());
     out.close();
    }
    
    // Removing an Item
    public void removeItem(Item item)throws IOException {
        items.remove(item);
        File f = new File(fileName);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        while(br.readLine() != null){
            if(line.equals(item.toString())){
                line = line.replace(item.toString(), null);
            }
        }
        fr.close();
        br.close();
    }
}

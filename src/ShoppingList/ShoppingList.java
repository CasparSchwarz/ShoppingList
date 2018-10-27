/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
    private File list;
    
    public ShoppingList(String name) throws IOException{
        this.name = name;
        this.fileName = "src/saves/" + name + ".txt";
        list = new File(fileName);
        items = new ArrayList<>();
        out = new PrintWriter(fileName);
    }
    
    // Adding an Item
    public void addItem(Item item) throws IOException{
        items.add(item);
//        out.println(item.toString());
//        out.close();
    }
    
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
//        File inputFile = list;
//        File tempFile = new File("src/saves/temp.txt");
//
//        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
//        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
//
//        String lineToRemove = item.toString();
//        String currentLine;
//
//        while((currentLine = reader.readLine()) != null) {
//            if(currentLine.equals(lineToRemove)) continue;
//            writer.write(currentLine + System.getProperty("line.separator"));
//        }
//        writer.close(); 
//        reader.close();
//        tempFile.renameTo(inputFile);
//        inputFile.delete();
//        if(tempFile.renameTo(inputFile)){
//            System.out.println("Item removal succesful");
//        } else{
//            System.out.println("Item removal failed");
//        }
//        tempFile.delete();
    }

    public List<Item> getItems() {
        return items;
    }
    
    
}

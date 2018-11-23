/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author caspar
 */
public class FileScanner {
    
    private BufferedReader reader;
    private List<String> items;
    private List<String> categories;
    /**
     *
     */
    
    // Opens a ShoppingList .txt
    public void openShoppingList() {
        
        // Creates an ArrayList for all the Items in the .txt
        items = new ArrayList<>();
        try{
            reader = new BufferedReader(new FileReader("src/saves/List1.txt"));
        } catch(FileNotFoundException e){
            System.out.println(e);
        }
        
        ShoppingList List1 = new ShoppingList("List1");
        
        // Create String to read the current line
        String letter;
        StringBuilder sb = new StringBuilder();
        
        // Read each Line
        try{
            while((letter = reader.readLine()) != null){
                String temp = "";
                int i = 0;
                
                // create int p to destinguish current attribute
                int p = 0;
                Item item = new Item(null, null, false, null);
                List1.addItemFS(item);
                
                // Checking for the seperator ";;;"
                while(i < 4 && p >= 0){
                    //System.out.print(letter.charAt(p));
                    if(letter.charAt(p) == ';' && letter.charAt(p+1) == ';' && letter.charAt(p+2) == ';'){
                        p = p +3;
                        
                        // Set attributes of a certain item
                        switch (i) {
                            case 0:
                                item.setName(temp);
                                break;
                            case 1:
                                break;
                            case 2:
                                if(temp == "true") item.setPriority(true);
                                if(temp == "false") item.setPriority(false);
                                break;
                            case 3:
                                item.setAmount(temp);
                                break;
                            case 4:
                                if("t".equals(temp)){
                                    item.setCheck(true);
                                } else {
                                    item.setCheck(false);
                                }   break;
                            default:
                                break;
                        }
                        temp = "";
                        i++;
                        if(i > 4) continue;
                    }
                    temp += Character.toString(letter.charAt(p));
                    System.out.println(temp);
                    p++;
                }
            }
            System.out.println(List1.getItems().toString());
        } catch (IOException f){
            System.out.println(f);
        }
    }
}
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.Item;
import java.util.ArrayList;
/**
 *
 * @author smg
 */
public class LItem {
    
    private Item item;
    
    private int ld;
    
    public LItem(Item item, int ld){
        this.item = item;
        this.ld = ld;
    }
    
    public void setLd(int ld){
        this.ld = ld;
    }

    public Item getItem() {
        return item;
    }

    public int getLd() {
        return ld;
    }
    
    public ArrayList<LItem> LIList(CharSequence in,ArrayList<Item> i){
        ArrayList<LItem> a = new ArrayList<>();
        
        return a;
    }
}

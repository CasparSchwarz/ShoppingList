/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

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
    
    private String slID;
    private String name;

    public ShoppingList(String slID, String name){
        this.name = name;
        this.slID = slID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlID() {
        return slID;
    }

    public void setSlID(String slId) {
        this.slID = slId;
    }
    
    public String toString(){
        String out = "ID: " + slID + "name: " + name;
        return out;
    }
}
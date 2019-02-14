
package services;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

import models.Item;

public class Organize {
    
private static final int SORT_BY_NAME = 0;
private static final int SORT_BY_CATEGORY = 1;

 private ArrayList<Item> items;
 private int lastSortedBy;
 private String lastSearchedBy;
    
    public Organize(){
        
    }
    
    public void sortItems(int id){
        if (id == SORT_BY_NAME) {
            Collections.sort(items, new Comparator<Item>() {
                @Override
                public int compare(Item o1, Item o2) {
                    return o1.getName().compareToIgnoreCase(o2.getName());
                }
            });
            this.lastSortedBy = SORT_BY_NAME;
        }
        if (id == SORT_BY_CATEGORY) {
            Collections.sort(items, new Comparator<Item>() {
                @Override
                public int compare(Item o1, Item o2) {
                    if (o1.getCategory().equals("") && o2.getCategory().equals("")) {
                        return 0;
                    } else if (o1.getCategory().equals("")) {
                        return 1;
                    } else if (o2.getCategory().equals("")) {
                        return -1;
                    } else {
                        return o1.getCategory().compareToIgnoreCase(o2.getCategory());
                    }
                }
            });
            this.lastSortedBy = SORT_BY_CATEGORY;
        }

        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getPriority() - o2.getPriority();
            }
        });

        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getCheck() - o2.getCheck();
            }
        });
        

       
    }
    
    public void filter(CharSequence rein) throws SQLException{
        DBService db = new DBService();
        db.connect();
        ArrayList<Item> out = new ArrayList<>();
        ArrayList<LItem> a = createLiList(rein,db.getItems());
        for(int i = 0; i < a.size() ;i++){
            out.add(a.get(i).getItem());
        }
        
        
        for(int j = 0; j < out.size(); j++){
            System.out.println(out.get(j).getId() + "\t"
                + out.get(j).getName() + "\t"
                + out.get(j).getCategory() + "\t"
                + out.get(j).getAmount() + "\t"
                + out.get(j).getPrice() + "\t"
                + Integer.toString(out.get(j).getPriority()) + "\t"
                + Integer.toString(out.get(j).getCheck()));
        }
    }
    
        public ArrayList<LItem> createLiList(CharSequence in,ArrayList<Item> i){
        ArrayList<LItem> a = new ArrayList<>();
        
        for (int b = 0; b < i.size(); b++) {
            a.add( new LItem(i.get(b),Organize.computeLevenshteinDistance(in, i.get(b).getName())));
        }
        
        Collections.sort(a, new Comparator<LItem>() {
            @Override
            public int compare(LItem o1, LItem o2) {
                return o1.getLd() - o2.getLd();
            }
        });
                
                
        return a;
        
        

    }
    
                                             
    private static int minimum(int a, int b, int c) {                            
            return Math.min(Math.min(a, b), c);                                      
        }                                                                            

        public static int computeLevenshteinDistance(CharSequence lhs, CharSequence rhs) {      
            int[][] distance = new int[lhs.length() + 1][rhs.length() + 1];        

            for (int i = 0; i <= lhs.length(); i++)                                 
                distance[i][0] = i;                                                  
            for (int j = 1; j <= rhs.length(); j++)                                 
                distance[0][j] = j;                                                  

            for (int i = 1; i <= lhs.length(); i++)                                 
                for (int j = 1; j <= rhs.length(); j++)                             
                    distance[i][j] = minimum(                                        
                            distance[i - 1][j] + 1,                                  
                            distance[i][j - 1] + 1,                                  
                            distance[i - 1][j - 1] + ((lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1));

            return distance[lhs.length()][rhs.length()];                           
        }                                                                            
    }
    
    


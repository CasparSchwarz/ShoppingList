
package services;

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
                if (o1.getPriority() == o2.getPriority()) {
                    return 0;
                } else if (o1.getPriority()) {
                    return -1;
                } else if (o2.getPriority()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if (o1.isCheck() == o2.isCheck()) {
                    return 0;
                } else if (o1.isCheck()) {
                    return 1;
                } else if (o2.isCheck()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

       
    }
}

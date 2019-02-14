package gui;

import models.Item;
import models.ShoppingList;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
import services.DBService;
import services.Service;

public class UI extends javax.swing.JFrame {
    
    // Creates item, Service as online database, shoppinglist to add item   
    private Item newItem;
    private Service s;
    private ShoppingList list1;
    
    // Creates list model for jlist
    private DefaultListModel model;
    // Creates list model wit priority for jlist
    private DefaultListModel pmodel;
    
    private int screenWidth;
    private int screenHeight;

    /**
     * Creates new form UI
     */
    @SuppressWarnings("unchecked")
    public UI() {
                
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        this.screenWidth = screenSize.width /2 - 200;
        this.screenHeight = screenSize.height /2 - 325;
        
        this.setLocation(screenWidth, screenHeight);        
        
        initComponents();

        //add functions to popupmenu
        jPopupMenu1.add(jLabelItemName);
        jPopupMenu1.add(jTextFieldItemName);
        jPopupMenu1.add(jLabelItemCategory);
        jPopupMenu1.add(jTextFieldItemCategory);
        jPopupMenu1.add(jLabelItemAmount);
        jPopupMenu1.add(jTextFieldItemAmount);
        jPopupMenu1.add(jLabelItemPrice);
        jPopupMenu1.add(jTextFieldItemPrice);
        jPopupMenu1.add(jCheckBoxItemPriority);
        jPopupMenu1.add(jButtonPopupHinzufügen);
        
        // Initializes shoppinglist to add items 
        list1 = new ShoppingList("1", "list1");
        
        // Uses Service to establish connection to db
        DBService s = new DBService();
        s.connect();
        s.addSL("list1");
        
        // Creates listmodel
        model = new DefaultListModel();
        pmodel = new DefaultListModel();
  
        // Name displayed in UI
        jTextFieldShoppingListName.setText("Name your shoppinglist!");
        
                
       // Sets model of shoppinglist
        jShoppingList.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jLabelItemName = new javax.swing.JLabel();
        jTextFieldItemName = new javax.swing.JTextField();
        jLabelItemCategory = new javax.swing.JLabel();
        jTextFieldItemCategory = new javax.swing.JTextField();
        jCheckBoxItemPriority = new javax.swing.JCheckBox();
        jLabelItemAmount = new javax.swing.JLabel();
        jTextFieldItemAmount = new javax.swing.JTextField();
        jLabelItemPrice = new javax.swing.JLabel();
        jTextFieldItemPrice = new javax.swing.JTextField();
        jButtonPopupHinzufügen = new javax.swing.JButton();
        jButtonAddItem = new javax.swing.JButton();
        jCheckPriority = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jShoppingList = new javax.swing.JList<>();
        jTextFieldShoppingListName = new javax.swing.JTextField();
        jButtonDelete = new javax.swing.JButton();

        jLabelItemName.setText("Produktname");

        jTextFieldItemName.setText(null);

        jLabelItemCategory.setText("Kategorie");

        jTextFieldItemCategory.setText(null);

        jCheckBoxItemPriority.setText("Priorität");
        jCheckBoxItemPriority.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxItemPriorityActionPerformed(evt);
            }
        });

        jLabelItemAmount.setText("Menge");

        jLabelItemPrice.setText("Preis (€)");

        jTextFieldItemPrice.setText("");

        jButtonPopupHinzufügen.setText("Hinzufügen");
        jButtonPopupHinzufügen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPopupHinzufügenActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 650));

        jButtonAddItem.setText("+");
        jButtonAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddItemActionPerformed(evt);
            }
        });

        jCheckPriority.setText("Priority");
        jCheckPriority.setMaximumSize(new java.awt.Dimension(70, 25));
        jCheckPriority.setMinimumSize(new java.awt.Dimension(70, 25));
        jCheckPriority.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckPriorityMouseClicked(evt);
            }
        });

        jShoppingList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jShoppingList);

        jTextFieldShoppingListName.setText("Hier könnte der Name Ihrer ShoppingList stehen :)");
        jTextFieldShoppingListName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldShoppingListNameMouseClicked(evt);
            }
        });

        jButtonDelete.setText("Delete");
        jButtonDelete.setMaximumSize(new java.awt.Dimension(70, 25));
        jButtonDelete.setMinimumSize(new java.awt.Dimension(70, 25));
        jButtonDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonDeleteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckPriority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldShoppingListName, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckPriority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldShoppingListName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getAccessibleContext().setAccessibleName("jFrame");
        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Opens popupmenu and sets parameters to null
    private void jButtonAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddItemActionPerformed
        newItem = new Item(null, null, null, null, null, 0, 0);
        jPopupMenu1.show(jButtonAddItem, -104 +jButtonAddItem.getWidth() , -224+jButtonAddItem.getHeight());
    }//GEN-LAST:event_jButtonAddItemActionPerformed

    // Reads all textfields and replaces parameters
    @SuppressWarnings("unchecked")
    private void jButtonPopupHinzufügenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPopupHinzufügenActionPerformed
        newItem.setName(jTextFieldItemName.getText());
        newItem.setCategory(jTextFieldItemCategory.getText());
        newItem.setAmount(jTextFieldItemAmount.getText());
        newItem.setPrice(jTextFieldItemPrice.getText());
        
        // Checks, wheter name and amount are inserted or not
        if(!newItem.getName().isEmpty() && !newItem.getAmount().isEmpty()) {
            model.addElement(newItem);
        } else {
            System.out.println("Error occured, please insert name and amount");
        }
        
        if(jCheckBoxItemPriority.isSelected()) {
                pmodel.addElement(newItem);
            }
        
        // Resets textfields to null, unchecks priority and closes popupmenu
        jPopupMenu1.setVisible(false);
        jTextFieldItemName.setText("");
        jTextFieldItemCategory.setText("");
        jTextFieldItemAmount.setText("");
        jTextFieldItemPrice.setText("");
        jCheckBoxItemPriority.setSelected(false);
        
    }//GEN-LAST:event_jButtonPopupHinzufügenActionPerformed

    // Checks and sets priority (located in popupmenu)
    private void jCheckBoxItemPriorityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxItemPriorityActionPerformed
        if(jCheckBoxItemPriority.isSelected()) {
            newItem.setPriority(1);
        } else {
            newItem.setPriority(0);
        }   
    }//GEN-LAST:event_jCheckBoxItemPriorityActionPerformed

    // Decides which listmodel to show (located in UI head)
    @SuppressWarnings("unchecked")
    private void jCheckPriorityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckPriorityMouseClicked
        // Prints only items with priority
        if(jCheckPriority.isSelected()) {
        jShoppingList.setModel(pmodel);
        // Prints only items without priority
        }else {
            jShoppingList.setModel(model);        
        }
    }//GEN-LAST:event_jCheckPriorityMouseClicked

    // Deletes items from jList (and Database)
    private void jButtonDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDeleteMouseClicked
        int selectedIndex = jShoppingList.getSelectedIndex();
        if (selectedIndex != -1) {
            model.remove(selectedIndex);
            }
    }//GEN-LAST:event_jButtonDeleteMouseClicked

    // Edits shoppinglistname in UI head
    private void jTextFieldShoppingListNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldShoppingListNameMouseClicked
        jTextFieldShoppingListName.setText("");
    }//GEN-LAST:event_jTextFieldShoppingListNameMouseClicked
                                   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddItem;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonPopupHinzufügen;
    private javax.swing.JCheckBox jCheckBoxItemPriority;
    private javax.swing.JCheckBox jCheckPriority;
    private javax.swing.JLabel jLabelItemAmount;
    private javax.swing.JLabel jLabelItemCategory;
    private javax.swing.JLabel jLabelItemName;
    private javax.swing.JLabel jLabelItemPrice;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> jShoppingList;
    private javax.swing.JTextField jTextFieldItemAmount;
    private javax.swing.JTextField jTextFieldItemCategory;
    private javax.swing.JTextField jTextFieldItemName;
    private javax.swing.JTextField jTextFieldItemPrice;
    private javax.swing.JTextField jTextFieldShoppingListName;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingList;

import DatabaseHelpers.DatabaseHelper;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author dorie
 */
public class UI extends javax.swing.JFrame {
    
    private Item newItem;
    private DatabaseHelper dbh;

    /**
     * Creates new form UI
     */
    public UI() {
        initComponents();
        jPopupMenu1.add(jLabel1);
        jPopupMenu1.add(jTextField1);
        jPopupMenu1.add(jLabel2);
        jPopupMenu1.add(jTextField2);
        jPopupMenu1.add(jCheckBox1);
        jPopupMenu1.add(jLabel3);
        jPopupMenu1.add(jTextField3);
        jPopupMenu1.add(jButton2);
        dbh = new DatabaseHelper();
        //System.out.println(list1 + "Liste vor addItem");
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
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("Produktname");

        jTextField1.setText(null);
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jLabel2.setText("Kategorie");

        jTextField2.setText(null);
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });

        jCheckBox1.setText("Priorität");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Anzahl");

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
        });

        jButton2.setText("Hinzufügen");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(303, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(280, 280, 280))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(563, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(438, 438, 438))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        newItem = new Item(null, null, null, null, null, 0, 0);
        System.out.println(newItem.toString() + " &jButton1");
        jPopupMenu1.show(jButton1, -jButton1.getWidth(), -jButton1.getHeight()*2);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            //System.out.println("Text Field 1 Enter Pressed");
            System.out.println(jTextField1.getText());
            newItem.setName(jTextField1.getText());
            System.out.println(newItem.toString());
            }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //System.out.println(jTextField1.getText());
        //System.out.println(jTextField2.getText());
        
        newItem.setName(jTextField1.getText());
        newItem.setCategory(jTextField2.getText());
        newItem.setAmount(jTextField3.getText());
        
        if(jTextField1.getText() != null && jTextField2.getText() != null){
            //list1.addItem(newItem);
            //System.out.println(list1 + "Liste nach addItem");
            //list1.replaceItem(newItem, newItem);
            dbh.addItem("", "", "", "", "", 0, 0);
            System.out.println(newItem.toString());
            System.out.println(list1.toString());
        }
        jPopupMenu1.setVisible(false);
        list1.saveList();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            //System.out.println("Text Field 2 Enter Pressed");
            System.out.println(jTextField2.getText());
            newItem.setCategory(jTextField2.getText());
            System.out.println(newItem.toString());
            }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if(jCheckBox1.isSelected()) {
            newItem.setPriority(1);
            System.out.println("Checkbox selected " + newItem.getPriority());
            System.out.println(newItem.toString());
        } else {
            newItem.setPriority(0);
            System.out.println(newItem.toString());
        }   
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            //System.out.println("Text Field 3 Enter Pressed");
            System.out.println(jTextField3.getText());
            newItem.setAmount(jTextField3.getText());
            System.out.println(newItem.toString());
            }
    }//GEN-LAST:event_jTextField3KeyPressed
    
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
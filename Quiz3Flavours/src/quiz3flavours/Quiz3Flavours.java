/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz3flavours;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import quiz3flavours.entity.Flavour;
import quiz3flavours.entity.PlacedOrder;

/**
 *
 * @author ipd
 */
public class Quiz3Flavours extends javax.swing.JFrame {
    Database db;
    DefaultListModel<Flavour> modelFlavourList1 = new DefaultListModel<>();
    DefaultListModel<Flavour> modelFlavourList2 = new DefaultListModel<>();
    DefaultListModel<PlacedOrder> modelPlacedOrderList = new DefaultListModel<>();
    
    /**
     * Creates new form Quiz3Flavours
     */
    public Quiz3Flavours() {
        try {
            db = new Database();
            initComponents();
            dlgManage.pack();
            refreshFlavourList1();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "failed to open database connection ",
                    "Database error",
                    JOptionPane.WARNING_MESSAGE);
            System.exit(1);
        }

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        centerOnParent(dlgManage, true);
    }

     final public void centerOnParent(final Window child, final boolean absolute) {
        child.pack();
        boolean useChildsOwner = child.getOwner() != null ? ((child.getOwner() instanceof JFrame) || (child.getOwner() instanceof JDialog)) : false;
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final Dimension parentSize = useChildsOwner ? child.getOwner().getSize() : screenSize;
        final Point parentLocationOnScreen = useChildsOwner ? child.getOwner().getLocationOnScreen() : new Point(0, 0);
        final Dimension childSize = child.getSize();
        childSize.width = Math.min(childSize.width, screenSize.width);
        childSize.height = Math.min(childSize.height, screenSize.height);
        child.setSize(childSize);
        int x;
        int y;
        if ((child.getOwner() != null) && child.getOwner().isShowing()) {
            x = (parentSize.width - childSize.width) / 2;
            y = (parentSize.height - childSize.height) / 2;
            x += parentLocationOnScreen.x;
            y += parentLocationOnScreen.y;
        } else {
            x = (screenSize.width - childSize.width) / 2;
            y = (screenSize.height - childSize.height) / 2;
        }
        if (!absolute) {
            x /= 2;
            y /= 2;
        }
        child.setLocation(x, y);
    }
    
    private void refreshFlavourList1() {
        try {
            ArrayList<Flavour> customerList = db.getAllFlavour();
            modelFlavourList1.clear();
            for (Flavour f : customerList) {
                modelFlavourList1.addElement(f);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Failded execute database query",
                    "Database error",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
    
         
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgManage = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        btDlgDismiss = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstPlacedOrder = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstFlavour1 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        tfCustName = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstFlavour2 = new javax.swing.JList<>();
        btAdd = new javax.swing.JButton();
        btManage = new javax.swing.JButton();
        btPlace = new javax.swing.JButton();

        jLabel3.setText("Orders:");

        btDlgDismiss.setText("Dismiss");
        btDlgDismiss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDlgDismissActionPerformed(evt);
            }
        });

        lstPlacedOrder.setModel(modelPlacedOrderList);
        jScrollPane3.setViewportView(lstPlacedOrder);

        javax.swing.GroupLayout dlgManageLayout = new javax.swing.GroupLayout(dlgManage.getContentPane());
        dlgManage.getContentPane().setLayout(dlgManageLayout);
        dlgManageLayout.setHorizontalGroup(
            dlgManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgManageLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(dlgManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dlgManageLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addGroup(dlgManageLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btDlgDismiss)
                        .addGap(108, 108, 108))))
        );
        dlgManageLayout.setVerticalGroup(
            dlgManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgManageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dlgManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btDlgDismiss))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Flavours:");

        lstFlavour1.setModel(modelFlavourList1);
        jScrollPane1.setViewportView(lstFlavour1);

        jLabel2.setText("CustName:");

        tfCustName.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tfCustNamePropertyChange(evt);
            }
        });
        tfCustName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfCustNameKeyPressed(evt);
            }
        });

        lstFlavour2.setModel(modelFlavourList2);
        lstFlavour2.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstFlavour2ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstFlavour2);

        btAdd.setText("Add->");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btManage.setText("Manage orders");
        btManage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btManageActionPerformed(evt);
            }
        });

        btPlace.setText("Place order");
        btPlace.setEnabled(false);
        btPlace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPlaceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btAdd))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(tfCustName, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btManage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                        .addComponent(btPlace)
                        .addGap(90, 90, 90))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(tfCustName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btAdd)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btManage)
                    .addComponent(btPlace))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        Flavour f1 = modelFlavourList1.get(lstFlavour1.getSelectedIndex());        
        if (f1 == null) {
            JOptionPane.showMessageDialog(this,
                    "Data cannot be empty",
                    "Database error",
                    JOptionPane.WARNING_MESSAGE);
        } else {
                modelFlavourList2.addElement(f1);
        }// TODO add your handling code here:
    }//GEN-LAST:event_btAddActionPerformed

    private void btPlaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPlaceActionPerformed
        String flavourList = "";
        for (int i = 0; i < modelFlavourList2.size(); i++) {
            flavourList  = flavourList + modelFlavourList2.get(i).name + ",";
        }                
       
        String custName = tfCustName.getText();        
        try {
            db.addPlacedOrder(custName,flavourList);
        } catch (SQLException ex) {
            Logger.getLogger(Quiz3Flavours.class.getName()).log(Level.SEVERE, null, ex);
        }
        modelFlavourList2.clear();
        tfCustName.setText(" ");
    }//GEN-LAST:event_btPlaceActionPerformed

    private void lstFlavour2ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstFlavour2ValueChanged
       enableButtonWhenBothSelected();
    }//GEN-LAST:event_lstFlavour2ValueChanged

    private void tfCustNamePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tfCustNamePropertyChange
       
    }//GEN-LAST:event_tfCustNamePropertyChange

    private void tfCustNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCustNameKeyPressed
        enableButtonWhenBothSelected();
    }//GEN-LAST:event_tfCustNameKeyPressed

    private void btManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btManageActionPerformed
        dlgManage.setVisible(true);
        try {
            ArrayList<PlacedOrder> OrderList = db.getAllPlacedOrder();
            for(PlacedOrder p: OrderList) {
                modelPlacedOrderList.addElement(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Quiz3Flavours.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btManageActionPerformed

    private void btDlgDismissActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDlgDismissActionPerformed
        dlgManage.setVisible(false);
    }//GEN-LAST:event_btDlgDismissActionPerformed
    
    private void enableButtonWhenBothSelected() {
         int idx1 = lstFlavour2.getSelectedIndex();
         boolean idx2 = tfCustName.getText().equals(" ");
         boolean enabled = idx1 >= 0 && !idx2 ;
         btPlace.setEnabled(enabled);
    }
    
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
            java.util.logging.Logger.getLogger(Quiz3Flavours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quiz3Flavours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quiz3Flavours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quiz3Flavours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quiz3Flavours().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btDlgDismiss;
    private javax.swing.JButton btManage;
    private javax.swing.JButton btPlace;
    private javax.swing.JDialog dlgManage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<Flavour> lstFlavour1;
    private javax.swing.JList<Flavour> lstFlavour2;
    private javax.swing.JList<PlacedOrder> lstPlacedOrder;
    private javax.swing.JTextField tfCustName;
    // End of variables declaration//GEN-END:variables
}

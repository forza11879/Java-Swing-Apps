/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainquiz3;

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
import javax.swing.ListModel;
import newpackage.entity.Flavour;
import newpackage.entity.PlacedOrder;

/**
 *
 * @author ipd
 */
public class MainWindow extends javax.swing.JFrame {

    Database db;
    DefaultListModel<Flavour> modelFlavourList = new DefaultListModel<>();
    DefaultListModel<Flavour> modelOrderFlavourList = new DefaultListModel<>();
    DefaultListModel<PlacedOrder> modelPlacedOrderFlavourList = new DefaultListModel<>();

    public MainWindow() {
        try {
            db = new Database();
            initComponents();
            refreshFlavourList();
            //center window
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
            dlgPlacedOrders.setLocationRelativeTo(this);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Failed to open databse connection",
                    "Database error",
                    JOptionPane.WARNING_MESSAGE);
            System.exit(1);
        }

        centerOnParent(dlgPlacedOrders, true);
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

    private void refreshFlavourList() {
        try {
            //fetch the data from database
            ArrayList<Flavour> lstFlavour = db.getAllFlavour();
            //first clear data in the model
            modelFlavourList.clear();
            for (Flavour f : lstFlavour) {
                modelFlavourList.addElement(f);
                //then add it
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Failed execute database query",
                    "Database error",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void enableButtonWhenBothSelected() {
        int idx1 = lstOrderFlavour.getSelectedIndex();
        boolean idx2 = tfCustomerName.getText().equals(" ");
        boolean enabled = idx1 >= 0 && !idx2;
        btnPlaceOrder.setEnabled(enabled);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgPlacedOrders = new javax.swing.JDialog();
        lblDlgOrders = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstPlacedOrder = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        lblFlavours = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstFlavour = new javax.swing.JList<>();
        lblCustomerName = new javax.swing.JLabel();
        tfCustomerName = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstOrderFlavour = new javax.swing.JList<>();
        btnAdd = new javax.swing.JButton();
        btnManageOrders = new javax.swing.JButton();
        btnPlaceOrder = new javax.swing.JButton();

        dlgPlacedOrders.setMinimumSize(new java.awt.Dimension(800, 600));

        lblDlgOrders.setText("Orders:");

        lstPlacedOrder.setModel(modelPlacedOrderFlavourList);
        jScrollPane3.setViewportView(lstPlacedOrder);

        jButton1.setText("Dismiss");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dlgPlacedOrdersLayout = new javax.swing.GroupLayout(dlgPlacedOrders.getContentPane());
        dlgPlacedOrders.getContentPane().setLayout(dlgPlacedOrdersLayout);
        dlgPlacedOrdersLayout.setHorizontalGroup(
            dlgPlacedOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgPlacedOrdersLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(196, Short.MAX_VALUE))
            .addGroup(dlgPlacedOrdersLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(lblDlgOrders)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(60, 60, 60))
        );
        dlgPlacedOrdersLayout.setVerticalGroup(
            dlgPlacedOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgPlacedOrdersLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(dlgPlacedOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDlgOrders)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(170, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));

        lblFlavours.setText("Flavours :");

        lstFlavour.setModel(modelFlavourList);
        jScrollPane1.setViewportView(lstFlavour);

        lblCustomerName.setText("Customer Name:");

        tfCustomerName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfCustomerNameKeyPressed(evt);
            }
        });

        lstOrderFlavour.setModel(modelOrderFlavourList);
        lstOrderFlavour.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstOrderFlavourValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstOrderFlavour);

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnManageOrders.setText("Manage orders");
        btnManageOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageOrdersActionPerformed(evt);
            }
        });

        btnPlaceOrder.setText("Place Order");
        btnPlaceOrder.setEnabled(false);
        btnPlaceOrder.setSelected(true);
        btnPlaceOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlaceOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(lblFlavours)
                        .addGap(304, 304, 304)
                        .addComponent(lblCustomerName)
                        .addGap(18, 18, 18)
                        .addComponent(tfCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(116, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(btnManageOrders)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPlaceOrder)
                .addGap(222, 222, 222))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lblFlavours))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCustomerName)
                            .addComponent(tfCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(btnAdd)))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnManageOrders)
                    .addComponent(btnPlaceOrder))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        /*
        int index = lstFlavour.getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(this,
                    "You must select a flavour first",
                    "Selection missing",
                    JOptionPane.WARNING_MESSAGE);
            return;

        }
        ListModel<Flavour> model = lstFlavour.getModel(); //give access to the abstract model
        Flavour flavour = model.getElementAt(index);
        System.out.printf("Selected: %d = %s\n", index, flavour);
        modelOrderFlavourList.addElement(flavour.name);
         */
        Flavour flavour = modelFlavourList.get(lstFlavour.getSelectedIndex());
        if (flavour == null) {
            JOptionPane.showMessageDialog(this,
                    "Data cannot be empty",
                    "Database error",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            modelOrderFlavourList.addElement(flavour);
        }


    }//GEN-LAST:event_btnAddActionPerformed

    private void btnPlaceOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlaceOrderActionPerformed
        String flavourList = "";
        for (int i = 0; i < modelOrderFlavourList.size(); i++) {
            flavourList = flavourList + modelOrderFlavourList.get(i).name + ",";
        }

        String customerName = tfCustomerName.getText();
        try {
            db.addOrder(customerName, flavourList);
        } catch (SQLException ex) {
            // Logger.getLogger(Quiz3Flavours.class.getName()).log(Level.SEVERE, null, ex);
        }
        modelOrderFlavourList.clear();
        tfCustomerName.setText(" ");
    }//GEN-LAST:event_btnPlaceOrderActionPerformed

    private void tfCustomerNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCustomerNameKeyPressed
        enableButtonWhenBothSelected();
    }//GEN-LAST:event_tfCustomerNameKeyPressed

    private void lstOrderFlavourValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstOrderFlavourValueChanged
        enableButtonWhenBothSelected();
    }//GEN-LAST:event_lstOrderFlavourValueChanged

    private void btnManageOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageOrdersActionPerformed
        //Causes this Window to be sized to fit the preferred size and layouts of its subcomponents
        dlgPlacedOrders.pack();
        //set the dialog window visible
        dlgPlacedOrders.setVisible(true);

        try {
            //fetch the data from database
            ArrayList<PlacedOrder> lstPlacedOrder = db.getAllPlacedOrder();
            //first clear data in the model
            modelPlacedOrderFlavourList.clear();
            for (PlacedOrder p : lstPlacedOrder) {
                modelPlacedOrderFlavourList.addElement(p);
                //then add it
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Failed execute database query",
                    "Database error",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnManageOrdersActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       dlgPlacedOrders.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnManageOrders;
    private javax.swing.JButton btnPlaceOrder;
    private javax.swing.JDialog dlgPlacedOrders;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCustomerName;
    private javax.swing.JLabel lblDlgOrders;
    private javax.swing.JLabel lblFlavours;
    private javax.swing.JList<Flavour> lstFlavour;
    private javax.swing.JList<Flavour> lstOrderFlavour;
    private javax.swing.JList<PlacedOrder> lstPlacedOrder;
    private javax.swing.JTextField tfCustomerName;
    // End of variables declaration//GEN-END:variables
}

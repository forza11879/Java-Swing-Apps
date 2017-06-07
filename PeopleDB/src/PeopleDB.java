
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ipd
 */
public class PeopleDB extends javax.swing.JFrame {

    Database db;
    //create dedault model list
    DefaultListModel<Person> modelPersonList = new DefaultListModel<>();

    public PeopleDB() {
        try {
            db = new Database();
            initComponents();
            //
            //center window
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
            dlgEditPeople.setLocationRelativeTo(this);
            //showw the list at the start
            refreshPersonList();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Failed to open databse connection",
                    "Database error",
                    JOptionPane.WARNING_MESSAGE);
            System.exit(1);
        }

        centerOnParent(dlgEditPeople, true);
    }

    // Center on parent ( absolute true/false (exact center or 25% upper left) )
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu = new javax.swing.JPopupMenu();
        rightClickDeteleteItem = new javax.swing.JMenuItem();
        dlgEditPeople = new javax.swing.JDialog();
        lblDlgName = new javax.swing.JLabel();
        tfDlgName = new javax.swing.JTextField();
        lblDlgAge = new javax.swing.JLabel();
        tfDlgAge = new javax.swing.JTextField();
        btnDlgSaveChanges = new javax.swing.JButton();
        btnDlgCancel = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        lblAge = new javax.swing.JLabel();
        tfAge = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPersonList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        tfEnterID = new javax.swing.JTextField();

        rightClickDeteleteItem.setText("Delete Item");
        rightClickDeteleteItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rightClickDeteleteItemMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rightClickDeteleteItemMouseReleased(evt);
            }
        });
        rightClickDeteleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightClickDeteleteItemActionPerformed(evt);
            }
        });
        popupMenu.add(rightClickDeteleteItem);

        lblDlgName.setText("Name:");

        lblDlgAge.setText("Age:");

        btnDlgSaveChanges.setText("Save Changes");

        btnDlgCancel.setText("Cancel");

        javax.swing.GroupLayout dlgEditPeopleLayout = new javax.swing.GroupLayout(dlgEditPeople.getContentPane());
        dlgEditPeople.getContentPane().setLayout(dlgEditPeopleLayout);
        dlgEditPeopleLayout.setHorizontalGroup(
            dlgEditPeopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgEditPeopleLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(dlgEditPeopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dlgEditPeopleLayout.createSequentialGroup()
                        .addGroup(dlgEditPeopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDlgAge)
                            .addComponent(lblDlgName))
                        .addGroup(dlgEditPeopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dlgEditPeopleLayout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(tfDlgName, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgEditPeopleLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(tfDlgAge, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(dlgEditPeopleLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btnDlgSaveChanges)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                        .addComponent(btnDlgCancel)
                        .addGap(70, 70, 70))))
        );
        dlgEditPeopleLayout.setVerticalGroup(
            dlgEditPeopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgEditPeopleLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(dlgEditPeopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDlgName)
                    .addComponent(tfDlgName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(dlgEditPeopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDlgAge)
                    .addComponent(tfDlgAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(dlgEditPeopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDlgSaveChanges)
                    .addComponent(btnDlgCancel))
                .addGap(56, 56, 56))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblName.setText("Name:");

        lblAge.setText("Age:");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lstPersonList.setModel(modelPersonList);
        lstPersonList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstPersonListMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lstPersonListMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(lstPersonList);

        jLabel2.setText("Enter the ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblAge)
                        .addGap(18, 18, 18)
                        .addComponent(tfAge, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnAdd))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2)
                        .addGap(31, 31, 31)
                        .addComponent(tfEnterID, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAge)
                    .addComponent(tfAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfEnterID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(149, 149, 149))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        //we grab the name from GUI and send it to DB
        String name = tfName.getText();
        int age = Integer.parseInt(tfAge.getText());
//anytime when you connect to DB you have to handle the exception
        try {
// and add info from GUI to DB
            db.addPerson(name, age);
            //when you added the person it will refresh 
            refreshPersonList();
            //clean the entry fields
            tfName.setText("");
            tfAge.setText("");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Failed to open databse connection",
                    "Database error",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void rightClickDeteleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightClickDeteleteItemActionPerformed

    }//GEN-LAST:event_rightClickDeteleteItemActionPerformed

    private void rightClickDeteleteItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rightClickDeteleteItemMouseReleased
        int index = lstPersonList.getSelectedIndex();
        Person p = modelPersonList.get(index);
        //Custom button text
        Object[] options = {"Delete", "Cancel"};
        int choice = JOptionPane.showOptionDialog(this,
                "Are you sure you want to delete item: \n" + p,
                "Confirm deletion",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        if (choice == 0) {
            //modelPersonList.remove(index);
           // db.removePerson(name, age);
        }
    }//GEN-LAST:event_rightClickDeteleteItemMouseReleased

    private void lstPersonListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstPersonListMouseReleased
        // right click mouse         
        if ((evt.getButton() == MouseEvent.BUTTON3) && (evt.getClickCount() == 1)) {
            lstPersonList.setSelectedIndex(lstPersonList.locationToIndex(evt.getPoint()));
            if (lstPersonList.getSelectedIndex() != -1) {
                popupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_lstPersonListMouseReleased

    private void rightClickDeteleteItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rightClickDeteleteItemMouseClicked

    }//GEN-LAST:event_rightClickDeteleteItemMouseClicked

    private void lstPersonListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstPersonListMouseClicked
        if ((evt.getButton() == MouseEvent.BUTTON1) && (evt.getClickCount() == 2)) {
            // left button, double-click
            lstPersonList.setSelectedIndex(lstPersonList.locationToIndex(evt.getPoint()));
            int index = lstPersonList.getSelectedIndex();
            if (index != -1) {
                Person p = modelPersonList.get(index);
                // fill in data of Person double-clicked for editing
                tfDlgName.setText(p.name);
                tfDlgAge.setText(p.age + "");

                // show dialog
                dlgEditPeople.setVisible(true);
            }
        }
    }//GEN-LAST:event_lstPersonListMouseClicked

    private void refreshPersonList() {
        try {
            //fetch the data from database
            ArrayList<Person> personList = db.getAllPersons();
            //first clear data in the model
            modelPersonList.clear();
            for (Person p : personList) {
                modelPersonList.addElement(p);
                //then add it

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Failed to open databse connection",
                    "Database error",
                    JOptionPane.WARNING_MESSAGE);
        }
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
            java.util.logging.Logger.getLogger(PeopleDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PeopleDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PeopleDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PeopleDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        // show the Jframe 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PeopleDB().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDlgCancel;
    private javax.swing.JButton btnDlgSaveChanges;
    private javax.swing.JDialog dlgEditPeople;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblDlgAge;
    private javax.swing.JLabel lblDlgName;
    private javax.swing.JLabel lblName;
    private javax.swing.JList<Person> lstPersonList;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JMenuItem rightClickDeteleteItem;
    private javax.swing.JTextField tfAge;
    private javax.swing.JTextField tfDlgAge;
    private javax.swing.JTextField tfDlgName;
    private javax.swing.JTextField tfEnterID;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables
}

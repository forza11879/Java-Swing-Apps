
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
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
public class CarPractice extends javax.swing.JFrame {
DefaultListModel<Car> modelCarList = new DefaultListModel<>();


    public CarPractice() {
        initComponents();
        
        //center window
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        dlgEditCar.setLocationRelativeTo(this);
        
        // hide error labels
        lblNameModelError.setVisible(false);
        lblYearOfProductionError.setVisible(false);
        lblAccelerationError.setVisible(false);
        
        //
        //centerOnParent(dlgEditPerson, true);
        
    }
    
    

    private boolean isCarDataValid(String nameModel, JLabel nameError,
            String yearStr, JLabel ageError, String accelerationStr, JLabel postcodeError) {
        
        boolean isNameModelInvalid = (nameModel.length() < 2 || nameModel.length() > 30);
        lblNameModelError.setVisible(isNameModelInvalid);
        //
        int yop = 0;
        boolean isYOPInvalid;
        try {
            yop = Integer.parseInt(yearStr);
            isYOPInvalid = yop < 1900 || yop > 2050;
        } catch (NumberFormatException e) {
            isYOPInvalid = true;
        }
        lblYearOfProductionError.setVisible(isYOPInvalid);
        //
        double acceleration = 0;
        boolean isAccelerationInvalid;
        try {
            acceleration = Double.parseDouble(accelerationStr);
            isAccelerationInvalid = acceleration < 1 || acceleration > 1000;
        } catch (NumberFormatException e) {
            isAccelerationInvalid = true;
        }
        lblAccelerationError.setVisible(isAccelerationInvalid);
        //
        return (!(isNameModelInvalid || isYOPInvalid || isAccelerationInvalid));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgEditCar = new javax.swing.JDialog();
        tfDlgYearOfProduction = new javax.swing.JTextField();
        tfDlgAcceleration = new javax.swing.JTextField();
        lblDlgYearOfProductionError = new javax.swing.JLabel();
        lblDlgAccelerationError = new javax.swing.JLabel();
        lblDlgNameModelError = new javax.swing.JLabel();
        lblNameModel1 = new javax.swing.JLabel();
        lblYeatOfProduction1 = new javax.swing.JLabel();
        lblAcceleration1 = new javax.swing.JLabel();
        tfDlgNameModel = new javax.swing.JTextField();
        lblDlgWhatWould = new javax.swing.JLabel();
        btnDlgSaveChanges = new javax.swing.JButton();
        btnDlgCancel = new javax.swing.JButton();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        deleteRightClick = new javax.swing.JMenuItem();
        lblMyGarage = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstMyCars = new javax.swing.JList<>();
        lblNameModel = new javax.swing.JLabel();
        lblYeatOfProduction = new javax.swing.JLabel();
        lblAcceleration = new javax.swing.JLabel();
        tfNameModel = new javax.swing.JTextField();
        tfYearOfProduction = new javax.swing.JTextField();
        tfAcceleration = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        lblYearOfProductionError = new javax.swing.JLabel();
        lblAccelerationError = new javax.swing.JLabel();
        lblNameModelError = new javax.swing.JLabel();

        lblDlgYearOfProductionError.setForeground(java.awt.Color.red);
        lblDlgYearOfProductionError.setText("Year of production must be between 1900 and 2050");

        lblDlgAccelerationError.setForeground(java.awt.Color.red);
        lblDlgAccelerationError.setText("Acceleration must be 1 - 1000 sec");

        lblDlgNameModelError.setForeground(java.awt.Color.red);
        lblDlgNameModelError.setText("name must be 2-30 characters, no semicolons");

        lblNameModel1.setText("Model Name:");

        lblYeatOfProduction1.setText("Year of Production:");

        lblAcceleration1.setText("1-1000");

        lblDlgWhatWould.setText("What would you like to do ?");

        btnDlgSaveChanges.setText("Save Changes");

        btnDlgCancel.setText("Cancel");

        javax.swing.GroupLayout dlgEditCarLayout = new javax.swing.GroupLayout(dlgEditCar.getContentPane());
        dlgEditCar.getContentPane().setLayout(dlgEditCarLayout);
        dlgEditCarLayout.setHorizontalGroup(
            dlgEditCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgEditCarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dlgEditCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(dlgEditCarLayout.createSequentialGroup()
                        .addGroup(dlgEditCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblYeatOfProduction1)
                            .addComponent(lblAcceleration1))
                        .addGap(24, 24, 24)
                        .addGroup(dlgEditCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfDlgAcceleration)
                            .addComponent(tfDlgYearOfProduction)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dlgEditCarLayout.createSequentialGroup()
                        .addComponent(lblNameModel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(tfDlgNameModel, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(81, 81, 81))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgEditCarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(dlgEditCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgEditCarLayout.createSequentialGroup()
                        .addComponent(lblDlgYearOfProductionError)
                        .addGap(132, 132, 132))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgEditCarLayout.createSequentialGroup()
                        .addComponent(lblDlgNameModelError)
                        .addGap(145, 145, 145))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgEditCarLayout.createSequentialGroup()
                        .addGroup(dlgEditCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDlgWhatWould)
                            .addComponent(lblDlgAccelerationError))
                        .addGap(172, 172, 172))))
            .addGroup(dlgEditCarLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btnDlgSaveChanges)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDlgCancel)
                .addGap(70, 70, 70))
        );
        dlgEditCarLayout.setVerticalGroup(
            dlgEditCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgEditCarLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(dlgEditCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDlgNameModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNameModel1))
                .addGap(18, 18, 18)
                .addComponent(lblDlgNameModelError)
                .addGap(30, 30, 30)
                .addGroup(dlgEditCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDlgYearOfProduction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblYeatOfProduction1))
                .addGap(18, 18, 18)
                .addComponent(lblDlgYearOfProductionError)
                .addGap(53, 53, 53)
                .addGroup(dlgEditCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDlgAcceleration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAcceleration1))
                .addGap(18, 18, 18)
                .addComponent(lblDlgAccelerationError)
                .addGap(18, 18, 18)
                .addComponent(lblDlgWhatWould)
                .addGap(18, 18, 18)
                .addGroup(dlgEditCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDlgSaveChanges)
                    .addComponent(btnDlgCancel))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        deleteRightClick.setText("jMenuItem1");
        deleteRightClick.setActionCommand("Delete Item");
        deleteRightClick.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteRightClickMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                deleteRightClickMouseReleased(evt);
            }
        });
        deleteRightClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRightClickActionPerformed(evt);
            }
        });
        jPopupMenu1.add(deleteRightClick);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblMyGarage.setText("My Cars");

        lstMyCars.setModel(modelCarList);
        lstMyCars.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstMyCarsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstMyCars);

        lblNameModel.setText("Model Name:");

        lblYeatOfProduction.setText("Year of Production:");

        lblAcceleration.setText("1-1000");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblYearOfProductionError.setForeground(java.awt.Color.red);
        lblYearOfProductionError.setText("Year of production must be between 1900 and 2050");

        lblAccelerationError.setForeground(java.awt.Color.red);
        lblAccelerationError.setText("Acceleration must be 1 - 1000 sec");

        lblNameModelError.setForeground(java.awt.Color.red);
        lblNameModelError.setText("name must be 2-30 characters, no semicolons");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(lblMyGarage))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblYeatOfProduction)
                                    .addComponent(lblNameModel)
                                    .addComponent(lblAcceleration))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfNameModel, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                                    .addComponent(tfYearOfProduction)
                                    .addComponent(tfAcceleration)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblNameModelError)
                                        .addGap(50, 50, 50))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblYearOfProductionError)
                                        .addGap(53, 53, 53)))))))
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblAccelerationError)
                        .addGap(142, 142, 142))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(193, 193, 193))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(lblMyGarage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNameModel)
                            .addComponent(tfNameModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNameModelError)
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblYeatOfProduction)
                            .addComponent(tfYearOfProduction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblYearOfProductionError)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAcceleration)
                            .addComponent(tfAcceleration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAccelerationError)
                .addGap(37, 37, 37)
                .addComponent(btnAdd)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String nameModel = tfNameModel.getText();
        String yearStr = tfYearOfProduction.getText();
        String accelerationStr = tfAcceleration.getText();
        //        
        if (isCarDataValid(nameModel, lblNameModelError, yearStr, lblYearOfProductionError, accelerationStr, lblAccelerationError)) {
            modelCarList.addElement(new Car(nameModel, Integer.parseInt(yearStr), Double.parseDouble(accelerationStr)));
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void lstMyCarsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstMyCarsMouseClicked
        if ((evt.getButton() == MouseEvent.BUTTON1) && (evt.getClickCount() == 2)) {
            // left button, double-click
            lstMyCars.setSelectedIndex(lstMyCars.locationToIndex(evt.getPoint()));
            int index = lstMyCars.getSelectedIndex();
            if (index != -1) {
                Car p = modelCarList.get(index);
                // fill in data of Person double-clicked for editing
                tfDlgNameModel.setText(p.nameModel);
                tfDlgYearOfProduction.setText(p.yop + "");
                //tfDlgAcceleration.setText(p.acceleration);
                // hide errors
                lblDlgNameModelError.setVisible(false);
                lblDlgYearOfProductionError.setVisible(false);
                lblDlgAccelerationError.setVisible(false);
                // show dialog
                dlgEditCar.setVisible(true);
            }
        }
    }//GEN-LAST:event_lstMyCarsMouseClicked

    private void deleteRightClickMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteRightClickMouseReleased
     int index = lstMyCars.getSelectedIndex();
        Car p = modelCarList.get(index);
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
            modelCarList.remove(index);
        }
    }//GEN-LAST:event_deleteRightClickMouseReleased

    private void deleteRightClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRightClickActionPerformed
      int index = lstMyCars.getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(this,
                    "You must select a line first",
                    "Selection missing",
                    JOptionPane.WARNING_MESSAGE);
            return;

        }
        modelCarList.remove(index);
    }//GEN-LAST:event_deleteRightClickActionPerformed

    private void deleteRightClickMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteRightClickMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteRightClickMouseClicked

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
            java.util.logging.Logger.getLogger(CarPractice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarPractice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarPractice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarPractice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarPractice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDlgCancel;
    private javax.swing.JButton btnDlgSaveChanges;
    private javax.swing.JMenuItem deleteRightClick;
    private javax.swing.JDialog dlgEditCar;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAcceleration;
    private javax.swing.JLabel lblAcceleration1;
    private javax.swing.JLabel lblAccelerationError;
    private javax.swing.JLabel lblDlgAccelerationError;
    private javax.swing.JLabel lblDlgNameModelError;
    private javax.swing.JLabel lblDlgWhatWould;
    private javax.swing.JLabel lblDlgYearOfProductionError;
    private javax.swing.JLabel lblMyGarage;
    private javax.swing.JLabel lblNameModel;
    private javax.swing.JLabel lblNameModel1;
    private javax.swing.JLabel lblNameModelError;
    private javax.swing.JLabel lblYearOfProductionError;
    private javax.swing.JLabel lblYeatOfProduction;
    private javax.swing.JLabel lblYeatOfProduction1;
    private javax.swing.JList<Car> lstMyCars;
    private javax.swing.JTextField tfAcceleration;
    private javax.swing.JTextField tfDlgAcceleration;
    private javax.swing.JTextField tfDlgNameModel;
    private javax.swing.JTextField tfDlgYearOfProduction;
    private javax.swing.JTextField tfNameModel;
    private javax.swing.JTextField tfYearOfProduction;
    // End of variables declaration//GEN-END:variables
}

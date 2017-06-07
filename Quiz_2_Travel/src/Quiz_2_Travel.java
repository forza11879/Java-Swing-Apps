
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ipd
 */
public class Quiz_2_Travel extends javax.swing.JFrame {

    DefaultListModel<Travel> modelTravelList = new DefaultListModel<>();
    File currentFile;
    Travel t;
    boolean isModified;

    //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    public Quiz_2_Travel() {
        initComponents();
        //center window
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        dlgAddTrip.setLocationRelativeTo(this);

        //
        
        // hide error labels
        lblDlgDestinationError.setVisible(false);
        lblDlgTravellerNameError.setVisible(false);
        lblDlgTravellerPassportNoError.setVisible(false);
        lblDlgDepartureDateError.setVisible(false);
        lblDlgReturnDateError.setVisible(false);

        //
        centerOnParent(dlgAddTrip, true);
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

    private void doExitAction() {
        if (isModified) {
            Object[] options = {"Save",
                "Discard changes",
                "Cancel"};
            int choice = JOptionPane.showOptionDialog(this,
                    "Would you like to save changes before closing?",
                    "Unsaved changes to current file",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[2]);
            //
            switch (choice) {
                case JOptionPane.YES_OPTION:
                    if (doSaveAction()) {
                        dispose();
                    }
                    break;
                case JOptionPane.NO_OPTION:
                    dispose();
                    break;
                case JOptionPane.CANCEL_OPTION:
                default:
                    
            }
        } else { // not modified - close window
            dispose();
        }
    }

    private void docModified(boolean is) {
        isModified = is;
        if (is) {
            setTitle("(document modified)");
        } else {
            setTitle("");
        }
    }

      public static Date removeTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    private boolean doSaveAction() {
        saveFileChooser.setFileFilter(new FileNameExtensionFilter("Text files (*.txt)", "txt"));
        if (saveFileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File currentFile = saveFileChooser.getSelectedFile();
            // FIXME: what if user selected "All files" filter?
            if (saveFileChooser.getFileFilter() != saveFileChooser.getAcceptAllFileFilter()) {
                if (!currentFile.getName().toLowerCase().endsWith(".txt")) {
                    currentFile = new File(currentFile.getAbsolutePath() + ".txt");
                }
            }
            try (PrintWriter pw = new PrintWriter(currentFile)) {
                for (int index = 0; index < modelTravelList.getSize(); index++) {
                    Travel t = modelTravelList.get(index);
                    DateFormat inputFormatter = new SimpleDateFormat("yyyy/MM/dd");
                    Date departureDate = removeTime(t.getDepartureDate());
                    Date returnDate = removeTime(t.getReturnDate());
                    pw.write(t.getDestination() + ";" + t.getTravallerName() + ";" + t.getTravallerPassportNo() + ";"
                            + departureDate + ";" + returnDate + "\n");
                }
                pw.close();
                docModified(false);
                return true;
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this,
                        "Unable to write file contents to " + currentFile.getAbsolutePath(),
                        "File access error",
                        JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
        return false;
    }

    DateFormat formatter;
    Date departureDate = null;
    Date returnDate = null;

    private boolean isTravelDateValid(
            String destination, JLabel lblDlgDestinationError,
            String travallerName, JLabel lblDlgTravellerNameError,
            String travallerPassportNo, JLabel lblDlgTravellerPassportNoError,
            String departureDateStr, JLabel lblDlgDepartureDateError,
            String returnDateStr, JLabel lblDlgReturnDateError) throws ParseException {
        //
        boolean isDestinationInvalid = (destination.length() < 2 || destination.length() > 29);
        lblDlgDestinationError.setVisible(isDestinationInvalid);
        //
        boolean isTravellerNameInvalid = (travallerName.length() < 2 || travallerName.length() > 29);
        lblDlgTravellerNameError.setVisible(isTravellerNameInvalid);
        //
        boolean isTravallerPassportNoInvalid = !travallerPassportNo.matches("[a-zA-Z]{2}[0-9]{6}");
        lblDlgTravellerPassportNoError.setVisible(isTravallerPassportNoInvalid);
        // 

        boolean isDepartureDateInvalid = false;

        formatter = new SimpleDateFormat("yyyy/MM/dd");

        try {

            departureDate = (Date) formatter.parse(departureDateStr);
            isDepartureDateInvalid = false;

        } catch (ParseException e) {

            isDepartureDateInvalid = true;
            //e.printStackTrace();
        }

        lblDlgDepartureDateError.setVisible(isDepartureDateInvalid);

        //  
        boolean isReturnDateInvalid = false;

        formatter = new SimpleDateFormat("yyyy/MM/dd");

        try {

            returnDate = (Date) formatter.parse(returnDateStr);
            isReturnDateInvalid = false;

            if (returnDate.compareTo(departureDate) >= 0) {
                isReturnDateInvalid = false;
            } else {
                isReturnDateInvalid = true;
            }

        } catch (ParseException e) {
            isReturnDateInvalid = true;
            e.printStackTrace();

        }
        lblDlgReturnDateError.setVisible(isReturnDateInvalid);

        //
        return (!(isDestinationInvalid || isTravellerNameInvalid || isTravallerPassportNoInvalid || isDepartureDateInvalid || isReturnDateInvalid));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgAddTrip = new javax.swing.JDialog();
        lblDlgDestination = new javax.swing.JLabel();
        lblDlgTravellerName = new javax.swing.JLabel();
        lblDlgPassport = new javax.swing.JLabel();
        lblDlgDepartureDate = new javax.swing.JLabel();
        lblDlgReturnDate = new javax.swing.JLabel();
        tfDlgDestination = new javax.swing.JTextField();
        tfDlgTravellerName = new javax.swing.JTextField();
        tfDlgTravallerPassportNo = new javax.swing.JTextField();
        tfDlgDepartureDate = new javax.swing.JTextField();
        tfDlgReturnDate = new javax.swing.JTextField();
        btnDlgAddTrip = new javax.swing.JButton();
        lblDlgDestinationError = new javax.swing.JLabel();
        lblDlgTravellerNameError = new javax.swing.JLabel();
        lblDlgTravellerPassportNoError = new javax.swing.JLabel();
        lblDlgDepartureDateError = new javax.swing.JLabel();
        lblDlgReturnDateError = new javax.swing.JLabel();
        saveFileChooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstTravel = new javax.swing.JList<>();
        btnSaveSelected = new javax.swing.JButton();
        btnAddTrip = new javax.swing.JButton();

        dlgAddTrip.setMinimumSize(new java.awt.Dimension(600, 410));
        dlgAddTrip.setModal(true);
        dlgAddTrip.setSize(new java.awt.Dimension(600, 470));
        dlgAddTrip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dlgAddTripMouseClicked(evt);
            }
        });

        lblDlgDestination.setText("Destination:");

        lblDlgTravellerName.setText("Traveller Name:");

        lblDlgPassport.setText("Passport:");

        lblDlgDepartureDate.setText("Departure Date:");

        lblDlgReturnDate.setText("Return Date: ");

        btnDlgAddTrip.setText("Add Trip");
        btnDlgAddTrip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDlgAddTripActionPerformed(evt);
            }
        });

        lblDlgDestinationError.setForeground(java.awt.Color.red);
        lblDlgDestinationError.setText("destination name must be 2-29 characters, no semicolons");

        lblDlgTravellerNameError.setForeground(java.awt.Color.red);
        lblDlgTravellerNameError.setText("traveller name must be 2-29 characters, no semicolons");

        lblDlgTravellerPassportNoError.setForeground(java.awt.Color.red);
        lblDlgTravellerPassportNoError.setText("passport number must be 2 Leeters and 6 digits");

        lblDlgDepartureDateError.setForeground(java.awt.Color.red);
        lblDlgDepartureDateError.setText("must be YYYY/MM/DD format");

        lblDlgReturnDateError.setForeground(java.awt.Color.red);
        lblDlgReturnDateError.setText("return date must be YYYY/MM/DD and greater than departure date");

        javax.swing.GroupLayout dlgAddTripLayout = new javax.swing.GroupLayout(dlgAddTrip.getContentPane());
        dlgAddTrip.getContentPane().setLayout(dlgAddTripLayout);
        dlgAddTripLayout.setHorizontalGroup(
            dlgAddTripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgAddTripLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dlgAddTripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dlgAddTripLayout.createSequentialGroup()
                        .addGroup(dlgAddTripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(dlgAddTripLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblDlgTravellerPassportNoError)
                                .addGap(114, 114, 114))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dlgAddTripLayout.createSequentialGroup()
                                .addGroup(dlgAddTripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dlgAddTripLayout.createSequentialGroup()
                                        .addGroup(dlgAddTripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblDlgDepartureDate)
                                            .addComponent(lblDlgReturnDate))
                                        .addGap(29, 29, 29)
                                        .addGroup(dlgAddTripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfDlgReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfDlgDepartureDate, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(dlgAddTripLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(lblDlgReturnDateError))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dlgAddTripLayout.createSequentialGroup()
                                        .addGroup(dlgAddTripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblDlgPassport)
                                            .addComponent(lblDlgTravellerName))
                                        .addGap(28, 28, 28)
                                        .addGroup(dlgAddTripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfDlgTravellerName, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfDlgTravallerPassportNo, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfDlgDestination, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 29, Short.MAX_VALUE)))
                        .addContainerGap(29, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgAddTripLayout.createSequentialGroup()
                        .addGap(0, 240, Short.MAX_VALUE)
                        .addGroup(dlgAddTripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgAddTripLayout.createSequentialGroup()
                                .addComponent(btnDlgAddTrip)
                                .addGap(237, 237, 237))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgAddTripLayout.createSequentialGroup()
                                .addComponent(lblDlgDepartureDateError)
                                .addGap(182, 182, 182))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgAddTripLayout.createSequentialGroup()
                        .addComponent(lblDlgDestination)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgAddTripLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(dlgAddTripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgAddTripLayout.createSequentialGroup()
                        .addComponent(lblDlgTravellerNameError)
                        .addGap(117, 117, 117))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgAddTripLayout.createSequentialGroup()
                        .addComponent(lblDlgDestinationError)
                        .addGap(90, 90, 90))))
        );
        dlgAddTripLayout.setVerticalGroup(
            dlgAddTripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgAddTripLayout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addGroup(dlgAddTripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDlgDestination)
                    .addComponent(tfDlgDestination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDlgDestinationError)
                .addGap(18, 18, 18)
                .addGroup(dlgAddTripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDlgTravellerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDlgTravellerName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDlgTravellerNameError)
                .addGap(18, 18, 18)
                .addGroup(dlgAddTripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfDlgTravallerPassportNo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDlgPassport, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDlgTravellerPassportNoError)
                .addGap(27, 27, 27)
                .addGroup(dlgAddTripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDlgDepartureDate, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfDlgDepartureDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(dlgAddTripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dlgAddTripLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(dlgAddTripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDlgReturnDate)
                            .addComponent(tfDlgReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(dlgAddTripLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDlgDepartureDateError)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDlgReturnDateError)
                .addGap(18, 18, 18)
                .addComponent(btnDlgAddTrip)
                .addGap(10, 10, 10))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lstTravel.setModel(modelTravelList);
        lstTravel.setMaximumSize(new java.awt.Dimension(560, 350));
        lstTravel.setMinimumSize(new java.awt.Dimension(560, 350));
        lstTravel.setPreferredSize(new java.awt.Dimension(560, 350));
        jScrollPane1.setViewportView(lstTravel);

        btnSaveSelected.setText("Save selected");
        btnSaveSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveSelectedActionPerformed(evt);
            }
        });

        btnAddTrip.setText("Add Trip");
        btnAddTrip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddTripMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnAddTripMouseReleased(evt);
            }
        });
        btnAddTrip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTripActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnSaveSelected)
                .addGap(116, 116, 116)
                .addComponent(btnAddTrip)
                .addContainerGap(455, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveSelected)
                    .addComponent(btnAddTrip))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dlgAddTripMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dlgAddTripMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_dlgAddTripMouseClicked

    private void btnAddTripMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddTripMouseClicked

    }//GEN-LAST:event_btnAddTripMouseClicked

    private void btnAddTripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTripActionPerformed
        tfDlgDestination.setText("");
        tfDlgTravellerName.setText("");
        tfDlgTravallerPassportNo.setText("");
        tfDlgDepartureDate.setText("");
        tfDlgReturnDate.setText("");
        //Causes this Window to be sized to fit the preferred size and layouts of its subcomponents
        dlgAddTrip.pack();
        //set the dialog window visible
        dlgAddTrip.setVisible(true);
    }//GEN-LAST:event_btnAddTripActionPerformed

    private void btnDlgAddTripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDlgAddTripActionPerformed
        try {
            String destination = tfDlgDestination.getText();
            String travallerName = tfDlgTravellerName.getText();
            String travallerPassportNo = tfDlgTravallerPassportNo.getText().toUpperCase();;
            String departureDateStr = tfDlgDepartureDate.getText();
            String returnDateStr = tfDlgReturnDate.getText();
            //
            if (isTravelDateValid(
                    destination, lblDlgDestinationError,
                    travallerName, lblDlgTravellerNameError,
                    travallerPassportNo, lblDlgTravellerPassportNoError,
                    departureDateStr, lblDlgDepartureDateError,
                    returnDateStr, lblDlgReturnDateError)) {
                modelTravelList.addElement(t = new Travel(
                        destination,
                        travallerName,
                        travallerPassportNo,
                        (Date) formatter.parse(departureDateStr),
                        (Date) formatter.parse(returnDateStr)));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        docModified(true);
        //
        dlgAddTrip.setVisible(false);
    }//GEN-LAST:event_btnDlgAddTripActionPerformed

    private void btnAddTripMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddTripMouseReleased

    }//GEN-LAST:event_btnAddTripMouseReleased

    private void btnSaveSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveSelectedActionPerformed
        String destination = tfDlgDestination.getText();
        String travallerName = tfDlgTravellerName.getText();
        String travallerPassportNo = tfDlgTravallerPassportNo.getText().toUpperCase();
        String departureDateStr = tfDlgDepartureDate.getText();
        String returnDateStr = tfDlgReturnDate.getText();
        //
                
        if (lstTravel.getSelectedIndices().length > 0) {
            
            doSaveAction();
            
        } else {
            JOptionPane.showMessageDialog(this,
                    "You forgot to make the selection",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveSelectedActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        doExitAction();
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Quiz_2_Travel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quiz_2_Travel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quiz_2_Travel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quiz_2_Travel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quiz_2_Travel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddTrip;
    private javax.swing.JButton btnDlgAddTrip;
    private javax.swing.JButton btnSaveSelected;
    private javax.swing.JDialog dlgAddTrip;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDlgDepartureDate;
    private javax.swing.JLabel lblDlgDepartureDateError;
    private javax.swing.JLabel lblDlgDestination;
    private javax.swing.JLabel lblDlgDestinationError;
    private javax.swing.JLabel lblDlgPassport;
    private javax.swing.JLabel lblDlgReturnDate;
    private javax.swing.JLabel lblDlgReturnDateError;
    private javax.swing.JLabel lblDlgTravellerName;
    private javax.swing.JLabel lblDlgTravellerNameError;
    private javax.swing.JLabel lblDlgTravellerPassportNoError;
    private javax.swing.JList<Travel> lstTravel;
    private javax.swing.JFileChooser saveFileChooser;
    private javax.swing.JTextField tfDlgDepartureDate;
    private javax.swing.JTextField tfDlgDestination;
    private javax.swing.JTextField tfDlgReturnDate;
    private javax.swing.JTextField tfDlgTravallerPassportNo;
    private javax.swing.JTextField tfDlgTravellerName;
    // End of variables declaration//GEN-END:variables
}

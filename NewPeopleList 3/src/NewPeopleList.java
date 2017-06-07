
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
public class NewPeopleList extends javax.swing.JFrame {

    DefaultListModel<Person> modelPersonList = new DefaultListModel<>();
    File currentFile;
    Person person;

    public NewPeopleList() {
        initComponents();
        //center window
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        dlgEditPerson.setLocationRelativeTo(this);

        // hide error labels
        lblNameError.setVisible(false);
        lblAgeError.setVisible(false);
        lblPostcodeError.setVisible(false);

        //
        centerOnParent(dlgEditPerson, true);
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

        fileChooser = new javax.swing.JFileChooser();
        popupMenu = new javax.swing.JPopupMenu();
        deleteRightClick = new javax.swing.JMenuItem();
        dlgEditPerson = new javax.swing.JDialog();
        lblDlgNameError = new javax.swing.JLabel();
        lblDlgAgeError = new javax.swing.JLabel();
        lblDlgPostcodeError = new javax.swing.JLabel();
        lblDlgName = new javax.swing.JLabel();
        lblDlgAge = new javax.swing.JLabel();
        lblDlgPostalCode = new javax.swing.JLabel();
        tfDlgName = new javax.swing.JTextField();
        tfDlgAge = new javax.swing.JTextField();
        tfDlgPostalCode = new javax.swing.JTextField();
        btnDlgSaveChanges = new javax.swing.JButton();
        btnDlgCancel = new javax.swing.JButton();
        lblDlgWhatWould = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPeople = new javax.swing.JList<>();
        lblName = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        lblPostalCode = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        tfAge = new javax.swing.JTextField();
        tfPostalCode = new javax.swing.JTextField();
        btnAddPerson = new javax.swing.JButton();
        lblNameError = new javax.swing.JLabel();
        lblAgeError = new javax.swing.JLabel();
        lblPostcodeError = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        openFile = new javax.swing.JMenuItem();
        savaAsFile = new javax.swing.JMenuItem();
        saveSelectedFile = new javax.swing.JMenuItem();
        exitFile = new javax.swing.JMenuItem();

        popupMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                popupMenuMouseClicked(evt);
            }
        });

        deleteRightClick.setText("Delete Item");
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
        popupMenu.add(deleteRightClick);

        dlgEditPerson.setModal(true);
        dlgEditPerson.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                dlgEditPersonMouseReleased(evt);
            }
        });

        lblDlgNameError.setForeground(java.awt.Color.red);
        lblDlgNameError.setText("name must be 2-20 characters, no semicolons");

        lblDlgAgeError.setForeground(java.awt.Color.red);
        lblDlgAgeError.setText("age must be between 1 and 150");

        lblDlgPostcodeError.setForeground(java.awt.Color.red);
        lblDlgPostcodeError.setText("postal code must be valid A1A1A1 format");

        lblDlgName.setText("Name:");

        lblDlgAge.setText("Age:");

        lblDlgPostalCode.setText("Postal Code:");

        tfDlgName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDlgNameActionPerformed(evt);
            }
        });

        tfDlgPostalCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDlgPostalCodeActionPerformed(evt);
            }
        });

        btnDlgSaveChanges.setText("Save Changes");
        btnDlgSaveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDlgSaveChangesActionPerformed(evt);
            }
        });

        btnDlgCancel.setText("Cancel");
        btnDlgCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDlgCancelMouseClicked(evt);
            }
        });
        btnDlgCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDlgCancelActionPerformed(evt);
            }
        });

        lblDlgWhatWould.setText("What would you like to do ?");

        javax.swing.GroupLayout dlgEditPersonLayout = new javax.swing.GroupLayout(dlgEditPerson.getContentPane());
        dlgEditPerson.getContentPane().setLayout(dlgEditPersonLayout);
        dlgEditPersonLayout.setHorizontalGroup(
            dlgEditPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgEditPersonLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(btnDlgSaveChanges)
                .addGroup(dlgEditPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgEditPersonLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDlgCancel)
                        .addGap(64, 64, 64))
                    .addGroup(dlgEditPersonLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblDlgWhatWould)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgEditPersonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(dlgEditPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgEditPersonLayout.createSequentialGroup()
                        .addComponent(lblDlgNameError)
                        .addGap(120, 120, 120))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgEditPersonLayout.createSequentialGroup()
                        .addComponent(lblDlgAgeError)
                        .addGap(163, 163, 163))))
            .addGroup(dlgEditPersonLayout.createSequentialGroup()
                .addGroup(dlgEditPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dlgEditPersonLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(dlgEditPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDlgAge)
                            .addComponent(lblDlgPostalCode)
                            .addComponent(lblDlgName))
                        .addGap(39, 39, 39)
                        .addGroup(dlgEditPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDlgPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDlgAge, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDlgName, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(dlgEditPersonLayout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(lblDlgPostcodeError)))
                .addGap(0, 101, Short.MAX_VALUE))
        );
        dlgEditPersonLayout.setVerticalGroup(
            dlgEditPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgEditPersonLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(dlgEditPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDlgName)
                    .addComponent(tfDlgName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(dlgEditPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(dlgEditPersonLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(lblDlgAge))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgEditPersonLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblDlgNameError)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfDlgAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lblDlgAgeError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(dlgEditPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDlgPostalCode)
                    .addComponent(tfDlgPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblDlgPostcodeError)
                .addGap(32, 32, 32)
                .addComponent(lblDlgWhatWould)
                .addGap(18, 18, 18)
                .addGroup(dlgEditPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDlgCancel)
                    .addComponent(btnDlgSaveChanges))
                .addGap(22, 22, 22))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 400));

        lstPeople.setModel(modelPersonList);
        lstPeople.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstPeopleMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lstPeopleMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(lstPeople);

        lblName.setText("Name:");

        lblAge.setText("Age:");

        lblPostalCode.setText("Postal Code:");

        tfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNameActionPerformed(evt);
            }
        });

        tfPostalCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPostalCodeActionPerformed(evt);
            }
        });

        btnAddPerson.setText("Add Person");
        btnAddPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPersonActionPerformed(evt);
            }
        });

        lblNameError.setForeground(java.awt.Color.red);
        lblNameError.setText("name must be 2-20 characters, no semicolons");

        lblAgeError.setForeground(java.awt.Color.red);
        lblAgeError.setText("age must be between 1 and 150");

        lblPostcodeError.setForeground(java.awt.Color.red);
        lblPostcodeError.setText("postal code must be valid A1A1A1 format");

        jMenu1.setText("File");

        openFile.setText("Open..");
        openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileActionPerformed(evt);
            }
        });
        jMenu1.add(openFile);

        savaAsFile.setText("Save As...");
        savaAsFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savaAsFileActionPerformed(evt);
            }
        });
        jMenu1.add(savaAsFile);

        saveSelectedFile.setText("Save Selected As...");
        saveSelectedFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveSelectedFileActionPerformed(evt);
            }
        });
        jMenu1.add(saveSelectedFile);

        exitFile.setText("Exit");
        exitFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitFileActionPerformed(evt);
            }
        });
        jMenu1.add(exitFile);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAge)
                                    .addComponent(lblName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfAge, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPostalCode)
                                .addGap(71, 71, 71)
                                .addComponent(tfPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(167, 167, 167))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblNameError)
                                .addGap(190, 190, 190))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblAgeError)
                                .addGap(214, 214, 214))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblPostcodeError)
                                .addGap(207, 207, 207))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAddPerson)
                                .addGap(224, 224, 224))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNameError)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAge))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAgeError)
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPostalCode))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPostcodeError)
                        .addGap(32, 32, 32)
                        .addComponent(btnAddPerson))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitFileActionPerformed
        dispose();
    }//GEN-LAST:event_exitFileActionPerformed

  private boolean isPersonDataValid(String name, JLabel nameError,
            String ageStr, JLabel ageError, String postcode, JLabel postcodeError) {
//
        boolean isNameInvalid = (name.length() < 2 || name.length() > 20);
        lblNameError.setVisible(isNameInvalid);
        
//
        int age = 0;
        boolean isAgeInvalid;
        try {
            age = Integer.parseInt(ageStr);
            isAgeInvalid = age < 1 || age > 150;
        } catch (NumberFormatException e) {
            isAgeInvalid = true;
        }
        lblAgeError.setVisible(isAgeInvalid);
        //
        boolean isPostcodeInvalid = !postcode.matches("[A-Z][0-9][A-Z] ?[0-9][A-Z][0-9]");
        lblPostcodeError.setVisible(isPostcodeInvalid);
        //
        return (!(isNameInvalid || isAgeInvalid || isPostcodeInvalid));
    }
    
    
    private void btnAddPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPersonActionPerformed
       String name = tfName.getText();
        String ageStr = tfAge.getText();
        String postcode = tfPostalCode.getText().toUpperCase();
        //        
        if (isPersonDataValid(
                name, lblNameError, 
                ageStr, lblAgeError, 
                postcode, lblPostcodeError)) {
            modelPersonList.addElement(new Person(
                    name, 
                    Integer.parseInt(ageStr), 
                    postcode));
        }

    }//GEN-LAST:event_btnAddPersonActionPerformed


    private void lstPeopleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstPeopleMouseClicked
        if ((evt.getButton() == MouseEvent.BUTTON1) && (evt.getClickCount() == 2)) {
            // left button, double-click
            lstPeople.setSelectedIndex(lstPeople.locationToIndex(evt.getPoint()));
            int index = lstPeople.getSelectedIndex();
            if (index != -1) {
                Person p = modelPersonList.get(index);
                // fill in data of Person double-clicked for editing
                tfDlgName.setText(p.name);
                tfDlgAge.setText(p.age + "");
                tfDlgPostalCode.setText(p.postcode);
                // hide errors
                lblDlgNameError.setVisible(false);
                lblDlgAgeError.setVisible(false);
                lblDlgPostcodeError.setVisible(false);
                // show dialog
                dlgEditPerson.setVisible(true);
            }
        }
    }//GEN-LAST:event_lstPeopleMouseClicked

    private void tfPostalCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPostalCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPostalCodeActionPerformed

    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileActionPerformed
        /*
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text files (*.txt)", "txt"));
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                currentFile = fileChooser.getSelectedFile();//to get the file into the current file
                String content = new Scanner(currentFile).useDelimiter("\\Z").next();
                lstPeople.(content);//to add the content to areaText
            } catch (FileNotFoundException ex) {
                currentFile = null;
                JOptionPane.showMessageDialog(this,
                        "Unable to read file contents from " + currentFile.getAbsolutePath(),
                        "File access error",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

        }
         */
    }//GEN-LAST:event_openFileActionPerformed

    private void lstPeopleMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstPeopleMouseReleased
         if ((evt.getButton() == MouseEvent.BUTTON3) && (evt.getClickCount() == 1)) {
            lstPeople.setSelectedIndex(lstPeople.locationToIndex(evt.getPoint()));
            if (lstPeople.getSelectedIndex() != -1) {
                popupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_lstPeopleMouseReleased

    private void deleteRightClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRightClickActionPerformed
        int index = lstPeople.getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(this,
                    "You must select a line first",
                    "Selection missing",
                    JOptionPane.WARNING_MESSAGE);
            return;

        }
        modelPersonList.remove(index);
    }//GEN-LAST:event_deleteRightClickActionPerformed

    private void deleteRightClickMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteRightClickMouseReleased
        int index = lstPeople.getSelectedIndex();
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
            modelPersonList.remove(index);
        }
    }//GEN-LAST:event_deleteRightClickMouseReleased

    private void tfDlgPostalCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDlgPostalCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDlgPostalCodeActionPerformed

    private void tfDlgNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDlgNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDlgNameActionPerformed

    private void btnDlgCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDlgCancelActionPerformed
        dlgEditPerson.setVisible(false);
    }//GEN-LAST:event_btnDlgCancelActionPerformed

    private void btnDlgCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDlgCancelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDlgCancelMouseClicked

    private void btnDlgSaveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDlgSaveChangesActionPerformed
   String name = tfDlgName.getText();
       String ageStr = tfDlgAge.getText();
       String postcode = tfDlgPostalCode.getText();
       if (isPersonDataValid(name, lblDlgNameError, ageStr, lblDlgAgeError,
               postcode, lblDlgPostcodeError)) {
           Person p = modelPersonList.get(lstPeople.getSelectedIndex());
           // save changes
           p.name = name;
           p.age = Integer.parseInt(ageStr);
           p.postcode = postcode;
           //
           dlgEditPerson.setVisible(false);
       }
    }//GEN-LAST:event_btnDlgSaveChangesActionPerformed

    private void savaAsFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savaAsFileActionPerformed
      // TODO: show file chooser first
        int[] indexList = lstPeople.getSelectedIndices();
        for (int idx : indexList) {
            Person p = modelPersonList.get(idx);
            System.out.printf("Sel[%d]: %s\n", idx, p);
        }
    }//GEN-LAST:event_savaAsFileActionPerformed

    private void saveSelectedFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveSelectedFileActionPerformed
      int[] indexList = lstPeople.getSelectedIndices();
        for (int idx : indexList) {
            Person p = modelPersonList.get(idx);
            System.out.printf("Sel[%d]: %s\n", idx, p);
        }
    }//GEN-LAST:event_saveSelectedFileActionPerformed

    private void deleteRightClickMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteRightClickMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteRightClickMouseClicked

    private void popupMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_popupMenuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_popupMenuMouseClicked

    private void dlgEditPersonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dlgEditPersonMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_dlgEditPersonMouseReleased

    private void tfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNameActionPerformed

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
            java.util.logging.Logger.getLogger(NewPeopleList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewPeopleList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewPeopleList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewPeopleList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewPeopleList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPerson;
    private javax.swing.JButton btnDlgCancel;
    private javax.swing.JButton btnDlgSaveChanges;
    private javax.swing.JMenuItem deleteRightClick;
    private javax.swing.JDialog dlgEditPerson;
    private javax.swing.JMenuItem exitFile;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblAgeError;
    private javax.swing.JLabel lblDlgAge;
    private javax.swing.JLabel lblDlgAgeError;
    private javax.swing.JLabel lblDlgName;
    private javax.swing.JLabel lblDlgNameError;
    private javax.swing.JLabel lblDlgPostalCode;
    private javax.swing.JLabel lblDlgPostcodeError;
    private javax.swing.JLabel lblDlgWhatWould;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameError;
    private javax.swing.JLabel lblPostalCode;
    private javax.swing.JLabel lblPostcodeError;
    private javax.swing.JList<Person> lstPeople;
    private javax.swing.JMenuItem openFile;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JMenuItem savaAsFile;
    private javax.swing.JMenuItem saveSelectedFile;
    private javax.swing.JTextField tfAge;
    private javax.swing.JTextField tfDlgAge;
    private javax.swing.JTextField tfDlgName;
    private javax.swing.JTextField tfDlgPostalCode;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfPostalCode;
    // End of variables declaration//GEN-END:variables
}

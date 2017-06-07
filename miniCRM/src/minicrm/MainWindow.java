/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minicrm;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import minicrm.entity.Customer;
import minicrm.entity.Interaction;
import minicrm.entity.Representative;

/**
 *
 * @author ipd
 */
public class MainWindow extends javax.swing.JFrame {

    //connection to Database
    Database db;

    DefaultListModel<Customer> modelCustomerList = new DefaultListModel<>();
    DefaultListModel<Representative> modelRepList = new DefaultListModel<>();
    DefaultListModel<Interaction> modelInteractionList = new DefaultListModel<>();

    public MainWindow() {
        try {
            db = new Database();
            initComponents();
            dlgAddRep.pack();
            refreshRepresentativeList();
            refreshCustomerList();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Failed to open databse connection",
                    "Database error",
                    JOptionPane.WARNING_MESSAGE);
            System.exit(1);
        }

        //center window
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        dlgAddCustomer.setLocationRelativeTo(this);
        dlgAddRep.setLocationRelativeTo(this);
        //
        centerOnParent(dlgManageCustomerInteractions, true);
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

    private void refreshRepresentativeList() {
        try {
            //fetch the data from database
            ArrayList<Representative> lstRepresentative = db.getAllRepresentative();
            //first clear data in the model
            modelRepList.clear();
            for (Representative r : lstRepresentative) {
                modelRepList.addElement(r);
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

    private void refreshCustomerList() {
        try {
            //fetch the data from database
            ArrayList<Customer> lstCustomer = db.getAllCustomer();
            //first clear data in the model
            modelCustomerList.clear();
            for (Customer c : lstCustomer) {
                modelCustomerList.addElement(c);
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
    
    

    private void enableButtonWhenBothListsSelected() {
        int idx1 = lstRepresentative.getSelectedIndex();
        int idx2 = lstCustomer.getSelectedIndex();
        boolean enabled = idx1 >= 0 && idx2 >= 0;
        btnManageCustomerInteractions.setEnabled(enabled);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgAddCustomer = new javax.swing.JDialog();
        lblDlgFirstName = new javax.swing.JLabel();
        lblDlgLastName = new javax.swing.JLabel();
        lblDlgAddress = new javax.swing.JLabel();
        lblDlgPostalCode = new javax.swing.JLabel();
        lblDlgPhoneNumber = new javax.swing.JLabel();
        lblDlgSIN = new javax.swing.JLabel();
        tfDlgFirstName = new javax.swing.JTextField();
        tfDlgLastName = new javax.swing.JTextField();
        tfDlgAddress = new javax.swing.JTextField();
        tfDlgPostalCode = new javax.swing.JTextField();
        tfDlgPhoneNumber = new javax.swing.JTextField();
        tfDlgSIN = new javax.swing.JTextField();
        btnDlgAddNewCustomer = new javax.swing.JButton();
        lblDlgAddingNewCustomer = new javax.swing.JLabel();
        dlgAddRep = new javax.swing.JDialog();
        lblDlgRepAddingNewRepresentative = new javax.swing.JLabel();
        lblDlgRepFirstName = new javax.swing.JLabel();
        lblDlgRepLastName = new javax.swing.JLabel();
        btnDlgRepAddNewRep = new javax.swing.JButton();
        tfDlgRepFirstName = new javax.swing.JTextField();
        tfDlgRepLastName = new javax.swing.JTextField();
        dlgManageCustomerInteractions = new javax.swing.JDialog();
        lblDlgInteractionCurrentRepresentative = new javax.swing.JLabel();
        lblDlgInteractionCurrentRepresentative2 = new javax.swing.JLabel();
        lblDlgInteractionCurrentCustomer = new javax.swing.JLabel();
        lblDlgInteractionCurrentCustomer2 = new javax.swing.JLabel();
        lblDlgListOfInteractionsSortedByDate = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstInteraction = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        taDlgNotesHistory = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        lblCurrentRep = new javax.swing.JLabel();
        lblFindCustomer = new javax.swing.JLabel();
        btnAddRep = new javax.swing.JButton();
        btnAddCustomer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstRepresentative = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstCustomer = new javax.swing.JList<>();
        btnManageCustomerInteractions = new javax.swing.JButton();

        dlgAddCustomer.setMinimumSize(new java.awt.Dimension(600, 500));

        lblDlgFirstName.setText("First Name  ");

        lblDlgLastName.setText("Last Name ");

        lblDlgAddress.setText("Address");

        lblDlgPostalCode.setText("Postal Code");

        lblDlgPhoneNumber.setText("Phone Number");

        lblDlgSIN.setText("SIN");

        btnDlgAddNewCustomer.setText("Add New Customer");
        btnDlgAddNewCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDlgAddNewCustomerActionPerformed(evt);
            }
        });

        lblDlgAddingNewCustomer.setText("Adding New Customer");

        javax.swing.GroupLayout dlgAddCustomerLayout = new javax.swing.GroupLayout(dlgAddCustomer.getContentPane());
        dlgAddCustomer.getContentPane().setLayout(dlgAddCustomerLayout);
        dlgAddCustomerLayout.setHorizontalGroup(
            dlgAddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgAddCustomerLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(dlgAddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDlgFirstName)
                    .addComponent(lblDlgSIN)
                    .addComponent(lblDlgPhoneNumber)
                    .addComponent(lblDlgPostalCode)
                    .addComponent(lblDlgAddress)
                    .addComponent(lblDlgLastName))
                .addGap(69, 69, 69)
                .addGroup(dlgAddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfDlgFirstName)
                    .addComponent(tfDlgLastName)
                    .addComponent(tfDlgAddress)
                    .addComponent(tfDlgPostalCode)
                    .addComponent(tfDlgPhoneNumber)
                    .addComponent(tfDlgSIN, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgAddCustomerLayout.createSequentialGroup()
                .addContainerGap(274, Short.MAX_VALUE)
                .addGroup(dlgAddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgAddCustomerLayout.createSequentialGroup()
                        .addComponent(lblDlgAddingNewCustomer)
                        .addGap(199, 199, 199))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgAddCustomerLayout.createSequentialGroup()
                        .addComponent(btnDlgAddNewCustomer)
                        .addGap(201, 201, 201))))
        );
        dlgAddCustomerLayout.setVerticalGroup(
            dlgAddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgAddCustomerLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblDlgAddingNewCustomer)
                .addGap(32, 32, 32)
                .addGroup(dlgAddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDlgFirstName)
                    .addComponent(tfDlgFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dlgAddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDlgLastName)
                    .addComponent(tfDlgLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dlgAddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDlgAddress)
                    .addComponent(tfDlgAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(dlgAddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDlgPostalCode)
                    .addComponent(tfDlgPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(dlgAddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDlgPhoneNumber)
                    .addComponent(tfDlgPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(dlgAddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDlgSIN)
                    .addComponent(tfDlgSIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addComponent(btnDlgAddNewCustomer)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        dlgAddRep.setMinimumSize(new java.awt.Dimension(600, 500));

        lblDlgRepAddingNewRepresentative.setText("Adding New Representative");

        lblDlgRepFirstName.setText("First Name");

        lblDlgRepLastName.setText("Last Name");

        btnDlgRepAddNewRep.setText("Add New Rep");
        btnDlgRepAddNewRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDlgRepAddNewRepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dlgAddRepLayout = new javax.swing.GroupLayout(dlgAddRep.getContentPane());
        dlgAddRep.getContentPane().setLayout(dlgAddRepLayout);
        dlgAddRepLayout.setHorizontalGroup(
            dlgAddRepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgAddRepLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(dlgAddRepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDlgRepLastName)
                    .addComponent(lblDlgRepFirstName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(dlgAddRepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfDlgRepFirstName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDlgRepLastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgAddRepLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(dlgAddRepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgAddRepLayout.createSequentialGroup()
                        .addComponent(btnDlgRepAddNewRep)
                        .addGap(203, 203, 203))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgAddRepLayout.createSequentialGroup()
                        .addComponent(lblDlgRepAddingNewRepresentative)
                        .addGap(193, 193, 193))))
        );
        dlgAddRepLayout.setVerticalGroup(
            dlgAddRepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgAddRepLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(lblDlgRepAddingNewRepresentative)
                .addGap(54, 54, 54)
                .addGroup(dlgAddRepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDlgRepFirstName)
                    .addComponent(tfDlgRepFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(dlgAddRepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDlgRepLastName)
                    .addComponent(tfDlgRepLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addComponent(btnDlgRepAddNewRep)
                .addContainerGap(182, Short.MAX_VALUE))
        );

        dlgManageCustomerInteractions.setMinimumSize(new java.awt.Dimension(820, 740));
        dlgManageCustomerInteractions.setModal(true);

        lblDlgInteractionCurrentRepresentative.setText("Current representative:");

        lblDlgInteractionCurrentCustomer.setText("Current Customer:");

        lblDlgListOfInteractionsSortedByDate.setText("List of interactions, sorted by date:");

        lstInteraction.setModel(modelInteractionList);
        jScrollPane3.setViewportView(lstInteraction);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Selected interaction details"));

        jLabel6.setText("Representative name:");

        jLabel7.setText("Interaction date:");

        jLabel8.setText("..............................");

        jLabel9.setText("..............................");

        jLabel10.setText("Notes:");

        taDlgNotesHistory.setColumns(20);
        taDlgNotesHistory.setRows(5);
        taDlgNotesHistory.setEnabled(false);
        jScrollPane4.setViewportView(taDlgNotesHistory);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel9))))
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Add new interaction note"));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane5.setViewportView(jTextArea2);

        jButton2.setText("Add new interaction note");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(159, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(152, 152, 152))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        javax.swing.GroupLayout dlgManageCustomerInteractionsLayout = new javax.swing.GroupLayout(dlgManageCustomerInteractions.getContentPane());
        dlgManageCustomerInteractions.getContentPane().setLayout(dlgManageCustomerInteractionsLayout);
        dlgManageCustomerInteractionsLayout.setHorizontalGroup(
            dlgManageCustomerInteractionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgManageCustomerInteractionsLayout.createSequentialGroup()
                .addGroup(dlgManageCustomerInteractionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dlgManageCustomerInteractionsLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(dlgManageCustomerInteractionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDlgListOfInteractionsSortedByDate)
                            .addGroup(dlgManageCustomerInteractionsLayout.createSequentialGroup()
                                .addComponent(lblDlgInteractionCurrentRepresentative)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblDlgInteractionCurrentRepresentative2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(lblDlgInteractionCurrentCustomer)
                                .addGap(18, 18, 18)
                                .addComponent(lblDlgInteractionCurrentCustomer2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(dlgManageCustomerInteractionsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(dlgManageCustomerInteractionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        dlgManageCustomerInteractionsLayout.setVerticalGroup(
            dlgManageCustomerInteractionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgManageCustomerInteractionsLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(dlgManageCustomerInteractionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDlgInteractionCurrentRepresentative)
                    .addComponent(lblDlgInteractionCurrentRepresentative2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDlgInteractionCurrentCustomer)
                    .addComponent(lblDlgInteractionCurrentCustomer2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(lblDlgListOfInteractionsSortedByDate)
                .addGap(33, 33, 33)
                .addGroup(dlgManageCustomerInteractionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dlgManageCustomerInteractionsLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dlgManageCustomerInteractionsLayout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));

        lblCurrentRep.setText("Current Representative");

        lblFindCustomer.setText("Find Customer");

        btnAddRep.setText("Add Rep");
        btnAddRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRepActionPerformed(evt);
            }
        });

        btnAddCustomer.setText("Add Customer");
        btnAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCustomerActionPerformed(evt);
            }
        });

        lstRepresentative.setModel(modelRepList);
        lstRepresentative.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstRepresentativeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstRepresentative);

        lstCustomer.setModel(modelCustomerList);
        lstCustomer.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstCustomerValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstCustomer);

        btnManageCustomerInteractions.setText("Manage Customer Interactions");
        btnManageCustomerInteractions.setEnabled(false);
        btnManageCustomerInteractions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageCustomerInteractionsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnAddRep)
                        .addGap(261, 261, 261)
                        .addComponent(btnAddCustomer))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblCurrentRep)
                        .addGap(210, 210, 210)
                        .addComponent(lblFindCustomer))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnManageCustomerInteractions)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFindCustomer)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(btnManageCustomerInteractions, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCurrentRep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 21, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddRep)
                    .addComponent(btnAddCustomer))
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRepActionPerformed
        tfDlgRepFirstName.setText("");
        tfDlgRepLastName.setText("");

        //Causes this Window to be sized to fit the preferred size and layouts of its subcomponents
        dlgAddRep.pack();
        //set the dialog window visible
        dlgAddRep.setVisible(true);
    }//GEN-LAST:event_btnAddRepActionPerformed

    private void btnAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCustomerActionPerformed
        tfDlgFirstName.setText("");
        tfDlgLastName.setText("");
        tfDlgAddress.setText("");
        tfDlgPostalCode.setText("");
        tfDlgPhoneNumber.setText("");
        tfDlgSIN.setText("");

        //Causes this Window to be sized to fit the preferred size and layouts of its subcomponents
        dlgAddCustomer.pack();
        //set the dialog window visible
        dlgAddCustomer.setVisible(true);
    }//GEN-LAST:event_btnAddCustomerActionPerformed

    private void btnDlgRepAddNewRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDlgRepAddNewRepActionPerformed
        String nameFirst = tfDlgRepFirstName.getText();
        String nameLast = tfDlgRepLastName.getText();

//anytime when you connect to DB you have to handle the exception
        try {
// and add info from GUI to DB
            db.addRepresentative(nameFirst, nameLast);

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Failed to open databse connection",
                    "Database error",
                    JOptionPane.WARNING_MESSAGE);
        }
        dlgAddRep.setVisible(false);

        refreshRepresentativeList();
    }//GEN-LAST:event_btnDlgRepAddNewRepActionPerformed

    private void btnDlgAddNewCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDlgAddNewCustomerActionPerformed
        String nameFirst = tfDlgFirstName.getText();
        String nameLast = tfDlgLastName.getText();
        String address = tfDlgAddress.getText();
        String postalCode = tfDlgPostalCode.getText();
        String phoneNumber = tfDlgPhoneNumber.getText();
        String SIN = tfDlgSIN.getText();

//anytime when you connect to DB you have to handle the exception
        try {
// and add info from GUI to DB
            db.addCustomer(nameFirst, nameLast, address, postalCode, phoneNumber, SIN);

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Failed to open databse connection",
                    "Database error",
                    JOptionPane.WARNING_MESSAGE);
        }
        dlgAddCustomer.setVisible(false);

        refreshCustomerList();
    }//GEN-LAST:event_btnDlgAddNewCustomerActionPerformed

    private void btnManageCustomerInteractionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageCustomerInteractionsActionPerformed

        //
        Representative rep = lstRepresentative.getSelectedValue();
        lblDlgInteractionCurrentRepresentative2.setText(rep.nameFirst + " " + rep.nameLast);
        Customer cust = lstCustomer.getSelectedValue();
        lblDlgInteractionCurrentCustomer2.setText(cust.nameFirst + " " + cust.nameLast);
        //
        
         try {
            //fetch the data from database
            ArrayList<Interaction> lstInteraction = db.getAllInteraction();
            //first clear data in the model
            modelInteractionList.clear();
            for (Interaction i : lstInteraction) {
                modelInteractionList.addElement(i);
                //then add it
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Failed execute database query",
                    "Database error",
                    JOptionPane.WARNING_MESSAGE);
        }
        
        //
        dlgManageCustomerInteractions.pack();
        dlgManageCustomerInteractions.setVisible(true);
        
        
        

        
    }//GEN-LAST:event_btnManageCustomerInteractionsActionPerformed

    private void lstRepresentativeValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstRepresentativeValueChanged
        enableButtonWhenBothListsSelected();    }//GEN-LAST:event_lstRepresentativeValueChanged

    private void lstCustomerValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstCustomerValueChanged
        enableButtonWhenBothListsSelected();    }//GEN-LAST:event_lstCustomerValueChanged

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
    private javax.swing.JButton btnAddCustomer;
    private javax.swing.JButton btnAddRep;
    private javax.swing.JButton btnDlgAddNewCustomer;
    private javax.swing.JButton btnDlgRepAddNewRep;
    private javax.swing.JButton btnManageCustomerInteractions;
    private javax.swing.JDialog dlgAddCustomer;
    private javax.swing.JDialog dlgAddRep;
    private javax.swing.JDialog dlgManageCustomerInteractions;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel lblCurrentRep;
    private javax.swing.JLabel lblDlgAddingNewCustomer;
    private javax.swing.JLabel lblDlgAddress;
    private javax.swing.JLabel lblDlgFirstName;
    private javax.swing.JLabel lblDlgInteractionCurrentCustomer;
    private javax.swing.JLabel lblDlgInteractionCurrentCustomer2;
    private javax.swing.JLabel lblDlgInteractionCurrentRepresentative;
    private javax.swing.JLabel lblDlgInteractionCurrentRepresentative2;
    private javax.swing.JLabel lblDlgLastName;
    private javax.swing.JLabel lblDlgListOfInteractionsSortedByDate;
    private javax.swing.JLabel lblDlgPhoneNumber;
    private javax.swing.JLabel lblDlgPostalCode;
    private javax.swing.JLabel lblDlgRepAddingNewRepresentative;
    private javax.swing.JLabel lblDlgRepFirstName;
    private javax.swing.JLabel lblDlgRepLastName;
    private javax.swing.JLabel lblDlgSIN;
    private javax.swing.JLabel lblFindCustomer;
    private javax.swing.JList<Customer> lstCustomer;
    private javax.swing.JList<Interaction> lstInteraction;
    private javax.swing.JList<Representative> lstRepresentative;
    private javax.swing.JTextArea taDlgNotesHistory;
    private javax.swing.JTextField tfDlgAddress;
    private javax.swing.JTextField tfDlgFirstName;
    private javax.swing.JTextField tfDlgLastName;
    private javax.swing.JTextField tfDlgPhoneNumber;
    private javax.swing.JTextField tfDlgPostalCode;
    private javax.swing.JTextField tfDlgRepFirstName;
    private javax.swing.JTextField tfDlgRepLastName;
    private javax.swing.JTextField tfDlgSIN;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minicrm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import minicrm.entity.Customer;
import minicrm.entity.Interaction;
import minicrm.entity.Representative;

/**
 *
 * @author ipd
 */
public class Database {

    private Connection conn;

    public Database() throws SQLException {
        conn = DriverManager.getConnection("jdbc:sqlite:minicrm.db");

    }

    public void addRepresentative(String nameFirst, String nameLast) throws SQLException {
        //prepared statements. we MUST use this format "INSERT INTO person VALUES(NULL, ?,?)"
        String query = "INSERT INTO Representative VALUES(NULL, ?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, nameFirst);
        ps.setString(2, nameLast);
        ps.execute();
        

    }

    public ArrayList<Representative> getAllRepresentative() throws SQLException {
        //this is a query
        final String SELECT_REPRESENTATIVE = "SELECT * FROM Representative";
        ArrayList<Representative> result = new ArrayList<>();
        //we are using another layer to talk to the database - 
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SELECT_REPRESENTATIVE);
            // cursor
            while (rs.next()) {
                //extract data
                int representativeID = rs.getInt("representativeID");
                String nameFirst = rs.getString("nameFirst");
                String nameLast = rs.getString("nameLast");

                //then create a person with the data
                Representative r = new Representative(representativeID, nameFirst, nameLast);
                result.add(r);
                //adding to the array list a Person
            }

        }
        return result;
    }
    
    public ArrayList<Interaction> getAllInteraction() throws SQLException {
        //this is a query
        final String SELECT_Interaction = "SELECT * FROM Interaction";
        ArrayList<Interaction> result = new ArrayList<>();
        //we are using another layer to talk to the database - 
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SELECT_Interaction);
            // cursor
            while (rs.next()) {
                //extract data
                int interactionID = rs.getInt("interactionID");
				int customerID = rs.getInt("customerID");
				int repID = rs.getInt("repID");
				String date = rs.getString("date");  
				String notes = rs.getString("notes"); 
                

                //then create a person with the data
                Interaction i = new Interaction(interactionID, customerID, repID, date, notes);
                result.add(i);
                //adding to the array list a Person
            }

        }
        return result;
    }
    /*
    public getAllInteractionByCustomerID(int customerID) throws SQLException {
        //this is a query
        String SELECT_INTERACTION = "SELECT R.nameFirst, R.nameLast,I.date FROM Customer as C inner join Interaction as I on C.customerID = I.customerID inner join Representative as R on I.repID = R.representativeID where C.customerID =" + customerID;
                //we are using another layer to talk to the database - 
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SELECT_INTERACTION);
            // cursor
            while (rs.next()) {
                //extract data
                int interactionID = rs.getInt("interactionID");
                customerID = rs.getInt("customerID");
                int repID = rs.getInt("repID");
                String date = rs.getString("date");
                String notes = rs.getString("notes");

                //then create a Interaction with the data
                Interaction i = new Interaction(interactionID, customerID, repID, date, notes);
                result.add(i);
                //adding to the array list a Person
            }

        }
        return result;
    }
*/
    
    public void addCustomer(String nameFirst, String nameLast, String address,
            String postalCode, String phoneNumber, String SIN) throws SQLException {
        //prepared statements. we MUST use this format "INSERT INTO person VALUES(NULL, ?,?)"
        String query = "INSERT INTO Customer VALUES(NULL, ?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, nameFirst);
        ps.setString(2, nameLast);
        ps.setString(3, address);
        ps.setString(4, postalCode);
        ps.setString(5, phoneNumber);
        ps.setString(6, SIN);
        ps.execute();
        

    }
    
    
    public ArrayList<Customer> getAllCustomer() throws SQLException {
        //this is a query
        final String SELECT_CUSTOMER = "SELECT * FROM Customer";
        ArrayList<Customer> result = new ArrayList<>();
        //we are using another layer to talk to the database - 
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SELECT_CUSTOMER);
            // cursor
            while (rs.next()) {
                //extract data
                int customerID = rs.getInt("customerID");
                String nameFirst = rs.getString("nameFirst");
                String nameLast = rs.getString("nameLast");
                String address = rs.getString("address");
                String postalCode = rs.getString("postalCode");
                String phoneNumber = rs.getString("phoneNumber");
                String SIN = rs.getString("SIN");
                

                //then create a person with the data
                Customer c = new Customer(customerID, nameFirst, nameLast, address, postalCode, phoneNumber, SIN);
                result.add(c);
                //adding to the array list a Person
            }

        }
        return result;
    }

}

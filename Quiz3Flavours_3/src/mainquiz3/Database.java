/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainquiz3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import newpackage.entity.Flavour;
import newpackage.entity.PlacedOrder;

/**
 *
 * @author ipd
 */
public class Database {
    
    private Connection conn;

    public Database() throws SQLException {
        conn = DriverManager.getConnection("jdbc:sqlite:mainquiz3.sqlite");

    }
    
    
    public ArrayList<Flavour> getAllFlavour() throws SQLException {
        //this is a query
        final String SELECT_FLAVOUR = "SELECT * FROM Flavour";
        ArrayList<Flavour> result = new ArrayList<>();
        //we are using another layer to talk to the database - 
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SELECT_FLAVOUR);
            // cursor
            while (rs.next()) {
                //extract data
                int flavourID = rs.getInt("flavourID");
                String name = rs.getString("name");
                

                //then create a person with the data
                Flavour f = new Flavour(flavourID, name);
                result.add(f);
                //adding to the array list a Person
            }

        }
        return result;
    }
    
    public void addOrder(String customerName, String flavourList) throws SQLException {
               
        String query = "INSERT INTO PlacedOrder VALUES (NULL,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, customerName);
        ps.setString(2, flavourList);        
        ps.execute();
        
    }
    
    public ArrayList<PlacedOrder> getAllPlacedOrder() throws SQLException {
        //this is a query
        final String SELECT_PLACEDORDER = "SELECT * FROM PlacedOrder";
        ArrayList<PlacedOrder> result = new ArrayList<>();
        //we are using another layer to talk to the database - 
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SELECT_PLACEDORDER);
            // cursor
            while (rs.next()) {
                //extract data
                int placedOrderID = rs.getInt("placedOrderID");
                String customerName = rs.getString("customerName");
                String flavourList = rs.getString("flavourList");
                //then create a person with the data
                PlacedOrder p = new PlacedOrder(placedOrderID, customerName, flavourList);
                result.add(p);
                //adding to the array list a Person
            }

        }
        return result;
    }
    
}

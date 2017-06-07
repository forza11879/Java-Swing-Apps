/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz3flavours;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import quiz3flavours.entity.Flavour;
import quiz3flavours.entity.PlacedOrder;
/**
 *
 * @author ipd
 */
public class Database {
    private Connection conn;
    
    public Database() throws SQLException {
        conn = DriverManager.getConnection("jdbc:sqlite:flavours.db");
    }
    
    public void addCustomer(String nameFirst, String nameLast, String address, String postalCode, String phoneNumber, String SIN) throws SQLException {
        String query = "INSERT INTO customer VALUES (NULL,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, nameFirst);
        ps.setString(2, nameLast);
        ps.setString(3, address);
        ps.setString(4, postalCode);
        ps.setString(5, phoneNumber);
        ps.setString(6, SIN);
        ps.execute();
    }

    public ArrayList<Flavour> getAllFlavour() throws SQLException {
        final String SELECT_FLAVOUR = "SELECT * FROM Flavour ";
        ArrayList<Flavour> result = new ArrayList();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SELECT_FLAVOUR);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                
                Flavour f = new Flavour(id, name);
                result.add(f);
            }
        }
        return result;
    }
    
    public void addPlacedOrder(String placedOrder, String flavourList) throws SQLException {
        String query = "INSERT INTO PlacedOrder VALUES (NULL,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, placedOrder);
        ps.setString(2, flavourList);        
        ps.execute();
    }

    public ArrayList<PlacedOrder> getAllPlacedOrder() throws SQLException {
        final String SELECT_PLACEDORDER = "SELECT * FROM PlacedOrder ";
        ArrayList<PlacedOrder> result = new ArrayList();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SELECT_PLACEDORDER);
            while (rs.next()) {
                int id = rs.getInt("id");
                String custName = rs.getString("custName");
                String flavourList = rs.getString("flavourList");
                PlacedOrder o = new PlacedOrder(id, custName, flavourList);
                result.add(o);
            }
        }
        return result;
    }
}

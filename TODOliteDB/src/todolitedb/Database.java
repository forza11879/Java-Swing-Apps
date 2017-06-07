package todolitedb;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ipd
 */
class SQLExceptionResultEmpty extends SQLException {}

public class Database {

    private final Connection conn;

    public Database() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost/todoitem", "root", "root");
    }

    public void addItem(String title, Date dueDate, boolean isDone) throws SQLException {
        String query = "INSERT INTO item VALUES (NULL,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, title);
        ps.setDate(2, dueDate);
        ps.setBoolean(3, isDone);
        ps.execute();
    }

    public ArrayList<TodoItem> getAllItem() throws SQLException {
        final String SELECT_ITEM = "SELECT * FROM item ";
        ArrayList<TodoItem> result = new ArrayList();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SELECT_ITEM);
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                Date dueDate  = rs.getDate("dueDate");
                boolean isDone = rs.getBoolean("isDone");
                TodoItem i = new TodoItem(id,title,dueDate,isDone);
                result.add(i);
            }
        } 
        return result;
    }

    public TodoItem getItemByID(int id) throws SQLException {
        final String SELECT_ITEMBYID = "SELECT * FROM item WHERE id" + id;
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SELECT_ITEMBYID);
            if(!rs.next()){
                throw new SQLExceptionResultEmpty();
            } 
            else{
                id = rs.getInt("id");
                String title = rs.getString("title");
                Date dueDate  = rs.getDate("dueDate");
                boolean isDone = rs.getBoolean("isDone");
                TodoItem p = new TodoItem(id, title, dueDate, isDone);
                return p;
            }
        } 
    }
    
    public void updateItem(TodoItem i) throws SQLException {
        String query = "UPDATE item SET title = ? ,dueDate = ?, isDone = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, i.title);
        ps.setDate(2, i.dueDate);
        ps.setBoolean(3, i.isDone);
        ps.setInt(4, i.id);
        ps.execute();
    }

    public void deleteItem(int id) throws SQLException {
        String query = "DELETE FROM item WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ps.execute();
    }
}

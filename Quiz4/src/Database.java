
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ipd
 */
public class Database {

    private Connection conn;

    public Database() throws SQLException {
        conn = DriverManager.getConnection("jdbc:sqlite:quiz4.db");

    }
    
    
    
    
    
    
    
    
}

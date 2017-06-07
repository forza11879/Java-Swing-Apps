
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

class SQLExceptionResultEmpty extends SQLException {
}

public class Database {

    private Connection conn;

    public Database() throws SQLException {
        //open the connection in the constractor
        //connects to database
        //factory methos is a static method it create it for you it does not get it.it creates
        //model will not comunicate with the user . let the contoller handle the exception
        //we can write the exception to the log file
        //model throws the exception to the controller
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/people",
                    "root", "root");

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    public void addPerson(String name, int age) throws SQLException {
        //prepared statements. we MUST use this format "INSERT INTO person VALUES(NULL, ?,?)"
        String query = "INSERT INTO person VALUES(NULL, ?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, name);
        ps.setInt(2, age);
        ps.execute();

    }

    public ArrayList<Person> getAllPersons() throws SQLException {
        //this is a query
        final String SELECT_PERSON = "SELECT * FROM person";
        ArrayList<Person> result = new ArrayList<>();
        //we are using another layer to talk to the database - 
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SELECT_PERSON);
            // cursor
            while (rs.next()) {
                //extract data
                int id = rs.getInt("idperson");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                //then create a person with the data
                Person p = new Person(id, name, age);
                result.add(p);
                //adding to the array list a Person
            }

        }
        return result;
    }

    public Person getPersonById(int id) throws SQLException {
        String query = "SELECT * FROM person" + id;
        //we are using another layer to talk to the database - 
        try (Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(query);
            if (!rs.next()) {
                throw new SQLExceptionResultEmpty();

            }
            id = rs.getInt("idperson");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            //then create a person with the data
            Person p = new Person(id, name, age);
            return p;
        }
    }

    //using void because there is nothing to return 
    public void updatePerson(Person p) throws SQLException {
        String query = "UPDATE person SET name=?, age=? WHERE personid=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, p.name);
        ps.setInt(2, p.age);
        ps.setInt(3, p.id);
        ps.execute();
    }

    //using void because there is nothing to return 
    public void deletePerson(int id) throws SQLException {
        String query = "DELETE FROM PERSON WHERE personid=" + id;
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(query);
        }

    }

}

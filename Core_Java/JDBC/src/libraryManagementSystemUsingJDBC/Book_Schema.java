package libraryManagementSystemUsingJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Book_Schema {

	
	Connection createConnection(String dbName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // if dbName is empty → connect without selecting db
            String url = dbName.isEmpty() ? "jdbc:mysql://localhost:3306/" 
                                          : "jdbc:mysql://localhost:3306/" + dbName;
            Connection con = DriverManager.getConnection(url, "root", "qwe123");
            return con;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    void createSchema() {
        try {
            // Step 1: connect without database
            Connection con = createConnection("");
            Statement state = con.createStatement();

            // Step 2: create db if not exists
            String dbCreate = "CREATE DATABASE IF NOT EXISTS library_db";
            state.executeUpdate(dbCreate);
            con.close();

            // Step 3: connect to the new database
            con = createConnection("library_db");
            state = con.createStatement();

            // Step 4: create table if not exists
            String tableCreate = "CREATE TABLE IF NOT EXISTS books("
                    + "id INT PRIMARY KEY, "
                    + "title VARCHAR(100), "
                    + "author VARCHAR(100), "
                    + "price DECIMAL(10,2), "
                    + "quantity INT)";
            state.executeUpdate(tableCreate);

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    Connection useDB() {
        // Ensure db + tables exist
        createSchema();
        // Always return a connection to the correct db
        return createConnection("library_db");
    }
}

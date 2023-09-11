package bankmanagementsystem;

import java.sql.*;

public class Conn {
    /*
     * 5 steps in JDBC
     * 1. Register the driver
     * 2. Create connection
     * 3. Create statement
     * 4. Execute query
     * 5. Close connection
     */
    Connection c;
    Statement s;

    public Conn() {
        try {
            // Register driver
            // Class.forName("com.mysql.cj.jdbc.Driver"); Don't need to register the driver
            // anymore apparently...
            // Create connection
            // By default we are running mysql in local host with port number 3306
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", <localhost username>, <mysql password>);
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

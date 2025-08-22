package ninzaCRM.genericMethodsPractise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseUtility {
	
	Connection conn = null;
	
	/**
	 * This method is used to get the connection
	 * @return
	 */
    public Connection getTheConnection() {
        Connection conn = null;
        try {
            // Load the JDBC driver (optional for newer versions of Java)
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Database connection details
            String url = "jdbc:mysql://localhost:3306/testdb"; // replace testdb with your DB name
            String username = "root"; // replace with your DB username
            String password = "root"; // replace with your DB password

            // Get connection
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully!");

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
        return conn;
    }
    
    
    /**
     * This method is used to close the database connection
     */
    public void closeTheConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Connection closed successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }


}

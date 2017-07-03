/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author burcak
 */
public class DBConnector {

    /* 
     * Singleton Pattern
     */
    
    private static DBConnector instance = new DBConnector();
    public static final String URL = "jdbc:postgresql://localhost:5432/inventory";
    public static final String USER = "postgres";
    public static final String PASSWORD = ""; // password required.
    public static final String DRIVER_CLASS = "org.postgresql.Driver"; 
    
    private DBConnector() {
        try {
            Class.forName(DRIVER_CLASS);
   
        }
        catch(ClassNotFoundException e) {
        }
    }
    
    private Connection newConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        }
        catch (SQLException e) {
            System.out.println("DB Connection error");
        }
        return conn;
    }
    public static Connection getConnection() {
        return instance.newConnection();
    }
}

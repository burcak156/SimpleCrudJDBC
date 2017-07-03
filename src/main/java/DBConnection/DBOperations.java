/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author burcak
 */
public class DBOperations {
    private Connection conn;
    private PreparedStatement prepStmt;
    public DBOperations() {
        
    }
    public void insertData() {   
        String insertSQL = "INSERT INTO product(id,productname,producttotalcost,productlevel,productdetails) " +
                "VALUES(?,?,?,?,?)";
        try {
            conn = DBConnector.getConnection();
            prepStmt = conn.prepareStatement(insertSQL);
            
            prepStmt.setInt(1, 10);
            prepStmt.setString(2, "Desicion Support System");
            prepStmt.setDouble(3, 800);
            prepStmt.setString(4, "High");
            prepStmt.setString(5, "for manufacturing sector");
            
            prepStmt.executeUpdate();
            
            System.out.println("Insert Done !!");
        }
        catch(SQLException e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit( 0 );
        } finally {
            close(prepStmt);
            close(conn);
        }
    }
    
    public void deleteData() {
        String deleteSQL = "DELETE FROM product WHERE id=?";
        try {
            conn = DBConnector.getConnection();
            prepStmt = conn.prepareStatement(deleteSQL);
            prepStmt.setInt(1, 10);
            prepStmt.executeUpdate();
            System.out.println("Record deleted !!");
        }
        catch(SQLException e){
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit( 0 );
            
        }finally {
            close(prepStmt);
            close(conn);
        }
    }
    
    public void updateData(){
        String updateSQL = "UPDATE product SET productdetails = ? WHERE id=?";
        try {
            conn = DBConnector.getConnection();
            prepStmt = conn.prepareStatement(updateSQL);
            prepStmt.setString(1 , "manufaturing sector");
            prepStmt.setInt(2, 10);
            prepStmt.executeUpdate();
            
            System.out.println("Record updated !");
        }
        catch(SQLException e){
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit( 0 );
            
        }finally {
            close(prepStmt);
            close(conn);
        }
    }
    
    public void selectData() {
        String selectSQL = "SELECT id, productname,productlevel,producttotalcost,productdetails FROM product WHERE id = ?";
        
        try {
            conn = DBConnector.getConnection();
            prepStmt = conn.prepareStatement(selectSQL);
            prepStmt.setInt(1, 10);
            ResultSet rs =  prepStmt.executeQuery();
            while (rs.next()) {
                
                int id = rs.getInt("id");
                String productName = rs.getString("productname");
                double productTotalCost = rs.getDouble("producttotalcost");
                String productLevel = rs.getString("productlevel");
                String productDetails = rs.getString("productdetails");
                
                System.out.println("id : " + id);
                System.out.println("product name : " + productName);
                
                System.out.println("product total cost : " + productTotalCost);
                System.out.println("product level : " + productLevel);
                System.out.println("product details : " + productDetails);
            }
        }
        catch(SQLException e){
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit( 0 );
            
        }finally {
            close(prepStmt);
            close(conn);
        }
    }
    
    public static void close(Connection conn) {
        if(conn != null) {
            try{
                conn.close();
            }
            catch (SQLException e) {
                
            }
        }
    }
    public static void close(PreparedStatement prepStmt) {
        if (prepStmt != null) {
            try {
                prepStmt.close();
            } catch (SQLException e) {
                
            }
        }
    }
}
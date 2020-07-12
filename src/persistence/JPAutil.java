package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JPAutil {
	
	
	public static String dbUrl= "jdbc:sqlite:res/DB/PAIDB.db";
	//this are the connection to dbs
	public static Connection connection;
	
	
	/**
	 * this functino return the connection wuth the dbs
	 * @return
	 */
	public static Connection getConnection() {
		
		connection =null; //empty connection
		
		try {	
			//get connection
			connection = DriverManager.getConnection(dbUrl);
			
//            System.out.println("Connection to SQLite has been established.");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return connection;
	}
	
	
	/**
	 * this function cloced this connection with the dbs
	 */
	public static void closedConnection() {
		
		try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {	
            System.out.println(ex.getMessage());
        }
		
	}
	
	
//	
//	public static void main(String[] args) {
//		getConnection();
//	}

}

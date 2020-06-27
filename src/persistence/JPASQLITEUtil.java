package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class JPASQLITEUtil {
	 
	//url to dbs
    static String url = "jdbc:sqlite:rec/db/pai.db";
    //connection 
	static Connection conn = null;
	/**
	 * this function connect to dbs
	 * @return the conection to dbs
	 */
	public static Connection getConnection() {
		conn = null;
		try {	
			//get connection
			conn = DriverManager.getConnection(url);
			
//            System.out.println("Connection to SQLite has been established.");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return conn;
	}
	
	/**
	 * this function close the connection 
	 */
	public static void closeConn() {
		try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {	
            System.out.println(ex.getMessage());
        }
	}
	
		
	
	/**
	 * EXIST
	 * this function return the boolean if exist a duple with this 
	 * settings
	 * @param query
	 * @return if exist a dupla with by this query
	 */
	public static boolean generalExist(String query){
		conn = null;
		
		try {
			//get 	
			conn = getConnection();
			//get result set
			ResultSet rs = conn.createStatement().executeQuery(query);
			
			if(rs.next()) {//encontro existencia
				return true;
			}else {//no existe
				return false;
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return false;
	}
	
	
	/**
	 * SELECT
	 * 
	 * @param query
	 * @return resultset to consult
	 */
	public static ResultSet generalExecuteQuerry(String query){
		conn = null;
		ResultSet rs = null;
		try {
			//get conection
			conn = getConnection();
			//get result set
			rs = conn.createStatement().executeQuery(query);
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return rs;
	}
	
	/**
	 * INSERT - UPDATE - DELETE 
	 * 
	 * @param query
	 */
	public static void generalExecuteUpdate(String query ) {
		conn = null;
		try {
			conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}	
	
	
	
}

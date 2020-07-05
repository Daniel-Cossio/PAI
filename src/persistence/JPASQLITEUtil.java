package persistence;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 

public class JPASQLITEUtil {
	 
	//url to dbs
//    static String url = "jdbc:sqlite:rec/db/pai.db"; //this are the previous db, now this don'texist
    static String url = "jdbc:sqlite:res/DB/PAIDB2.db";
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
	

	
}

package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Rclosemonth;

public class JPARclosemonth {
	


	//static vars
	private static String tableName = "rclosemonth";
	private static Connection conn =null;

	/**
	 * this function select all duples to rclosemonth table 
	 * @return
	 */
	public static ArrayList<Rclosemonth>  selectAll(){
		
		//query
		String sqlQ = "SELECT * FROM " + tableName;
		//create arraylisto to return
		ArrayList<Rclosemonth> arrl = new ArrayList<Rclosemonth>();

		//managment connection and result set
		try{
			//get connection
			conn = JPAutil.getConnection();
			//result set to consult
			ResultSet rs = conn.prepareStatement(sqlQ).executeQuery();
			
			//loop througth the result set and save this in the arraylist
			while(rs.next()){
				arrl.add(new Rclosemonth(rs.getInt(1),rs.getDate(2)));
			}
			
			return arrl;
		} catch (SQLException e){
			System.err.println(e.getMessage());
			return null;
		}


	}
	
	
	
	/**
	 * rhis functiopn update the spesific duple by the 
	 * gived rclosemonth 
	 * @param rclosemonth
	 */
	public static void update(Rclosemonth rclosemonth) {
		//empty connection
		conn = null;
		try {
			//get connection
			conn = JPAutil.getConnection();
			//statment to process
			PreparedStatement pst = conn.prepareStatement(
					"UPDATE " + tableName + " SET date_cm = ? " +" WHERE code_cm = ?");
			
			//set values
			pst.setDate(1, rclosemonth.getDate_cm());
			pst.setInt(2, rclosemonth.getCode_cm());
			
			//execute changes in db
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//cloced connection
			JPAutil.closedConnection();
			
		}
	}
	
	
	
	/**
	 * This function remove the spesific duple by the code-g string
	 * @param codeG
	 */

	public static void delete(int code) {
		//empty connection
		conn  = null;
		try {
			//get connection 
			conn  = JPAutil.getConnection();
			//statment to process
			PreparedStatement pst = conn.prepareStatement("DELETE FROM "+ tableName+ " WHERE code_cm = ?");//prepare querry

			//set values
			pst.setInt(1, code);
			//execute changes in db
			pst.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//closed conection
			JPAutil.closedConnection();
		}
	}

	/**
	 * This function create a nwe duple and this storage the givened rclosemonth
	 * @param rclosemonth
	 */
	public static void create(Rclosemonth rclosemonth) {
		//empty connection
		conn = null;

		try {
			//get connection
			conn = JPAutil.getConnection(); 

			//statement process
			PreparedStatement pst = conn.prepareStatement("INSERT INTO " + tableName + " (code_cm, date_cm) VALUES (?,?)");

			//sest values
			pst.setInt(1, rclosemonth.getCode_cm());//insert code
			pst.setDate(2, rclosemonth.getDate_cm());//insert name 

			//execute change in DBS
			pst.executeUpdate();
		}catch (java.sql.SQLIntegrityConstraintViolationException  e) {
			System.out.println("primary key violation");
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("ERROR TO TRY INSERT GROUPP");
			e.printStackTrace();
		} finally {
			//try closed connection
			JPAutil.closedConnection();
		}
	}


	/**
	 * This fuction allow know if the codeG already exist in the tabe 
	 * @param code
	 * @return
	 */
	public static boolean exist(int code) {
		//empty connection
		conn = null;
		
		//result set
		
		try {
			conn = JPAutil.getConnection();//get connection to dbs
			//statement to process
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE code_cm = ?" );
			//set value
			pst.setInt(1, code);
			//execute querry
			ResultSet rs = pst.executeQuery();
			//return the existence
			return rs.next();
		} catch (Exception e) {
			System.out.println("Problems to connect or querry Rclosemonth");
			return false;
		}finally {
			//closed conection
			JPAutil.closedConnection();
		}
	}

	/**
	 * this function print in the console the arraylist
	 * @param argpp
	 */
	
	public static void printArrL(ArrayList<Rclosemonth> argpp) {
		if (argpp != null)
			for (int i = 0; i < argpp.size(); i++) {
				System.out.println("---------------------------------------------");
				System.out.println(argpp.get(i).toString());
			}
	}
	
	
//	public static void main(String[] args) {
		//create
//		create(new Rclosemonth(1,new Date(2)));
//		create(new Rclosemonth(2,new Date(2)));
//		create(new Rclosemonth(3,new Date(2)));
//		create(new Rclosemonth("2", "gr2"));
//		create(new Rclosemonth("3", "gr3"));
		//update 
//		update(new Rclosemonth(2,new Date(120, 1, 14)));
		//delete
//		delete(3);
		//exist
//		System.out.println(exist(1));
//		System.out.println(exist(3));
//		printArrL(selectAll());
//		printArrL(selectName("up"));
//	}


}

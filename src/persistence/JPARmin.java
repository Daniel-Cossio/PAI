package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Rmin;

public class JPARmin {

	//static vars
	private static String tableName = "rmin";
	private static Connection conn =null;

	/**
	 * this function select all duples to rmin table 
	 * @return
	 */
	public static ArrayList<Rmin>  selectAll(){
		
		//query
		String sqlQ = "SELECT * FROM " + tableName;
		//create arraylisto to return
		ArrayList<Rmin> arrl = new ArrayList<Rmin>();

		//managment connection and result set
		try{
			//get connection
			conn = JPAutil.getConnection();
			//result set to consult
			ResultSet rs = conn.prepareStatement(sqlQ).executeQuery();
			
			//loop througth the result set and save this in the arraylist
			while(rs.next()){
				arrl.add(new Rmin(rs.getInt(1),rs.getDouble(2),rs.getDouble(3)));
			}
			
			return arrl;
		} catch (SQLException e){
			System.err.println(e.getMessage());
			return null;
		}


	}
	
	
	/**
	 * rhis functiopn update the spesific duple by the 
	 * gived rmin 
	 * @param rmin
	 */
	public static void update(Rmin rmin) {
		//empty connection
		conn = null;
		try {
			//get connection
			conn = JPAutil.getConnection();
			//statment to process
			PreparedStatement pst = conn.prepareStatement(
					"UPDATE " + tableName + " SET account = ?, total_pryce = ? " +" WHERE code_m = ?");
			
			//set values
			pst.setDouble(1, rmin.getAccont());
			pst.setDouble(2, rmin.getTotal_pryce());
			pst.setInt(3, rmin.getCode_m());
			
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
			PreparedStatement pst = conn.prepareStatement("DELETE FROM "+ tableName+ " WHERE code_m = ?");//prepare querry

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
	 * This function create a nwe duple and this storage the givened rmin
	 * @param rmin
	 */
	public static void create(Rmin rmin) {
		//empty connection
		conn = null;

		try {
			//get connection
			conn = JPAutil.getConnection(); 

			//statement process
			PreparedStatement pst = conn.prepareStatement("INSERT INTO " + tableName + " (code_m, account, total_pryce) VALUES (?,?,?)");

			//sest values
			pst.setInt(1, rmin.getCode_m()); 
			pst.setDouble(2, rmin.getAccont());
			pst.setDouble(3, rmin.getTotal_pryce());
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
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE code_m= ?" );
			//set value
			pst.setInt(1, code);
			//execute querry
			ResultSet rs = pst.executeQuery();
			//return the existence
			return rs.next();
		} catch (Exception e) {
			System.out.println("Problems to connect or querry Rmin");
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
	
	public static void printArrL(ArrayList<Rmin> argpp) {
		if (argpp != null)
			for (int i = 0; i < argpp.size(); i++) {
				System.out.println("---------------------------------------------");
				System.out.println(argpp.get(i).toString());
			}
	}
	
	
//	public static void main(String[] args) {
		//create
//		create(new Rmin(1,23,2)); 
//		create(new Rmin(2,2.35,24.45));
//		create(new Rmin(3,23.434,32));
		//update 
//		update(new Rmin(2,23,23));
		//delete
//		delete(3);
		//exist
//		System.out.println(exist(1));
//		System.out.println(exist(3));
//		printArrL(selectAll());
//		printArrL(selectName("up"));
//	}


}

package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Rinitialstock;

public class JPARinitialstock {


	//static vars
	private static String tableName = "rinitialstock";
	private static Connection conn =null;

	/**
	 * this function select all duples to rinitialstock table 
	 * @return
	 */
	public static ArrayList<Rinitialstock>  selectAll(){
		
		//query
		String sqlQ = "SELECT * FROM " + tableName;
		//create arraylisto to return
		ArrayList<Rinitialstock> arrl = new ArrayList<Rinitialstock>();

		//managment connection and result set
		try{
			//get connection
			conn = JPAutil.getConnection();
			//result set to consult
			ResultSet rs = conn.prepareStatement(sqlQ).executeQuery();
			
			//loop througth the result set and save this in the arraylist
			while(rs.next()){
				arrl.add(new Rinitialstock(rs.getInt(1),rs.getInt(2),rs.getDouble(3)));
			}
			
			return arrl;
		} catch (SQLException e){
			System.err.println(e.getMessage());
			return null;
		}


	}
	
	/**
	 * rhis functiopn update the spesific duple by the 
	 * gived rinitialstock 
	 * @param rinitialstock
	 */
	public static void update(Rinitialstock rinitialstock) {
		//empty connection
		conn = null;
		try {
			//get connection
			conn = JPAutil.getConnection();
			//statment to process
			PreparedStatement pst = conn.prepareStatement(
					"UPDATE " + tableName + " SET code_cm = ?, measure = ? " +" WHERE code_m = ?");
			
			//set values
			pst.setInt(1, rinitialstock.getCode_cm());
			pst.setDouble(2, rinitialstock.getMeasure());
			pst.setInt(3, rinitialstock.getCode_m());
			
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

	public static void delete(String code) {
		//empty connection
		conn  = null;
		try {
			//get connection 
			conn  = JPAutil.getConnection();
			//statment to process
			PreparedStatement pst = conn.prepareStatement("DELETE FROM "+ tableName+ " WHERE code_m = ?");//prepare querry

			//set values
			pst.setString(1, code);
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
	 * This function create a nwe duple and this storage the givened rinitialstock
	 * @param rinitialstock
	 */
	public static void create(Rinitialstock rinitialstock) {
		//empty connection
		conn = null;

		try {
			//get connection
			conn = JPAutil.getConnection(); 

			//statement process
			PreparedStatement pst = conn.prepareStatement("INSERT INTO " + tableName + " (code_m, code_cm, measure) VALUES (?,?,?)");

			//sest values
			pst.setInt(1, rinitialstock.getCode_m()); 
			pst.setInt(2, rinitialstock.getCode_cm());
			pst.setDouble(3, rinitialstock.getMeasure());
			 

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
	public static boolean exist(String code) {
		//empty connection
		conn = null;
		
		//result set
		
		try {
			conn = JPAutil.getConnection();//get connection to dbs
			//statement to process
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE code_m = ?" );
			//set value
			pst.setString(1, code);
			//execute querry
			ResultSet rs = pst.executeQuery();
			//return the existence
			return rs.next();
		} catch (Exception e) {
			System.out.println("Problems to connect or querry Rinitialstock");
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
	
	public static void printArrL(ArrayList<Rinitialstock> argpp) {
		if (argpp != null)
			for (int i = 0; i < argpp.size(); i++) {
				System.out.println("---------------------------------------------");
				System.out.println(argpp.get(i).toString());
			}
	}
	
	
//	public static void main(String[] args) {
//		//create
//		create(new Rinitialstock(1,2,2.34));
//		create(new Rinitialstock(2,2,234.5));
//		create(new Rinitialstock(3,2,554.5));
//		//update 
//		update(new Rinitialstock(2,3,12313.34));
//		//delete
//		delete("3");
//		//exist
//		System.out.println(exist("1"));
//		System.out.println(exist("3"));
//		printArrL(selectAll());
//		printArrL(selectName("up"));
//	}

}

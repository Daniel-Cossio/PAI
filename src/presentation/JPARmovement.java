package presentation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Rmovement;

public class JPARmovement {

	//static vars
	private static String tableName = "rmovement";
	private static Connection conn =null;

	/**
	 * this function select all duples to rmovement table 
	 * @return
	 */
	public static ArrayList<Rmovement>  selectAll(){
		
		//query
		String sqlQ = "SELECT * FROM " + tableName;
		//create arraylisto to return
		ArrayList<Rmovement> arrl = new ArrayList<Rmovement>();

		//managment connection and result set
		try{
			//get connection
			conn = JPAutil.getConnection();
			//result set to consult
			ResultSet rs = conn.prepareStatement(sqlQ).executeQuery();
			
			//loop througth the result set and save this in the arraylist
			while(rs.next()){
				arrl.add(new Rmovement(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(7)));
//				arrl.add(new Rmovement(rs.getInt(1), new Date(1), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(7)));
			}
			
			return arrl;
		} catch (SQLException e){
//			System.err.println(e.getMessage());
			e.printStackTrace();
			return null;
		}


	}
	
	
	/**
	 * This function return all duples to rmovement table with the 
	 * conincidence with search String
	 * @param str is the string to search
	 * @return the arraylist consult
	 */
	public static ArrayList<Rmovement> selectName(String str){
		
		//query
		String sqlQ = "SELECT * FROM " + tableName + " WHERE code_invoice LIKE '%"+str+"%'";
		//create array list
		ArrayList<Rmovement> arrl = new ArrayList<Rmovement>();

		
		try{
			//getconnection 
			conn = JPAutil.getConnection();
			//result set to consult
			ResultSet rs = conn.prepareStatement(sqlQ).executeQuery();
			//loop througth the result set and save this in the arraylist
			while(rs.next()){
				arrl.add(new Rmovement(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(7)));
			}

			return arrl;
		} catch (SQLException e){
			System.err.println(e.getMessage());
			return null;
		}
	}

	/**
	 * rhis functiopn update the spesific duple by the 
	 * gived rmovement 
	 * @param rmovement
	 */
	public static void update(Rmovement rmovement) {
		//empty connection
		conn = null;
		try {
			//get connection
			conn = JPAutil.getConnection();
			//statment to process
			PreparedStatement pst = conn.prepareStatement(
					"UPDATE " + tableName + " SET date_m = ?, code_invoice = ?, type_m = ?, quantity = ?, code_p = ?, code_u = ?  " +" WHERE code_m= ?");
			
			//set values
			pst.setDate(1, rmovement.getDate_m());
			pst.setString(2, rmovement.getCode_invoice());
			pst.setString(3, rmovement.getType_m());
			pst.setDouble(4, rmovement.getQuantity());
			pst.setString(5, rmovement.getCode_p());
			pst.setString(6, rmovement.getCode_u());
			pst.setInt(7, rmovement.getCode_m());
			
			
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
	 * This function create a nwe duple and this storage the givened rmovement
	 * @param rmovement
	 */
	public static void create(Rmovement rmovement) {
		//empty connection
		conn = null;

		try {
			//get connection
			conn = JPAutil.getConnection(); 

			//statement process
			PreparedStatement pst = conn.prepareStatement("INSERT INTO " + tableName + " ( date_m, code_invoice, type_m, quantity, code_p, code_u) VALUES (?,?,?,?,?,?)");

			//sest values
//			pst.setInt(1, rmovement.getCode_m());
//			pst.setDate(2, rmovement.getDate_m());
//			pst.setString(3, rmovement.getCode_invoice());
//			pst.setString(4, rmovement.getType_m());
//			pst.setDouble(5, rmovement.getQuantity());
//			pst.setString(6, rmovement.getCode_p());
//			pst.setString(7, rmovement.getCode_u());
			
			pst.setDate(1, rmovement.getDate_m());
			pst.setString(2, rmovement.getCode_invoice());
			pst.setString(3, rmovement.getType_m());
			pst.setDouble(4, rmovement.getQuantity());
			pst.setString(5, rmovement.getCode_p());
			pst.setString(6, rmovement.getCode_u());
			
			 

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
			System.out.println("Problems to connect or querry Rmovement");
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
	
	public static void printArrL(ArrayList<Rmovement> argpp) {
		if (argpp != null)
			for (int i = 0; i < argpp.size(); i++) {
				System.out.println("---------------------------------------------");
				System.out.println(argpp.get(i).toString());
			}
	}
	
	
//	public static void main(String[] args) {
//		//create
//		create(new Rmovement(new Date(120,1,24),"factura453545","Entrada",12314.1234,"1","1")); 
//		create(new Rmovement(new Date(120,1,25),"453545","Ajuste",1231443.12,"1",null));
//		create(new Rmovement(new Date(120,1,26),"fact","SALIDA",123144343.1234,null,"2"));
//		//update 
//		update(new Rmovement(2,new Date(121,4,30),"45sdf3g5fg45","NONE",1231443.1223,null,null));
//		//delete
//		delete(1);
//		//exist
//		System.out.println(exist("1"));
//		System.out.println(exist("3"));
//		printArrL(selectAll());
//		printArrL(selectName("fac"));
//	}


}

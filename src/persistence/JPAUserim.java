package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Userim;

public class JPAUserim {

	//static vars
	private static String tableName = "userim";
	private static Connection conn =null;

	/**
	 * this function select all duples to userim table 
	 * @return
	 */
	public static ArrayList<Userim>  selectAll(){
		
		//query
		String sqlQ = "SELECT * FROM " + tableName;
		//create arraylisto to return
		ArrayList<Userim> arrl = new ArrayList<Userim>();

		//managment connection and result set
		try{
			//get connection
			conn = JPAutil.getConnection();
			//result set to consult
			ResultSet rs = conn.prepareStatement(sqlQ).executeQuery();
			
			//loop througth the result set and save this in the arraylist
			while(rs.next()){
				arrl.add(new Userim(rs.getString(1),rs.getString(2),rs.getString(3)));
			}
			
			return arrl;
		} catch (SQLException e){
			System.err.println(e.getMessage());
			return null;
		}


	}
	
	
	/**
	 * This function return all duples to userim table with the 
	 * conincidence with search String
	 * @param str is the string to search
	 * @return the arraylist consult
	 */
	public static ArrayList<Userim> selectName(String str){
		
		//query
		String sqlQ = "SELECT * FROM " + tableName + " WHERE name_u LIKE '%"+str+"%'";
		//create array list
		ArrayList<Userim> arrl = new ArrayList<Userim>();

		
		try{
			//getconnection 
			conn = JPAutil.getConnection();
			//result set to consult
			ResultSet rs = conn.prepareStatement(sqlQ).executeQuery();
			//loop througth the result set and save this in the arraylist
			while(rs.next()){
				arrl.add(new Userim(rs.getString(1),rs.getString(2),rs.getString(3)));
			}

			return arrl;
		} catch (SQLException e){
			System.err.println(e.getMessage());
			return null;
		}
	}

	/**
	 * rhis functiopn update the spesific duple by the 
	 * gived userim 
	 * @param userim
	 */
	public static void update(Userim userim) {
		//empty connection
		conn = null;
		try {
			//get connection
			conn = JPAutil.getConnection();
			//statment to process
			PreparedStatement pst = conn.prepareStatement(
					"UPDATE " + tableName + " SET name_u = ?, password_u = ? " +" WHERE code_u = ?");
			
			//set values
			pst.setString(1, userim.getName_u());
			pst.setString(2, userim.getPassword_u());
			pst.setString(3, userim.getCode_u());
			
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
			PreparedStatement pst = conn.prepareStatement("DELETE FROM "+ tableName+ " WHERE code_u = ?");//prepare querry

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
	 * This function create a nwe duple and this storage the givened userim
	 * @param userim
	 */
	public static void create(Userim userim) {
		//empty connection
		conn = null;

		try {
			//get connection
			conn = JPAutil.getConnection(); 

			//statement process
			PreparedStatement pst = conn.prepareStatement("INSERT INTO " + tableName + " (code_u, name_u, password_u) VALUES (?,?,?)");

			//sest values
			pst.setString(1, userim.getCode_u());//insert code
			pst.setString(2, userim.getName_u());//insert name
			pst.setString(3, userim.getPassword_u());//insert name 

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
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE code_u = ?" );
			//set value
			pst.setString(1, code);
			//execute querry
			ResultSet rs = pst.executeQuery();
			//return the existence
			return rs.next();
		} catch (Exception e) {
			System.out.println("Problems to connect or querry Userim");
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
	
	public static void printArrL(ArrayList<Userim> argpp) {
		if (argpp != null)
			for (int i = 0; i < argpp.size(); i++) {
				System.out.println("---------------------------------------------");
				System.out.println(argpp.get(i).toString());
			}
	}
	
	
//	public static void main(String[] args) {
//		//create
//		create(new Userim("1", "fernaando","sadfas534")); 
//		create(new Userim("2", "glucas","245234"));
//		create(new Userim("3", "lorenzo", "password"));
//		//update 
//		update(new Userim("2","lucas UP", "1234lucas"));
//		//delete
//		delete("3");
//		//exist
//		System.out.println(exist("1"));
//		System.out.println(exist("3"));
//		printArrL(selectAll());
//		printArrL(selectName("up"));
//	}

}

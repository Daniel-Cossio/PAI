package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Subgroup;

public class JPASubgroup {
	

	//static vars
	private static String tableName = "subgroup";
	private static Connection conn =null;

	/**
	 * this function select all duples to subgroup table 
	 * @return
	 */
	public static ArrayList<Subgroup>  selectAll(){
		
		//query
		String sqlQ = "SELECT * FROM " + tableName;
		//create arraylisto to return
		ArrayList<Subgroup> arrl = new ArrayList<Subgroup>();

		//managment connection and result set
		try{
			//get connection
			conn = JPAutil.getConnection();
			//result set to consult
			ResultSet rs = conn.prepareStatement(sqlQ).executeQuery();
			
			//loop througth the result set and save this in the arraylist
			while(rs.next()){
				arrl.add(new Subgroup(rs.getString(1),rs.getString(2),rs.getString(3)));
			}
			
			return arrl;
		} catch (SQLException e){
			System.err.println(e.getMessage());
			return null;
		}


	}
	
	
	/**
	 * This function return all duples to subgroup table with the 
	 * conincidence with search String
	 * @param str is the string to search
	 * @return the arraylist consult
	 */
	public static ArrayList<Subgroup> selectName(String str){
		
		//query
		String sqlQ = "SELECT * FROM " + tableName + " WHERE name_sg LIKE '%"+str+"%'";
		//create array list
		ArrayList<Subgroup> arrl = new ArrayList<Subgroup>();

		
		try{
			//getconnection 
			conn = JPAutil.getConnection();
			//result set to consult
			ResultSet rs = conn.prepareStatement(sqlQ).executeQuery();
			//loop througth the result set and save this in the arraylist
			while(rs.next()){
				arrl.add(new Subgroup(rs.getString(1),rs.getString(2),rs.getString(3)));
			}

			return arrl;
		} catch (SQLException e){
			System.err.println(e.getMessage());
			return null;
		}
	}

	/**
	 * rhis functiopn update the spesific duple by the 
	 * gived subgroup 
	 * @param subgroup
	 */
	public static void update(Subgroup subgroup) {
		//empty connection
		conn = null;
		try {
			//get connection
			conn = JPAutil.getConnection();
			//statment to process
			PreparedStatement pst = conn.prepareStatement(
					"UPDATE " + tableName + " SET name_sg = ?, code_g = ? " +" WHERE code_sg = ?");
			
			//set values
			pst.setString(1, subgroup.getName_sg());
			pst.setString(2, subgroup.getCode_g());
			pst.setString(3, subgroup.getCode_sg());
			
			
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
			PreparedStatement pst = conn.prepareStatement("DELETE FROM "+ tableName+ " WHERE code_sg = ?");//prepare querry

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
	 * This function create a nwe duple and this storage the givened subgroup
	 * @param subgroup
	 */
	public static void create(Subgroup subgroup) {
		//empty connection
		conn = null;

		try {
			//get connection
			conn = JPAutil.getConnection(); 

			//statement process
			PreparedStatement pst = conn.prepareStatement("INSERT INTO " + tableName + " (code_sg, name_sg, code_g) VALUES (?,?,?)");

			//sest values
			pst.setString(1, subgroup.getCode_sg());//insert code
			pst.setString(2, subgroup.getName_sg());//insert name
			pst.setString(3, subgroup.getCode_g());//insert name 

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
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE code_sg = ?" );
			//set value
			pst.setString(1, code);
			//execute querry
			ResultSet rs = pst.executeQuery();
			//return the existence
			return rs.next();
		} catch (Exception e) {
			System.out.println("Problems to connect or querry Subgroup");
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
	
	public static void printArrL(ArrayList<Subgroup> argpp) {
		if (argpp != null)
			for (int i = 0; i < argpp.size(); i++) {
				System.out.println("---------------------------------------------");
				System.out.println(argpp.get(i).toString());
			}
	}
	
	
//	public static void main(String[] args) {
//		create
//		create(new Subgroup("1", "gr1","1")); 
//		create(new Subgroup("2", "gr2",null));
//		create(new Subgroup("3", "gr3","2"));
//		update 
//		update(new Subgroup("2","g update","2"));
//		delete
//		delete("3");
//		exist
//		System.out.println(exist("1"));
//		System.out.println(exist("3"));
//		printArrL(selectAll());
//		printArrL(selectName("up"));
//	}


}

package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Department;

public class JPADepartment {
	

	//static vars
	private static String tableName = "department";
	private static Connection conn =null;

	/**
	 * this function select all duples to department table 
	 * @return
	 */
	public static ArrayList<Department>  selectAll(){
		
		//query
		String sqlQ = "SELECT * FROM " + tableName;
		//create arraylisto to return
		ArrayList<Department> arrl = new ArrayList<Department>();

		//managment connection and result set
		try{
			//get connection
			conn = JPAutil.getConnection();
			//result set to consult
			ResultSet rs = conn.prepareStatement(sqlQ).executeQuery();
			
			//loop througth the result set and save this in the arraylist
			while(rs.next()){
				arrl.add(new Department(rs.getString(1),rs.getString(2)));
			}
			
			return arrl;
		} catch (SQLException e){
			System.err.println(e.getMessage());
			return null;
		}


	}
	
	
	/**
	 * This function return all duples to department table with the 
	 * conincidence with search String
	 * @param str is the string to search
	 * @return the arraylist consult
	 */
	public static ArrayList<Department> selectName(String str){
		
		//query
		String sqlQ = "SELECT * FROM " + tableName + " WHERE name_d LIKE '%"+str+"%'";
		//create array list
		ArrayList<Department> arrl = new ArrayList<Department>();

		
		try{
			//getconnection 
			conn = JPAutil.getConnection();
			//result set to consult
			ResultSet rs = conn.prepareStatement(sqlQ).executeQuery();
			//loop througth the result set and save this in the arraylist
			while(rs.next()){
				arrl.add(new Department(rs.getString(1),rs.getString(2)));
			}

			return arrl;
		} catch (SQLException e){
			System.err.println(e.getMessage());
			return null;
		}
	}

	/**
	 * rhis functiopn update the spesific duple by the 
	 * gived department 
	 * @param department
	 */
	public static void update(Department department) {
		//empty connection
		conn = null;
		try {
			//get connection
			conn = JPAutil.getConnection();
			//statment to process
			PreparedStatement pst = conn.prepareStatement(
					"UPDATE " + tableName + " SET name_d = ? " +" WHERE code_d = ?");
			
			//set values
			pst.setString(1, department.getName_d());
			pst.setString(2, department.getCode_d());
			
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
			PreparedStatement pst = conn.prepareStatement("DELETE FROM "+ tableName+ " WHERE code_d = ?");//prepare querry

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
	 * This function create a nwe duple and this storage the givened department
	 * @param department
	 */
	public static void create(Department department) {
		//empty connection
		conn = null;

		try {
			//get connection
			conn = JPAutil.getConnection(); 

			//statement process
			PreparedStatement pst = conn.prepareStatement("INSERT INTO " + tableName + " (code_d, name_d) VALUES (?,?)");

			//sest values
			pst.setString(1, department.getCode_d());//insert code
			pst.setString(2, department.getName_d());//insert name 

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
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE code_d = ?" );
			//set value
			pst.setString(1, code);
			//execute querry
			ResultSet rs = pst.executeQuery();
			//return the existence
			return rs.next();
		} catch (Exception e) {
			System.out.println("Problems to connect or querry Department");
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
	
	public static void printArrL(ArrayList<Department> argpp) {
		if (argpp != null)
			for (int i = 0; i < argpp.size(); i++) {
				System.out.println("---------------------------------------------");
				System.out.println(argpp.get(i).toString());
			}
	}
	
	
	public static void main(String[] args) {
		//create
		create(new Department("1", "d1")); 
		create(new Department("2", "d2"));
		create(new Department("3", "d3"));
		//update 
		update(new Department("2","d update"));
		//delete
		delete("3");
		//exist
		System.out.println(exist("1"));
		System.out.println(exist("3"));
		printArrL(selectAll());
		printArrL(selectName("up"));
	}


}

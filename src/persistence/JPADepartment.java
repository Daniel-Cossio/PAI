package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import objects.Department;
import objects.Groupp;

public class JPADepartment {

	private static String tableName="department";
	private static Connection conn =null;


	/**
	 * this function return all departments in the dbs 
	 * @return
	 */

	public static ArrayList<Department>  selectAllD(){
		String sqlQ = "SELECT * FROM " + tableName;//SQL TO SEARCH ALLS

		ArrayList<Department> depts = new ArrayList<Department>();

		try{
			conn = JPASQLITEUtil.getConnection();
			ResultSet rs = conn.prepareStatement(sqlQ).executeQuery();

			while(rs.next()){
				depts.add(new Department(rs.getString(1),rs.getString(2)));
			}

			return depts;
		} catch (SQLException e){
			System.err.println(e.getMessage());
			return null;
		}

	}
	
	
	/**
	 * this function return all departments in the dbs whuth the cininsidence like n
	 * in the name 
	 * @param name
	 * @return
	 */
	public static ArrayList<Department>  selectNameD(String name){
		String sqlQ = "SELECT * FROM " + tableName + " WHERE name_d LIKE '%" +name+ "%'";//SQL TO SEARCH ALLS
		ArrayList<Department> depts = new ArrayList<Department>();

		try{
			conn = JPASQLITEUtil.getConnection();
			ResultSet rs = conn.prepareStatement(sqlQ).executeQuery();
			while(rs.next()){
				depts.add(new Department(rs.getString(1),rs.getString(2)));
			}
			return depts;
		} catch (SQLException e){
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	/**
	 * this function update the department dulpe
	 * @param dept
	 */
	public static void updateD(Department dept) {
		conn = null;
		try {
			conn = JPASQLITEUtil.getConnection();//get connection
			PreparedStatement pst = conn.prepareStatement(
					"UPDATE " + tableName + " SET name_d = ? " +" WHERE code_d = ?"); //prepare querry
			//set values
			pst.setString(1, dept.getNameD());
			pst.setString(2, dept.getCodeD());
			//execute querry
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//cieroo la coneccion

			JPASQLITEUtil.closeConn();

		}
	}
	
	/**
	 * this function delete a spesific department duple
	 * @param codeD
	 */
	public static void deleteD(String codeD) {
		conn  = null;
		try {
			conn  = JPASQLITEUtil.getConnection();//get connection
			PreparedStatement pst = conn.prepareStatement("DELETE FROM "+ tableName+ " WHERE code_d = ?");//prepare querry

			pst.setString(1, codeD);//insert the value to querry
			pst.executeUpdate();//execute querry

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//closed conection
			JPASQLITEUtil.closeConn();
		}

	}

	/**
	 * this function create a new deparment and storage this in the db
	 * @param dept
	 */
	public static void createD(Department dept) {
		conn = null;//empty connection

		try {
			conn = JPASQLITEUtil.getConnection();//get connection 

			//prepare the sql statament
			PreparedStatement pst = conn.prepareStatement("INSERT INTO " + tableName + " (code_d, name_d) VALUES (?,?)");

			//insertion to values to class
			pst.setString(1, dept.getCodeD());//insert code
			pst.setString(2, dept.getNameD());//insert name 

			//execute change in DBS
			pst.executeUpdate();


		}catch (java.sql.SQLIntegrityConstraintViolationException  e) {
			System.out.println("primary key violation");
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("ERROR TO TRY INSERT DEPT");
			e.printStackTrace();
		} finally {
			//try closed connection
			JPASQLITEUtil.closeConn();
		}
	} 

	/**
	 * This function search a department with the same code
	 * @param codeD
	 * @return the existence the department
	 */
	public static boolean existD(String codeD) {
		conn = null;
		ResultSet rs = null;
		try {
			conn = JPASQLITEUtil.getConnection();//get connection to dbs
			//set to query
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE code_d = ?" );
			//inside the code to search
			pst.setString(1, codeD);
			//execute querry
			rs = pst.executeQuery();

			return rs.next();
		} catch (Exception e) {
			System.out.println("Problems to connect or querry Department");
			return false;
		}finally {
			//closed conection
			JPASQLITEUtil.closeConn();
		}
	}
	
	
	/**
	 * this function print the arraylist 
	 * @param arDep
	 */
	public static void printArrL(ArrayList<Department> arDep) {
		System.out.println("|" + String.format("%-10s",  " CODE D ") + "|" + String.format("%-10s",  "NAME D") + "|");

		if (arDep != null)
			for (int i = 0; i < arDep.size(); i++) {

				System.out.println("-----------------------");
				System.out.println(arDep.get(i).toStringF());
			}
	}
	
	//probe
//	public static void main(String[] args) {
		//create
//		createD(new Department("1", "dep1"));
//		createD(new Department("2", "dep1"));
//		createD(new Department("3", "dep1"));
		//update
//		updateD(new Department("2","dep update"));
		//delete
//		deleteD("3");
		//exist
//		System.out.println(existD("1"));
//		System.out.println(existD("3"));
		//
//		printArrL(selectNameD("up"));
//		printArrL(selectAllD());
//	}

}
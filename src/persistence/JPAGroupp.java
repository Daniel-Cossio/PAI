package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import objects.Groupp;


public class JPAGroupp {

	private static String tableName = "groupp";
	private static Connection conn =null;

	/**
	 * this function select consult the selects 
	 * @return
	 */
	public static ArrayList<Groupp>  selectAllG(){
		String sqlQ = "SELECT * FROM " + tableName;//SQL TO SEARCH ALLS

		ArrayList<Groupp> groups = new ArrayList<Groupp>();

		try{
			conn = JPASQLITEUtil.getConnection();
			ResultSet rs = conn.prepareStatement(sqlQ).executeQuery();

			while(rs.next()){
				groups.add(new Groupp(rs.getString(1),rs.getString(2)));
			}

			return groups;
		} catch (SQLException e){
			System.err.println(e.getMessage());
			return null;
		}


	}
	/**
	 * This function create cnsul to search with the name
	 * this waint the string to search by name  
	 * @param str 
	 * @return the arraylist consult
	 */
	public static ArrayList<Groupp> selectNameG(String str){
		String sqlQ = "SELECT * FROM " + tableName + " WHERE name_g LIKE '%"+str+"%'";//SQL TO SEARCH USING LIKE

		ArrayList<Groupp> groups = new ArrayList<Groupp>();

		try{
			conn = JPASQLITEUtil.getConnection();
			ResultSet rs = conn.prepareStatement(sqlQ).executeQuery();

			while(rs.next()){
				groups.add(new Groupp(rs.getString(1),rs.getString(2)));
			}

			return groups;
		} catch (SQLException e){
			System.err.println(e.getMessage());
			return null;
		}
	}

	/**
	 * This function actualice a previous registry 
	 * @param groupp
	 */
	public static void updateG(Groupp groupp) {
		conn = null;
		try {
			conn = JPASQLITEUtil.getConnection();//get connection
			PreparedStatement pst = conn.prepareStatement(
					"UPDATE " + tableName + " SET name_g = ? " +" WHERE code_g = ?"); //prepare querry
			//set values
			pst.setString(1, groupp.getNameG());
			pst.setString(2, groupp.getCodeG());
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
	 * This function remove theh duple with this registry
	 * @param codeG
	 */

	public static void deleteG(String codeG) {
		conn  = null;
		try {
			conn  = JPASQLITEUtil.getConnection();//get connection
			PreparedStatement pst = conn.prepareStatement("DELETE FROM "+ tableName+ " WHERE code_g = ?");//prepare querry

			pst.setString(1, codeG);//insert the value to querry
			pst.executeUpdate();//execute querry

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//closed conection
			JPASQLITEUtil.closeConn();
		}

	}

	/**
	 * This function create a nwe duple, this storage the give group
	 * @param groupp
	 */
	public static void createG(Groupp groupp) {
		conn = null;//empty connection

		try {
			conn = JPASQLITEUtil.getConnection();//get connection 

			//prepare the sql statament
			PreparedStatement pst = conn.prepareStatement("INSERT INTO " + tableName + " (code_g, name_g) VALUES (?,?)");

			//insertion to values to class
			pst.setString(1, groupp.getCodeG());//insert code
			pst.setString(2, groupp.getNameG());//insert name 

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
			JPASQLITEUtil.closeConn();
		}
	}


	/**
	 * This fuction allow know if the codeG already exist in the tabe 
	 * @param codeG
	 * @return
	 */
	public static boolean existG(String codeG) {
		conn = null;
		ResultSet rs = null;
		try {
			conn = JPASQLITEUtil.getConnection();//get connection to dbs
			//set to query
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE code_g = ?" );
			//inside the code to search
			pst.setString(1, codeG);
			//execute querry
			rs = pst.executeQuery();

			return rs.next();
		} catch (Exception e) {
			System.out.println("Problems to connect or querry Groupp");
			return false;
		}finally {
			//closed conection
			JPASQLITEUtil.closeConn();
		}
	}

	/**
	 * this function print in the console the arraylist
	 * @param argpp
	 */
	
	public static void printArrL(ArrayList<Groupp> argpp) {
		System.out.println("|" + String.format("%-10s",  " CODE G ") + "|" + String.format("%-10s",  "NAME G") + "|");

		if (argpp != null)
			for (int i = 0; i < argpp.size(); i++) {

				System.out.println("-----------------------");
				System.out.println(argpp.get(i).toStringF());
			}
	}
// PTOBRES
//	public static void main(String[] args) {
		//		CREATE
		//		createG(new Groupp("1",	 "G1"));
		//		createG(new Groupp("2",	 "G1"));
		//		createG(new Groupp("3",	 "G1"));
		//		UPDATE 
		//		updateG(new Groupp("2", "G update"));
		//		DELETE
		//		deleteG("3");
		//		EXIST
		//		System.out.println(existG("4"));
		//		

		//		printArrL(selectAllG());
		//		printArrL(selectNameG("up"));

//	}

}

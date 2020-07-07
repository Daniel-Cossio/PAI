package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Product;

public class JPAProduct {	

	//static vars
	private static String tableName = "product";
	private static Connection conn =null;

	/**
	 * this function select all duples to product table 
	 * @return
	 */
	public static ArrayList<Product>  selectAll(){
		
		//query
		String sqlQ = "SELECT * FROM " + tableName;
		//create arraylisto to return
		ArrayList<Product> arl = new ArrayList<Product>();

		//managment connection and result set
		try{
			//get connection
			conn = JPAutil.getConnection();
			//result set to consult
			ResultSet rs = conn.prepareStatement(sqlQ).executeQuery();
			
			//loop througth the result set and save this in the arraylist
			while(rs.next()){
				arl.add(new Product(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			}
			
			return arl;
		} catch (SQLException e){
			System.err.println(e.getMessage());
			return null;
		}


	}
	
	
	/**
	 * This function return all duples to product table with the 
	 * conincidence with search String
	 * @param str is the string to search
	 * @return the arraylist consult
	 */
	public static ArrayList<Product> selectName(String str){
		
		//query
		String sqlQ = "SELECT * FROM " + tableName + " WHERE name_p LIKE '%"+str+"%'";
		//create array list
		ArrayList<Product> arl = new ArrayList<Product>();

		
		try{
			//getconnection 
			conn = JPAutil.getConnection();
			//result set to consult
			ResultSet rs = conn.prepareStatement(sqlQ).executeQuery();
			//loop througth the result set and save this in the arraylist
			while(rs.next()){
				arl.add(new Product(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			}

			return arl;
		} catch (SQLException e){
			System.err.println(e.getMessage());
			return null;
		}
	}

	/**
	 * rhis functiopn update the spesific duple by the 
	 * gived product 
	 * @param product
	 */
	public static void update(Product product) {
		//empty connection
		conn = null;
		try {
			//get connection
			conn = JPAutil.getConnection();
			//statment to process
			PreparedStatement pst = conn.prepareStatement(
					"UPDATE " + tableName + " SET name_p = ?, measure = ?, code_sg = ? " +" WHERE code_p = ?");
			
			//set values
			pst.setString(1, product.getName_p());
			pst.setString(2, product.getMeasure());
			pst.setString(3, product.getCode_sg());
			pst.setString(4, product.getCode_p());
			
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
			PreparedStatement pst = conn.prepareStatement("DELETE FROM "+ tableName+ " WHERE code_p = ?");//prepare querry

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
	 * This function create a nwe duple and this storage the givened product
	 * @param product
	 */
	public static void create(Product product) {
		//empty connection
		conn = null;

		try {
			//get connection
			conn = JPAutil.getConnection(); 

			//statement process
			PreparedStatement pst = conn.prepareStatement("INSERT INTO " + tableName + " (code_p, name_p, measure, code_sg) VALUES (?,?,?,?)");

			//sest values
			pst.setString(1, product.getCode_p());//insert code
			pst.setString(2, product.getName_p());//insert name
			pst.setString(3, product.getMeasure());//insert name
			pst.setString(4, product.getCode_sg());//insert name

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
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE code_p = ?" );
			//set value
			pst.setString(1, code);
			//execute querry
			ResultSet rs = pst.executeQuery();
			//return the existence
			return rs.next();
		} catch (Exception e) {
			System.out.println("Problems to connect or querry Product");
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
	
	public static void printArrL(ArrayList<Product> argpp) {
		if (argpp != null)
			for (int i = 0; i < argpp.size(); i++) {
				System.out.println("---------------------------------------------");
				System.out.println(argpp.get(i).toString());
			}
	}
	
	
//	public static void main(String[] args) {
		//create
//		create(new Product("1", "pr1","kilos","1")); 
//		create(new Product("2", "pr2","Productos",null));
//		create(new Product("3", "gr3", "gr ","2"));
		//update 
//		update(new Product("2","p update", "gramos","1"));
		//delete
//		delete("3");
		//exist
//		System.out.println(exist("1"));
//		System.out.println(exist("3"));
//		printArrL(selectAll());
//		printArrL(selectName("up"));
//	}

}

package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import objects.Product;

public class JPAProduct {
	
	private static String tableName="product";
	private static Connection conn =null;
	
	
	 //Select

	  public static ArrayList<Product>  selectP(){
	    String sqlQ = "SELECT * FROM " + tableName;//SQL TO SEARCH ALLS
	    
	    ArrayList<Product> products = new ArrayList<Product>();

	    try{
	      conn = JPASQLITEUtil.getConnection();
	      ResultSet rs = conn.prepareStatement(sqlQ).executeQuery();

	      while(rs.next()){
	    	  products.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),
	    			  Double.parseDouble(rs.getString(5)), Double.parseDouble(rs.getString(6))));
	      }

	      return products;
	    } catch (SQLException e){
	      System.err.println(e.getMessage());
	      return null;
	    }


	  }
	  

	  //update

	  public static void updateP(Product product) {
			conn = null;
			try {
				conn = JPASQLITEUtil.getConnection();//get connection
				PreparedStatement pst = conn.prepareStatement(
	        "UPDATE " + tableName + " SET (nameP = ?,  measure = ?, initial = ?, stock = ?) " +" WHERE codep = ? AND codesg = ?"); //prepare querry
				//set values
				pst.setString(1, product.getNameP());
				pst.setString(2, product.getMeasure());
				pst.setString(3, String.valueOf(product.getInitial()));
				pst.setString(4, String.valueOf(product.getStock()));
				pst.setString(5, product.getCodeP());
				pst.setString(6, product.getCodeSG());
				//execute query
				pst.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//close connection
				
				JPASQLITEUtil.closeConn();

			}
		}
	  
	//Delete

	  public static void deleteP(String codeP, String codeSG) {
			conn  = null;
			try {
				conn  = JPASQLITEUtil.getConnection();//get connection
				PreparedStatement pst = conn.prepareStatement("DELETE FROM "+ tableName+ " WHERE codeP = ? AND codeSG = ?");//prepare querry

				pst.setString(1, codeP);//insert the value to query
				pst.setString(2, codeSG);//insert the value to query
				pst.executeUpdate();//execute query
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				//closed connection
				JPASQLITEUtil.closeConn();
			}

		}
	  
	  

	  //Insert
	  
	  public static void createP(Product product) {
			conn = null;//empty connection
			
			try {
				conn = JPASQLITEUtil.getConnection();//get connection 
				
				//prepare the sql statament
				PreparedStatement pst = conn.prepareStatement("INSERT INTO " + tableName + " (codep, namep, measure, initial, stock, sodesg) VALUES (?,?,?,?,?,?)");
				
				//insertion to values to class
				pst.setString(1, product.getCodeP());//insert code
				pst.setString(2, product.getNameP());//insert name 
				pst.setString(3, product.getMeasure());//insert measure
				pst.setString(4, String.valueOf(product.getInitial()));//insert initial stock
				pst.setString(5, String.valueOf(product.getStock()));//insert actual stock
				pst.setString(6, product.getCodeSG());//insert subgroup code 
				
				//execute change in DBS
				pst.executeUpdate();
				
				
			}catch (java.sql.SQLIntegrityConstraintViolationException  e) {
				System.out.println("primary key violation");
				e.printStackTrace();
			}catch (Exception e) {
				System.out.println("ERROR TO TRY INSERT PRODUCT");
				e.printStackTrace();
			} finally {
				//try closed connection
				JPASQLITEUtil.closeConn();
			}
		}
	  
	  

	  //Exist
	  public static boolean existP(String codeP, String codeSG) {
			conn = null;
			ResultSet rs = null;
			try {
				conn = JPASQLITEUtil.getConnection();//get connection to dbs
				//set to query
				PreparedStatement pst = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE codep = ? AND codesg = ?" );
				//inside the code to search
				pst.setString(1, codeP);
				pst.setString(2, codeSG);
				//execute querry
				rs = pst.executeQuery();

	      return rs.next();
			} catch (Exception e) {
				System.out.println("Problems to connect or querry Product");
				return false;
			}finally {
				//closed connection
				JPASQLITEUtil.closeConn();
			}
			
		
		}
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	
	
	
}

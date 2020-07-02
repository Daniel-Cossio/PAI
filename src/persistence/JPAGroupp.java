package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import objects.Groupp;


public class JPAGroupp extends Groupp{
	
	private static String tableName = "groupp";
	private static Connection conn =null;
	  
	//Select
	
	public static ArrayList<Groupp>  selectG(){
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
	
	//Update
	
	public static void updateG(Groupp groupp) {
		conn = null;
		try {
			conn = JPASQLITEUtil.getConnection();//get connection
			PreparedStatement pst = conn.prepareStatement(
					"UPDATE " + tableName + " SET nameg = ? " +" WHERE codeg = ?"); //prepare querry
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
	
	
	 //Delete

	  public static void deleteG(String codeG) {
			conn  = null;
			try {
				conn  = JPASQLITEUtil.getConnection();//get connection
				PreparedStatement pst = conn.prepareStatement("DELETE FROM "+ tableName+ " WHERE codeg = ?");//prepare querry
				
				pst.setString(1, codeG);//insert the value to querry
				pst.executeUpdate();//execute querry
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				//closed conection
				JPASQLITEUtil.closeConn();
			}

		}
	
	
	  
	//Insert
	  public static void createG(Groupp groupp) {
			conn = null;//empty connection
			
			try {
				conn = JPASQLITEUtil.getConnection();//get connection 
				
				//prepare the sql statament
				PreparedStatement pst = conn.prepareStatement("INSERT INTO " + tableName + " (codeg, nameg) VALUES (?,?)");
				
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
	  
	  
	// exist
	  public static boolean existG(String codeG) {
			conn = null;
			ResultSet rs = null;
			try {
				conn = JPASQLITEUtil.getConnection();//get connection to dbs
				//set to query
				PreparedStatement pst = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE codeg = ?" );
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
	  
	  
	  
	  
	
	
	
	
	// Previous paradigm:
	

	/**
	 * this function return all the serch
	 * @return
	 */
	/*public static ArrayList<Groupp> selectAll() {
		return selectExecute(toSelectAllQuery());
	}*/
	
	/**
	 * This function return the arraylist width resulto to 
	 * query with 'like'
	 * @return
	 */
	/*public static ArrayList<Groupp> selectLike(String srch) {
		return selectExecute(toSelectLikeQuery(toSelectLikeQuery(srch)));
	}*/
	
	/**
	 * execute the same select
	 * @param query
	 * @return
	 */
	/*private static ArrayList<Groupp> selectExecute(String query){
		ArrayList<Groupp> groups = new ArrayList<Groupp>();
		ResultSet rs = JPASQLITEUtil.generalExecuteQuerry(query);
		try {
			while (rs.next()) {
				groups.add(new Groupp(rs.getString(1), rs.getString(2)));
			}
			return groups;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}*/
	
	/*public static boolean exist(Groupp groupp) {
		ResultSet rs = JPASQLITEUtil.generalExecuteQuerry(groupp.toExistQuery());
		try {
			return rs.next();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
//			e.printStackTrace();
			return false;
		}
	}*/
	
	
	
	
	/**
	 * TEMPORAL
	 * 
	 */
	
	/*public static void printConsole() {
		ArrayList<Groupp> deps = selectAll();
//		ArrayList<Groupp> deps = selectLike("d");
		for (int i = 0; i < deps.size(); i++) {
			System.out.println(deps.get(i).toStringF());
		}
	}*/
	
//	public static void main(String[] args) {
//		INSERT
//		JPASQLITEUtil.generalExecuteUpdate(new Groupp("00", "group1").toInsertQuery());
//		JPASQLITEUtil.generalExecuteUpdate(new Groupp("01", "group2").toInsertQuery());
//		JPASQLITEUtil.generalExecuteUpdate(new Groupp("02", "group3").toInsertQuery());
//		UPDATE
//		JPASQLITEUtil.generalExecuteUpdate(new Groupp("00", "Updategroup").toUpdateQuery());
//		DELETE
//		System.out.println(new Groupp("01","").toDeleteQuery());
//		JPASQLITEUtil.generalExecuteUpdate(new Groupp("01","").toDeleteQuery());
//		EXIST
//		System.out.println(exist(new Groupp("0", "")));
//		
//		
//		printConsole();
//	}
//	


}

package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import objects.Subgroup;

public class JPASubgroup extends Subgroup{

	private static String tableName="subgroup";
	private static Connection conn =null;
	
	
	
	 //Select

	  public static ArrayList<Subgroup>  selectSG(){
	    String sqlQ = "SELECT * FROM " + tableName;//SQL TO SEARCH ALLS
	    
	    ArrayList<Subgroup> subgroups = new ArrayList<Subgroup>();

	    try{
	      conn = JPASQLITEUtil.getConnection();
	      ResultSet rs = conn.prepareStatement(sqlQ).executeQuery();

	      while(rs.next()){
	    	  subgroups.add(new Subgroup(rs.getString(1),rs.getString(2),rs.getString(3)));
	      }

	      return subgroups;
	    } catch (SQLException e){
	      System.err.println(e.getMessage());
	      return null;
	    }
	  }
	
	
	//Update
	  /*				
	 							DUDA
	 							
	 A un subgrupo se le puede modificar el grupo al que pertenece?
	 							
	 							
		*/
	  
	  public static void updateSG(Subgroup subgroup) {
			conn = null;
			try {
				conn = JPASQLITEUtil.getConnection();//get connection
				PreparedStatement pst = conn.prepareStatement(
	        "UPDATE " + tableName + " SET namesg = ? " +" WHERE codesg = ? AND codeg = ?"); //prepare querry
				//set values
				pst.setString(1, subgroup.getNameSG());
				pst.setString(2, subgroup.getCodeSG());
				pst.setString(3, subgroup.getCodeG());
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

	  public static void deleteSG(String codesg, String codeg) {
			conn  = null;
			try {
				conn  = JPASQLITEUtil.getConnection();//get connection
				PreparedStatement pst = conn.prepareStatement("DELETE FROM "+ tableName+ " WHERE codesg = ? AND codeg = ?");//prepare query
				
				pst.setString(1, codesg);//insert the value to query	
				pst.setString(2, codeg);//insert the value to query
				pst.executeUpdate();//execute query
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				//closed connection
				JPASQLITEUtil.closeConn();
			}

		}
	  
	  

	  //Insert
	  public static void createSG(Subgroup subgroup) {
			conn = null;//empty connection
			
			try {
				conn = JPASQLITEUtil.getConnection();//get connection 
				
				//prepare the sql statament
				PreparedStatement pst = conn.prepareStatement("INSERT INTO " + tableName + " (codesg, namesg, codeg) VALUES (?,?,?)");
				
				//insertion to values to class
				pst.setString(1, subgroup.getCodeSG());//insert code
				pst.setString(2, subgroup.getNameSG());//insert name 
				pst.setString(3, subgroup.getCodeG());//insert group code 
				
				//execute change in DBS
				pst.executeUpdate();
				
				
			}catch (java.sql.SQLIntegrityConstraintViolationException  e) {
				System.out.println("primary key violation");
				e.printStackTrace();
			}catch (Exception e) {
				System.out.println("ERROR TO TRY INSERT SUBGROUP");
				e.printStackTrace();
			} finally {
				//try closed connection
				JPASQLITEUtil.closeConn();
			}
		}
	  
	  //Exist
	  public static boolean existSG(String codeSG, String codeG) {
			conn = null;
			ResultSet rs = null;
			try {
				conn = JPASQLITEUtil.getConnection();//get connection to dbs
				//set to query
				PreparedStatement pst = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE codesg = ? AND codeg = ?" );
				//inside the code to search
				pst.setString(1, codeSG);
				pst.setString(2, codeG);
				//execute querry
				rs = pst.executeQuery();

	      return rs.next();
			} catch (Exception e) {
				System.out.println("Problems to connect or querry Subgroup");
				return false;
			}finally {
				//closed conection
				JPASQLITEUtil.closeConn();
			}
			
		
		}
	  
	  
	  
	  
	  
	  
	  
	  
	  
	//Previous paradigm: 
	
	/**
	 * this function return all the serch
	 * @return
	 */
	/*public static ArrayList<Subgroup> selectAll() {
		return selectExecute(toSelectAllQuery());
	}
	
	/**
	 * This function return the arraylist width resulto to 
	 * query with 'like'
	 * @return
	 */
	
	/*public static ArrayList<Subgroup> selectLike(String srch) {
		return selectExecute(toSelectLikeQuery(toSelectLikeQuery(srch)));
	}*/
	
	/**
	 * execute the same select
	 * @param query
	 * @return
	 */ 
	
	/*private static ArrayList<Subgroup> selectExecute(String query){
		ArrayList<Subgroup> subgrps = new ArrayList<Subgroup>();
		ResultSet rs = JPASQLITEUtil.generalExecuteQuerry(query);
		try {
			while (rs.next()) {
				subgrps.add(new Subgroup(rs.getString(1), rs.getString(2),rs.getString(3)));
			}
			return subgrps;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}*/
	 
	/*public static boolean exist(Subgroup dep) {
		ResultSet rs = JPASQLITEUtil.generalExecuteQuerry(dep.toExistQuery());
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
		ArrayList<Subgroup> deps = selectAll();
//		ArrayList<Subgroup> deps = selectLike("d");
		for (int i = 0; i < deps.size(); i++) {
			System.out.println(deps.get(i).toStringF());
		}
	}*/
	
//	public static void main(String[] args) {
//		INSERT
//		JPASQLITEUtil.generalExecuteUpdate(new Subgroup("1215", "newDep").toInsertQuery());
//		UPDATE
//		System.out.println(new Subgroup("1214", "Updatesubg", "00").toUpdateQuery());
//		JPASQLITEUtil.generalExecuteUpdate(new Subgroup("1214", "Updatesubg", "00").toUpdateQuery());
//		DELETE
//		System.out.println(new Subgroup("1234","").toDeleteQuery());
//		JPASQLITEUtil.generalExecuteUpdate(new Subgroup("1214","").toDeleteQuery());
//		EXIST
//		System.out.println(exist(new Subgroup("31d", "")));
//		
//		
//		printConsole();
//	}
	
}

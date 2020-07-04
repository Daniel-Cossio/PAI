package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import objects.Department;

public class JPADepartment {

  private static String tableName="department";
  private static Connection conn =null;
  
  
  //select 

  public static ArrayList<Department>  selectD(){
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

  //update

  public static void updateD(Department dept) {
		conn = null;
		try {
			conn = JPASQLITEUtil.getConnection();//get connection
			PreparedStatement pst = conn.prepareStatement(
        "UPDATE " + tableName + " SET named = ? " +" WHERE coded = ?"); //prepare querry
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
  //delete

  public static void deleteD(String codeD) {
		conn  = null;
		try {
			conn  = JPASQLITEUtil.getConnection();//get connection
			PreparedStatement pst = conn.prepareStatement("DELETE FROM "+ tableName+ " WHERE coded = ?");//prepare querry
			
			pst.setString(1, codeD);//insert the value to querry
			pst.executeUpdate();//execute querry
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//closed conection
			JPASQLITEUtil.closeConn();
		}

	}

  //insert
  public static void createD(Department dept) {
		conn = null;//empty connection
		
		try {
			conn = JPASQLITEUtil.getConnection();//get connection 
			
			//prepare the sql statament
			PreparedStatement pst = conn.prepareStatement("INSERT INTO " + tableName + " (coded, named) VALUES (?,?)");
			
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
  
  //Exist
  public static boolean existD(String codeD) {
		conn = null;
		ResultSet rs = null;
		try {
			conn = JPASQLITEUtil.getConnection();//get connection to dbs
			//set to query
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE coded = ?" );
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
  
  public static void main(String[] args) {
	  System.out.println("asd");
  }

}
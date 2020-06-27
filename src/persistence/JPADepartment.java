package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import objects.Department;

public class JPADepartment extends Department{
	
	
	/**
	 * this function return all the serch
	 * @return
	 */
	public static ArrayList<Department> selectAll() {
		return selectExecute(toSelectAllQuery());
	}
	
	/**
	 * This function return the arraylist width resulto to 
	 * query with 'like'
	 * @return
	 */
	public static ArrayList<Department> selectLike(String srch) {
		return selectExecute(toSelectLikeQuery(toSelectLikeQuery(srch)));
	}
	
	/**
	 * execute the same select
	 * @param query
	 * @return
	 */
	private static ArrayList<Department> selectExecute(String query){
		ArrayList<Department> deps = new ArrayList<Department>();
		ResultSet rs = JPASQLITEUtil.generalExecuteQuerry(query);
		try {
			while (rs.next()) {
				deps.add(new Department(rs.getString(1), rs.getString(2)));
			}
			return deps;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	public static boolean exist(Department dep) {
		ResultSet rs = JPASQLITEUtil.generalExecuteQuerry(dep.toExistQuery());
		try {
			return rs.next();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
//			e.printStackTrace();
			return false;
		}
	}
	
	
	
	
	/**
	 * TEMPORAL
	 * 
	 */
	
	public static void printConsole() {
		ArrayList<Department> deps = selectAll();
//		ArrayList<Department> deps = selectLike("d");
		for (int i = 0; i < deps.size(); i++) {
			System.out.println(deps.get(i).toStringF());
		}
	}
	
//	public static void main(String[] args) {
//		INSERT
//		JPASQLITEUtil.generalExecuteUpdate(new Department("1214", "newDep").toInsertQuery());
//		UPDATE
//		JPASQLITEUtil.generalExecuteUpdate(new Department("1214", "UpdateDep").toUpdateQuery());
//		DELETE
//		System.out.println(new Department("1234","").toDeleteQuery());
//		JPASQLITEUtil.generalExecuteUpdate(new sDepartment("1212","").toDeleteQuery());
//		EXIST
//		System.out.println(exist(new Department("1210", "")));
//		
//		
//		printConsole();
//	}
	

}

package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import objects.Subgroup;

public class JPASubgroup extends Subgroup{

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

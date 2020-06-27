package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import objects.Groupp;


public class JPAGroupp extends Groupp{
	

	/**
	 * this function return all the serch
	 * @return
	 */
	public static ArrayList<Groupp> selectAll() {
		return selectExecute(toSelectAllQuery());
	}
	
	/**
	 * This function return the arraylist width resulto to 
	 * query with 'like'
	 * @return
	 */
	public static ArrayList<Groupp> selectLike(String srch) {
		return selectExecute(toSelectLikeQuery(toSelectLikeQuery(srch)));
	}
	
	/**
	 * execute the same select
	 * @param query
	 * @return
	 */
	private static ArrayList<Groupp> selectExecute(String query){
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
	}
	
	public static boolean exist(Groupp groupp) {
		ResultSet rs = JPASQLITEUtil.generalExecuteQuerry(groupp.toExistQuery());
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
		ArrayList<Groupp> deps = selectAll();
//		ArrayList<Groupp> deps = selectLike("d");
		for (int i = 0; i < deps.size(); i++) {
			System.out.println(deps.get(i).toStringF());
		}
	}
	
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

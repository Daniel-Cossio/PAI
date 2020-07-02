package objects;

public class Groupp {
	 
	private String codeG, nameG;
	private static String tableName="groupp";
	/**
	 * Constructor
	 * 
	 */
	public Groupp() {
	}
	
	public Groupp(String codeG,String nameG) {
		this.codeG = codeG;
		this.nameG = nameG;
	}
	
	 /**
	   * 
	   * Getters and setters
	   */

	public String getCodeG() {
		return codeG;
	}

	public void setCodeG(String codeG) {
		this.codeG = codeG;
	}

	public String getNameG() {
		return nameG;
	}

	public void setNameG(String nameG) {
		this.nameG = nameG;
	}
	
	
//	_________SQL
	
	/**
	 * This function return to represent struct To string
	 * @return
	 */
	public String toStringF() {
		return "|" + String.format("%-10s",  codeG) + "|" + String.format("%-10s",  nameG) + "|";
	}
	
	/**
	 * Insert
	 * this return the insert query
	 * @return
	 */
	public String toInsertQuery() {
		return "INSERT INTO "+tableName+" (codeG,nameG) VALUES ('"+codeG+"','"+nameG+"')";
	}
	
	/**
	 * Delete
	 */
	public String toDeleteQuery() {
		return "DELETE FROM "+tableName+" WHERE codeG = '" + codeG+"'";
	}
	
	/**
	 * Exist
	 */
	public String toExistQuery() {
		return "SELECT * FROM "+tableName+" WHERE codeG = '" +codeG+ "'";
	}
	
	/**
	 * Update 
	 */
	public String toUpdateQuery() {
		return "UPDATE "+tableName+" SET nameG = '"+nameG+"'"
                + "WHERE codeG = '" + codeG + "'";
	}
	
	/**
	 * Select
	 */
	public static String toSelectAllQuery() {
		return  "SELECT * FROM "+tableName+" ";
	}
	/**
	 * this use like  
	 * @param srch
	 * @return
	 */
	public static String toSelectLikeQuery(String srch) {
		return  "SELECT * FROM "+tableName+" WHERE nameG like '%"+srch+ "%'";
	}
	


}

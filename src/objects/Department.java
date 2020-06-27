package objects;

public class Department {
	
	
	private String codeD, nameD;
	private static String tableName="department";
	
	
	/**
	 * constructors
	 * 
	 */
	
	public Department() {
		
	}
	public Department(String codeD, String nameD) {
		this.codeD = codeD;
		this.nameD = nameD;
	}
	
	/**
	 * 
	 * Getters and setters
	 */
	public String getCodeD() {
		return codeD;
	}
	public void setCodeD(String codeD) {
		this.codeD = codeD;
	}
	public String getNameD() {
		return nameD;
	}
	public void setNameD(String nameD) {
		this.nameD = nameD;
	}

//	_________SQL
	
	/**
	 * This function return to represent struct To string
	 * @return
	 */
	public String toStringF() {
		return "|" + String.format("%-10s",  codeD) + "|" + String.format("%-10s",  nameD) + "|";
	}
	
	/**
	 * Insert
	 * this return the insert query
	 * @return
	 */
	public String toInsertQuery() {
		return "INSERT INTO "+tableName+" (codeD,nameD) VALUES ('"+codeD+"','"+nameD+"')";
	}
	
	/**
	 * Delete
	 */
	public String toDeleteQuery() {
		return "DELETE FROM "+tableName+" WHERE codeD = '" + codeD+"'";
	}
	
	/**
	 * Exist
	 */
	public String toExistQuery() {
		return "SELECT * FROM "+tableName+" WHERE codeD = '" +codeD+ "'";
	}
	
	/**
	 * Update 
	 */
	public String toUpdateQuery() {
		return "UPDATE "+tableName+" SET nameD = '"+nameD+"'"
                + "WHERE codeD = '" + codeD + "'";
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
		return  "SELECT * FROM "+tableName+" WHERE nameD like '%"+srch+ "%'";
	}
	
}

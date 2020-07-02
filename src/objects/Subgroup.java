package objects;

public class Subgroup {
	
	
	private String codeSG, nameSG,codeG; 
	private static String tableName="subgroup"; 
	//constructor
	public Subgroup() {
	}
	
	//getters and setters

	public Subgroup(String codeSG, String nameSG) {
		super();
		this.codeSG = codeSG;
		this.nameSG = nameSG;
		codeG =null;
	}
	
	public Subgroup(String codeSG, String nameSG, String codeG) {
		super();
		this.codeSG = codeSG;
		this.nameSG = nameSG;
		this.codeG = codeG;
		
	}

	public String getCodeSG() {
		return codeSG;
	}

	public void setCodeSG(String codeSG) {
		this.codeSG = codeSG;
	}

	public String getNameSG() {
		return nameSG;
	}

	public void setNameSG(String nameSG) {
		this.nameSG = nameSG;
	}
	
	public String getCodeG() {
		return codeG;
	}

	public void setCodeG(String codeG) {
		this.codeG = codeG;
	}
	
//	_________SQL
	
	/**
	 * This function return to represent struct To string
	 * @return
	 */
	public String toStringF() {
		return "|" + String.format("%-10s",  codeSG) + "|" + String.format("%-10s",  nameSG) + "| FK "+ String.format("%-10s",  codeG) + "|";
	}
	
	/**
	 * Insert
	 * this return the insert query
	 * @return
	 */
	public String toInsertQuery() {
		return "INSERT INTO "+tableName+" (codeSG,nameSG,codeG) VALUES ('"+codeSG+"','"+nameSG+"','" + codeG+"')";
	}
	
	/**
	 * Delete
	 */
	public String toDeleteQuery() {
		return "DELETE FROM "+tableName+" WHERE codeSG= '" + codeSG+"'";
	}
	
	/**
	 * Exist
	 */
	public String toExistQuery() {
		return "SELECT * FROM "+tableName+" WHERE codeSG = '" +codeSG+ "'";
	}
	
	/**
	 * Update 
	 */
	public String toUpdateQuery() {
		return "UPDATE "+tableName+" SET nameSG = '"+nameSG+"'," +"codeG = '" + codeG+"' " 
                + " WHERE codeSG = '" + codeSG + "'";
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
		return  "SELECT * FROM "+tableName+" WHERE nameSG like '%"+srch+ "%'";
	}

	
	public static void main(String[] args) {
		System.out.println(new Subgroup("333dddddd3","asaaaaaa", "asdasdasddddddddddddd").toStringF());
	}
	
	
	
}

package objects;

public class Subgroup {
	
	
	private String codeSG, nameSG,codeG; 
	private static String tableName="subgroup"; 
	//constructor
	public Subgroup() {
	}
	
	

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
	
	//getters and setters

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
	
	
	/**
	 * This function return to represent struct To string
	 * @return
	 */
	public String toStringF() {
		return "|" + String.format("%-10s",  codeSG) + "|" + String.format("%-10s",  nameSG) + "| FK "+ String.format("%-10s",  codeG) + "|";
	}	
}

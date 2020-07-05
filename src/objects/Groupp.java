package objects;

public class Groupp {
	 
	private String codeG, nameG;
	/**
	 * Constructors
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
	
	/**
	 * This function return to represent struct To string
	 * @return
	 */
	public String toStringF() {
		return "|" + String.format("%-10s",  codeG) + "|" + String.format("%-10s",  nameG) + "|";
	}
	
}

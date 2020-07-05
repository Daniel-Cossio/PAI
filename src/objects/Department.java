package objects;


public class Department {
	
	
	private String codeD, nameD;
	
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
	
	/**
	 * This function return to represent struct To string
	 * @return
	 */
	public String toStringF() {
		return "|" + String.format("%-10s",  codeD) + "|" + String.format("%-10s",  nameD) + "|";
	}
	
}

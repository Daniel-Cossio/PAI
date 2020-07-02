package objects;

public class UserIM {
	
	
	private String codeU, nameU, passwordU;
	//constructor
	public UserIM() {
		
	}
	public UserIM(String codeU, String nameU, String passwordU) {
		super();
		this.codeU = codeU;
		this.nameU = nameU;
		this.passwordU = passwordU;
	}
	
	//getters and setters
	public String getCodeU() {
		return codeU;
	}
	public void setCodeU(String codeU) {
		this.codeU = codeU;
	}
	public String getNameU() {
		return nameU;
	}
	public void setNameU(String nameU) {
		this.nameU = nameU;
	}
	public String getPasswordU() {
		return passwordU;
	}
	public void setPasswordU(String passwordU) {
		this.passwordU = passwordU;
	}
	

}

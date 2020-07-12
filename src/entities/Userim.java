package entities;

public class Userim {
	//attribs 
	
	private String code_u, name_u, password_u;

	//constructor
	public Userim(String code_u, String name_u, String password_u) {
		super();
		this.code_u = code_u;
		this.name_u = name_u;
		this.password_u = password_u;
	}
	
	//getters and setters
	public String getCode_u() {
		return code_u;
	}

	public void setCode_u(String code_u) {
		this.code_u = code_u;
	}

	public String getName_u() {
		return name_u;
	}

	public void setName_u(String name_u) {
		this.name_u = name_u;
	}

	public String getPassword_u() {
		return password_u;
	}

	public void setPassword_u(String password_u) {
		this.password_u = password_u;
	}

	@Override
	public String toString() {
		return "Userim [code_u=" + code_u + ", name_u=" + name_u + ", password_u=" + password_u + "]";
	}
	 
	
}

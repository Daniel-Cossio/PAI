package entities;

public class Department {
	
	//attribs
	private String code_d, name_d;

	
	//constructor
	public Department(String code_d, String name_d) {
		super();
		this.code_d = code_d;
		this.name_d = name_d;
	}

	//getters and setters
	public String getCode_d() {
		return code_d;
	}

	public void setCode_d(String code_d) {
		this.code_d = code_d;
	}

	public String getName_d() {
		return name_d;
	}

	public void setName_d(String name_d) {
		this.name_d = name_d;
	}

	@Override
	public String toString() {
		return "Department [code_d=" + code_d + ", name_d=" + name_d + "]";
	}
	
		

}

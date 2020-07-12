package entities;

public class Groupp {
	
	//attribs
	private String code_g, name_g;
	
	// constructor
	public Groupp(String code_g, String name_g) {
		super();
		this.code_g = code_g;
		this.name_g = name_g;
	}
	
	//getters and setters

	public String getCode_g() {
		return code_g;
	}

	public void setCode_g(String code_g) {
		this.code_g = code_g;
	}

	public String getName_g() {
		return name_g;
	}

	public void setName_g(String name_g) {
		this.name_g = name_g;
	}

	@Override
	public String toString() {
		return "Groupp [code_g=" + code_g + ", name_g=" + name_g + "]";
	}
	
}

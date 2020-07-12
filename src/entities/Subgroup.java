package entities;

public class Subgroup {
	//attribs
	private String code_sg, name_sg, code_g;

	//constructor
	public Subgroup(String code_sg, String name_sg, String code_g) {
		super();
		this.code_sg = code_sg;
		this.name_sg = name_sg;
		this.code_g = code_g;
	}

	//getters and setters
	public String getCode_sg() {
		return code_sg;
	}

	public void setCode_sg(String code_sg) {
		this.code_sg = code_sg;
	}

	public String getName_sg() {
		return name_sg;
	}

	public void setName_sg(String name_sg) {
		this.name_sg = name_sg;
	}

	public String getCode_g() {
		return code_g;
	}

	public void setCode_g(String code_g) {
		this.code_g = code_g;
	}

	@Override
	public String toString() {
		return "Subgroup [code_sg=" + code_sg + ", name_sg=" + name_sg + ", code_g=" + code_g + "]";
	} 
	
}

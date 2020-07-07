package entities;

public class Product {
	
	//attribs
	private String code_p, name_p, measure, code_sg;
	
	//constructors
	public Product(String code_p, String name_p, String measure, String code_sg) {
		super();
		this.code_p = code_p;
		this.name_p = name_p;
		this.measure = measure;
		this.code_sg = code_sg;
	}
	
	//getters and setters
	public String getCode_p() {
		return code_p;
	}

	public void setCode_p(String code_p) {
		this.code_p = code_p;
	}

	public String getName_p() {
		return name_p;
	}

	public void setName_p(String name_p) {
		this.name_p = name_p;
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	public String getCode_sg() {
		return code_sg;
	}

	public void setCode_sg(String code_sg) {
		this.code_sg = code_sg;
	}

	@Override
	public String toString() {
		return "Product [code_p=" + code_p + ", name_p=" + name_p + ", measure=" + measure + ", code_sg=" + code_sg
				+ "]";
	}
		

}

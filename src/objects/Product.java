package objects;

public class Product {
	
	
	// codeSG = subgoup code
	private String codeP, nameP, measure, codeSG;
	private double initial, stock;
	
	/**
	 * constructor 
	 */
	public Product() {
	}

	public Product(String codeP, String nameP, String measure, String codeSG, double initial, double stock) {
		super();
		this.codeP = codeP;
		this.nameP = nameP;
		this.measure = measure;
		this.codeSG = codeSG;
		this.initial = initial;
		this.stock = stock;
	}
	
	//getters and setters

	public String getCodeP() {
		return codeP;
	}

	public void setCodeP(String codeP) {
		this.codeP = codeP;
	}

	public String getNameP() {
		return nameP;
	}

	public void setNameP(String nameP) {
		this.nameP = nameP;
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	public String getCodeSG() {
		return codeSG;
	}

	public void setCodeSG(String codeSG) {
		this.codeSG = codeSG;
	}

	public double getInitial() {
		return initial;
	}

	public void setInitial(double initial) {
		this.initial = initial;
	}

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}
	
	

}

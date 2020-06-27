package objects;

public class Product {
	
	
	//the codeSG = subgoup 
	private String codeP, nameP, mearure, codeSG;
	private double initialStock, stock;
	
	/**
	 * constructor 
	 */
	public Product() {
	}

	public Product(String codeP, String nameP, String mearure, String codeSG, double initialStock, double stock) {
		super();
		this.codeP = codeP;
		this.nameP = nameP;
		this.mearure = mearure;
		this.codeSG = codeSG;
		this.initialStock = initialStock;
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

	public String getMearure() {
		return mearure;
	}

	public void setMearure(String mearure) {
		this.mearure = mearure;
	}

	public String getCodeSG() {
		return codeSG;
	}

	public void setCodeSG(String codeSG) {
		this.codeSG = codeSG;
	}

	public double getInitialStock() {
		return initialStock;
	}

	public void setInitialStock(double initialStock) {
		this.initialStock = initialStock;
	}

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}
	
	
	
	

}

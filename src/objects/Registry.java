package objects;

import java.util.Date;

public class Registry {
	
	// the codeP = product
	private String codeR,codeP;
	private Date dateR; 
	private double quantityR, priceR;
	
	//constructor
	public Registry() {
	}

	public Registry(String codeR, String codeP, Date dateR, double quantityR, double priceR) {
		super();
		this.codeR = codeR;
		this.codeP = codeP;
		this.dateR = dateR;
		this.quantityR = quantityR;
		this.priceR = priceR;
	}
		
	// getters and setters 
	

	public String getCodeR() {
		return codeR;
	}

	public void setCodeR(String codeR) {
		this.codeR = codeR;
	}

	public String getCodeP() {
		return codeP;
	}

	public void setCodeP(String codeP) {
		this.codeP = codeP;
	}

	public Date getDateR() {
		return dateR;
	}

	public void setDateR(Date dateR) {
		this.dateR = dateR;
	}

	public double getQuantityR() {
		return quantityR;
	}

	public void setQuantityR(double quantityR) {
		this.quantityR = quantityR;
	}

	public double getPriceR() {
		return priceR;
	}

	public void setPriceR(double priceR) {
		this.priceR = priceR;
	}
	
	

}

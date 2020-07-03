package objects;

import java.util.Date;

public class Movement {
	
	/**
	 * the codeP = product code
	 * thr codeD = deprtment code
	 */
	private String codeM,codeFactura,typeM,codeD,codeP;
	private Date dateM;
	private double quantityM,totalPryce,unityPryce;
	
	/**
	 * construtors
	 */
	public Movement() {
	}

	public Movement(String codeM, String codeF, String typeM, String codeD, String codeP, Date dateM, double quantityM,
			double totalPryce, double unityPryce) {
		super();
		this.codeM = codeM;
		this.codeFactura = codeF;
		this.dateM = dateM;
		this.typeM = typeM;

		this.quantityM = quantityM;
		this.totalPryce = totalPryce;
		this.unityPryce = unityPryce;

		this.codeD = codeD;
		this.codeP = codeP;
		
		
	}

	
	/**
	 * getters and seetters
	 */
	
	public String getCodeM() {
		return codeM;
	}

	public void setCodeM(String codeM) {
		this.codeM = codeM;
	}

	public String getCodeF() {
		return codeFactura;
	}

	public void setCodeF(String nameM) {
		this.codeFactura = nameM;
	}

	public String getTypeM() {
		return typeM;
	}

	public void setTypeM(String typeM) {
		this.typeM = typeM;
	}

	public String getCodeD() {
		return codeD;
	}

	public void setCodeD(String codeD) {
		this.codeD = codeD;
	}

	public String getCodeP() {
		return codeP;
	}

	public void setCodeP(String codeP) {
		this.codeP = codeP;
	}

	public Date getDateM() {
		return dateM;
	}

	public void setDateM(Date dateM) {
		this.dateM = dateM;
	}

	public double getQuantityM() {
		return quantityM;
	}

	public void setQuantityM(double quantityM) {
		this.quantityM = quantityM;
	}

	public double getTotalPryce() {
		return totalPryce;
	}

	public void setTotalPryce(double totalPryce) {
		this.totalPryce = totalPryce;
	}

	public double getUnityPryce() {
		return unityPryce;
	}

	public void setUnityPryce(double unityPryce) {
		this.unityPryce = unityPryce;
	}
	
	
	
	
	
	
	
}

package entities;

import java.sql.Date;

public class Rmovement {
	//attrib 
	private int code_m;
	private Date date_m;
	private String code_invoice, type_m;
	private double quantity;
	private String code_p, code_u;
	
	//constructors
	public Rmovement( Date date_m, String code_invoice, String type_m, double quantity, String code_p,
			String code_u) {
		super();
		this.code_m = 0;
		initialice( date_m,  code_invoice,  type_m,  quantity,  code_p,
				 code_u);
	}
	
	public Rmovement(int code_m, Date date_m, String code_invoice, String type_m, double quantity, String code_p,
			String code_u) {
		this.code_m = code_m;
		initialice( date_m,  code_invoice,  type_m,  quantity,  code_p,
				 code_u);
	}
	
	private void initialice(Date date_m, String code_invoice, String type_m, double quantity, String code_p,
			String code_u) {
		this.date_m = date_m;
		this.code_invoice = code_invoice;
		this.type_m = type_m;
		this.quantity = quantity;
		this.code_p = code_p;
		this.code_u = code_u;
	}

	public int getCode_m() {
		return code_m;
	}

	public void setCode_m(int code_m) {
		this.code_m = code_m;
	}

	public Date getDate_m() {
		return date_m;
	}

	public void setDate_m(Date date_m) {
		this.date_m = date_m;
	}

	public String getCode_invoice() {
		return code_invoice;
	}

	public void setCode_invoice(String code_invoice) {
		this.code_invoice = code_invoice;
	}

	public String getType_m() {
		return type_m;
	}

	public void setType_m(String type_m) {
		this.type_m = type_m;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getCode_p() {
		return code_p;
	}

	public void setCode_p(String code_p) {
		this.code_p = code_p;
	}

	public String getCode_u() {
		return code_u;
	}

	public void setCode_u(String code_u) {
		this.code_u = code_u;
	}
	
	

	@Override
	public String toString() {
		return "Rmovement [code_m=" + code_m + ", date_m=" + date_m + ", code_invoice=" + code_invoice + ", type_m="
				+ type_m + ", quantity=" + String.format("%f", quantity )+ ", code_p=" + code_p + ", code_u=" + code_u + "]";
	}

	
	
	
	

}

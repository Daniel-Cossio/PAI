package entities;

import java.sql.Date;

public class Rclosemonth {
	//attribs
	private int code_cm;
	private Date date_cm;
	
	//constructors
	public Rclosemonth(int code_cm, Date date_cm) {
		super();
		this.code_cm = code_cm;
		this.date_cm = date_cm;
	}
	
	// getters and setters
	public int getCode_cm() {
		return code_cm;
	}

	public void setCode_cm(int code_cm) {
		this.code_cm = code_cm;
	}

	public Date getDate_cm() {
		return date_cm;
	}

	public void setDate_cm(Date date_cm) {
		this.date_cm = date_cm;
	}

	@Override
	public String toString() {
		return "Rclosemonth [code_cm=" + code_cm + ", date_cm=" + date_cm + "]";
	}

}

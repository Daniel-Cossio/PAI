package entities;

public class Rinitialstock {
	
	//attrib
	private int code_m, code_cm;
	private double measure;
	
	//constructor
	public Rinitialstock(int code_m, int code_cm, double measure) {
		super();
		this.code_m = code_m;
		this.code_cm = code_cm;
		this.measure = measure;
	}
	//getters and setterss
	public int getCode_m() {
		return code_m;
	}
	public void setCode_m(int code_m) {
		this.code_m = code_m;
	}
	public int getCode_cm() {
		return code_cm;
	}
	public void setCode_cm(int code_cm) {
		this.code_cm = code_cm;
	}
	public double getMeasure() {
		return measure;
	}
	public void setMeasure(double measure) {
		this.measure = measure;
	}
	@Override
	public String toString() {
		return "Rinitialstock [code_m=" + code_m + ", code_cm=" + code_cm + ", measure=" + measure + "]";
	}
	
	
	
}

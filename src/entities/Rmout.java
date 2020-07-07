package entities;

public class Rmout {
	//attribs
	
	private int code_m;
	private String code_d;
	
	//constructor
	public Rmout(int code_m, String code_d) {
		super();
		this.code_m = code_m;
		this.code_d = code_d;
	}
	//getters and setters
	public int getCode_m() {
		return code_m;
	}
	public void setCode_m(int code_m) {
		this.code_m = code_m;
	}
	public String getCode_d() {
		return code_d;
	}
	public void setCode_d(String code_d) {
		this.code_d = code_d;
	}
	
	
	@Override
	public String toString() {
		return "Rmout [code_m=" + code_m + ", code_d=" + code_d + "]";
	}
	
	
	
	

}

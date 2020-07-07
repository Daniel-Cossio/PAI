package entities;

public class Rmin {
	
	//attribs
	private int code_m;
	private double accont,total_pryce;
	
	//constructor
	public Rmin(int code_m, double accont, double total_pryce) {
		super();
		this.code_m = code_m;
		this.accont = accont;
		this.total_pryce = total_pryce;
	}

	public int getCode_m() {
		return code_m;
	}

	public void setCode_m(int code_m) {
		this.code_m = code_m;
	}

	public double getAccont() {
		return accont;
	}

	public void setAccont(double accont) {
		this.accont = accont;
	}

	public double getTotal_pryce() {
		return total_pryce;
	}

	public void setTotal_pryce(double total_pryce) {
		this.total_pryce = total_pryce;
	}

	@Override
	public String toString() {
		return "Rmin [code_m=" + code_m + ", accont=" + accont + ", total_pryce=" + total_pryce + "]";
	}
	

}

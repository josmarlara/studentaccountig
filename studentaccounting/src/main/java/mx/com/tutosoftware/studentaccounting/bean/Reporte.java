package mx.com.tutosoftware.studentaccounting.bean;

import java.io.Serializable;

public class Reporte implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String cuenta;
	private String concepto;
	private double cantidad;
	private double renglon1;
	private double renglon3;
	private double renglon4;
	
	public Reporte(String cuenta, String concepto, double cantidad, double renglon1, double renglon3) {
		super();
		this.cuenta = cuenta;
		this.concepto = concepto;
		this.cantidad = cantidad;
		this.renglon1 = renglon1;
		this.renglon3 = renglon3;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getRenglon1() {
		return renglon1;
	}

	public void setRenglon1(double renglon1) {
		this.renglon1 = renglon1;
	}

	public double getRenglon3() {
		return renglon3;
	}

	public void setRenglon3(double renglon3) {
		this.renglon3 = renglon3;
	}

	public double getRenglon4() {
		return renglon4;
	}

	public void setRenglon4(double renglon4) {
		this.renglon4 = renglon4;
	}
	

}

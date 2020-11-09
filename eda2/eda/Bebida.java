package eda;

public class Bebida extends Alimento {
	
	private String descripcion;
	private Double precio;
	
	public Bebida(String descripcion, Double precio) {
		super(descripcion, precio);
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Double getPrecio() {
		return precio;
	}
	
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
}

package eda;

public class Comida extends Alimento {
	private String descripcion;
	private Double precio;
	
	public Comida(String descripcion, Double precio) {
		super(descripcion);
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	protected void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	protected Double getPrecio() {
		return precio;
	}
	
	protected void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
}

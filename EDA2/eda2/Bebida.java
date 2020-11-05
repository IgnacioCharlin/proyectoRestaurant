package eda2;

public class Bebida extends Pedido {
	private String descripcion;
	private Double precio;
	public Bebida(String descripcion, Double precio) {
		super();
		this.descripcion = descripcion;
		this.precio = precio;
	}
	protected String getDescripcion() {
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

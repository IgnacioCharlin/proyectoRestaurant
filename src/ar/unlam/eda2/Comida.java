package ar.unlam.eda2;

public class Comida extends Pedido {
	private String descripcion;
	private Double precio;
	
	public Comida(String descripcion, Double precio, Integer numeroDePedido) {
		super(numeroDePedido);
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

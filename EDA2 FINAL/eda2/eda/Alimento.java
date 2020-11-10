package eda;

public abstract class Alimento{
	private String descripcion;
	private Double precio;

	public Alimento(String descripcion, Double precio) {
		super();
		this.descripcion = descripcion;
		this.precio = precio;
	}

	
	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getDescripcion() {
		return descripcion;
	}

	public void setNumeroDePedido(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alimento other = (Alimento) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		return true;
	}
	
}

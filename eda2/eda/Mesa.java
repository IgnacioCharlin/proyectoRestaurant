package eda;

public class Mesa {
	private Integer capacidad;
	private Integer numeroDeMesa;
	
	public Mesa(Integer capacidad, Integer numeroDeMesa) {
		super();
		this.capacidad = capacidad;
		this.numeroDeMesa = numeroDeMesa;
	}
	
	protected Integer getCapacidad() {
		return capacidad;
	}
	
	protected void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
	
	protected Integer getNumeroDeMesa() {
		return numeroDeMesa;
	}
	
	protected void setNumeroDeMesa(Integer numeroDeMesa) {
		this.numeroDeMesa = numeroDeMesa;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroDeMesa == null) ? 0 : numeroDeMesa.hashCode());
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
		Mesa other = (Mesa) obj;
		if (numeroDeMesa == null) {
			if (other.numeroDeMesa != null)
				return false;
		} else if (!numeroDeMesa.equals(other.numeroDeMesa))
			return false;
		return true;
	}
	
	
}
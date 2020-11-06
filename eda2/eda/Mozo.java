package eda;


public class Mozo extends Persona implements Comparable<Mozo>{
	private String nombre;
	private String apellido;
	private Long dni;
	private Integer legajo;
	
	public Mozo(String nombre, String apellido, Long dni, Integer legajo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.legajo = legajo;
	}
	
	protected Integer getLegajo() {
		return legajo;
	}
	
	protected void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((legajo == null) ? 0 : legajo.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mozo other = (Mozo) obj;
		if (legajo == null) {
			if (other.legajo != null)
				return false;
		} else if (!legajo.equals(other.legajo))
			return false;
		return true;
	}

	@Override
	public int compareTo(Mozo o) {
		
		return this.legajo.compareTo(o.legajo);
	}
	
	
}

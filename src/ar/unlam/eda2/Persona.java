package ar.unlam.eda2;

public abstract class Persona {
	private String nombre;
	private String apellido;
	private Long dni;
	
	public Persona() {
		super();
	}
	
	protected String getNombre() {
		return nombre;
	}
	
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	protected String getApellido() {
		return apellido;
	}
	
	protected void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	protected Long getDni() {
		return dni;
	}
	
	protected void setDni(Long dni) {
		this.dni = dni;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
		Persona other = (Persona) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}	
	
}
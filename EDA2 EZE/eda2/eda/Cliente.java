package eda;

public class Cliente extends Persona implements Comparable<Cliente> {
//	private String nombre;
//	private String apellido;
	private Long dni;
	
	public Cliente(String nombre, String apellido , Long dni) {
		super();
//		this.nombre = nombre;
//		this.apellido = apellido;
		this.dni = dni;
	}

	@Override
	public int compareTo(Cliente o) {
		return this.dni.compareTo(o.dni);
	}
	
}

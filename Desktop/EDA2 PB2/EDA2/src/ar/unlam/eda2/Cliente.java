package ar.unlam.eda2;

public class Cliente extends Persona {
	private String nombre;
	private String apellido;
	private Long dni;
	
	public Cliente(String nombre, String apellido , Long dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	
}

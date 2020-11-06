package ar.unlam.eda2;

import java.util.HashSet;
import java.util.TreeSet;

public class Restaurant {
	private TreeSet<Mozo> mozos;
	private HashSet<Mesa> mesas;
	private TreeSet<Cliente> clientes;
	private String nombreDelResto;
	
	public Restaurant(String nombreDelResto) {
		this.nombreDelResto = nombreDelResto;
		mozos = new TreeSet<Mozo>();
		mesas = new HashSet<Mesa>();
		clientes = new TreeSet<Cliente>();
	}
	
	public Boolean agregarMozo(Persona nuevo) {
		//for (Mozo mozo : mozos) {
		//	return mozos.add(nuevo);
		//}
		//return false;
		return this.mozos.add(nuevo);
	}
	
	public Boolean agregarCliente(Persona nuevo) {
		//for (Mozo mozo : mozos) {
		//	return mozos.add(nuevo);
		//}
		//return false;
		return this.clientes.add(nuevo);
	}
	
	public Boolean agregarMesa(Mesa nuevo) {
		//for (Mozo mozo : mozos) {
		//	return mozos.add(nuevo);
		//}
		//return false;
		return this.mesas.add(nuevo);
	}
	
	
	
	
	
	public TreeSet<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(TreeSet<Cliente> clientes) {
		this.clientes = clientes;
	}

	public TreeSet<Mozo> getMozos() {
		return mozos;
	}
	
	public void setMozos(TreeSet<Mozo> mozos) {
		this.mozos = mozos;
	}
	
	public HashSet<Mesa> getMesas() {
		return mesas;
	}
	
	public void setMesas(HashSet<Mesa> mesas) {
		this.mesas = mesas;
	}
	
	public String getNombreDelResto() {
		return nombreDelResto;
	}
	
	public void setNombreDelResto(String nombreDelResto) {
		this.nombreDelResto = nombreDelResto;
	}
	
	
	
}
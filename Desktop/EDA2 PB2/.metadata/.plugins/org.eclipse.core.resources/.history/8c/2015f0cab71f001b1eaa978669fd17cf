package eda2;

import java.util.*;

public class Restaurant {
	private TreeSet<Mozo> mozos;
	private HashSet<Mesa> mesas;
	private String nombreDelResto;
	public Restaurant(String nombreDelResto) {
		this.nombreDelResto = nombreDelResto;
		mozos = new TreeSet<Mozo>();
		mesas = new HashSet<Mesa>();
	}
	public Boolean agregarMozo(Mozo nuevo) {
		for (Mozo mozo : mozos) {
			return mozos.add(nuevo);
		}
		return false;
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

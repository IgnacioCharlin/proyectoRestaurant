package eda;

import java.util.HashSet;
import java.util.TreeSet;

public class Restaurant {
	private TreeSet<Mozo> mozos;
	private HashSet<Mesa> mesas;
	private TreeSet<Cliente> clientes;
	private TreeSet<Pedido>pedidos;
	private HashSet <Alimento> carta;
	private String nombreDelResto;
	
	public Restaurant(String nombreDelResto) {
		this.nombreDelResto = nombreDelResto;
		mozos = new TreeSet<Mozo>();
		mesas = new HashSet<Mesa>();
		clientes = new TreeSet<Cliente>();
		pedidos = new TreeSet<Pedido>();
		carta = new HashSet<Alimento>();
	}
	
	public Boolean agregarMozo(Mozo nuevo) {
		return mozos.add(nuevo);
	}
	
	public Boolean agregarCliente(Cliente nuevo) {
		return this.clientes.add(nuevo);
	}
	
	public Boolean agregarMesa(Mesa nuevo) {
		return this.mesas.add(nuevo);
	}
	
	public Boolean agregarComidaALaCarta(Alimento nuevo) {
		return carta.add(nuevo);
	}
	
	public Boolean agregarPedido(Pedido nuevo) {
		for (Mozo mozo : mozos) {
			for (Mesa mesa : mesas) {
				if (nuevo.getMozo().equals(mozo) && nuevo.getNroDeMesa().equals(mesa) ) {
					return pedidos.add(nuevo);
				}
			}
		}
		return false;
		
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

	public TreeSet<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(TreeSet<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public HashSet<Alimento> getCarta() {
		return carta;
	}

	public void setCarta(HashSet<Alimento> carta) {
		this.carta = carta;
	}

	
	
	
}
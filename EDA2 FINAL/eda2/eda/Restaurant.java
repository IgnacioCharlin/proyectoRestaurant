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
	
	public Boolean agregarMesa(Mesa nuevo) {
		return this.mesas.add(nuevo);
	}
	
	public Boolean asignarMesaAlCliente(Mesa mesa , Cliente cliente) {
		if (mesa.getOcupada()==false) {
			mesa.setOcupada(true);
			return clientes.add(cliente);
		}
		return false;
	}
	
	
	public Boolean agregarComidaALaCarta(Alimento nuevo) {
		return carta.add(nuevo);
	}
	public Boolean agregarComidaAlPedido(Alimento nuevo , Pedido actual) {
		for (Alimento alimento : carta) {
			for (Pedido pedido : pedidos) {
				if (alimento.getDescripcion().equals(nuevo.getDescripcion())&& actual.equals(pedido)) {
					return actual.agregarAlimentoAlPedido(nuevo);
				}
			}
		}
		return false;
	}
	public Boolean agregarPedido(Pedido nuevo) {
		for (Mozo mozo : mozos) {
			for (Mesa mesa : mesas) {
				if (nuevo.getMozo().equals(mozo) && nuevo.getNroDeMesa().equals(mesa) && nuevo.getNroDeMesa().getOcupada().equals(true) ) {
					return pedidos.add(nuevo);
				}
			}
		}
		return false;
		
	}
	
	public Double cerrarMesaYTotalDeGastadoEnLaMesa (Integer nroDePedido) {
		for (Pedido pedido : pedidos) {
			if (pedido.getNumeroDePedido().equals(nroDePedido)) {
				pedido.getNroDeMesa().setOcupada(false);
				return pedido.getTotalDelPedido();
			}
		}
		return 0.0;
	}
	
	public Integer cantidaDeMesasLibres() {
		Integer cantidadDeMesasLibres=0;
		for (Mesa mesa : mesas) {
			if (mesa.getOcupada().equals(false)) {
				cantidadDeMesasLibres++;
			}
		}
		return cantidadDeMesasLibres;
	}
	

	
	public Double consumoTotalDeTodasLasMesas() {
		Double total = 0.0;
		for (Pedido pedido : pedidos) {
			total += pedido.getTotalDelPedido();
		}
		return total;
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
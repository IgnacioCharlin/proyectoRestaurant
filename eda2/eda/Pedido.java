package eda;

import java.util.HashSet;

public class Pedido implements Comparable<Pedido> {
	private Integer numeroDePedido;
	private HashSet<Alimento>alimentosEnElPedido;
	private Mesa mesa;
	private Mozo mozo;
	private Double totalDelPedido;

	public Pedido(Integer numeroDePedido, Mesa mesa, Mozo mozo) {
		super();
		this.numeroDePedido = numeroDePedido;
		this.mesa = mesa;
		this.mozo = mozo;
		totalDelPedido = 0.0;
		alimentosEnElPedido = new HashSet<Alimento>();
	}

	public Boolean agregarAlimentoAlPedido(Alimento nuevo) {
		totalDelPedido += nuevo.getPrecio();
		return alimentosEnElPedido.add(nuevo);
	}
	
	public Integer getNumeroDePedido() {
		return numeroDePedido;
	}


	public void setNumeroDePedido(Integer numeroDePedido) {
		this.numeroDePedido = numeroDePedido;
	}


	public HashSet<Alimento> getAlimentosEnElPedido() {
		return alimentosEnElPedido;
	}


	public void setAlimentosEnElPedido(HashSet<Alimento> alimentosEnElPedido) {
		this.alimentosEnElPedido = alimentosEnElPedido;
	}


	public Mesa getNroDeMesa() {
		return mesa;
	}


	public Mozo getMozo() {
		return mozo;
	}

	public void setMozo(Mozo mozo) {
		this.mozo = mozo;
	}

	public void setNroDeMesa(Mesa nroDeMesa) {
		this.mesa = nroDeMesa;
	}

	

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Double getTotalDelPedido() {
		return totalDelPedido;
	}

	public void setTotalDelPedido(Double totalDelPedido) {
		this.totalDelPedido = totalDelPedido;
	}

	@Override
	public int compareTo(Pedido arg0) {
		return numeroDePedido.compareTo(arg0.numeroDePedido);
	}
}

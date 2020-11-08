package eda;

import java.util.HashSet;

public class Pedido implements Comparable<Pedido> {
	private Integer numeroDePedido;
	private HashSet<Alimento>alimentosEnElPedido;
	private Mesa mesa;
	private Mozo mozo;

	public Pedido(Integer numeroDePedido, Mesa mesa, Mozo mozo) {
		super();
		this.numeroDePedido = numeroDePedido;
		this.mesa = mesa;
		this.mozo = mozo;
		alimentosEnElPedido = new HashSet<Alimento>();
	}

	public Boolean agregarAlimentoAlPedido(Alimento nuevo , Restaurant actual) {
		for (Alimento alimento : actual.getCarta()) {
			if (nuevo.getDescripcion().equals(alimento.getDescripcion())) {
				return alimentosEnElPedido.add(nuevo);
			}
		}
		return false;
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


	@Override
	public int compareTo(Pedido arg0) {
		return numeroDePedido.compareTo(arg0.numeroDePedido);
	}
}

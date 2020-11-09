package eda2;

import java.util.HashSet;

public class Carta {
	private HashSet<Alimento> carta;
	private HashSet<Bebida> bebida;

	
	public Carta(HashSet<Alimento> carta, HashSet<Bebida> bebida) {
		super();
		this.carta = carta;
		this bebida = bebida;
	}
	

	public Boolean agregarComidaALaCarta(Alimento nuevo) {
		return carta.add(nuevo);
	}
	
	public Boolean agregarBebidaALaCarta(Bebida nuevo) {
		return bebida.add(nuevo);
	}
	
	public HashSet<Alimento> getCarta() {
		return carta;
	}

	public void setCarta(HashSet<Alimento> carta) {
		this.carta = carta;
	}
	
}

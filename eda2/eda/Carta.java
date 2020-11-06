package eda;

import java.util.HashSet;

public class Carta {
	private HashSet<Alimento> carta;

	
	public Carta(HashSet<Alimento> carta) {
		super();
		this.carta = carta;
	}

	public Boolean agregarComidaALaCarta(Alimento nuevo) {
		return carta.add(nuevo);
	}
	
	public HashSet<Alimento> getCarta() {
		return carta;
	}

	public void setCarta(HashSet<Alimento> carta) {
		this.carta = carta;
	}
	
}

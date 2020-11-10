package eda;

import java.util.Comparator;

public class PorLegajoComparator implements Comparator<Mozo>{
	
	@Override
	public int compare(Mozo mozo1,Mozo mozo2) {
		
		return mozo1.getLegajo().compareTo(mozo2.getLegajo());
	}

}
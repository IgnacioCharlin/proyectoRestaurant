package eda;

import java.util.Comparator;

public class PorDniComparator implements Comparator<Cliente>{
	
	@Override
	public int compare(Cliente cliente1,Cliente cliente2) {
		
		return cliente1.getDni().compareTo(cliente2.getDni());
	}

}

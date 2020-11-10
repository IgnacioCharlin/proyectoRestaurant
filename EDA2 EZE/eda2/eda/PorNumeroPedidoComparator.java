package eda;

import java.util.Comparator;

public class PorNumeroPedidoComparator implements Comparator<Pedido>{
	
	@Override
	public int compare(Pedido pedido1,Pedido pedido2) {
		
		return pedido1.getNumeroDePedido().compareTo(pedido2.getNumeroDePedido());
	}

}
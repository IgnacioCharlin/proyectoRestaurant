package eda;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestResto {

	@Test
	public void CrearMozo() {
		Persona juan = new Mozo("juan", "Gonzales", (long) 123, 123);
		assertNotNull(juan);
		
	}
	
	@Test
	public void CrearCliente() {
		Persona juan = new Cliente("juan", "Gonzales", (long) 123);
		assertNotNull(juan);
		
	}
	
	@Test
	public void CrearMesa() {
		Mesa mesa1 = new Mesa(4,001);
		assertNotNull(mesa1);
	}
	
	@Test
	public void CrearBebida() {
		Alimento cerveza = new Bebida("Cerveza",100.0);
		assertNotNull(cerveza);
		
	}
	
	@Test
	public void CrearComidaa() {
		Alimento papitas = new Comida("papas",100.0);
		assertNotNull(papitas);
		
	}
	
	@Test
	public void CrearRestaurant() {
		
		Restaurant resto1 = new Restaurant("Antares");
		assertNotNull(resto1);

	}
	
	@Test
	public void queSePuedaAsignarUnMozoAlRestaurant() {
		Mozo juan = new Mozo("juan", "Gonzales", (long) 123, 123);
		Restaurant resto1 = new Restaurant("Antares");
		
		assertTrue(resto1.agregarMozo(juan));
	}
	
	@Test
	public void queSePuedaAsignarUnClienteAlRestaurant() {
		Cliente juan = new Cliente("juan", "Gonzales", (long) 123);
		Restaurant resto1 = new Restaurant("Antares");
		
		resto1.agregarCliente(juan);
	}
	
	@Test
	public void queSePuedaAsignarUnaMesaAlRestaurant() {
		Mesa mesa1 = new Mesa(4,001);
		Restaurant resto1 = new Restaurant("Antares");
		
		resto1.agregarMesa(mesa1);
		
		Integer cantidadMesasEnElBar = resto1.getMesas().size();
		Integer cantidadEsperada = 1;
		
		assertEquals(cantidadEsperada,cantidadMesasEnElBar);

	}
	
	@Test
	public void AgregarComidadALaCarta() {
		Restaurant resto1 = new Restaurant("Antares");
		Alimento pizza = new Comida("pizza", 150.0);
		
		assertTrue(resto1.agregarComidaALaCarta(pizza));

	}
	
	@Test
	public void CrearUnPedido() {
		Restaurant resto1 = new Restaurant("Antares");
		Mesa mesa1 = new Mesa(4,001);
		resto1.agregarMesa(mesa1);
		Mozo juan = new Mozo("juan", "Gonzales", (long) 123, 123);
		resto1.agregarMozo(juan);
		Pedido nuevo = new Pedido(1, mesa1, juan);
		assertTrue(resto1.agregarPedido(nuevo));

	}
	
	@Test
	public void agregarComidaAlPedido() {
		Restaurant resto1 = new Restaurant("Antares");
		Mesa mesa1 = new Mesa(4,001);
		resto1.agregarMesa(mesa1);
		Mozo juan = new Mozo("juan", "Gonzales", (long) 123, 123);
		resto1.agregarMozo(juan);
		Pedido nuevo = new Pedido(1, mesa1, juan);
		resto1.agregarPedido(nuevo);
		Alimento pizza = new Comida("pizza", 150.0);
		resto1.agregarComidaALaCarta(pizza);
		assertTrue(nuevo.agregarAlimentoAlPedido(pizza, resto1));

	}
	
	@Test
	public void agregarComidayBebidaAlPedido() {
		Restaurant resto1 = new Restaurant("Antares");
		Mesa mesa1 = new Mesa(4,001);
		resto1.agregarMesa(mesa1);
		Mozo juan = new Mozo("juan", "Gonzales", (long) 123, 123);
		resto1.agregarMozo(juan);
		Pedido nuevo = new Pedido(1, mesa1, juan);
		resto1.agregarPedido(nuevo);
		Alimento cerveza = new Bebida("cerveza", 150.0);
		Alimento pizza = new Bebida("pizza", 200.0);
		
		resto1.agregarComidaALaCarta(cerveza);
		resto1.agregarComidaALaCarta(pizza);
		
		assertTrue(nuevo.agregarAlimentoAlPedido(cerveza, resto1));
		assertTrue(nuevo.agregarAlimentoAlPedido(pizza, resto1));

	}
	
	@Test
	public void queNoPuedaAgregarAlimentoAlPedido() {
		Restaurant resto1 = new Restaurant("Antares");
		Mesa mesa1 = new Mesa(4,001);
		resto1.agregarMesa(mesa1);
		Mozo juan = new Mozo("juan", "Gonzales", (long) 123, 123);
		resto1.agregarMozo(juan);
		Pedido nuevo = new Pedido(1, mesa1, juan);
		resto1.agregarPedido(nuevo);
		Alimento cerveza = new Bebida("cerveza", 150.0);
		Alimento pizza = new Bebida("pizza", 200.0);
		
		resto1.agregarComidaALaCarta(cerveza);
		
		assertTrue(nuevo.agregarAlimentoAlPedido(cerveza, resto1));
		assertFalse(nuevo.agregarAlimentoAlPedido(pizza, resto1)); // ESTE DARIA FALSO PORQUE NO LO ENCUENTRA EN CARTA YA QUE NO LO AGREGAMOS.

	}
	
	@Test
	public void importeTotalPedido() {
		Restaurant resto1 = new Restaurant("Antares");
		Mesa mesa1 = new Mesa(4,001);
		resto1.agregarMesa(mesa1);
		Mozo juan = new Mozo("juan", "Gonzales", (long) 123, 123);
		resto1.agregarMozo(juan);
		Pedido nuevo = new Pedido(1, mesa1, juan);
		resto1.agregarPedido(nuevo);
		
		Alimento cerveza = new Bebida("cerveza", 150.0);
		Alimento pizza = new Comida("pizza", 200.0);
		
		resto1.agregarComidaALaCarta(cerveza);
		resto1.agregarComidaALaCarta(pizza);
		nuevo.agregarAlimentoAlPedido(cerveza, resto1);
		nuevo.agregarAlimentoAlPedido(pizza, resto1);
		
		Integer ve=350;;
		Integer importeTotal=0;
		
		for(Pedido nuevo : alimentosEnElPedido) {
			if(nuevo.getNumeroDePedido()==1) {
			importeTotal+=nuevo.getAlimentosEnElPedido().getPrecio();
		}
		}
		assertEquals(ve,importeTotal,0.0);
	
	}
	
}
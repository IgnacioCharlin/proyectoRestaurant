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
	public void AgregarPedidoAUnaMesa() {
		Restaurant resto1 = new Restaurant("Antares");
		Mesa mesa1 = new Mesa(4,001);
		Persona juan = new Mozo("juan", "Gonzales", (long) 123, 123);
		Pedido nuevo = new Pedido(1, mesa1,  (Mozo)juan);
		assertNotNull(nuevo);
	}
	@Test
	public void AgregarComidaAlPedido() {
		Restaurant resto1 = new Restaurant("Antares");
		Mesa mesa1 = new Mesa(4,001);
		Persona juan = new Mozo("juan", "Gonzales", (long) 123, 123);
		Pedido nuevo = new Pedido(1, mesa1,  (Mozo)juan);
		Alimento pizza = new Comida("pizza", 150.0);
		Alimento cerveza = new Bebida("Cerveza",100.0);
		nuevo.agregarAlimentoAlPedido(pizza);
		nuevo.agregarAlimentoAlPedido(cerveza);
		

	}
}

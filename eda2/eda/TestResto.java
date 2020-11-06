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
		Pedido cerveza = new Bebida("Cerveza",100d, 1);
		assertNotNull(cerveza);
		
	}
	
	@Test
	public void CrearComidaa() {
		Pedido papitas = new Comida("Cerveza",100d, 1);
		assertNotNull(papitas);
		
	}
	
	@Test
	public void CrearRestaurant() {
		
		Restaurant resto1 = new Restaurant("Antares");
		assertNotNull(resto1);

	}
	
	@Test
	public void queSePuedaAsignarUnMozoAlRestaurant() {
		Persona juan = new Mozo("juan", "Gonzales", (long) 123, 123);
		Restaurant resto1 = new Restaurant("Antares");
		
		resto1.agregarMozo(juan);
		//Me da error, porque le paso un objeto del tipo persona y el metodo de la clase Restaurant espera un objeto mozo
	}
	
	@Test
	public void queSePuedaAsignarUnClienteAlRestaurant() {
		Persona juan = new Cliente("juan", "Gonzales", (long) 123);
		Restaurant resto1 = new Restaurant("Antares");
		
		resto1.agregarCliente(juan);
		//Me da error, porque le paso un objeto del tipo persona y el metodo de la clase Restaurant espera un objeto Cliente
	}
	
	@Test
	public void queSePuedaAsignarUnaMesaAlRestaurant() {
		Mesa mesa1 = new Mesa(4,001);
		Restaurant resto1 = new Restaurant("Antares");
		
		resto1.agregarMesa(mesa1);
		//Este me funciona porque no tiene aplicado polimorfismo, chequear eso con el profe.
		
		Integer cantidadMesasEnElBar = resto1.getMesas().size();
		Integer cantidadEsperada = 1;
		
		assertEquals(cantidadEsperada,cantidadMesasEnElBar);

	}
}

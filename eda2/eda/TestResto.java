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
		Mesa mesa1 = new Mesa(4,001);
		resto1.agregarMesa(mesa1);
		assertTrue(resto1.asignarMesaAlCliente(mesa1, juan));
	}
	@Test
	public void queNoSePuedaAsignarUnClienteAlRestaurantConElMismoDni() {
		Cliente juan = new Cliente("juan", "Gonzales", (long) 123);
		Cliente roberto = new Cliente("roberto", "Gomez", (long) 123);
		Restaurant resto1 = new Restaurant("Antares");
		Mesa mesa1 = new Mesa(4,001);
		resto1.agregarMesa(mesa1);
		Mesa mesa2 = new Mesa(4,002);
		resto1.agregarMesa(mesa2);
		assertTrue(resto1.asignarMesaAlCliente(mesa1, juan));
		assertFalse(resto1.asignarMesaAlCliente(mesa2, roberto));
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
	public void queNoSePuedaAsignarUnaMesaAlRestaurantConMismoNumero() {
		Mesa mesa1 = new Mesa(4,001);
		Mesa mesa2 = new Mesa(4,001);
		Restaurant resto1 = new Restaurant("Antares");
		
		resto1.agregarMesa(mesa1);
		resto1.agregarMesa(mesa2);
		
		Integer cantidadMesasEnElBar = resto1.getMesas().size();
		Integer cantidadEsperada = 1;
		
		assertEquals(cantidadEsperada,cantidadMesasEnElBar);

	}
	@Test
	public void cantidadDeMesasLibres() {
		Mesa mesa1 = new Mesa(4,001);
		Mesa mesa2 = new Mesa(4,002);
		Mesa mesa3 = new Mesa(4,003);
		Restaurant resto1 = new Restaurant("Antares");
		Mozo juan = new Mozo("juan", "Gonzales", (long) 123, 123);
		Cliente raul = new Cliente("raul", "Gomez", (long) 321);
		Cliente federico = new Cliente("federico", "perez", (long) 324);
		resto1.agregarMesa(mesa1);
		resto1.agregarMesa(mesa2);
		resto1.agregarMesa(mesa3);
		resto1.agregarMozo(juan);
		resto1.asignarMesaAlCliente(mesa1, federico);
		resto1.asignarMesaAlCliente(mesa2, raul);
		
		assertEquals(1,resto1.cantidaDeMesasLibres(),0.01);

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
		Cliente raul = new Cliente("raul", "Gomez", (long) 321);
		Mozo juan = new Mozo("juan", "Gonzales", (long) 123, 123);
		resto1.agregarMozo(juan);
		resto1.asignarMesaAlCliente(mesa1, raul);
		Pedido nuevo = new Pedido(1, mesa1, juan);
		assertTrue(resto1.agregarPedido(nuevo));

	}
	
	@Test
	public void agregarComidaAlPedido() {
		Restaurant resto1 = new Restaurant("Antares");
		Mesa mesa1 = new Mesa(4,001);
		resto1.agregarMesa(mesa1);
		Mozo juan = new Mozo("juan", "Gonzales", (long) 123, 123);
		Cliente raul = new Cliente("raul", "Gomez", (long) 321);
		resto1.agregarMozo(juan);
		resto1.asignarMesaAlCliente(mesa1, raul);
		Pedido nuevo = new Pedido(1, mesa1, juan);
		resto1.agregarPedido(nuevo);
		Alimento pizza = new Comida("pizza", 150.0);
		resto1.agregarComidaALaCarta(pizza);
		assertTrue(resto1.agregarComidaAlPedido(pizza, nuevo));

	}
	
	@Test
	public void queNoPuedaAgregarAlimentoAlPedido() {
		Restaurant resto1 = new Restaurant("Antares");
		Mesa mesa1 = new Mesa(4,001);
		resto1.agregarMesa(mesa1);
		Mozo juan = new Mozo("juan", "Gonzales", (long) 123, 123);
		Cliente raul = new Cliente("raul", "Gomez", (long) 321);
		resto1.agregarMozo(juan);
		resto1.asignarMesaAlCliente(mesa1, raul);
		Pedido nuevo = new Pedido(1, mesa1, juan);
		resto1.agregarPedido(nuevo);
		Alimento cerveza = new Bebida("cerveza", 150.0);
		Alimento pizza = new Bebida("pizza", 200.0);
		
		resto1.agregarComidaALaCarta(cerveza);
		
		assertTrue(resto1.agregarComidaAlPedido(cerveza, nuevo));
		assertFalse(resto1.agregarComidaAlPedido(pizza, nuevo)); // ESTE DARIA FALSO PORQUE NO LO ENCUENTRA EN CARTA YA QUE NO LO AGREGAMOS.

	}
	
	@Test
	public void importeTotalPedido() {
		Restaurant resto1 = new Restaurant("Antares");
		Mesa mesa1 = new Mesa(4,001);
		resto1.agregarMesa(mesa1);
		Mozo juan = new Mozo("juan", "Gonzales", (long) 123, 123);
		Cliente raul = new Cliente("raul", "Gomez", (long) 321);
		resto1.agregarMozo(juan);
		resto1.asignarMesaAlCliente(mesa1, raul);
		Pedido nuevo = new Pedido(1, mesa1, juan);
		resto1.agregarPedido(nuevo);
		
		Alimento cerveza = new Bebida("cerveza", 150.0);
		Alimento pizza = new Comida("pizza", 200.0);
		
		resto1.agregarComidaALaCarta(cerveza);
		resto1.agregarComidaALaCarta(pizza);
		resto1.agregarComidaAlPedido(cerveza, nuevo);
		resto1.agregarComidaAlPedido(pizza, nuevo);
		
		assertEquals(350.0, resto1.cerrarMesaYTotalDeGastadoEnLaMesa(001), 0.01);
	
	}
	@Test
	public void consumoTotalEnElResto() {
		Restaurant resto1 = new Restaurant("Antares");
		Mesa mesa1 = new Mesa(4,001);
		resto1.agregarMesa(mesa1);
		Mesa mesa2 = new Mesa(4,002);
		resto1.agregarMesa(mesa2);
		Mozo juan = new Mozo("juan", "Gonzales", (long) 123, 123);
		Cliente raul = new Cliente("raul", "Gomez", (long) 321);
		Cliente federico = new Cliente("federico", "perez", (long) 324);
		resto1.agregarMozo(juan);
		resto1.asignarMesaAlCliente(mesa1, raul);
		resto1.asignarMesaAlCliente(mesa2, federico);
		Pedido nuevo = new Pedido(1, mesa1, juan);
		Pedido nuevo2 = new Pedido(2, mesa2, juan);
		resto1.agregarPedido(nuevo);
		resto1.agregarPedido(nuevo2);
		
		Alimento cerveza = new Bebida("cerveza", 150.0);
		Alimento pizza = new Comida("pizza", 200.0);
		
		resto1.agregarComidaALaCarta(cerveza);
		resto1.agregarComidaALaCarta(pizza);
		resto1.agregarComidaAlPedido(cerveza, nuevo);
		resto1.agregarComidaAlPedido(pizza, nuevo);
		resto1.agregarComidaAlPedido(cerveza, nuevo2);
		resto1.agregarComidaAlPedido(pizza, nuevo2);
		
		assertEquals(700.0, resto1.consumoTotalDeTodasLasMesas(), 0.01);
	
	}
}

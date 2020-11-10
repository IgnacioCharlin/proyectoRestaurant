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
	
	@Test
	public void importeTotalDeDosMesasDistintas() {
		Restaurant resto1 = new Restaurant("Antares");
		Mesa mesa1 = new Mesa(4,001);
		Mesa mesa2 = new Mesa(4,002);
		
		resto1.agregarMesa(mesa1);
		resto1.agregarMesa(mesa2);
		
		Mozo juan = new Mozo("juan", "Gonzales", (long) 123, 123);
		Mozo marcos = new Mozo("marcos", "fernandez", (long) 122, 122);
		
		Cliente raul = new Cliente("raul", "Gomez", (long) 321);
		Cliente jorge = new Cliente("jorge", "sanson", (long) 221);
		
		resto1.agregarMozo(juan);
		resto1.agregarMozo(marcos);
		resto1.asignarMesaAlCliente(mesa1, raul);
		resto1.asignarMesaAlCliente(mesa2, jorge);
		
		Pedido nuevo = new Pedido(1, mesa1, juan);
		Pedido nuevo2 = new Pedido(2, mesa2, marcos);
		
		resto1.agregarPedido(nuevo);
		resto1.agregarPedido(nuevo2);
		
		Alimento cerveza = new Bebida("cerveza", 150.0);
		Alimento pizza = new Comida("pizza", 200.0);
		
		resto1.agregarComidaALaCarta(cerveza);
		resto1.agregarComidaALaCarta(pizza);
		
		resto1.agregarComidaAlPedido(cerveza, nuevo);
		resto1.agregarComidaAlPedido(pizza, nuevo);
		
		resto1.agregarComidaAlPedido(pizza, nuevo2);
		
		assertEquals(350.0, resto1.cerrarMesaYTotalDeGastadoEnLaMesa(001), 0.01);
		assertEquals(200.0, resto1.cerrarMesaYTotalDeGastadoEnLaMesa(002), 0.01);
	
	}
	
	
	
	@Test
	public void queLosClientesSePresentenOrdenadosPorDni() {
		PorDniComparator orden = new PorDniComparator();
		
		Cliente cliente1 = new Cliente("raul", "Gomez", (long) 222);
		Cliente cliente2 = new Cliente("jorge", "Gomez", (long) 111);
		Cliente cliente3 = new Cliente("luis", "Gomez", (long) 444);
		Cliente cliente4 = new Cliente("matias", "Gomez", (long) 333);
		
		Mesa mesa1 = new Mesa(4,001);
		
		Restaurant resto1 = new Restaurant("Antares");
		
		resto1.agregarMesa(mesa1);
		
		resto1.asignarMesaAlCliente(mesa1, cliente1);
		resto1.asignarMesaAlCliente(mesa1, cliente2);
		resto1.asignarMesaAlCliente(mesa1, cliente3);
		resto1.asignarMesaAlCliente(mesa1, cliente4);
		
		Cliente primerCliente = resto1.getClientes().first();
		Cliente ultimoCliente = resto1.getClientes().last();
		
		assertEquals(cliente2.getDni(),primerCliente.getDni());
		
		assertEquals(cliente3.getDni(),ultimoCliente.getDni());
		
	}
	
	
	@Test
	public void queLosMozosSePresentenOrdenadosPorLegajo() {
		PorLegajoComparator orden = new PorLegajoComparator();
		
		Cliente cliente1 = new Cliente("raul", "Gomez", (long) 222);
		Cliente cliente2 = new Cliente("jorge", "Gomez", (long) 111);
		Cliente cliente3 = new Cliente("luis", "Gomez", (long) 444);
		Cliente cliente4 = new Cliente("matias", "Gomez", (long) 333);
		
		Mesa mesa1 = new Mesa(4,001);
		
		Restaurant resto1 = new Restaurant("Antares");
		
		resto1.asignarMesaAlCliente(mesa1, cliente1);
		resto1.asignarMesaAlCliente(mesa1, cliente2);
		resto1.asignarMesaAlCliente(mesa1, cliente3);
		resto1.asignarMesaAlCliente(mesa1, cliente4);
		
		Mozo mozo1 = new Mozo("juan", "Gonzales", (long) 123, 222);
		Mozo mozo2 = new Mozo("marcos", "fernandez", (long) 122, 111);
		Mozo mozo3 = new Mozo("jose", "Gonzales", (long) 123, 444);
		Mozo mozo4 = new Mozo("domingo", "fernandez", (long) 122, 333);
		
		resto1.agregarMesa(mesa1);
		
		resto1.agregarMozo(mozo1);
		resto1.agregarMozo(mozo2);
		resto1.agregarMozo(mozo3);
		resto1.agregarMozo(mozo4);
		
		Mozo primerMozo = resto1.getMozos().first();
		Mozo ultimoMozo = resto1.getMozos().last();
		
		
		assertEquals(mozo2.getLegajo(),primerMozo.getLegajo());
		
		assertEquals(mozo3.getLegajo(),ultimoMozo.getLegajo());
		
	}
	
	@Test
	public void queLosPedidosSePresentenOrdenadosPorNumeroDePedido() {
		PorNumeroPedidoComparator orden = new PorNumeroPedidoComparator();
		
		Cliente cliente1 = new Cliente("raul", "Gomez", (long) 222);
		Cliente cliente2 = new Cliente("jorge", "Gomez", (long) 111);
		Cliente cliente3 = new Cliente("luis", "Gomez", (long) 444);
		Cliente cliente4 = new Cliente("matias", "Gomez", (long) 333);
		
		Mesa mesa1 = new Mesa(4,001);
		
		Restaurant resto1 = new Restaurant("Antares");
		
		resto1.asignarMesaAlCliente(mesa1, cliente1);
		resto1.asignarMesaAlCliente(mesa1, cliente2);
		resto1.asignarMesaAlCliente(mesa1, cliente3);
		resto1.asignarMesaAlCliente(mesa1, cliente4);
		
		Mozo mozo1 = new Mozo("juan", "Gonzales", (long) 123, 222);
		Mozo mozo2 = new Mozo("marcos", "fernandez", (long) 122, 111);
		Mozo mozo3 = new Mozo("jose", "Gonzales", (long) 123, 444);
		Mozo mozo4 = new Mozo("domingo", "fernandez", (long) 122, 333);
		
		resto1.agregarMesa(mesa1);
		
		resto1.agregarMozo(mozo1);
		resto1.agregarMozo(mozo2);
		resto1.agregarMozo(mozo3);
		resto1.agregarMozo(mozo4);
		
		Pedido nuevo1 = new Pedido(2, mesa1, mozo1);
		Pedido nuevo2 = new Pedido(1, mesa1, mozo2);
		Pedido nuevo3 = new Pedido(4, mesa1, mozo3);
		Pedido nuevo4 = new Pedido(3, mesa1, mozo4);
		
		resto1.agregarPedido(nuevo1);
		resto1.agregarPedido(nuevo2);
		resto1.agregarPedido(nuevo3);
		resto1.agregarPedido(nuevo4);
		
		Pedido primerPedido = resto1.getPedidos().first();
		Pedido ultimoPedido = resto1.getPedidos().last();
		
		
		assertEquals(nuevo2.getNumeroDePedido(),primerPedido.getNumeroDePedido());
		
		assertEquals(nuevo3.getNumeroDePedido(),ultimoPedido.getNumeroDePedido());
		
	}
	
	
		
	
	
	
	
	
	
	
}


package TestEjercicio1;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import Ejercicio2.Bebida;
import Ejercicio2.ComarcaPlus;
import Ejercicio2.Dispositivo;
import Ejercicio2.MasterCard;
import Ejercicio2.Plato;
import Ejercicio2.Tarjeta;
import Ejercicio2.Viedma;
import Ejercicio2.Visa;
import Implementaciones.PedidosRegistroEnMemoria;

class DispositivoTest_TP1_Iteracion2 {

	Bebida coca = new Bebida("Coca", 200);
	Bebida fanta = new Bebida("Fanta", 150);
	Bebida sprite = new Bebida("Sprite", 150);

	Plato milanesas = new Plato("Milanesas con papas", 500);
	Plato pollo = new Plato("Pollo a la parrilla", 600);
	Plato empanadas = new Plato("Empanadas", 500);

	@Test
	public void testVisa() {
		// SetUp
		Tarjeta visa = new Visa(5);
		Dispositivo dispositivo = new Dispositivo(visa, new PedidosRegistroEnMemoria());

		dispositivo.agregarBebida(coca, 2);
		dispositivo.agregarPlato(milanesas, 1);
		dispositivo.agregarPlato(pollo, 1);

		// Testeo
		float resultado = dispositivo.calculo();
		float valorEsperado = 1562.4f;
		dispositivo.procesarPago();

		// Veriticacion
		Assert.assertTrue(valorEsperado == resultado);
	}

	@Test
	public void testMaster() {

		// SetUp
		Tarjeta master = new MasterCard(5);
		Dispositivo dispositivo = new Dispositivo(master, new PedidosRegistroEnMemoria());

		dispositivo.agregarBebida(coca, 2);
		dispositivo.agregarBebida(fanta, 1);
		dispositivo.agregarBebida(sprite, 1);
		dispositivo.agregarPlato(milanesas, 1);
		dispositivo.agregarPlato(pollo, 1);
		dispositivo.agregarPlato(empanadas, 2);

		// Testeo
		float resultado = dispositivo.calculo();
		float valorEsperado = 2895.9f;
		dispositivo.procesarPago();
		// System.out.println("Resultado: " + resultado);

		// Veriticacion
		Assert.assertTrue(valorEsperado == resultado);

	}

	@Test
	public void testComarca() {

		// SetUp
		Tarjeta comarca = new ComarcaPlus(5);
		Dispositivo dispositivo = new Dispositivo(comarca, new PedidosRegistroEnMemoria());

		dispositivo.agregarBebida(coca, 2);
		dispositivo.agregarPlato(milanesas, 1);
		dispositivo.agregarPlato(pollo, 1);

		// Testeo
		float resultado = dispositivo.calculo();
		float valorEsperado = 1543.5f;
		dispositivo.procesarPago();

		// Veriticacion
		Assert.assertTrue(valorEsperado == resultado);

	}

	@Test
	public void testViedma() {

		// SetUp
		Tarjeta viedma = new Viedma(5);
		Dispositivo dispositivo = new Dispositivo(viedma, new PedidosRegistroEnMemoria());

		dispositivo.agregarBebida(coca, 2);
		dispositivo.agregarPlato(milanesas, 1);
		dispositivo.agregarPlato(pollo, 1);

		// Testeo
		float resultado = dispositivo.calculo();
		float valorEsperado = 1575f;

		// Veriticacion
		Assert.assertTrue(valorEsperado == resultado);

	}

	@Test
	public void testCoberturaSuficiente() { // REVISAR...

		// SetUp
		Tarjeta visa = new Visa(5);
		Dispositivo dispositivo = new Dispositivo(visa, new PedidosRegistroEnMemoria());

		dispositivo.agregarBebida(coca, 2);
		dispositivo.agregarPlato(milanesas, 1);
		dispositivo.agregarPlato(pollo, 1);

		// Testeo
		float resultado = dispositivo.calculo();

		// Veriticacion
		Assert.assertTrue(dispositivo.montoDisponible() >= resultado); // ¿Está bien?

	}

}

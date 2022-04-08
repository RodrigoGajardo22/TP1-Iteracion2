package Ejercicio2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Clases.RegistrarDatos;

public class Dispositivo {

	private Tarjeta tarjeta;
	private List<Bebida> listaBebidas;
	private List<Plato> listaPlatos;
	private float montoBebida, montoPlatos;
	private RegistrarDatos registro;

	public Dispositivo(Tarjeta t, RegistrarDatos registro) {

		this.tarjeta = t;
		this.registro = registro;

		montoBebida = 0;
		montoPlatos = 0;

		listaBebidas = new ArrayList<>();
		listaPlatos = new ArrayList<>();

	}

	public void seleccionarTarjeta(Tarjeta t) {
		this.tarjeta = t;
	}

	public void agregarBebida(Bebida b, int cantidad) {

		listaBebidas.add(b);
		montoBebida += b.costoTotal(cantidad);

	}

	public void agregarPlato(Plato p, int cantidad) {

		listaPlatos.add(p);
		montoPlatos = montoPlatos + p.costoTotal(cantidad);

	}

	public float calculo() {

		return tarjeta.calculo(montoBebida, montoPlatos);

	}

	public float montoDisponible() {
		return tarjeta.cobertura();
	}

	public void procesarPago() {
		float total = calculo();
		if (montoDisponible() > total) {
			tarjeta.procesarPago(total);
			registro.registrar(" " + LocalDateTime.now() + " || " + total);
		}
	}

}

package Implementaciones;

import Clases.RegistrarDatos;

public class RegistroEnMemoria implements RegistrarDatos {

	public void registrar(String datos) {

		System.out.println("Datos: " + datos);
	}
}

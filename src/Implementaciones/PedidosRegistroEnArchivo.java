package Implementaciones;

import java.io.File;
import java.io.FileWriter;

import Clases.RegistrarDatos;

public class PedidosRegistroEnArchivo implements RegistrarDatos {

	public void registrar(String dato) {

		try {

			File archivo = new File("C:\\Users\\Usuario\\Documents\\Registro De Pedidos.txt");
			FileWriter escribir = new FileWriter(archivo, true);

			escribir.write(dato);
			escribir.write("\r\n");
			escribir.close();

		} // Si existe un problema al escribir cae aqui
		catch (Exception e) {
			System.out.println("Error al escribir");
		}

	}
}

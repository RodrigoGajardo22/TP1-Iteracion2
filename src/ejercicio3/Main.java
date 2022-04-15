package ejercicio3;

import java.time.LocalDate;
import java.util.Scanner;

import Implementaciones.EnBaseRegistroDeInscripcion;
import ejercicio1.Concurso;
import ejercicio1.Participante;
import ejercicio1.RegistrarDatos;

public class Main {

	public static void main(String[] args) {

		System.out.println("\n");
		System.out.println(" Menú concurso X: ");
		System.out.println("\n");

		RegistrarDatos registro = new EnBaseRegistroDeInscripcion();
		Concurso concurso = new Concurso(1, LocalDate.now(), LocalDate.now().plusDays(10), registro);

		Scanner leer;
		String datos;
		int dni;
		int opcion = 1;

		while (opcion != 0) {
			leer = new Scanner(System.in);
			System.out.println("Ingrese nombre y apellido: ");
			datos = leer.nextLine();
			System.out.println("DNI: ");
			dni = leer.nextInt();
			System.out.println("\n");
			Participante participante = new Participante(datos, dni);
			concurso.inscribirParticipante(participante);
			System.out.println("\n");

			System.out.println("¿Nuevo participante?");
			System.out.println("\n Precion un numero o 0 para finalizar: ");
			opcion = leer.nextInt();

		}

		System.out.println("Sistema finalizado");

	}

}

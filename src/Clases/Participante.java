package Clases;

public class Participante {

	private int puntos;
	private String nombreYApellido;
	private int dni;

	public Participante(String nombreYApellido, int dni) {

		this.nombreYApellido = nombreYApellido;
		this.dni = dni;
		puntos = 0;
	}

	public void sumarPuntos() {
		puntos = +10;
	}

	public String nombre() {
		return nombreYApellido;
	}

	public String mostrarDatos() {
		if (nombreYApellido != null)
			return "Nombre y Apellido: " + nombreYApellido + " DNI: " + dni + " Puntos: " + puntos;
		else
			return "No se encontraron datos.";
	}

}

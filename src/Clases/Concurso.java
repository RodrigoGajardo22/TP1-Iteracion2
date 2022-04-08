package Clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {

	private List<Participante> listParticipantes;
	private LocalDate fechaInicio, fechaFin;
	private int numParticipante;
	private RegistrarDatos registro;
	private int ID_Concurso;

	public Concurso(int id_Concurso, LocalDate fechaIni, LocalDate fechaFin, RegistrarDatos registro) {
		this.fechaInicio = fechaIni;
		this.fechaFin = fechaFin;
		listParticipantes = new ArrayList<Participante>();
		numParticipante = 0;
		this.registro = registro;
		this.ID_Concurso = id_Concurso;
	}

	public boolean inscribirParticipante(Participante p) {

		if (puedeInscribirse()) {
			p.sumarPuntos();
			listParticipantes.add(p);
			numParticipante++;
			registro.registrar(
					"" + LocalDate.now() + " ID-Participante: " + numParticipante + " ID-Concurso: " + ID_Concurso);
			return true;
		}

		return false;

	}

	private boolean puedeInscribirse() {// si la fecha es valida, entonces True;

		LocalDate fechaHoy = LocalDate.now();

		if (fechaHoy.equals(fechaInicio))
			return true;
		if (fechaHoy.isAfter(fechaInicio) && fechaHoy.isBefore(fechaFin))
			return true;

		return false;
	}

	public void mostrarParticipantes() {

		int i = 1;
		if (numParticipante > 0)
			for (Participante p : listParticipantes) {
				System.out.println(i + " - " + p.mostrarDatos());
				i++;
			}
		else
			System.out.println("Aun no hay participantes registrados.");
	}

}

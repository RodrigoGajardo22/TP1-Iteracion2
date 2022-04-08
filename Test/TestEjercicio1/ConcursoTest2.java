package TestEjercicio1;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import Clases.Concurso;
import Clases.Participante;
import Implementaciones.RegistroEnMemoria;

public class ConcursoTest2 {

	private Participante p1 = new Participante("Juan Fuentes", 40635211); // Puede inscrirbirse y suma puntos
	private Participante p2 = new Participante("Alberto Garcia", 36849859); // Puede inscrirbirse
	private Participante p3 = new Participante("Cristina Entraigas", 17647852);// No puede

	Concurso c1 = new Concurso(1, LocalDate.now().minusDays(3), LocalDate.now().plusDays(10), new RegistroEnMemoria());
	Concurso c2 = new Concurso(2, LocalDate.now(), LocalDate.now().plusDays(7), new RegistroEnMemoria());
	Concurso c3 = new Concurso(3, LocalDate.now().minusDays(12), LocalDate.now().minusDays(2), new RegistroEnMemoria());

	@Test
	public void testInscripcion() { // concurso abierto hace 3 dias

		assertTrue(c1.inscribirParticipante(p1));
	}

	@Test
	public void testInscripcionHoy() {// Concurso abrió hoy

		assertTrue(c1.inscribirParticipante(p2));
	}

	@Test
	public void testInscripcionFueraTermino() { // No puede inscribirse

		assertTrue(!c3.inscribirParticipante(p3));
	}

}

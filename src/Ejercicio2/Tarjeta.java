package Ejercicio2;

public class Tarjeta {
//Atributos
	private float cobertura = 15000;
	protected int propina;

	public Tarjeta(int propina) {

		this.propina = propina;
	}

	public void procesarPago(float monto) {

		if (cobertura >= monto) {
			cobertura = -monto;
			// System.out.println("Pago aceptado.");
		} // else System.out.println(" Monto insuficiente.");

	}

	public float cobertura() {
		return cobertura;
	}

	public float calculo(float montoBebidas, float montoPlatos) {

		float monto = montoBebidas + montoPlatos;
		return monto + monto * propina / 100;

	}
}

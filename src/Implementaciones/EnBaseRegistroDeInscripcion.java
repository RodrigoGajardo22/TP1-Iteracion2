package Implementaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

import ejercicio1.RegistrarDatos;

//	import objetos.RegistroDeInscripcion;

public class EnBaseRegistroDeInscripcion implements RegistrarDatos {

	// TODO Auto-generated method stub
	private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String URL_DB = "jdbc:mysql://localhost:3306/";
	// jdbc:mysql://localhost:3306/
	protected static String DB = "registro_inscripcion";
	protected static String user = "root";
	protected static String pass = "";
	protected static Connection conn = null;

	private void connect() {
		try {
			conn = DriverManager.getConnection(URL_DB + DB + "?useSSL=false", user, pass);
		} catch (SQLException sqlEx) {
			System.out.println("No se ha podido conectar a " + URL_DB + DB + ". " + sqlEx.getMessage());
			System.out.println("Error al cargar el driver");
		}
	}

	private void disconnect() {
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void registrar(String registro) {

		// String consulta = "INSERT INTO registro(registro) VALUES (?)";

		this.connect();

		try {
			PreparedStatement statement = conn.prepareStatement("INSERT INTO registro(registro) " + "VALUES (?)");
			statement.setString(1, registro); // nombre
			System.out.println("Se conecto");
			statement.executeUpdate(); // <----- ACA TIRA ERROR

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.disconnect();
			System.out.println("Se desconecto");
		}

	}

	@Override
	public Optional<String> datos() {
		// TODO Auto-generated method stub
		return null;
	}

}

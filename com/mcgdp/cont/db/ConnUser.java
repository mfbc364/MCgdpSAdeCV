package mcgdp.cont.db;

import java.io.File;
import java.sql.*;
import javax.swing.*;

public class ConnUser {
	// Parámetros de conexión
	private String bdName = "\\db\\users.db";
	private final String basePath = new File("").getAbsolutePath();
	private final String url = "jdbc:sqlite:" + basePath + bdName;
	private static JFrame frmSQL;
	
	// Objeto de conexión
	Connection conn = null;
	
	// Constructor
	public ConnUser() {
		try {
			Class.forName("org.sqlite.JDBC");														// Se obtiene driver
			
			conn = DriverManager.getConnection(url);												// Se obtiene conexión
			if(conn != null) {																		// Conexión hallada
				System.out.println("Conexión exitosa.");
			}
			else {																					// Conexión es null
				System.out.println("Conexión fallida. Datos no localizados");
			}
		} 
		catch (ClassNotFoundException e) {															// Errores de clase
			JOptionPane.showMessageDialog(frmSQL, "Error Fatal: " + e.getMessage() 
			+ ", contacte a soporte técnico.", "Auxiliar Contable", JOptionPane.ERROR_MESSAGE);
			System.out.println("Error Fatal: " + e.getMessage());
		} 
		catch (SQLException e) {																	// Errores de BD
			JOptionPane.showMessageDialog(frmSQL, "Error Fatal: " + e.getMessage() 
			+ ", contacte a soporte técnico.", "Auxiliar Contable", JOptionPane.ERROR_MESSAGE);
			System.out.println("Error Fatal: " + e.getMessage());
		}
	}
	
	// Desconexión de base de datos
		public void disconnect() {
			conn = null;
		}
	
	// Getter de conexión
	public Connection getConnection( ) {
		return conn;
	}
}

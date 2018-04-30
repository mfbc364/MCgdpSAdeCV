// #################################################################################################################### //
package mcgdp.cont.db;

import java.io.File;
import java.sql.*;
import javax.swing.*;

public class ConnDB {
	// Objeto de conexión
	private Connection conn = null;
	
	// Directorio padre de directorio db
	private final String basePath = new File("").getAbsolutePath();
	
	// Constructor
	public ConnDB(String bdName) {
		try {
			// Parámetros de conexión
			final String url = "jdbc:sqlite:" + getBasePath() + bdName;
			
			Class.forName("org.sqlite.JDBC");														// Se obtiene driver
			
			setConn(DriverManager.getConnection(url));												// Se obtiene conexión
			if(getConn() != null) {																	// Conexión hallada
				System.out.println("SQL [INFO]: Conexión exitosa.");
			}
			else {																					// Conexión es null
				System.out.println("SQL [ERROR]: Conexión fallida. DB no localizada.");
			}
		} 
		catch (ClassNotFoundException e) {															// Errores de clase
			JOptionPane.showMessageDialog(null, "Error Fatal en clase: " + e.getMessage() 
			+ ", contacte a soporte técnico.", "Auxiliar Contable", JOptionPane.ERROR_MESSAGE);
			System.out.println("SQL [FATAL]: Error Fatal: " + e.getMessage());
			e.printStackTrace();
		} 
		catch (SQLException e) {																	// Errores de BD
			JOptionPane.showMessageDialog(null, "Error Fatal en DB: " + e.getMessage() 
			+ ", contacte a soporte técnico.", "Auxiliar Contable", JOptionPane.ERROR_MESSAGE);
			System.out.println("SQL [FATAL] Error Fatal: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	// Desconexión de base de datos
	public void disconnect() {
		System.out.println("SQL [INFO]: Conexión cerrada.");
		setConn(null);
	}
	
	// Getter de conexión
	public Connection getConnection() {
		return conn;
	}
	
	// Getters
	private Connection getConn() {
		return conn;
	}
	
	private String getBasePath() {
		return basePath;
	}
	
	// Setters
	private void setConn(Connection conn) {
		this.conn = conn;
	}
}
// #################################################################################################################### //
// ################################################################################################################### //
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
				System.out.println("SQL [INFO]: Conexión exitosa.");
			}
			else {																					// Conexión es null
				System.out.println("SQL [ERROR]: Conexión fallida. DB no localizada.");
			}
		} 
		catch (ClassNotFoundException e) {															// Errores de clase
			JOptionPane.showMessageDialog(frmSQL, "Error Fatal en clase: " + e.getMessage() 
			+ ", contacte a soporte técnico.", "Auxiliar Contable", JOptionPane.ERROR_MESSAGE);
			System.out.println("SQL [FATAL]: Error Fatal: " + e.getMessage());
			e.printStackTrace();
		} 
		catch (SQLException e) {																	// Errores de BD
			JOptionPane.showMessageDialog(frmSQL, "Error Fatal en DB: " + e.getMessage() 
			+ ", contacte a soporte técnico.", "Auxiliar Contable", JOptionPane.ERROR_MESSAGE);
			System.out.println("SQL [FATAL] Error Fatal: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	// Desconexión de base de datos
		public void disconnect() {
			System.out.println("SQL [INFO]: Conexión cerrada.");
			conn = null;
		}
	
	// Getter de conexión
	public Connection getConnection() {
		return conn;
	}
}
// ################################################################################################################### //
// ##################################################################################################################################### //
package mcgdp.cont.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import mcgdp.cont.db.ConnDB;
import mcgdp.cont.db.vo.User;

public class Users {
	public ArrayList<User> consListaUsuarios() {
		ArrayList<User> usersList = new ArrayList<>();																// Arreglo de usuarios
		
		Connection conn = null;																						// Conexión con DB
		ConnDB uconn = new ConnDB("\\db\\users.db");																// Ubicación de DB
		PreparedStatement ps = null;																				// Acciones de DB
		ResultSet rs = null;																						// Resultados de DB
		
		User usuario;																								// Objeto Usuario
		
		conn = uconn.getConnection();																				// Iniciando conexión
		System.out.println("SQL_Users [INFO]: Consultando DB Users...");
		
		String cons = "SELECT * FROM usuarios;";																	// Consulta en DB
		
		try {
			if(conn != null) {
				ps = conn.prepareStatement(cons);
				rs = ps.executeQuery();
			}
			
			while(rs.next() == true) {																				// Guardando resultados
				usuario = new User();																				// de DB en arreglo
				usuario.setUsuario(rs.getString("Usuario"));
				usuario.setPassword(rs.getString("Password"));
				usuario.setRol(rs.getString("Rol"));
				usuario.setPuesto(rs.getString("Puesto"));
				usuario.setID(rs.getInt("ID"));
				
				usersList.add(usuario);
			}
		}
		catch(SQLException s) {																						// Errores
			System.out.println("SQL_Users [FATAL]: Error en la consulta: "+s.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la consulta: "+s.getMessage(), "Auxiliar Contable", 
					JOptionPane.ERROR_MESSAGE);
			s.printStackTrace();
		}
		finally
		{
			try {
				System.out.println("SQL_Users [INFO]: Cerrando consulta...");										// Cerrando conexión
				conn.close();
			    uconn.disconnect();
			   } 
			catch (SQLException e) {																				// Errores
				System.out.println("SQL_Users [FATAL]: Error al cerrar DB: "+e.getMessage());
				JOptionPane.showMessageDialog(null, "Error en la consulta: "+e.getMessage(), "Auxiliar Contable", 
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			   }
			  }
		return usersList;
	}
}
// ##################################################################################################################################### //
package mcgdp.cont.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import mcgdp.cont.db.ConnUser;
import mcgdp.cont.db.vo.User;

public class Users {
	public ArrayList<User> consListaUsuarios() {
		ArrayList<User> usersList = new ArrayList<>();
		
		Connection conn = null;
		ConnUser uconn = new ConnUser();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		User usuario;
		
		conn = uconn.getConnection();
		System.out.println("SQL_Users [INFO]: Consultando DB Users");
		
		String cons = "SELECT uID, usuarios, password, rol FROM usuarios;";
		
		try {
			if(conn != null) {
				ps = conn.prepareStatement(cons);
				rs = ps.executeQuery();
			}
			
			while(rs.next() == true) {
				usuario = new User();
				usuario.setUID(rs.getInt("uID"));
				usuario.setUsuarios(rs.getString("usuarios"));
				usuario.setPassword(rs.getString("password"));
				usuario.setRol(rs.getString("rol"));
				
				usersList.add(usuario);
			}
		}
		catch(SQLException s) {
			System.out.println("SQL_Users [FATAL]: Error en la consulta: "+s.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la consulta: "+s.getMessage(), "Auxiliar Contable", 
					JOptionPane.ERROR_MESSAGE);
			s.printStackTrace();
		}
		finally
		{
			try {
				System.out.println("SQL_Users [INFO]: Cerrando consulta...");
				conn.close();
			    uconn.disconnect();
			   } 
			catch (SQLException e) {
				System.out.println("SQL_Users [FATAL]: Error al cerrar DB: "+e.getMessage());
				JOptionPane.showMessageDialog(null, "Error en la consulta: "+e.getMessage(), "Auxiliar Contable", 
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			   }
			  }
		return usersList;
	}
}
// ####################################################################################################### //
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
			System.out.println("Error en la consulta: "+s.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la consulta: "+s.getMessage(), "Auxiliar Contable", 
					JOptionPane.ERROR_MESSAGE);
		}
		finally
		{
			try {
			    conn.close();
			    uconn.disconnect();
			   } catch (SQLException e) {
			    e.printStackTrace();
			   }
			  }
			  return usersList;
	}
}
// ####################################################################################################### //
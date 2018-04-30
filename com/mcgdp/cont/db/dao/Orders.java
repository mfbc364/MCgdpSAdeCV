package mcgdp.cont.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import mcgdp.cont.db.ConnDB;
import mcgdp.cont.db.vo.Order;

public class Orders {
	public ArrayList<Order> consOrdenes() {
		Connection conn = null;																					// Conexión con DB
		final ConnDB uconn = new ConnDB("\\db\\business.db");													// Ubicación de DB
		PreparedStatement ps = null;																			// Acciones de DB
		ResultSet rs = null;																					// Resultados de DB
		ArrayList<Order> usersList = new ArrayList<>();															// Arreglo de usuarios
		
		Order orden;																							// Objeto Usuario
		
		conn = uconn.getConnection();																			// Iniciando conexión
		System.out.println("SQL_Orders [INFO]: Consultando DB Business...");
		
		String cons = "SELECT * FROM ordenes;";																	// Consulta en DB
		
		try {
			if(conn != null) {
				ps = conn.prepareStatement(cons);
				rs= ps.executeQuery();
			}
			
			while(rs.next() == true) {																			// Guardando resultados
				try {	
					orden = new Order();																		// de DB en arreglo
					orden.setOrderNumber(rs.getString("OrderNumber"));
					orden.setEmissionDate(new SimpleDateFormat("yyyy-MM-dd").
							parse(rs.getString("EmissionDate")));
					orden.setEmissionResponsible(rs.getString("EmissionResponsible"));
					orden.setProvider(rs.getString("Provider"));
					orden.setAddress(rs.getString("Adress"));
					orden.setColony(rs.getString("Colony"));
					orden.setCity(rs.getString("City"));
					orden.setPostalCode(rs.getInt("PostalCode"));
					orden.setCountry(rs.getString("Country"));
					orden.setQty(rs.getInt("Qty"));
					orden.setMUnit(rs.getString("MUnit"));
					orden.setDescription(rs.getString("Description"));
					orden.setUnitPrice(rs.getInt("UnitPrice"));
					orden.setTotal(rs.getInt("Total"));
					orden.setBadge(rs.getString("Badge"));
					orden.setStatus(rs.getString("Status"));
					
					usersList.add(orden);
				}
				catch(Exception err) {
					System.out.println("SQL_Orders [FATAL]: Error en la consulta: "+err.getMessage());
					JOptionPane.showMessageDialog(null, "Error en la consulta: "+err.getMessage(), 
							"Auxiliar Contable", JOptionPane.ERROR_MESSAGE);
					err.printStackTrace();
				}
			}
		}
		catch(SQLException s) {																						// Errores
			System.out.println("SQL_Orders [FATAL]: Error en la consulta: "+s.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la consulta: "+s.getMessage(), "Auxiliar Contable", 
					JOptionPane.ERROR_MESSAGE);
			s.printStackTrace();
		}
		finally
		{
			try {
				System.out.println("SQL_Orders [INFO]: Cerrando consulta...");										// Cerrando conexión
				conn.close();
			    uconn.disconnect();
			}
			catch (SQLException e) {																				// Errores
				System.out.println("SQL_Orders [FATAL]: Error al cerrar DB: "+e.getMessage());
				JOptionPane.showMessageDialog(null, "Error en la consulta: "+e.getMessage(), "Auxiliar Contable", 
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
		return usersList;
	}
}

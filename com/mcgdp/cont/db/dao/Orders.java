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
		final ConnDB oconn = new ConnDB("\\db\\business.db");													// Ubicación de DB
		PreparedStatement ps = null;																			// Acciones de DB
		ResultSet rs = null;																					// Resultados de DB
		ArrayList<Order> ordersList = new ArrayList<>();															// Arreglo de usuarios
		
		Order orden;																							// Objeto Usuario
		
		conn = oconn.getConnection();																			// Iniciando conexión
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
					orden.setEmissionDate(new SimpleDateFormat("dd-MM-yyyy").
							parse(rs.getString("EmissionDate")));
					orden.setEmissionResponsible(rs.getString("EmissionResponsible"));
					orden.setProvider(rs.getString("Provider"));
					orden.setAddress(rs.getString("Adress"));
					orden.setColony(rs.getString("Colony"));
					orden.setCity(rs.getString("City"));
					orden.setPostalCode(Integer.parseInt(rs.getString("PostalCode")));
					orden.setCountry(rs.getString("Country"));
					orden.setQty(Integer.parseInt(rs.getString("Qty")));
					orden.setMUnit(rs.getString("MUnit"));
					orden.setDescription(rs.getString("Description"));
					orden.setUnitPrice(Integer.parseInt(rs.getString("UnitPrice")));
					orden.setTotal(Integer.parseInt(rs.getString("Total")));
					orden.setBadge(rs.getString("Badge"));
					orden.setStatus(rs.getString("Status"));
					
					ordersList.add(orden);
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
			    oconn.disconnect();
			}
			catch (SQLException e) {																				// Errores
				System.out.println("SQL_Orders [FATAL]: Error al cerrar DB: "+e.getMessage());
				JOptionPane.showMessageDialog(null, "Error en la consulta: "+e.getMessage(), "Auxiliar Contable", 
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
		return ordersList;
	}
}

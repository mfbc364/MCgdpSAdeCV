package mcgdp.cont.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import mcgdp.cont.db.ConnDB;
import mcgdp.cont.db.vo.Fact;

public class Facts {
	public ArrayList<Fact> consFacturas(String cons) {
		Connection conn = null;																					// Conexión con DB
		final ConnDB tconn = new ConnDB("\\db\\business.db");													// Ubicación de DB
		PreparedStatement ps = null;																			// Acciones de DB
		ResultSet rs = null;																					// Resultados de DB
		ArrayList<Fact> factsList = new ArrayList<>();															// Arreglo de usuarios
		
		Fact factura;																							// Objeto Usuario
		
		conn = tconn.getConnection();																			// Iniciando conexión
		System.out.println("SQL_Facts [INFO]: Consultando DB Business...");
		
		try {
			if(conn != null) {
				ps = conn.prepareStatement(cons);
				rs= ps.executeQuery();
			}
			
			while(rs.next() == true) {																			// Guardando resultados
				try {	
					factura = new Fact();																		// de DB en arreglo
					factura.setRFC(rs.getString("RFC"));
					factura.setClientName(rs.getString("ClientName"));
					factura.setEmissionDate(new SimpleDateFormat("dd-MM-yyyy").
							parse(rs.getString("EmissionDate")));
					factura.setAddress(rs.getString("Address"));
					factura.setColony(rs.getString("Colony"));
					factura.setCity(rs.getString("City"));
					factura.setPostalCode(Integer.parseInt(rs.getString("PostalCode")));
					factura.setCountry(rs.getString("Country"));
					factura.setDescription(rs.getString("Description"));
					factura.setQty(Integer.parseInt(rs.getString("Qty")));
					factura.setMUnit(rs.getString("MUnit"));
					factura.setUnitPrice(Integer.parseInt(rs.getString("UnitPrice")));
					factura.setTaxes(Integer.parseInt(rs.getString("Taxes")));
					factura.setTotal(Integer.parseInt(rs.getString("Total")));
					factura.setBadge(rs.getString("Badge"));
					factura.setPayType(rs.getString("PayType"));
					factura.setPayMethod(rs.getString("PayMethod"));
					factura.setStatus(rs.getString("Status"));
					
					factsList.add(factura);
				}
				catch(Exception err) {
					System.out.println("SQL_Facts [FATAL]: Error en la consulta: "+err.getMessage());
					JOptionPane.showMessageDialog(null, "Error en la consulta: "+err.getMessage(), 
							"Auxiliar Contable", JOptionPane.ERROR_MESSAGE);
					err.printStackTrace();
				}
			}
		}
		catch(SQLException s) {																						// Errores
			System.out.println("SQL_Facts [FATAL]: Error en la consulta: "+s.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la consulta: "+s.getMessage(), "Auxiliar Contable", 
					JOptionPane.ERROR_MESSAGE);
			s.printStackTrace();
		}
		finally
		{
			try {
				System.out.println("SQL_Facts [INFO]: Cerrando consulta...");										// Cerrando conexión
				conn.close();
			    tconn.disconnect();
			}
			catch (SQLException e) {																				// Errores
				System.out.println("SQL_Facts [FATAL]: Error al cerrar DB: "+e.getMessage());
				JOptionPane.showMessageDialog(null, "Error en la consulta: "+e.getMessage(), "Auxiliar Contable", 
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
		return factsList;
	}
}

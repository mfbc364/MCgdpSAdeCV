// ############################################################################################################################ //
package mcgdp.cont.process;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import mcgdp.cont.db.dao.Facts;
import mcgdp.cont.db.dao.Orders;
import mcgdp.cont.db.vo.Fact;
import mcgdp.cont.db.vo.Order;

public class Load {
	public String[][] obtenerMatrizOrders(String status) {											// Obteniendo datos
		System.out.println("Load_Orders [INFO]: Cargando...");
		Orders ordenes = new Orders();
		ArrayList<Order> listaOrders = ordenes.consOrdenes();
		ArrayList<Integer> pos = new ArrayList<Integer>();
		
		int m = 0;
		
		for(int j= 0; j < listaOrders.size(); j++) {
			if(listaOrders.get(j).getStatus().equals(status)) {										// Encontrando tamaño de filas
				pos.add(j);																			// Se agrega posición de dato
			}
		}
		
		String matrizData[][] = new String[pos.size()][15];
		
		try {
			for(int i = 0; i < listaOrders.size(); i++) {											// Recorriendo arreglo
				if(pos.contains(i)) {																// Si la posición es la actual
					if(listaOrders.get(i).getStatus().equals(status)) {								// Si el status recibido
						matrizData[m][0] = listaOrders.get(i).getOrderNumber()+"";					// es verdadero
						matrizData[m][1] = listaOrders.get(i).getEmissionDate().toString()+"";
						matrizData[m][2] = listaOrders.get(i).getEmissionResponsible()+"";
						matrizData[m][3] = listaOrders.get(i).getProvider()+"";
						matrizData[m][4] = listaOrders.get(i).getAddress()+"";
						matrizData[m][5] = listaOrders.get(i).getColony()+"";
						matrizData[m][6] = listaOrders.get(i).getCity()+"";
						matrizData[m][7] = listaOrders.get(i).getPostalCode().toString()+"";
						matrizData[m][8] = listaOrders.get(i).getCountry()+"";
						matrizData[m][9] = listaOrders.get(i).getDescription()+"";
						matrizData[m][10] = listaOrders.get(i).getMUnit()+"";
						matrizData[m][11] = listaOrders.get(i).getQty().toString()+"";
						matrizData[m][12] = "$"+listaOrders.get(i).getUnitPrice().toString()+"";
						matrizData[m][13] = "$"+listaOrders.get(i).getTotal().toString()+"";
						matrizData[m][14] = listaOrders.get(i).getBadge()+"";
					}
					m++;
				}
			}
		}
		catch(Exception e) {
			System.out.println("Load_Orders [FATAL]: Error Fatal: " + e.getMessage() +				// Errores
					e.getCause());
			JOptionPane.showMessageDialog(null, 
					"Error Fatal, contacte a soporte técnico", "Auxiliar Contable", 
					JOptionPane.ERROR_MESSAGE);
		}
		System.out.println("Load [INFO]: Cargado.");
		return matrizData;
	}
	
	public String[][] obtenerMatrizPays(String status) {											// Obteniendo datos
		System.out.println("Load_Pays [INFO]: Cargando...");
		Facts facturas = new Facts();
		ArrayList<Fact> listaFacts = facturas.consFacturas("SELECT * FROM cobros;");
		ArrayList<Integer> pos = new ArrayList<Integer>();
		
		int m = 0;
		
		for(int j= 0; j < listaFacts.size(); j++) {
			if(listaFacts.get(j).getStatus().equals(status)) {										// Encontrando tamaño de filas
				pos.add(j);																			// Se agrega posición de dato
			}
		}
		
		String matrizData[][] = new String[pos.size()][17];
		
		try {
			for(int i = 0; i < listaFacts.size(); i++) {											// Recorriendo arreglo
				if(pos.contains(i)) {																// Si la posición es la actual
					if(listaFacts.get(i).getStatus().equals(status)) {								// Si el status recibido
						matrizData[m][0] = listaFacts.get(i).getRFC()+"";							// es verdadero
						matrizData[m][1] = listaFacts.get(i).getClientName()+"";
						matrizData[m][2] = listaFacts.get(i).getEmissionDate().toString()+"";
						matrizData[m][3] = listaFacts.get(i).getAddress()+"";
						matrizData[m][4] = listaFacts.get(i).getColony()+"";
						matrizData[m][5] = listaFacts.get(i).getCity()+"";
						matrizData[m][6] = listaFacts.get(i).getPostalCode().toString()+"";
						matrizData[m][7] = listaFacts.get(i).getCountry()+"";
						matrizData[m][8] = listaFacts.get(i).getDescription()+"";
						matrizData[m][9] = listaFacts.get(i).getQty().toString()+"";
						matrizData[m][10] = listaFacts.get(i).getMUnit()+"";
						matrizData[m][11] = "$"+listaFacts.get(i).getUnitPrice().toString()+"";
						matrizData[m][12] = "$"+listaFacts.get(i).getTaxes().toString()+"";
						matrizData[m][13] = "$"+listaFacts.get(i).getTotal().toString()+"";
						matrizData[m][14] = listaFacts.get(i).getBadge()+"";
						matrizData[m][15] = listaFacts.get(i).getPayType()+"";
						matrizData[m][16] = listaFacts.get(i).getPayMethod()+"";
					}
					m++;
				}
			}
		}
		catch(Exception e) {
			System.out.println("Load_Pays [FATAL]: Error Fatal: " + e.getMessage() +				// Errores
					e.getCause());
			JOptionPane.showMessageDialog(null, 
					"Error Fatal, contacte a soporte técnico", "Auxiliar Contable", 
					JOptionPane.ERROR_MESSAGE);
		}
		System.out.println("Load_Pays [INFO]: Cargado.");
		return matrizData;
	}
	
	public String[][] obtenerMatrizBills(String status) {											// Obteniendo datos
		System.out.println("Load_Bills [INFO]: Cargando...");
		Facts facturas = new Facts();
		ArrayList<Fact> listaFacts = facturas.consFacturas("SELECT * FROM pagos;");
		ArrayList<Integer> pos = new ArrayList<Integer>();
		
		int m = 0;
		
		for(int j= 0; j < listaFacts.size(); j++) {
			if(listaFacts.get(j).getStatus().equals(status)) {										// Encontrando tamaño de filas
				pos.add(j);																			// Se agrega posición de dato
			}
		}
		
		String matrizData[][] = new String[pos.size()][17];
		
		try {
			for(int i = 0; i < listaFacts.size(); i++) {											// Recorriendo arreglo
				if(pos.contains(i)) {																// Si la posición es la actual
					if(listaFacts.get(i).getStatus().equals(status)) {								// Si el status recibido
						matrizData[m][0] = listaFacts.get(i).getRFC()+"";							// es verdadero
						matrizData[m][1] = listaFacts.get(i).getClientName()+"";
						matrizData[m][2] = listaFacts.get(i).getEmissionDate().toString()+"";
						matrizData[m][3] = listaFacts.get(i).getAddress()+"";
						matrizData[m][4] = listaFacts.get(i).getColony()+"";
						matrizData[m][5] = listaFacts.get(i).getCity()+"";
						matrizData[m][6] = listaFacts.get(i).getPostalCode().toString()+"";
						matrizData[m][7] = listaFacts.get(i).getCountry()+"";
						matrizData[m][8] = listaFacts.get(i).getDescription()+"";
						matrizData[m][9] = listaFacts.get(i).getQty().toString()+"";
						matrizData[m][10] = listaFacts.get(i).getMUnit()+"";
						matrizData[m][11] = "$"+listaFacts.get(i).getUnitPrice().toString()+"";
						matrizData[m][12] = "$"+listaFacts.get(i).getTaxes().toString()+"";
						matrizData[m][13] = "$"+listaFacts.get(i).getTotal().toString()+"";
						matrizData[m][14] = listaFacts.get(i).getBadge()+"";
						matrizData[m][15] = listaFacts.get(i).getPayType()+"";
						matrizData[m][16] = listaFacts.get(i).getPayMethod()+"";
					}
					m++;
				}
			}
		}
		catch(Exception e) {
			System.out.println("Load_Bills [FATAL]: Error Fatal: " + e.getMessage() +				// Errores
					e.getCause());
			JOptionPane.showMessageDialog(null, 
					"Error Fatal, contacte a soporte técnico", "Auxiliar Contable", 
					JOptionPane.ERROR_MESSAGE);
		}
		System.out.println("Load_Bills [INFO]: Cargado.");
		return matrizData;
	}
}
//############################################################################################################################ //
package mcgdp.cont.process;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import mcgdp.cont.db.dao.*;
import mcgdp.cont.db.vo.*;

public class SearchDB {
	public String[][] obtenerMatrizOrders(String search, String filter) {							// Obteniendo datos
		System.out.println("Search_DB_Orders [INFO]: Buscando en Ordenes de Compra...");
		Orders ordenes = new Orders();
		ArrayList<Order> listaOrders = ordenes.consOrdenes();
		ArrayList<Integer> pos = new ArrayList<Integer>();
		int m = 0;
		int i = 0;
		int j = 0;
		boolean getPos = false;
		boolean getData = false;
		
		switch(filter) {																			// Obteniendo filtro
			case "Número de orden":																	// En cada case se ejecuta
				getPos = listaOrders.get(j).getOrderNumber().equals(search);						// el metodo correspondiente
				getData = listaOrders.get(i).getOrderNumber().equals(search);						// a cada filtro
				break;
			case "Fecha de emisión":
				getPos = listaOrders.get(j).getEmissionDate().equals(search);
				getData = listaOrders.get(i).getEmissionDate().equals(search);
				break;
			case "Encargado de emisión":
				getPos = listaOrders.get(j).getEmissionResponsible().equals(search);
				getData = listaOrders.get(i).getEmissionResponsible().equals(search);
				break;
			case "Proveedor":
				getPos = listaOrders.get(j).getProvider().equals(search);
				getData = listaOrders.get(i).getProvider().equals(search);
				break;
			case "Dirección":
				getPos = listaOrders.get(j).getAddress().equals(search);
				getData = listaOrders.get(i).getAddress().equals(search);
				break;
			case "Colonia":
				getPos = listaOrders.get(j).getColony().equals(search);
				getData = listaOrders.get(i).getColony().equals(search);
				break;
			case "Ciudad":
				getPos = listaOrders.get(j).getCity().equals(search);
				getData = listaOrders.get(i).getCity().equals(search);
				break;
			case "Código Postal":
				getPos = listaOrders.get(j).getPostalCode().equals(Integer.parseInt(search));
				getData = listaOrders.get(i).getPostalCode().equals(Integer.parseInt(search));
				break;
			case "Pais":
				getPos = listaOrders.get(j).getCountry().equals(search);
				getData = listaOrders.get(i).getCountry().equals(search);
				break;
			case "Descripción":
				getPos = listaOrders.get(j).getDescription().equals(search);
				getData = listaOrders.get(i).getDescription().equals(search);
				break;
			case "Unidad de medida":
				getPos = listaOrders.get(j).getMUnit().equals(search);
				getData = listaOrders.get(i).getMUnit().equals(search);
				break;
			case "Cantidad":
				getPos = listaOrders.get(j).getQty().equals(Integer.parseInt(search));
				getData = listaOrders.get(i).getQty().equals(Integer.parseInt(search));
				break;
			case "Precio Unitario":
				getPos = listaOrders.get(j).getUnitPrice().equals(Integer.parseInt(search));
				getData = listaOrders.get(i).getUnitPrice().equals(Integer.parseInt(search));
				break;
			case "Total":
				getPos = listaOrders.get(j).getTotal().equals(Integer.parseInt(search));
				getData = listaOrders.get(i).getTotal().equals(Integer.parseInt(search));
				break;
			case "Divisa":
				getPos = listaOrders.get(j).getBadge().equals(search);
				getData = listaOrders.get(i).getBadge().equals(search);
				break;
		}
		
		for(j= 0; j < listaOrders.size(); j++) {
			if(getPos == true) {																	// Encontrando tamaño de filas
				pos.add(j);																			// Se agrega posición de dato
			}
		}
		
		String matrizData[][] = new String[pos.size()][15];
		
		try {
			for(i = 0; i < listaOrders.size(); i++) {												// Recorriendo arreglo
				if(pos.contains(i)) {																// Si la posición es la actual
					if(getData == true) {															// Si el status recibido
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
			System.out.println("Search_DB_Orders [FATAL]: Error Fatal: " + e.getMessage() +			// Errores
					e.getCause());
			JOptionPane.showMessageDialog(null, 
					"Error Fatal, contacte a soporte técnico", "Auxiliar Contable", 
					JOptionPane.ERROR_MESSAGE);
		}
		System.out.println("Search_DB_Orders [INFO]: Encontrado(s).");
		return matrizData;
	}
	
	public String[][] obtenerMatrizPays(String search, String filter) {								// Obteniendo datos
		System.out.println("Search_DB_Pays [INFO]: Buscando en Cuentas por Cobrar...");
		Facts facturas = new Facts();
		ArrayList<Fact> listaFacts = facturas.consFacturas("SELECT * FROM cobros;");
		ArrayList<Integer> pos = new ArrayList<Integer>();
		int m = 0;
		int i = 0;
		int j = 0;
		boolean getPos = false;
		boolean getData = false;
		
		switch(filter) {																			// Obteniendo filtro
			case "RFC":																				// En cada case se ejecuta
				getPos = listaFacts.get(j).getRFC().equals(search);									// el metodo correspondiente
				getData = listaFacts.get(i).getRFC().equals(search);								// a cada filtro
				break;
			case "Cliente":
				getPos = listaFacts.get(j).getClientName().equals(search);
				getData = listaFacts.get(i).getClientName().equals(search);
				break;
			case "Fecha de emisión":
				getPos = listaFacts.get(j).getEmissionDate().equals(search);
				getData = listaFacts.get(i).getEmissionDate().equals(search);
				break;
			case "Dirección":
				getPos = listaFacts.get(j).getAddress().equals(search);
				getData = listaFacts.get(i).getAddress().equals(search);
				break;
			case "Colonia":
				getPos = listaFacts.get(j).getColony().equals(search);
				getData = listaFacts.get(i).getColony().equals(search);
				break;
			case "Ciudad":
				getPos = listaFacts.get(j).getCity().equals(search);
				getData = listaFacts.get(i).getCity().equals(search);
				break;
			case "Código Postal":
				getPos = listaFacts.get(j).getPostalCode().equals(Integer.parseInt(search));
				getData = listaFacts.get(i).getPostalCode().equals(Integer.parseInt(search));
				break;
			case "Pais":
				getPos = listaFacts.get(j).getCountry().equals(search);
				getData = listaFacts.get(i).getCountry().equals(search);
				break;
			case "Descripción":
				getPos = listaFacts.get(j).getDescription().equals(search);
				getData = listaFacts.get(i).getDescription().equals(search);
				break;
			case "Cantidad":
				getPos = listaFacts.get(j).getQty().equals(Integer.parseInt(search));
				getData = listaFacts.get(i).getQty().equals(Integer.parseInt(search));
				break;
			case "Unidad de medida":
				getPos = listaFacts.get(j).getMUnit().equals(search);
				getData = listaFacts.get(i).getMUnit().equals(search);
				break;
			case "Precio Unitario":
				getPos = listaFacts.get(j).getUnitPrice().equals(Integer.parseInt(search));
				getData = listaFacts.get(i).getUnitPrice().equals(Integer.parseInt(search));
				break;
			case "Impuestos":
				getPos = listaFacts.get(j).getTaxes().equals(Integer.parseInt(search));
				getData = listaFacts.get(i).getTaxes().equals(Integer.parseInt(search));
				break;
			case "Total":
				getPos = listaFacts.get(j).getTotal().equals(Integer.parseInt(search));
				getData = listaFacts.get(i).getTotal().equals(Integer.parseInt(search));
				break;
			case "Divisa":
				getPos = listaFacts.get(j).getBadge().equals(search);
				getData = listaFacts.get(i).getBadge().equals(search);
				break;
			case "Tipo de Pago":
				getPos = listaFacts.get(j).getPayType().equals(search);
				getData = listaFacts.get(i).getPayType().equals(search);
				break;
			case "Método de Pago":
				getPos = listaFacts.get(j).getPayMethod().equals(search);
				getData = listaFacts.get(i).getPayMethod().equals(search);
				break;
		}
		
		for(j= 0; j < listaFacts.size(); j++) {
			if(getPos == true) {																	// Encontrando tamaño de filas
				pos.add(j);																			// Se agrega posición de dato
			}
		}
		
		String matrizData[][] = new String[pos.size()][17];
		
		try {
			for(i = 0; i < listaFacts.size(); i++) {												// Recorriendo arreglo
				if(pos.contains(i)) {																// Si la posición es la actual
					if(getData == true) {															// Si el status recibido
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
			System.out.println("Search_DB_Pays [FATAL]: Error Fatal: " + e.getMessage() +			// Errores
					e.getCause());
			JOptionPane.showMessageDialog(null, 
					"Error Fatal, contacte a soporte técnico", "Auxiliar Contable", 
					JOptionPane.ERROR_MESSAGE);
		}
		System.out.println("Search_DB_Pays [INFO]: Encontrado(s).");
		return matrizData;
	}
	
	public String[][] obtenerMatrizBills(String search, String filter) {							// Obteniendo datos
		System.out.println("Search_DB_Bills [INFO]: Buscando en Cuentas por Cobrar...");
		Facts facturas = new Facts();
		ArrayList<Fact> listaFacts = facturas.consFacturas("SELECT * FROM cobros;");
		ArrayList<Integer> pos = new ArrayList<Integer>();
		int m = 0;
		int i = 0;
		int j = 0;
		boolean getPos = false;
		boolean getData = false;
		
		switch(filter) {																			// Obteniendo filtro
			case "RFC":																				// En cada case se ejecuta
				getPos = listaFacts.get(j).getRFC().equals(search);									// el metodo correspondiente
				getData = listaFacts.get(i).getRFC().equals(search);								// a cada filtro
				break;
			case "Proveedor":
				getPos = listaFacts.get(j).getClientName().equals(search);
				getData = listaFacts.get(i).getClientName().equals(search);
				break;
			case "Fecha de emisión":
				getPos = listaFacts.get(j).getEmissionDate().equals(search);
				getData = listaFacts.get(i).getEmissionDate().equals(search);
				break;
			case "Dirección":
				getPos = listaFacts.get(j).getAddress().equals(search);
				getData = listaFacts.get(i).getAddress().equals(search);
				break;
			case "Colonia":
				getPos = listaFacts.get(j).getColony().equals(search);
				getData = listaFacts.get(i).getColony().equals(search);
				break;
			case "Ciudad":
				getPos = listaFacts.get(j).getCity().equals(search);
				getData = listaFacts.get(i).getCity().equals(search);
				break;
			case "Código Postal":
				getPos = listaFacts.get(j).getPostalCode().equals(Integer.parseInt(search));
				getData = listaFacts.get(i).getPostalCode().equals(Integer.parseInt(search));
				break;
			case "Pais":
				getPos = listaFacts.get(j).getCountry().equals(search);
				getData = listaFacts.get(i).getCountry().equals(search);
				break;
			case "Descripción":
				getPos = listaFacts.get(j).getDescription().equals(search);
				getData = listaFacts.get(i).getDescription().equals(search);
				break;
			case "Cantidad":
				getPos = listaFacts.get(j).getQty().equals(Integer.parseInt(search));
				getData = listaFacts.get(i).getQty().equals(Integer.parseInt(search));
				break;
			case "Unidad de medida":
				getPos = listaFacts.get(j).getMUnit().equals(search);
				getData = listaFacts.get(i).getMUnit().equals(search);
				break;
			case "Precio Unitario":
				getPos = listaFacts.get(j).getUnitPrice().equals(Integer.parseInt(search));
				getData = listaFacts.get(i).getUnitPrice().equals(Integer.parseInt(search));
				break;
			case "Impuestos":
				getPos = listaFacts.get(j).getTaxes().equals(Integer.parseInt(search));
				getData = listaFacts.get(i).getTaxes().equals(Integer.parseInt(search));
				break;
			case "Total":
				getPos = listaFacts.get(j).getTotal().equals(Integer.parseInt(search));
				getData = listaFacts.get(i).getTotal().equals(Integer.parseInt(search));
				break;
			case "Divisa":
				getPos = listaFacts.get(j).getBadge().equals(search);
				getData = listaFacts.get(i).getBadge().equals(search);
				break;
			case "Tipo de Pago":
				getPos = listaFacts.get(j).getPayType().equals(search);
				getData = listaFacts.get(i).getPayType().equals(search);
				break;
			case "Método de Pago":
				getPos = listaFacts.get(j).getPayMethod().equals(search);
				getData = listaFacts.get(i).getPayMethod().equals(search);
				break;
		}
		
		for(j= 0; j < listaFacts.size(); j++) {
			if(getPos == true) {																	// Encontrando tamaño de filas
				pos.add(j);																			// Se agrega posición de dato
			}
		}
		
		String matrizData[][] = new String[pos.size()][17];
		
		try {
			for(i = 0; i < listaFacts.size(); i++) {												// Recorriendo arreglo
				if(pos.contains(i)) {																// Si la posición es la actual
					if(getData == true) {															// Si el status recibido
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
			System.out.println("Search_DB_Bills [FATAL]: Error Fatal: " + e.getMessage() +			// Errores
					e.getCause());
			JOptionPane.showMessageDialog(null, 
					"Error Fatal, contacte a soporte técnico", "Auxiliar Contable", 
					JOptionPane.ERROR_MESSAGE);
		}
		System.out.println("Search_DB_Bills [INFO]: Encontrado(s).");
		return matrizData;
	}
}

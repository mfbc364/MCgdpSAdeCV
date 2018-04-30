package mcgdp.cont.process;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import mcgdp.cont.db.dao.*;
import mcgdp.cont.db.vo.*;

public class SearchDB {
	public String[][] obtenerMatrizProcess(String search, String filter) {							// Obteniendo datos
		System.out.println("Search [INFO]: Buscando...");
		Orders ordenes = new Orders();
		ArrayList<Order> listaProcess = ordenes.consOrdenes();
		ArrayList<Integer> pos = new ArrayList<Integer>();
		int m = 0;
		int i = 0;
		int j = 0;
		boolean getPos = false;
		boolean getData = false;
		
		switch(filter) {																			// Obteniendo filtro
			case "Número de orden":																	// En cada case se ejecuta
				getPos = listaProcess.get(j).getOrderNumber().equals(search);						// el metodo correspondiente
				getData = listaProcess.get(i).getOrderNumber().equals(search);						// a cada filtro
				break;
			case "Fecha de emisión":
				getPos = listaProcess.get(j).getEmissionDate().equals(search);
				getData = listaProcess.get(i).getEmissionDate().equals(search);
				break;
			case "Encargado de emisión":
				getPos = listaProcess.get(j).getEmissionResponsible().equals(search);
				getData = listaProcess.get(i).getEmissionResponsible().equals(search);
				break;
			case "Proveedor":
				getPos = listaProcess.get(j).getProvider().equals(search);
				getData = listaProcess.get(i).getProvider().equals(search);
				break;
			case "Dirección":
				getPos = listaProcess.get(j).getAddress().equals(search);
				getData = listaProcess.get(i).getAddress().equals(search);
				break;
			case "Colonia":
				getPos = listaProcess.get(j).getColony().equals(search);
				getData = listaProcess.get(i).getColony().equals(search);
				break;
			case "Ciudad":
				getPos = listaProcess.get(j).getCity().equals(search);
				getData = listaProcess.get(i).getCity().equals(search);
				break;
			case "Código Postal":
				getPos = listaProcess.get(j).getPostalCode().equals(search);
				getData = listaProcess.get(i).getPostalCode().equals(search);
				break;
			case "Pais":
				getPos = listaProcess.get(j).getCountry().equals(search);
				getData = listaProcess.get(i).getCountry().equals(search);
				break;
			case "Cantidad":
				getPos = listaProcess.get(j).getQty().equals(search);
				getData = listaProcess.get(i).getQty().equals(search);
				break;
			case "Unidad de medida":
				getPos = listaProcess.get(j).getMUnit().equals(search);
				getData = listaProcess.get(i).getMUnit().equals(search);
				break;
			case "Descripción":
				getPos = listaProcess.get(j).getDescription().equals(search);
				getData = listaProcess.get(i).getDescription().equals(search);
				break;
			case "Precio Unitario":
				getPos = listaProcess.get(j).getUnitPrice().equals(search);
				getData = listaProcess.get(i).getUnitPrice().equals(search);
				break;
			case "Total":
				getPos = listaProcess.get(j).getTotal().equals(search);
				getData = listaProcess.get(i).getTotal().equals(search);
				break;
			case "Divisa":
				getPos = listaProcess.get(j).getBadge().equals(search);
				getData = listaProcess.get(i).getBadge().equals(search);
				break;
		}
		
		for(j= 0; j < listaProcess.size(); j++) {
			if(getPos == true) {																	// Encontrando tamaño de filas
				pos.add(j);																			// Se agrega posición de dato
			}
		}
		
		String matrizData[][] = new String[pos.size()][16];
		
		try {
			for(i = 0; i < listaProcess.size(); i++) {												// Recorriendo arreglo
				if(pos.contains(i)) {																// Si la posición es la actual
					if(getData == true) {															// Si el status recibido
						matrizData[m][0] = listaProcess.get(i).getOrderNumber()+"";					// es verdadero
						matrizData[m][1] = listaProcess.get(i).getEmissionDate().toString()+"";
						matrizData[m][2] = listaProcess.get(i).getEmissionResponsible()+"";
						matrizData[m][3] = listaProcess.get(i).getProvider()+"";
						matrizData[m][4] = listaProcess.get(i).getAddress()+"";
						matrizData[m][5] = listaProcess.get(i).getColony()+"";
						matrizData[m][6] = listaProcess.get(i).getCity()+"";
						matrizData[m][7] = listaProcess.get(i).getPostalCode().toString()+"";
						matrizData[m][8] = listaProcess.get(i).getCountry()+"";
						matrizData[m][9] = listaProcess.get(i).getQty().toString()+"";
						matrizData[m][10] = listaProcess.get(i).getMUnit()+"";
						matrizData[m][11] = listaProcess.get(i).getDescription()+"";
						matrizData[m][12] = "$"+listaProcess.get(i).getUnitPrice().toString()+"";
						matrizData[m][13] = "$"+listaProcess.get(i).getTotal().toString()+"";
						matrizData[m][14] = listaProcess.get(i).getBadge()+"";
						matrizData[m][15] = listaProcess.get(i).getStatus()+"";
					}
					m++;
				}
			}
		}
		catch(Exception e) {
			System.out.println("Search_DB [FATAL]: Error Fatal: " + e.getMessage() +						// Errores
					e.getCause());
			JOptionPane.showMessageDialog(null, 
					"Error Fatal, contacte a soporte técnico", "Auxiliar Contable", 
					JOptionPane.ERROR_MESSAGE);
		}
		System.out.println("Search_DB [INFO]: Encontrado(s).");
		return matrizData;
	}
}

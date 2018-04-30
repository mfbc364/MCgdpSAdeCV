// ############################################################################################################################ //
package mcgdp.cont.process;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import mcgdp.cont.db.dao.Orders;
import mcgdp.cont.db.vo.Order;

public class Load {
	public String[][] obtenerMatrizProcess(String status) {												// Obteniendo datos
		System.out.println("Load [INFO]: Cargando...");
		Orders ordenes = new Orders();
		ArrayList<Order> listaProcess = ordenes.consOrdenes();
		ArrayList<Integer> pos = new ArrayList<Integer>();
		
		int m = 0;
		
		for(int j= 0; j < listaProcess.size(); j++) {
			if(listaProcess.get(j).getStatus().equals(status)) {									// Encontrando tamaño de filas
				pos.add(j);																			// Se agrega posición de dato
			}
		}
		
		String matrizData[][] = new String[pos.size()][15];
		
		try {
			for(int i = 0; i < listaProcess.size(); i++) {											// Recorriendo arreglo
				if(pos.contains(i)) {																// Si la posición es la actual
					if(listaProcess.get(i).getStatus().equals(status)) {							// Si el status recibido
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
					}
					m++;
				}
			}
		}
		catch(Exception e) {
			System.out.println("Load [FATAL]: Error Fatal: " + e.getMessage() +					// Errores
					e.getCause());
			JOptionPane.showMessageDialog(null, 
					"Error Fatal, contacte a soporte técnico", "Auxiliar Contable", 
					JOptionPane.ERROR_MESSAGE);
		}
		System.out.println("Load [INFO]: Cargado.");
		return matrizData;
	}
}
//############################################################################################################################ //
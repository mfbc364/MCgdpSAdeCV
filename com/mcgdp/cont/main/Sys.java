package mcgdp.cont.main;

import javax.swing.JOptionPane;

import mcgdp.cont.GUI.Main.Session;
import mcgdp.cont.GUI.Main.Index;
import mcgdp.cont.process.ProcessLogin;

public class Sys {
	public void init() {
		System.out.println("Iniciando proceso...");
		try {
			// Clases únicas instanciadas
			Session login = new Session();														// Iniciando aplicación
			Core nucleo = new Core();															// Iniciando núcleo
			ProcessLogin procesos = new ProcessLogin();											// Iniciando procesos
			Index inicio = new Index();
			
			// Clases relacionadas con el núcleo
			login.setCore(nucleo);																// Se relaciona con login
			procesos.setCore(nucleo);															// Se relaciona con procesos de login
			inicio.setCore(nucleo);																// Se relaciona con inicio
			
			// Núcleo relacionado con clases
			nucleo.setLogin(login);																// Login se relaciona
			nucleo.setProcess(procesos);														// Procesos de login se relacionan
			nucleo.setIndex(inicio);															// Inicio se relaciona
			
			login.setVisible(true);																// Abriendo ventana
		}
		catch(Exception e) {
			System.out.println("Error Fatal: " + e.getMessage());								// Errores
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error Fatal, contacte a soporte técnico", 
					"Auxiliar Contable", JOptionPane.ERROR_MESSAGE);
			System.out.println("Cerrando proceso...");
			System.exit(0);																		// Matando procesos
		}
	}
}
// ############################################################################################ //
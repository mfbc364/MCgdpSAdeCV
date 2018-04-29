// ############################################################################################################################### //
package mcgdp.cont.main;

import javax.swing.JOptionPane;

import mcgdp.cont.GUI.Main.Session;
import mcgdp.cont.process.ProcessLogin;

public class Sys {
	public void init() {
		System.out.println("System [INFO]: Iniciando proceso...");
		try {
			// Clases únicas instanciadas
			Session login = new Session();														// Iniciando aplicación
			Core nucleo = new Core();															// Iniciando núcleo
			ProcessLogin procesos = new ProcessLogin();											// Iniciando procesos
			
			// Clases relacionadas con el núcleo
			login.setCore(nucleo);																// Se relaciona con login
			procesos.setCore(nucleo);															// Se relaciona con procesos de login
			
			// Núcleo relacionado con clases
			nucleo.setLogin(login);																// Login se relaciona
			nucleo.setProcess(procesos);														// Procesos de login se relacionan
			
			login.setVisible(true);																// Abriendo ventana
		}
		catch(Exception e) {
			System.out.println("System [FATAL]: Error Fatal: " + e.getMessage()	+				// Errores
			e.getCause());
			JOptionPane.showMessageDialog(null, "Error Fatal, contacte a soporte técnico", 
					"Auxiliar Contable", JOptionPane.ERROR_MESSAGE);
			System.out.println("System [INFO]: Cerrando proceso...");
			System.exit(0);																		// Matando procesos
		}
	}
}
// ############################################################################################################################### //
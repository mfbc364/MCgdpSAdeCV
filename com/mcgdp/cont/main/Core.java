package mcgdp.cont.main;

import mcgdp.cont.GUI.Main.Session;
import mcgdp.cont.GUI.Main.Index;
import mcgdp.cont.process.ProcessLogin;

public class Core {
	private Session login;
	private ProcessLogin procesos;
	private Index inicio;

	public void setLogin(Session login) {											// Relación con la sesión
		this.login = login;
	}

	public void setProcess(ProcessLogin procesos) {									// Relación con los procesos de login
		this.procesos = procesos;
	}
	
	public void setIndex(Index inicio) {											// Relación con el inicio
		this.inicio = inicio;
	}

	public String validarDatos(String user, char[] password) {						// Envío y retorno de validación
		procesos.setUser(user);
		procesos.setPass(password);
		return procesos.validarDatos();
	}
	
	// Se valida status de login
	public boolean validarStatus() {
		return procesos.getStatus();
	}
	
	// Cierre de ventana Sesión
	public void closeWS() {
		login.dispose();
	}

	// Limpieza de sesión
	public void cleanP() {
		procesos.setPass(new char[] {});
		procesos.setUser("");
		procesos.setStatus(false);
	}

	public void setRole(String role) {
		inicio.setRole(role);
	}
}
// ############################################################################# //
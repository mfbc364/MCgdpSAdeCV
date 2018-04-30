// ################################################################################################################### //
package mcgdp.cont.main;

import mcgdp.cont.GUI.Main.Session;
import mcgdp.cont.process.ProcessLogin;

public class Core {
	private Session login;
	private ProcessLogin procesos;

	public void setLogin(Session login) {											// Relaci�n con la sesi�n
		this.login = login;
	}

	public void setProcess(ProcessLogin procesos) {									// Relaci�n con los procesos de login
		this.procesos = procesos;
	}

	public String validarDatos(String user, char[] password) {						// Env�o y retorno de validaci�n
		procesos.setUser(user);
		procesos.setPass(password);
		return procesos.validarDatos();
	}
	
	// Se valida status de login
	public boolean validarStatus() {
		return procesos.getStatus();
	}

	public void setRole(String role) {
		login.setRole(role);
	}
}
// ################################################################################################################### //
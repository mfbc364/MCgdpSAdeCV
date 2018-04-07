package mcgdp.cont.process;

import mcgdp.cont.main.Core;

public class ProcessLogin {
	// Parámetros de procesos
	@SuppressWarnings("unused")
	private Core nucleo;
	private String user;
	private String password;
	private String role = "Administrator";
	public String message;
	private boolean status = false;
	private final String sel = "Selecciona...";
	private final String pass = "MCgdp2018*";

	// Relación con el núcleo
	public void setCore(Core nucleo) {
		this.nucleo = nucleo;
	}
	
	// Validando sesión
	public String validarDatos() {
		System.out.println("Iniciando sesión...");
		System.out.println("Procesando usuario...");
		if(getUser().equals(sel)) {
			System.out.println("La selección " + sel + " es inválida.");
			setMessage("No hay una selección. Intenta de nuevo.");
		}
		if(getPass().equals("")) {
			System.out.println("Ingresa una contraseña.");
			setMessage("Ingresa una contraseña.");
		}
		if(getUser().equals("admin")) {
			System.out.println("Usuario " + getUser() + " encontrado.");
			validarContra();
			if((getRole().equals("Administrator") || getRole().equals("Standard")  
					|| getRole().equals("Guest")) == false) {
				System.out.println("No hay rol asignado para este usuario.");
				setMessage("Rol no válido, imposible iniciar sesión con este usuario.");
				setStatus(false);
			}
			else {
				setMessage("Usuario y/o Contraseña inválidos. Intenta de nuevo.");
				}
		}
		if(getStatus() == true) {
			setMessage("Usuario y Contraseña aceptados. Bienvenido " + getUser());
			nucleo.setRole(getRole());
		}
		else {
			System.out.println("Usuario " + getUser() + " no existe.");
			setMessage("Usuario no registrado. Selecciona uno válido");
		}
		return getMessage();
	}
	
	// Validando contraseña ingresada
	private void validarContra() {
		System.out.println("Procesando contraseña...");
		if(getPass().equals(pass)) {
			System.out.println("Contraseña válida.");
			setStatus(true);
		}
		else {
			System.out.println("Contraseña inválida.");
		}
	}

	// Getters de parámetros
	private String getUser() {
		return user;
	}
		
	private String getPass() {
		return password;
	}
	
	public String getRole() {
		return role;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public String getMessage() {
		return message;
	}
	// Setters de parámetros
	public void setUser(String user) {
		this.user = user;
	}
	
	public void setPass(char[] password) {
		this.password = new String(password);
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
package mcgdp.cont.process;

import mcgdp.cont.main.Core;
import mcgdp.cont.db.dao.Users;
import mcgdp.cont.db.vo.User;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ProcessLogin {
	// Parámetros de procesos
	private Core nucleo;
	private String user;
	private Integer index;
	private String password;
	private String role;
	public String message;
	private boolean status;
	private final String sel = "Selecciona...";
	private final Users data = new Users();
	private ArrayList <User> usersList = data.consListaUsuarios();

	// Relación con el núcleo
	public void setCore(Core nucleo) {
		this.nucleo = nucleo;
	}
	
	// Validando sesión
	public String validarDatos() {
		try {
			System.out.println("Login [INFO]: Intento de inicio de sesión por: " + getUser());
			System.out.println("Login [INFO]: Iniciando sesión...");
			
			if(getUser().equals(sel)) {
				System.out.println("Login [ERROR]: " + sel + " no es aplicable.");
				setMessage("No hay una selección. Intenta de nuevo.");
				setStatus(false);
			}
			else if(!getUser().equals(sel)) {
				System.out.println("Login [INFO]: Procesando usuario...");
				validarUsuario();
				System.out.println("Login [INFO]: Usuario procesado.");
				
				if(getIndex() != null) {
					System.out.println("Login [INFO]: Usuario " + getUser() + " encontrado.");
					System.out.println("Login [INFO]: Procesando contraseña...");
					validarPassword();
					
					if(getStatus() == true) {
						setMessage("Usuario y Contraseña válidos. Bienvenido " + getUser());
						nucleo.setRole(getRole());
						System.out.println("Login [INFO]: Inicio de sesión exitoso.");
					}
					else {
						System.out.println("Login [ERROR]: Inicio de sesión fallido.");
					}
				}
				else if(getIndex() == null) {
					System.out.println("Login [ERROR]: Usuario inválido.");
					setMessage("Usuario inválido. Intenta de nuevo.");
					setStatus(false);
				}
			}
		}
		catch(Exception e) {
			System.out.println("Login [FATAL]: Error inesperado en login: "+e.getMessage());
			JOptionPane.showMessageDialog(null, "Error Fatal al iniciar sesión: "+e.getMessage(), 
					"Auxiliar Contable", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return getMessage();
	}
	
	// Validando contraseña ingresada
	private void validarPassword() {
		if(getPass().equals("")) {
			System.out.println("Login [ERROR]: No hay contraseña ingresada.");
			setMessage("Ingresa una contraseña.");
			setStatus(false);
		}
		else if(getPass().equals(usersList.get(getIndex()).getPassword())) {
			System.out.println("Login [INFO]: Contraseña válida.");
			validarRol();
		}
		else {
			System.out.println("Login [ERROR]: Contraseña inválida.");
			setMessage("Contraseña inválida. Intenta de nuevo.");
			setStatus(false);
		}
	}
	
	// Validando si existe el usuario ingresado
	private void validarUsuario() {
		for(int i = 0; i < usersList.size(); i++) {
			if(usersList.get(i).getUsuarios().equals(getUser())) {
				setIndex(i);
			}
		}
	}
	
	// Validando y asignando rol de usuario
	private void validarRol() {
		System.out.println("Login [INFO]: Validando rol...");
		if(usersList.get(getIndex()).getRol() != null) {
			System.out.println("Login [INFO]: Rol validado.");
			System.out.println("Login [INFO]: Asignando rol...");
			setRole(usersList.get(getIndex()).getRol());
			System.out.println("Login [INFO]: Rol asignado.");
			setStatus(true);
		}
		else {
			System.out.println("Login [ERROR]: No hay rol asignado para este usuario.");
			setMessage("Rol no encontrado, imposible iniciar sesión con este usuario. "
					+ "Contacte a su administrador");
			setStatus(false);
		}
	}

	// Getters de parámetros
	private String getUser() {
		return user;
	}
	
	private Integer getIndex() {
		return index;
	}
		
	private String getPass() {
		return password;
	}
	
	private String getRole() {
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
	
	public void setIndex(Integer index) {
		this.index = index;
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
// ##################################################################################### //
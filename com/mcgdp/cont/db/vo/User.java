package mcgdp.cont.db.vo;

public class User {
	// Parámetros de clase
	private int uID;
	private String usuarios;
	private String password;
	private String rol;
	
	// Getters
	public int getUID() {
		return uID;
	}
	
	public String getUsuarios() {
		return usuarios;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getRol() {
		return rol;
	}
	
	// Setters
	public void setUID(int uID) {
		this.uID = uID;
	}
	
	public void setUsuarios(String usuarios) {
		this.usuarios = usuarios;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setRol(String rol) {
		this.rol = rol;
	}
}
// ######################################################################################################## //
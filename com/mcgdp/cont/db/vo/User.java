// ######################################################################################################## //
package mcgdp.cont.db.vo;

public class User {
	// Parámetros de clase
	private String usuario;
	private String password;
	private String rol;
	private String puesto;
	private int ID;
	
	// Getters	
	public String getUsuario() {
		return usuario;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getRol() {
		return rol;
	}
	
	public String getPuesto() {
		return puesto;
	}
	
	public int getID() {
		return ID;
	}
	
	// Setters
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
}
// ######################################################################################################## //
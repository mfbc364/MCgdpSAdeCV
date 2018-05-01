// ############################################################################################################################ //
package mcgdp.cont.GUI.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;
import javax.swing.*;

import mcgdp.cont.GUI.tasks.Bills;
import mcgdp.cont.GUI.tasks.Info;
import mcgdp.cont.GUI.tasks.POs;
import mcgdp.cont.GUI.tasks.Pays;
import mcgdp.cont.main.Sys;

public class Index extends JFrame implements ActionListener {
	/**
	 * Interfaz gráfica del inicio
	 */
	
	// Parámetros de inicio
	private Container cont;
	private JLabel lblTitle, lblPerm, lblPOs, lblBills, lblPays;
	private JButton btnUser, btnInfo, btnPOs, btnBills, btnPays, btnLogout;
	private Image icon, user, info, pos, bills, pays, logout; 
	private Sys sis;
	private Info i;
	private POs oc;
	private Pays p;
	private Bills b;
	private String role = "Sistema";
	private static final long serialVersionUID = 1L;
	
	//Constructor
	public Index() {
		initialize();
		setTitle("Auxiliar Contable");
		setSize(800, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setPerm();
		System.out.println("Index [INFO]: Auxiliar Contable iniciado.");
	}
	
	// Inicialización de componentes
	private void initialize() {
		System.out.println("Index [INFO]: Iniciando Auxiliar Contable...");
		cont = getContentPane();																	// Contenedor instanciado
		cont.setLayout(null);																		// Layout absoluto
		
		icon = new ImageIcon(this.getClass().getResource("/icon-sm.png")).getImage();				// Ícono encontrado
		setIconImage(icon);																			// Ícono seleccionado
		
		btnUser = new JButton("");
		user = new ImageIcon(this.getClass().getResource("/user-info.png")).getImage();				// Propiedades del botón
		btnUser.setIcon(new ImageIcon(user));														// Usuario
		btnUser.setBounds(50, 15, 50, 50);
		btnUser.addActionListener(this);
		
		lblTitle = new JLabel("MC Global del Potosí S.A. de C.V.");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 24));										// Propiedades de la etiqueta
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);										// Título
		lblTitle.setBounds(129, 11, 540, 54);
		
		btnInfo = new JButton("");
		info = new ImageIcon(this.getClass().getResource("/info.png")).getImage();					// Propiedades del botón
		btnInfo.setIcon(new ImageIcon(info));														// Info
		btnInfo.addActionListener(this);
		btnInfo.setBounds(691, 15, 50, 50);
		
		lblPerm = new JLabel("");
		lblPerm.setHorizontalAlignment(SwingConstants.CENTER);										// Propiedades de la etiqueta
		lblPerm.setBounds(347, 60, 107, 14);														// Permisos
		lblPerm.setText(getRole());
		
		lblPOs = new JLabel("");
		lblPOs.setHorizontalAlignment(SwingConstants.CENTER);										// Propiedades de la etiqueta
		pos = new ImageIcon(this.getClass().getResource("/pos.png")).getImage();					// Ordenes de compra
		lblPOs.setIcon(new ImageIcon(pos));
		lblPOs.setBounds(99, 98, 72, 94);
		
		btnPOs = new JButton("Ordenes de compra");
		btnPOs.setBounds(50, 203, 170, 65);															// Propiedades del botón
		btnPOs.addActionListener(this);																// Ordenes de compra
		
		lblBills = new JLabel("");
		bills = new ImageIcon(this.getClass().getResource("/bills.png")).getImage();				// Propiedades de la etiqueta
		lblBills.setIcon(new ImageIcon(bills));														// Cuentas por pagar
		lblBills.setHorizontalAlignment(SwingConstants.CENTER);
		lblBills.setBounds(359, 98, 78, 94);
		
		btnBills = new JButton("Cuentas por pagar");
		btnBills.setBounds(319, 204, 159, 65);														// Propiedades del botón
		btnBills.addActionListener(this);															// Cuentas por pagar
		
		lblPays = new JLabel("");
		pays = new ImageIcon(this.getClass().getResource("/pays.png")).getImage();					// Propiedades de la etiqueta
		lblPays.setIcon(new ImageIcon(pays));														// Cuentas por cobrar
		lblPays.setHorizontalAlignment(SwingConstants.CENTER);
		lblPays.setBounds(582, 98, 159, 94);
		
		btnPays = new JButton("Cuentas por cobrar");
		btnPays.setBounds(582, 204, 159, 65);														// Propiedades del botón
		btnPays.addActionListener(this);															// Cuentas por cobrar
		
		btnLogout = new JButton("Cerrar Sesión");
		logout = new ImageIcon(this.getClass().getResource("/logout.png")).getImage();				// Propiedades del botón
		btnLogout.setIcon(new ImageIcon(logout));													// Cerrar sesión
		btnLogout.setBounds(330, 293, 136, 39);
		btnLogout.addActionListener(this);
		
		// Componentes agregados al contenedor
		cont.add(btnUser);
		cont.add(lblTitle);
		cont.add(btnInfo);
		cont.add(lblPerm);
		cont.add(lblPOs);
		cont.add(btnPOs);
		cont.add(lblBills);
		cont.add(btnBills);
		cont.add(lblPays);
		cont.add(btnPays);
		cont.add(btnLogout);
	}
	
	/**
	 * Métodos de acciones lógicas
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == btnInfo) {
				i = new Info();
				i.setVisible(true);
			}
			if(e.getSource() == btnPOs) {															// Ejecución del botón POs
				oc = new POs();																		// Iniciando Ordenes de Compra
				oc.setRole(getRole());
				oc.setPerm();
				oc.setVisible(true);
				close();																			// Cerrando ventana Inicio
			}
			if(e.getSource() == btnBills) {															// Ejecución del botón Bills
				b = new Bills();																	// Iniciando Cuentas por Pagar
				b.setRole(getRole());
				b.setPerm();
				b.setVisible(true);
				close();																			// Cerrando ventana Inicio
			}
			if(e.getSource() == btnPays) {															// Ejecución del botón Pays
				p = new Pays();																		// Iniciando Cuentas por Cobrar
				p.setRole(getRole());
				p.setPerm();
				p.setVisible(true);
				close();																			// Cerrando ventana Inicio
			}
			if(e.getSource() == btnLogout) {														// Ejecución del botón
				logout();																			// Cerrar sesión
			}
		}
		catch(Exception err) {
			System.out.println("Index [FATAL]: Error Fatal: " + err.getMessage()	+				// Errores
					err.getCause());
			err.printStackTrace();
					JOptionPane.showMessageDialog(this, "Error Fatal, contacte a soporte técnico", 
							"Auxiliar Contable", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void logout() {
		if(JOptionPane.showConfirmDialog(this, 														// Cerrando sesión
				"¿Seguro que deseas cerrar la sesión?", "Auxiliar Contable", 						// Ventana de confirmación
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
			System.out.println("Index [INFO]: Saliendo del Auxiliar Contable...");
			sis = new Sys();
			sis.init();
			close();																				// Cerrando ventanas
			}
	}
	
	private void close() {																			// Cerrando aplicación
		dispose();
	}
	
	// Getters
	private String getRole() {
		return role;
	}
	
	// Setters
	public void setRole(String role) {
		this.role = role;
	}
	
	public void setPerm() {																			// Extrayendo permisos
		if(getRole().equals("Administrator") || getRole().equals("Sistema")) {
			System.out.println("Index [INFO]: Usuario reconocido como: Administrador");				// Como Administrador
			lblPerm.setText("Administrador");
		}
		else if(getRole().equals("Standard")) {
			System.out.println("Index [INFO]: Usuario reconocido como: Estándar");					// Como Usuario
			lblPerm.setText("Editor");
			btnUser.setEnabled(false);
		} 
		else if (getRole().equals("Guest")) {
			System.out.println("Index [INFO]: Usuario reconocido como: Invitado");					// Como Invitado
			lblPerm.setText("Invitado");
			btnUser.setEnabled(false);
			btnPOs.setEnabled(false);
			btnBills.setEnabled(false);
			btnPays.setEnabled(false);
		}
		else {
			System.out.println("Index [ERROR]: Fallo en seguridad. Cierre inmediato");				// Error
			JOptionPane.showMessageDialog(this, "Error Fatal: "
					+ "Fallo en seguridad. Cierre inmediato", "Auxiliar Contable", 
					JOptionPane.INFORMATION_MESSAGE);
			close();																				// Cierre inesperado
		}
	} 
}
// ############################################################################################################################ //
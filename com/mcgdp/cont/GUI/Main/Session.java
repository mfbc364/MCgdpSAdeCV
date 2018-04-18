package mcgdp.cont.GUI.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

import mcgdp.cont.db.dao.Users;
import mcgdp.cont.db.vo.User;
import mcgdp.cont.main.Core;

public class Session extends JFrame implements ActionListener {
	/**
	 * Interfaz gráfica de la sesión
	 */
	
	// Parámetros de la sesión
	private Container cont;
	private JLabel lblTitle, lblUser, lblPass, lblWelcome, lblSession, lblLogin;
	private JComboBox<String> userCombo;
	private JPasswordField passwordField;
	private JButton btnLogin, btnClean, btnExit;
	private Image icon, signin, clean, exit, login;
	private JSeparator separatorTop, separatorBot;
	private Core nucleo;
	private Index inicio;
	private static final long serialVersionUID = 1L;
	
	// Constructor
	public Session() {
		cargarUsuarios();
		initialize();
		setTitle("Auxiliar Contable");
		setSize(450, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		System.out.println("Aplicación iniciada.");
	}
	
	// Inicialización de componentes
	private void initialize() {
		System.out.println("Iniciando aplicación...");
		cont = getContentPane();																	// Contenedor instanciado
		cont.setLayout(null);																		// Layout absoluto
		
		icon = new ImageIcon(this.getClass().getResource("/icon-sm.png")).getImage();				// Ícono encontrado
		setIconImage(icon);																			// Ícono seleccionado
		
		lblTitle = new JLabel("MC Global del Potosí S.A. de C.V.");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 24));										// Propiedades de la etiqueta
		lblTitle.setBounds(21, 11, 390, 33);														// Título
		
		lblWelcome = new JLabel("Bienvenido al administrador de cobros/pagos");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);									// Propiedades de la etiqueta
		lblWelcome.setBounds(87, 46, 277, 14);														// Bienvenida
		
		lblSession = new JLabel("Inicia sesión para acceder al sistema.");
		lblSession.setHorizontalAlignment(SwingConstants.CENTER);									// Propiedades de la etiqueta
		lblSession.setBounds(87, 71, 277, 14);														// Sesión
		
		separatorTop = new JSeparator();															// Propiedades del separador
		separatorTop.setBounds(10, 96, 414, 1);														// Top
		
		lblLogin = new JLabel();
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);										// Propiedades de la etiqueta
		login = new ImageIcon(this.getClass().getResource("/login.png")).getImage();				// Ícono de inicio de sesión
		lblLogin.setIcon(new ImageIcon(login));
		lblLogin.setBounds(10, 103, 83, 86);
		
		lblUser = new JLabel("Usuario");															// Propiedades de la etiqueta
		lblUser.setBounds(123, 112, 46, 14);														// Usuario
		
		userCombo = new JComboBox<String>();
		userCombo.setBounds(190, 109, 221, 20);														// Propiedades del campo de texto
		userCombo.setModel(new DefaultComboBoxModel<String>(new String[]{"Selecciona..."})); 		// Usuario
		userCombo.setSelectedIndex(0);
		userCombo.addActionListener(this);
		
		lblPass = new JLabel("Contraseña");															// Propiedades de la etiqueta
		lblPass.setBounds(103, 156, 77, 14);														// Contraseña
		lblPass.setVisible(false);
		
		passwordField = new JPasswordField();														// Propiedades del campo de texto
		passwordField.setBounds(190, 153, 221, 20);													// Contraseña
		passwordField.setVisible(false);
		
		separatorBot = new JSeparator();															// Propiedades del separador
		separatorBot.setBounds(10, 197, 414, 1);													// Bot
		
		btnLogin = new JButton("Iniciar Sesión");
		signin = new ImageIcon(this.getClass().getResource("/signin.png")).getImage();				// Propiedades del botón
		btnLogin.setIcon(new ImageIcon(signin));													// Inicio de sesión
		btnLogin.setBounds(154, 209, 131, 23);
		btnLogin.addActionListener(this);															// Ejecución de botón
		
		btnClean = new JButton("Limpiar");
		clean = new ImageIcon(this.getClass().getResource("/clean.png")).getImage();				// Propiedades del botón
		btnClean.setIcon(new ImageIcon(clean));														// Limpiar
		btnClean.setBounds(21, 209, 100, 23);
		btnClean.addActionListener(this);															// Ejecución del botón
		
		btnExit = new JButton("Salir");
		exit = new ImageIcon(this.getClass().getResource("/exit.png")).getImage();					// Propiedades del botón
		btnExit.setIcon(new ImageIcon(exit));														// Salir
		btnExit.setBounds(322, 209, 89, 23);
		btnExit.addActionListener(this);															// Ejecución del botón
		
		// Componentes agregados al contenedor
		cont.add(lblTitle);
		cont.add(lblWelcome);
		cont.add(lblSession);
		cont.add(separatorTop);
		cont.add(lblLogin);
		cont.add(lblUser);
		cont.add(userCombo);
		cont.add(lblPass);
		cont.add(passwordField);
		cont.add(separatorBot);
		cont.add(btnLogin);
		cont.add(btnClean);
		cont.add(btnExit);
	}
	
	/**
	 * Métodos de acciones lógicas
	 */
	
	// Eventos de botones
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == userCombo) {														// Ejecución de combo
			mostrarPass();																			// Combo de usuarios
		}
		
		if(e.getSource() == btnLogin) {																// Ejecución del botón
			String user = userCombo.getSelectedItem().toString();									// Iniciar Sesión
			char[] pass = passwordField.getPassword();
			System.out.println("Intento de inicio de sesión por: " + user);
			String res = nucleo.validarDatos(user, pass);
			
			if(nucleo.validarStatus() == true) {													// Ejecución de validación
				System.out.println("Inicio de sesión exitoso.");									// Inicio de sesión exitoso
				JOptionPane.showMessageDialog(this, res, "Auxiliar Contable", 
						JOptionPane.INFORMATION_MESSAGE);
				System.out.println("Limpiando datos...");
				
				userCombo.setSelectedIndex(0);														// Limpiando
				passwordField.setText(null);
				close();
				
				inicio = new Index();
				inicio.setVisible(true);															// Abriendo Inicio
			}
			else {
				System.out.println("Inicio de sesión fallido.");									// Inicio de sesión fallido
				JOptionPane.showMessageDialog(this, res, "Auxiliar Contable", 
						JOptionPane.ERROR_MESSAGE);
			}
			
			userCombo.setSelectedIndex(0);															// Limpiando
			passwordField.setText(null);
			System.out.println("Entradas limpiadas");
		}
		if(e.getSource() == btnClean) {																// Ejecución del botón
			passwordField.setText(null);															// Limpiar
			userCombo.setSelectedIndex(0);
			
			System.out.println("Entradas limpiadas.");
		}
		if(e.getSource() == btnExit) {																// Ejecución del botón
			if(JOptionPane.showConfirmDialog(this, "¿Seguro que deseas salir?", 					// Salir
					"Auxiliar Contable", JOptionPane.YES_NO_OPTION) == 
					JOptionPane.YES_NO_OPTION) {
				
				System.out.println("Saliendo de la aplicación...");
				System.out.println("Aplicación cerrada.");
				System.out.println("Cerrando proceso...");
				System.exit(0);																		// Matando proceso
			}
		}
	}
		catch(Exception err) {
			System.out.println("Error fatal: " + err.getMessage());
		}
	}
	
	public void close() {																			// Cierre de aplicación
		dispose();
	}
	
	private void mostrarPass() {																	// Método para mostrar campos
		// String sel = (String) userCombo.getSelectedItem();										// Contraseña
		int i = userCombo.getSelectedIndex();
		if(i == 0) {
			lblPass.setVisible(false);
			passwordField.setVisible(false);
		}
		else {
			lblPass.setVisible(true);
			passwordField.setVisible(true);
		}
	}
	
	private void cargarUsuarios() {  
		Users users = new Users();
		  ArrayList <User> usersList = users.consListaUsuarios();
		  System.out.println();
		 
		  for (int i = 0; i <usersList.size(); i++) {
		   userCombo.addItem(usersList.get(i).getUID()+ " - " +usersList.get(i).getUsuarios());
		  }
		 }

	public void setCore(Core nucleo) {																// Relación con el núcleo
		this.nucleo = nucleo;
	}
}
// ################################################################################################ //
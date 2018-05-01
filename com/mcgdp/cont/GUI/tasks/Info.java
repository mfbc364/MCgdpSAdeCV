package mcgdp.cont.GUI.tasks;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Info extends JDialog implements ActionListener {
	/** 
	  * Interfaz gráfica de la información
	 **/
	
	private Container cont;
	private JButton btnOK;
	private JLabel lblIcon, lblTitle, lblSubTitle, lblAuthor;
	private JPanel panel;
	private static final long serialVersionUID = 1L;
	
	public Info() {
		initialize();
		setTitle("Auxiliar Contable");
		setSize(450, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		getRootPane().setDefaultButton(btnOK);
		System.out.println("Info [INFO]: Ventana Información iniciada.");
	}
	
	// Inicialización de componentes
	private void initialize() {
		System.out.println("Info [INFO]: Iniciando Ventana Información...");
		panel = new JPanel();																		// Panel creado
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));												// Borde del panel
		panel.setLayout(null);																		// Layout absoluto
		
		cont = getContentPane();																	// Contenedor instanciado
		cont.setLayout(new BorderLayout());															// Layout border
		cont.add(panel, BorderLayout.CENTER);														// Panel centrado en contenedor
		
		lblIcon = new JLabel("");																	// Propiedades de la etiqueta
		Image icon = new ImageIcon(this.getClass().getResource("/icon-lrg.png")).getImage();		// Ícono
		lblIcon.setIcon(new ImageIcon(icon));
		lblIcon.setBounds(150, 0, 130, 130);
		
		lblTitle = new JLabel("Auxiliar Contable v0.8");											// Propiedades de la etiqueta
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);										// Título
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitle.setBounds(125, 141, 180, 23);
		
		lblSubTitle = new JLabel("MC Global del Potos\u00ED S.A. de C.V.");							// Propiedades de la etiqueta
		lblSubTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));									// SubTítulo
		lblSubTitle.setBounds(118, 175, 197, 14);
		
		lblAuthor = new JLabel("Creado por: Ing. Mario Fernando Bravo Coronilla");					// Propiedades de la etiqueta
		lblAuthor.setFont(new Font("Tahoma", Font.ITALIC, 11));										// Autor
		lblAuthor.setBounds(101, 200, 241, 14);
		
		btnOK = new JButton("OK");																	// Propiedades del botón
		btnOK.setBounds(190, 225, 60, 23);															// OK
		btnOK.addActionListener(this);
		
		// Componentas agregados al panel
		panel.add(lblIcon);
		panel.add(lblTitle);
		panel.add(lblSubTitle);
		panel.add(lblAuthor);
		panel.add(btnOK);
	}
	
	/**
	 * Métodos de acciones lógicas
	 */
	// Eventos de botones
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if(e.getSource() == btnOK) {														// Botón Salir presionado
					System.out.println("Info [INFO]: Cerrando Ventana Información...");				// Cerrando ventana Búsqueda
					close();
				}
			}
			catch(Exception err) {
				System.out.println("Info [FATAL]: Error Fatal: " + err.getMessage() + " " +			// Errores
						err.getCause());
				err.printStackTrace();
						JOptionPane.showMessageDialog(this, 
								"Error Fatal, contacte a soporte técnico", "Auxiliar Contable", 
								JOptionPane.ERROR_MESSAGE);
			}
		}
		
		// Cierre de ventana
		public void close() {
			dispose();
		}
}

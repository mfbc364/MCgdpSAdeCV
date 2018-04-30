// ############################################################################################################################## //
package mcgdp.cont.GUI.tasks;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import mcgdp.cont.GUI.Main.Index;

public class POs extends JFrame implements ActionListener {
	 /** 
	  * Interfaz gráfica del inicio
	 **/
	
	// Parámetros de ordenes de compra
	private Container cont;
	private JButton btnBack, btnSearch, btnAdd, btnEdit, btnDel;
	private JPanel panel;
	private JScrollPane scrollPanel, scrollProcess, scrollComplets, scrollCanceled;
	private JLabel lblProcess, lblComplets, lblCanceled;
	private JTable tableProcess, tableComplets, tableCanceled;
	private JSeparator separatorTop, separatorMid, separatorBot;
	private Image icon, back, search, add, edit, del, process, ok, cancel;
	private Index inicio;
	private static final long serialVersionUID = 1L;
	
	// Constructor
	public POs() {
		initialize();
		setTitle("Auxiliar Contable");
		setSize(1280, 720);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		System.out.println("POs [INFO]: Lista de Ordenes de Compra iniciada.");
	}
	
	// Inicialización de componentes
	private void initialize() {
		System.out.println("Pos [INFO]: Iniciando ventana de POs...");
		cont = getContentPane();																	// Contenedor instanciado
		cont.setLayout(null);																		// Layout absoluto
		
		icon = new ImageIcon(this.getClass().getResource("/icon-sm.png")).getImage();				// Ícono encontrado
		setIconImage(icon);																			// Ícono seleccionado
		
		// Componentes del contenedor del Frame
		btnBack = new JButton("Atrás");																// Propiedades del botón
		back = new ImageIcon(this.getClass().getResource("/back.png")).getImage();					// Atrás
		btnBack.setIcon(new ImageIcon(back));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(0, 0, 119, 40);
		btnBack.addActionListener(this);
		
		btnSearch = new JButton("Búsqueda");														// Propiedades del botón
		search = new ImageIcon(this.getClass().getResource("/search.png")).getImage();				// Búsqueda
		btnSearch.setIcon(new ImageIcon(search));
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearch.setBounds(176, 0, 144, 40);
		btnSearch.addActionListener(this);
		
		btnAdd = new JButton("Añadir");																// Propiedades del botón
		add = new ImageIcon(this.getClass().getResource("/add.png")).getImage();					// Añadir
		btnAdd.setIcon(new ImageIcon(add));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.setBounds(360, 0, 119, 40);
		btnAdd.addActionListener(this);
		
		btnEdit = new JButton("Editar");															// Propiedades del botón
		edit = new ImageIcon(this.getClass().getResource("/edit.png")).getImage();					// Editar
		btnEdit.setIcon(new ImageIcon(edit));
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEdit.setBounds(530, 0, 119, 40);
		btnEdit.addActionListener(this);
		
		btnDel = new JButton("Eliminar");															// Propiedades del botón
		del = new ImageIcon(this.getClass().getResource("/delete.png")).getImage();					// Eliminar
		btnDel.setIcon(new ImageIcon(del));
		btnDel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDel.setBounds(700, 0, 119, 40);
		btnDel.addActionListener(this);
		
		// Se crea panel con su respectivo scroll
		scrollPanel = new JScrollPane();															// Propiedades del scroll
		scrollPanel.setBounds(0, 40, 1274, 651);													// Panel
		
		panel = new JPanel();																		// Generando Panel
		panel.setBorder(null);																		// Propiedades del Panel
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(1254, 1025));											// Tamaño ubicado con referencia
		scrollPanel.setViewportView(panel);															// al contenedor
		
			// Componentes del panel
			lblProcess = new JLabel("En proceso...");												// Propiedades de la etiqueta
			process = new ImageIcon(this.getClass().getResource("/inprocess.png")).getImage();		// En proceso
			lblProcess.setIcon(new ImageIcon(process));
			lblProcess.setBounds(20, 0, 150, 32);													// Ubicación con referencia
			lblProcess.setFont(new Font("Tahoma", Font.PLAIN, 15));									// al panel
			lblProcess.setHorizontalAlignment(SwingConstants.LEFT);
			
			scrollProcess = new JScrollPane();														// Propiedades del scroll
			scrollProcess.setBounds(10, 35, 1234, 300);												// En proceso
			
			tableProcess = new JTable();															// Propiedades de la tabla
			scrollProcess.setViewportView(tableProcess);											// En proceso
			
			separatorTop = new JSeparator();														// Propiedades del separador
			separatorTop.setBounds(10, 339, 1234, 2);												// Arriba
			
			lblComplets = new JLabel("Completos");
			ok = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();					// Propiedades de la etiqueta
			lblComplets.setIcon(new ImageIcon(ok));													// Completos
			lblComplets.setBounds(20, 340, 150, 32);
			lblComplets.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			scrollComplets = new JScrollPane();														// Propiedades del scroll
			scrollComplets.setBounds(10, 375, 1234, 300);											// Completos
			
			tableComplets = new JTable();															// Propiedades de la tabla
			scrollComplets.setViewportView(tableComplets);											// Completos
			
			separatorMid = new JSeparator();														// Propiedades del separador
			separatorMid.setBounds(10, 679, 1234, 2);												// En medio
			
			lblCanceled = new JLabel("Cancelados");
			cancel = new ImageIcon(this.getClass().getResource("/canceled.png")).getImage();		// Propiedades de la etiqueta
			lblCanceled.setIcon(new ImageIcon(cancel));												// Cancelados
			lblCanceled.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblCanceled.setBounds(20, 680, 150, 32);
			
			scrollCanceled = new JScrollPane();														// Propiedades del scroll
			scrollCanceled.setBounds(10, 715, 1234, 300);											// Cancelados
			
			tableCanceled = new JTable();															// Propiedades de la tabla
			scrollCanceled.setViewportView(tableCanceled);											// Cancelados
			
			separatorBot = new JSeparator();														// Propiedades del separador
			separatorBot.setBounds(10, 1020, 1234, 2);												// Abajo
			
		// Componentes agregados al contenedor
		cont.add(btnBack);
		cont.add(btnSearch);
		cont.add(btnAdd);
		cont.add(btnEdit);
		cont.add(btnDel);
		cont.add(scrollPanel);
		
		// Componentes agregados al panel
		panel.add(lblProcess);
		panel.add(scrollProcess);
		panel.add(separatorTop);
		panel.add(lblComplets);
		panel.add(scrollComplets);
		panel.add(separatorMid);
		panel.add(lblCanceled);
		panel.add(scrollCanceled);
		panel.add(separatorBot);
	}
	
	/**
	 * Métodos de acciones lógicas
	 */
	
	// Eventos de botones
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == btnBack) {
				inicio = new Index();
				inicio.setVisible(true);
				close();
			}
		}
		catch(Exception err) {
			System.out.println("POs [FATAL]: Error Fatal: " + err.getMessage()	+					// Errores
					err.getCause());
					JOptionPane.showMessageDialog(this, 
							"Error Fatal, contacte a soporte técnico", "Auxiliar Contable", 
							JOptionPane.ERROR_MESSAGE);
		}
	}
	
	// Cierre de la ventana
	public void close() {
		dispose();
	}
}
// ############################################################################################################################## //
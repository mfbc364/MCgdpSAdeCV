// ###################################################################################################################################### //
package mcgdp.cont.GUI.tasks;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import mcgdp.cont.GUI.Main.Index;
import mcgdp.cont.GUI.process.Search;
import mcgdp.cont.process.Load;

public class Pays extends JFrame implements ActionListener {
	/** 
	  * Interfaz gráfica de las cuentas por cobrar
	 **/
	
	// Parámetros de cuentas por cobrar
	private Container cont;
	private Image icon, back, search, add, edit, del, review, ok;
	private JButton btnBack, btnSearch, btnAdd, btnEdit, btnDel;
	private JLabel lblReview, lblApproved, lblNoReview, lblNoApproved;
	private JPanel panel;
	private JScrollPane scrollPanel, scrollReview, scrollApproved;
	private JSeparator separatorTop, separatorBot;
	private JTable tableReview, tableApproved;
	private ArrayList<String> titles;
	private String role;
	private Index inicio;
	private Load cargar;
	private Search busqueda;
	private static final long serialVersionUID = 1L;
	
	// Constructor
	public Pays() {
		initialize();
		setTitle("Auxiliar Contable");
		setSize(1280, 720);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setTitles();
		construirTableReview();
		construirTableApproved();
		System.out.println("Pays [INFO]: Pays iniciada.");
	}
	
	// Inicialización de componentes
	private void initialize() {
		System.out.println("Pays [INFO]: Iniciando ventana de Pays...");
		cont = getContentPane();																			// Contenedor instanciado
		cont.setLayout(null);																				// Layout absoluto
		
		icon = new ImageIcon(this.getClass().getResource("/icon-sm.png")).getImage();						// Ícono encontrado
		setIconImage(icon);																					// Ícono seleccionado
		
		// Componentes del contenedor del Frame
		btnBack = new JButton("Atrás");																		// Propiedades del botón
		back = new ImageIcon(this.getClass().getResource("/back.png")).getImage();							// Atrás
		btnBack.setIcon(new ImageIcon(back));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(0, 0, 119, 40);
		btnBack.addActionListener(this);
		
		btnSearch = new JButton("Búsqueda");																// Propiedades del botón
		search = new ImageIcon(this.getClass().getResource("/search.png")).getImage();						// Búsqueda
		btnSearch.setIcon(new ImageIcon(search));
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearch.setBounds(176, 0, 144, 40);
		btnSearch.addActionListener(this);
		
		btnAdd = new JButton("Añadir");																		// Propiedades del botón
		add = new ImageIcon(this.getClass().getResource("/add.png")).getImage();							// Añadir
		btnAdd.setIcon(new ImageIcon(add));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.setBounds(360, 0, 119, 40);
		btnAdd.addActionListener(this);
		
		btnEdit = new JButton("Editar");																	// Propiedades del botón
		edit = new ImageIcon(this.getClass().getResource("/edit.png")).getImage();							// Editar
		btnEdit.setIcon(new ImageIcon(edit));
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEdit.setBounds(530, 0, 119, 40);
		btnEdit.addActionListener(this);
		
		btnDel = new JButton("Eliminar");																	// Propiedades del botón
		del = new ImageIcon(this.getClass().getResource("/delete.png")).getImage();							// Eliminar
		btnDel.setIcon(new ImageIcon(del));
		btnDel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDel.setBounds(700, 0, 119, 40);
		btnDel.addActionListener(this);
		
		// Se crea panel con su respectivo scroll
		scrollPanel = new JScrollPane();																	// Propiedades del scroll
		scrollPanel.setBounds(0, 40, 1274, 651);															// Panel
		
		
		panel = new JPanel();																				// Generando Panel
		panel.setBorder(null);																				// Propiedades del Panel
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(1254, 689));													// Tamaño ubicado con referencia
		scrollPanel.setViewportView(panel);																	// al contenedor
		
			// Componentes del panel
			lblReview = new JLabel("En revisión...");														// Propiedades de la etiqueta
			review = new ImageIcon(this.getClass().getResource("/pending.png")).getImage();					// En revisión
			lblReview.setIcon(new ImageIcon(review));
			lblReview.setBounds(20, 0, 150, 32);															// Ubicación con referencia
			lblReview.setFont(new Font("Tahoma", Font.PLAIN, 15));											// al panel
			lblReview.setHorizontalAlignment(SwingConstants.LEFT);
			
			scrollReview = new JScrollPane();																// Propiedades del scroll
			scrollReview.setBounds(10, 35, 1234, 300);														// En revisión
			
			separatorTop = new JSeparator();																// Propiedades del separador
			separatorTop.setBounds(10, 339, 1234, 2);														// Arriba
			
			lblApproved = new JLabel("Aprobadas");															// Propiedades de la etiqueta
			ok = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();							// Aprobados
			lblApproved.setIcon(new ImageIcon(ok));
			lblApproved.setBounds(20, 340, 150, 32);
			lblApproved.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			scrollApproved = new JScrollPane();																// Propiedades del scroll
			scrollApproved.setBounds(10, 375, 1234, 300);													// Aprobados
			
			separatorBot = new JSeparator();																// Propiedades del separador
			separatorBot.setBounds(10, 679, 1234, 2);														// Abajo
			
		// Componentes agregados al contenedor
		cont.add(btnBack);
		cont.add(btnSearch);
		cont.add(btnAdd);
		cont.add(btnEdit);
		cont.add(btnDel);
		cont.add(scrollPanel);
		
		// Componentes agregados al panel
		panel.add(lblReview);
		panel.add(scrollReview);
		panel.add(separatorTop);
		panel.add(lblApproved);
		panel.add(scrollApproved);
		panel.add(separatorBot);
	}
	
	/**
	 * Métodos de acciones lógicas
	 */
	
	// Eventos de botones
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == btnBack) {																	// Botón Atrás presionado
				exit();
			}
			if(e.getSource() == btnSearch) {																// Botón Buscar presionado
				busqueda = new Search();
				busqueda.setTitles(getTitles());
				busqueda.setCombo();
				busqueda.setKey(2);
				busqueda.setVisible(true);
			}
		}
		catch(Exception err) {
			System.out.println("Pays [FATAL]: Error Fatal: " + err.getMessage() + " " + 					// Errores
					err.getCause());
			err.printStackTrace();
					
			JOptionPane.showMessageDialog(this, "Error Fatal, contacte a soporte técnico", 
					"Auxiliar Contable", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	// Creación de datos de tabla En revisión...
	private void construirTableReview() {																	// Tabla de datos
		System.out.println("Pays [INFO]: Creando tabla 'En revisión'...");									// En revisión
			
		String title[] = getTitles().toArray(new String[getTitles().size()]);								// Títulos
			
		cargar = new Load();
		String data[][] = cargar.obtenerMatrizPays("In_review");											// Datos
			
		if(data.length != 0) {																			 	// Si existen datos
			tableReview = new JTable(data, title) {															// Propiedades de la tabla
				private static final long serialVersionUID = 1L;											// En revisión
				public boolean isCellEditable(int row, int column) {										// Desactivando edición
					return false;																			// de tabla
				};
				
				@Override
	            public Class<?> getColumnClass(int column) {												// Obteniendo columnas
	                return getValueAt(0, column).getClass();
	            }
		};
		
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();						// Centrando datos
			centerRenderer.setHorizontalAlignment(JLabel.CENTER);											// de tabla
			for(int i = 0; i < data.length; i++) {
				tableReview.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);					// Centrando columnas
			}
		
			resizeColumnWidth(tableReview);
			tableReview.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			scrollReview.setViewportView(tableReview);
			tableReview.setCellSelectionEnabled(false);
			System.out.println("Pays [INFO]: Tabla creada: 'En revisión...'");
		}
		else {																								// Si no existen datos
			lblNoReview = new JLabel("No hay Cuentas de Cobro en Revisión");								// Propiedades de la etiqueta
			lblNoReview.setFont(new Font("Tahoma", Font.PLAIN, 25));										// No hay en revisión
			lblNoReview.setHorizontalAlignment(SwingConstants.CENTER);
			scrollReview.setViewportView(lblNoReview);
			System.out.println("Pays [INFO]: Tabla 'En revisión...' no creada por falta de datos");
		}
	}
	
	// Creación de datos de tabla Aprobados
	private void construirTableApproved() {																	// Tabla de datos
		System.out.println("Pays [INFO]: Creando tabla 'Aprobados'...");									// Aprobados
			
		String title[] = getTitles().toArray(new String[getTitles().size()]);								// Títulos
			
		cargar = new Load();
		String data[][] = cargar.obtenerMatrizPays("Approved");												// Datos
			
		if(data.length != 0) {																			 	// Si existen datos
			tableApproved = new JTable(data, title) {														// Propiedades de la tabla
				private static final long serialVersionUID = 1L;											// Aprobados
				public boolean isCellEditable(int row, int column) {										// Desactivando edición
					return false;																			// de tabla
				};
				
				@Override
	            public Class<?> getColumnClass(int column) {												// Obteniendo columnas
	                return getValueAt(0, column).getClass();
	            }
			};
			
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();						// Centrando datos
	        centerRenderer.setHorizontalAlignment(JLabel.CENTER);											// de tabla
	        for(int i = 0; i < data.length; i++) {
	        	tableApproved.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);				// Centrando columnas
	        }
			
			resizeColumnWidth(tableApproved);
			tableApproved.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			scrollApproved.setViewportView(tableApproved);
			tableApproved.setCellSelectionEnabled(false);
			System.out.println("Pays [INFO]: Tabla creada: 'Aprobados'");
		}
		else {																								// Si no existen datos
			lblNoApproved = new JLabel("No hay Cuentas de Cobro Aprobadas");								// Propiedades de la etiqueta
			lblNoApproved.setFont(new Font("Tahoma", Font.PLAIN, 25));										// No hay aprobados
			lblNoApproved.setHorizontalAlignment(SwingConstants.CENTER);
			scrollApproved.setViewportView(lblNoApproved);
			System.out.println("Pays [INFO]: Tabla 'Aprobados' no creada por falta de datos");
		}
	}
	
	// Modificación de tamaño de columnas
	private void resizeColumnWidth(JTable table) {
		final TableColumnModel columnModel = table.getColumnModel();										// Obteniendo modelo de tabla
	    for (int column = 0; column < table.getColumnCount(); column++) {									// Recorriendo columnas
	        int width = 130;																				// Anchura mínima
	        for (int row = 0; row < table.getRowCount(); row++) {											// Recorriendo datos de columna
	            TableCellRenderer renderer = table.getCellRenderer(row, column);
	            Component comp = table.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width +1 , width);
	        }
	        if(width > 400)
	            width=400;
	        columnModel.getColumn(column).setPreferredWidth(width);											// Asignando tamaño a columna 
	    }
	}
	
	// Setters
	private void setTitles() {
		titles = new ArrayList<String>();
		titles.add("RFC");
		titles.add("Cliente");
		titles.add("Fecha de emisión");
		titles.add("Dirección");
		titles.add("Colonia");
		titles.add("Ciudad");
		titles.add("Código Postal");
		titles.add("Pais");
		titles.add("Descripción");
		titles.add("Cantidad");
		titles.add("Unidad de medida");
		titles.add("Precio Unitario");
		titles.add("Impuestos");
		titles.add("Total");
		titles.add("Divisa");
		titles.add("Tipo de Pago");
		titles.add("Método de Pago ");
	}	
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public void setPerm() {																			// Extrayendo permisos
		if(getRole().equals("Administrator") || getRole().equals("Sistema")) {
			System.out.println("POs [INFO]: Usuario reconocido como: Administrador");				// Como Administrador
		}
		else if(getRole().equals("Standard")) {
			System.out.println("POs [INFO]: Usuario reconocido como: Estándar");					// Como Usuario
			btnDel.setEnabled(false);
		}
		else {
			System.out.println("POs [ERROR]: Fallo en seguridad. Cierre inmediato");				// Error
			JOptionPane.showMessageDialog(this, "Error Fatal: "
					+ "Fallo en seguridad. Cierre inmediato", "Auxiliar Contable", 
					JOptionPane.INFORMATION_MESSAGE);
			close();																				// Cierre inesperado
		}
	}
	
	// Getters
	private ArrayList<String> getTitles() {
		return titles;
	}
	
	private String getRole() {
		return role;
	}
	
	// Confirmación de retroceso
	private void exit() {																					// Cerrando ventana
		if(JOptionPane.showConfirmDialog(null,																// Ventana de confirmación
				"¿Seguro que deseas salir de Cuentas por Cobrar?", "Auxiliar Contable",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
				System.out.println("Pos [INFO]: Saliendo de Ordenes de compra...");
				inicio = new Index();
				inicio.setRole(getRole());
				inicio.setPerm();
				inicio.setVisible(true);																	// Abriendo pantalla inicio
				close();																					// Cerrando ventana
		}
	}
	
	// Cierre de la ventana
	private void close() {
		dispose();
	}
}
// ###################################################################################################################################### //
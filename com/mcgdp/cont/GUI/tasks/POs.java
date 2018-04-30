// ############################################################################################################################## //
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
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import mcgdp.cont.GUI.Main.Index;
import mcgdp.cont.GUI.process.*;
import mcgdp.cont.process.*;

public class POs extends JFrame implements ActionListener {
	 /** 
	  * Interfaz gráfica del inicio
	 **/
	
	// Parámetros de ordenes de compra
	private Container cont;
	private JButton btnBack, btnSearch, btnAdd, btnEdit, btnDel;
	private JPanel panel;
	private JScrollPane scrollPanel, scrollProcess, scrollComplets, scrollCancelled;
	private JLabel lblProcess, lblComplets, lblCanceled, lblNoProcess, lblNoComplets, lblNoCancelled;
	private JTable tableProcess, tableComplets, tableCancelled;
	private JSeparator separatorTop, separatorMid, separatorBot;
	private Image icon, back, search, add, edit, del, process, ok, cancel;
	private ArrayList<String> titles;
	private Index inicio;
	private Load cargar;
	private Search busqueda;
	private static final long serialVersionUID = 1L;
	
	// Constructor
	public POs() {
		initialize();
		setTitle("Auxiliar Contable");
		setSize(1280, 720);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setTitles();
		construirTableProcess();
		construirTableComplets();
		construirTableCanceled();
		System.out.println("POs [INFO]: Pos iniciada.");
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
			
			separatorTop = new JSeparator();														// Propiedades del separador
			separatorTop.setBounds(10, 339, 1234, 2);												// Arriba
			
			lblComplets = new JLabel("Completos");
			ok = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();					// Propiedades de la etiqueta
			lblComplets.setIcon(new ImageIcon(ok));													// Completos
			lblComplets.setBounds(20, 340, 150, 32);
			lblComplets.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			scrollComplets = new JScrollPane();														// Propiedades del scroll
			scrollComplets.setBounds(10, 375, 1234, 300);											// Completos
			
			separatorMid = new JSeparator();														// Propiedades del separador
			separatorMid.setBounds(10, 679, 1234, 2);												// En medio
			
			lblCanceled = new JLabel("Cancelados");
			cancel = new ImageIcon(this.getClass().getResource("/canceled.png")).getImage();		// Propiedades de la etiqueta
			lblCanceled.setIcon(new ImageIcon(cancel));												// Cancelados
			lblCanceled.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblCanceled.setBounds(20, 680, 150, 32);
			
			scrollCancelled = new JScrollPane();														// Propiedades del scroll
			scrollCancelled.setBounds(10, 715, 1234, 300);											// Cancelados
			
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
		panel.add(scrollCancelled);
		panel.add(separatorBot);
	}
	
	/**
	 * Métodos de acciones lógicas
	 */
	
	// Eventos de botones
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == btnBack) {															// Botón Atrás presionado
				exit();
			}
			if(e.getSource() == btnSearch) {														// Botón Buscar presionado
				busqueda = new Search();
				busqueda.setVisible(true);
			}
		}
		catch(Exception err) {
			System.out.println("POs [FATAL]: Error Fatal: " + err.getMessage() + " " + 				// Errores
					err.getCause());
			err.printStackTrace();
					
			JOptionPane.showMessageDialog(this, "Error Fatal, contacte a soporte técnico", 
					"Auxiliar Contable", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	// Creación de datos de tabla En proceso...
	private void construirTableProcess() {															// Tabla de datos de en proceso
		System.out.println("POs [INFO]: Creando tabla 'En proceso...'...");
		
		String title[] = getTitles().toArray(new String[getTitles().size()]);						// Títulos
		
		cargar = new Load();
		String data[][] = cargar.obtenerMatrizProcess("In_progress");								// Datos
		
		if(data.length != 0) {																		// Si existen datos
			tableProcess = new JTable(data, title);													// Propiedades de la tabla
			resizeColumnWidth(tableProcess);														// En proceso
			tableProcess.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			scrollProcess.setViewportView(tableProcess);
			System.out.println("POs [INFO]: Tabla creada: 'En proceso...'");
		}
		else {																						// Si no existen datos
			lblNoProcess = new JLabel("No hay Ordenes de Compra en Proceso");						// Propiedades de la etiqueta
			lblNoProcess.setFont(new Font("Tahoma", Font.PLAIN, 25));								// No hay en proceso
			lblNoProcess.setHorizontalAlignment(SwingConstants.CENTER);
			scrollProcess.setViewportView(lblNoProcess);
			System.out.println("POs [INFO]: Tabla En proceso... no creada por falta de datos");
		}
	}
	
	// Creación de datos de tabla Completos
	private void construirTableComplets() {															// Tabla de datos de completos
		System.out.println("POs [INFO]: Creando tabla 'Completos'...");
		String title[] = getTitles().toArray(new String[getTitles().size()]);						// Títulos
		
		cargar = new Load();
		String data[][] = cargar.obtenerMatrizProcess("Ok");										// Datos
		
		if(data.length != 0) {																		// Si existen datos
			tableComplets = new JTable(data, title);												// Propiedades de la tabla
			resizeColumnWidth(tableComplets);														// Completos
			tableComplets.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			scrollComplets.setViewportView(tableComplets);
			System.out.println("POs [INFO]: Tabla creada: 'Completos'");
		}
		else {																						// Si no existen datos
			lblNoComplets = new JLabel("No hay Ordenes de Compra Completadas");						// Propiedades de la etiqueta
			lblNoComplets.setFont(new Font("Tahoma", Font.PLAIN, 25));								// No hay completos
			lblNoComplets.setHorizontalAlignment(SwingConstants.CENTER);
			scrollComplets.setViewportView(lblNoComplets);
			System.out.println("POs [INFO]: Tabla Completos no creada por falta de datos");
		}
	}
		
	// Creación de datos de tabla Cancelados
	private void construirTableCanceled() {															// Tabla de datos de cancelados
		System.out.println("POs [INFO]: Creando tabla 'Cancelados'...");							// Títulos
		String title[] = getTitles().toArray(new String[getTitles().size()]);						// Títulos
					
		cargar = new Load();
		String data[][] = cargar.obtenerMatrizProcess("Canceled");									// Datos
					
		if(data.length != 0) {																		// Si existen datos
			tableCancelled = new JTable(data, title);												// Propiedades de la tabla
			resizeColumnWidth(tableCancelled);														// Cancelados
			tableCancelled.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			scrollCancelled.setViewportView(tableCancelled);
			System.out.println("POs [INFO]: Tabla creada: 'Cancelados'");
		}
		else {																						// Si no existen datos
			lblNoCancelled = new JLabel("No hay Ordenes de Compra Canceladas");						// Propiedades de la etiqueta
			lblNoCancelled.setFont(new Font("Tahoma", Font.PLAIN, 25));								// No hay cancelados
			lblNoCancelled.setHorizontalAlignment(SwingConstants.CENTER);
			scrollCancelled.setViewportView(lblNoCancelled);
			System.out.println("POs [INFO]: Tabla Cancelados no creada por falta "
					+ "de datos");
		}
	}
	
	// Modificación de tamaño de columnas
	private void resizeColumnWidth(JTable table) {
		final TableColumnModel columnModel = table.getColumnModel();								// Obteniendo modelo de tabla
	    for (int column = 0; column < table.getColumnCount(); column++) {							// Recorriendo columnas
	        int width = 15;																			// Anchura mínima
	        for (int row = 0; row < table.getRowCount(); row++) {									// Recorriendo datos de columna
	            TableCellRenderer renderer = table.getCellRenderer(row, column);
	            Component comp = table.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width +1 , width);
	        }
	        if(width > 300)
	            width=300;
	        columnModel.getColumn(column).setPreferredWidth(width);									// Asignando tamaño a columna 
	    }
	}
	
	// Setters
	private void setTitles() {
		titles = new ArrayList<String>();
		titles.add("Número de orden");
		titles.add("Fecha de emisión");
		titles.add("Encargado de emisión");
		titles.add("Proveedor");
		titles.add("Dirección");
		titles.add("Colonia");
		titles.add("Ciudad");
		titles.add("Código Postal");
		titles.add("Pais");
		titles.add("Cantidad");
		titles.add("Unidad de medida");
		titles.add("Descripción");
		titles.add("Precio Unitario");
		titles.add("Total");
		titles.add("Divisa");
	}
	
	// Getters
	public ArrayList<String> getTitles() {
		return titles;
	}
	
	// Confirmación de retroceso
	public void exit() {																			// Cerrando ventana
		if(JOptionPane.showConfirmDialog(this,														// Ventana de confirmación
			"¿Seguro que deseas salir de Ordenes de Compra?", "Auxiliar Contable",
			JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
			System.out.println("Pos [INFO]: Saliendo de Ordenes de compra...");
			inicio = new Index();
			inicio.setVisible(true);																// Abriendo pantalla inicio
			close();																				// Cerrando ventana
		}
	}
	
	// Cierre de la ventana
	public void close() {
		dispose();
	}
}
// ############################################################################################################################## //
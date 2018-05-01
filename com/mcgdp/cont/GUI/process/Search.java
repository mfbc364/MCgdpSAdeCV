package mcgdp.cont.GUI.process;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import mcgdp.cont.process.SearchDB;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

public class Search extends JDialog implements ActionListener{
	/** 
	  * Interfaz gráfica de la búsqueda
	 **/
	
	private Container cont;
	private Image icon;
	private JButton btnSearch, btnExit;
	private JComboBox<String> comboFilter;
	private JLabel lblBuscar, lblPor, lblNoResults;
	private JScrollPane scrollSearch;
	private JSeparator separatorTop, separatorBot;
	private JPanel panel;
	private JTable tableSearch;
	private JTextArea txtSearch;
	private static final long serialVersionUID = 1L;
	private SearchDB busqueda;
	private String[] titles;
	private int key;
	
	public Search() {
		initialize();
		setTitle("Auxiliar Contable");
		setSize(450, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		getRootPane().setDefaultButton(btnSearch);
		System.out.println("Search [INFO]: Ventana Busqueda iniciada.");
	}
	
	// Inicialización de componentes
	private void initialize() {
		System.out.println("Search [INFO]: Iniciando Ventana Busqueda...");
		panel = new JPanel();																		// Panel creado
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));												// Borde del panel
		panel.setLayout(null);																		// Layout absoluto
		
		cont = getContentPane();																	// Contenedor instanciado
		cont.setLayout(new BorderLayout());															// Layout border
		cont.add(panel, BorderLayout.CENTER);														// Panel centrado en contenedor
		
		icon = new ImageIcon(this.getClass().getResource("/icon-sm.png")).getImage();				// Ícono encontrado
		setIconImage(icon);																			// Ícono seleccionado
		
		lblBuscar = new JLabel("Buscar:");															// Propiedades de la etiqueta
		lblBuscar.setBounds(10, 14, 46, 14);														// Buscar
		
		txtSearch = new JTextArea();																// Propiedades del cuadro de texto
		txtSearch.setBounds(52, 9, 160, 22);														// Buscar
		
		btnSearch = new JButton();																	// Propiedades del botón
		Image search = new ImageIcon(this.getClass().getResource("/search-mini.png")).getImage();	// Buscar
		btnSearch.setIcon(new ImageIcon(search));
		btnSearch.setBounds(219, 6, 25, 25);
		btnSearch.addActionListener(this);

		
		lblPor = new JLabel("Por:");																// Propiedades de la etiqueta
		lblPor.setBounds(254, 14, 25, 14);															// Por (filtro)
		
		comboFilter = new JComboBox<String>();														// Propiedades del combo
		comboFilter.setBounds(289, 11, 135, 20);													// Filtro
		
		separatorTop = new JSeparator();															// Propiedades del separador
		separatorTop.setBounds(10, 39, 412, 2);														// Arriba
		
		scrollSearch = new JScrollPane();															// Propiedades del scroll
		scrollSearch.setBounds(10, 47, 414, 168);													// Busqueda
		
		lblNoResults = new JLabel("Búsqueda...");													// Propiedades de la etiqueta
		lblNoResults.setFont(new Font("Tahoma", Font.PLAIN, 25));									// Sin resultados
		lblNoResults.setHorizontalAlignment(SwingConstants.CENTER);
		scrollSearch.setViewportView(lblNoResults);
		
		separatorBot = new JSeparator();															// Propiedades del separador
		separatorBot.setBounds(10, 222, 412, 2);													// Abajo
		
		btnExit = new JButton("Salir");																// Propiedades del botón
		btnExit.setBounds(190, 230, 70, 35);														// Salir
		btnExit.addActionListener(this);
		
		// Componentes agregados al panel
		panel.add(lblBuscar);
		panel.add(txtSearch);
		panel.add(btnSearch);
		panel.add(lblPor);
		panel.add(comboFilter);
		panel.add(separatorTop);
		panel.add(scrollSearch);
		panel.add(separatorBot);
		panel.add(btnExit);
	}
	
	/**
	 * Métodos de acciones lógicas
	 */
	
	// Eventos de botones
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == btnExit) {															// Botón Salir presionado
				close();																			// Cerrando ventana Búsqueda
			}
			if(e.getSource() == btnSearch) {														// Botón Buscar presionado
				String search = txtSearch.getText();												// Obteniendo entrada
				String filter = comboFilter.getSelectedItem().toString();							// Obteniendo filtro
				
				busqueda = new SearchDB();
				switch(getKey()) {
				case 1:	
					String[][] matriz1 = busqueda.obtenerMatrizOrders(search, filter);;				// Realizando búsqueda
					construirTableResults(getTitles(), matriz1);									// Analizando resultados
					break;
				case 2:
					String[][] matriz2 = busqueda.obtenerMatrizPays(search, filter);;				// Realizando búsqueda
					construirTableResults(getTitles(), matriz2);									// Analizando resultados
					break;
				case 3:
					String[][] matriz3 = busqueda.obtenerMatrizBills(search, filter);;				// Realizando búsqueda
					construirTableResults(getTitles(), matriz3);									// Analizando resultados
					break;
				default:
					throw new IllegalArgumentException();
				}
			}
		}
		catch (Exception err) {
			System.out.println("Search [FATAL]: Error Fatal: " + err.getMessage() + " " +			// Errores
					err.getCause());
			err.printStackTrace();
					JOptionPane.showMessageDialog(this, 
							"Error Fatal, contacte a soporte técnico", "Auxiliar Contable", 
							JOptionPane.ERROR_MESSAGE);
		}
	}
	
	// Creación de datos encontrados
	private void construirTableResults(String title[], String data[][]) {							// Tabla de datos de en proceso
		System.out.println("Search [INFO]: Creando tabla 'Resultados'...");
		
		tableSearch = new JTable(data, title) {														// Propiedades de la tabla
			private static final long serialVersionUID = 1L;										// Búsqueda
			public boolean isCellEditable(int row, int column) {									// Desactivando edición
				return false;																		// de tabla
			};
			
			@Override
            public Class<?> getColumnClass(int column) {											// Obteniendo columnas
                return getValueAt(0, column).getClass();
            }
		};
		
		if(data.length != 0) {																		// Si existen datos
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();				// Centrando datos
			centerRenderer.setHorizontalAlignment(JLabel.CENTER);									// de tabla
			for(int i = 0; i < data.length; i++) {
				tableSearch.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);			// Centrando columnas
			}
			
			resizeColumnWidth(tableSearch);															// Propiedades de la tabla
			tableSearch.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);									// En proceso
			scrollSearch.setViewportView(tableSearch);
			System.out.println("POs [INFO]: Tabla creada: 'En proceso...'");
		}
		else {																						// Si no existen datos
			lblNoResults.setText("No hay resultados");												// Texto de la etiqueta
			scrollSearch.setViewportView(lblNoResults);												// Sin resultados modificado
			System.out.println("Search [INFO]: Tabla En proceso... no creada por falta de datos");
		}
	}
	
	// Modificación de tamaño de columnas
	private void resizeColumnWidth(JTable table) {
		final TableColumnModel columnModel = table.getColumnModel();								// Obteniendo modelo de tabla
		for (int column = 0; column < table.getColumnCount(); column++) {							// Recorriendo columnas
			int width = 50;																			// Anchura mínima
		    for (int row = 0; row < table.getRowCount(); row++) {									// Recorriendo datos de columna
		    	TableCellRenderer renderer = table.getCellRenderer(row, column);
		        Component comp = table.prepareRenderer(renderer, row, column);
		        width = Math.max(comp.getPreferredSize().width +1 , width);
		    }
		    if(width > 300)
		        width=300;
		        columnModel.getColumn(column).setPreferredWidth(width);								// Asignando tamaño a columna 
		    }
		}
	
	// Getters
	private String[] getTitles() {
		return titles;
	}
	
	private int getKey() {
		return key;
	}
	
	// Setters
	public void setTitles(ArrayList<String> titles) {
		this.titles = titles.toArray(new String[titles.size()]); 
	}
	
	public void setCombo() {
		comboFilter.setModel(new DefaultComboBoxModel<String>(getTitles()));
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	// Cierre de ventana
	public void close() {
		dispose();
	}
}

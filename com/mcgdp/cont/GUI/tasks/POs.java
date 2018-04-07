package mcgdp.cont.GUI.tasks;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class POs {

	private JFrame frmACPO;
	// private JFrame frmPOs;
	private JTable tableProcess;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					POs window = new POs();
					window.frmACPO.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public POs() {
		initialize();
	}
	
	public void close() {
		frmACPO.setVisible(false);
		frmACPO.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmACPO = new JFrame();
		frmACPO.setTitle("Auxiliar Contable");
		frmACPO.setBounds(43, 24, 1280, 720);
		frmACPO.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmACPO.setResizable(false);
		frmACPO.getContentPane().setLayout(null);
		ImageIcon icon = new ImageIcon("img/icon-sm.png");
		frmACPO.setIconImage(icon.getImage());
		
		JButton btnBack = new JButton("Atrás");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Image back = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnBack.setIcon(new ImageIcon(back));
		btnBack.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0) {
				// Index i = new Index();
				// i.main(null);
				close();
			}
		});
		btnBack.setBounds(0, 0, 119, 40);
		frmACPO.getContentPane().add(btnBack);
		
		JButton btnSearch = new JButton("Búsqueda");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearch.setBounds(176, 0, 144, 40);
		frmACPO.getContentPane().add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Image search = new ImageIcon(this.getClass().getResource("/search.png")).getImage();
		btnSearch.setIcon(new ImageIcon(search));
		
		JButton btnAdd = new JButton("Añadir");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAdd.setBounds(360, 0, 119, 40);
		frmACPO.getContentPane().add(btnAdd);
		Image add = new ImageIcon(this.getClass().getResource("/add.png")).getImage();
		btnAdd.setIcon(new ImageIcon(add));
		
		JButton btnEdit = new JButton("Editar");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEdit.setBounds(530, 0, 119, 40);
		frmACPO.getContentPane().add(btnEdit);
		Image edit = new ImageIcon(this.getClass().getResource("/edit.png")).getImage();
		btnEdit.setIcon(new ImageIcon(edit));
		
		JButton btnDel = new JButton("Eliminar");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDel.setBounds(700, 0, 119, 40);
		frmACPO.getContentPane().add(btnDel);
		Image del = new ImageIcon(this.getClass().getResource("/delete.png")).getImage();
		btnDel.setIcon(new ImageIcon(del));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 40, 1274, 651);
		frmACPO.getContentPane().add(scrollPane);
				
		JPanel panel = new JPanel();
		panel.setBorder(null);
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(1254, 987));
		
		JLabel lblProcess = new JLabel("En proceso...");
		lblProcess.setBounds(20, 0, 150, 32);
		lblProcess.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProcess.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblProcess);
		Image process = new ImageIcon(this.getClass().getResource("/inprocess.png")).getImage();
		lblProcess.setIcon(new ImageIcon(process));
		
		JScrollPane scrollProcess = new JScrollPane();
		scrollProcess.setBounds(10, 35, 1234, 300);
		panel.add(scrollProcess);
		
		tableProcess = new JTable();
		scrollProcess.setViewportView(tableProcess);
		/* try 
		{
			String query = "select * from user where";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			System.out.println("Cargando datos en proceso...");
			tableProcess.setModel(DbUtils.resultSetToTableModel(rs));
			
			ps.close();
			rs.close();
		}
		catch (Exception d) {
			JOptionPane.showMessageDialog(frmPOs, "No se pudieron cargar los datos en proceso: "+d, 
					"Auxiliar Contable", JOptionPane.ERROR_MESSAGE);
			d.printStackTrace();
		} */
		
		JSeparator separatorTop = new JSeparator();
		separatorTop.setBounds(10, 339, 1234, 2);
		panel.add(separatorTop);
		
		JLabel lblComplets = new JLabel("Completos");
		lblComplets.setBounds(20, 340, 150, 32);
		lblComplets.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblComplets);
		Image ok = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		lblComplets.setIcon(new ImageIcon(ok));
				
		JSeparator separatorBot = new JSeparator();
		separatorBot.setBounds(10, 638, 1234, 2);
		panel.add(separatorBot);
		
		JLabel lblCanceled = new JLabel("Cancelados");
		lblCanceled.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCanceled.setBounds(20, 639, 150, 32);
		panel.add(lblCanceled);
		Image cancel = new ImageIcon(this.getClass().getResource("/canceled.png")).getImage();
		lblCanceled.setIcon(new ImageIcon(cancel));
	}
}

package mcgdp.cont.GUI.tasks;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import mcgdp.cont.GUI.Main.Index;

public class Pays {

	private JFrame frmACP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pays window = new Pays();
					window.frmACP.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pays() {
		initialize();
	}
	
	public void close() {
		frmACP.setVisible(false);
		frmACP.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmACP = new JFrame();
		frmACP.setTitle("Auxiliar Contable");
		frmACP.setBounds(43, 24, 1280, 720);
		frmACP.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmACP.setResizable(false);
		ImageIcon icon = new ImageIcon("img/icon-sm.png");
		frmACP.setIconImage(icon.getImage());
		frmACP.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("Atrás");
		Image back = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnBack.setIcon(new ImageIcon(back));
		btnBack.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0) {
				Index m = new Index();
				m.main(null);
				close();
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		frmACP.getContentPane().add(btnBack);
	}

}
// ############################################################################################## //
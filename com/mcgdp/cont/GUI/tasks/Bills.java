package mcgdp.cont.GUI.tasks;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import mcgdp.cont.GUI.Main.Index;

import java.awt.TextArea;

public class Bills {

	private JFrame frmACB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bills window = new Bills();
					window.frmACB.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Bills() {
		initialize();
	}
	
	public void close() {
		frmACB.setVisible(false);
		frmACB.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmACB = new JFrame();
		frmACB.setTitle("Auxiliar Contable");
		frmACB.setBounds(43, 24, 1280, 720);
		frmACB.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmACB.setResizable(false);
		frmACB.getContentPane().setLayout(null);
		ImageIcon icon = new ImageIcon("img/icon-sm.png");
		frmACB.setIconImage(icon.getImage());
		
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
		frmACB.getContentPane().add(btnBack);
	}
}
// ######################################################################################### //
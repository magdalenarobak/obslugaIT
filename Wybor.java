package it;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Wybor {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wybor window = new Wybor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Wybor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 686, 411);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWybierzOpcj = new JLabel("Wybierz opcj\u0119");
		lblWybierzOpcj.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblWybierzOpcj.setBounds(241, 88, 210, 74);
		frame.getContentPane().add(lblWybierzOpcj);
		
		JButton btnZgoszenie = new JButton("Zg\u0142oszenie");
		btnZgoszenie.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnZgoszenie.setBounds(79, 205, 196, 51);
		frame.getContentPane().add(btnZgoszenie);
		
		JButton btnAdministrator = new JButton("Administrator");
		btnAdministrator.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnAdministrator.setBounds(407, 204, 210, 52);
		frame.getContentPane().add(btnAdministrator);
	}
}

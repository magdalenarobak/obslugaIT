package it;

import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Wybor {

	private JFrame frame;

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

	Connection polaczeniezbaza=null;
	
	public Wybor() {
		initialize();
		polaczeniezbaza = Polaczeniezbaza.dbPolaczenie();
	}

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
		btnZgoszenie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose();
				Zgloszenia administrator = new Zgloszenia();
				administrator.setVisible(true);
	
			}
		});
		btnZgoszenie.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnZgoszenie.setBounds(79, 205, 196, 51);
		frame.getContentPane().add(btnZgoszenie);
		
		JButton btnAdministrator = new JButton("Administrator");
		btnAdministrator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
				    JFrame frame = new JFrame("Admin");
				    int code = Integer.parseInt(JOptionPane.showInputDialog(frame, "Wprowadz haslo", "Admin", JOptionPane.WARNING_MESSAGE));
				   
				    if (code == 1029)
				    {
				    System.out.printf("OK");
				    
				    frame.dispose();
			    	Admin zgloszenie = new Admin();
			    	zgloszenie.setVisible(true);
					
				    }
				    else {
				    JOptionPane.showMessageDialog(null, "B³¹d autoryzacji");

				    }
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				  
			}
		});
		btnAdministrator.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnAdministrator.setBounds(407, 204, 210, 52);
		frame.getContentPane().add(btnAdministrator);
	}
}

package it;
/**
 * Klasa tworzaca okno wyboru i przekierowywujaca nas do nastepnych okien
 * 
 * @author Magdalena Robak
 * @version 1.0.0
 * 
 * 
 */
import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.sun.prism.Image;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Wybor {

	private JFrame frame;
	/**
	 * Uruchomienie aplikacji
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

	Connection polaczeniezbaza=null;
	
	/**
	 * Utworzenie aplikacji. Utworzenie polaczenia z baza danych.
	 */
	public Wybor() {
		initialize();
		polaczeniezbaza = Polaczeniezbaza.dbPolaczenie();
	}

	/**
	 * Inicjacja zawartosci ramki.
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 878, 496);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWybierzOpcj = new JLabel("Wybierz opcj\u0119");
		lblWybierzOpcj.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblWybierzOpcj.setBounds(392, 71, 210, 74);
		frame.getContentPane().add(lblWybierzOpcj);
		
		JButton btnZgoszenie = new JButton("Zg\u0142oszenie");
		java.awt.Image obraz1 = new ImageIcon(this.getClass().getResource("/help.png")).getImage();
		btnZgoszenie.setIcon(new ImageIcon(obraz1));
		
		btnZgoszenie.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				zgloszenie();
	
			}
		});
		btnZgoszenie.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnZgoszenie.setBounds(24, 251, 331, 97);
		frame.getContentPane().add(btnZgoszenie);
		
		JButton btnAdministrator = new JButton("Administrator");
		java.awt.Image obraz2 = new ImageIcon(this.getClass().getResource("/admin.png")).getImage();
		btnAdministrator.setIcon(new ImageIcon(obraz2));
		
		btnAdministrator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				administrator();
				  
			}
		});
		btnAdministrator.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnAdministrator.setBounds(452, 251, 369, 97);
		frame.getContentPane().add(btnAdministrator);
		
		JLabel lblObraz = new JLabel("");
		java.awt.Image obraz = new ImageIcon(this.getClass().getResource("/pomoc.png")).getImage();
		lblObraz.setIcon(new ImageIcon(obraz));
		lblObraz.setBounds(240, 32, 128, 138);
		frame.getContentPane().add(lblObraz);
	}
	
	/**
	 * Uruchomienie nowego okna po nacisnieciu przycisku Zgloszenie.
	 */
	public void zgloszenie() {
		
		frame.dispose();
		Zgloszenia administrator = new Zgloszenia();
		administrator.setVisible(true);
	}
	
	/**
	 * Uruchomienie nowego okna do wpisania hasla. Po wpisaniu prawidlowego hasla uruchomienie nowego okna.
	 * 
	 */
	public void administrator() {
		
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
		    JOptionPane.showMessageDialog(null, "Blad autoryzacji");

		    }
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
	}
}

package it;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Zgloszenia extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsterka;
	private JTextField txtMiejsce;
	private JTextField txtOsoba;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Zgloszenia frame = new Zgloszenia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection polaczeniezbaza=null;
	
	public Zgloszenia() {
		polaczeniezbaza = Polaczeniezbaza.dbPolaczenie();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsterkaKrytyczna = new JLabel("Usterka krytyczna");
		lblUsterkaKrytyczna.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUsterkaKrytyczna.setBounds(76, 49, 171, 28);
		contentPane.add(lblUsterkaKrytyczna);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(335, 49, 185, 35);
		contentPane.add(comboBox_1);
		
		JLabel lblObszarUsterki = new JLabel("Obszar usterki");
		lblObszarUsterki.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblObszarUsterki.setBounds(76, 118, 171, 35);
		contentPane.add(lblObszarUsterki);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(335, 115, 185, 38);
		contentPane.add(comboBox_2);
		
		JLabel lblDokadnyOpisUsterki = new JLabel("Dok\u0142adny opis usterki");
		lblDokadnyOpisUsterki.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDokadnyOpisUsterki.setBounds(76, 398, 171, 42);
		contentPane.add(lblDokadnyOpisUsterki);
		
		txtUsterka = new JTextField();
		txtUsterka.setText("Usterka");
		txtUsterka.setBounds(286, 364, 334, 117);
		contentPane.add(txtUsterka);
		txtUsterka.setColumns(10);
		
		JLabel lblMiejsceUsterki = new JLabel("Miejsce usterki");
		lblMiejsceUsterki.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMiejsceUsterki.setBounds(76, 294, 157, 49);
		contentPane.add(lblMiejsceUsterki);
		
		txtMiejsce = new JTextField();
		txtMiejsce.setText("Miejsce");
		txtMiejsce.setBounds(286, 290, 334, 63);
		contentPane.add(txtMiejsce);
		txtMiejsce.setColumns(10);
		
		JLabel lblOsobaZgaszajca = new JLabel("Osoba zg\u0142aszaj\u0105ca");
		lblOsobaZgaszajca.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblOsobaZgaszajca.setBounds(76, 218, 157, 42);
		contentPane.add(lblOsobaZgaszajca);
		
		txtOsoba = new JTextField();
		txtOsoba.setText("Osoba");
		txtOsoba.setBounds(286, 218, 334, 42);
		contentPane.add(txtOsoba);
		txtOsoba.setColumns(10);
		
		JButton btnZgo = new JButton("Zg\u0142o\u015B");
		btnZgo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				LocalDate today = LocalDate.now();
				
				try {
				String q = "insert into zgloszenia (Data_zgloszenia,Miejsce,Realizacja,Opis_problemu,Obszar_usterki,Osoba) values (?,?,?,?,?,?)";
				PreparedStatement pst = polaczeniezbaza.prepareStatement(q);
				pst.setString(1, (today.getYear() + "-" + today.getMonth()+ "-" +today.getDayOfMonth()) );
				pst.setString(2, txtMiejsce.getText() );
				pst.setString(3, "nie" );
				pst.setString(4, txtUsterka.getText() );
				pst.setString(5, txtUsterka.getText() );
				pst.setString(6, txtOsoba.getText() );
				
				JOptionPane.showMessageDialog(null, "Zg³oszenie dodane");
				
				pst.execute();
				pst.close();
			
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, "B³¹d po³¹czenia");
				}
			}
		});
		btnZgo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZgo.setBounds(630, 447, 99, 34);
		contentPane.add(btnZgo);
	}
}

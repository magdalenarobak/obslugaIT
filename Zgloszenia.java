package it;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Date;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Klasa s³u¿¹ca do dodania zg³oszenia do bazy danych.
 * @author Magdalena Robak
 *
 */
public class Zgloszenia extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsterka;
	private JTextField txtMiejsce;
	private JTextField txtOsoba;
	private JComboBox comboBox ;
	private JComboBox comboBox_2;
	private JComboBox comboBox_1;
	private JFrame frame;

	/**
	 * Uruchomienie aplikacji.
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
	private JButton btnNiezrealizowane;
	
	/**
	 * Inicjacja zawartoœci ramki.
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public Zgloszenia() {
		polaczeniezbaza = Polaczeniezbaza.dbPolaczenie();
		frame = new JFrame();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsterkaKrytyczna = new JLabel("Usterka krytyczna");
		lblUsterkaKrytyczna.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUsterkaKrytyczna.setBounds(76, 74, 171, 28);
		contentPane.add(lblUsterkaKrytyczna);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"tak", "nie"}));
		comboBox_1.setBounds(335, 74, 185, 35);
		contentPane.add(comboBox_1);
		
		JLabel lblObszarUsterki = new JLabel("Obszar usterki");
		lblObszarUsterki.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblObszarUsterki.setBounds(76, 139, 171, 35);
		contentPane.add(lblObszarUsterki);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"sprz\u0119t", "sie\u0107", "AMMS"}));
		comboBox_2.setBounds(335, 140, 185, 38);
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
		txtMiejsce.setText("Nr pokoju");
		txtMiejsce.setBounds(286, 290, 139, 53);
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
				
				zglos();
			}
		});
		btnZgo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZgo.setBounds(630, 447, 99, 34);
		contentPane.add(btnZgo);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Rzesz\u00F3w - Szopena", "Rzesz\u00F3w - Powsta\u0144c\u00F3w Warszawy", "Jas\u0142o", "Jasionka", "Mielec"}));
		comboBox.setBounds(453, 294, 167, 35);
		contentPane.add(comboBox);
		
		btnNiezrealizowane = new JButton("Wy\u015Bwietl niezrealizowane\r\n");
		btnNiezrealizowane.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNiezrealizowane.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				wyswietlNiezrealizowane();
			}
		});
		btnNiezrealizowane.setBounds(168, 11, 297, 35);
		contentPane.add(btnNiezrealizowane);
		
	}

	/**
	 * Metoda pobieraj¹ca z bazy danych najnowszy numer zg³oszenia.
	 * @return numer Zwrot numeru zg³oszenia.
	 */
	private int pobierzNumer() {
		
		try {
			
			String q="select Numer_zgloszenia from zgloszenia";
			PreparedStatement pst = polaczeniezbaza.prepareStatement(q);
			
			ResultSet rs=pst.executeQuery();
			int wynik=0;
			while (rs.next()) {
                wynik = rs.getInt("Numer_zgloszenia");
                
			}
			int numer = wynik+1;
			
			rs.close();
			pst.close();
			return numer;
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "B³êdny numer");
		}
		return 0;
		
	}
	
	/**
	 * Metoda s³u¿¹ca do wstawienia do bazy danych uzupe³nionych przez u¿ytkownika dotycz¹cych zg³oszenia.
	 */
	private void zglos() {
		LocalDate today = LocalDate.now();
		
		try {
		String q = "insert into zgloszenia (Data_zgloszenia,Miejsce,Realizacja,Opis_problemu,Obszar_usterki,Osoba,Usterka_krytyczna) values (?,?,?,?,?,?,?)";
		PreparedStatement pst = polaczeniezbaza.prepareStatement(q);
		String krytyczna = (String)comboBox_1.getSelectedItem();
		String usterka = (String)comboBox_2.getSelectedItem();
		String lokalizacja = (String)comboBox.getSelectedItem();
		pst.setString(1, (today.getYear() + "-" + today.getMonth()+ "-" +today.getDayOfMonth()) );
		pst.setString(2, txtMiejsce.getText()+ lokalizacja );
		pst.setString(3, "nie" );
		pst.setString(4, txtUsterka.getText() );
		pst.setString(5, usterka );
		pst.setString(6, txtOsoba.getText() );
		pst.setString(7, krytyczna);
		

		JOptionPane.showMessageDialog(null, "Zg³oszenie dodane"+ "\n Twój numer zg³oszenia to:" + " " +pobierzNumer());
		
		pst.execute();
		pst.close();
	
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "B³¹d po³¹czenia");
		}
	}
	
	/**
	 * Metoda tworzy nowe okno.
	 */
	private void wyswietlNiezrealizowane() {
		
		frame.dispose();
		Niezrealizowane niezrealizowane = new Niezrealizowane();
		niezrealizowane.setVisible(true);
	}
}

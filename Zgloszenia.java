package it;

import java.sql.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.Font;
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

	/**
	 * Create the frame.
	 */
	public Zgloszenia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDziaUsterki = new JLabel("Dzia\u0142 usterki");
		lblDziaUsterki.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDziaUsterki.setBounds(76, 24, 123, 28);
		contentPane.add(lblDziaUsterki);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(335, 20, 185, 42);
		contentPane.add(comboBox);
		
		JLabel lblUsterkaKrytyczna = new JLabel("Usterka krytyczna");
		lblUsterkaKrytyczna.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUsterkaKrytyczna.setBounds(76, 73, 171, 28);
		contentPane.add(lblUsterkaKrytyczna);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(335, 73, 185, 35);
		contentPane.add(comboBox_1);
		
		JLabel lblObszarUsterki = new JLabel("Obszar usterki");
		lblObszarUsterki.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblObszarUsterki.setBounds(76, 118, 171, 35);
		contentPane.add(lblObszarUsterki);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(335, 119, 185, 38);
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
		
		JLabel lblDataZgoszenia = new JLabel("Data wyst\u0105pienia");
		lblDataZgoszenia.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDataZgoszenia.setBounds(76, 165, 157, 35);
		contentPane.add(lblDataZgoszenia);
		
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
		btnZgo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZgo.setBounds(630, 447, 99, 34);
		contentPane.add(btnZgo);
	}
}

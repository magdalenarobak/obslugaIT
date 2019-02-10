package it;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.Font;
public class Admin extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(173, 41, 145, 28);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(173, 80, 145, 28);
		contentPane.add(comboBox_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 301, 821, 146);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblDataZgoszenia = new JLabel("Data zg\u0142oszenia");
		lblDataZgoszenia.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDataZgoszenia.setBounds(10, 41, 135, 28);
		contentPane.add(lblDataZgoszenia);
		
		JLabel lblZrealizowane = new JLabel("Zrealizowane");
		lblZrealizowane.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblZrealizowane.setBounds(10, 81, 111, 21);
		contentPane.add(lblZrealizowane);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(173, 119, 145, 33);
		contentPane.add(comboBox_2);
		
		JLabel lblMiejsce = new JLabel("Miejsce");
		lblMiejsce.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMiejsce.setBounds(10, 116, 135, 33);
		contentPane.add(lblMiejsce);
		
		JLabel lblNumerZgoszenia = new JLabel("Numer zg\u0142oszenia");
		lblNumerZgoszenia.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNumerZgoszenia.setBounds(10, 160, 135, 28);
		contentPane.add(lblNumerZgoszenia);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(173, 163, 145, 28);
		contentPane.add(comboBox_3);
		
		JButton btnSzukaj = new JButton("Szukaj");
		btnSzukaj.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSzukaj.setBounds(345, 252, 89, 23);
		contentPane.add(btnSzukaj);
		
		textField = new JTextField();
		textField.setBounds(461, 119, 213, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNumerZgoszenia_1 = new JLabel("Numer zg\u0142oszenia");
		lblNumerZgoszenia_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNumerZgoszenia_1.setBounds(471, 77, 202, 28);
		contentPane.add(lblNumerZgoszenia_1);
		
		JButton btnZrealizuj = new JButton("Zrealizuj");
		btnZrealizuj.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZrealizuj.setBounds(505, 163, 135, 23);
		contentPane.add(btnZrealizuj);
		
		JLabel lblObszarUsterki = new JLabel("Obszar usterki");
		lblObszarUsterki.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblObszarUsterki.setBounds(10, 199, 135, 28);
		contentPane.add(lblObszarUsterki);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(173, 202, 145, 28);
		contentPane.add(comboBox_4);
	}
}

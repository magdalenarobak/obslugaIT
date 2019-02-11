package it;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
public class Admin extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_4;
	

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

	Connection polaczeniezbaza=null;
	private JTextField textField_1;
	
	public void wypelnienieComboBox() {
		try {
			String q ="select distinct Data_zgloszenia from zgloszenia group by Data_zgloszenia";
			PreparedStatement pst =polaczeniezbaza.prepareStatement(q);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {

				comboBox.addItem(rs.getString("Data_zgloszenia"));
		
			}
		}catch(Exception e) {
				e.printStackTrace();
				}
	}
	
	public void wypelnienieComboBox_2() {
		try {
			String q ="select distinct Miejsce from zgloszenia group by Miejsce";
			PreparedStatement pst =polaczeniezbaza.prepareStatement(q);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				comboBox_2.addItem(rs.getString("Miejsce"));
			}
		}catch(Exception e) {
				e.printStackTrace();
				}
	}
	
	public Admin() {
		polaczeniezbaza = Polaczeniezbaza.dbPolaczenie();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String data = (String)comboBox.getSelectedItem();
					String q = "select * from zgloszenia where Data_zgloszenia=?";
					PreparedStatement pst = polaczeniezbaza.prepareStatement(q);
					pst.setString(1,data);
					ResultSet rs = pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		comboBox.setBounds(173, 41, 145, 28);
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String realizacja = (String)comboBox_1.getSelectedItem();
					String q = "select * from zgloszenia where Realizacja=?";
					PreparedStatement pst = polaczeniezbaza.prepareStatement(q);
					pst.setString(1,realizacja);
					ResultSet rs = pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
		});

		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"tak", "nie"}));
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
		
		comboBox_2 = new JComboBox();
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String miejsce = (String)comboBox_2.getSelectedItem();
					String q = "select * from zgloszenia where Miejsce=?";
					PreparedStatement pst = polaczeniezbaza.prepareStatement(q);
					pst.setString(1,miejsce);
					ResultSet rs = pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
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
		
		JButton btnSzukaj = new JButton("Szukaj");
		btnSzukaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String q="select * from zgloszenia where Numer_zgloszenia=?";
					PreparedStatement pst = polaczeniezbaza.prepareStatement(q);
					pst.setString(1,textField.getText());
					
					ResultSet rs=pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					rs.close();
					pst.close();
					
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, "B³êdny numer");
				}
			}
		});
		btnSzukaj.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSzukaj.setBounds(328, 163, 89, 23);
		contentPane.add(btnSzukaj);
		
		textField = new JTextField();
		textField.setBounds(173, 163, 145, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNumerZgoszenia_1 = new JLabel("Numer zg\u0142oszenia do realizacji");
		lblNumerZgoszenia_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNumerZgoszenia_1.setBounds(463, 66, 265, 28);
		contentPane.add(lblNumerZgoszenia_1);
		
		JButton btnZrealizuj = new JButton("Zrealizuj");
		btnZrealizuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String akceptacja = "tak";
					String q = "update zgloszenia set Realizacja='"+akceptacja+"' where Numer_zgloszenia='"+textField_1.getText()+"' ";
					PreparedStatement pst = polaczeniezbaza.prepareStatement(q);
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Zlecenie zrealizowane");
					pst.close();
					
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, "B³êdny numer zlecenia");
				}
			
			}
		});
		btnZrealizuj.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnZrealizuj.setBounds(520, 139, 135, 23);
		contentPane.add(btnZrealizuj);
		
		JLabel lblObszarUsterki = new JLabel("Obszar usterki");
		lblObszarUsterki.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblObszarUsterki.setBounds(10, 199, 135, 28);
		contentPane.add(lblObszarUsterki);
		
		comboBox_4 = new JComboBox();
		comboBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String usterka = (String)comboBox_4.getSelectedItem();
					String q = "select * from zgloszenia where Obszar_usterki=?";
					PreparedStatement pst = polaczeniezbaza.prepareStatement(q);
					pst.setString(1,usterka);
					ResultSet rs = pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"sprz\u0119t", "sie\u0107", "AMMS"}));
		comboBox_4.setBounds(173, 202, 145, 28);
		contentPane.add(comboBox_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(486, 92, 201, 36);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUsterkaKrytyczna = new JLabel("Usterka krytyczna");
		lblUsterkaKrytyczna.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUsterkaKrytyczna.setBounds(10, 238, 135, 28);
		contentPane.add(lblUsterkaKrytyczna);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String krytyczna = (String)comboBox_3.getSelectedItem();
					String q = "select * from zgloszenia where Usterka_krytyczna=?";
					PreparedStatement pst = polaczeniezbaza.prepareStatement(q);
					pst.setString(1,krytyczna);
					ResultSet rs = pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"tak", "nie"}));
		comboBox_3.setBounds(173, 241, 145, 28);
		contentPane.add(comboBox_3);
		wypelnienieComboBox();
		wypelnienieComboBox_2();
	}
}

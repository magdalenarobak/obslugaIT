package it;

import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

public class Niezrealizowane extends JFrame {

	private JPanel contentPane;
	private JTable table;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Niezrealizowane frame = new Niezrealizowane();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection polaczeniezbaza=null;
	public Niezrealizowane() {
		
		polaczeniezbaza = Polaczeniezbaza.dbPolaczenie();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 60, 628, 326);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		try {
			String x = "nie";
			String q="select Numer_zgloszenia, Data_zgloszenia, Usterka_krytyczna from zgloszenia where Realizacja='"+x+"'";
			PreparedStatement pst = polaczeniezbaza.prepareStatement(q);
			
			ResultSet rs=pst.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
			rs.close();
			pst.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}

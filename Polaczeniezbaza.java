package it;

import java.sql.*;
import javax.swing.*;


/**
 * Klasa umo¿liwiaj¹ca po³¹czenie z baz¹ danych.
 * @author Magdalena Robak
 *
 */
public class Polaczeniezbaza {
	
	Connection polaczenie = null;
	
	/**
	 * Metoda otwieraj¹ca po³¹czenie z baz¹
	 * @return polaczenie zwrot w postaci obiektu Connection
	 */
	public static Connection dbPolaczenie()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			Connection polaczenie=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Ma³gosia\\Desktop\\IT\\zgloszenia.sqlite");
			System.out.println("Poprawne polaczenie z baza");
			return polaczenie;
			
		}catch(Exception e) 
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}

}


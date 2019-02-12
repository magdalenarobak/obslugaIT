package it;

import java.sql.*;
import javax.swing.*;


/**
 * Klasa umo�liwiaj�ca po��czenie z baz� danych.
 * @author Magdalena Robak
 *
 */
public class Polaczeniezbaza {
	
	Connection polaczenie = null;
	
	/**
	 * Metoda otwieraj�ca po��czenie z baz�
	 * @return polaczenie zwrot w postaci obiektu Connection
	 */
	public static Connection dbPolaczenie()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			Connection polaczenie=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Ma�gosia\\Desktop\\IT\\zgloszenia.sqlite");
			System.out.println("Poprawne polaczenie z baza");
			return polaczenie;
			
		}catch(Exception e) 
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}

}


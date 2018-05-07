package Fachlogik;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Fachlogik.Medienverwaltung.Medienverwaltung;
import Views.ViewController;

public class Bibliothek 
{
	static Views.ViewController vc = new ViewController();
	static Medienverwaltung mv = new Medienverwaltung();
	
	public static void main(String[] args)
	{
		vc.start();
		
		//unnötiger kommentar
		//unnötiger kommentar 2
		String url = "jdbc:mysql://localhost:3306/bib?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username = "admin";
		String password = "admin";
		
		try(Connection conneciton = DriverManager.getConnection(url,username,password))
		{
			System.out.println("Database connected!");
		}
		catch(SQLException e)
		{
			throw new IllegalStateException("Cannot connect the database", e);
		}
	}
	
	
	
}

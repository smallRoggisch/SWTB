package Fachlogik;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import Fachlogik.Medienverwaltung.Medienverwaltung;
import Fachlogik.Medienverwaltung.Medium;
import Views.ViewController;

public class Bibliothek 
{
	static Views.ViewController vc = new ViewController();
	static Medienverwaltung mv = new Medienverwaltung();
	
	public static void main(String[] args)
	{
		vc.start();
		

		String url = "jdbc:mysql://localhost:3306/bib?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username = "admin";
		String password = "admin";
		
		
		try
		{
			Connection connection = DriverManager.getConnection(url,username,password);
			
			
			//connection.createStatement().executeUpdate(s);
			ResultSet rs = connection.createStatement().executeQuery("select * from autor;");
			System.out.println("Database connected!");
			rs.next();
			System.out.println(rs.getString(3));
			
		}
		catch(SQLException e)
		{
			throw new IllegalStateException("Cannot connect the database", e);
		}
		
	}
	
	
	
}

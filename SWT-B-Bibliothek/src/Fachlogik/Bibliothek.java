package Fachlogik;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Fachlogik.Medienverwaltung.Medienverwaltung;
import Fachlogik.Medienverwaltung.Medium;
import Views.ViewController;

public class Bibliothek 
{
	static Views.ViewController vc = new ViewController();
	static Medienverwaltung mv = new Medienverwaltung();
	static final String url = "jdbc:mysql://localhost:3306/bib?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	static final String username = "admin";
	static final String password = "admin";
	
	public static void main(String[] args)
	{
		vc.start();
		

		
		
		
		try
		{
			Connection connection = DriverManager.getConnection(url,username,password);
			
			
			//connection.createStatement().executeUpdate(s);
			//ResultSet rs = connection.createStatement().executeQuery("select * from autor;");
			System.out.println("Database connected!");
			//rs.next();
			//System.out.println(rs.getString(3));
			load();
		}
		catch(SQLException e)
		{
			throw new IllegalStateException("Cannot connect the database", e);
		}
		for (Autor autor : mv.getAutoren()) 
		{
			System.out.println(autor.getautorVorname() + autor.getautorNachname());
		}
	}
	
	public static void load()
	{
		try {
			Connection connection = DriverManager.getConnection(url,username,password);
			ResultSet rs = connection.createStatement().executeQuery("select * from autor;");
			ArrayList<Autor> autor = new ArrayList<Autor>();
			while(rs.next())
			{
				Autor a = new Autor(rs.getString(2), rs.getString(3), rs.getInt(1));
				autor.add(a);
			}
			mv.setAutorList(autor);
			
		}
		catch(SQLException e)
		{
			throw new IllegalStateException("Cannot connect the database", e);
		}
	}
	
	
	
}

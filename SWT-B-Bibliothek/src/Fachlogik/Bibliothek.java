package Fachlogik;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Fachlogik.Medienverwaltung.Buch;
import Fachlogik.Medienverwaltung.CD;
import Fachlogik.Medienverwaltung.Medienverwaltung;
import Fachlogik.Medienverwaltung.Medium;
import Views.ViewController;

public final class Bibliothek 
{
	private static Bibliothek uniqueInstance = null;
	static Views.ViewController vc = new ViewController();
	static Medienverwaltung mv = new Medienverwaltung();
	static final String url = "jdbc:mysql://localhost:3306/bib?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	static final String username = "admin";
	static final String password = "admin";
	
	public static void main(String[] args)
	{
		
		
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
			
			ResultSet rs2 = connection.createStatement().executeQuery("select * from cd;");
			while(rs2.next())
			{
				
				CD c = new CD(mv.getAutorbyId(rs2.getInt(4)), rs2.getString(6), rs2.getString(2), rs2.getString(1), rs2.getString(3),rs2.getBoolean(5));
				mv.addCd(c);
			}
			
			ResultSet rs3 = connection.createStatement().executeQuery("select * from buch;");
			while(rs3.next())
			{
				Buch b = new Buch(mv.getAutorbyId(rs3.getInt(4)), rs3.getString(6), rs3.getString(2), rs3.getString(1), rs3.getString(3),rs3.getBoolean(5));
				mv.addBuch(b);
			}
			
		}
		catch(SQLException e)
		{
			throw new IllegalStateException("Cannot connect the database", e);
		}
		vc.start(mv);
	}
	
	public static Bibliothek instance()
	{
		if(uniqueInstance == null)
		{
			uniqueInstance = new Bibliothek();
		}
		return uniqueInstance;
	}
	
}

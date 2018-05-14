package Fachlogik.Medienverwaltung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Fachlogik.Autor;

public class CD extends Medium{
	
	private String herausgeber;
	
	public CD(Autor autor, String herausgeber, String titel, String id, String genre)
	{
		this.autor = autor;
		this.herausgeber = herausgeber;
		this.setTitel(titel);
		this.setId(id);
		this.setGenre(genre);
	}
		
	public void setHerausgeber(String herausgeber)
	{
		this.herausgeber = herausgeber;
	}
	
	public String getHerausgeber()
	{
		return herausgeber;
	}

	@Override
	public void save() {
		String databasequerry;
		databasequerry= "insert into cd values("
		+ this.getId() + ", '"
		+ this.getTitel() + "', '"
		+ this.getGenre() + "', '"
		+ this.getHerausgeber() + "', "
		+ this.istAusgeliehen() + ");";
		
		String url = "jdbc:mysql://localhost:3306/bib?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username = "admin";
		String password = "admin";
		
		try
		{
			Connection connection = DriverManager.getConnection(url,username,password);
			connection.createStatement().executeUpdate(databasequerry);
		}
		catch(SQLException e)
		{
			throw new IllegalStateException("Cannot connect the database", e);
		}
	}
}

package Fachlogik.Medienverwaltung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Fachlogik.Autor;

public class CD extends Medium{
	
	private String herausgeber;
	
	public CD(Autor autor, String herausgeber, String titel, String id, String genre, boolean ausgeliehen)
	{
		this.autor = autor;
		this.herausgeber = herausgeber;
		this.setTitel(titel);
		this.setId(id);
		this.setGenre(genre);
		this.setAusgeliehen(ausgeliehen);
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
		databasequerry= "insert into cd values('"
		+ this.getId() + "', '"
		+ this.getTitel() + "', '"
		+ this.getGenre() + "', "
		+ this.autor.getId() +", "
		+ this.istAusgeliehen() + ", '"
		+ this.getHerausgeber()  + "');";
		
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
	
	public void update(boolean ausgeliehen)
	{
		String url = "jdbc:mysql://localhost:3306/bib?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username = "admin";
		String password = "admin";
		try
		{
			Connection connection = DriverManager.getConnection(url,username,password);
			String sql = "update cd set ausgeliehen = " + ausgeliehen + " where idcd='" +getId() + "';";
			connection.createStatement().executeUpdate(sql);
		}
		catch(SQLException e)
		{
			throw new IllegalStateException("Cannot connect the database", e);
		}
	}
}

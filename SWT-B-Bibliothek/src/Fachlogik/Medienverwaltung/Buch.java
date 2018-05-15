package Fachlogik.Medienverwaltung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Fachlogik.Autor;

public class Buch extends Medium{
	
	private String verlag;
		
	public Buch(Autor autor, String verlag, String titel, String id, String genre, boolean ausgeliehen)
	{
		this.autor = autor;
		this.verlag = verlag;
		this.setTitel(titel);
		this.setId(id);
		this.setGenre(genre);
		this.setAusgeliehen(ausgeliehen);
	}
	
	public void setVerlag(String verlag)
	{
		this.verlag = verlag;
	}
	
	public String getVerlag()
	{
		return verlag;
	}
	
	@Override
	public void save()
	{
		String databasequerry;
		databasequerry = "insert into buch values('" 
		+ this.getId() + "', '" 
		+ this.getTitel() + "', '" 
		+ this.getGenre() + "', " 
		+ this.getAutor().getId() + ", " 
		+ this.istAusgeliehen() + ", '" 
		+ this.getVerlag() + "');";

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
			String sql = "update buch set ausgeliehen = " + ausgeliehen + " where idbuch='" +getId() + "';";
			connection.createStatement().executeUpdate(sql);
		}
		catch(SQLException e)
		{
			throw new IllegalStateException("Cannot connect the database", e);
		}
	}

}

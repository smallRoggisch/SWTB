package Fachlogik.Medienverwaltung;

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
}

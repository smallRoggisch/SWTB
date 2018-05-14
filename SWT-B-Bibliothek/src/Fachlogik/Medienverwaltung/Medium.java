package Fachlogik.Medienverwaltung;

import Fachlogik.Autor;

public abstract class Medium {
	
	private String titel;
	private String id;
	private String genre;
	protected Autor autor;
	private boolean ausgeliehen;
	

	public void setTitel(String titel)
	{
		this.titel = titel;
	}
	public String getTitel()
	{
		return titel;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getId()
	{
		return id;
	}
	
	public void setGenre(String genre)
	{
		this.genre = genre;
	}
	
	public String getGenre()
	{
		return genre;
	}
	
	public void setAutor(String autorVorname, String autorNachname, int autorId)
	{
		this.autor = new Autor(autorVorname, autorNachname, autorId);
	}
	
	public Autor getAutor()
	{
		return this.autor;
	}
	
	public void setAusgeliehen(boolean ausgeliehen)
	{
		this.ausgeliehen = ausgeliehen;
	}
	
	public boolean istAusgeliehen()
	{
		return ausgeliehen;
	}
	
	abstract public void save();
		
}

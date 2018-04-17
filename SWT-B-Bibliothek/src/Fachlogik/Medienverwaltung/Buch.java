package Fachlogik.Medienverwaltung;

import Fachlogik.Autor;

public class Buch extends Medium{
	
	private Autor autor;
	private String verlag;
	
	public Buch(String autorVorname, String autorNachname, String verlag, String titel, String id, String genre)
	{
		this.autor = new Autor(autorVorname, autorNachname);		
		this.verlag = verlag;
		this.setTitel(titel);
		this.setId(id);
		this.setGenre(genre);
	}	
	
	public void setVerlag(String verlag)
	{
		this.verlag = verlag;
	}
	
	public String getVerlag()
	{
		return verlag;
	}
	
	public Autor getAutor()
	{
		return autor;
	}
	


}

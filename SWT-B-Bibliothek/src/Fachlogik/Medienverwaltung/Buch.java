package Fachlogik.Medienverwaltung;

import Fachlogik.Autor;

public class Buch extends Medium{
	
	private String verlag;
		
	public Buch(Autor autor, String verlag, String titel, String id, String genre)
	{
		this.autor = autor;
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

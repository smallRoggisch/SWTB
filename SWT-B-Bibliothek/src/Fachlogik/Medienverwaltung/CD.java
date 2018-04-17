package Fachlogik.Medienverwaltung;

public class CD extends Medium{
	
	private String interpret;
	private String herausgeber;
	
	public CD(String interpret, String herausgeber, String titel, String id, String genre)
	{
		this.interpret = interpret;
		this.herausgeber = herausgeber;
		this.setTitel(titel);
		this.setId(id);
		this.setGenre(genre);
	}
	
	public void setInterpret(String interpret)
	{
		this.interpret = interpret;
	}
	
	public String getInterpret()
	{
		return interpret;
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

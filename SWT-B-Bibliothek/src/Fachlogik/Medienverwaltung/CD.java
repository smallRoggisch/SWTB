package Fachlogik.Medienverwaltung;

public class CD extends Medium{
	
	private String herausgeber;
	
	public CD(String interpret, String herausgeber, String titel, String id, String genre)
	{
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

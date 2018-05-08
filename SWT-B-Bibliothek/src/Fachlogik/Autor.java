package Fachlogik;

public class Autor {
	
	private int id;
	private String autorVorname;
	private String autorNachname;
	
	public Autor(String autorVorname, String autorNachname, int id)
	{
		this.id = id;
		this.autorVorname = autorVorname;
		this.autorNachname = autorNachname;
	}
	
	public void setAutorVorname(String autorVorname)
	{
		this.autorVorname = autorVorname;
	}
	 
	
	public String getautorVorname()
	{
		return autorVorname;
	}
	
	public void setAutorNachname(String autorNachname)
	{
		this.autorNachname = autorNachname;
	}
	
	public String getautorNachname()
	{
		return autorNachname;
	}

	public int getId()
	{
		return id;
	}
}

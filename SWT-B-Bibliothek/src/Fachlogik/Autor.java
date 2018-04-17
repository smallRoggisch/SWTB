package Fachlogik;

public class Autor {
	
	private String autorVorname;
	private String autorNachname;
	
	public Autor(String autorVorname, String autorNachname)
	{
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

}

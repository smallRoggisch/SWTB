package Fachlogik.Medienverwaltung;

import java.util.ArrayList;
import java.util.List;

public class Medienverwaltung {
	
	private List<Medium> medien = new ArrayList<Medium>();
	
	public Medienverwaltung()
	{
		
	}
	
	public void addBuch(Buch buch)
	{
		medien.add(buch);
	}
	
	public Buch getBuchById(String id)
	{
		for (Medium medium : medien) {
			if(medium.getClass() == Buch.class)
			{
				if(medium.getId().equals(id))
				{
					return (Buch) medium;
				}
			}
		}
		
		return null;	
	}
	
	public void addCd(CD cd)
	{
		medien.add(cd);
	}
	
	public CD getCdById(String id)
	{
		for (Medium medium : medien) {
			if(medium.getClass() == CD.class)
			{
				if(medium.getId().equals(id))
				{
					return (CD) medium;
				}
			}
		}
		return null;	
	}
	

	//TODO anzahl ausgeliehen ausgeben + sortierte Medienliste ausgeben -> sortiert nach id	
public ArrayList<Medium> getAusgeliehene()
{
	return null;
}
}


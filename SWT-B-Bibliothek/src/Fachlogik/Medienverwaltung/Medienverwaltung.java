package Fachlogik.Medienverwaltung;

import java.util.ArrayList;

public class Medienverwaltung {
	
	private ArrayList<Medium> medien = new ArrayList<Medium>();
	
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
	

	
	public ArrayList<Medium> getAusgeliehene()
	{
		ArrayList<Medium> ausgeliehene = new ArrayList<Medium>();
		for (Medium medium : medien) 
		{
			if(medium.istAusgeliehen())
			{
				ausgeliehene.add(medium);
			}
		}
		return ausgeliehene;
	}
	
	public void save()
	{
		//TODO implemtiere das speichern
	}
	//TODO sortierte Medienliste ausgeben -> sortiert nach id	
}


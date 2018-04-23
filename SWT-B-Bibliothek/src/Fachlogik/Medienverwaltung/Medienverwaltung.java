package Fachlogik.Medienverwaltung;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
	
	public ArrayList<Medium> getSortedList()
	{
		ArrayList<Medium> sortedList = new ArrayList<Medium>();
		sortedList = this.medien;
		
		Collections.sort(sortedList, new Comparator<Medium>(){

			@Override
			public int compare(Medium o1, Medium o2) {
				return o1.getTitel().compareTo(o2.getTitel());
			}			
		});
		
		return sortedList;
	}
	
	public void save()
	{
		//TODO implemtiere das speichern
	}
	//TODO sortierte Medienliste ausgeben -> sortiert nach id	
}


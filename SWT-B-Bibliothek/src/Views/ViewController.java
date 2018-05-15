package Views;

import java.util.ArrayList;

import Fachlogik.Autor;
import Fachlogik.Medienverwaltung.Buch;
import Fachlogik.Medienverwaltung.CD;
import Fachlogik.Medienverwaltung.Medienverwaltung;
import Fachlogik.Medienverwaltung.Medium;

public class ViewController 
{	
	Medienverwaltung medienVerwaltung;
	
	public void start(Medienverwaltung mverwaltung)
	{
		MainView mv = new MainView(this);
		medienVerwaltung = mverwaltung;
	}
	
	//Methode zum zugriff auf bibliothek zum speichern, hört auf action listener
	public void saveBuch(Buch buch)
	{
		buch.save();
		medienVerwaltung.addBuch(buch);
	}
	
	public void saveCD(CD cd)
	{
		cd.save();
		medienVerwaltung.addCd(cd);
	}

	public void mediumAusgeliehen(Medium m)
	{
		medienVerwaltung.setAusgeliehen(m);
	}
	
	public void mediumZurueckGegeben(Medium m)
	{
		medienVerwaltung.setZurueckGegeben(m);
	}
	
	public ArrayList<Medium> getMedien()
	{
		
		ArrayList<Medium> mList = new ArrayList();
		mList = medienVerwaltung.getSortedList();
		return mList;
	}
	
	public ArrayList<Autor> getAutorList()
	{
		//TODO test
		return medienVerwaltung.getAutoren();
	}
}

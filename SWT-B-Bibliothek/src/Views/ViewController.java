package Views;

import java.util.ArrayList;

import Fachlogik.Autor;
import Fachlogik.Observer;
import Fachlogik.Subject;
import Fachlogik.Medienverwaltung.Buch;
import Fachlogik.Medienverwaltung.CD;
import Fachlogik.Medienverwaltung.Medienverwaltung;
import Fachlogik.Medienverwaltung.Medium;

public class ViewController implements Subject
{	
	Medienverwaltung medienVerwaltung;
	private ArrayList<Observer> observers;
	
	public void start(Medienverwaltung mverwaltung)
	{
		MainView mv = new MainView(this);
		medienVerwaltung = mverwaltung;
		observers = new ArrayList<>();
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
		notifyObserver();
	}
	
	public void mediumZurueckGegeben(Medium m)
	{
		medienVerwaltung.setZurueckGegeben(m);
		notifyObserver();
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

	@Override
	public void register(Observer newObserver) {
		observers.add(newObserver);
		
	}

	@Override
	public void unregister(Observer deleteObserver) {
		int observerIndex = observers.indexOf(deleteObserver);
		observers.remove(observerIndex);
		
	}

	@Override
	public void notifyObserver() {
		for(Observer observer : observers){
			observer.update();
		}
		
	}
}

package Views;

import Fachlogik.Autor;
import Fachlogik.Medienverwaltung.Buch;
import Fachlogik.Medienverwaltung.CD;
import Fachlogik.Medienverwaltung.Medium;

public class ViewController 
{	
	public void start()
	{
		MainView mv = new MainView();
	}
	
	//Methode zum zugriff auf bibliothek zum speichern, hört auf action listener
	public void saveBuch(Buch buch)
	{
		
	}
	
	public void saveCD(CD cd)
	{
		
	}
	
	public void save(Medium m)
	{
		
	}
	public Autor[] getAutorList()
	{
		//TODO
		return new Autor[]{new Autor("1", "2", 3)};
	}
}

package Fachlogik;

import Fachlogik.Medienverwaltung.Medienverwaltung;
import Views.ViewController;

public class Bibliothek 
{
	static Views.ViewController vc = new ViewController();
	static Medienverwaltung mv = new Medienverwaltung();
	
	public static void main(String[] args)
	{
		vc.start();
	}
}

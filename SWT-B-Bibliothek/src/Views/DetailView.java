package Views;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Fachlogik.Observer;
import Fachlogik.Medienverwaltung.Medium;

public class DetailView implements Observer {
	
	private static int observerIDTracker = 1;
	private int observerID;
	
	private ViewController vc;
	private String titel = "Detailansicht";
	private JLabel ausgeliehen;
	private JFrame frame = new JFrame(titel);
	private JPanel detailPanel;
	private int index;
	
	private ArrayList<Medium> mList;
	private Medium selectedMedium;
	
	public DetailView(ViewController vc, int index) 
	{		
		this.vc = vc;
		this.observerID = ++observerIDTracker;
		vc.register(this);
		
		this.index = index;
		detailPanel = new JPanel();
		 mList = new ArrayList();
		mList = vc.getMedien();
		selectedMedium = mList.get(index);
		
		buildWindow();
		
		
	}

	private void buildWindow()
	{
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		buildPanel();
	}
	
	private void buildPanel()
	{
		detailPanel.add(new JLabel("Titel: "));
		detailPanel.add(new JLabel(selectedMedium.getTitel()));
		detailPanel.add(new JLabel("ID: "));
		detailPanel.add(new JLabel(selectedMedium.getId()));
		detailPanel.add(new JLabel("Genre: "));
		detailPanel.add(new JLabel(selectedMedium.getGenre()));
		detailPanel.add(new JLabel("Autor Vorname: "));
		detailPanel.add(new JLabel(selectedMedium.getAutor().getautorVorname()));
		detailPanel.add(new JLabel("Autor Nachname: "));
		detailPanel.add(new JLabel(selectedMedium.getAutor().getautorNachname()));
		detailPanel.add(new JLabel("Ausgeliehen: "));
		ausgeliehen = new JLabel(setLabelAusgeliehen());	
		detailPanel.add(ausgeliehen);
		frame.add(detailPanel);
		detailPanel.setVisible(true);
	}
	
	private String setLabelAusgeliehen()
	{
		if(selectedMedium.istAusgeliehen())
		{
			return "ausgeliehen";
		}
		
		else{
			return "verfügbar";
		}
	}

	@Override
	public void update() {
		mList = vc.getMedien();
		selectedMedium = mList.get(index);	
		ausgeliehen.setText(setLabelAusgeliehen());
		//detailPanel.revalidate();
	    //detailPanel.repaint();
	}
}

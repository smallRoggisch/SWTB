package Views;

import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import Fachlogik.Medienverwaltung.Medienverwaltung;
import Fachlogik.Medienverwaltung.Medium;

public class AusleihView extends JPanel implements ActionListener{
	
	JPanel listPanel, buttonPanel;
	JButton ausleihen, zurueckGegeben;
	JList medienListe;
	
	ViewController vc;
	
	private ArrayList<Medium> mList;
	private String[] medien;
	
	public AusleihView(ViewController vc)
	{
		this.vc = vc;
		mList = new ArrayList();
		setLayout(new GridLayout(1, 2));
		listPanel = new JPanel();
		buttonPanel = new JPanel();
		
		ausleihen = new JButton("ausleihen");
		ausleihen.addActionListener(this);
		ausleihen.setVisible(true);
		
		zurueckGegeben = new JButton("zurueck geben");
		zurueckGegeben.addActionListener(this);
		zurueckGegeben.setVisible(true);
		
		medienLaden();
		buttonPanel.add(zurueckGegeben);
		buttonPanel.add(ausleihen);
		

		medienListe = new JList(medien);
	
		listPanel.add(medienListe);
		
		add(listPanel);
		add(buttonPanel);
		setVisible(true);
		
		//setVisible(true);
	}
	
	private void medienLaden()
	{
		mList = vc.getMedien();
		medien = new String[mList.size()];
		int i = 0;
		
		for(Medium m : mList)
		{
			medien[i] = listenString(m.getTitel(), m.getAutor().getautorNachname(), m.istAusgeliehen());
			i++;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ausleihen)
		{
			vc.mediumAusgeliehen(mList.get(medienListe.getSelectedIndex()));
			medienLaden();
			
			this.revalidate();
		    this.repaint();
		}
		
		if(e.getSource() == zurueckGegeben)
		{
			vc.mediumZurueckGegeben(mList.get(medienListe.getSelectedIndex()));
			medienLaden();
			System.out.println(medien[0]);
			this.revalidate();
		    this.repaint();
		}
		
	}
	
	
	private String listenString(String titel, String autorNachname, boolean ausgeliehen)
	{
		String s;
		if(ausgeliehen)
		{
			s = titel + ", " + autorNachname + ", ausgeliehen";
		}
		
		else
		{
			s = titel + ", " + autorNachname + ", verfügbar";
		}
		
		return s;
	}


}

package Views;

import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Fachlogik.Medienverwaltung.Medienverwaltung;
import Fachlogik.Medienverwaltung.Medium;

public class AusleihView extends JPanel implements ActionListener{
	
	JPanel listPanel, buttonPanel;
	JButton ausleihen, zurueckGegeben;
	JList medienListe;
	
	DefaultListModel listModel;
	
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
		
		

		medienListe = new JList();
		setModel();
		JScrollPane scrollPane = new JScrollPane(medienListe);
	
		listPanel.add(scrollPane);
		
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
			medien[i] = listenString(m.getTitel(), m.getAutor().getautorNachname(), m.istAusgeliehen(), m.getClass());
			i++;
		}
	}
	
	private void setModel()
	{
		listModel = new DefaultListModel<>();
		for(String s : medien)
		{
			listModel.addElement(s);
		}
		medienListe.setModel(listModel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ausleihen)
		{
			vc.mediumAusgeliehen(mList.get(medienListe.getSelectedIndex()));
			medienLaden();
			setModel();
			this.revalidate();
		    this.repaint();
		}
		
		if(e.getSource() == zurueckGegeben)
		{
			vc.mediumZurueckGegeben(mList.get(medienListe.getSelectedIndex()));
			medienLaden();
			setModel();
			System.out.println(medien[0]);
			this.revalidate();
		    this.repaint();
		}
		
	}
	
	
	private String listenString(String titel, String autorNachname, boolean ausgeliehen, Class<? extends Medium> klasse)
	{
		String string = "Fachlogik.Medienverwaltung.";
		String s = "";
		System.out.println(klasse.getTypeName());
		if(klasse.getTypeName().equals(string + "Buch"))
		{
			
			s = "Medium: Buch, ";
		}
		
		else if(klasse.getTypeName().equals(string + "CD"))
		{
			s = "Medium: CD, ";
		}
		if(ausgeliehen)
		{
			s += "Titel: " + titel + ", " + "Autor: " + autorNachname + ", ausgeliehen";
		}
		
				
		else
		{
			s += "Titel: " + titel + ", " + "Autor: " + autorNachname + ", verfügbar";
		}
		
		return s;
	}


}

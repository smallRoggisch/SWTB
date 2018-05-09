package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class MainView implements ActionListener
{
	String titel = "Bibliotheksverwaltung";
	JFrame frame = new JFrame(titel);
	JMenuBar menuBar = new JMenuBar();
	JMenuItem menuAusleihen, menuAnlegen;
	//JPanel ausleihe, anlegen;
	
	public MainView() 
	{		
		buildWindow();
	}
	
	private void buildWindow()
	{
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		createMenuBar();
		frame.setVisible(true);
	}
		
	private void createMenuBar()
	{
		menuAusleihen = new JMenuItem("Ausleihen");
		menuAnlegen = new JMenuItem("Medium anlegen");
		menuAusleihen.addActionListener(this);
		menuAnlegen.addActionListener(this);
		menuBar.add(menuAusleihen);
		menuBar.add(menuAnlegen);
		
		frame.setJMenuBar(menuBar);
		menuBar.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Ausleih Menü
		if(e.getSource() == menuAusleihen)
		{
			frame.add(new AusleihView());
			frame.setVisible(true);
		}
				
		//Anlegen Menü
		else if(e.getSource() == menuAnlegen)
		{
			frame.add(new MediumAnlegenView());
			frame.setVisible(true);
		}
		
	}


}

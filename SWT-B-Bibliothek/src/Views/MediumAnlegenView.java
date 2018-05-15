package Views;

import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Fachlogik.Autor;
import Fachlogik.Medienverwaltung.Buch;
import Fachlogik.Medienverwaltung.CD;
import Fachlogik.Medienverwaltung.Medienverwaltung;
import Fachlogik.Medienverwaltung.Medium;

public class MediumAnlegenView extends JPanel implements ActionListener{
	
	JButton saveButton;
	private ViewController vc;
	
	private JPanel cdBuchPanel;
	private JTextField title, id, genre, verlag, herausgeber;
	private JComboBox<String> comboBox;
	
	private String cdButtonString = "Cd anlegen";
	private String buchButtonString = "Buch anlegen";
	private String ausgeliehenString = "ausgeliehen?";

	private ArrayList<Autor> autoren;
	
	private JRadioButton cdButton = new JRadioButton(cdButtonString);
	private JRadioButton buchButton = new JRadioButton(buchButtonString);
	
	private JRadioButton ausgeliehenButton = new JRadioButton(ausgeliehenString);
	
	public MediumAnlegenView(ViewController vc)
	{		
		this.vc = vc;
		autoren = new ArrayList();
		createPage();
	}
	
	private void createPage()
	{
		setLayout(new GridLayout(1, 2));
		JPanel mainPanel = new JPanel();
		cdBuchPanel = new JPanel();
		
		mainPanel.add(new JLabel("CD oder Buch anlegen?"));
		
		cdButton.setMnemonic(KeyEvent.VK_B);
		cdButton.setActionCommand(cdButtonString);	
		cdButton.setSelected(true);
		buchButton.setMnemonic(KeyEvent.VK_C);
		buchButton.setActionCommand(buchButtonString);
		
		saveButton = new JButton();
		saveButton.setVisible(true);
		saveButton.setText("Speichern");
		
		
		mainPanel.add(cdButton);
		mainPanel.add(buchButton);
		mainPanel.add(saveButton);
		saveButton.addActionListener(this);
		cdButton.addActionListener(this);
		buchButton.addActionListener(this);
		mainPanel.setVisible(true);
		cdBuchPanel.setVisible(true);
		createCDPanel();
		
		add(mainPanel);
		add(cdBuchPanel);
	}
	
	private void createBuchPanel()
	{		

		JPanel buchPanel = new JPanel();
		buchPanel.setLayout(new GridLayout(3,2));
		autoren = vc.getAutorList();
		String[] autorenNamen = new String[autoren.size()];
		
		for(int i = 0; i < autoren.size(); i++)
		{
			autorenNamen[i] = autoren.get(i).getautorVorname() + " " + autoren.get(i).getautorNachname();
		}
		
		this.title = new JTextField(15);
		this.id = new JTextField(15);
		this.genre = new JTextField(15);
		this.comboBox = new JComboBox<String>(autorenNamen);
		this.verlag = new JTextField(15);
		buchPanel.add(new JLabel("Titel"));
		buchPanel.add(this.title);
		buchPanel.add(new JLabel("ID"));
		buchPanel.add(this.id);
		buchPanel.add(new JLabel("Genre"));
		buchPanel.add(this.genre);
		buchPanel.add(new JLabel("Verlag"));
		buchPanel.add(this.verlag);
		
		buchPanel.add(this.comboBox);
		buchPanel.add(ausgeliehenButton);
		
		this.cdBuchPanel.removeAll();
		this.cdBuchPanel.add(buchPanel);
		this.revalidate();
	    this.repaint();
		
	}
	
	private void createCDPanel()
	{
		JPanel cdPanel = new JPanel();
		cdPanel.setLayout(new GridLayout(3,2));
		autoren = vc.getAutorList();
		String[] autorenNamen = new String[autoren.size()];
		
		for(int i = 0; i < autoren.size(); i++)
		{
			autorenNamen[i] = autoren.get(i).getautorVorname() + " " + autoren.get(i).getautorNachname();
		}
		
		this.title = new JTextField(15);
		this.id = new JTextField(15);
		this.genre = new JTextField(15);
		this.herausgeber = new JTextField(15);
		this.comboBox = new JComboBox<String>(autorenNamen);
		cdPanel.add(new JLabel("Titel"));
		cdPanel.add(this.title);
		cdPanel.add(new JLabel("ID"));
		cdPanel.add(this.id);
		cdPanel.add(new JLabel("Genre"));
		cdPanel.add(this.genre);
		cdPanel.add(new JLabel("Herausgeber"));
		cdPanel.add(this.herausgeber);
		cdPanel.add(ausgeliehenButton);
		
		cdPanel.add(this.comboBox);
		
		this.cdBuchPanel.removeAll();
		this.cdBuchPanel.add(cdPanel);;
		this.revalidate();
	    this.repaint();
	}
	
	private void inputToBuch()
	{
		int position = this.comboBox.getSelectedIndex();
		
		System.out.println(position);
		Autor autor = autoren.get(position);
		String verlag = this.verlag.getText();
		String titel = title.getText();
		String id = this.id.getText();
		String genre = this.genre.getText();
		
		
		Buch buch = new Buch(autor, verlag, titel, id, genre, ausgeliehenButton.isSelected());
		System.out.println(position + " " + verlag);
		vc.saveBuch(buch);
	}
	
	private void inputToCd()
	{
		int position = this.comboBox.getSelectedIndex();
		
		Autor autor = autoren.get(position);
		String herausgeber = this.herausgeber.getText();
		String titel = title.getText();
		String id = this.id.getText();
		String genre = this.genre.getText();
		
		CD cd = new CD(autor, herausgeber, titel, id, genre, ausgeliehenButton.isSelected());
		vc.saveCD(cd);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == saveButton)
		{
			if(buchButton.isSelected())
			{
				inputToBuch();
			}
			else if(cdButton.isSelected())
			{
				inputToCd();
			}
			
		}
		
		else if(e.getActionCommand().equals(cdButtonString))
		{
			if(buchButton.isSelected())
			{
				buchButton.setSelected(false);
			}

			createCDPanel();
		}
		
		else if(e.getActionCommand().equals(buchButtonString))
		{
			if(cdButton.isSelected())
			{
				cdButton.setSelected(false);
			}
			
			createBuchPanel();
		}
				
	}

}

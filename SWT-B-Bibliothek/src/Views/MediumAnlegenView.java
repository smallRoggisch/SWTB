package Views;

import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
import Fachlogik.Medienverwaltung.Medium;

public class MediumAnlegenView extends JPanel implements ActionListener{
	
	JButton saveButton;
	private ViewController vc;
	
	private JPanel cdBuchPanel;
	private JTextField title, id, genre, verlag, herausgeber;
	private JComboBox<String> comboBox;
	
	String cdButtonString = "Cd anlegen";
	String buchButtonString = "Buch anlegen";

	Autor[] autoren;
	
	JRadioButton cdButton = new JRadioButton(cdButtonString);
	JRadioButton buchButton = new JRadioButton(buchButtonString);
	
	public MediumAnlegenView()
	{		
		vc = new ViewController();
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
		add(mainPanel);
		add(cdBuchPanel);
	}
	
	private void createCDPanel()
	{		

		/*this.cdBuchPanel.add(new JButton("Hallo"));*/

		System.out.println("test");	
		autoren = vc.getAutorList();
		String[] autorenNamen = new String[autoren.length];
		
		for(int i = 0; i < autoren.length; i++)
		{
			autorenNamen[i] = autoren[i].getautorVorname() + " " + autoren[i].getautorNachname();
		}
		
		this.title = new JTextField(15);
		this.id = new JTextField(15);
		this.genre = new JTextField(15);
		this.comboBox = new JComboBox<String>(autorenNamen);
		this.cdBuchPanel.add(new JLabel("Titel"));
		this.cdBuchPanel.add(this.title);
		this.cdBuchPanel.add(new JLabel("ID"));
		this.cdBuchPanel.add(this.id);
		this.cdBuchPanel.add(new JLabel("Genre"));
		this.cdBuchPanel.add(this.genre);
		
		this.cdBuchPanel.add(this.comboBox);
		
		/*this.comboBox.setVisible(true);
		this.title.setVisible(true);
		this.genre.setVisible(true);
		this.id.setVisible(true);*/
		
		revalidate();
	    repaint();
	}
	
	private void createBuchPanel()
	{
		autoren = vc.getAutorList();
		String[] autorenNamen = new String[autoren.length];
		
		for(int i = 0; i < autoren.length; i++)
		{
			autorenNamen[i] = autoren[i].getautorVorname() + " " + autoren[i].getautorNachname();
		}
		
		this.title = new JTextField(15);
		this.id = new JTextField(15);
		this.genre = new JTextField(15);
		this.herausgeber = new JTextField(15);
		this.comboBox = new JComboBox<String>(autorenNamen);
		this.cdBuchPanel.add(new JLabel("Titel"));
		this.cdBuchPanel.add(this.title);
		this.cdBuchPanel.add(new JLabel("ID"));
		this.cdBuchPanel.add(this.id);
		this.cdBuchPanel.add(new JLabel("Genre"));
		this.cdBuchPanel.add(this.genre);
		this.cdBuchPanel.add(new JLabel("Herausgeber"));
		this.cdBuchPanel.add(this.herausgeber);
		
		
		this.cdBuchPanel.add(this.comboBox);
		
		
		revalidate();
	    repaint();
	}
	
	private void inputToBuch()
	{
		int position = this.comboBox.getSelectedIndex();
		System.out.println(position);
		Autor autor = autoren[position];
		String verlag = this.verlag.getText();
		String titel = title.getText();
		String id = this.id.getText();
		String genre = this.genre.getText();
		
		
		Buch buch = new Buch(autor, verlag, titel, id, genre);
		System.out.println(position + " " + verlag);
		vc.saveBuch(buch);
	}
	
	private void inputToCd()
	{
		int position = this.comboBox.getSelectedIndex();
		System.out.println(position);
		Autor autor = autoren[position];
		String herausgeber = this.herausgeber.getText();
		String titel = title.getText();
		String id = this.id.getText();
		String genre = this.genre.getText();
		
		CD cd = new CD(autor, herausgeber, titel, id, genre);
		vc.saveCD(cd);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == saveButton)
		{
			System.out.println("test");
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
			System.out.println("cd");
		}
		
		else if(e.getActionCommand().equals(buchButtonString))
		{
			if(cdButton.isSelected())
			{
				cdButton.setSelected(false);
			}
			
			createBuchPanel();
			System.out.println("buch");
		}
		
	}

}

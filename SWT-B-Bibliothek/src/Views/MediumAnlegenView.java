package Views;

import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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
	
	JPanel cdBuchPanel;
	private JTextField title, id, genre, verlag;
	private JComboBox<String> comboBox;
	
	String cdButtonString = "Cd anlegen";
	String buchButtonString = "Buch anlegen";

	JRadioButton cdButton = new JRadioButton(cdButtonString);
	JRadioButton buchButton = new JRadioButton(buchButtonString);
	
	public MediumAnlegenView()
	{		
		createPage();
	}
	
	private void createPage()
	{
		setLayout(new GridLayout(1, 2));
		JPanel mainPanel = new JPanel();
		cdBuchPanel = new JPanel();
		
		mainPanel.add(new TextField("CD oder Buch anlegen?"));
		
		cdButton.setMnemonic(KeyEvent.VK_B);
		cdButton.setActionCommand(cdButtonString);		
		buchButton.setMnemonic(KeyEvent.VK_C);
		buchButton.setActionCommand(buchButtonString);
		
		saveButton = new JButton();
		saveButton.setVisible(true);
		saveButton.setText("Speichern");
		
		mainPanel.add(saveButton);
		mainPanel.add(cdButton);
		mainPanel.add(buchButton);
		saveButton.addActionListener(this);
		cdButton.addActionListener(this);
		buchButton.addActionListener(this);
		mainPanel.setVisible(true);
		add(mainPanel);
		add(cdBuchPanel);

	}
	
	private void createCDPanel()
	{		
		title = new JTextField(15);
		id = new JTextField(15);
		genre = new JTextField(15);
		comboBox = new JComboBox<String>(vc.getAutorList());
		comboBox.setVisible(true);
		title.setVisible(true);
		genre.setVisible(true);
		id.setVisible(true);
		cdBuchPanel.add(title);
		cdBuchPanel.add(genre);
		cdBuchPanel.add(id);
		cdBuchPanel.add(comboBox);
			
	}
	
	private void createBuchPanel()
	{
		
	}
	
	private Buch inputToBuch()
	{
		Autor autor = null;
		String verlag = this.verlag.getText();
		String titel = title.getText();
		String id = this.id.getText();
		String genre = this.genre.getText();
		
		return new Buch(autor, verlag, titel, id, genre);
		
	}
	
	private CD inputToCd()
	{
		return new CD(null, null, null, null, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == saveButton)
		{
			System.out.println("test");
			if(buchButton.isSelected())
			{
				vc.save(inputToBuch());
			}
			else if(cdButton.isSelected())
			{
				vc.save(inputToCd());
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

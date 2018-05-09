package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MediumAnlegenView extends JPanel implements ActionListener{
	
	JButton saveButton;
	private ViewController vc;
	
	public MediumAnlegenView()
	{
		
		saveButton = new JButton();
		saveButton.setVisible(true);
		saveButton.setText("Speichern");
		add(saveButton);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Test");
		if(e.getSource() == saveButton)
		{
			System.out.println("test");
			//vc.save(m);
		}
		
	}

}

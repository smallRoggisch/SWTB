package Views;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AusleihView extends JPanel {
	
	public AusleihView()
	{
		GridLayout gridLayout = new GridLayout(5, 5);
		
		
		setLayout(gridLayout);
		JButton button;

		button = new JButton();
		button.setText("hallo");
		button.setSize(50,50);
		button.setVisible(true);
		
		add(button);
		

		
		//setVisible(true);
	}

}

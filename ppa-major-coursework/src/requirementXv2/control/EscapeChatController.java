package requirementXv2.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class EscapeChatController implements ActionListener {

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton button = (JButton) arg0.getSource();
		if(button.getName().equals("Button 1"))
		{
			System.out.println("Hello");
		}
	}

}

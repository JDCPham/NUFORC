package requirementX.view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import api.ripley.Ripley;
import requirementX.model.MainModel;

public class WelcomePanel extends JPanel{

	MainModel mainModel;
	JLabel mainLabel;

	public WelcomePanel(MainModel mainModel) {

		this.mainModel = mainModel;
		initWidgets();

	}



	public void initWidgets(){

		setLayout(new GridLayout(1, 1));
		mainLabel = new JLabel("Test");
		mainLabel.setHorizontalAlignment(JLabel.CENTER);
		mainLabel.setVerticalAlignment(JLabel.CENTER);
		add(mainLabel);	

	}


}

package requirementX.view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import api.ripley.Ripley;
import requirementX.model.MainModel;
import requirementX.model.WelcomeModel;

public class WelcomePanel extends JPanel{

	WelcomeModel welcomeModel;
	MainModel mainModel;
	JLabel mainLabel;

	public WelcomePanel(MainModel mainModel, WelcomeModel welcomeModel) {

		this.mainModel = mainModel;
		this.welcomeModel = welcomeModel;
		initWidgets();

	}



	public void initWidgets(){

		setLayout(new GridLayout(1, 1));
		mainLabel = new JLabel();
		mainLabel.setHorizontalAlignment(JLabel.CENTER);
		mainLabel.setVerticalAlignment(JLabel.CENTER);
		add(mainLabel);	
		updateLabel();

	}



	public String updateLabel() {

		String text;

		text = "Welcome to the Ripley API v" + welcomeModel.getVersion()+ "<br>"
				+ "Please select from the dates above, in order to<br>"
				+ "begin analysing UFO sighting data.<br><br>";
		
		if ((mainModel.getFromSelectionYear() == 0) || (mainModel.getToSelectionYear()) == 0) {
			
			text += "Please select a date range";
			
		} else {
			
			text += "Date range selected: " + mainModel.getFromSelectionYear() + " - " + mainModel.getToSelectionYear();
			
		}

		text = "<html><center>" + text + "</html></center>";

		mainLabel.setText(text);
		
		return text;
		
	}


}

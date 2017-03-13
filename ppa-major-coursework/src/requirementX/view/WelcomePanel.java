package requirementX.view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.xml.soap.Text;

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
	
	
	public boolean isDateSelected() {
		
		if ((mainModel.getFromSelectionYear() == 0) || (mainModel.getToSelectionYear()) == 0) return false;
		else return true;
		
	}



	public String updateLabel() {

		String text;

		text = "Welcome to the Ripley API v" + welcomeModel.getVersion()+ "<br>"
				+ "Please select from the dates above, in order to<br>"
				+ "begin analysing UFO sighting data.<br><br>";
		
		if (isDateSelected() && mainModel.isDateValid() && isDateSelected() && mainModel.isGrabbingData()){
			
			text += "Date range selected: " + mainModel.getFromSelectionYear() + " - " 
					+ mainModel.getToSelectionYear() + "<br><br><b>Grabbing Data...</b>";
			
		} else if (isDateSelected() && mainModel.isDateValid() && isDateSelected()){
			
			text += "Date range selected: " + mainModel.getFromSelectionYear() + " - " 
					+ mainModel.getToSelectionYear();
			
		} else if (isDateSelected() && !mainModel.isDateValid() && isDateSelected()){
			
			text += "You have entered an invalid date. Select another date range.";
			
		}

		text = "<html><center>" + text + "</center></html>";

		mainLabel.setText(text);

		return text;

	}



}

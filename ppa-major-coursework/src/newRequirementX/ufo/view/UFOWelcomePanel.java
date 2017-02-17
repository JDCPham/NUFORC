package newRequirementX.ufo.view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import newRequirementX.ufo.model.UFOMainModel;
import newRequirementX.ufo.model.UFOWelcomeModel;

public class UFOWelcomePanel extends JPanel{
	
	// Fields
	UFOWelcomeModel welcomeModel;
	UFOMainModel mainModel;
	JLabel mainLabel;
	
	public UFOWelcomePanel(UFOWelcomeModel welcomeModel, UFOMainModel mainModel){
		
		this.welcomeModel = welcomeModel;
		this.mainModel = mainModel;
		initWidgets();
		updateLabel();
		
	}
	
	public void initWidgets(){
		
		setLayout(new GridLayout(1, 1));
		mainLabel = new JLabel();
		mainLabel.setHorizontalAlignment(JLabel.CENTER);
		mainLabel.setVerticalAlignment(JLabel.CENTER);
		add(mainLabel);	
		
	}
	
	public void updateLabel(){
		
		String labelText = "Welcome to the Ripley API v" + welcomeModel.getVersion()+ "<br>"
					+ "Please select from the dates above, in order to<br>"
					+ "begin analysing UFO sighting data.<br><br>";
		
		if ((mainModel.getFromYear() != 0) && (mainModel.getToYear() != 0)){
			
			if (mainModel.getFromYear() > mainModel.getToYear()){
				
				labelText += "Date range selected, " + mainModel.getFromYear() + " - " + mainModel.getToYear() + "<br><br>"
						+ "This is not a valid date";	
				
			} else {
				
				labelText += "Date range selected, " + mainModel.getFromYear() + " - " + mainModel.getToYear() + "<br><br>"
						+ "Grabbing data...<br>"
						+ "Data grabbed in 1 minutes, 17 seconds...<br>"
						+ "<b>Please now interact with this data using the buttons<br>"
						+ "to the left and the right</b>";	
				
			}
		}
		
		mainLabel.setText("<html><center>" + labelText + "<center></html>");
	
	}
	

}

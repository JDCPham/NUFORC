package requirementX.ufo.view;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import requirementX.ufo.model.UFOModel;

public class UFOWelcome extends JPanel implements Observer{
	
	JLabel mainLabel;
	UFOModel ufoModel;
	
	public UFOWelcome(UFOModel ufoModel){
		
		this.ufoModel = ufoModel;
		ufoModel.addObserver(this);
		
		initWidgets();
		updateLabel();
		
	}
	
	public void initWidgets(){
		setLayout(new GridLayout(1,1));
		mainLabel = new JLabel();
		mainLabel.setHorizontalAlignment(JLabel.CENTER);
		mainLabel.setVerticalAlignment(JLabel.CENTER);
		add(mainLabel);	
	}
	
	public void updateLabel(){
		
		mainLabel.setText("<html><center>Welcome to the Ripley API v1.0<br>"
				+ "Please select from the dates above, in order to<br>"
				+ "begin analysing UFO sighting data.<br><br>"
				+ "Date range selected, " + ufoModel.getFromYear() + " - " + ufoModel.getToYear() + " <br><br>"
				+ "Grabbing data...<br>"
				+ "Data grabbed in 1 minutes, 17 seconds...<br>"
				+ "<b>Please now interact with this data using the buttons<br>"
				+ "to the left and the right</b></center></html>");
		
	}

	@Override
	public void update(Observable o, Object arg) {
		updateLabel();	
	}

}

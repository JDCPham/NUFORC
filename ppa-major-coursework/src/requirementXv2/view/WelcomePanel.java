// Package
package requirementXv2.view;

// Imports
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

import javax.swing.JLabel;
import javax.swing.JPanel;

import requirementXv2.model.MainModel;
import requirementXv2.model.WelcomeModel;

// WelcomePanel class
public class WelcomePanel extends JPanel implements Observer{

	// Models
	private MainModel mainModel;
	private WelcomeModel welcomeModel;

	// Data
	private JLabel mainLabel;



	/**
	 * Constructor Method.
	 * Sets the Main Model and Welcome Model.
	 * Adds necessary observers.
	 * Calls the initWidgets() method which sets up Widgets and GUI.
	 * @param mainModel The welcome panel uses the main model for the date range.
	 * @param welcomeModel The welcome panel uses the welcome model for the ripley version number.
	 */
	public WelcomePanel(MainModel mainModel, WelcomeModel welcomeModel) {

		this.mainModel = mainModel;
		this.welcomeModel = welcomeModel;
		mainModel.addObserver(this);
		welcomeModel.addObserver(this);
		initWidgets();

	}



	/**
	 * Sets up the widgets and GUI inside the Welcome Panel (Panel 1)
	 * A label is placed in the centre of the screen.
	 */
	public void initWidgets() {

		setLayout(new GridLayout(1, 1));
		mainLabel = new JLabel();
		mainLabel.setHorizontalAlignment(JLabel.CENTER);
		mainLabel.setVerticalAlignment(JLabel.CENTER);
		add(mainLabel);	
		updateLabel(false);

	}



	/**
	 * Method which looks at the current state of the program and
	 * Determines what text should be displayed onto the welcome panel.
	 * Should be called whenever a change is made in the welcome model.
	 * @param dataReady A field stored in the Welcome Model which is set to true when all data for the date range selected has been retrieved and sorted.
	 */

	public void updateLabel(boolean dataReady) {

		String text; 
		
		text = "Welcome to the Ripley API v" + welcomeModel.getVersion() + "<br>"
				+ "Please select from the dates above, in order to <br>" 
				+ "begin analysing UFO sighting data.";

		// If the selected date is valid, display the selected date range from the main model.
		if (mainModel.isDateValid()) {

			text += "<br><br>Date range selected, ";
			text += mainModel.getFromSelectionYear() + " - " + mainModel.getToSelectionYear();
			
			// If the data has not yet been retrieved, update the label with a loading message
			if (!dataReady) {

				text += "<br><br>Grabbing data...";

			// If the data is ready and has been retrieved, display the amount of time taken
			} else {

				text += "<br><br>Data Grabbed in " + millisToTime(welcomeModel.getDataGrabTime());
				text += "<br><br><b>Please now interact with this data using the"
						+ "<br>buttons to the left and the right</b>";

			}

		}

		// Set the text of the centre label surrounded by HTML tags for styling reasons.
		mainLabel.setText("<html><center>" + text + "</center></html>");

	}
	


	/**
	 * 
	 * @param millis
	 * @return
	 */
	private String millisToTime(long millis) {
		
		int intMillis = (int) (millis);
		int minutes = (intMillis / (1000 * 60)) % 60;
		int seconds = (intMillis / 1000) % 60;
		System.out.println(millis);
		
		return minutes + " minutes and " + seconds + " seconds.";

	}

	

	/**
	 * 
	 */
	@Override
	public void update(Observable o, Object arg) {

		if (arg.equals("Data Ready")) updateLabel(true);
		if (arg.equals("Date Selection changed")) updateLabel(false);
		if (arg.equals("Data Grabbed Time Changed")) updateLabel(true);

	}


}

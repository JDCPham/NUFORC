// Package
package requirementXv2;

// Imports
import requirementXv2.model.MainModel;
import requirementXv2.model.MapModel;
import requirementXv2.model.StatsModel;
import requirementXv2.model.SurpriseModel;
import requirementXv2.model.WelcomeModel;
import requirementXv2.view.MainFrame;

// Main Class
public class Main {

	public static void main(String[] args) {
		
		// Create models. A model is created for the frame and each of its containing panels.
		MainModel mainModel = new MainModel();
		WelcomeModel welcomeModel = new WelcomeModel(mainModel);
		MapModel mapModel = new MapModel(mainModel);
		StatsModel statsModel = new StatsModel(mainModel, mapModel);
		SurpriseModel surpriseModel = new SurpriseModel(mainModel);
		
		// Create the main frame
		MainFrame mainFrame = new MainFrame(mainModel, welcomeModel, mapModel, statsModel);
		
		// Set the observers
		mainModel.addObserver(mainFrame);
		mapModel.addObserver(mainFrame);
		welcomeModel.addObserver(mainFrame);

		// Set visibility to true
		mainFrame.setVisible(true); 		

	}

}

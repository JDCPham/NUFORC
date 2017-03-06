// Package
package requirementX;

// Imports
import api.ripley.Ripley;
import requirementX.model.MainModel;
import requirementX.model.MapModel;
import requirementX.model.StatsModel;
import requirementX.model.WelcomeModel;
import requirementX.view.MainFrame;

public class Main {

	public static void main(String[] args) {
		
		// Create new Ripley object
		Ripley ripley = new Ripley("10tLI3CWstqyVD6ql2OMtA==", "tBgm4pRo9grVqL46EnH7ew==");
		
		// Create models
		WelcomeModel welcomeModel = new WelcomeModel(ripley);
		MapModel mapModel = new MapModel(ripley);
		StatsModel statsModel = new StatsModel(ripley);
		MainModel mainModel = new MainModel(ripley);
		
		// Create frame
		MainFrame mainFrame = new MainFrame(mainModel, welcomeModel, mapModel, statsModel);
		mainFrame.setVisible(true);
		
		// Add observers
		mainModel.addObserver(mainFrame);
		
	}

}

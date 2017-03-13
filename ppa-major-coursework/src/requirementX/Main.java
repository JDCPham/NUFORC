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
		MainModel mainModel = new MainModel(ripley);
		WelcomeModel welcomeModel = new WelcomeModel(mainModel);
		MapModel mapModel = new MapModel(mainModel);
		StatsModel statsModel = new StatsModel(mainModel);
		
		// Add other models
		mainModel.setModels(welcomeModel, mapModel, statsModel);
		welcomeModel.setModels(mapModel, statsModel);
		mapModel.setModels(welcomeModel, statsModel);
		statsModel.setModels(welcomeModel, mapModel);
		
		// Create frame
		MainFrame mainFrame = new MainFrame(mainModel, welcomeModel, mapModel, statsModel);
		mainFrame.setVisible(true);
		
		// Add observers
		mainModel.addObserver(mainFrame);
		
	}

}

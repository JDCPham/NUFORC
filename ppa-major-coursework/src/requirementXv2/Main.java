package requirementXv2;

import requirementXv2.model.MainModel;
import requirementXv2.model.MapModel;
import requirementXv2.model.StatsModel;
import requirementXv2.model.SurpriseModel;
import requirementXv2.model.WelcomeModel;
import requirementXv2.view.MainFrame;

public class Main {

	public static void main(String[] args) {
		
		// Create models
		MainModel mainModel = new MainModel();
		WelcomeModel welcomeModel = new WelcomeModel(mainModel);
		MapModel mapModel = new MapModel(mainModel);
		StatsModel statsModel = new StatsModel(mainModel);
		SurpriseModel surpriseModel = new SurpriseModel(mainModel);
		
		// Create frame
		MainFrame mainFrame = new MainFrame(mainModel, welcomeModel, mapModel);
		
		// Set observers
		mainModel.addObserver(mainFrame);
		mapModel.addObserver(mainFrame);
		welcomeModel.addObserver(mainFrame);

		// Set visibility 
		mainFrame.setVisible(true);
		

	}

}

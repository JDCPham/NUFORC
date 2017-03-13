package requirementX.model;

import java.util.Observable;

import api.ripley.Ripley;

public class StatsModel extends Observable {
	
	private MainModel mainModel;
	private MapModel mapModel;
	private WelcomeModel welcomeModel;
	
	
	public StatsModel(MainModel mainModel) {
		
		this.mainModel = mainModel;
		
	}
	
	
	public void setModels(WelcomeModel welcomeModel, MapModel mapModel) {
		
		this.welcomeModel = welcomeModel;
		this.mapModel = mapModel;
		
	}

}

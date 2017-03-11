package requirementX.model;

import java.util.Observable;

import api.ripley.Ripley;

public class MapModel extends Observable {
	
	private MainModel mainModel;
	private WelcomeModel welcomeModel;
	private StatsModel statsModel;
	
	public MapModel(MainModel mainModel) {
		
		this.mainModel = mainModel;
		
	}
	
	
	
	public void setModels(WelcomeModel welcomeModel, StatsModel statsModel) {
		
		this.welcomeModel = welcomeModel;
		this.statsModel = statsModel;
		
	}

}

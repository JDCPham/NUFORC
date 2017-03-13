
package requirementX.model;

import java.util.Observable;

import api.ripley.Ripley;

public class WelcomeModel extends Observable{
	
	private double version;
	
	private MainModel mainModel;
	private MapModel mapModel;
	private StatsModel statsModel;
	
	
	
	public WelcomeModel(MainModel mainModel) {

		// Add Main Model
		this.mainModel = mainModel;
		
		// Get version
		version = this.mainModel.ripley.getVersion();
		
	}
	
	
	
	public void setModels(MapModel mapModel, StatsModel statsModel) {
		
		this.mapModel = mapModel;
		this.statsModel = statsModel;
		
	}
	
	
	
	public double getVersion() {
		
		return version;
		
	}
	
	

}

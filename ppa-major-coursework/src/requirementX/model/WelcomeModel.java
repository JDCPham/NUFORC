package requirementX.model;

import java.util.Observable;

import api.ripley.Ripley;

public class WelcomeModel extends Observable{
	
	private Ripley ripley;
	
	private double version;
	
	public WelcomeModel(Ripley ripley) {
		
		// Set ripley object
		this.ripley = ripley;
		
		// Get version
		version = ripley.getVersion();
		
	}
	
	
	
	public double getVersion() {
		
		return version;
		
	}
	
	

}

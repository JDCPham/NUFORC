package newRequirementX.ufo.model;

import api.ripley.Ripley;

public class UFOWelcomeModel {
	
	private Ripley ripley;
	
	private UFOMainModel mainModel;
	
	private double version;
	
	public UFOWelcomeModel(UFOMainModel mainModel){
		
		// Set up Ripley
		ripley = new Ripley("10tLI3CWstqyVD6ql2OMtA==", "tBgm4pRo9grVqL46EnH7ew==");
		
		// Get Ripley version
		version = ripley.getVersion();
		
		// Set main model
		this.mainModel = mainModel;
		
	}
	
	
	
	
	/*
	 * GETTERS AND SETTERS
	 */
	
	public int getFromYear(){
		return mainModel.getFromYear();
	}
	
	public int getToYear(){
		return mainModel.getToYear();
	}
	
	public double getVersion(){
		return version;
	}

}

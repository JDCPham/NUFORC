package requirementXv2.model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.TreeMap;

import api.ripley.Incident;

public class WelcomeModel extends Observable{

	// Main Model
	private MainModel mainModel;

	// Data
	private double version;
	private long dataGrabTime;
	private ArrayList<Incident> incidents;
	private TreeMap<String, Integer> states;

	/** Constructor **/

	public WelcomeModel(MainModel mainModel) {

		// Set main model
		this.mainModel = mainModel;

		// Get data required for first panel
		version = ripleyVersion();

	}


	/** Retrieving data from Ripley **/

	public double ripleyVersion() { return mainModel.ripley.getVersion(); }


	/** Useful **/
	
	/** Setters **/
	
	public void setDataGrabTime(long time) { this.dataGrabTime = time; }
	

	/** Getters **/

	public double getVersion() { return version; }
	
	public long getDataGrabTime() { return dataGrabTime; }

}

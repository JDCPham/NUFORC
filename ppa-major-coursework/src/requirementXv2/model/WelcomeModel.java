// Package
package requirementXv2.model;

// Imports
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


	/**
	 * Constructor Method
	 * Sets the main model, and gets the version of ripley API.
	 * @param mainModel Model for main frame.
	 */
	public WelcomeModel(MainModel mainModel) {

		// Set main model
		this.mainModel = mainModel;

		// Get data required for first panel
		version = ripleyVersion();

	}


	/**
	 * Retrieves a double of the version number of ripley API.
	 * @return Ripley Version.
	 */
	public double ripleyVersion() { return mainModel.ripley.getVersion(); }

	
	
	/**
	 * Sets how long it took between the user selecting a date range, and the finishing of the retrieval of data.
	 * Notifies observers to update the welcome panel with the duration of time taken.
	 * @param time The time taken.
	 */
	public void setDataGrabTime(long time) { 
		
		this.dataGrabTime = time; 
		setChanged();
		notifyObservers("Data Grabbed Time Changed");
	
	}
	

	/**
	 * Returns version of ripley.
	 * @return Current Ripley version.
	 */
	public double getVersion() { return version; }
	
	
	/**
	 * Returns the length of time taken to grab data.
	 * @return Length of time taken to grab data.
	 */
	public long getDataGrabTime() { return dataGrabTime; }

}

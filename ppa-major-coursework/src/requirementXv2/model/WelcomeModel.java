package requirementXv2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import api.ripley.Incident;

public class WelcomeModel {

	// Main Model
	private MainModel mainModel;

	// Data
	private double version;
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

	
	

	/** Getters **/

	public double getVersion() { return version; }

}

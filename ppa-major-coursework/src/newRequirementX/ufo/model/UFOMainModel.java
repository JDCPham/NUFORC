package newRequirementX.ufo.model;

import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import api.ripley.Ripley;
import newRequirementX.ufo.control.UFOWelcomeControl;
import newRequirementX.ufo.view.UFOWelcomePanel;

public class UFOMainModel extends Observable{
	
	private Ripley ripley;
	
	private ArrayList<JPanel> panels;
	private int currentPanel;
	
	private int startYear;
	private int latestYear;
	private String lastUpdated;
	
	private int fromYear;
	private int toYear;
	
	private boolean dateValid;
	
	public UFOMainModel(){
		
		System.out.println(currentPanel);
		
		// Initialise panels array
		panels = new ArrayList<JPanel>();
		
		// Add Panels
		panels.add(new UFOWelcomeControl(this).newPanel());
		
		// Set date valid boolean
		dateValid = false;
		
		// Set up Ripley
		ripley = new Ripley("10tLI3CWstqyVD6ql2OMtA==", "tBgm4pRo9grVqL46EnH7ew==");
		
		// Get Start year
		startYear = ripley.getStartYear();
		
		// Get Latest year
		latestYear = ripley.getLatestYear();
		
		// Get last updated
		lastUpdated = ripley.getLastUpdated();
		
		
	}
	
	
	
	
	
	
	/*
	 * Getters and Setters
	 */
	
	public void setDateValid(boolean valid){
		dateValid = valid;
	}
	
	public void setFromYear(String year){
		if (year != " - "){
			fromYear = Integer.parseInt(year);
		} else {
			fromYear = 0;
		}
		setChanged();
		notifyObservers();
	}
	
	public void setToYear(String year){
		if (year != " - "){
			toYear = Integer.parseInt(year);
		} else {
			toYear = 0;
		}
		setChanged();
		notifyObservers();
	}
	
	public int getFromYear(){
		return fromYear;
	}
	
	public int getToYear(){
		return toYear;
	}
	
	public int getStartYear(){
		return startYear;
	}
	
	public int getLatestYear(){
		return latestYear;
	}
	
	public String getLastUpdated(){
		return lastUpdated;
	}
	
	public JPanel getCurrentPanel(){
		return panels.get(currentPanel);
	}
	
	
	
}

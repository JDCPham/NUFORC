package requirementX.model;

import java.util.Observable;

import api.ripley.Ripley;

public class MainModel extends Observable {

	// Final Fields
	public static final int WELCOME_PANEL = 0;
	public static final int MAP_PANEL = 1;
	public static final int STATS_PANEL = 2;
	public static final int SURPRISE_PANEL = 3;
	
	// Models
	private MapModel mapModel;
	private StatsModel statsModel;
	private WelcomeModel welcomeModel;

	// Ripley 
	Ripley ripley;
	
	// Data 
	private int startYear;
	private int latestYear;
	private int fromSelectionYear;
	private int toSelectionYear;
	private String lastUpdated;
	
	// Current state 
	private int currentPanel;
	private boolean dateValid;
	private boolean grabbingData;
	private boolean dataReady;
	

	public MainModel(Ripley ripley) {

		// Set up Ripley
		this.ripley = ripley;

		// Set current panel
		currentPanel = WELCOME_PANEL;

		// Get time range
		startYear = ripley.getStartYear();
		latestYear = ripley.getLatestYear();

		// Get when data last updated
		lastUpdated = ripley.getLastUpdated();
		
		// Set date valid
		dateValid = false;
		grabbingData = false;
		dataReady = false;
		
	}
	
	
	
	public void setModels(WelcomeModel welcomeModel, MapModel mapModel, StatsModel statsModel) {
		
		this.welcomeModel = welcomeModel;
		this.mapModel = mapModel;
		this.statsModel = statsModel;
		
	}
	
	
	
	public void setFromYear(String year){
		
		if (!year.equals("-")) fromSelectionYear = Integer.parseInt(year);
		else fromSelectionYear = 0;
		
		setChanged();
		notifyObservers();
		
	}
	
	
	
	
	public void setToYear(String year){
		
		if (!year.equals("-")) toSelectionYear = Integer.parseInt(year);
		else toSelectionYear = 0;
			
		setChanged();
		notifyObservers();
		
	}
	
	
	
	public void setNextPanel() {
		
		if (currentPanel != SURPRISE_PANEL) {
			
			currentPanel++;
			setChanged();
			notifyObservers("Current Panel Changed");
			
		}
		
	}
	
	
	
	
	public void setPreviousPanel() {
		
		if (currentPanel != WELCOME_PANEL) {
			
			currentPanel--;
			setChanged();
			notifyObservers("Current Panel Changed");
			
		}
		
	}
	
	
	
	public void setFromSelectionYear(int year){
		
		this.fromSelectionYear = year;
		setChanged();
		notifyObservers("Date Selection Changed");
		
	}
	
	
	
	public void setToSelectionYear(int year) {
		
		this.toSelectionYear = year;
		setChanged();
		notifyObservers("Date Selection Changed");
		
	}
	
	
	
	public boolean setDateValid() {
		
		if (fromSelectionYear <= toSelectionYear) dateValid = true;
		else dateValid = false;

		setChanged();
		notifyObservers("Date Valid Changed");
		
		return dateValid;
		
	}
	
	
	
	public int getFromSelectionYear() {
		
		return fromSelectionYear;
		
	}
	
	
	
	public int getToSelectionYear() {
		
		return toSelectionYear;
		
	}
	


	public int getCurrentPanel() {

		return currentPanel;

	}



	public String getLastUpdated() {

		return lastUpdated;

	}



	public int getLatestYear() {

		return latestYear;

	}



	public int getStartYear() {

		return startYear;

	}
	
	
	
	public boolean isDateValid() {
		
		return dateValid;
		
	}
	
	
	public boolean isGrabbingData() {
		
		return grabbingData;
		
	}
	
	
	public boolean isDataReady() {
		
		return dataReady;
		
	}



	public void getData() {
		
		grabbingData = true;
		setChanged();
		notifyObservers("Grabbing Data");
	
		
	}
	


}

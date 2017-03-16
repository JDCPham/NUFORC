package requirementXv2.model;

import java.util.Observable;

import api.ripley.Ripley;
import requirementX.model.MapModel;
import requirementX.model.StatsModel;
import requirementX.model.WelcomeModel;

public class MainModel extends Observable {

	// Final Fields
	public static final int NO_SELECTION = -1;
	public static final int WELCOME_PANEL = 0;
	public static final int MAP_PANEL = 1;
	public static final int STATS_PANEL = 2;
	public static final int SURPRISE_PANEL = 3;

	// Ripley 
	protected Ripley ripley;

	// Models
	private WelcomeModel welcomeModel;
	private MapModel mapModel;
	private StatsModel statsModel;

	// Data 
	private int startYear;
	private int latestYear;
	private int fromSelectionYear;
	private int toSelectionYear;
	private String lastUpdated;

	// Current state 
	private int currentPanel;

	/** Constructor **/

	public MainModel() {

		// Set up Ripley
		ripley = new Ripley("10tLI3CWstqyVD6ql2OMtA==", "tBgm4pRo9grVqL46EnH7ew==");

		// Set current panel
		currentPanel = WELCOME_PANEL;

		// Get time range
		startYear = ripley.getStartYear();
		latestYear = ripley.getLatestYear();

		// Get when data last updated
		lastUpdated = ripley.getLastUpdated();
		
		// Set default from and to selection years
		fromSelectionYear = NO_SELECTION;
		toSelectionYear = NO_SELECTION;
		

	}
	

	/** Useful **/

	public int toInt(String s) { return Integer.parseInt(s); }
	
	public boolean isSelection(String s) { 
		
		if (s.equals("-")) return false;
		else return true;
		
	}
	
	
	public boolean isDateValid() {
		
		if ((fromSelectionYear <= toSelectionYear) && (fromSelectionYear != NO_SELECTION) && (toSelectionYear != NO_SELECTION)) {
			
			return true;
			
		} else {
			
			return false;
			
		}
			
	}
	


	/** Getters **/

	public int getCurrentPanel() { return currentPanel; }

	public int getStartYear() { return startYear; }

	public int getLatestYear() { return latestYear; }

	public int getFromSelectionYear() { return fromSelectionYear; }

	public int getToSelectionYear() { return toSelectionYear; }

	public String getLastUpdated() { return lastUpdated; }


	/** Setters **/

	public void setFromSelectionYear(String year){

		if (isSelection(year)) fromSelectionYear = toInt(year);
		else fromSelectionYear = NO_SELECTION;
		setChanged();
		notifyObservers("Date Selection changed");

	}

	public void setToSelectionYear(String year){

		if (isSelection(year)) toSelectionYear = toInt(year);
		else toSelectionYear = NO_SELECTION;
		setChanged();
		notifyObservers("Date Selection changed");

	}

	public void setNextPanel() {

		if (currentPanel != SURPRISE_PANEL) {

			currentPanel++; 
			setChanged();
			notifyObservers("Panel changed");

		}

	}

	public void setPreviousPanel() {

		if (currentPanel != WELCOME_PANEL) {

			currentPanel--;
			setChanged();
			notifyObservers("Panel changed");

		}

	}
	
	public void setDataReady() {
		
		setChanged();
		notifyObservers("Data Ready");
		
	}



}

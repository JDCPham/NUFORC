// Package
package requirementXv2.model;

// Imports
import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Observable;
import java.util.TreeMap;
import java.util.TreeSet;

import api.ripley.Incident;
import api.ripley.Ripley;

public class MainModel extends Observable implements Serializable{
	
	private static final long serialVersionUID = 2680493143842746133L;
	
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
	
	// Incidents
	private ArrayList<Incident> incidents;

	
	/**
	 * Constructor Method.
	 * Sets up Ripley API with Public and Private Keys.
	 * Sets the current panel to the welcome panel.
	 * Gets the first and latest year recorded by the ripley API.
	 * Gets and sets the date and time the API was last updated.
	 * Set the default selection years.
	 */
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
		
		// Prints the Ripley Acknowledgement String
		System.out.println(ripley.getAcknowledgementString());
		
	}
	

	/**
	 * Converts a string into an integer
	 * @param s A string containing a number.
	 * @return Number from String as type Integer.
	 */
	public int toInt(String s) { 
		
		return Integer.parseInt(s); 
		
	}
	
	
	
	/**
	 * Checks if the supplied selection is a valid year.
	 * @param s String from drop-down combo box.
	 * @return Boolean. True if string is valid selection.
	 */
	public boolean isSelection(String s) { 
		
		if (s.equals("-")) return false;
		else return true;
		
	}
	
	
	
	/**
	 * Checks if the dates selected were valid.
	 * Ensures the from year selection is before or equal to the to year selection.
	 * @return Boolean. True if date selection was valid.
	 */
	public boolean isDateValid() {
		
		if ((fromSelectionYear <= toSelectionYear) && (fromSelectionYear != NO_SELECTION) && (toSelectionYear != NO_SELECTION)) {
			
			return true;
			
		} else return false;
			
	}
	
	
	
	/**
	 * Returns an arraylist of incidents from ripley from a given date range.
	 * @param from The year from which the query is requesting incident reports from.
	 * @param to The year from which the query is requesting incident reports to.
	 * @return Array List of Incidents in a given date range.
	 */
	public ArrayList<Incident> ripleyIncidents(int from, int to) { 

		String fromYear = Integer.toString(from);
		String toYear = Integer.toString(to);

		return ripley.getIncidentsInRange(fromYear + "-01-01 00:00:00", toYear + "-12-31 23:59:59"); 

	}
	

	
	/**
	 * Determines all the different states that have been recorded from the current array list of incidents into a treemap.
	 * Initialises the treemap with the State name as a Key, and 0 as the value.
	 * Then counts the number of incidents each states have received.
	 * @return TreeMap with all states with number of incidents recorded for that state.
	 */
	public TreeMap<String, Integer> getIncidentCounts() {

		TreeSet<String> set;
		ListIterator<Incident> incidentList;
		TreeMap<String, Integer> incidentCount;
		String currentState;
		
		incidentCount = new TreeMap<String, Integer>();
		set = new TreeSet<String>();
		incidentList = incidents.listIterator();

		while (incidentList.hasNext()) set.add(incidentList.next().getState());
		for (String s: set) incidentCount.put(s, 0);
		
		incidentList = incidents.listIterator();	

		while (incidentList.hasNext()) {
			
			currentState = incidentList.next().getState();
			
			for (String otherState: incidentCount.keySet()) {

				if (currentState.equals(otherState)) incidentCount.put(currentState, incidentCount.get(currentState) + 1); 	
				
			}
		}	
		
		return incidentCount;
		
	}


	
	/**
	 * @return The integer representing the current panel being displayed.
	 */
	public int getCurrentPanel() { return currentPanel; }

	
	
	/**
	 * @return The integer of the first year the ripley API has incidents recorded.
	 */
	public int getStartYear() { return startYear; }

	
	/**
	 * @return The integer of the last year the ripley API has incidents recorded.
	 */
	public int getLatestYear() { return latestYear; }

	
	/**
	 * @return The integer of the selected 'From' year made by the user.
	 */
	public int getFromSelectionYear() { return fromSelectionYear; }

	
	/**
	 * @return The integer of the selected 'To' year made by the user.
	 */
	public int getToSelectionYear() { return toSelectionYear; }

	
	/**
	 * @return String with date and time of when the ripley API was last updated.
	 */
	public String getLastUpdated() { return lastUpdated; }
	
	
	/**
	 * @return The model representing and maintaining the map panel of the application.
	 */
	public MapModel getMapModel() { return mapModel; }
	
	
	/**
	 * @return Current array list of incidents from a selected date range.
	 */
	public ArrayList<Incident> getIncidents() { return incidents; }


	
	/**
	 * Sets the selection year. If selection year is not valid, then set the field to a final field representing no selection.
	 * Notifies observers to check if the date range is valid and get relevant data.
	 * @param year A string with a year to get list of incidents from.
	 */
	public void setFromSelectionYear(String year){

		if (isSelection(year)) fromSelectionYear = toInt(year);
		else fromSelectionYear = NO_SELECTION;
		setChanged();
		notifyObservers("Date Selection changed");

	}

	
	/**
	 * Sets the selection year. If selection year is not valid, then set the field to a final field representing no selection.
	 * Notifies observers to check if the date range is valid and get relevant data.
	 * @param year A string with a year to get list of incidents to.
	 */
	public void setToSelectionYear(String year){

		if (isSelection(year)) toSelectionYear = toInt(year);
		else toSelectionYear = NO_SELECTION;
		setChanged();
		notifyObservers("Date Selection changed");

	}

	
	
	/**
	 * Determines the current panel and calculates what the next panel is when the right button is pressed.
	 * Then sets the current panel to the next panel.
	 * Notifies observers so this change is reflected on screen.
	 */
	public void setNextPanel() {

		if (currentPanel != SURPRISE_PANEL) {

			currentPanel++; 
			setChanged();
			notifyObservers("Panel changed");

		}

	}

	
	
	/**
	 * Determines the current panel and calculates what the previous panel is when the left button is pressed.
	 * Then sets the current panel to the previous panel.
	 * Notifies observers so this change is reflected on screen.
	 */
	public void setPreviousPanel() {

		if (currentPanel != WELCOME_PANEL) {

			currentPanel--;
			setChanged();
			notifyObservers("Panel changed");

		}

	}
	
	
	
	/**
	 * Notifies observers to say that the data for the selected date range has been retrieved.
	 * And allows users to view the data via various panels.
	 */
	public void setDataReady() {
		
		setChanged();
		notifyObservers("Data Ready");
		
	}
	
	
	
	/**
	 * Sets the Arraylist of incidents.
	 * @param incidents Arraylist containing incident objects.
	 */
	public void setIncidents(ArrayList<Incident> incidents) {
		
		this.incidents = incidents;
		
	}



}

// Package
package requirementXv2.model;

// Imports
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Observable;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import api.ripley.Incident;

public class MapModel extends Observable {

	// Main Model
	private MainModel mainModel;

	private ArrayList<Incident> incidents;
	private TreeMap<String, Integer> states;

	private ArrayList<Sighting> sightings;
	private ArrayList<Sighting> sightingsByDate;
	private ArrayList<Sighting> sightingsByCity;
	private ArrayList<Sighting> sightingsByShape;
	private ArrayList<Sighting> sightingsByDuration;
	private ArrayList<Sighting> sightingsByPosted;



	/**
	 * Constructor method.
	 * Sets the main model.
	 * Sets up new arraylists designed to hold the list of sightings from the given date range.
	 * Every arraylist is sorted by various properties. 
	 * Eg. sightingsByCity is sorted in alphabetical order by city name.
	 * @param mainModel
	 */
	public MapModel(MainModel mainModel) {

		// Set up Main Model
		this.mainModel = mainModel;	

		// Set up arraylists
		sightings = new ArrayList<Sighting>();
		sightingsByCity = new ArrayList<Sighting>();
		sightingsByShape = new ArrayList<Sighting>();
		sightingsByDuration = new ArrayList<Sighting>();
		sightingsByPosted = new ArrayList<Sighting>();
		sightingsByDate = new ArrayList<Sighting>();

	}



	/**
	 * Sets the list of incidents by calling the ripleyIncidents method. Passing from and to selection years.
	 * Sets this list of incidents in the main model.
	 * Counts the number of incidents for each state.
	 * Notifies observers to update the map.
	 */
	public void updateStates() {

		incidents = mainModel.ripleyIncidents(mainModel.getFromSelectionYear(), mainModel.getToSelectionYear());
		mainModel.setIncidents(incidents);
		initialStates(incidents);
		countIncidents(incidents);

		setChanged();
		notifyObservers("State Data Updated");

	}


	
	/**
	 * Sets up a treemap and puts all states in which incidents have been recorded as a Key.
	 * The value of the treemap is initialised to 0.
	 * @param ripleyIncidents ArrayList of incidents.
	 */
	public void initialStates(ArrayList<Incident> ripleyIncidents) {

		TreeSet<String> set;
		ListIterator<Incident> incidents;
		
		states = new TreeMap<String, Integer>();
		set = new TreeSet<String>();
		incidents = ripleyIncidents.listIterator();

		while (incidents.hasNext()) set.add(incidents.next().getState());

		for (String s: set) states.put(s, 0);

	}

	
	
	/**
	 * Given an arraylist of incidents, counts the number of incidents recorded for each state in the US.
	 * @param ripleyIncidents Array list of incidents.
	 */
	public void countIncidents(ArrayList<Incident> ripleyIncidents) {

		ListIterator<Incident> incidents;
		String currentState;
		
		incidents = ripleyIncidents.listIterator();	

		while (incidents.hasNext()){

			currentState = incidents.next().getState();

			for (String otherState: getStatesIterable()) {

				if (currentState.equals(otherState)) states.put(currentState, states.get(currentState) + 1); 	

			}
		}	
	}



	/**
	 * Adds a Sighting to the sighting array list.
	 * @param sighting A custom class representing an incident.
	 */
	public void addSighting(Sighting sighting) {

		sightings.add(sighting);

	}

	
	/**
	 * Sorts the sightings arraylist into other arraylists.
	 * The order of sightings varies.
	 */
	public void sortSightings() {

		// New ArrayLists
		sightingsByCity = new ArrayList<Sighting>();
		sightingsByShape = new ArrayList<Sighting>();
		sightingsByDuration = new ArrayList<Sighting>();
		sightingsByDate = new ArrayList<Sighting>();
		sightingsByPosted = new ArrayList<Sighting>();

		// Add all sightings to all array lists.
		for (Sighting s: sightings) {

			sightingsByCity.add(s);
			sightingsByShape.add(s);
			sightingsByDuration.add(s);
			sightingsByDate.add(s);
			sightingsByPosted.add(s); 

		}

		// Sorts all arraylists using custom comparators.
		Collections.sort(sightingsByCity, new CustomComparators(). new CityComparator());
		Collections.sort(sightingsByShape, new CustomComparators(). new ShapeComparator());
		Collections.sort(sightingsByDuration, new CustomComparators(). new DurationComparator());
		Collections.sort(sightingsByDate, new CustomComparators(). new DateComparator());
		Collections.sort(sightingsByPosted, new CustomComparators(). new PostedComparator());

	}


	/**
	 * @return Returns an iterable set of states from the list of incidents.
	 */
	public Set<String> getStatesIterable() { return states.keySet(); }

	
	/**
	 * @return Treemap of states and number of incidents recorded for each state.
	 */
	public TreeMap<String, Integer> getStateCount() { return states; }

	
	/**
	 * @return Arraylist of incidents from a given date range.
	 */
	public ArrayList<Incident> getIncidents() { return incidents; }

	
	/**
	 * @return Arraylist of sightings from a given date range.
	 */
	public ArrayList<Sighting> getSightings() { return sightings; }

	
	/**
	 * @return Arraylist of sightings from a given date range sorted by city name.
	 */
	public ArrayList<Sighting> getSightingsByCity() { return sightingsByCity; }

	
	/**
	 * @return Arraylist of sightings from a given date range sorted by shape.
	 */
	public ArrayList<Sighting> getSightingsByShape() { return sightingsByShape; }

	
	/**
	 * @return Arraylist of sightings from a given date range sorted by duration.
	 */
	public ArrayList<Sighting> getSightingsByDuration() { return sightingsByDuration; }

	
	/**
	 * @return Arraylist of sightings from a given date range sorted by date.
	 */
	public ArrayList<Sighting> getSightingsByDate() { return sightingsByDate; }

	
	/**
	 * @return Arraylist of sightings from a given date range sorted by date posted.
	 */
	public ArrayList<Sighting> getSightingsByPosted() { return sightingsByPosted; }


}

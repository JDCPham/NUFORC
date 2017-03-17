package requirementXv2.model;

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



	/** Constructor **/

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



	/** Retrieving data from Ripley **/

	public ArrayList<Incident> ripleyIncidents(int from, int to) { 

		String fromYear = Integer.toString(from);
		String toYear = Integer.toString(to);

		return mainModel.ripley.getIncidentsInRange(fromYear + "-01-01 00:00:00", toYear + "-12-31 23:59:59"); 

	}



	/** Main **/

	public void updateStates() {

		incidents = ripleyIncidents(mainModel.getFromSelectionYear(), mainModel.getToSelectionYear());
		initialStates(incidents);
		countIncidents(incidents);
		
		setChanged();
		notifyObservers("State Data Updated");

	}


	/** Useful **/

	public void countIncidents(ArrayList<Incident> ripleyIncidents) {

		ListIterator<Incident> incidents = ripleyIncidents.listIterator();	
		String currentState;

		while (incidents.hasNext()){

			currentState = incidents.next().getState();

			for (String otherState: getStatesIterable()) {

				if (currentState.equals(otherState)) states.put(currentState, states.get(currentState) + 1); 	

			}
		}	
	}



	public void initialStates(ArrayList<Incident> ripleyIncidents) {

		states = new TreeMap<String, Integer>();
		TreeSet<String> set = new TreeSet<String>();
		ListIterator<Incident> incidents = ripleyIncidents.listIterator();

		while (incidents.hasNext()) set.add(incidents.next().getState());

		for (String s: set) states.put(s, 0);

	}



	public void addSighting(Sighting sighting) {

		sightings.add(sighting);

	}

	public void sortSightings() {

		// BY CITY

		sightingsByCity = new ArrayList<Sighting>();
		sightingsByShape = new ArrayList<Sighting>();
		sightingsByDuration = new ArrayList<Sighting>();
		sightingsByDate = new ArrayList<Sighting>();
		sightingsByPosted = new ArrayList<Sighting>();

		for (Sighting s: sightings) {

			sightingsByCity.add(s);
			sightingsByShape.add(s);
			sightingsByDuration.add(s);
			sightingsByDate.add(s);
			sightingsByPosted.add(s); 

		}

		Collections.sort(sightingsByCity, new CityComparator());
		Collections.sort(sightingsByShape, new ShapeComparator());
		Collections.sort(sightingsByDuration, new DurationComparator());
		Collections.sort(sightingsByDate, new DateComparator());
		Collections.sort(sightingsByPosted, new PostedComparator());

		// BY SHAPE




	}






	/** Getters **/

	public Set<String> getStatesIterable() { return states.keySet(); }

	public TreeMap<String, Integer> getStateCount() { return states; }

	public ArrayList<Incident> getIncidents() { return incidents; }

	public ArrayList<Sighting> getSightings() { return sightings; }

	public ArrayList<Sighting> getSightingsByCity() { return sightingsByCity; }
	
	public ArrayList<Sighting> getSightingsByShape() { return sightingsByShape; }
	
	public ArrayList<Sighting> getSightingsByDuration() { return sightingsByDuration; }
	
	public ArrayList<Sighting> getSightingsByDate() { return sightingsByDate; }
	
	public ArrayList<Sighting> getSightingsByPosted() { return sightingsByPosted; }


}

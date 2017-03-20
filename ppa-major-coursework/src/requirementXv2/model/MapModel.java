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




	/** Main **/

	public void updateStates() {

		incidents = mainModel.ripleyIncidents(mainModel.getFromSelectionYear(), mainModel.getToSelectionYear());
		mainModel.setIncidents(incidents);
		initialStates(incidents);
		countIncidents(incidents);

		setChanged();
		notifyObservers("State Data Updated");

	}


	/** Useful **/
	
	
	public void initialStates(ArrayList<Incident> ripleyIncidents) {

		TreeSet<String> set;
		ListIterator<Incident> incidents;
		
		states = new TreeMap<String, Integer>();
		set = new TreeSet<String>();
		incidents = ripleyIncidents.listIterator();

		while (incidents.hasNext()) set.add(incidents.next().getState());

		for (String s: set) states.put(s, 0);

	}

	
	

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



	public void addSighting(Sighting sighting) {

		sightings.add(sighting);

	}

	
	
	public void sortSightings() {

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

		Collections.sort(sightingsByCity, new CustomComparators(). new CityComparator());
		Collections.sort(sightingsByShape, new CustomComparators(). new ShapeComparator());
		Collections.sort(sightingsByDuration, new CustomComparators(). new DurationComparator());
		Collections.sort(sightingsByDate, new CustomComparators(). new DateComparator());
		Collections.sort(sightingsByPosted, new CustomComparators(). new PostedComparator());

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

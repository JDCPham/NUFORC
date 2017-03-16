package requirementXv2.model;

import java.util.ArrayList;
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
	

	
	
	/** Constructor **/
	
	public MapModel(MainModel mainModel) {
		
		// Set up Main Model
		this.mainModel = mainModel;	
		
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
	

	
	
	
	
	/** Getters **/
	
	public Set<String> getStatesIterable() { return states.keySet(); }
	
	public TreeMap<String, Integer> getStateCount() { return states; }
	
	public ArrayList<Incident> getIncidents() { return incidents; }
	

}

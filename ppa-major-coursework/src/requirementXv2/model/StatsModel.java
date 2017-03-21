package requirementXv2.model;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Observable;
import java.util.Set;
import java.util.TreeMap;	

import api.ripley.Incident;

public class StatsModel extends Observable {
	
	// Regular Expressions
	public static final Pattern HOAX = Pattern.compile("[Hh][Oo][Aa][Xx]");
	public static final Pattern VALID_STATES = Pattern.compile("AL|AK|AS|AZ|AR|CA|CO|CT|DE|DC|FL|GA|GU"
			+ "|HI|IA|ID|IL|IN|IS|KS|KY|LA|ME|MD|MH|MA|MI|FM|MN|MS|MO|MT|NE|NV|NH|NJ|NM|NY|NC|ND|MP|OH|OK"
			+ "|OR|PW|PA|PR|RI|SC|SD|TN|TX|UT|VT|VA|VI|WA|WV|WI|WY");

	// Main Model
	private MainModel mainModel;
	private MapModel mapModel;

	// Statistics
	private Statistic[] stats;

	// Current
	private int topLeft;
	private int topRight;
	private int bottomLeft;
	private int bottomRight;

	// Incidents
	private ArrayList<Incident> incidents;

	/** Constructor **/

	public StatsModel(MainModel mainModel, MapModel mapModel) {

		this.mainModel = mainModel;
		this.mapModel = mapModel;

		topLeft = 0;
		topRight = 1;
		bottomLeft = 2;
		bottomRight = 3;

		initStats();

	}


	public void initStats() {

		stats = new Statistic[8];

		stats[0] = new Statistic("Suspected Hoaxes", "A");
		stats[1] = new Statistic("Non-US Sightings", "B");
		stats[2] = new Statistic("Likeliest State", "C");
		stats[3] = new Statistic("Sightings via Other Platforms", "D");
		stats[4] = new Statistic("Total Sightings", "E");
		stats[5] = new Statistic("Most Common Year", "F");
		stats[6] = new Statistic("7", "G");
		stats[7] = new Statistic("8", "H");

	}


	public Statistic getStat(String position) {

		if (position.equals("Top Left")) return stats[topLeft];

		else if (position.equals("Top Right")) return stats[topRight];

		else if (position.equals("Bottom Left")) return stats[bottomLeft];

		else return stats[bottomRight];

	}


	public void nextStat(String position) {

		int i = 0;

		if (position.equals("Top Left")) i = topLeft;
		else if (position.equals("Top Right")) i = topRight;
		else if (position.equals("Bottom Left")) i = bottomLeft;
		else if (position.equals("Bottom Right")) i = bottomRight;

		while ((i == topLeft) || (i == topRight) || (i == bottomLeft) || (i == bottomRight)) { 

			if (i == 7) i = 0;	
			else i++;		

		}

		if (position.equals("Top Left")) topLeft = i;
		else if (position.equals("Top Right")) topRight = i;
		else if (position.equals("Bottom Left")) bottomLeft = i;
		else if (position.equals("Bottom Right")) bottomRight = i;

		setChanged();
		notifyObservers("Stats Box Changed");

	}


	public void prevStat(String position) {

		int i = 0;

		if (position.equals("Top Left")) i = topLeft;
		else if (position.equals("Top Right")) i = topRight;
		else if (position.equals("Bottom Left")) i = bottomLeft;
		else if (position.equals("Bottom Right")) i = bottomRight;

		while ((i == topLeft) || (i == topRight) || (i == bottomLeft) || (i == bottomRight)) { 

			if (i == 0) i = 7;	
			else i--;		

		}

		if (position.equals("Top Left")) topLeft = i;
		else if (position.equals("Top Right")) topRight = i;
		else if (position.equals("Bottom Left")) bottomLeft = i;
		else if (position.equals("Bottom Right")) bottomRight = i;

		setChanged();
		notifyObservers("Stats Box Changed");

	}

	
	public void updateStats() {

		stats[0].setStat(calculateHoaxes());
		stats[1].setStat(calculateNonUSSightings());
		stats[2].setStat(calculateLikeliestState());
		stats[3].setStat("S");
		stats[4].setStat(calculateTotalSightings());
		stats[5].setStat(calculateMostCommonYear());
		stats[6].setStat("s");
		stats[7].setStat("S");

		setChanged();
		notifyObservers("Stats Box Changed");

	}

	
	// Done
	private String calculateHoaxes() {

		int count = 0;
		
		for (Incident incident: mainModel.getIncidents()) {
			
			Matcher matcherA = HOAX.matcher(incident.getSummary());
			
			if (matcherA.find()) count++;
			
		}

		return Integer.toString(count);

	}

	
	
	// Done
	private String calculateLikeliestState() {

		int count = 0;
		int max = 0;
		String state = findMaxValue(mainModel.getIncidentCounts());

		if (state.equals("Not specified.")) state = "N/A";

		return state;

	}


	// Done
	private String calculateNonUSSightings() {

		int count = 0;
		
		for (Incident incident: mainModel.getIncidents()) {
			
			Matcher matcher = VALID_STATES.matcher(incident.getState());
			
			if (!matcher.find()) count++;
			
		}

		return Integer.toString(count);

	}


	
	// Done
	private String calculateTotalSightings() {

		int count = 0;

		for (Incident incident: mainModel.getIncidents()) count++;

		return Integer.toString(count);

	}
	
	
	
	// In Progess
	private String calculateYoutubeSightings() {
		
		
		return null;
		
	}
	
	
	// Done
	private String calculateMostCommonYear() {
		
		TreeMap<String, Integer> yearCount;
		String year;
		int fromYear;
		int toYear;
		
		fromYear = mainModel.getFromSelectionYear();
		toYear = mainModel.getToSelectionYear();
		
		yearCount = new TreeMap<String, Integer>();
		
		for (int i = fromYear; i <= toYear; i++) yearCount.put(Integer.toString(i), 0);
		
		for (Incident incident: mainModel.getIncidents()) {
			
			year = parseYear(incident.getDateAndTime());
			yearCount.put(year, yearCount.get(year) + 1);
			
		}
		
		return findMaxValue(yearCount);
	}
	
	
	
	
	
	private String parseYear(String dateTime) {
		
		String year;
		
		year = dateTime.replaceAll("-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}$", "");
		
		return year;
		
	}
	
	private String findMaxValue(TreeMap<String, Integer> map) {
		
		int count = 0;
		int maxValue = 0;
		String maxKey = "N/A";

		Set<Entry<String, Integer>> tempSet;

		tempSet = map.entrySet();
		
		if (!map.isEmpty()) maxValue = map.firstEntry().getValue();

		for (Entry<String, Integer> entry: tempSet) {

			if (entry.getValue() >= maxValue) {

				maxValue = entry.getValue();
				maxKey = entry.getKey();

			}	

		}
		
		return maxKey;
	}




}


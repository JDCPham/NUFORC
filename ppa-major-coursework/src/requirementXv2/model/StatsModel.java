// Package
package requirementXv2.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
// Imports
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Observable;
import java.util.Set;
import java.util.TreeMap;	

import api.ripley.Incident;


// StatsModel Class
public class StatsModel extends Observable implements Serializable {

	// Final fields
	public static final int TOP_LEFT = 0;
	public static final int TOP_RIGHT = 1;
	public static final int BOTTOM_LEFT = 2;
	public static final int BOTTOM_RIGHT = 3;

	// Serial Number
	private static final long serialVersionUID = 1L;

	// Regular Expressions
	public static final Pattern HOAX = Pattern.compile("[Hh][Oo][Aa][Xx]");
	public static final Pattern VALID_STATES = Pattern.compile("AL|AK|AS|AZ|AR|CA|CO|CT|DE|DC|FL|GA|GU"
			+ "|HI|IA|ID|IL|IN|IS|KS|KY|LA|ME|MD|MH|MA|MI|FM|MN|MS|MO|MT|NE|NV|NH|NJ|NM|NY|NC|ND|MP|OH|OK"
			+ "|OR|PW|PA|PR|RI|SC|SD|TN|TX|UT|VT|VA|VI|WA|WV|WI|WY");

	// Model Fields
	private MainModel mainModel;
	private MapModel mapModel;

	// Statistics
	private Statistic[] stats;

	// Current Statistics
	private int topLeft;
	private int topRight;
	private int bottomLeft;
	private int bottomRight;
	private int currentStatistics[];

	// Incidents
	private ArrayList<Incident> incidents;



	/** Constructor **/

	public StatsModel(MainModel mainModel, MapModel mapModel) {

		this.mainModel = mainModel;
		this.mapModel = mapModel;

		currentStatistics = new int[4];

		deserialize();

		initStats();

	}


	public void initStats() {

		stats = new Statistic[8];

		stats[0] = new Statistic("Suspected Hoaxes");
		stats[1] = new Statistic("Non-US Sightings");
		stats[2] = new Statistic("Likeliest State");
		stats[3] = new Statistic("Sightings via Other Platforms");
		stats[4] = new Statistic("Total Sightings");
		stats[5] = new Statistic("Most Common Year");
		stats[6] = new Statistic("7");
		stats[7] = new Statistic("8");

	}


	public Statistic getStat(String position) {

		if (position.equals("Top Left")) return stats[currentStatistics[0]];

		else if (position.equals("Top Right")) return stats[currentStatistics[1]];

		else if (position.equals("Bottom Left")) return stats[currentStatistics[2]];

		else return stats[currentStatistics[3]];

	}


	public void nextStat(String position) {

		int i = getCurrentStat(position);

		while ((i == currentStatistics[0]) || (i == currentStatistics[1]) || (i == currentStatistics[2]) || (i == currentStatistics[3])) { 

			if (i == 7) i = 0;	
			else i++;		

		}

		setStat(position, i);

		setChanged();
		notifyObservers("Stats Box Changed");

	}


	public void prevStat(String position) {

		int i = getCurrentStat(position);

		while ((i == currentStatistics[0]) || (i == currentStatistics[1]) || (i == currentStatistics[2]) || (i == currentStatistics[3])) { 

			if (i == 0) i = 7;	
			else i--;		

		}

		setStat(position, i);

		setChanged();
		notifyObservers("Stats Box Changed");

	}


	public int getCurrentStat(String position) {

		if (position.equals("Top Left")) return currentStatistics[0];
		else if (position.equals("Top Right")) return currentStatistics[1];
		else if (position.equals("Bottom Left")) return currentStatistics[2];
		else if (position.equals("Bottom Right")) return currentStatistics[3];
		else return 0;

	}

	public void setStat(String position, int i) {

		if (position.equals("Top Left")) currentStatistics[0] = i;
		else if (position.equals("Top Right")) currentStatistics[1] = i;
		else if (position.equals("Bottom Left")) currentStatistics[2] = i;
		else if (position.equals("Bottom Right")) currentStatistics[3] = i;
		serialize();

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
		String state = maxValue(mainModel.getIncidentCounts());

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

		return maxValue(yearCount);

	}



	/** Useful **/

	private String maxValue(TreeMap<String, Integer> map) {

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

	

	private String parseYear(String date) {

		return date.replaceAll("-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}$", "");

	}


	/** Serializable Methods **/

	public void serialize() {

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/requirementXv2/serialize.ser", false))) {

			out.writeObject(currentStatistics);

		} catch(IOException ex) {

			System.out.println(ex.getMessage());

		}

	}



	public void deserialize() {

		try( ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/requirementXv2/serialize.ser"))) {

			try {

				this.currentStatistics = (int[]) in.readObject();	

			}   catch (ClassNotFoundException ex) {

				System.out.println(ex.getMessage());

			}

		} catch (IOException ex) {

			System.out.println(ex.getMessage());

		}

	}

}


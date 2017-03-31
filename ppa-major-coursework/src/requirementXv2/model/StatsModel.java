// Package
package requirementXv2.model;

//Imports
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Observable;
import java.util.Set;
import java.util.TreeMap;

import org.json.JSONObject;

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
	public static final Pattern ANONYMOUS = Pattern.compile("[Aa][Nn][Oo][Nn][Yy][Mm][Oo][Uu][Ss]");
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



	/**
	 * Constructor Method. Assigns and sets supplied main model and map model.
	 * Creates new Array to store current statistic panels being shown to the user.
	 * Calls deserialize method to restore the currentStatistics array from the last time used.
	 * Calls the initStats method to create the initial 8 statistic panels shown.
	 * @param mainModel Model for the main frame of the application
	 * @param mapModel Model for the map panel of the application
	 */
	public StatsModel(MainModel mainModel, MapModel mapModel) {

		this.mainModel = mainModel;
		this.mapModel = mapModel;

		currentStatistics = new int[4];
		
		for (int i = 0; i <= 3; i++) {
			
			currentStatistics[i] = i;
			
		}

		deserialize();
		initStats();

	}



	/**
	 * Creates a new array storing the title and statistic for each of the 8 panels.
	 * Also, sets the title of the panels here.
	 */
	public void initStats() {

		stats = new Statistic[8];

		stats[0] = new Statistic("Suspected Hoaxes");
		stats[1] = new Statistic("Non-US Sightings");
		stats[2] = new Statistic("Likeliest State");
		stats[3] = new Statistic("Sightings via Other Platforms");
		stats[4] = new Statistic("Total Sightings");
		stats[5] = new Statistic("Most Common Year");
		stats[6] = new Statistic("Sent Anonymously");
		stats[7] = new Statistic("8");

	}

	

	/**
	 * Returns the relevant statistic stored with a supplied position as argument.
	 * @param position An integer to differentiate between 4 of the visible statistic boxes shown at any given time.
	 * @return The statistic at the supplied position.
	 */
	public Statistic getStat(String position) {

		if (position.equals("Top Left")) return stats[currentStatistics[TOP_LEFT]];
		else if (position.equals("Top Right")) return stats[currentStatistics[TOP_RIGHT]];
		else if (position.equals("Bottom Left")) return stats[currentStatistics[BOTTOM_LEFT]];
		else return stats[currentStatistics[BOTTOM_RIGHT]];

	}


	
	/**
	 * Changes the current state of a statistic box so that it shows a new statistic.
	 * It will never show a statistic that is already on there.
	 * Notifies observers to update the statistic view.
	 * @param position An integer to differentiate between 4 of the visible statistic boxes shown at any given time.
	 */
	public void nextStat(String position) {

		int i = getCurrentStat(position);

		while (isStatInView(i)) { 

			if (i == 7) i = 0;	
			else i++;		

		}

		setStat(position, i);

		setChanged();
		notifyObservers("Stats Box Changed");

	}

	

	/**
	 * Changes the current state of a statistic box so that it shows a new statistic.
	 * It will never show a statistic that is already on there.
	 * Notifies observers to update the statistic view.
	 * @param position An integer to differentiate between 4 of the visible statistic boxes shown at any given time.
	 */
	public void prevStat(String position) {

		int i = getCurrentStat(position);

		while (isStatInView(i)) { 

			if (i == 0) i = 7;	
			else i--;		

		}

		setStat(position, i);

		setChanged();
		notifyObservers("Stats Box Changed");

	}


	/**
	 * Returns the current statistic stored at the supplied position
	 * @param position An integer to differentiate between 4 of the visible statistic boxes shown at any given time.
	 * @return The statistic stored at supplied position, if position does not exist, returns -1/
	 */
	public int getCurrentStat(String position) {

		if (position.equals("Top Left")) return currentStatistics[TOP_LEFT];
		else if (position.equals("Top Right")) return currentStatistics[TOP_RIGHT];
		else if (position.equals("Bottom Left")) return currentStatistics[BOTTOM_LEFT];
		else if (position.equals("Bottom Right")) return currentStatistics[BOTTOM_RIGHT];
		else return -1;

	}

	
	
	/**
	 * Sets the statistic at a supplied position.
	 * @param position An integer to differentiate between 4 of the visible statistic boxes shown at any given time.
	 * @param i The statistic to be set.
	 */
	public void setStat(String position, int i) {

		if (position.equals("Top Left")) currentStatistics[TOP_LEFT] = i;
		else if (position.equals("Top Right")) currentStatistics[TOP_RIGHT] = i;
		else if (position.equals("Bottom Left")) currentStatistics[BOTTOM_LEFT] = i;
		else if (position.equals("Bottom Right")) currentStatistics[BOTTOM_RIGHT] = i;
		
		serialize();

	}


	
	/**
	 * Updates stats by calling relevant methods to calculate statistics.
	 * Then stores the stats into relevant positions in array.
	 * Then notifies observers to update stats panel.
	 * @throws IOException
	 */
	public void updateStats() throws IOException {

		stats[0].setStat(calculateHoaxes());
		stats[1].setStat(calculateNonUSSightings());
		stats[2].setStat(calculateLikeliestState());
		stats[3].setStat(calculateYoutubeSightings());
		stats[4].setStat(calculateTotalSightings());
		stats[5].setStat(calculateMostCommonYear());
		stats[6].setStat(calculateAnonymousCount());
		stats[7].setStat("S");

		setChanged();
		notifyObservers("Stats Box Changed");

	}


	
	/**
	 * Uses the Google Youtube Data API.
	 * Gets all results of UFO Sightings from Youtube from a given date.
	 * @return A string of the number of results returned.
	 * @throws IOException
	 */
	private String calculateYoutubeSightings() throws IOException {

		// Search parameters
		String search = "Unidentified%20Flying%20Object%20Sightings%20In&20America";
		String url = "https://www.googleapis.com/youtube/v3/search";
		String fromDate = mainModel.getFromSelectionYear() + "-01-01T00:00:00Z";
		String charset = StandardCharsets.UTF_8.name(); 
		String fullURL = url + "?part=snippet&q=" + search + "&publishedAfter=" + fromDate + "&key=AIzaSyCpb31Vn10CczseYpYg2m9yAz8CJ02ZyYA" ;	
		
		// Creating URL and HTTP Objects
		URL urlObj = new URL(fullURL);
		HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();

		// Setting Connection Properties
		connection.setRequestMethod("GET");

		// Grabbing data from API
		if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {

			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {		
				
				response.append(inputLine);
				
			}

			in.close();

			// Parses response JSON
			return parseNumberOfResults(response.toString());

		} else {

			return "Error";

		}

	}
	
	
	
	/**
	 * Counts the number of incidents in the given date range which are deemed to be reported anonymously.
	 * @return Number of anonymous reports as a String.
	 */
	private String calculateAnonymousCount() {
		
		int count = 0;

		for (Incident incident: mainModel.getIncidents()) {

			Matcher matcherA = ANONYMOUS.matcher(incident.getSummary());

			if (matcherA.find()) count++;

		}

		return Integer.toString(count);
		
	}


	
	/**
	 * Counts the number of incidents in the given date range which are suspected to be a hoax.
	 * @return Number of suspected hoax incidents as a String.
	 */
	private String calculateHoaxes() {

		int count = 0;

		for (Incident incident: mainModel.getIncidents()) {

			Matcher matcherA = HOAX.matcher(incident.getSummary());

			if (matcherA.find()) count++;

		}

		return Integer.toString(count);

	}



	/**
	 * Calculates the state which has received the greatest number of reports.
	 * @return State with the highest number of reports.
	 */
	private String calculateLikeliestState() {

		int count = 0;
		int max = 0;
		String state = maxValue(mainModel.getIncidentCounts());

		if (state.equals("Not specified.")) state = "N/A";

		return state;

	}


	
	/**
	 * Calculates the number of sightings which have not taken place within the US.
	 * @return Number of sightings outside the US.
	 */
	private String calculateNonUSSightings() {

		int count = 0;

		for (Incident incident: mainModel.getIncidents()) {

			Matcher matcher = VALID_STATES.matcher(incident.getState());

			if (!matcher.find()) count++;

		}

		return Integer.toString(count);

	}



	/**
	 * Counts the total number of sightings in the given date range.
	 * @return Number of incidents reported within given date range.
	 */
	private String calculateTotalSightings() {

		int count = 0;

		for (Incident incident: mainModel.getIncidents()) count++;

		return Integer.toString(count);

	}

	

	/**
	 * Calculates which year received the most number of reports within given date range.
	 * @return The year which received the most number of reports as a String.
	 */
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


    /**
     * Returns the key of a treemap with the greatest value.
     * @param map Map with String Keys and Integer values.
     * @return Key with the largest corresponding value.
     */
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


	/**
	 * Returns the year from a string.
	 * @param date Raw String to be parsed.
	 * @return Year in String format.
	 */
	private String parseYear(String date) {

		return date.replaceAll("-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}$", "");

	}

	
	
	/**
	 * Reads a stream of JSON formatted String and returns the number of results.
	 * @param json Raw JSON.
	 * @return Number of Youtube Video results as a String.
	 */
	private String parseNumberOfResults(String json) {

		JSONObject jsonParser = new JSONObject(json);

		return Integer.toString(jsonParser.getJSONObject("pageInfo").getInt("totalResults"));

	}
	
	
	
	/**
	 * Checks if the statistic at the supplied location is currently displayed or not.
	 * @param i The position to check.
	 * @return True or false. Whether the supplied postion is displayed.
	 */
	private boolean isStatInView(int i) {
		
		if ((i == currentStatistics[TOP_LEFT]) 
				|| (i == currentStatistics[TOP_RIGHT]) 
				|| (i == currentStatistics[BOTTOM_LEFT])
				|| (i == currentStatistics[BOTTOM_RIGHT])) {
			
			return true;
			
		} else return false;
			
	}


	
	/**
	 * Serializes a supplied object. In this case, writing the currentStatistics array into a text file so it can be loaded again.
	 */

	public void serialize() {

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/requirementXv2/serialize.ser", false))) {

			out.writeObject(currentStatistics);

		} catch(IOException ex) {

			System.out.println(ex.getMessage());

		}

	}



	/**
	 * Reads from a text file and deserializes it, turning it back into a readable Java Object.
	 */
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


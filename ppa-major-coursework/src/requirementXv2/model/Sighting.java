// Package
package requirementXv2.model;

// Import
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sighting {
	
	
	// Regular Expressions
	public static final Pattern DATE_A = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}$");
	
	public static final Pattern DURATION_A = Pattern.compile("^\\d{1,2}\\s[Mm]inutes?$");
	public static final Pattern DURATION_B = Pattern.compile("^\\d{1,2}\\s[Ss]econds?$");
	public static final Pattern DURATION_C = Pattern.compile("^[Nn][Oo][Ww]$");
	public static final Pattern DURATION_D = Pattern.compile("^\\d{1,2}-\\d{1,2}\\s[Mm]inutes?$");
	public static final Pattern DURATION_E = Pattern.compile("^\\d{1,2}\\s[Hh]ours?$");
	
		
	
	// Fields
	private String dateTime;
	private Date date;
	private String city;
	private String state;
	private String shape;
	private Date posted;
	private String postedString;
	private String id;
	private String summary;
	private int duration;

	
	
	/**
	 * Parses a string for the date, and the time.
	 * Then sets the date, and time field.
	 * @param dateTime String containing both date and time of incident.
	 */
	public void setDateTime(String dateTime) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Matcher matcherA = DATE_A.matcher(dateTime);
		
		// If string matches regular expression DATE_A
		if (matcherA.find()) {
			
			String rawDate = matcherA.group();
			
			rawDate = rawDate.replaceAll(":\\d{2}$", "");
			this.dateTime = rawDate;
			rawDate = rawDate.replaceAll("\\s\\d{2}:\\d{2}", "");
			
			try { date = sdf.parse(rawDate); } catch (ParseException e) { e.printStackTrace(); }
			
		}
		
	}
	
	
	/**
	 * Sets ID of incident.
	 * @param id ID of incident.
	 */
	public void setID(String id) {
		
		this.id = id;
		
	}
	
	
	/**
	 * Sets city of incident.
	 * @param city City of incident.
	 */
	public void setCity(String city) {
		
		this.city = city;
		
	}
	
	
	/**
	 * Sets state of incident.
	 * @param state State of incident.
	 */
	public void setState(String state) {
		
		this.state = state;
		
	}
	
	
	/**
	 * Sets summary of incident.
	 * @param summary Summary of incidents.
	 */
	public void setSummary(String summary) {
		
		this.summary = summary;
		
	}
	
	
	/**
	 * Sets shape of incident.
	 * @param shape Shape of incident.
	 */
	public void setShape(String shape) {
		
		this.shape = shape;
		
	}
	
	
	/**
	 * Parses the duration and turns it into a standardised integer representing number of minutes.
	 * @param duration Duration of incident from Ripley.
	 */
	public void setDuration(String duration) {
		
		Matcher matcherA = DURATION_A.matcher(duration);
		Matcher matcherB = DURATION_B.matcher(duration);
		Matcher matcherC = DURATION_C.matcher(duration);
		Matcher matcherD = DURATION_D.matcher(duration);
		Matcher matcherE = DURATION_E.matcher(duration);
		
		// If in format eg "2 Minutes"
		if (matcherA.find()) {
			
			String rawDuration = matcherA.group();
			rawDuration = rawDuration.replaceAll("\\s[Mm]inutes?$", "");
			this.duration = Integer.parseInt(rawDuration);
			
		// If in format eg "2 Seconds"
		} else if (matcherB.find()) {
			
			String rawDuration = matcherB.group();
			rawDuration = rawDuration.replaceAll("\\s[Ss]econds?$", "");
			this.duration = (Integer.parseInt(rawDuration) % 3600) / 60;
			
		// If in format eg "NOW"
		} else if (matcherC.find()) {
			
			String rawDuration = matcherC.group();
			rawDuration = rawDuration.replaceAll("[Nn][Oo][Ww]", "");
			this.duration = 0;	
		
		// If in format eg "2-10 Minutes"
		} else if (matcherD.find()) {
			
			String rawDuration = matcherD.group();
			rawDuration = rawDuration.replaceAll("^\\d{1,2}-", "");
			rawDuration = rawDuration.replaceAll("\\s[Mm]inutes?$", "");
			this.duration = Integer.parseInt(rawDuration);
		
		// If in format eg "2 Hours"
		} else if (matcherE.find()) {
			
			String rawDuration = matcherE.group();
			rawDuration = rawDuration.replaceAll("\\s[Hh]ours?$", "");
			this.duration = (Integer.parseInt(rawDuration) * 60);
			
		} else this.duration = -1;
		
	}
	
	
	
	/**
	 * Turns the posted date of type string into a parsable date format and sets the posted field.
	 * @param posted String representing date of incident.
	 */
	public void setPosted(String posted) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		this.postedString = posted;
		
		try { this.posted = sdf.parse(posted); } catch (ParseException e) { e.printStackTrace(); }
		
	}
	
	
	/**
	 * @return ID of sighting.
	 */
	public String getID() { return id; }
	
	
	/**
	 * @return date and time of sighting.
	 */
	public String getDateTime() { return dateTime; }
	
	
	/**
	 * @return City of sighting.
	 */
	public String getCity() { return city; }
	
	
	/**
	 * @return State of sighting.
	 */
	public String getState() { return state; }
	
	
	/**
	 * @return Shape of UFO sighting.
	 */
	public String getShape() { return shape; }
	
	
	/**
	 * @return Summary of sighting report.
	 */
	public String getSummary() { return summary; }
	
	
	/**
	 * @return Duration of sighting.
	 */
	public int getDuration() { return duration; }
	
	
	/**
	 * @return Date of sighting.
	 */
	public Date getDate() { return date; }
	
	
	/**
	 * @return Date sighting report posted.
	 */
	public Date getPosted() { return posted; }
	

	/**
	 * ToString. String representation of sighting object.
	 */
	public String toString() {
		
		return "Time: "+ dateTime + ", City: " + city + ", Shape: " + shape + ", Duration: " + duration + " minutes, Posted: " + postedString;
		
	}	

}

package requirementXv2.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sighting {
	
	
	// Regular Expressions
	
	public static final Pattern DATE_A = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}$");
	
		
	
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
	
	
	/** Constructor **/
	
	public Sighting() {
	
		
	}
	
	
	
	/** Setters **/
	
	public void setDateTime(String dateTime) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Matcher matcherA = DATE_A.matcher(dateTime);
		
		
		if (matcherA.find()) {
			
			String rawDate = matcherA.group();
			
			rawDate = rawDate.replaceAll(":\\d{2}$", "");
			this.dateTime = rawDate;
			rawDate = rawDate.replaceAll("\\s\\d{2}:\\d{2}", "");
			
			try { date = sdf.parse(rawDate); } catch (ParseException e) { e.printStackTrace(); }
			
		}
		
	}
	
	public void setID(String id) {
		
		this.id = id;
		
	}
	
	public void setCity(String city) {
		
		this.city = city;
		
	}
	
	
	public void setState(String state) {
		
		this.state = state;
		
	}
	
	public void setSummary(String summary) {
		
		this.summary = summary;
		
	}
	
	public void setShape(String shape) {
		
		this.shape = shape;
		
	}
	
	public void setDuration(String duration) {
		
		if (duration.equals("Not specified.")) this.duration = -1;
		else this.duration = 2;
		
		System.out.println(duration);
		
	}
	
	public void setPosted(String posted) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		this.postedString = posted;
		
		try { this.posted = sdf.parse(posted); } catch (ParseException e) { e.printStackTrace(); }
		
	}
	
	
	/** Getters **/
	
	public String getID() { return id; }
	
	public String getDateTime() { return dateTime; }
	
	public String getCity() { return city; }
	
	public String getState() { return state; }
	
	public String getShape() { return shape; }
	
	public String getSummary() { return summary; }
	
	public int getDuration() { return duration; }
	
	public Date getDate() { return date; }
	
	public Date getPosted() { return posted; }
	
	
	
	/** Useful **/
	
	private void parseDateTime() {}
	
	private void parseDuration() {}
	
	
	
	/** Overrides **/
	
	public String toString() {
		
		return "Time: "+ dateTime + " City: " + city + " Shape: " + shape + " Duration: " + duration + " Posted: " + postedString;
		
	}

	

}

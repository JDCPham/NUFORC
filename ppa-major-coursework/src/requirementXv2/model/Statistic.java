// Package
package requirementXv2.model;


/**
 * This class represents a statistic as stored in the stats panel.
 * It contains the title of the statistic eg "Total Sightings", and the stat itself, eg. "35"/
 * @author JP
 */
public class Statistic {
	
	// Fields
	private String title;
	private String stat;
	
	/**
	 * Constructor method.
	 */
	public Statistic() {}
	
	
	/**
	 * Constructor method.
	 * Sets title of statistic.
	 * @param t Title of statistic.
	 */
	public Statistic(String t) {
		
		title = t;
		
	}
	
	
	
	/**
	 * @return Title of statistic.
	 */
	public String getTitle() { return title; }
	
	
	/**
	 * @return String representation of statistic.
	 */
	public String getStat() { return stat; }
	
	
	/**
	 * Sets the title of the statistic.
	 * @param title Title of statistic.
	 */
	public void setTitle(String title) { this.title = title; }
	
	
	/**
	 * Sets the statistic.
	 * @param stat Statistic.
	 */
	public void setStat(String stat) { this.stat = stat; }

}

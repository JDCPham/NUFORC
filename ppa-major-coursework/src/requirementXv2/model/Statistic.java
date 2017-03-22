package requirementXv2.model;

public class Statistic {
	
	private String title;
	private String stat;
	
	
	public Statistic() {
		
		
	}
	
	public Statistic(String t) {
		
		title = t;
		
	}
	
	
	/** Getters **/
	
	public String getTitle() { return title; }
	
	public String getStat() { return stat; }
	
	
	
	/** Setters **/
	
	public void setTitle(String title) { this.title = title; }
	
	public void setStat(String stat) { this.stat = stat; }

}

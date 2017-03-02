package requirementX.model;

import javax.swing.JPanel;

import api.ripley.Ripley;
import requirementX.view.WelcomePanel;

public class MainModel {

	public static final int WELCOME_PANEL = 0;
	public static final int MAP_PANEL = 1;
	public static final int STATS_PANEL = 2;

	private Ripley ripley;
	private int startYear;
	private int latestYear;
	private String lastUpdated;
	private int currentPanel;

	public MainModel() {

		// Set up Ripley
		ripley = new Ripley("10tLI3CWstqyVD6ql2OMtA==", "tBgm4pRo9grVqL46EnH7ew==");

		// Set current panel
		currentPanel = WELCOME_PANEL;

		// Get time range
		startYear = ripley.getStartYear();
		latestYear = ripley.getLatestYear();

		// Get when data last updated
		lastUpdated = ripley.getLastUpdated();
		

	}
	
	

	public Ripley getRipley() {
		
		return ripley;
		
	}
	


	public int getCurrentPanel() {

		return currentPanel;

	}



	public String getLastUpdated() {

		return lastUpdated;

	}



	public int getLatestYear() {

		return latestYear;

	}



	public int getStartYear() {

		return startYear;

	}




}

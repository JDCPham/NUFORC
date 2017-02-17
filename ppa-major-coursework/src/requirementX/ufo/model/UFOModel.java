package requirementX.ufo.model;

import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JPanel;

import api.ripley.Ripley;

public class UFOModel extends Observable{
	
	private int fromYear;
	private int toYear;
	private int currentPanel;
	private boolean dataReady;
	
	private Ripley ripley;
	
	
	
	public UFOModel() throws InterruptedException{
		currentPanel = 0;
		dataReady = false;
		setRipley();

	}
	
	public double getVersion(){
		return ripley.getVersion();
	}
	
	public int getCurrentPanel(){
		return currentPanel;
	}
	
	public void setNextPanel(ArrayList<JPanel> views){		
		if (currentPanel < views.size()-1){
			currentPanel++;
		} else {
			currentPanel = 0;
		}
		setChanged();
		notifyObservers();
	}
	
	public void setFromYear(String year){
		fromYear = Integer.parseInt(year);
		setChanged();
		notifyObservers();
	}
	
	public void setToYear(String year){
		toYear = Integer.parseInt(year);
		setChanged();
		notifyObservers();
	}
	
	public int getFromYear(){
		return fromYear;
	}
	
	public int getToYear(){
		return toYear;
	}
	
	public boolean isDataReady(){
		return dataReady;
	}
	
	public void setRipley(){
		ripley = new Ripley("10tLI3CWstqyVD6ql2OMtA==", "tBgm4pRo9grVqL46EnH7ew==");
	}
	
	public int getStartYear(){
		return ripley.getStartYear();
	}
	
	public int getLatestYear(){
		return ripley.getLatestYear();
	}
	
	public String getLastUpdated(){
		return ripley.getLastUpdated();
	}
	

	
	
	
}

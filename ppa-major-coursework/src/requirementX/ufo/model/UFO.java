package requirementX.ufo.model;

import java.util.Observable;

public class UFO extends Observable{
	
	private int fromYear;
	private int toYear;
	
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
	
	
	
	
}

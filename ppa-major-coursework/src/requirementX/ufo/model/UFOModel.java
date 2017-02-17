package requirementX.ufo.model;

import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JPanel;

public class UFOModel extends Observable{
	
	private int fromYear;
	private int toYear;

	private int currentPanel;
	
	public UFOModel(){
		this.currentPanel = 0;
	}
	
	public int getCurrentPanel(){
		return currentPanel;
	}
	
	public void setCurrentPanel(int i){
		currentPanel = i;
	}
	
	public void setNextPanel(){
		currentPanel++;
		setChanged();
		notifyObservers();
	}
	
	public void setFromYear(String year){
		fromYear = Integer.parseInt(year);
	}
	
	public void setToYear(String year){
		toYear = Integer.parseInt(year);
	}
	
	public int getFromYear(){
		return fromYear;
	}
	
	public int getToYear(){
		return toYear;
	}
	

	
	
	
}

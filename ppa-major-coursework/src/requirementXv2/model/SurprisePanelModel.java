package requirementXv2.model;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Observable;

public class SurprisePanelModel extends Observable {
	private Dictionary<Integer,String> dictionary;
	private int score;
	
	public SurprisePanelModel() {
		dictionary = new Hashtable<Integer,String>();
		dictionary.put(0,"A");
		dictionary.put(1,"A");
		dictionary.put(2,"B");
		dictionary.put(3,"D");
		dictionary.put(4,"D");
		dictionary.put(5,"C");
		dictionary.put(6,"C");
		dictionary.put(7,"A");
		
		
	}
	
	public void checkAnswer(int question, String answer) {
		if (answer.equals(dictionary.get(question))) {
			score++;
		}
	}


}

package requirementXv2.model;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Observable;

public class SurprisePanelModel extends Observable {
	private int score;
	private ArrayList<Question> questions = new ArrayList<Question>();
	
	public SurprisePanelModel() {
		
		Question question0 = new Question("what is 5+5?");
		question0.addAnswers("A:10", "B:11", "C:12", "D:9");
		questions.add(question0);
		
	}
	
	public String getQuestion(int question, int answer) {
		return questions.get(question).getQuestion(answer);
	}
	

	
	/*public void checkAnswer(int question, String answer) {
		if (answer.equals(dictionary.get(question))) {
			score++;
			System.out.println("hello");
		}
		notifyObservers();
		setChanged();
	}*/


}

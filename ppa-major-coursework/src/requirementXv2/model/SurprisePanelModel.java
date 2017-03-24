package requirementXv2.model;

import java.util.ArrayList; 
import java.util.Observable;

public class SurprisePanelModel  {
	private int score;
	private ArrayList<Question> questions = new ArrayList<Question>();
	private ArrayList<String> rewrite = new ArrayList<String>();
	
	public SurprisePanelModel() {
		
		Question question0 = new Question("what is 5+5?");
		question0.addAnswers("A:10", "B:11", "C:12", "D:9");
		questions.add(question0);
		
	}
	
	public String getQuestion(int question, int answer) {
		return questions.get(question).getQuestion(answer);
	}
	
	public void write(String line) {
		rewrite.add(line);
		System.out.println(rewrite);
	}
	
	public ArrayList<String> rewrite() {
		rewrite.remove(rewrite.size()-1);
		rewrite.remove(rewrite.size()-1);
		rewrite.remove(rewrite.size()-1);
		rewrite.remove(rewrite.size()-1);
		
		return rewrite;
	}


}

package requirementXv2.model;

import java.util.ArrayList;

public class Question {
	//1 question and 4 options
	private ArrayList<String> question = new ArrayList<String>();
	
	public Question(String question) {
		this.question.add(question);
		
	}
	
	public void addAnswers(String optionA, String optionB, String optionC, String optionD) {
		question.add(optionA);
		question.add(optionB);
		question.add(optionC);
		question.add(optionD);
	}
	
	public String getQuestion(int answer) {
		
		return question.get(answer);
	}
	
	
}

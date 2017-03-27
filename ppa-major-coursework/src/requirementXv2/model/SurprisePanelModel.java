package requirementXv2.model;

import java.util.ArrayList; 

public class SurprisePanelModel  {
	private int score;
	private ArrayList<Question> questions = new ArrayList<Question>();
	private ArrayList<String> rewrite = new ArrayList<String>();
	private int[] markScheme = new int[4];
	
	public SurprisePanelModel() {
		
		Question question0 = new Question("what is 5+5?");
		question0.addAnswers("A:10", "B:11", "C:12", "D:9");
		questions.add(question0);
		markScheme[0] = 1;
		
		Question question1 = new Question("how hot am I?");
		question1.addAnswers("A:VERY", "B:NOT VERY", "C:CAOKY", "D:10");
		questions.add(question1);
		markScheme[1] = 3;
		
		Question question2 = new Question("what is 5+5?");
		question2.addAnswers("A:10", "B:11", "C:12", "D:9");
		questions.add(question2);
		markScheme[2] = 1;
	}
	
	public String getAnswerPicked(int question, int answer) {
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
	
	public void checkAnswer(int question, int answer) {
		System.out.println("1");
		if (markScheme[question] == answer) {
			score++;
		}
	}
	
	public int getScore() {
		return score;
	}


}

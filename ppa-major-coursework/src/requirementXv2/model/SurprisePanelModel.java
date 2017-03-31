package requirementXv2.model;

import java.util.ArrayList; 

public class SurprisePanelModel  {
	private int score;
	private ArrayList<Question> questions = new ArrayList<Question>();
	private ArrayList<String> rewrite = new ArrayList<String>();
	private int[] markScheme = new int[10];
	
	public SurprisePanelModel() {
		
		Question question1 = new Question("What planet are you from?");
		question1.addAnswers("A:Earth", "B:Neptune", "C:Jupiter", "D:Uranus");
		questions.add(question1);
		markScheme[0] = 4;
		
		Question question2 = new Question("How hot am I?");
		question2.addAnswers("A:Very", "B:Not Very", "C:Caoky", "D:Martin");
		questions.add(question2);
		markScheme[1] = 4;
		
		Question question3 = new Question("Have you finished Assignment 7?");
		question3.addAnswers("A:Yes", "B:Nearly", "C:I'm in therapy", "D:I dropped out after Assignment 2");
		questions.add(question3);
		markScheme[2] = 4;
		
		Question question4 = new Question("How lush is your beard?");
		question4.addAnswers("A:Full blown Martin", "B:Three Quarters Martin", "C:Half Martin", "D:Haven't reached puberty");
		questions.add(question4);
		markScheme[3] = 1;
		
		Question question5 = new Question("What is your favourite movie?");
		question5.addAnswers("A:Shrek", "B:Shrek 2 ", "C:Shrek The Third", "D:Shrek Forever After");
		questions.add(question5);
		markScheme[4] = 1;
		
		Question question6 = new Question("What is your favourite drink?");
		question6.addAnswers("A:Martini Shaken", "B:Martini Stirred ", "C:Bloody Mary", "D:Caramel Frappucino");
		questions.add(question6);
		markScheme[5] = 2;
		
		Question question7 = new Question("What is your favourite place to eat?");
		question7.addAnswers("A:King's Canteen", "B:McDonald's", "C:Tesco �3 meal deal", "D:The Fridge");
		questions.add(question7);
		markScheme[6] = 3;
		
		Question question8 = new Question("Differentiate e^x.");
		question8.addAnswers("A:I'm only first year", "B:4", "C:Shakespeare", "D:7");
		questions.add(question8);
		markScheme[7] = 1;
		
		Question question9 = new Question("What's the worst football team?");
		question9.addAnswers("A:Definitely not Liverpool", "B:Manchester United", "C:Chelsea", "4:Arsenal");
		questions.add(question9);
		markScheme[8] = 4;
		
		Question question10 = new Question("What's the best degree?");
		question10.addAnswers("A:Computer Science", "B:English", "C:Liberal Arts", "4:Geography");
		questions.add(question10);
		markScheme[9] = 1;
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
		System.out.println(score);
		if (markScheme[question] == answer) {
			score++;
		}
	}
	
	public int getScore() {
		return score;
	}


}

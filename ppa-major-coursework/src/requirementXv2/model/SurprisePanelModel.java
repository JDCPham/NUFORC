package requirementXv2.model;

import java.util.ArrayList;

/**
 * This class is the model for the fourth panel.
 * It contains the questions, answers and mark scheme
 * for the chat.
 * @author Emmanuel
 *
 */

public class SurprisePanelModel  {
	private int score;														//Instance variable for the score
	private ArrayList<Question> questions = new ArrayList<Question>();		//Instance variable for the list of questions
	private ArrayList<String> rewrite = new ArrayList<String>();			//Instance variable for list of chosen options
	private int[] markScheme = new int[10];									//Instance variable for mark scheme array of size 10
	
	/**
	 * Class constructor. When this class is created, the 10
	 * questions with each of their correct answers are also created.
	 */
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
		question4.addAnswers("A:Full blown Martin", "B:Three Quarters Martin", "C:Half Martin",
				"D:Haven't reached puberty");
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
		question7.addAnswers("A:King's Canteen", "B:McDonald's", "C:Tesco \u00A33 meal deal", "D:The Fridge");
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
		question10.addAnswers("A:Computer Science", "B:English", "C:Liberal Arts", "D:Geography");
		questions.add(question10);
		markScheme[9] = 1;
	}

	
	/**
	 * Method to get the answer chosen.
	 * @param question
	 * @param answer
	 * @return the chosen answer
	 */
	public String getAnswerPicked(int question, int answer) {
		return questions.get(question).getQuestion(answer);

	}

	
	/**
	 * Method to add answers to the rewrite 
	 * array list.
	 * @param line
	 */
	public void write(String line) {
		rewrite.add(line);
	}

	
	/**
	 * Method to remove unchosen answers
	 * from the array list.
	 * @return the array list with only the chosen answer
	 */
	public ArrayList<String> rewrite() {
		rewrite.remove(rewrite.size() - 1);
		rewrite.remove(rewrite.size() - 1);
		rewrite.remove(rewrite.size() - 1);
		rewrite.remove(rewrite.size() - 1);

		return rewrite;
	}

	
	/**
	 * Method to check the answer against the mark scheme
	 * and update the score.
	 * @param question
	 * @param answer
	 */
	public void checkAnswer(int question, int answer) {
		System.out.println(score);
		if (markScheme[question] == answer) {
			score++;
		}
	}

	
	/**
	 * Method to get the score.
	 * @return
	 */
	public int getScore() {
		return score;
	}

	public boolean checkScore() {

		if (score > 5) {

			System.out.println("GJ, You won.");
			return true;

		} else {

			System.out.println("You're going to die alone.");
			return false;

		}
	}

}

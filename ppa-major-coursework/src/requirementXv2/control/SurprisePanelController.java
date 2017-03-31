package requirementXv2.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import requirementXv2.model.SurprisePanelModel;
import requirementXv2.view.ChatRoomFrame;
/**
 * 
 * @author caokynguyen
 * 
 */
public class SurprisePanelController implements ActionListener {

	private ChatRoomFrame view;
	private SurprisePanelModel model;
	private int questionCount;
	private int answer;

	/**
	 * When this class is created, 
	 * @param view
	 * @param model
	 */
	public SurprisePanelController(ChatRoomFrame view, SurprisePanelModel model) {
		this.view = view;
		this.model = model;
		view.addActionListener(this);
		for (int i = 0; i < 5; i++) {
			model.write(model.getAnswerPicked(0, i));
			view.write(model.getAnswerPicked(0, i));
		}
	}

	@Override
	/**
	 * Method to check what button the user clicked.
	 */
	public void actionPerformed(ActionEvent e) {
		if (questionCount < 10) {

			if (((JButton) e.getSource()).getName().equals("buttonA")) {

				view.write(model.rewrite());
				view.write(model.getAnswerPicked(questionCount, 1));
				model.write(model.getAnswerPicked(questionCount, 1));

				answer = 1;

			}
			if (((JButton) e.getSource()).getName().equals("buttonB")) {

				view.write(model.rewrite());
				view.write(model.getAnswerPicked(questionCount, 2));
				model.write(model.getAnswerPicked(questionCount, 2));

				answer = 2;
			}
			if (((JButton) e.getSource()).getName().equals("buttonC")) {

				view.write(model.rewrite());
				view.write(model.getAnswerPicked(questionCount, 3));
				model.write(model.getAnswerPicked(questionCount, 3));

				answer = 3;

			}
			if (((JButton) e.getSource()).getName().equals("buttonD")) {

				view.write(model.rewrite());
				view.write(model.getAnswerPicked(questionCount, 4));
				model.write(model.getAnswerPicked(questionCount, 4));

				answer = 4;

			}
			model.checkAnswer(questionCount, answer);

			questionCount++;
			if (questionCount < 10) {
				showQuestion();
			} else {
				if (model.getScore() > 6) {
					view.write("Congratulations you have won!");
				}else{
					view.write("You have lost!");
				}
				
				view.write("<html><b>MR STEAL YOUR GIRL AKA MARTIN CHAPMAN HAS STOLEN YOUR GIRL</b></html>");
				view.write("<html><b>BETTER LUCK NEXT TIME</b></html>Ï");

			}
		}
	}
	
	/**
	 * 
	 */
	public void showQuestion() {
		for (int i = 0; i < 5; i++) {
			model.write(model.getAnswerPicked(questionCount, i));
			view.write(model.getAnswerPicked(questionCount, i));
		}
	}

}

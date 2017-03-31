package requirementXv2.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import requirementXv2.model.SurprisePanelModel;
import requirementXv2.view.ChatRoomFrame;

/**
 * This class is the controller for the surprise panel.
 * @author caokynguyen
 * 
 */
public class SurprisePanelController implements ActionListener {

	// Field that holds the surprise panel view.
	private ChatRoomFrame view;	
	// Field that holds the surprise panel model.
	private SurprisePanelModel model;
	// Field to track the number of questions.
	private int questionCount;
	// Field to track the answer.
	private int answer;

	/**
	 * When this class is created, 
	 * this adds the question and answers to the jlist.
	 * @param view View of the surprise panel.
	 * @param model Model of the surprise panel.
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
	 * Action listener for the buttons.
	 * Method to check what button the user clicked,
	 * and to check game outcome when finished.
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
					view.write("<html><b>Congratulations you have won!</b></html>");
				} else {
					view.write("<html><b>You have lost!</b></html>");

				}
			}
		}
	}

	/**
	 * Method that shows the question on the list.
	 */
	public void showQuestion() {
		for (int i = 0; i < 5; i++) {
			model.write(model.getAnswerPicked(questionCount, i));
			view.write(model.getAnswerPicked(questionCount, i));
		}
	}

}

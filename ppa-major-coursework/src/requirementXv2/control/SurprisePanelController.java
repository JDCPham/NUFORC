package requirementXv2.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import requirementXv2.model.SurprisePanelModel;
import requirementXv2.view.ChatRoomFrame;

public class SurprisePanelController implements ActionListener {

	private ChatRoomFrame view;
	private SurprisePanelModel model;
	private int questionCount;
	private int answer;
	
	public SurprisePanelController(ChatRoomFrame view, SurprisePanelModel model) {
		this.view = view;
		this.model = model;
		view.addActionListener(this);
		for (int i = 0; i<5; i++) {
			model.write(model.getAnswerPicked(0, i));
			view.write(model.getAnswerPicked(0,i));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (questionCount < 9 ) {
			System.out.println("questionCount " + questionCount);
			if (((JButton)e.getSource()).getName().equals("buttonA")) {
				
				view.write(model.rewrite());
				view.write(model.getAnswerPicked(questionCount, 1));
				model.write(model.getAnswerPicked(questionCount, 1));
				
				System.out.println("button A pressed");
				answer = 1;
				
			}
			if (((JButton)e.getSource()).getName().equals("buttonB")) {
				
				view.write(model.rewrite());
				view.write(model.getAnswerPicked(questionCount, 2));
				model.write(model.getAnswerPicked(questionCount, 2));
				
				System.out.println("button B pressed");
				answer = 2;
			}
			if (((JButton)e.getSource()).getName().equals("buttonC")) {
				
				view.write(model.rewrite());
				view.write(model.getAnswerPicked(questionCount, 3));
				model.write(model.getAnswerPicked(questionCount, 3));
				System.out.println("button C pressed");
				answer = 3;
				
			}
			if (((JButton)e.getSource()).getName().equals("buttonD")) {
				
				view.write(model.rewrite());
				view.write(model.getAnswerPicked(questionCount, 4));
				model.write(model.getAnswerPicked(questionCount, 4));
				System.out.println("button D pressed");
				answer = 4;
		
			}
			model.checkAnswer(questionCount, answer);
			System.out.println(model.getScore());
			questionCount++;
			showQuestion();
		}	
	}
	
	public void showQuestion() {
		for (int i = 0; i<5; i++) {
			model.write(model.getAnswerPicked(questionCount, i));
			view.write(model.getAnswerPicked(questionCount,i));
		}
	}
	
}

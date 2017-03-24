package requirementXv2.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import requirementXv2.model.SurprisePanelModel;
import requirementXv2.view.SurprisePanel;

public class SurprisePanelController implements ActionListener {

	private SurprisePanel view;
	private SurprisePanelModel model;
	private int questionCount;
	
	public SurprisePanelController(SurprisePanel view, SurprisePanelModel model) {
		this.view = view;
		this.model = model;
		view.addActionListener(this);
		for (int i = 0; i<5; i++) {
			model.write(model.getQuestion(0, i));
			view.write(model.getQuestion(0,i));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if (((JButton)e.getSource()).getName().equals("buttonA")) {
			
			view.write(model.rewrite());
			view.write(model.getQuestion(questionCount, 1));
			System.out.println("button A pressed");
			
		}
		if (((JButton)e.getSource()).getName().equals("buttonB")) {
			
			view.write(model.rewrite());
			view.write(model.getQuestion(questionCount, 2));
			System.out.println("button B pressed");
		}
		if (((JButton)e.getSource()).getName().equals("buttonC")) {
			
			view.write(model.rewrite());
			view.write(model.getQuestion(questionCount, 3));
			System.out.println("button C pressed");
			
		}
		if (((JButton)e.getSource()).getName().equals("buttonD")) {
			
			view.write(model.rewrite());
			view.write(model.getQuestion(questionCount, 4));
			System.out.println("button D pressed");
			
		}
		questionCount++;
	}
	
}

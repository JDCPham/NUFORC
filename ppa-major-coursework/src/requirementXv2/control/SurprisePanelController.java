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
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (((JButton)e.getSource()).getName().equals("buttonA")) {
			model.checkAnswer(questionCount, "A");
		}
	}
	
}

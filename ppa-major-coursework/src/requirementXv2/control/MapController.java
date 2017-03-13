package requirementXv2.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import requirementXv2.model.MapModel;
import requirementXv2.view.StatesFrame;

public class MapController {
	
	private MapModel mapModel;

	public MapController(MapModel mapModel) {
		
		this.mapModel = mapModel;
		
	}

	public class AlienIconListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			new StatesFrame(mapModel, getState(e));

		}


	}

	public String getState(ActionEvent e) {

		JButton button = (JButton) e.getSource();
		String state = button.getName();
		return state;

	}

}

package requirementXv2.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JList;

import requirementXv2.model.MapModel;
import requirementXv2.view.SightingDialog;
import requirementXv2.view.StatesFrame;

public class MapController {

	private MapModel mapModel;

	public MapController(MapModel mapModel) {

		this.mapModel = mapModel;

	}

	public MapController() {


	}


	public class AlienIconListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			new StatesFrame(mapModel, getState(e));

		}


	}

	public class ListListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {

			if (e.getClickCount() == 2) {
				
				String item = getSelectedListItem(e);
				System.out.println(item);
				new SightingDialog();

			}

		}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}

	}

	
	/** Convert from events to source **/
	
	public String getState(ActionEvent e) {

		JButton button = (JButton) e.getSource();
		String state = button.getName();
		return state;

	}
	
	public String getSelectedListItem(MouseEvent e) {
		
		JList<String> list = (JList<String>) e.getSource();
		String item = list.getSelectedValue();
		return item;
		
	}

}

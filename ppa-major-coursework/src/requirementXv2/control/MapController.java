package requirementXv2.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JList;

import requirementXv2.model.MapModel;
import requirementXv2.model.Sighting;
import requirementXv2.view.SightingDialog;
import requirementXv2.view.StatesFrame;

public class MapController {

	private MapModel mapModel;

	
	/** Constructor **/
	
	public MapController(MapModel mapModel) {

		this.mapModel = mapModel;

	}

	public MapController() {}


	
	/** Action Listener **/
	
	public class AlienIconListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			new StatesFrame(mapModel, getState(e));

		}


	}
	
	public class CloseListener implements ActionListener {
		
		private JDialog dialog;
		
		public CloseListener(JDialog dialog) {
			
			this.dialog = dialog;
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			dialog.dispose();

		}

	}
	

	public class ListListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {

			if (e.getClickCount() == 2) {
				
				Sighting item = getSelectedListItem(e);
				new SightingDialog(item.getSummary());

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
	
	public String getValue(ActionEvent e) {
		
		JComboBox<String> combo = (JComboBox<String>) e.getSource();
		String value = (String) combo.getSelectedItem();
		return value;
		
	}
	
	public Sighting getSelectedListItem(MouseEvent e) {
		
		JList<Sighting> list = (JList<Sighting>) e.getSource();
		Sighting item = list.getSelectedValue();
		return item;
		
	}

}

package requirementX.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;

import requirementX.model.MainModel;

public class MainController implements ActionListener {

	MainModel mainModel;

	public MainController(MainModel mainModel){

		this.mainModel = mainModel;

	}
	
	
	public boolean checkDateRange() {
		
		int from = mainModel.getFromSelectionYear();
		int to = mainModel.getToSelectionYear();
		
		if (from <= to) return true;
		else return false;
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if (((JComponent) e.getSource()).getName().equals("Right Button")) mainModel.setNextPanel();
		if (((JComponent) e.getSource()).getName().equals("Left Button")) mainModel.setPreviousPanel();
		if (((JComponent) e.getSource()).getName().equals("From ComboBox")) {

			JComboBox<String> widget = (JComboBox<String>) e.getSource();
			String year = (String) widget.getSelectedItem();
			mainModel.setFromSelectionYear(Integer.parseInt(year));
			if (mainModel.setDateValid()) mainModel.getData();

		}
		
		if (((JComponent) e.getSource()).getName().equals("To ComboBox")) {

			JComboBox<String> widget = (JComboBox<String>) e.getSource();
			String year = (String) widget.getSelectedItem();
			mainModel.setToSelectionYear(Integer.parseInt(year));
			if (mainModel.setDateValid()) mainModel.getData();

		}

	}

}

package requirementXv2.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

import requirementXv2.model.MainModel;
import requirementXv2.model.MapModel;
import requirementXv2.model.WelcomeModel;
import requirementXv2.view.StatesFrame;

public class MainController {
	
	// Models
	private MainModel mainModel;
	private WelcomeModel welcomeModel;
	private MapModel mapModel;
	
	/** Constructor **/
	
	public MainController(MainModel mainModel, WelcomeModel welcomeModel, MapModel mapModel) {
		
		this.mainModel = mainModel;
		this.welcomeModel = welcomeModel;
		this.mapModel = mapModel;
		
	}
	
	
	/** Action Listener Inner Classes **/
	
	public class RightButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			mainModel.setNextPanel();
			
		}
		
	}
	
	
	public class LeftButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			mainModel.setPreviousPanel();
			
		}
		
	}
	
	
	public class FromComboBoxListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String year = getSelectedItem(e);
			mainModel.setFromSelectionYear(year);
			if (mainModel.isDateValid()) mapModel.updateStates();
			
		}
		
	}
	
	
	public class ToComboBoxListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			String year = getSelectedItem(e);
			mainModel.setToSelectionYear(year);
			if (mainModel.isDateValid()) mapModel.updateStates();
			
		}
		
	}
	
	
	public class AlienIconListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			new StatesFrame(mapModel, getState(e));
			
		}
		
		
		
	}
	
	
	/** Useful **/
	
	public JComboBox<String> getComboBox(ActionEvent e) { return (JComboBox<String>) e.getSource(); }
	
	public String getSelectedItem(ActionEvent e) { 
		
		JComboBox<String> comboBox = getComboBox(e);
		comboBox.hidePopup();
		return (String) comboBox.getSelectedItem(); 
		
	}
	
	public String getState(ActionEvent e) {
		
		JButton button = (JButton) e.getSource();
		String state = button.getName();
		return state;
		
	}
	

}

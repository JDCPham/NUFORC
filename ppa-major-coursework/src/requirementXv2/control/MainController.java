package requirementXv2.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import requirementXv2.model.MainModel;
import requirementXv2.model.MapModel;
import requirementXv2.model.WelcomeModel;

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
			
			JComboBox<String> comboBox = (JComboBox<String>) e.getSource();
			String year = (String) comboBox.getSelectedItem();
			mainModel.setFromSelectionYear(year);
			
		}
		
	}
	
	
	public class ToComboBoxListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			JComboBox<String> comboBox = (JComboBox<String>) e.getSource();
			String year = (String) comboBox.getSelectedItem();
			mainModel.setToSelectionYear(year);
			
		}
		
	}

}

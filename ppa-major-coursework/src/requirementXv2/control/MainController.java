package requirementXv2.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;

import requirementXv2.model.MainModel;
import requirementXv2.model.MapModel;
import requirementXv2.model.StatsModel;
import requirementXv2.model.WelcomeModel;
import requirementXv2.view.StatesFrame;

public class MainController {
	
	// Models
	private MainModel mainModel;
	private WelcomeModel welcomeModel;
	private MapModel mapModel;
	private StatsModel statsModel;

	
		
	
	/**
	 * Sets all models required for the main controller.
	 * @param mainModel Model for main frame.
	 * @param welcomeModel Model for welcome panel.
	 * @param mapModel Model for Map panel.
	 * @param statsModel Model for Stats panel.
	 */
	public MainController(MainModel mainModel, WelcomeModel welcomeModel, MapModel mapModel, StatsModel statsModel) {
		
		this.mainModel = mainModel;
		this.welcomeModel = welcomeModel;
		this.mapModel = mapModel;
		this.statsModel = statsModel;
	
		
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
			
			long start;
			long end;
			long time;
			
			String year = getSelectedItem(e);
			start = System.currentTimeMillis();
			mainModel.setFromSelectionYear(year);
			
			if (mainModel.isDateValid()) {
				
				try {
					
					mapModel.updateStates();
					mainModel.setDataReady();
					statsModel.updateStats();
					
				} catch (IOException e1) {
					
					e1.printStackTrace();
					
				}
				
				end = System.currentTimeMillis();
				time = end - start;
				welcomeModel.setDataGrabTime(time);
				
			} 
			
		}
		
	}
	
	
	public class ToComboBoxListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			long start;
			long end;
			long time;

			String year = getSelectedItem(e);
			start = System.currentTimeMillis();
			mainModel.setToSelectionYear(year);
			
			if (mainModel.isDateValid()) {
				
				try {
					
					mapModel.updateStates();
					mainModel.setDataReady();
					statsModel.updateStats();
					
				} catch (IOException e1) {
	
					e1.printStackTrace();
					
				}
				
				end = System.currentTimeMillis();
				time = end - start;
				welcomeModel.setDataGrabTime(time);
				
				
			}
			
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

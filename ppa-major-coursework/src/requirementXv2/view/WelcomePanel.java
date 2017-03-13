package requirementXv2.view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import requirementXv2.model.MainModel;
import requirementXv2.model.WelcomeModel;

public class WelcomePanel extends JPanel{
	
	// Models
	private MainModel mainModel;
	private WelcomeModel welcomeModel;
	
	// Data
	private JLabel mainLabel;

	/** Constructor **/
	
	public WelcomePanel(MainModel mainModel, WelcomeModel welcomeModel) {
		
		this.mainModel = mainModel;
		this.welcomeModel = welcomeModel;
		initWidgets();
		
	}
	
	
	/** Setting up widgets **/
	
	public void initWidgets() {
		
		setLayout(new GridLayout(1, 1));
		mainLabel = new JLabel();
		mainLabel.setHorizontalAlignment(JLabel.CENTER);
		mainLabel.setVerticalAlignment(JLabel.CENTER);
		add(mainLabel);	
		updateLabel();
		
	}
	
	
	
	/** Updating views **/
	
	public void updateLabel() {
		
		String text; 
		
		text = "This is test text";
		
		mainLabel.setText("<html><center>" + text + "</center></html>");
		
	}
	

}

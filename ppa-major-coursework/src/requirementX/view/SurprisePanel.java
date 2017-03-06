package requirementX.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import requirementX.model.MainModel;

public class SurprisePanel extends JPanel {
	
	private MainModel mainModel;
	
	public SurprisePanel(MainModel mainModel) {
		
		this.mainModel = mainModel;
		initWidgets();
		
	}
	
	
	
	public void initWidgets() {
		
		setLayout(new GridLayout(1, 1));
		setBackground(Color.YELLOW);
		
	}

}

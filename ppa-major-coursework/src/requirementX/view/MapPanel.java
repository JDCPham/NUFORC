package requirementX.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import requirementX.model.MainModel;
import requirementX.model.MapModel;

public class MapPanel extends JPanel {
	
	private MainModel mainModel;
	private MapModel mapModel;
	
	public MapPanel(MainModel mainModel, MapModel mapModel) {
		
		this.mainModel = mainModel;
		this.mapModel = mapModel;
		initWidgets();
		
	}
	
	
	
	public void initWidgets() {
		
		setLayout(new GridLayout(1, 1));
		setBackground(Color.BLUE);
		
	}

}

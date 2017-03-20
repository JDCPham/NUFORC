package requirementXv2.view;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import requirementXv2.model.MainModel;
import requirementXv2.model.StatsModel;

public class StatsPanel extends JPanel implements Observer{

	// Models
	private MainModel mainModel;
	private StatsModel statsModel;
	
	// Panels
	private StatsBox topLeftContainer;
	private StatsBox topRightContainer;
	private StatsBox bottomLeftContainer;
	private StatsBox bottomRightContainer;

	// Background image
	private BufferedImage background;


	/** Constructor **/

	public StatsPanel(MainModel mainModel, StatsModel statsModel) {

		this.mainModel = mainModel;
		this.statsModel = statsModel;
		statsModel.addObserver(this);
		mainModel.addObserver(this);
		initWidgets();

	}


	/** Creating widgets **/

	public void initWidgets() {

		// Set Layout of panel
		setLayout(new GridLayout(2, 2));
		
		// Create container panels
		topLeftContainer = new StatsBox(statsModel, "Top Left");
		topRightContainer = new StatsBox(statsModel, "Top Right");
		bottomLeftContainer = new StatsBox(statsModel, "Bottom Left");
		bottomRightContainer = new StatsBox(statsModel, "Bottom Right");
	
		// Add containers to panel
		add(topLeftContainer);
		add(topRightContainer);
		add(bottomLeftContainer);
		add(bottomRightContainer);
		
		setVisible(true);
		

	}


	@Override
	public void update(Observable o, Object arg) {
		
	}

}

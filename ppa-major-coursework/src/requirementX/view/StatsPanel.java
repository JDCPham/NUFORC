package requirementX.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import requirementX.model.MainModel;
import requirementX.model.StatsModel;

public class StatsPanel extends JPanel {

	private MainModel mainModel;
	private StatsModel statsModel;

	public StatsPanel(MainModel mainModel, StatsModel statsPanel) {

		this.mainModel = mainModel;
		this.statsModel = statsModel;
		initWidgets();

	}


	public void initWidgets() {

		setLayout(new GridLayout(1, 1));
		setBackground(Color.GREEN);

	}

}

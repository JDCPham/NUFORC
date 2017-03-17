package requirementXv2.model;

import java.util.ArrayList;
import java.util.Observable;

import api.ripley.Incident;

public class StatsModel extends Observable {

	// Main Model
	private MainModel mainModel;
	private MapModel mapModel;

	// Statistics
	private Statistic[] stats;

	// Current
	private int topLeft;
	private int topRight;
	private int bottomLeft;
	private int bottomRight;

	// Incidents
	private ArrayList<Incident> incidents;

	/** Constructor **/

	public StatsModel(MainModel mainModel, MapModel mapModel) {

		this.mainModel = mainModel;
		this.mapModel = mapModel;

		topLeft = 0;
		topRight = 1;
		bottomLeft = 2;
		bottomRight = 3;

		initStats();

	}


	public void initStats() {

		stats = new Statistic[4];

		stats[0] = new Statistic();
		stats[1] = new Statistic();
		stats[2] = new Statistic();
		stats[3] = new Statistic();

	}


	public Statistic getStat(String position) {

		if (position.equals("Top Left")) return stats[topLeft];

		else if (position.equals("Top Right")) return stats[topRight];

		else if (position.equals("Bottom Left")) return stats[bottomLeft];

		else return stats[bottomRight];

	}



}

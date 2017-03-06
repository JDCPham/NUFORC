package requirementX.model;

import java.util.Observable;

import api.ripley.Ripley;

public class StatsModel extends Observable {
	
	Ripley ripley;
	
	public StatsModel(Ripley ripley) {
		
		this.ripley = ripley;
		
	}

}

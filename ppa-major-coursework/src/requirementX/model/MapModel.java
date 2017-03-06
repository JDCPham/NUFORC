package requirementX.model;

import java.util.Observable;

import api.ripley.Ripley;

public class MapModel extends Observable {
	
	Ripley ripley;
	
	public MapModel(Ripley ripley) {
		
		this.ripley = ripley;
		
	}

}

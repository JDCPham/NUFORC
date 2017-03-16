package requirementXv2.model;

import java.util.Comparator;

public class DurationComparator implements Comparator<Sighting> {
	
	@Override
	public int compare(Sighting o1, Sighting o2) {
		
		int o1Duration = o1.getDuration();
		int o2Duration = o2.getDuration();
		
		return o1Duration - o2Duration;
		
	}

}

package requirementXv2.model;

import java.util.Comparator;
import java.util.Date;

public class PostedComparator implements Comparator<Sighting> {
	
	@Override
	public int compare(Sighting o1, Sighting o2) {
		
		Date o1Posted = o1.getPosted();
		Date o2Posted = o2.getPosted();
		
		return o1Posted.compareTo(o2Posted);
			
	}

}

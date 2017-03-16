package requirementXv2.model;

import java.util.Comparator;
import java.util.Date;

public class DateComparator implements Comparator<Sighting>{

	@Override
	public int compare(Sighting o1, Sighting o2) {
		
		Date o1Date = o1.getDate();
		Date o2Date = o2.getDate();
		
		return o1Date.compareTo(o2Date);
			
	}

}

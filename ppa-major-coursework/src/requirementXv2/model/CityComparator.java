package requirementXv2.model;

import java.util.Comparator;

public class CityComparator implements Comparator<Sighting> {

	@Override
	public int compare(Sighting o1, Sighting o2) {
		
		String o1City = o1.getCity();
		String o2City = o2.getCity();
		
		return o1City.compareTo(o2City);
		
	}

}

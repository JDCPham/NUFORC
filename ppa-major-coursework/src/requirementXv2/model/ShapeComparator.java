package requirementXv2.model;

import java.util.Comparator;

public class ShapeComparator implements Comparator<Sighting>{

	@Override
	public int compare(Sighting o1, Sighting o2) {
		
		String o1Shape = o1.getShape();
		String o2Shape = o2.getShape();
		
		return o1Shape.compareTo(o2Shape);
		
	}
	
}

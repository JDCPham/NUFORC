package requirementXv2.model;

import java.util.Comparator;
import java.util.Date;

public class CustomComparators {



	public class DateComparator implements Comparator<Sighting> {

		@Override
		public int compare(Sighting o1, Sighting o2) {

			Date o1Date = o1.getDate();
			Date o2Date = o2.getDate();

			return o1Date.compareTo(o2Date);

		}

	}



	public class DurationComparator implements Comparator<Sighting> {

		@Override
		public int compare(Sighting o1, Sighting o2) {

			int o1Duration = o1.getDuration();
			int o2Duration = o2.getDuration();

			return o1Duration - o2Duration;

		}

	}
	
	
	public class CityComparator implements Comparator<Sighting> {

		@Override
		public int compare(Sighting o1, Sighting o2) {
			
			String o1City = o1.getCity();
			String o2City = o2.getCity();
			
			return o1City.compareTo(o2City);
			
		}

	}
	
	
	public class PostedComparator implements Comparator<Sighting> {
		
		@Override
		public int compare(Sighting o1, Sighting o2) {
			
			Date o1Posted = o1.getPosted();
			Date o2Posted = o2.getPosted();
			
			return o1Posted.compareTo(o2Posted);
				
		}

	}
	
	
	public class ShapeComparator implements Comparator<Sighting>{

		@Override
		public int compare(Sighting o1, Sighting o2) {
			
			String o1Shape = o1.getShape();
			String o2Shape = o2.getShape();
			
			return o1Shape.compareTo(o2Shape);
			
		}
		
	}

}




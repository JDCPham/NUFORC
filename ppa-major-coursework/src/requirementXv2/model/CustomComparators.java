// Package
package requirementXv2.model;

// Import
import java.util.Comparator;
import java.util.Date;

public class CustomComparators {


	/**
	 * A comparator for a date.
	 * Returns -1 if date is less, 0 if equal, and 1 if greater than current date.
	 * @author JP
	 *
	 */
	public class DateComparator implements Comparator<Sighting> {

		@Override
		public int compare(Sighting o1, Sighting o2) {

			Date o1Date = o1.getDate();
			Date o2Date = o2.getDate();

			return o1Date.compareTo(o2Date);

		}

	}



	/**
	 * A comparator for a duration.
	 * Returns -1 if duration is less, 0 if equal, and 1 if greater than current duration.
	 * @author JP
	 *
	 */
	public class DurationComparator implements Comparator<Sighting> {

		@Override
		public int compare(Sighting o1, Sighting o2) {

			int o1Duration = o1.getDuration();
			int o2Duration = o2.getDuration();

			return o1Duration - o2Duration;

		}

	}
	
	
	
	/**
	 * A comparator for a city. (Alphabetical)
	 * Returns -1 if city name is before, 0 if equal, and 1 if after than current city name.
	 * @author JP
	 *
	 */
	public class CityComparator implements Comparator<Sighting> {

		@Override
		public int compare(Sighting o1, Sighting o2) {
			
			String o1City = o1.getCity();
			String o2City = o2.getCity();
			
			return o1City.compareTo(o2City);
			
		}

	}
	
	
	
	/**
	 * A comparator for a posted date..
	 * Returns -1 if date is less, 0 if equal, and 1 if greater than current date.
	 * @author JP
	 *
	 */
	public class PostedComparator implements Comparator<Sighting> {
		
		@Override
		public int compare(Sighting o1, Sighting o2) {
			
			Date o1Posted = o1.getPosted();
			Date o2Posted = o2.getPosted();
			
			return o1Posted.compareTo(o2Posted);
				
		}

	}
	
	
	
	/**
	 * A comparator for a shape. (Alphabetical)
	 * Returns -1 if string is before, 0 if equal, and 1 if after than current shape string.
	 * @author JP
	 *
	 */
	public class ShapeComparator implements Comparator<Sighting>{

		@Override
		public int compare(Sighting o1, Sighting o2) {
			
			String o1Shape = o1.getShape();
			String o2Shape = o2.getShape();
			
			return o1Shape.compareTo(o2Shape);
			
		}
		
	}

}




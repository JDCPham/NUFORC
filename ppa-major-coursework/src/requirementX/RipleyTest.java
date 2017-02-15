// Package
package requirementX;

// Imports
import api.ripley.Ripley;

public class RipleyTest {

	public static void main(String[] args) {
		
		// New ripley object, includes private and public keys
		Ripley ripley = new Ripley("10tLI3CWstqyVD6ql2OMtA==", "tBgm4pRo9grVqL46EnH7ew==");
		
		// Call getLastUpdated method from ripley object and print to console
		System.out.println(ripley.getLastUpdated());
		

	}

}

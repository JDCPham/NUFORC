package requirementX;

import api.ripley.Incident;
import api.ripley.Ripley;
import java.util.ArrayList;

import com.joestelmach.natty.*;

public class TestOne {

	public static void main(String[] args) {
		Ripley ripley = new Ripley("10tLI3CWstqyVD6ql2OMtA==", "tBgm4pRo9grVqL46EnH7ew==");
		Parser parser = new Parser();
		ArrayList<Incident> s = ripley.getIncidentsInRange("2016-12-12 00:00:00", "2017-01-01 00:00:00");
		
		for (Incident ss: s){
			
			System.out.println(ss.getState());
		}

	}

}

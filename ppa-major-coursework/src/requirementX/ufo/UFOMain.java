package requirementX.ufo;

import java.util.ArrayList;

import javax.swing.JPanel;

import requirementX.ufo.model.UFOModel;
import requirementX.ufo.view.UFOFrame;
import requirementX.ufo.view.UFOMap;
import requirementX.ufo.view.UFOStat;
import requirementX.ufo.view.UFOWelcome;

public class UFOMain {

	public static void main(String[] args) {
		
		// Create model
		UFOModel ufoModel = new UFOModel();
		
		// New frame
		new UFOFrame(ufoModel, initViews(ufoModel)).setVisible(true);
		
	}
	
	public static ArrayList<JPanel> initViews(UFOModel ufoModel){
		
		// Create views
		JPanel panelOne = new UFOWelcome(ufoModel);
		JPanel panelTwo = new UFOMap(ufoModel);
		JPanel panelThree = new UFOStat(ufoModel);
		JPanel panelFour = new UFOStat(ufoModel);
				
		// Add to new arraylist
		ArrayList<JPanel> views = new ArrayList<JPanel>();
		views.add(panelOne);
		views.add(panelTwo);
		views.add(panelThree);
		views.add(panelFour);

		return views;
		
	}

}

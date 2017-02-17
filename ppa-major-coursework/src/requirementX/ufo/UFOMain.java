package requirementX.ufo;

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
		new UFOFrame(ufoModel).setVisible(true);
		
	}

}

package requirementX.ufo;

import requirementX.ufo.model.UFO;
import requirementX.ufo.view.UFOFrame;

public class UFOMain {

	public static void main(String[] args) {
		
		UFO ufo = new UFO();
		new UFOFrame(ufo).setVisible(true);
		
	}

}

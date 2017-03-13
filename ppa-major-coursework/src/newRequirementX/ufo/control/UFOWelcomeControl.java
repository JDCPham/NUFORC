package newRequirementX.ufo.control;

import javax.swing.JPanel;

import newRequirementX.ufo.model.UFOMainModel;
import newRequirementX.ufo.model.UFOWelcomeModel;
import newRequirementX.ufo.view.UFOWelcomePanel;

public class UFOWelcomeControl {
	
	private UFOMainModel mainModel;
	
	private UFOWelcomeModel welcomeModel;
	
	public UFOWelcomeControl(UFOMainModel mainModel){
		this.mainModel = mainModel;
		welcomeModel = new UFOWelcomeModel(mainModel);
	}
	
	public JPanel newPanel(){
		return new UFOWelcomePanel(welcomeModel, mainModel);
	}

}

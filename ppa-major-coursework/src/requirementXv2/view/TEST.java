package requirementXv2.view;

import requirementXv2.control.SurprisePanelController;
import requirementXv2.model.SurprisePanelModel;

public class TEST {

	public static void main (String [] args) {
		SurprisePanel panel = new SurprisePanel();
		SurprisePanelModel model = new SurprisePanelModel();
		SurprisePanelController controller = new SurprisePanelController(panel,model);
	}
}

package requirementX.ufo.view;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import requirementX.ufo.model.UFOModel;

public class UFOStat extends JPanel implements Observer{

	UFOModel ufoModel;
	
	public UFOStat(UFOModel ufoModel){
		
		this.ufoModel = ufoModel;
		ufoModel.addObserver(this);
		
		initWidgets();
		
	}
	
	public void initWidgets(){
		setBackground(Color.BLACK);
	}
	

	@Override
	public void update(Observable o, Object arg) {
			
	}

}

package requirementX.ufo.view;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import requirementX.ufo.model.UFOModel;

public class UFOMap extends JPanel implements Observer{

	UFOModel ufoModel;
	
	public UFOMap(UFOModel ufoModel){
		
		this.ufoModel = ufoModel;
		ufoModel.addObserver(this);
		
		initWidgets();
		updateLabel();
		
	}
	
	public void initWidgets(){
		setBackground(Color.BLACK);
	}
	
	public void updateLabel(){
		
		
	}

	@Override
	public void update(Observable o, Object arg) {
		updateLabel();	
	}

}

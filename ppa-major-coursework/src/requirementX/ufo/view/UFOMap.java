package requirementX.ufo.view;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import requirementX.ufo.model.UFOModel;

public class UFOMap extends JPanel{

	UFOModel ufoModel;
	
	public UFOMap(UFOModel ufoModel){
		
		this.ufoModel = ufoModel;
		initWidgets();
		
	}
	
	public void initWidgets(){
		setBackground(Color.YELLOW);
		JLabel labelA = new JLabel("Hello");
		add(labelA);
		setVisible(true);
	}
	


}

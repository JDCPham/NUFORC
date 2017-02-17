package requirementX.ufo.view;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import requirementX.ufo.model.UFOModel;

public class UFOStat extends JPanel{

	UFOModel ufoModel;
	
	public UFOStat(UFOModel ufoModel){
		
		this.ufoModel = ufoModel;
		initWidgets();
		
	}
	
	public void initWidgets(){
		setBackground(Color.BLUE);
		JLabel labelA = new JLabel("PANEL3");
		add(labelA);
		setVisible(true);
	}
	

}

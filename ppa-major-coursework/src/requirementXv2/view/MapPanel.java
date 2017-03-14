package requirementXv2.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.TreeMap;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import requirementXv2.model.MainModel;
import requirementXv2.model.MapModel;

public class MapPanel extends JPanel implements Observer {

	// Models
	private MainModel mainModel;
	private MapModel mapModel;
	
	// Background image
	private BufferedImage background;


	/** Constructor **/

	public MapPanel(MainModel mainModel, MapModel mapModel) {

		this.mainModel = mainModel;
		this.mapModel = mapModel;
		mapModel.addObserver(this);
		mainModel.addObserver(this);
		initWidgets();

	}
	
	
	/** Creating widgets **/
	
	public void initWidgets() {
		
		setBackgroundImage("resources/map.png");
		setLayout(null);
		setVisible(true);
		
	}
	
	
	/** Alien heads **/
	
	public void placeIcons() {
		
		removeAll();
		TreeMap<String, Integer> states = mapModel.getStateCount();
		Set<String> statesIterable = mapModel.getStatesIterable();
		
		for (String currentState: statesIterable) {
			
			if (states.get(currentState) <= 200) addIcon(1, currentState);
			else if ((states.get(currentState) > 200) && (states.get(currentState) <= 400)) addIcon(2, currentState);
			else addIcon(3, currentState);
				
		}
		
		revalidate();
		repaint();
			
	}
		

	
	
	
	/** Useful **/
	
	public void setBackgroundImage(String path) {
		
		try { background = ImageIO.read(new File(path)); } 
		catch (IOException e) { e.printStackTrace(); }
				
	}
	
	
	public void addIcon(int size, String location) {
		
		AlienIcon icon = new AlienIcon(size, location, mapModel);
		if (location.equals("CA")) icon.setBounds(110, 260, 50, 50); 
		else if (location.equals("AZ")) icon.setBounds(200, 260, 50, 50); 
		else if (location.equals("FL")) icon.setBounds(630, 380, 50, 50);
		else if (location.equals("UT")) icon.setBounds(230, 220, 50, 50); 
		else if (location.equals("NV")) icon.setBounds(160, 180, 50, 50); 
		else if (location.equals("TX")) icon.setBounds(400, 370, 50, 50); 
		else if (location.equals("NM")) icon.setBounds(260, 270, 50, 50); 
		else if (location.equals("CO")) icon.setBounds(270, 200, 50, 50); 
		else if (location.equals("WY")) icon.setBounds(270, 160, 50, 50); 
		else if (location.equals("OR")) icon.setBounds(110, 90, 50, 50); 
		else if (location.equals("WA")) icon.setBounds(110, 40, 50, 50); 
		else if (location.equals("ID")) icon.setBounds(180, 120, 50, 50); 
		else if (location.equals("MT")) icon.setBounds(280, 90, 50, 50); 
		
		add(icon);
		
	}
	
	
	
	/** Other **/
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.drawImage(background, 0, 0, this);
		
	}


	@Override
	public void update(Observable o, Object arg) {

		if (arg.equals("State Data Updated")) placeIcons();
		System.out.println("hi");
	}

	
}




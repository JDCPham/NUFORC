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
		
		TreeMap<String, Integer> states; 
		Set<String> statesIterable;
		double sizeFive;
		double sizeFour;
		double sizeThree;
		double sizeTwo;
		double sizeOne;
		
		states = mapModel.getStateCount();
		statesIterable = mapModel.getStatesIterable();
		
		sizeFive = mostSightings(statesIterable, states);
		sizeFour = (sizeFive * 0.8);
		sizeThree = sizeFive / 2;
		sizeTwo = (sizeFive * 0.4);
		sizeOne = (sizeFive * 0.2);
		
		for (String currentState: statesIterable) {
			
			if (states.get(currentState) >= sizeFive) {
				
				addIcon(5, currentState);
				
			} else if ((states.get(currentState) >= sizeFour) && (states.get(currentState) < sizeFive)) {
				
				addIcon(4, currentState);
				
			} else if ((states.get(currentState) >= sizeThree) && (states.get(currentState) < sizeFour)) {
				
				addIcon(3, currentState);
				
			} else if ((states.get(currentState) >= sizeTwo) && (states.get(currentState) < sizeThree)) {
				
				addIcon(2, currentState);
				
			} else {
				
				addIcon(1, currentState);
				
			}
				
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
		else if (location.equals("ND")) icon.setBounds(376, 88, 50, 50); 
		else if (location.equals("SD")) icon.setBounds(377, 136, 50, 50); 
		else if (location.equals("NE")) icon.setBounds(380, 190, 50, 50); 
		else if (location.equals("KS")) icon.setBounds(398, 245, 50, 50); 
		else if (location.equals("OK")) icon.setBounds(413, 297, 50, 50);
		else if (location.equals("MN")) icon.setBounds(444, 107, 50, 50); 
		else if (location.equals("IA")) icon.setBounds(463, 182, 50, 50);
		
		else if (location.equals("MO")) icon.setBounds(474, 244, 50, 50);
		else if (location.equals("AR")) icon.setBounds(480, 305, 50, 50); 
		else if (location.equals("LA")) icon.setBounds(481, 362, 50, 50); 
		else if (location.equals("MS")) icon.setBounds(523, 348, 50, 50);
		else if (location.equals("IL")) icon.setBounds(519, 216, 50, 50); 
		else if (location.equals("WI")) icon.setBounds(504, 137, 50, 50); 
		else if (location.equals("TN")) icon.setBounds(563, 283, 50, 50); 
		else if (location.equals("AL")) icon.setBounds(566, 338, 50, 50); 
		else if (location.equals("KY")) icon.setBounds(585, 248, 50, 50); 
		else if (location.equals("IN")) icon.setBounds(556, 212, 50, 50);
		
		else if (location.equals("MI")) icon.setBounds(572, 150, 50, 50); 
		else if (location.equals("OH")) icon.setBounds(602, 197, 50, 50); 
		else if (location.equals("GA")) icon.setBounds(611, 333, 50, 50); 
		else if (location.equals("SC")) icon.setBounds(644, 302, 50, 50); 
		else if (location.equals("NC")) icon.setBounds(651, 274, 50, 50); 
		else if (location.equals("VA")) icon.setBounds(665, 235, 50, 50); 
		else if (location.equals("WV")) icon.setBounds(631, 226, 50, 50);
		else if (location.equals("PA")) icon.setBounds(667, 178, 50, 50); 
		else if (location.equals("NY")) icon.setBounds(691, 130, 50, 50); 
		else if (location.equals("WA")) icon.setBounds(682, 205, 50, 50);
		
		else if (location.equals("MD")) icon.setBounds(703, 218, 50, 50); 
		else if (location.equals("DE")) icon.setBounds(700, 207, 50, 50);
		else if (location.equals("NJ")) icon.setBounds(709, 184, 50, 50); 
		else if (location.equals("CT")) icon.setBounds(726, 152, 50, 50); 
		else if (location.equals("RI")) icon.setBounds(739, 149, 50, 50); 
		else if (location.equals("MA")) icon.setBounds(732, 138, 50, 50); 
		else if (location.equals("ME")) icon.setBounds(752, 78, 50, 50); 
		else if (location.equals("NH")) icon.setBounds(731, 114, 50, 50); 
		else if (location.equals("VT")) icon.setBounds(717, 109, 50, 50); 
		
		add(icon);
		
	}
	
	
	public double mostSightings(Set<String> states, TreeMap<String, Integer> sightings) {
		
		int current;
		int max;
		
		if (sightings.isEmpty()) return 0;
		
		max = sightings.firstEntry().getValue();
		
		for (String s: states) {
			
			current = sightings.get(s);
			
			if (current > max) max = current;
				
		}	
		
		return max;
	}
	
	
	
	/** Other **/
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.drawImage(background, 0, 0, this);
		
	}


	@Override
	public void update(Observable o, Object arg) {

		if (arg.equals("State Data Updated")) placeIcons();
		
	}

	
}




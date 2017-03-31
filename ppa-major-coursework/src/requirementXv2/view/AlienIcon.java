// Package
package requirementXv2.view;

// Imports
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import requirementXv2.control.MapController;
import requirementXv2.model.MapModel;

public class AlienIcon extends JPanel {

	// Fields
	private BufferedImage background;
	private MapModel mapModel;
	private JButton button;
	private String state;

	
	
	/**
	 * Constructor method.
	 * Sets the state of the alien icon.
	 * Sets the map model.
	 * Initialises the widget by paining the alien icon, and setting the button.
	 * @param size The size of the alien icon from 1 to 5.
	 * @param state The state the alien icon is stored.
	 * @param mapModel The map model.
	 */
	public AlienIcon(int size, String state, MapModel mapModel) {

		this.state = state;
		this.mapModel = mapModel;
		initWidgets(size);

	}


	
	/**
	 * Initialises the widgets for the GUI of the Alien Icon.
	 * @param size Size of alien icon from 1 to 5.
	 */
	public void initWidgets(int size) {

		// Layout and Properties
		setLayout(new GridLayout(1, 1));
		setOpaque(false);
		setBackgroundImage("resources/alien-"+ size +".png");
		
		// Create buttons
		button = new JButton();
		button.setName(state);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.addActionListener(new MapController(mapModel).new AlienIconListener());
		add(button);

	}


	/**
	 * Sets the background image.
	 * @param path The string in which the path of the image is stored.
	 */
	public void setBackgroundImage(String path) {

		try {

			background = ImageIO.read(new File(path));

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	
	/**
	 * Paints the background with supplied image.
	 */
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(background, 0, 0, this);

	}

}
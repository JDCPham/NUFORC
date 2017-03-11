package requirementXv2.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class AlienIcon extends JPanel {

	private BufferedImage background;


	/** Constructor **/

	public AlienIcon(int size) {

		initWidgets(size);

	}


	public void initWidgets(int size) {

		setOpaque(false);
		setBackgroundImage("resources/alien-"+ size +".png");

	}



	/** Useful **/

	public void setBackgroundImage(String path) {

		try {

			background = ImageIO.read(new File(path));

		} catch (IOException e) {

			e.printStackTrace();

		}

	}


	/** Other **/

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(background, 0, 0, this);

	}

}
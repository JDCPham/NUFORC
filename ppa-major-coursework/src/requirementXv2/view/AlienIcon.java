package requirementXv2.view;

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

	private BufferedImage background;
	private MapModel mapModel;
	private JButton button;
	private String state;

	/** Constructor **/

	public AlienIcon(int size, String state, MapModel mapModel) {

		this.state = state;
		this.mapModel = mapModel;
		initWidgets(size);

	}


	public void initWidgets(int size) {

		setLayout(new GridLayout(1, 1));
		setOpaque(false);
		setBackgroundImage("resources/alien-"+ size +".png");
		
		button = new JButton();
		button.setName(state);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.addActionListener(new MapController(mapModel).new AlienIconListener());
		add(button);

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
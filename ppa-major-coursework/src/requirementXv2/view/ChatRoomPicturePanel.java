package requirementXv2.view;

import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ChatRoomPicturePanel extends JPanel {

	private BufferedImage image;
	
	/**
	 * Constructor for when you wish to specify the layout manager of the image.
	 * @param path - set the URL of the image source location.
	 * @param layout - set the layout of this image.
	 */
	public ChatRoomPicturePanel(String path, LayoutManager layout) {
		
		// Assign the image
		this(path);
		// Assign the layout
		setLayout(layout);
	}

	public ChatRoomPicturePanel(String path) {

		try {

			this.image = ImageIO.read(new File(path));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	protected void paintComponent(Graphics g) {
		// Call the super JPanel paint.
		super.paintComponent(g);
		
		// Assign the image to the graphic of this JPanel and set this to be the listener.
		g.drawImage(image, 0, 0, this);
	}
}

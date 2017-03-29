package requirementXv2.view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	private static final long serialVersionUID = 1L;	//Creating fields
	private BufferedImage image;
	private JPanel emptyPanel1;
	private JPanel emptyPanel2;

	/*
	 * converts url into image
	 */
	public ImagePanel(String url) {	

		try {
			image = ImageIO.read(new File(url));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * paints image onto this panel
	 */
	public void paintComponent(Graphics graphic) {
		super.paintComponent(graphic);
		graphic.drawImage(image, 0, 0, this);
	}

}

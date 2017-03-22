package requirementXv2.view;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class EscapePicturePanel extends JPanel {
	
	private BufferedImage image;

	public EscapePicturePanel(String path)
	{
		
		setPreferredSize(new Dimension(200, 50));
		try {
			
			this.image = ImageIO.read(new File(path));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		setOpaque(false);
	}
	
	protected void paintComponent(Graphics g)
	{
	    g.drawImage(image, 0, 0, this);
	}
}

package requirementXv2.view;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ChatRoomPicturePanel extends JPanel {
	
	private BufferedImage image;

	public ChatRoomPicturePanel(String path)
	{
		
		try {
			
			this.image = ImageIO.read(new File(path));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	protected void paintComponent(Graphics g)
	{
	    g.drawImage(image, 0, 0, this);
	}
}

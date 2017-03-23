package requirementXv2.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SurprisePanel {

	public static void main (String [] args) {
		JFrame frame = new JFrame("Surprise Panel");
		frame.setLayout(new BorderLayout());
		
		JPanel southPanel = new JPanel();
		JButton leftButton = new JButton("left");
		JButton leftMiddleButton = new JButton("leftMiddle");
		JButton rightMiddleButton = new JButton("rightMiddle");
		JButton rightButton = new JButton("right");
		
		southPanel.setLayout(new FlowLayout());
		southPanel.add(leftButton);
		southPanel.add(leftMiddleButton);
		southPanel.add(rightMiddleButton);
		southPanel.add(rightButton);
		frame.add(southPanel, BorderLayout.SOUTH);
		
		ImagePanel roger = new ImagePanel("Images/female alien.jpg");
		roger.setPreferredSize(new Dimension(300, 200));
		roger.setOpaque(false);
		frame.add(roger);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,300);
		frame.setVisible(true);
		
	}
}

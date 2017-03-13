package requirementX;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

import api.ripley.Ripley;

import javax.swing.JButton;

public class PanelOne {
	
	public static void main(String[] args) {
		
		// Instantiate an object of Ripley
		Ripley ripley = new Ripley("10tLI3CWstqyVD6ql2OMtA==", "tBgm4pRo9grVqL46EnH7ew==");
		
		// Create new main frame
		JFrame mainFrame = new JFrame("UFO");
		mainFrame.setSize(500, 500);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(new BorderLayout());
		
		// Create new top panel
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		
		// Create new top right panel
		JPanel topRightPanel = new JPanel();
		topRightPanel.setLayout(new GridLayout(1, 4));
		
		// Create new bottom panel
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BorderLayout());
		
		// Create widgets
		JLabel fromLabel = new JLabel("From: ");
		JLabel toLabel = new JLabel("To: ");
		JSpinner fromSpinner = new JSpinner();
		JSpinner toSpinner = new JSpinner();
		JTextArea mainTextArea = new JTextArea();
		JScrollPane mainScrollPane = new JScrollPane(mainTextArea);
		JButton rightButton = new JButton(">");
		JButton leftButton = new JButton("<");
		JLabel bottomTextArea = new JLabel();
		
		// New Colour
		Color defaultColour = new Color(236, 236, 236, 100);
		
		// Widget settings
		mainTextArea.setEditable(false);
		mainTextArea.setLineWrap(true);
		bottomTextArea.setHorizontalAlignment(JLabel.CENTER);
		mainTextArea.setBackground(defaultColour);
		
		// Add test text to bottom text area
		bottomTextArea.setText(ripley.getLastUpdated());
		
		// Add to Top Right Panel
		topRightPanel.add(fromLabel);
		topRightPanel.add(fromSpinner);
		topRightPanel.add(toLabel);
		topRightPanel.add(toSpinner);
		
		// Add to centre
		mainFrame.add(mainScrollPane, BorderLayout.CENTER);
		
		// Add to bottom Panel
		bottomPanel.add(leftButton, BorderLayout.WEST);
		bottomPanel.add(bottomTextArea, BorderLayout.CENTER);
		bottomPanel.add(rightButton,BorderLayout.EAST);
		
		// Add top right panel to top panel
		topPanel.add(topRightPanel, BorderLayout.EAST);
		
		// Add top panel to frame
		mainFrame.add(topPanel, BorderLayout.NORTH);
		
		// Add bottom panel to frame
		mainFrame.add(bottomPanel, BorderLayout.SOUTH);
		
		// Pack frame and set to visible
		mainFrame.pack();
		mainFrame.setVisible(true);			
		
	}

}


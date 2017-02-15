package requirementX;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;

import api.ripley.Ripley;

public class Panel1 {

public static void main(String[] args) {
		
		//Initializing ripley
		Ripley ripley = new Ripley("10tLI3CWstqyVD6ql2OMtA==", "tBgm4pRo9grVqL46EnH7ew==");
		//Creating JFrame
		JFrame firstFrame = new JFrame("");
		firstFrame.setSize(700, 700);
		firstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		//Adding north, center, south panels to first frame
		firstFrame.setLayout(new BorderLayout());	
		JPanel panelNorth = new JPanel();
		JPanel panelCenter = new JPanel();
		JPanel panelSouth = new JPanel();
		firstFrame.add(panelNorth, BorderLayout.NORTH);
		firstFrame.add(panelCenter, BorderLayout.CENTER);
		firstFrame.add(panelSouth, BorderLayout.SOUTH);
		
		JLabel centerLabel = new JLabel("asdknadsa");
		panelCenter.add(centerLabel);
		
		
		//Adding north-east panel
		panelNorth.setLayout(new BorderLayout());
		JPanel panelNorthEast = new JPanel();
		panelNorth.add(panelNorthEast, BorderLayout.EAST);
		
		//Adding south-west panel
		panelSouth.setLayout(new BorderLayout());
		JPanel panelSouthWest = new JPanel();
		panelSouth.add(panelSouthWest, BorderLayout.WEST);
		
		//Adding south-east panel
		JPanel panelSouthEast = new JPanel();
		panelSouth.add(panelSouthEast, BorderLayout.EAST);
		
		//Creating labels
		JLabel labelFrom = new JLabel("From");
		JLabel labelTo = new JLabel("To");
		
		//Creating spinner model
		SpinnerNumberModel modelFrom = new SpinnerNumberModel(1950.0, ripley.getStartYear(), ripley.getLatestYear(), 1.0);
		JSpinner spinnerFrom = new JSpinner(modelFrom);
		SpinnerNumberModel modelTo = new SpinnerNumberModel(1950.0, ripley.getStartYear(), ripley.getLatestYear(), 1.0);
		JSpinner spinnerTo = new JSpinner(modelTo);
		
		// Adding "from" and "to" label and spinner to North-east panel
		panelNorthEast.add(labelFrom);
		panelNorthEast.add(spinnerFrom);
		panelNorthEast.add(labelTo);
		panelNorthEast.add(spinnerTo);
	
		// Creating Buttons and adding buttons to panels
		JButton ButtonSouthWest = new JButton("<");
		JButton ButtonSouthEast = new JButton(">");
		panelSouthWest.add(ButtonSouthWest);
		panelSouthEast.add(ButtonSouthEast);
		
		//Setting a default color for the background
		Color defaultColour = new Color(236, 236, 236, 100);
		
		// Creating label and adding to south panel
		JLabel southTextArea = new JLabel();
		southTextArea.setText(ripley.getLastUpdated());
		southTextArea.setHorizontalAlignment(JLabel.CENTER);
		southTextArea.setBackground(defaultColour);
		panelSouth.add(southTextArea);

		// Creating center text area and adding it to center panel
		JTextArea centerTextArea = new JTextArea();
		JScrollPane centerScrollPane = new JScrollPane(centerTextArea);
		
		firstFrame.setVisible(true);
		
	}
}

//Package
package requirementX;

//Imports
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
		JFrame mainFrame = new JFrame("UFO");
		mainFrame.setSize(700, 700);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(new BorderLayout());	
		
		//Creating Panels
		JPanel panelNorth = new JPanel();
		JPanel panelCenter = new JPanel();
		JPanel panelSouth = new JPanel();
		
		//Add panels to main frame
		mainFrame.add(panelNorth, BorderLayout.NORTH);
		mainFrame.add(panelCenter, BorderLayout.CENTER);
		mainFrame.add(panelSouth, BorderLayout.SOUTH);
		
		//Create centre label and add to centre panel
		JLabel centerLabel = new JLabel("I am a label");
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
		
		mainFrame.setVisible(true);
		
	}
}

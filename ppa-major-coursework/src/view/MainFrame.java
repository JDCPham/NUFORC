package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	
	JComboBox fromComboBox;
	JComboBox toComboBox;

	public UFOMainFrame() {

		super("UFO Application");
		initWidgets();

	}



	public void initWidgets() {

		// Set frame properties and layout
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(700, 400));
		setLayout(new BorderLayout());

		// Create widgets
		JLabel fromLabel = new JLabel("From: ");
		JLabel toLabel = new JLabel("To: ");
		JLabel lastUpdatedLabel = new JLabel("Test Label");
		JButton leftButton = new JButton("<");
		JButton rightButton = new JButton(">");
		fromComboBox = makeComboBox();
		toComboBox = makeComboBox();

		// Set widget properties
		lastUpdatedLabel.setHorizontalAlignment(JLabel.CENTER);

		// Set default values
		fromComboBox.setSelectedItem(" - ");
		toComboBox.setSelectedItem(" - ");

		// Create panels
		JPanel topPanel = new JPanel();
		JPanel bottomPanel = new JPanel();

		// Set panel properties and layout
		topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		bottomPanel.setLayout(new BorderLayout());

		// Add widgets to panels
		topPanel.add(fromLabel);
		topPanel.add(fromComboBox);
		topPanel.add(toLabel);
		topPanel.add(toComboBox);

		bottomPanel.add(leftButton, BorderLayout.WEST);
		bottomPanel.add(lastUpdatedLabel, BorderLayout.CENTER);
		bottomPanel.add(rightButton, BorderLayout.EAST);

		// Add panels to frame
		add(topPanel, BorderLayout.NORTH);
		add(bottomPanel, BorderLayout.SOUTH);

		// Pack
		pack();

	}
	
	
	
	public JComboBox<String> makeComboBox(){

		int noOfYears = 2017 - 1955;
		int currentYear = 1955;
		
		JComboBox<String> comboBox = new JComboBox<String>();

		for (int i = 0; i <= noOfYears; i++){
			comboBox.addItem(Integer.toString(currentYear));
			currentYear++;
		}

		comboBox.addItem(" - ");
		return comboBox;	
		
	}

	
	
}

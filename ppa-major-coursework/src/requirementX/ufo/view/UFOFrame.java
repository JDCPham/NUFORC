package requirementX.ufo.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import api.ripley.Ripley;
import requirementX.ufo.model.UFO;

public class UFOFrame extends JFrame implements Observer{
	
	private Ripley ripley;
	private UFO ufo;
	private JLabel panelOneLabel;
	private JPanel mainPanel;
	
	public UFOFrame(UFO ufo){
		super("UFO");
		ripley = new Ripley("10tLI3CWstqyVD6ql2OMtA==", "tBgm4pRo9grVqL46EnH7ew==");
		
		this.ufo = ufo;
		ufo.addObserver(this);
		initWidgets();
		updateLabel();
	}
	
	public JComboBox<String> makeComboBox(){
		
		JComboBox<String> comboBox = new JComboBox<String>();
		
		int startYear = ripley.getStartYear();
		int latestYear = ripley.getLatestYear();
		
		int noOfYears = latestYear - startYear;
		int currentYear = startYear;
		
		for (int i = 0; i <= noOfYears; i++){
			comboBox.addItem(Integer.toString(currentYear));
			currentYear++;
		}
			
		return comboBox;	
	}
	
	public void initWidgets(){
		
		// New ripley
		Ripley ripley = new Ripley("10tLI3CWstqyVD6ql2OMtA==", "tBgm4pRo9grVqL46EnH7ew==");
		
		// Set frame properties and layout
		setPreferredSize(new Dimension(600, 300));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// Create widgets
		JLabel fromLabel = new JLabel("From: ");
		JLabel toLabel = new JLabel("To: ");
		JLabel lastUpdatedLabel = new JLabel(ripley.getLastUpdated());
		panelOneLabel = new JLabel();
		JComboBox<String> fromComboBox = makeComboBox();
		JComboBox<String> toComboBox = makeComboBox();
		JButton leftButton = new JButton("<");
		JButton rightButton = new JButton(">");
	
		// Set widget properties
		lastUpdatedLabel.setHorizontalAlignment(JLabel.CENTER);
		panelOneLabel.setVerticalAlignment(JLabel.CENTER);
		panelOneLabel.setHorizontalAlignment(JLabel.CENTER);
		leftButton.setEnabled(false);
		rightButton.setEnabled(false);
		
		// Set default values
		fromComboBox.setSelectedItem("2014");
		setFromYear((String)fromComboBox.getSelectedItem());
		toComboBox.setSelectedItem("2017");
		setToYear((String)toComboBox.getSelectedItem());
		
		// Add Action listeners
		fromComboBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setFromYear((String)fromComboBox.getSelectedItem());
			}
		});
		
		toComboBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setToYear((String)toComboBox.getSelectedItem());
			}
		});

		// Create panels
		JPanel topPanel = new JPanel();
		JPanel centrePanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		
		// Set panel properties and layout
		topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		bottomPanel.setLayout(new BorderLayout());
		centrePanel.setLayout(new GridLayout(1, 1));
		
		// Add widgets to panels
		topPanel.add(fromLabel);
		topPanel.add(fromComboBox);
		topPanel.add(toLabel);
		topPanel.add(toComboBox);
		
		bottomPanel.add(leftButton, BorderLayout.WEST);
		bottomPanel.add(lastUpdatedLabel, BorderLayout.CENTER);
		bottomPanel.add(rightButton, BorderLayout.EAST);
		
		centrePanel.add(panelOneLabel);
		
		// Add panels to frame
		add(topPanel, BorderLayout.NORTH);
		add(bottomPanel, BorderLayout.SOUTH);
		add(centrePanel, BorderLayout.CENTER);
		
		// Pack frame
		pack();
	}
	
	public void setFromYear(String year){
		ufo.setFromYear(year);
	}
	
	public void setToYear(String year){
		ufo.setToYear(year);	
	}
	
	private void updateLabel(){
		
		panelOneLabel.setText("<html><center>Welcome to the Ripley API v1.0<br>"
				+ "Please select from the dates above, in order to<br>"
				+ "begin analysing UFO sighting data.<br><br>"
				+ "Date range selected, " + ufo.getFromYear() + " - " + ufo.getToYear() + " <br><br>"
				+ "Grabbing data...<br>"
				+ "Data grabbed in 1 minutes, 17 seconds...<br>"
				+ "<b>Please now interact with this data using the buttons<br>"
				+ "to the left and the right</b></center></html>");
		
		
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		updateLabel();
	}
	

}

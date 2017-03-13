package newRequirementX.ufo.view;

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

import newRequirementX.ufo.model.UFOMainModel;

public class UFOMainFrame extends JFrame implements Observer{
	
	// Fields
	private UFOMainModel mainModel;
	private JPanel mainPanel;
	private JComboBox<String> fromComboBox;
	private JComboBox<String> toComboBox;
	
	public UFOMainFrame(){
		
		// Set window title
		super("Title");
		
		// Create main frame model
		mainModel = new UFOMainModel();
		
		// Add observers
		mainModel.addObserver(this);
		
		// Create GUI
		initWidgets();
		
		// Update panel
		updatePanel();
		
	}



	public void initWidgets(){

		// Set frame properties and layout
		setPreferredSize(new Dimension(700, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// Create widgets
		JLabel fromLabel = new JLabel("From: ");
		JLabel toLabel = new JLabel("To: ");
		JLabel lastUpdatedLabel = new JLabel(mainModel.getLastUpdated());
		fromComboBox = makeComboBox();
		toComboBox = makeComboBox();
		JButton leftButton = new JButton("<");
		JButton rightButton = new JButton(">");

		// Set widget properties
		lastUpdatedLabel.setHorizontalAlignment(JLabel.CENTER);
		leftButton.setEnabled(false);
		rightButton.setEnabled(true);

		// Set default values
		fromComboBox.setSelectedItem(" - ");
		toComboBox.setSelectedItem(" - ");

		// Create panels
		JPanel topPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		mainPanel = new JPanel();
		
		// Add action listeners
		fromComboBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setFromYear();
			}	
		});
		
		toComboBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setToYear();
			}
		});

		// Set panel properties and layout
		topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		bottomPanel.setLayout(new BorderLayout());
		mainPanel.setLayout(new GridLayout(1, 1));

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
		add(mainPanel, BorderLayout.CENTER);

		// Pack frame
		pack();
	}
	
	
	
	
	
	public JComboBox<String> makeComboBox(){

		int noOfYears = mainModel.getLatestYear() - mainModel.getStartYear();
		int currentYear = mainModel.getStartYear();
		
		JComboBox<String> comboBox = new JComboBox<String>();

		for (int i = 0; i <= noOfYears; i++){
			comboBox.addItem(Integer.toString(currentYear));
			currentYear++;
		}

		comboBox.addItem(" - ");
		return comboBox;	
	}
	
	
	public void updatePanel(){
		
		mainPanel.removeAll();
		mainPanel.add(mainModel.getCurrentPanel());
		mainPanel.revalidate();
		mainPanel.repaint();
		
	}
	
	
	/*
	 * Model Setters
	 */
	public void setFromYear(){
		mainModel.setFromYear((String)fromComboBox.getSelectedItem());
		setDateValid();
	}
	
	public void setToYear(){
		mainModel.setToYear((String)toComboBox.getSelectedItem());
		setDateValid();
	}
	
	public void setDateValid(){
		if ((mainModel.getFromYear() <= mainModel.getToYear()) && (mainModel.getFromYear() != 0) 
				&& (mainModel.getToYear() != 0)){
			mainModel.setDateValid(true);
		} else {
			mainModel.setDateValid(false);
		}
	}



	@Override
	public void update(Observable o, Object arg) {
		
		UFOWelcomePanel p = (UFOWelcomePanel) mainModel.getCurrentPanel();
		p.updateLabel();
		
	}







}

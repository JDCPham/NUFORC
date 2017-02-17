package requirementX.ufo.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import api.ripley.Ripley;
import requirementX.ufo.model.UFOModel;

public class UFOFrame extends JFrame implements Observer{
	
	private Ripley ripley;
	private UFOModel ufoModel;
	private ArrayList<JPanel> views;
	private JPanel mainPanel;
	
	public UFOFrame(UFOModel ufoModel, ArrayList<JPanel> views){
		super("UFO");
		ripley = new Ripley("10tLI3CWstqyVD6ql2OMtA==", "tBgm4pRo9grVqL46EnH7ew==");
	
		this.views = views;
		
		this.ufoModel = ufoModel;
		ufoModel.addObserver(this);
		
		initWidgets();
		updatePanel();
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
		JComboBox<String> fromComboBox = makeComboBox();
		JComboBox<String> toComboBox = makeComboBox();
		JButton leftButton = new JButton("<");
		JButton rightButton = new JButton(">");
	
		// Set widget properties
		lastUpdatedLabel.setHorizontalAlignment(JLabel.CENTER);
		leftButton.setEnabled(false);
		rightButton.setEnabled(true);
		
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
		
		fromComboBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setToYear((String)fromComboBox.getSelectedItem());
			}
		});
		
		rightButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				doSetNextPanel();
			}
		});
		
		leftButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			
			}	
		});

		// Create panels
		JPanel topPanel = new JPanel();
		mainPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		
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
		updatePanel();
		
		// Pack frame
		pack();
	}
	
	public JPanel getCurrentPanel(){
		return views.get(ufoModel.getCurrentPanel());
	}
	
	public void setFromYear(String year){
		ufoModel.setFromYear(year);
	}
	
	public void setToYear(String year){
		ufoModel.setToYear(year);	
	}
	
	
	public void doSetNextPanel(){
		ufoModel.setNextPanel(views);
	}
	
	public void updatePanel(){
		mainPanel.removeAll();
		mainPanel.add(getCurrentPanel());
		mainPanel.revalidate();
		mainPanel.repaint();
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		updatePanel();
	}
	

}

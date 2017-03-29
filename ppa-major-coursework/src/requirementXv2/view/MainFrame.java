package requirementXv2.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import requirementXv2.control.MainController;
import requirementXv2.control.SurprisePanelController;
import requirementXv2.model.MainModel;
import requirementXv2.model.MapModel;
import requirementXv2.model.StatsModel;
import requirementXv2.model.SurprisePanelModel;
import requirementXv2.model.WelcomeModel;

public class MainFrame extends JFrame implements Observer {

	// Model
	protected MainModel mainModel;
	private WelcomeModel welcomeModel;
	private MapModel mapModel;
	private StatsModel statsModel;
	

	// Controller
	protected MainController mainController;

	// Widgets
	private JButton leftButton;
	private JButton rightButton;
	private JComboBox<String> fromComboBox;
	private JComboBox<String> toComboBox;

	// Panels
	private JPanel[] panels;


	/** Constructor **/

	public MainFrame(MainModel mainModel, WelcomeModel welcomeModel, MapModel mapModel, StatsModel statsModel){

		super();
		this.mainModel = mainModel;
		this.welcomeModel = welcomeModel;
		this.mapModel = mapModel;
		this.statsModel = statsModel;
	
		this.mainController = new MainController(mainModel, welcomeModel, mapModel, statsModel);
		initPanels(mainModel, welcomeModel, mapModel, statsModel);
		initWidgets();

	}


	/** Creating Widgets **/

	public void initWidgets(){

		// Set frame properties and layout
		setPreferredSize(new Dimension(900, 562));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);

		// Create widgets
		JLabel fromLabel = new JLabel("From: ");
		JLabel toLabel = new JLabel("To: ");
		JLabel lastUpdatedLabel = new JLabel(mainModel.getLastUpdated());
		fromComboBox = makeComboBox();
		toComboBox = makeComboBox();
		leftButton = new JButton("<");
		rightButton = new JButton(">");

		// Set widget properties
		lastUpdatedLabel.setHorizontalAlignment(JLabel.CENTER);
		leftButton.setEnabled(false);
		rightButton.setEnabled(false);

		// Set default values
		fromComboBox.setSelectedItem("-");
		toComboBox.setSelectedItem("-");

		// Add Action Listeners
		leftButton.addActionListener(mainController.new LeftButtonListener());
		rightButton.addActionListener(mainController.new RightButtonListener());
		fromComboBox.addActionListener(mainController.new FromComboBoxListener());
		toComboBox.addActionListener(mainController.new ToComboBoxListener());

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
		add(panels[mainModel.getCurrentPanel()], BorderLayout.CENTER);

		// Pack frame
		pack();

	}



	public void initPanels(MainModel mainModel, WelcomeModel welcomeModel, MapModel mapModel, StatsModel statsModel) {

		panels = new JPanel[4];

		panels[0] = new WelcomePanel(mainModel, welcomeModel);
		panels[1] = new MapPanel(mainModel, mapModel);
		panels[2] = new StatsPanel(mainModel, statsModel);
		panels[3] = initSurprisePanel();


	}



	public JComboBox<String> makeComboBox() {

		int latestYear;
		int startYear;
		int noOfYears;
		int currentYear;
		JComboBox<String> comboBox;

		latestYear = mainModel.getLatestYear();
		startYear = mainModel.getStartYear();

		noOfYears = latestYear - startYear;
		currentYear = startYear;

		comboBox = new JComboBox<String>();

		for (int i = 0; i <= noOfYears; i++) {

			comboBox.addItem(Integer.toString(currentYear));
			currentYear++;

		}

		comboBox.addItem("-");
		return comboBox;	

	}
	
	
	private ChatRoomFrame initSurprisePanel() {
		
		ChatRoomFrame panel = new ChatRoomFrame();
		SurprisePanelModel model = new SurprisePanelModel();
		SurprisePanelController controller = new SurprisePanelController(panel, model);
		
		return panel;
		
	}


	/** Updating view **/

	public void updatePanel() {

		int current;
		current = mainModel.getCurrentPanel();

		if (current == MainModel.WELCOME_PANEL) leftButton.setEnabled(false);	
		else if (current == MainModel.SURPRISE_PANEL) rightButton.setEnabled(false);	
		else {

			leftButton.setEnabled(true);
			rightButton.setEnabled(true);

		}

		for (int i = 0; i < 4; i++) remove(panels[i]);

		add(panels[current], BorderLayout.CENTER);
		revalidate();
		repaint();

	}


	@Override
	public void update(Observable o, Object arg) {

		if (o instanceof MainModel) {

			if (arg.equals("Panel changed")) updatePanel();

			if (arg.equals("Date Selection changed")) {
				
				if (mainModel.isDateValid()) rightButton.setEnabled(true);
				else rightButton.setEnabled(false);
					
			}

		}

	}

}




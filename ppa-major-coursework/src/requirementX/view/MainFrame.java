package requirementX.view;

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

import requirementX.control.MainController;
import requirementX.model.MainModel;
import requirementX.model.MapModel;
import requirementX.model.StatsModel;
import requirementX.model.WelcomeModel;

public class MainFrame extends JFrame implements Observer {

	private static final long serialVersionUID = 1L;

	private MainModel mainModel;
	private JButton leftButton;
	private JButton rightButton;
	private JComboBox<String> fromComboBox;
	private JComboBox<String> toComboBox;
	private JPanel[] panels;

	public MainFrame(MainModel mainModel, WelcomeModel welcomeModel, MapModel mapModel, StatsModel statsModel){

		super("Application");
		this.mainModel = mainModel;
		initPanels(mainModel, welcomeModel, mapModel, statsModel);
		initWidgets();

	}



	public void initWidgets(){

		// Set frame properties and layout
		setPreferredSize(new Dimension(1080, 720));
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

		// Set widget names
		leftButton.setName("Left Button");
		rightButton.setName("Right Button");
		fromComboBox.setName("From ComboBox");
		toComboBox.setName("To ComboBox");

		// Set default values
		fromComboBox.setSelectedItem("-");
		toComboBox.setSelectedItem("-");

		// Add Action Listeners
		leftButton.addActionListener(new MainController(mainModel));
		rightButton.addActionListener(new MainController(mainModel));
		fromComboBox.addActionListener(new MainController(mainModel));
		toComboBox.addActionListener(new MainController(mainModel));

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
		panels[3] = new SurprisePanel(mainModel);

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
		
		if (arg.equals("Current Panel Changed")) updatePanel();
		if (arg.equals("Date Selection Changed")) ((WelcomePanel) panels[MainModel.WELCOME_PANEL]).updateLabel();
		if (arg.equals("Date Valid Changed")) ((WelcomePanel) panels[MainModel.WELCOME_PANEL]).updateLabel();
		if (arg.equals("Grabbing Data")) ((WelcomePanel) panels[MainModel.WELCOME_PANEL]).updateLabel();
			
	}

}

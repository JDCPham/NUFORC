package requirementXv2.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import api.ripley.Incident;
import requirementXv2.control.MapController;
import requirementXv2.model.MapModel;
import requirementXv2.model.Sighting;

public class StatesFrame extends JFrame{

	private MapModel mapModel;
	private JList<Sighting> listA;
	DefaultListModel<Sighting> modelA;
	private ArrayList<Sighting> sightings;
	private String state;


	/** Constructor **/

	public StatesFrame(MapModel mapModel, String state) {

		super();
		this.mapModel = mapModel;
		this.state = state;
		initWidgets();
		addSightings(state);
		updateList(mapModel.getSightings());

	}


	/** Creating widgets **/

	public void initWidgets() {

		// Frame properties
		setPreferredSize(new Dimension(700, 300));
		setTitle(getStateName(state) + " (" + state + ")");
		setLayout(new BorderLayout());

		// Create Widgets
		modelA = new DefaultListModel<Sighting>();
		listA = new JList<Sighting>(modelA);
		JScrollPane paneA = new JScrollPane(listA);
		JComboBox<String> boxA = new JComboBox<String>();

		// Action listeners
		listA.addMouseListener(new MapController(mapModel).new ListListener());
		boxA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String value = getValue(e);
				
				if (value.equals("-")) updateList(mapModel.getSightings());
				else if (value.equals("City")) updateList(mapModel.getSightingsByCity());
				else if (value.equals("Shape")) updateList(mapModel.getSightingsByShape());
				else if (value.equals("Duration")) updateList(mapModel.getSightingsByDuration());
				else if (value.equals("Date")) updateList(mapModel.getSightingsByDate());
				else if (value.equals("Posted")) updateList(mapModel.getSightingsByPosted());

			}



		});

		// Add items to combo box
		boxA.addItem("-");
		boxA.addItem("Date");
		boxA.addItem("City");
		boxA.addItem("Shape");
		boxA.addItem("Duration");
		boxA.addItem("Posted");

		// Add widgets to panel
		add(boxA, BorderLayout.NORTH);
		add(paneA, BorderLayout.CENTER);

		// Set visible and pack
		setVisible(true);
		pack();

	}


	public String getStateName(String state) {

		if (state.equals("CA")) return "California";
		else if (state.equals("AL")) return "Alabama";
		else if (state.equals("AK")) return "Alaska";
		else if (state.equals("AZ")) return "Arizona";
		else if (state.equals("AR")) return "Arkansas";
		else if (state.equals("CO")) return "Colorado";
		else if (state.equals("CT")) return "Connecticut";
		else if (state.equals("DE")) return "Delaware";
		else if (state.equals("GA")) return "Georgia";
		else if (state.equals("HI")) return "Hawaii";
		else if (state.equals("ID")) return "Idaho";
		else if (state.equals("IL")) return "Illinois";
		else if (state.equals("IN")) return "Indiana";
		else if (state.equals("IA")) return "Iowa";
		else if (state.equals("KS")) return "Kansas";
		else if (state.equals("KY")) return "Kentucky";
		else if (state.equals("LA")) return "Louisiana";
		else if (state.equals("ME")) return "Maine";
		
		else if (state.equals("MD")) return "Maryland";
		else if (state.equals("MA")) return "Massachusetts";
		else if (state.equals("MI")) return "Michigan";
		else if (state.equals("MN")) return "Minnesota";
		else if (state.equals("MS")) return "Mississippi";
		else if (state.equals("MO")) return "Missouri";
		else if (state.equals("MT")) return "Montana";
		else if (state.equals("NE")) return "Nebraska";
		else if (state.equals("NV")) return "Nevada";
		else if (state.equals("NH")) return "New Hampshire";
		else if (state.equals("NJ")) return "New Jersey";
		else if (state.equals("NM")) return "New Mexico";
		else if (state.equals("NY")) return "New York";
		else if (state.equals("NC")) return "North Carolina";
		else if (state.equals("ND")) return "North Dakota";
		else if (state.equals("OH")) return "Ohio";
		else if (state.equals("OK")) return "Oklahoma";
		
		else if (state.equals("CO")) return "Colorado";
		else if (state.equals("CT")) return "Connecticut";
		else if (state.equals("NY")) return "New York";
		else if (state.equals("NC")) return "North Carolina";
		else if (state.equals("AL")) return "Alabama";
		else if (state.equals("AZ")) return "Arizona";
		else if (state.equals("AR")) return "Arkansas";
		else if (state.equals("CO")) return "Colorado";
		else if (state.equals("CT")) return "Connecticut";
		else if (state.equals("NY")) return "New York";
		else if (state.equals("NC")) return "North Carolina";
		else if (state.equals("AL")) return "Alabama";
		else if (state.equals("AZ")) return "Arizona";
		else if (state.equals("AR")) return "Arkansas";
		else if (state.equals("CO")) return "Colorado";
		else if (state.equals("CT")) return "Connecticut";
		else if (state.equals("NY")) return "New York";
		else if (state.equals("NC")) return "North Carolina";
		else if (state.equals("AL")) return "Alabama";
		else if (state.equals("AZ")) return "Arizona";
		else if (state.equals("AR")) return "Arkansas";
		else if (state.equals("CO")) return "Colorado";
		else if (state.equals("CT")) return "Connecticut";
		else if (state.equals("NY")) return "New York";
		else if (state.equals("NC")) return "North Carolina";
		else if (state.equals("AL")) return "Alabama";
		else if (state.equals("AZ")) return "Arizona";
		else if (state.equals("AR")) return "Arkansas";
		else if (state.equals("CO")) return "Colorado";
		else if (state.equals("CT")) return "Connecticut";
		else if (state.equals("NY")) return "New York";
		else if (state.equals("NC")) return "North Carolina";
		
		else return null;

	}


	public void addSightings(String s) {
		
		mapModel.getSightings().clear();

		for (Incident i: mapModel.getIncidents()) { 

			if (i.getState().equals(s)) {

				mapModel.addSighting(setSighting(i));

			}
		}
		
		mapModel.sortSightings();
	}

	public void updateList(ArrayList<Sighting> s) {

		modelA.clear();

		for (Sighting sighting: s) {

			modelA.addElement(sighting);

		}
		
	}


	public Sighting setSighting(Incident i) {

		Sighting s = new Sighting();

		s.setDateTime(i.getDateAndTime());
		s.setCity(i.getCity());
		s.setID(i.getIncidentID());
		s.setState(i.getState());
		s.setShape(i.getShape());
		s.setSummary(i.getSummary());
		s.setDuration(i.getDuration());
		s.setPosted(i.getPosted());

		return s;

	}


	public String getValue(ActionEvent e) {

		JComboBox<String> combo = (JComboBox<String>) e.getSource();
		String value = (String) combo.getSelectedItem();
		return value;

	}

}

package requirementXv2.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import api.ripley.Incident;
import requirementXv2.model.MapModel;

public class StatesFrame extends JFrame {

	private MapModel mapModel;
	DefaultListModel<String> modelA;
	private String state;


	/** Constructor **/

	public StatesFrame(MapModel mapModel, String state) {

		super();
		this.mapModel = mapModel;
		this.state = state;
		initWidgets();
		pop(state);

	}


	/** Creating widgets **/

	public void initWidgets() {

		// Frame properties
		setPreferredSize(new Dimension(300, 200));
		setTitle(state);
		System.out.println(state);
		setLayout(new BorderLayout());

		// Create Widgets
		modelA = new DefaultListModel<String>();
		JList<String> listA = new JList<String>(modelA);
		JScrollPane paneA = new JScrollPane(listA);
		JComboBox<String> boxA = new JComboBox<String>();

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


	public void pop(String s) {

		for (Incident i: mapModel.getIncidents()){ 
			
			if (i.getState().equals(s)) {

				modelA.addElement("City: " + i.getCity() + " Country: " + i.getPosted() + "State: " + i.getState());
				
			}
		}
	}




}

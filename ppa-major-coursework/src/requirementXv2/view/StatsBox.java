// Package
package requirementXv2.view;

// Imports
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import requirementXv2.model.StatsModel;

public class StatsBox extends JPanel implements Observer {

	// Model field
	private StatsModel statsModel;

	// Widget Fields
	private JLabel title;
	private JLabel stat;
	private JButton right;
	private JButton left;

	// Position of the stat box
	private String position;

	
	/**
	 * Constructor Method.
	 * Sets the model fields and the position of this stat box.
	 * Adds observers.
	 * Calls initWidgets method, and updates the stats in this box.
	 * @param statsModel Data model for the stats panel.
	 * @param position An integer representing where this box is displayed within the statistics panel.
	 */
	public StatsBox(StatsModel statsModel, String position) {

		this.statsModel = statsModel;
		this.position = position;
		statsModel.addObserver(this);
		initWidgets();
		updateStat(position);

	}

	
	
	/**
	 * Initialises widgets and sets layouts.
	 * Adds action listeners to right and left buttons to move between the stat boxes.
	 */
	public void initWidgets() {

		// Set Layout
		setLayout(new BorderLayout());

		// Create labels
		title = new JLabel();
		stat = new JLabel();

		// Create buttons
		right = new JButton(">");
		left = new JButton("<");

		// Set Action listener
		right.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				statsModel.nextStat(position);

			}

		});

		left.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				statsModel.prevStat(position);

			}

		});

		// Set label properties
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.CENTER);
		stat.setHorizontalAlignment(JLabel.CENTER);
		stat.setVerticalAlignment(JLabel.CENTER);
		
		// Set fonts
		title.setFont(new Font("Verdana", Font.BOLD, 20));
		stat.setFont(new Font("Verdana", Font.BOLD, 50));

		// Set button properties
		right.setPreferredSize(new Dimension(80, 100));
		left.setPreferredSize(new Dimension(80, 100));

		// Add to panel
		add(right, BorderLayout.EAST);
		add(left, BorderLayout.WEST);
		add(title, BorderLayout.NORTH);
		add(stat, BorderLayout.CENTER);

	}


	/**
	 * Updates the title and statistic of the box from the model.
	 * @param position The position of the statistic box to be updated.
	 */
	public void updateStat(String position) {

		title.setText((statsModel.getStat(position)).getTitle());
		stat.setText((statsModel.getStat(position)).getStat());

	}

	
	
	@Override
	public void update(Observable o, Object arg) {

		if ((arg.equals("Stats Updated")) || (arg.equals("Stats Box Changed"))) updateStat(position);
		
	}


}

// Package
package requirementXv2.view;

// Imports
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import requirementXv2.control.MapController;

public class SightingDialog extends JDialog {
	
	// Widget Fields
	JPanel bottom;
	JLabel label;
	JButton button;
	
	
	/**
	 * Constructor Method
	 * Initialises Widgets
	 * @param s The summary of the incident in String format.
	 */
	public SightingDialog(String s) {
		
		initWidgets(s);
		
	}
	
	
	/**
	 * Initialises widgets by setting the layouts, and properties of the current dialog.
	 * Also creates a button which closes after clicking on it.
	 * @param s Text to be displayed in the middle of the frame.
	 */
	public void initWidgets(String s) {
		
		setPreferredSize(new Dimension(400, 200));
		setLayout(new BorderLayout());
		setTitle("More information...");
		
		label = new JLabel();
		label.setText("<html><center>" + s + "</center></html>");
		label.setOpaque(false);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		
		bottom = new JPanel();
		bottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		button = new JButton("OK");
		button.addActionListener(new MapController().new CloseListener(this));
		bottom.add(button);
		
		add(label, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
		
		
	}

}

package requirementXv2.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import requirementXv2.control.MapController;

public class SightingDialog extends JDialog {
	
	JPanel bottom;
	JLabel label;
	JButton button;
	
	public SightingDialog(String s) {
		
		initWidgets(s);
		
	}
	
	
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

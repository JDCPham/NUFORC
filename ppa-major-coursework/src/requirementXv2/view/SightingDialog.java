package requirementXv2.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SightingDialog extends JDialog {
	
	JPanel bottom;
	JLabel label;
	JButton button;
	
	public SightingDialog() {
		
		initWidgets();
		
	}
	
	
	public void initWidgets() {
		
		setPreferredSize(new Dimension(400, 200));
		setLayout(new BorderLayout());
		
		label = new JLabel();
		label.setText("<html><center>This is a test text</center></html>");
		label.setOpaque(false);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		
		bottom = new JPanel();
		bottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		button = new JButton("OK");
		bottom.add(button);
		
		add(label, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
		
		
	}

}

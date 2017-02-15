package requirementX;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;

public class Panel1 {

	public static void main(String[] args) {
		JFrame myFrame = new JFrame("");
		myFrame.setSize(650, 600);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		 * top of GUI
		 */
		JLabel JLleft = new JLabel("From");
		JLabel JLright = new JLabel("To");
		SpinnerNumberModel JPleft = new SpinnerNumberModel(1950.0, 0.0, 2000,
				1.0);
		JSpinner JPleft1 = new JSpinner(JPleft);
		SpinnerNumberModel JPright = new SpinnerNumberModel(1950.0, 0.0, 2000,
				1.0);
		JSpinner JPright1 = new JSpinner(JPright);
		myFrame.setLayout(new BorderLayout());
		JPanel jpNorth = new JPanel();
		JPanel jpCenter = new JPanel();
		JPanel jpSouth = new JPanel();
		jpNorth.setLayout(new BorderLayout());
		JPanel jpEast = new JPanel();
		jpNorth.add(jpEast, BorderLayout.EAST);
		jpEast.add(JLleft);
		jpEast.add(JPleft1);
		jpEast.add(JLright);
		jpEast.add(JPright1);
		/*
		 * bottom of GUI
		 */
		JButton JBleft = new JButton("<");
		JButton JBright = new JButton(">");
		jpSouth.setLayout(new BorderLayout());
		JPanel jpWest2 = new JPanel();
		jpSouth.add(jpWest2, BorderLayout.WEST);
		jpWest2.add(JBleft, BorderLayout.WEST);
		JPanel jpEast2 = new JPanel();
		jpSouth.add(jpEast2, BorderLayout.EAST);
		jpEast2.add(JBright);
		/*
		 * middle of GUI
		 */
		JTextArea jtArea = new JTextArea();
		jpCenter.add(jtArea);
		myFrame.add(jpNorth, BorderLayout.NORTH);
		myFrame.add(jpCenter, BorderLayout.CENTER);
		myFrame.add(jpSouth, BorderLayout.SOUTH);

		myFrame.pack();
		myFrame.setVisible(true);
	}

}

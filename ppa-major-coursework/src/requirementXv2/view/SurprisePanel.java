package requirementXv2.view;

import java.awt.BorderLayout;  
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SurprisePanel implements Observer {
	private JTextArea textArea;
	private JFrame frame;
	private JButton aButton;
	private JButton bButton;
	private JButton cButton;
	private JButton dButton;
	
	private String question;
	private String answer;
	
	public SurprisePanel() {
		frame = new JFrame("Surprise Panel");
		initWidgets();
		frame.setVisible(true);	
	}
	
	public void initWidgets() {
		frame.setLayout(new BorderLayout());
		
		JPanel southPanel = new JPanel();
		aButton = new JButton("A:");
		aButton.setName("buttonA");
		aButton.setPreferredSize(new Dimension(50,50));
		bButton = new JButton("B:");
		bButton.setName("buttonB");
		cButton = new JButton("C:");
		cButton.setName("buttonC");
		dButton = new JButton("D:");
		dButton.setName("buttonD");
		
		southPanel.setLayout(new GridLayout(2,2));
		southPanel.add(aButton);
	//	aButton.addActionListener();
		southPanel.add(bButton);
		southPanel.add(cButton);
		southPanel.add(dButton);
		frame.add(southPanel, BorderLayout.SOUTH);
		
		ImagePanel roger = new ImagePanel("Images/female alien.png");
		roger.setPreferredSize(new Dimension(470,500));
		roger.setOpaque(false);
		frame.add(roger,BorderLayout.WEST);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setPreferredSize(new Dimension(440,500));
		
		textArea.append("Try to hook up with her! \n");
		
		
		frame.add(textArea, BorderLayout.EAST);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700,520);
			
	}
	
	

	@Override
	public void update(Observable o, Object arg) {
		
		
	}
	
	
}

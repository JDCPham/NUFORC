package requirementXv2.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
 
public class SurprisePanel  {
	private JList<String> textList;
	private DefaultListModel<String> dlmText;
	private JFrame frame;
	private JButton aButton;
	private JButton bButton;
	private JButton cButton;
	private JButton dButton;
	
	public SurprisePanel() {
		frame = new JFrame("Surprise Panel");
		initWidgets();
		frame.setVisible(true);	
	}
	
	public void initWidgets() {
		frame.setLayout(new BorderLayout());
	
		dlmText = new DefaultListModel<String>();
		textList = new JList<String>(dlmText);
		
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
		southPanel.add(bButton);
		southPanel.add(cButton);
		southPanel.add(dButton);
		frame.add(southPanel, BorderLayout.SOUTH);
		
		ImagePanel roger = new ImagePanel("Images/female alien.png");
		roger.setPreferredSize(new Dimension(470,500));
		roger.setOpaque(false);
		frame.add(roger,BorderLayout.WEST);
		
		textList.setPreferredSize(new Dimension(440,500));
		
		dlmText.addElement("Try to hook up with her! \n");
		
		
		frame.add(textList, BorderLayout.EAST);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700,520);
			
	}
	
	public void write(String sentence) {
		
		dlmText.addElement(sentence);
	}
	
	public void write(ArrayList<String> lines) {
		dlmText.removeAllElements();
		dlmText.addElement("Try to hook up with her! \n");
		for (int i = 0; i< lines.size(); i++) {
			dlmText.addElement(lines.get(i));
		}
	}
	
	public void addActionListener(ActionListener listener) {
		aButton.addActionListener(listener);
		bButton.addActionListener(listener);
		cButton.addActionListener(listener);
		dButton.addActionListener(listener);
	}
}


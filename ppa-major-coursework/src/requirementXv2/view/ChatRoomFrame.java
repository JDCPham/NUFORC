package requirementXv2.view;

import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import requirementXv2.control.SurprisePanelController;


public class ChatRoomFrame extends JPanel {

	private DefaultListModel<String> chatRoomModel;
	private JList<String> textList;
	private JLabel jlWelcome;
	private JButton jbA, jbB, jbC, jbD;
	private JPanel jpSouth;
	private JPanel jpCenter;
	private JScrollPane jspChatRoom;
	private SurprisePanelController controller;
	
	public ChatRoomFrame() {
		
		initWidgets();
		
	}
	
	public void initWidgets() {
		
		// Set layout
		setLayout(new BorderLayout());
		
		// Set text, font and colour of label
		jlWelcome = new JLabel("Welcome to Alien Chat");
		jlWelcome.setFont(new Font("Serif", Font.BOLD, 40));
		jlWelcome.setForeground(Color.cyan);
		
		// Create models and lists
		chatRoomModel = new DefaultListModel<String>();
		textList = new JList<String>(chatRoomModel);
		
		// Create panels
		jpSouth = new JPanel();
		jpCenter = new JPanel();
		
		// Create buttons
		jbA = new JButton("A:");
		jbB = new JButton("B:");
		jbC = new JButton("C:");
		jbD = new JButton("D:");
		
		// Set button properties
		jbA.setName("buttonA");
		jbB.setName("buttonB");
		jbC.setName("buttonC");
		jbD.setName("buttonD");
		
		jpSouth.setLayout(new GridLayout(2,2));
		jpSouth.add(jbA);
		jpSouth.add(jbB);
		jpSouth.add(jbC);
		jpSouth.add(jbD);
		
		
		add(jpSouth, BorderLayout.SOUTH);
		
		ImagePanel roger = new ImagePanel("Images/female alien.png");
		roger.setPreferredSize(new Dimension(470,500));
		roger.setOpaque(false);
		
		ImagePanel pinkHeader = new ImagePanel("Images/PinkHeaderBackground.jpg");
		add(pinkHeader, BorderLayout.NORTH);
		
		jpCenter.setLayout(new GridLayout(1, 2));
		jpCenter.add(roger);
		jpCenter.add(textList);
		
		add(jpCenter, BorderLayout.CENTER);
		
		textList.setPreferredSize(new Dimension(440,500));
		
		chatRoomModel.addElement("Try to hook up with her! \n");	
		
		setSize(700,520);
		
	}
	
	
	
	public void write(String sentence) {
		
		chatRoomModel.addElement(sentence);
		
	}
	
	
	
	public void write(ArrayList<String> lines) {
		
		chatRoomModel.removeAllElements();
		chatRoomModel.addElement("Try to hook up with her! \n");
		for(int i = 0; i < lines.size(); i++) {
			
			chatRoomModel.addElement(lines.get(i));
			
		}
		
	}
	
	
	
	public void addActionListener(ActionListener listener) {
		
		jbA.addActionListener(listener);
		jbB.addActionListener(listener);
		jbC.addActionListener(listener);
		jbD.addActionListener(listener);
		
	}
	
	
}

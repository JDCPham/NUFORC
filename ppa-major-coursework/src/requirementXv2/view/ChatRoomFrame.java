package requirementXv2.view;

import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import requirementXv2.control.SurprisePanelController;

/**
 * This class creates the GUI for the the fourth panel.
 * This class also includes the method to append text to
 * the list and adds action listeners to each of the four 
 * buttons.
 * 
 * @author Emmanuel
 *
 */

public class ChatRoomFrame extends JPanel {

	private DefaultListModel<String> chatRoomModel;		//Instance variable for default list model
	private JList<String> textList;						//Instance variable for JList
	private JLabel jlWelcome;							//Instance variable for welcome label
	private JButton jbA, jbB, jbC, jbD;					//Instance variable for four buttons	
	private JPanel jpSouth;								//Instance variable for south panel
	private JPanel jpCenter;							//Instance variable for center panel	
	private SurprisePanelController controller;			//Instance variable for controller
	private JScrollPane jspChatRoom;
	
	/**
	 * Class constructor. When class is created,
	 * widgets are also created by calling initWidgets()
	 * method below.
	 */
	public ChatRoomFrame() {
		
		initWidgets();
		
	}
	
	/**
	 * Method to create each of the widgets in the
	 * frame and add each widget to specified locations.
	 */
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
		
		//Add buttons to the south panel
		jpSouth.setLayout(new GridLayout(2,2));
		jpSouth.add(jbA);
		jpSouth.add(jbB);
		jpSouth.add(jbC);
		jpSouth.add(jbD);
		
		//Add list to scroll pane
		jspChatRoom = new JScrollPane(textList);
		
		/*
		 * Add south panel with buttons to the south of the
		 * frame
		 */
		add(jpSouth, BorderLayout.SOUTH);
		
		/*
		 * Create reference to object of ImagePanel class
		 * with female alien as a parameter. Set image size. 
		 * Set transparency of image to true
		 */
		ImagePanel roger = new ImagePanel("Images/FemaleAlien.png");
		roger.setPreferredSize(new Dimension(450,600));
		roger.setOpaque(false);
		
		/*
		 * Create reference to object of ImagePanel class
		 * with pink picture as a parameter. Set image size. 
		 * Set transparency of image to true
		 */
		ImagePanel pinkHeader = new ImagePanel("Images/PinkHeaderBackground.jpg");
		pinkHeader.setPreferredSize(new Dimension(2200, 50));
		pinkHeader.add(jlWelcome);
		add(pinkHeader, BorderLayout.NORTH);
		
		/*
		 * Add picture of alien to center panel.
		 * Add list to center panel
		 */
		jpCenter.setLayout(new GridLayout(1, 2));
		jpCenter.add(roger);
		jpCenter.add(jspChatRoom);
		
		//Add center panel to center of frame
		add(jpCenter, BorderLayout.CENTER);
		
		//Set size of list
		textList.setPreferredSize(new Dimension(440,500));
		
		//Add introductory message to list model to explain instructions
		chatRoomModel.addElement("Try to hook up with her! \n");	
		
		setSize(700,520);
		
	}
	
	
	/**
	 * Method to add questions and answers to 
	 * the list model.
	 * @param sentence
	 */
	public void write(String sentence) {
		
		chatRoomModel.addElement(sentence);
		
	}
	
	
	/**
	 * Method to remove options that weren't chosen.
	 * Prints the introduction and the next question.
	 * @param lines
	 */
	public void write(ArrayList<String> lines) {
		
		chatRoomModel.removeAllElements();
		chatRoomModel.addElement("Try to hook up with her! \n");
		for(int i = 0; i < lines.size(); i++) {
			
			chatRoomModel.addElement(lines.get(i));
			
		}
		
	}
	
	
	/**
	 * Method to add action listeners to all 
	 * four of the buttons
	 * @param listener
	 */
	public void addActionListener(ActionListener listener) {
		
		jbA.addActionListener(listener);
		jbB.addActionListener(listener);
		jbC.addActionListener(listener);
		jbD.addActionListener(listener);
		
	}
	
	
}

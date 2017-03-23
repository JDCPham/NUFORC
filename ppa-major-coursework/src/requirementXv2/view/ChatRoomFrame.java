package requirementXv2.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import requirementXv2.control.EscapeChatController;

public class ChatRoomFrame extends JPanel implements Observer {

	private ChatRoomPicturePanel femaleRoger;
	private ChatRoomPicturePanel pinkHeader;
	private JTextArea jtaChatRoom;
	private JLabel jlWelcome;
	private JButton jb1, jb2, jb3, jb4;
	private JPanel jpSouth;
	private JPanel jpCenter;

	private ArrayList<JButton> buttonList;

	public ChatRoomFrame() {
		initWidgets();
		setVisible(true);
	}

	public void initWidgets() {
		setLayout(new BorderLayout());

		femaleRoger = new ChatRoomPicturePanel("Picture/FemaleAlien.png");
		pinkHeader = new ChatRoomPicturePanel("Picture/PinkHeaderBackground.jpg");

		jtaChatRoom = new JTextArea();
		
		// Initialise the button list.
		buttonList = new ArrayList<JButton>();
		
		jb1 = new JButton("Hello");
		jb1.setName("Button 1");
		buttonList.add(jb1);
		jb2 = new JButton("Hello");
		buttonList.add(jb2);
		jb3 = new JButton("Hello");
		buttonList.add(jb3);
		jb4 = new JButton("Hello");
		buttonList.add(jb4);
		
		// Create an action listener.
		EscapeChatController bal = new EscapeChatController();
		
		// Add action listener to buttons.
		for (JButton jb : buttonList) {
			
			jb.addActionListener(bal);
		}
		

		jpSouth = new JPanel();
		jpSouth.setLayout(new GridLayout(2, 2));
		jpSouth.add(jb1);
		jpSouth.add(jb2);
		jpSouth.add(jb3);
		jpSouth.add(jb4);

		jpCenter = new JPanel();
		jpCenter.setLayout(new GridLayout(1, 2));
		jlWelcome = new JLabel("Welcome to Alien Chat");
		jlWelcome.setFont(new Font("Serif", Font.BOLD, 40));
		jlWelcome.setForeground(Color.cyan);

		// jtaChatRoom.setPreferredSize(new Dimension(140, 500));

		add(jpSouth, BorderLayout.SOUTH);
		add(jpCenter, BorderLayout.CENTER);
		add(pinkHeader, BorderLayout.NORTH);

		jpCenter.add(femaleRoger);
		jpCenter.add(jtaChatRoom);

		pinkHeader.add(jlWelcome);
	}

	@Override
	public void update(Observable arg0, Object arg1) {

		// Disable the buttons to stop the user from continuing the game.
		for (JButton jb : buttonList) {
			
			jb.setEnabled(false);
		}
		
	}
}

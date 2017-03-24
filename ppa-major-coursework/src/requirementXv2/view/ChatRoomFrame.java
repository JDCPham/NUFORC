package requirementXv2.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import requirementXv2.control.EscapeChatController;
import requirementXv2.model.EscapeChatModel;

public class ChatRoomFrame extends JPanel implements Observer {

	private ChatRoomPicturePanel femaleRoger;
	private ChatRoomPicturePanel pinkHeader;
	private JTextArea jtaChatRoom;
	private JLabel jlWelcome;
	private JButton jb1, jb2, jb3, jb4;
	private JPanel jpSouth;
	private JPanel jpCenter;
	private JList<String> jList;
	private DefaultListModel<String> dlm;

	private ArrayList<JButton> buttonList;

	public ChatRoomFrame() {
		initWidgets();
		setVisible(true);
	}

	public void initWidgets() {
		setLayout(new BorderLayout());

		dlm = new DefaultListModel<String>();
		jList = new JList<String>(dlm);

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

		// Read arg1 to determine game state
		if (arg1 != null && arg1 instanceof Integer) {

			// Cast the argument as integer
			int gameState = (Integer) arg1;

			if (gameState != EscapeChatModel.GAME_ACTIVE) {
				// Case where an end game state has been reached
				promptEndGame(gameState);

			}
		}

	}

	private void promptEndGame(int gameState) {
		
		if (gameState == EscapeChatModel.GAME_WIN) {
			
			dlm.addElement("Good job, you won a date with an alien, gross but congratulations.");
			
			
		}
		
		// S
		else if (gameState == EscapeChatModel.GAME_LOST) {
			
			dlm.addElement("You failed to mate with an alien");
		}
		// Disable the buttons to stop the user from continuing the game.
		for (JButton jb : buttonList) {

			jb.setEnabled(false);
		}
	}
}
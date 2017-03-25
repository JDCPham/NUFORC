package requirementXv2.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import requirementXv2.control.EscapeChatController;
import requirementXv2.model.EscapeChatModel;

public class ChatRoomFrame extends JPanel implements Observer {

	private ChatRoomPicturePanel jpEast;
	private ChatRoomPicturePanel jpSouth;
	private JPanel jpCenter;
	private JPanel jpNorth;

	private JButton jButton1, jButton2, jButton3, jButton4;

	private ArrayList<JButton> buttonList;

	private JLabel alienPic;
	private JLabel userPic;
	
	private JLabel jlTitle;

	private JList<String> jList;
	private DefaultListModel<String> dlm;

	public ChatRoomFrame() {

		initWidgets();
		setVisible(true);

	}

	private void initWidgets() {
		setLayout(new BorderLayout());

		initNorth();
		initCenter();
		initSouth();
		initWest();

		add(jpNorth, BorderLayout.NORTH);
		add(jpEast, BorderLayout.WEST);
		add(jpSouth, BorderLayout.SOUTH);
		add(jpCenter, BorderLayout.CENTER);	

	}
	
	private void initNorth() {
		
		jpNorth = new JPanel(new FlowLayout());
		jpNorth.setBackground(Color.RED);
		jpNorth.setOpaque(true);
		jlTitle = new JLabel("ARE YOU HAVING TROUBLE WITH GETTING HUMAN GIRLS? "
				+ "NO WORRIES BECAUSE A 629 YEARS OLD, DIVORCED ALIEN IS NEAR YOUR LOCATION AND IS READY TO MINGLE!!");
		jlTitle.setFont(new Font(jlTitle.getText(), Font.BOLD, 10));
		jlTitle.setForeground(Color.WHITE);
		jpNorth.add(jlTitle);
	}
	private void initCenter() {
		
		jpCenter = new JPanel(new BorderLayout());
		dlm = new DefaultListModel<String>();
		jList = new JList<String>(dlm);
		JScrollPane sp = new JScrollPane(jList);
		jpCenter.add(sp, BorderLayout.CENTER);
	}

	private void initWest() {

		jpEast = new ChatRoomPicturePanel("Picture/Heart.jpg", new GridLayout(2, 0));

		alienPic = new JLabel();
		alienPic.setIcon(new ImageIcon("Picture/Alien.jpg"));
		alienPic.setPreferredSize(new Dimension(160, 220));
		alienPic.setHorizontalAlignment(JLabel.CENTER);
		alienPic.setVerticalAlignment(JLabel.CENTER);
		alienPic.setBorder(new LineBorder(Color.PINK));

		userPic = new JLabel();
		userPic.setIcon(new ImageIcon("Picture/profile.jpg"));
		userPic.setPreferredSize(new Dimension(160, 220));
		userPic.setHorizontalAlignment(JLabel.CENTER);
		userPic.setVerticalAlignment(JLabel.CENTER);
		userPic.setBorder(new LineBorder(Color.PINK));

		jpEast.add(alienPic);
		jpEast.add(userPic);
	}

	private void initSouth() {

		jpSouth = new ChatRoomPicturePanel("Picture/Heart.jpg", new GridLayout(2, 2));
		// Initialise array list.
		buttonList = new ArrayList<JButton>();

		jButton1 = new JButton("Button 1");
		jButton1.setIcon(new ImageIcon("Picture/kiss.jpg"));
		jpSouth.add(jButton1);
		buttonList.add(jButton1);

		jButton2 = new JButton("Button 2");
		jButton2.setIcon(new ImageIcon("Picture/kiss.jpg"));
		jpSouth.add(jButton2);
		buttonList.add(jButton2);

		jButton3 = new JButton("Button 3");
		jButton3.setIcon(new ImageIcon("Picture/kiss.jpg"));
		jpSouth.add(jButton3);
		buttonList.add(jButton3);

		jButton4 = new JButton("Button 4");
		jButton4.setIcon(new ImageIcon("Picture/kiss.jpg"));
		jpSouth.add(jButton4);
		buttonList.add(jButton4);

		// Create an action listener.
		EscapeChatController bal = new EscapeChatController();

		// Add action listener to buttons.
		for (JButton jb : buttonList) {

			jb.addActionListener(bal);
		}

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
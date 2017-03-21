package requirementXv2.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EscapeChatFrame extends JPanel implements Observer {

	private EscapePicturePanel sidePanelAlien1;
	private EscapePicturePanel sidePanelAlien2;
	private EscapePicturePanel sidePanelAlien3;
	private EscapePicturePanel sidePanelAlien4;
	private EscapePicturePanel sidePanelAlien5;
	private EscapePicturePanel sidePanelAlien6;
	private EscapePicturePanel sidePanelAlien7;
	private EscapePicturePanel sidePanelAlien8;
	private EscapePicturePanel headerBackground;
	private EscapePicturePanel leftSidePanelSpace;
	private EscapePicturePanel rightSidePanelSpace;
	private JTextField jtfChatInput;
	private JTextArea jtaChatRoom;
	private JLabel jlWelcome;
	
	public EscapeChatFrame()
	{
		initWidgets();
		setVisible(true);
	}
	
	public void initWidgets()
	{
		setLayout(new BorderLayout());
 		
		sidePanelAlien1 = new EscapePicturePanel("Picture/AlienHead.png");
		sidePanelAlien2 = new EscapePicturePanel("Picture/AlienHead.png");
		sidePanelAlien3 = new EscapePicturePanel("Picture/AlienHead.png");
		sidePanelAlien4 = new EscapePicturePanel("Picture/AlienHead.png");
		sidePanelAlien5 = new EscapePicturePanel("Picture/AlienHead.png");
		sidePanelAlien6 = new EscapePicturePanel("Picture/AlienHead.png");
		sidePanelAlien7 = new EscapePicturePanel("Picture/AlienHead.png");
		sidePanelAlien8 = new EscapePicturePanel("Picture/AlienHead.png");
		leftSidePanelSpace = new EscapePicturePanel("Picture/SpaceBackground.jpg");
		rightSidePanelSpace = new EscapePicturePanel("Picture/SpaceBackground.jpg");
		headerBackground = new EscapePicturePanel("Picture/GameHeaderBackground.jpg");
		
		jtfChatInput = new JTextField();
		jtfChatInput.setPreferredSize(new Dimension(20, 40));

		jtaChatRoom = new JTextArea();
		jlWelcome = new JLabel("Welcome aboard");
		jlWelcome.setFont(new Font("Serif", Font.BOLD, 40));
		jlWelcome.setForeground(Color.green);

		rightSidePanelSpace.setPreferredSize(new Dimension(140, 500));
		leftSidePanelSpace.setPreferredSize(new Dimension(140, 500));
		jtaChatRoom.setPreferredSize(new Dimension(140, 500));

		add(headerBackground, BorderLayout.NORTH);
		add(rightSidePanelSpace, BorderLayout.EAST);
		add(leftSidePanelSpace, BorderLayout.WEST);
		add(jtfChatInput, BorderLayout.SOUTH);
		add(jtaChatRoom, BorderLayout.CENTER);
		
		headerBackground.add(jlWelcome);
		
		rightSidePanelSpace.setLayout(new GridLayout(4, 1));
		rightSidePanelSpace.add(sidePanelAlien1);
		rightSidePanelSpace.add(sidePanelAlien2);
		rightSidePanelSpace.add(sidePanelAlien3);
		rightSidePanelSpace.add(sidePanelAlien4);
		
		leftSidePanelSpace.setLayout(new GridLayout(4, 1));
		leftSidePanelSpace.add(sidePanelAlien5);
		leftSidePanelSpace.add(sidePanelAlien6);
		leftSidePanelSpace.add(sidePanelAlien7);
		leftSidePanelSpace.add(sidePanelAlien8);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		
	}	
}

package requirementXv2.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
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
	//private JTextField jtfChatInput;
	private JTextArea jtaChatRoom;
	private JLabel jlWelcome;
	private JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9, jb10;
	private JPanel jpSouth;
	
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
		
		//jtfChatInput = new JTextField();
		//jtfChatInput.setPreferredSize(new Dimension(20, 40));

		jtaChatRoom = new JTextArea();
		jb1 = new JButton("Hello");
		jb2 = new JButton("Hello");
		jb3 = new JButton("Hello");
		jb4 = new JButton("Hello");
		jb5 = new JButton("Hello");
		jb6 = new JButton("Hello");
		jb7 = new JButton("Hello");
		jb8 = new JButton("Hello");
		jb9 = new JButton("Hello");
		jb10 = new JButton("Hello");
		
		jpSouth = new JPanel();
		jpSouth.setLayout(new GridLayout(1, 10));
		jpSouth.add(jb1);
		jpSouth.add(jb2);
		jpSouth.add(jb3);
		jpSouth.add(jb4);
		jpSouth.add(jb5);
		jpSouth.add(jb6);
		jpSouth.add(jb7);
		jpSouth.add(jb8);
		jpSouth.add(jb9);
		jpSouth.add(jb10);

		jlWelcome = new JLabel("Welcome aboard");
		jlWelcome.setFont(new Font("Serif", Font.BOLD, 40));
		jlWelcome.setForeground(Color.green);

		rightSidePanelSpace.setPreferredSize(new Dimension(140, 500));
		leftSidePanelSpace.setPreferredSize(new Dimension(140, 500));
		jtaChatRoom.setPreferredSize(new Dimension(140, 500));

		add(headerBackground, BorderLayout.NORTH);
		add(rightSidePanelSpace, BorderLayout.EAST);
		add(leftSidePanelSpace, BorderLayout.WEST);
		add(jpSouth, BorderLayout.SOUTH);
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

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
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import requirementXv2.control.EscapeChatController;

public class EscapeChatFrame extends JPanel implements Observer {

	private EscapePicturePanel femaleRoger;
	private JTextArea jtaChatRoom;
	private JLabel jlWelcome;
	private JButton jb1, jb2, jb3, jb4;
	private JPanel jpSouth;
	
	public EscapeChatFrame()
	{
		initWidgets();
		setVisible(true);
	}
	
	public void initWidgets()
	{
		setLayout(new BorderLayout());
 		
		femaleRoger = new EscapePicturePanel("Picture/FemaleAlien.png");

		jtaChatRoom = new JTextArea();
		jb1 = new JButton("Hello");
		jb1.setName("Button 1");
		jb1.addActionListener(new EscapeChatController());
		jb2 = new JButton("Hello");
		jb2.addActionListener(new EscapeChatController());
		jb3 = new JButton("Hello");
		jb3.addActionListener(new EscapeChatController());
		jb4 = new JButton("Hello");
		jb4.addActionListener(new EscapeChatController());
		

		
		jpSouth = new JPanel();
		jpSouth.setLayout(new GridLayout(2, 2));
		jpSouth.add(jb1);
		jpSouth.add(jb2);
		jpSouth.add(jb3);
		jpSouth.add(jb4);
		

		jlWelcome = new JLabel("Welcome to Alien Chat");
		jlWelcome.setFont(new Font("Serif", Font.BOLD, 40));
		jlWelcome.setForeground(Color.red);

		jtaChatRoom.setPreferredSize(new Dimension(140, 500));

		add(jpSouth, BorderLayout.SOUTH);
		add(jtaChatRoom, BorderLayout.CENTER);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		
	}	
}

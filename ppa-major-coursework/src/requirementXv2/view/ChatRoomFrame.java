package requirementXv2.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JScrollPane;

import requirementXv2.control.EscapeChatController;

public class ChatRoomFrame extends JPanel {

	private ChatRoomPicturePanel femaleRoger;
	private ChatRoomPicturePanel pinkHeader;
	private DefaultListModel<String> chatRoomModel;
	private JList<String> jltChatRoom;
	private JLabel jlWelcome;
	private JButton jbA, jbB, jbC, jbD;
	private JPanel jpSouth;
	private JPanel jpCenter;
	private JScrollPane jspChatRoom;
	
	public ChatRoomFrame()
	{
		initWidgets();
		setVisible(true);
	}
	
	public void initWidgets()
	{
		setLayout(new BorderLayout());
 		
		femaleRoger = new ChatRoomPicturePanel("Picture/FemaleAlien.png");
		pinkHeader = new ChatRoomPicturePanel("Picture/PinkHeaderBackground.jpg");
		
		chatRoomModel = new DefaultListModel<String>();
		jltChatRoom = new JList<String>(chatRoomModel);
		jspChatRoom = new JScrollPane(jltChatRoom);
		
		jbA = new JButton("Hello");
		jbA.setName("Button A");
		jbB = new JButton("Hello");
		jbC = new JButton("Hello");
		jbC.addActionListener(new EscapeChatController());
		jbD = new JButton("Hello");
		jbD.addActionListener(new EscapeChatController());
		
		jpSouth = new JPanel();
		jpSouth.setLayout(new GridLayout(2, 2));
		jpSouth.add(jbA);
		jpSouth.add(jbB);
		jpSouth.add(jbC);
		jpSouth.add(jbD);
		
		jpCenter = new JPanel();
		jpCenter.setLayout(new GridLayout(1, 2));
		jlWelcome = new JLabel("Welcome to Alien Chat");
		jlWelcome.setFont(new Font("Serif", Font.BOLD, 40));
		jlWelcome.setForeground(Color.cyan);

		add(jpSouth, BorderLayout.SOUTH);
		add(jpCenter, BorderLayout.CENTER);
		add(pinkHeader, BorderLayout.NORTH);
		
		jpCenter.add(femaleRoger);
		jpCenter.add(jspChatRoom);
		
		pinkHeader.add(jlWelcome);
	}
	
	public void write(String sentence)
	{
		chatRoomModel.addElement(sentence);
	}
	
	public void write(ArrayList<String> lines)
	{
		chatRoomModel.removeAllElements();
		chatRoomModel.addElement("Try to hook up with her! \n");
		for(int i = 0; i < lines.size(); i++)
		{
			chatRoomModel.addElement(lines.get(i));
		}
	}
}

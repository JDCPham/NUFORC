package requirementXv2.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
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

	private EscapePicturePanel sidePanelAlien;
	private EscapePicturePanel leftSidePanelSpace;
	private EscapePicturePanel rightSidePanelSpace;
	private JTextField jtfChatInput;
	private JTextArea jtaChatRoom;
	
	public EscapeChatFrame()
	{
		initWidgets();
		setVisible(true);
	}
	
	public void initWidgets()
	{
		setLayout(new BorderLayout());
 		
		sidePanelAlien = new EscapePicturePanel("Picture/greyAlienHead.png");
		leftSidePanelSpace = new EscapePicturePanel("Picture/SpaceBackground.jpg");
		rightSidePanelSpace = new EscapePicturePanel("Picture/SpaceBackground.jpg");
		
		jtfChatInput = new JTextField();
		jtaChatRoom = new JTextArea();
		
		rightSidePanelSpace.setPreferredSize(new Dimension(400, 500));
		leftSidePanelSpace.setPreferredSize(new Dimension(400, 500));
		jtaChatRoom.setPreferredSize(new Dimension(400, 500));

		add(rightSidePanelSpace, BorderLayout.EAST);
		add(leftSidePanelSpace, BorderLayout.WEST);
		add(jtfChatInput, BorderLayout.SOUTH);
		add(jtaChatRoom, BorderLayout.CENTER);
		
		jtfChatInput.setPreferredSize(new Dimension(getHeight(), 40));
		
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		
	}
	
	
}

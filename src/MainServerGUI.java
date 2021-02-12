import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainServerGUI extends JFrame implements ActionListener{
	JButton button1 = new JButton("Remote Desktop Control");
	JButton button2 = new JButton("Lets's Chat");
	JButton button3 = new JButton("Screen Sharing");
	JButton button4 = new JButton("Receive Files");
	JButton backBtn = new JButton("Back");
	JFrame frame;
	private String Port;
	public MainServerGUI(String port)
	{
		Port = port;
		System.out.println(Port);
		frame = new JFrame();
		frame.setSize(500,500);
		
		button1.setFont(new Font("Dialog", Font.PLAIN, 20));
		button2.setFont(new Font("Dialog", Font.PLAIN, 20));
		button3.setFont(new Font("Dialog", Font.PLAIN, 20));
		button4.setFont(new Font("Dialog", Font.PLAIN, 20));
		backBtn.setFont(new Font("Dialog", Font.PLAIN, 20));
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(Box.createRigidArea(new Dimension(1, 0)));
		panel.add(backBtn);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		backBtn.addActionListener(this);
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Main Menu");
	
		//frame.pack();
		frame.setVisible(true);

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainServerGUI("5000");

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//frame.dispose();
		if(e.getSource()==button1)
		{
			
		}
		if(e.getSource()==button2)
		{
			new ChatServerGUI(Port);
		}
		if(e.getSource()==button3)
		{
			int port;
			port = Integer.parseInt(Port);
			new ScreenShare(port);
		}
		if(e.getSource()==button4)
		{
			int port;
			port = Integer.parseInt(Port);
			new FileSharingServer(port);
		}
		if(e.getSource() == backBtn)
		{
			frame.dispose();
			new Server();
		}
	}

}

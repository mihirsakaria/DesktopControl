import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FileShareClientGUI extends JFrame implements ActionListener {
	JFrame frame;
	JButton send, close;
	String IP;
	int Port;
	JTextField userText;
	public FileShareClientGUI(String host, String port) {
		IP = host;
		Port = Integer.parseInt(port);
		frame = new JFrame();
		frame.setSize(500,500);
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		panel.setLayout(new GridLayout(0, 1));
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Main Menu");
		JLabel fileName = new JLabel("Enter File Name");
		panel.add(fileName);
		userText = new JTextField();
		userText.setPreferredSize(new Dimension(150,50));
		panel.add(userText);
		panel.add(Box.createRigidArea(new Dimension(5, 0)));
		send = new JButton("Send !!");
		close = new JButton("Close");
		panel.add(Box.createRigidArea(new Dimension(1, 0)));
		panel.add(send);
		panel.add(Box.createRigidArea(new Dimension(1, 0)));
		panel.add(close);
		send.addActionListener(this);
		close.addActionListener(this);
		frame.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==send) {
			String filename = userText.getText();
			System.out.println(filename);
			new FileSharingClient(IP, Port, filename);
			
		
		}
		if(e.getSource()==close) {
			frame.dispose();
			String port = Integer.toString(Port);
			new MainClientGUI(IP, port);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FileShareClientGUI("localhost", "5000");
	}

}

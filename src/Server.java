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

public class Server extends JFrame implements ActionListener {
	JButton submit = new JButton("Submit");
	JButton backBtn = new JButton("Back");
	JTextField userText;
	JFrame frame;
	public Server()
	{
				
		frame = new JFrame();
		frame.setSize(500,500);
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		panel.setLayout(new GridLayout(0, 1));
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Main Menu");
		
	
		JLabel port = new JLabel("Enter Port No.");
		panel.add(port);
		userText = new JTextField();
		userText.setPreferredSize(new Dimension(150,50));
		panel.add(userText);
		panel.add(Box.createRigidArea(new Dimension(5, 0)));
		
		panel.add(submit);
		panel.add(Box.createRigidArea(new Dimension(1, 0)));
		panel.add(backBtn);

		submit.addActionListener(this);
		backBtn.addActionListener(this);
		//frame.pack();
		frame.setVisible(true);

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Server();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit) {
		String Port = userText.getText();
		frame.dispose();
		new MainServerGUI(Port);
		}
		if(e.getSource()==backBtn)
		{
			frame.dispose();
			new server_client();
		}
		
	}

}

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

public class Client extends JFrame implements ActionListener {
	JButton submit = new JButton("Submit");
	JButton backBtn = new JButton("Back");
	JTextField ipText;
	JTextField portText;
	JFrame frame;
	public Client()
	{
				
		frame = new JFrame();
		frame.setSize(500,500);
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		panel.setLayout(new GridLayout(0, 1));
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Main Menu");
		JLabel iplabel = new JLabel("IP Address");
		panel.add(iplabel);
		ipText = new JTextField();
		//userText.setBounds(null);
		//ipText.setPreferredSize(new Dimension(150,10));
		panel.add(ipText);
		//frame.pack();
		JLabel port = new JLabel("Port No.");
		panel.add(port);
		portText = new JTextField();
		//portText.setPreferredSize(new Dimension(150,50));
		panel.add(portText);
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
		
		new Client();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit) {
		String IP = ipText.getText();
		String Port = portText.getText();
		frame.dispose();
		new MainClientGUI(IP, Port);
		}
		if(e.getSource()==backBtn)
		{
			frame.dispose();
			new server_client();
		}
		
	}
}


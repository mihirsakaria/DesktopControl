import java.awt.BorderLayout;
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

public class server_client extends JFrame implements ActionListener {
	JButton server = new JButton("Server");
	JButton client = new JButton("Client");
	JButton close = new JButton("Close");
	JFrame frame;
	public server_client() {
		frame = new JFrame();
		frame.setSize(500,400);
		
		server.setFont(new Font("Dialog", Font.PLAIN, 20));
		client.setFont(new Font("Dialog", Font.PLAIN, 20));
		close.setFont(new Font("Dialog", Font.PLAIN, 20));
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(server);
		panel.add(Box.createRigidArea(new Dimension(1, 0)));
		panel.add(client);
		panel.add(Box.createRigidArea(new Dimension(1, 0)));
		panel.add(close);
		server.addActionListener(this);
		client.addActionListener(this);
		close.addActionListener(this);
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Main Menu");
	
		//frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new server_client();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == server) {
			frame.dispose();
			new Server();
			
		}
		if(e.getSource() == client) {
			frame.dispose();
			new Client();
		}
		if(e.getSource()==close) {
			System.exit(0);
		}
	}

}

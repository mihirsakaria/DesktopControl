//package client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class FileSharingClient {
	
	private Socket s;
	
	public FileSharingClient(String host, int port, String file) {
		file = "Test.txt";
		System.out.println("File to send " + file);
		try {
			s = new Socket(host, port);
			System.out.println("Reached sendFile");
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			FileInputStream fis = new FileInputStream(file);
			byte[] buffer = new byte[4096];
			
			while (fis.read(buffer) > 0) {
				dos.write(buffer);
			}
			
			fis.close();
			dos.close();	
			System.out.println("File Sent!");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Client");
		}		
	}
	
	
	public static void main(String[] args) {
		FileSharingClient fc = new FileSharingClient("localhost", 5000, "Test.txt");
	}

}
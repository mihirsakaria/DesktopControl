//package server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class FileSharingServer extends Thread {
    String line = ""; 
	private ServerSocket ss;
	Socket clientSock;
	String Port;
	public FileSharingServer(int port) {
		Port = Integer.toString(port);
		try {
			ss = new ServerSocket(port);
			System.out.println("Server is listening");
			clientSock = ss.accept();
			DataInputStream dis = new DataInputStream(clientSock.getInputStream());
			FileOutputStream fos = new FileOutputStream("ReceivedFile.txt");
			System.out.println("File Received!");

			byte[] buffer = new byte[4096];
			
			int filesize = 15123; // Send file size in separate msg
			int read = 0;
			int totalRead = 0;
			int remaining = filesize;
			while((read = dis.read(buffer, 0, Math.min(buffer.length, remaining))) > 0) {
				totalRead += read;
				remaining -= read;
				System.out.println("read " + totalRead + " bytes.");
				fos.write(buffer, 0, read);
			}
			
			fos.close();
			dis.close();
			clientSock.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Server");
		}
	}


//-----------------------------------

//-------------------------------------------
	public static void main(String[] args) {
		FileSharingServer fs = new FileSharingServer(5000);
		fs.start();
	}

}
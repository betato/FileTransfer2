package com.betato;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient extends Thread {

	DataInputStream input;
	DataOutputStream output;
	Socket s;
	FileInputStream fileIn;
	int serverPort;

	public TCPClient(String ip, int serverPort, String file) {
		try {
			this.serverPort = serverPort;
			s = new Socket(ip, serverPort);
			input = new DataInputStream(s.getInputStream());
			output = new DataOutputStream(s.getOutputStream());
			fileIn = new FileInputStream(file);
			this.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			byte[] buffer = new byte[1024];
			int number;

			while ((number = fileIn.read(buffer)) != -1) {
				output.write(buffer, 0, number);
				output.flush();
			}
			fileIn.close();
			output.close();
			System.out.println("File Transfered");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (s != null) {
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
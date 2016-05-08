package com.betato;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TCPServer extends Thread {

	DataInputStream input;
	DataOutputStream output;
	FileOutputStream fileOut;
	Socket clientSocket;
	
	public TCPServer(Socket clientSocket, String saveFilePath) {
		try {
			this.clientSocket = clientSocket;
			input = new DataInputStream(clientSocket.getInputStream());
			output = new DataOutputStream(clientSocket.getOutputStream());
			fileOut = new FileOutputStream(saveFilePath + "test.txt");
			this.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			byte[] buffer = new byte[1024];
			int number;
			while ((number = input.read(buffer)) != -1) {
				fileOut.write(buffer, 0, number);
				fileOut.flush();
			}
			fileOut.close();
			System.out.println("File Recieved");
		} catch (EOFException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				clientSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

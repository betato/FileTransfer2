package com.betato;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerManager extends Thread {
	
	int serverPort;
	ServerSocket listenerSocket;
	String saveFilePath;
	
	public ServerManager(int serverPort, String saveFilePath) {
		this.serverPort = serverPort;
		this.saveFilePath = saveFilePath;
		this.start();
	}

	public void run() {

		try {
			listenerSocket = new ServerSocket(serverPort);
			System.out.println("Server Listening");
			while (true) {
				Socket clientSocket = listenerSocket.accept();
				new TCPServer(clientSocket, saveFilePath);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

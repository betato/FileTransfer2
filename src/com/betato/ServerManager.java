package com.betato;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerManager extends Thread {
	
	int serverPort;
	ServerSocket listenerSocket;
	
	public ServerManager(int serverPort) {
		this.serverPort = serverPort;
		this.start();
	}

	public void run() {

		try {
			listenerSocket = new ServerSocket(serverPort);
			System.out.println("Server Listening");
			while (true) {
				Socket clientSocket = listenerSocket.accept();
				new TCPServer(clientSocket);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package com.betato;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient extends Thread {

	Socket s = null;
	String ip = "localhost";
	int serverPort;

	public TCPClient(String ip, int serverPort) {
		this.ip = ip;
		this.serverPort = serverPort;
		this.start();
	}

	public void run() {
		try {
			s = new Socket(ip, serverPort);
			DataInputStream input = new DataInputStream(s.getInputStream());
			DataOutputStream output = new DataOutputStream(s.getOutputStream());

			// Read and write to streams here
			
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
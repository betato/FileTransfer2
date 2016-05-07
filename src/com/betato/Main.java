package com.betato;

import java.io.FileInputStream;

public class Main {

	public static void main(String[] args) {
		new ServerManager(3457);

		try {
			Thread.sleep(1000);
			new TCPClient("127.0.0.1", 3457, new FileInputStream(""));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

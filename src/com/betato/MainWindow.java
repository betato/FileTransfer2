package com.betato;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;

	public MainWindow() {
		setUpControls();
		initListeners();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(mainPanel);
	}

	JPanel mainPanel = new JPanel(new MigLayout());

	private void setUpControls() {
		
	}

	private void initListeners() {
		
	}
	
	public void start() {
		new ServerManager(3457, "");

		try {
			Thread.sleep(1000);
			new TCPClient("127.0.0.1", 3457, "a.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		setVisible(true);
	}

}

package com.pallanet.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnection extends Connection implements Runnable {



	@Override
	public void createConnection(Socket accept) throws IOException {
		this.connection = accept;
		out = new DataOutputStream(connection.getOutputStream());
		in = new DataInputStream(connection.getInputStream());
	}

	@Override
	public void run() {
		try {
			ServerSocket server = new ServerSocket(5060);
			createConnection(server.accept());
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

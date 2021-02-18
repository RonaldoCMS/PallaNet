package com.pallanet.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public abstract class Connection implements Runnable {
    protected Socket connection;
	protected DataOutputStream out;
	protected DataInputStream in;

	public Connection() {
		new Thread(this).run();
	}

    public DataOutputStream getOut() {
		return out;
	}

	public void setOut(DataOutputStream out) {
		this.out = out;
	}

	public DataInputStream getIn() {
		return in;
	}

	public void setIn(DataInputStream in) {
		this.in = in;
	}

    abstract public void createConnection(Socket accept) throws IOException;

    
	public Socket getConnessione() {
		return connection;
	}
}

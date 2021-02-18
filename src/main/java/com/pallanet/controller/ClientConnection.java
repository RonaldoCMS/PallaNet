package com.pallanet.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ClientConnection extends Connection {

    @Override
    public void createConnection(Socket accept) throws IOException {
        connection = new Socket("localhost", 5060);
        out = new DataOutputStream(connection.getOutputStream());
        in = new DataInputStream(connection.getInputStream()); 
    }

    @Override
    public void run() {
        try {
            createConnection(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

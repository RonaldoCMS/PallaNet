package com.pallanet.view;

import javax.swing.JFrame;

import com.pallanet.controller.Connection;

public class HomeView extends JFrame {

    Connection connection;

    public HomeView(String title, Connection connection) {
        super(title);
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.connection = connection;
    }
}

package com.pallanet.view;

import java.awt.Container;

import com.pallanet.controller.ClientConnection;
import com.pallanet.view.animation.Animation;
import com.pallanet.view.animation.ClientAnimation;

public class HomeClientView extends HomeView {
    
    public HomeClientView() {
        super("Pallanet - Client", new ClientConnection());
        Container contenitore = this.getContentPane();
		Animation pan = new ClientAnimation(connection, contenitore.getSize());
		contenitore.add(pan);
    }
}

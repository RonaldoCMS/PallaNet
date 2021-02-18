package com.pallanet.view;

import com.pallanet.controller.ServerConnection;
import com.pallanet.view.animation.Animation;
import com.pallanet.view.animation.ServerAnimation;

public class HomeServerView extends HomeView {

    public HomeServerView() {
        super("Pallanet - Server", new ServerConnection());
        
        Animation pan = new ServerAnimation(connection, this.getSize());
		this.add(pan);
    }
    
}

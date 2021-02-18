package com.pallanet.view.animation;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.pallanet.controller.Connection;

public class ClientAnimation extends Animation {

    public ClientAnimation(Connection connection, Dimension dimension) {
        super(connection, dimension);
    }

    @Override
    protected void movement() {
        if (!right) {
			xBall -= moving;
			if (xBall < 0) {
				ballPresence = false;
				comunication = false;
				try {
					connection.getOut().writeBoolean(bottom);
					connection.getOut().writeInt(yBall);
					comunication = false;
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, e.toString());
					System.exit(-1);
				}
			}
		}

		else {
			if (xBall >= 500) {
				right = false;
				xBall -= moving;
			} else {
				xBall += moving;
			}
		}
    }

	@Override
	protected void reset() {
		boolean direzione = false;
		int y = 0;
		try {
			direzione = connection.getIn().readBoolean();
			y = connection.getIn().readInt();
			bottom = direzione;
			right = true;
			yBall = y;
			xBall = 0;
			ballPresence = true;
		} catch(Exception e2) {
			JOptionPane.showMessageDialog(null, e2.toString());
			System.exit(-1);
		}
	}
    
}

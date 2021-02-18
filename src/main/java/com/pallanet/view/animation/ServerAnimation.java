package com.pallanet.view.animation;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.pallanet.controller.Connection;

public class ServerAnimation extends Animation {

	public ServerAnimation(Connection connection, Dimension dimension) {
		super(connection, dimension);
	}

	@Override
	protected void movement() {
		if (right) {
			if ((!comunication) && (xBall > (this.getWidth() - diametroPallina))) {
				try {
					connection.getOut().writeBoolean(bottom);
					connection.getOut().writeInt(yBall);
					comunication = true;
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, e.toString());
					System.exit(-1);
				}

			} else {
				xBall += moving;
				if (xBall > this.getWidth()) {
					ballPresence = false;
					comunication = false;
				}
			}
		}
		else {
			if(xBall <= 0) {
				right = true;
				xBall += moving;
			}
			else {
				xBall -= moving;
			}
		}
	}

	@Override
	protected void reset() {
		boolean direction = false;
			int y = 0;
			try {
				direction = connection.getIn().readBoolean();
				y = connection.getIn().readInt();
				bottom = direction;
				right = false;
				yBall = y;
				xBall = this.getWidth();
				ballPresence = true;
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e2.toString());
				System.exit(-1);
			}
	}
}
package com.pallanet.view.animation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;


import com.pallanet.controller.Connection;

public abstract class Animation extends JPanel implements ActionListener {

	protected Connection connection;
	protected Dimension dimension;
	private Image virtualBuffer;
	private Graphics offScreen;
	private Timer timer;
	protected int xBall;
	protected int yBall;
	protected int diametroPallina;
	protected int moving;
	private int timerDelay;
	protected boolean right;
	protected boolean bottom;
	protected boolean ballPresence;
	protected boolean comunication;

	public Animation(Connection connection, Dimension dimension) {
		super();
		this.connection = connection;
		this.setSize(dimension);

		right = true;
		bottom = true;
		ballPresence = true;
		comunication = false;

		xBall = 0;
		yBall = 0;
		diametroPallina = 40;
		moving = 3;
		timerDelay = 10;

		timer = new Timer(timerDelay, this);
		timer.start();

	}

	public void update(Graphics g) {
		paint(g);
	}

	public void paint(Graphics g) {
		super.paint(g);

		virtualBuffer = createImage(getWidth(), getHeight());
		offScreen = virtualBuffer.getGraphics();
		Graphics2D screen = (Graphics2D) g;
		offScreen.setColor(new Color(254, 138, 22));

		if (ballPresence) {
			offScreen.fillOval(xBall, yBall, diametroPallina, diametroPallina);
		}

		screen.drawImage(virtualBuffer, 0, 0, this);
		offScreen.dispose();
	}

	abstract protected void movement();
	abstract protected void reset();

	public void actionPerformed(ActionEvent e) {

		if (ballPresence) {
			presence();
			movement();
		} else {
			reset();
		}
		repaint();
	}

	private void presence() {
		if (bottom) {
			if (yBall > (this.getHeight() - diametroPallina)) {
				bottom = false;
				yBall -= moving;
			} else {
				yBall += moving;
			}
		} else {
			if (yBall <= 0) {
				bottom = true;
				yBall += moving;
			} else {
				yBall -= moving;
			}
		}
	}


}

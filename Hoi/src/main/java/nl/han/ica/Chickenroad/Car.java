package nl.han.ica.Chickenroad;

import processing.core.PImage;

public class Car extends Obstacle {
	private boolean directionRight;
	private int speed;
	private PImage sprite;
	private Chicken_Road app;
	
	// Timer variables
	private int delay = 30;
	private long prevTime = 0;
	
	public Car(Chicken_Road app, boolean directionRight, int speed, int posY) {
		this.app = app;
		this.prevTime = System.currentTimeMillis() - delay;
		this.speed = speed;
		this.posY = posY;
		this.directionRight = directionRight;
		
		if (directionRight) {
			sprite = app.loadImage("car_" + decideColor() + "autoR.png"); 
			posX = (int)app.random(-200, 0);
		} else {
			sprite = app.loadImage("car_" + decideColor() + "autoL.png");
			posX = (int)app.random(app.width, app.width + 200);
		}
	}
	
	@Override
	public void draw() {
		app.image(sprite, posX, posY, app.getTileSize(), app.getTileSize());
	}
	
	@Override
	public void move() {
		long curTime = System.currentTimeMillis();
		
		// Check delay
		if ((curTime - prevTime) >= delay) {
			prevTime = curTime;
			// Move left or right
			if (directionRight) {
				
				posX += speed;
				
				if (posX > app.width + app.getTileSize()) {
					posX = (int)app.random(-200, 0);
				}
			} else {
				posX -= speed;

				if (posX < 0 - app.getTileSize()) {
					posX = (int)app.random(app.width, app.width + 200);
				}
			}
		}
	}

	/**
	 * @return The color of the car as a String
	 */
	private String decideColor() {
		int num = (int)app.random(0, 2);
		
		if (num == 0) {
			return "blue";
		} else {
			return "red";
		}
	}
}

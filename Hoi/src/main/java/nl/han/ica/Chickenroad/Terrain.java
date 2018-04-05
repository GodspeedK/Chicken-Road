package nl.han.ica.Chickenroad;

import processing.core.PApplet;
import processing.core.PImage;

public abstract class Terrain extends PApplet {
	protected int posY;
	protected Chicken_Road app;
	protected PImage texture;
	protected boolean directionRight;
	
	/*
	 * @return posY - The Y position
	 */
	public int getY() {
		return posY;
	}
	
	/*
	 * Draws the terrain using the texture defined in the child constructors
	 */
	public void draw() {
		for (int i=0; i < app.width; i+= app.getTileSize()) {
			app.fill(255);
			app.image(texture, i, posY, app.getTileSize(), app.getTileSize());
		}
	}
	
	public abstract Obstacle getObstacle();
	public abstract void spawnObstacle();
	public abstract void moveObstacles();
	public abstract void drawObstacles();
}

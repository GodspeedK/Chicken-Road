package nl.han.ica.Chickenroad;

public abstract class Obstacle {
	protected float posX;
	protected float posY;
	
	/*
	 * @return posX - The X position
	 */
	public float getX() {
		return posX;
	}
	
	/*
	 * @return posY - The Y position
	 */
	public float getY() {
		return posY;
	}
	
	public abstract void draw();
	public abstract void move();
}

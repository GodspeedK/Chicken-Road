package nl.han.ica.chickenroad;

public class Safezone extends Terrain {

	public Safezone(int tileY, Chicken_Road app) {
		super.posY = tileY * 100;
		super.app = app;
		super.texture = app.loadImage(""); voeg afbeelding toe
	}


	@Override
	public void spawnObstacle() {

	}


	@Override
	public void moveObstacles() {

	}

	/*
	 * @return null
	 */
	@Override
	public Obstacle getObstacle() {
		return null;
	}

	@Override
	public void drawObstacles() {

	}

}

package nl.han.ica.chickenroad;

public class Road extends Terrain {
	
	private Obstacle obstacle;

	public Road(int tileY, Chicken_Road app) {
		super.posY = tileY * 100;
		super.app = app;
		super.texture = app.loadImage(""); vind afbeelding
		
		// Randomly decide whether we go left or right
		int num = (int)app.random(0, 2);
		
		if (num == 0) {
			super.directionRight = true;
		} else {
			super.directionRight = false;
		}
	}
	
	@Override
	public void moveObstacles() {
		if (hasObstacle()) {
			obstacle.move();
		}
	}
	
	@Override
	public void drawObstacles() {
		if (hasObstacle()) {
			obstacle.draw();
		}
	}
	

	@Override
	public void spawnObstacle() {
		if (!hasObstacle()) {
			obstacle = new Car(app, directionRight, 10 + app.level, posY);
		}
	}
	
	/*
	 * @return Whether we have an obstacle
	 */
	private boolean hasObstacle() {
		return obstacle != null;
	}
	
	/*
	 * @return obstacle - The obstacle object
	 */
	@Override
	public Obstacle getObstacle() {
		return obstacle;
	}
}

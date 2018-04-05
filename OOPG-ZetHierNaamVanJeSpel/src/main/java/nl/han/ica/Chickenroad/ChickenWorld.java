package nl.han.ica.chickenroad;

import java.util.ArrayList;

public class ChickenWorld {
	private ArrayList<Terrain> terrains;
	private ArrayList<IPickups> eggs;
	private Chicken_Road app;
	private int layers;
	private LevelScreen lvl;
	
	public ChickenWorld(Chicken_Road app, Player player) {
		this.layers = app.height / 100;
		this.terrains = new ArrayList<Terrain>(layers);
		this.eggs = new ArrayList<IPickups>(3);
		
		// Initial values
		for (int i=0; i < layers; i++) {
			terrains.add(null);
		}
		
		for (int i=0; i < 3; i++) {
			eggs.add(null);
		}
		
		this.app = app;
		
		createTerrain();
	}
	
	/**
	 * Draws all of the terrain stored in the arraylist
	 */
	public void drawTerrain() {
		for (int i=0; i < layers; i++) {
			Terrain t = terrains.get(i);
			if (t != null) {
				t.draw();
				t.moveObstacles();
				t.spawnObstacle();
			}
		}
	}
	
	/**
	 * Draws the obstacles of the terrain. This is seperated from terrain so we have more control over the draw order.
	 */
	public void drawObstacles() {
		for (int i=0; i < layers; i++) {
			Terrain t = terrains.get(i);
			if (t != null) {
				t.drawObstacles();
			}
		}
	}
	
	/**
	 * Draws the pickups
	 */
	public void drawPickups() {

		for (int i=0; i < eggs.size(); i++) {
			Egg e = (Egg) eggs.get(i);
			if (e != null) {
				e.draw();
			}
		}
		
	}
	
	/**
	 * Draws the stage screen if it's valid
	 */
	public void drawStageScreen() {
		if (isStageScreenValid()) {
			lvl.draw();
		}
	}
	
	/**
	 * Creates the terrain of a new stage
	 */
	public void createTerrain() {
		// Increase the stage
		app.level++;
		app.score+= 1000;
		
		// Show stage screen for 3 seconds
		lvl = new LevelScreen(app, 3000);
		
		// First and last tiles are safe zones
		terrains.set(0, new Safezone(0, app));
		terrains.set(layers - 1, new Safezone(layers -1, app));
		
		// The other tiles are other dangerous terrain
		for (int i=1; i < layers - 1; i++) {
			terrains.set(i, new Road(i, app));
		}
		
		// Create pickups
		createEggs();
	}
	
	/**
	 * Fills the pickups arraylist with coins
	 */
	private void createEggs() {
		int amount = (int)app.random(5, 9);
		eggs.clear();
		
		for (int i=0; i <= amount; i++) {
			int x = (int)app.random(0, app.width);
			int y = (int)app.random(0, app.height);
			eggs.add(new Egg(app, x, y, 30));
		}
	}
	
	/**
	 * Returns the arraylist of coins
	 * @return coins - The arraylist of coins
	 */
	public ArrayList<IPickups> getEggs() {
		return eggs;
	}
	
	/**
	 * Checks if the stage screen object has been made yet
	 * @return Whether the stage screen object has been made yet
	 */
	private boolean isStageScreenValid() {
		return lvl != null;
	}
	
	/**
	 * Returns the arraylist of terrain
	 * @return terrains - The arraylist of the terrain
	 */
	public ArrayList<Terrain> getTerrains() {
		return terrains;
	}
}

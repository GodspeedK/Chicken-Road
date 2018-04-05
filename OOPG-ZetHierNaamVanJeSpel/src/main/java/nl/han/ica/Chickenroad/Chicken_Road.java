/* Namen: Emerson & Merijn
 * Titel: OOPD Eindopdracht 'Chicken Road'
 * Datum: 29-03-2018
 * Course: OOPD
 * Docent: Meron Brouwer
 */

package nl.han.ica.Chickenroad;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import processing.core.PApplet;

public class Chicken_Road extends PApplet{
	
	// General variables
	private int screenWidth 		= 800;
	private int screenHeight 		= 600;
	private int tileSize 			= 100;
	private int state				= 1; // 1 = start screen, 2 = playing, 3 = end screen
	private boolean drawScoreboard	= false;
	
	// Objects
	private ChickenWorld world;
	private Player player;
	private StartScreen startScreen;
	private EndScreen endScreen;
	private ScoreBoard scoreBoard;
	
	// Statistics
	public int level = 0;
	public int score = -1000;
	
	public static void main(String[] args) {
		PApplet.main(new String[]{"nl.han.ica.Chickenroad.Chicken_Road"});
	}
	
	public void settings() {
		size(screenWidth, screenHeight);
	}
	
    @Override
    public void setup() {
        
		startScreen = new StartScreen(this);
		endScreen = new EndScreen(this);
		scoreBoard = new ScoreBoard(this);
		player = new Player(50, 3, this);
		world = new ChickenWorld(this, player);

    }
    
    
    private void createObjects() {
    }
    
	public void draw() {
		switch(state) {
			case 1: // Start screen
				startScreen();
			break;
			
			case 2: // Game
				playScreen();
			break;
			
			case 3: // End screen
				endScreen();
			break;
		}
	}
	
	/**
	 * Draws the start screen
	 */
	private void startScreen() {
		startScreen.draw();
	}
	
	/**
	 * Draws the gameplay
	 */
	private void playScreen() {
		world.drawTerrain();
		//world.drawPickups();
		world.drawObstacles();
		//player.draw();
		world.drawStageScreen();
		if (drawScoreboard) {
			scoreBoard.draw();
		}
	}
	
	/**
	 * Draws the end screen
	 */
	private void endScreen() {
		endScreen.draw();
	}
	
	/**
	 * Called whenever a key is pressed
	 */
	public void keyPressed() {
		switch(state) {
		case 1: // Start screen
			startScreen.checkChange();
		break;
		
		case 2: // Gameplay
			drawScoreboard = true;
			player.move();
		break;
		
		case 3: // End screen
			// unused
		break;
		}
	}
	
	/**
	 * Returns the tile size
	 * @return tileSize - The size of tiles
	 */
	public int getTileSize() {
		return tileSize;
	}
	
	/**
	 * Returns the world object
	 * @returns world - The world object
	 */
	public ChickenWorld getWorld() {
		return world;
	}
	
	/**
	 * Sets the state
	 * @param state - The new state
	 */
	public void setState(int state) {
		this.state = state;
	}
	
    
    public void update() {
    }

	
	public void setupGame() {
		// TODO Auto-generated method stub
		
	}
    
}
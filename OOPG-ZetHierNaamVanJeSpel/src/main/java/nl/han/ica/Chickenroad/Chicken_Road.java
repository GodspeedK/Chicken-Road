/* Namen: Emerson & Merijn
 * Titel: OOPD Eindopdracht 'Chicken Road'
 * Datum: 29-03-2018
 * Course: OOPD
 * Docent: Meron Brouwer
 */

package nl.han.ica.chickenroad;

import com.sun.prism.image.ViewPort;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.FilePersistence;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.IPersistence;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileMap;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileType;
import nl.han.ica.OOPDProcessingEngineHAN.View.EdgeFollowingViewport;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import nl.han.ica.waterworld.Player;
import nl.han.ica.waterworld.Swordfish;
import nl.han.ica.waterworld.tiles.BoardsTile;
import processing.core.PApplet;

public class Chicken_Road extends GameEngine{
	
	// General variables
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
		PApplet.main(new String[]{"\"nl.han.ica.chicken_road.Chicken_Road\""});
	}
	
    @Override
    public void setupGame() {

        int worldWidth=1204;
        int worldHeight=903;
        
		startScreen = new StartScreen(this);
		endScreen = new EndScreen(this);
		scoreBoard = new ScoreBoard(this);
		
		createViewWithoutViewport(worldWidth, worldHeight);

    }
    
    private void createViewWithoutViewport(int screenWidth, int screenHeight) {
        View view = new View(screenWidth,screenHeight);
        view.setBackground(loadImage("src/main/java/nl/han/ica/waterworld/media/background.jpg")); afbeelding

        setView(view);
        size(screenWidth, screenHeight);
    }
    
    private void createObjects() {
		player = new Player(this, 300, 540, 18, tileSize);
		world = new ChickenWorld(this, player);
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
		world.drawPickups();
		world.drawObstacles();
		player.draw();
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
	
    @Override
    public void update() {
    }
    
}
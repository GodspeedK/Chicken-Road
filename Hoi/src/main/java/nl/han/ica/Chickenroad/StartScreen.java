package nl.han.ica.Chickenroad;

import processing.core.PImage;

public class StartScreen extends Screen {

	private PImage background;
	
	public StartScreen(Chicken_Road app) {
		super(app);
		background = app.loadImage("src/main/java/nl/han/ica/Chickenroad/media/StartMenu.png");
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void draw() {
		app.textSize(32);
		app.fill(255);
		app.image(background, 0, 0, app.width, app.height);
		app.textAlign(app.CENTER);
		app.text("Press ENTER to start", app.width / 2, app.height - 50);
		app.textAlign(app.CORNER);
	}
	
	/*
	 * Checks if the game should start
	 */
	@SuppressWarnings("static-access")
	public void checkChange() {
		if (app.keyCode == app.ENTER) {
			app.setState(2);
		}
	}
}

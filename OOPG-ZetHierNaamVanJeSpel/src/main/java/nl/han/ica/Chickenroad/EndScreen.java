package nl.han.ica.chickenroad;

import processing.core.PImage;

public class EndScreen extends Screen{
	
	private PImage background;


	public EndScreen(Chicken_Road app) {
		super(app);
		background = app.loadImage("gameover.png");
	}

	@SuppressWarnings("static-access")
	@Override
	public void draw() {
		app.textSize(32);
		app.fill(255);
		app.image(background, 0, 0, app.width, app.height);
		app.textAlign(app.CENTER);
		app.text("You died! Score = " + app.score, app.width / 2, (int)(app.height * 0.08));
		app.textAlign(app.CORNER);
	}
}

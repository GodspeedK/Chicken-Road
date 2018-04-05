package nl.han.ica.chickenroad;

public class ScoreBoard extends Screen {
	
	public ScoreBoard(Chicken_Road app){
		super(app);
	}

	@SuppressWarnings("static-access")
	@Override
	public void draw() {
		if ((app.keyCode != app.TAB) && (app.keyCode != app.LEFT)
				&& (app.keyCode != app.RIGHT) && (app.keyCode != app.UP) && 
					(app.keyCode != app.DOWN)) {
			app.textSize(32);
			app.fill(255, 0, 0, 255);
			app.rect(50, 50, app.width-100, 220);
		 	app.fill(255);
		 	app.rect(60, 60, app.width-120, 200);
		 	app.fill(0);
		 	app.text("Scoreboard", 80, 100);
		 	app.text("Score: " + app.score, 80, 150);			  
		 	app.text("Stage: " + app.level, 80, 200);
		}
	}
}

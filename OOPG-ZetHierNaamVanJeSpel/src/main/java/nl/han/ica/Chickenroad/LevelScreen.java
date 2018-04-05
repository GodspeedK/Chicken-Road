package nl.han.ica.Chickenroad;


public class LevelScreen extends Screen {
	private long prevTime;
	private int interval;
	private boolean isActive;
	
	/*
	 * @param millis - The amount of milliseconds that the stage screen should stay active
	 */
	public LevelScreen(Chicken_Road app, int millis) {
		super(app);
		this.prevTime = app.millis();
		this.interval = millis;
		setActive(true);
	}
	
	@Override
	public void draw() {
		// If this screen is active
		if (getActive()) {
			// Draw transparent black rectangle
			app.fill(0, 0, 0, 100);
			app.rect((float)(0), (float)(app.height * 0.1), (float)(app.width), (float)(app.height * 0.15));
			app.fill(255, 255, 255);
			app.textSize(24);
			app.text("Level " + app.level, (float)(app.width * 0.45), (float)(app.height * 0.17));
		}
		checkTime();
	}
	
	public boolean getActive() {
		return isActive;
	}
	
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	private void checkTime() {
		long curTime = app.millis();
		
		// Check delay
		if (curTime - prevTime >= interval) {
			prevTime = curTime;
			setActive(false);
		}
	}
	
	public float timeLeft() {
		return app.millis() - prevTime;
	}
	
}

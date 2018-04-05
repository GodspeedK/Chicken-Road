package nl.han.ica.Chickenroad;

public abstract class Screen {
	protected Chicken_Road app;
	
	public Screen(Chicken_Road app){
		this.app = app;
	}
	
	public abstract void draw();
}

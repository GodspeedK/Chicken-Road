package nl.han.ica.Chickenroad;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

import java.util.List;
import java.util.Random;

public class Car extends AnimatedSpriteObject implements ICollidableWithGameObjects{
	private Chickenroad app;
    private boolean Collison;
    private int xspeed;

	public Car(Chickenroad app,int xspeed,int x, int y)   {
		super(new Sprite("src/main/java/nl/han/ica/Chickenroad/media/car.png"), 1);
		this.app=app;
		this.xspeed = xspeed;
		setxSpeed(this.xspeed);
		super.y = y;
		super.x = x;
	}

    public boolean isCollison() {
        return Collison;
    }

	@Override
	public void update() {;
        Collison = false;
        if (x == -width) {
            setX(app.width);
        }
    }

    @Override
    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
        Collison = true;
    }
}

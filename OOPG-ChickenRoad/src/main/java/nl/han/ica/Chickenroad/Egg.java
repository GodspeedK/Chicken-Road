package nl.han.ica.Chickenroad;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

import java.util.List;

public class Egg extends AnimatedSpriteObject implements ICollidableWithGameObjects{
    private static final String SPRITEPATH = "src/main/java/nl/han/ica/Chickenroad/media/egg.png";
    private static final int SPRITE_FRAMES = 1;
    private boolean Collision;


    public Egg(int x, int y) {
        super(new Sprite(SPRITEPATH), SPRITE_FRAMES);
        super.x = x;
        super.y = y;
    }

    @Override
    public void update() {
        Collision = false;
    }

    @Override
    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
        Collision = true;
    }

    public boolean isCollision() {
        return Collision;
    }
}




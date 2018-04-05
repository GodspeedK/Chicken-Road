package nl.han.ica.Chickenroad;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Egg extends AnimatedSpriteObject{
    private static final String SPRITEPATH = "src/main/java/nl/han/ica/Chickenroad/media/egg.png";
    private static final int SPRITE_FRAMES = 1;


    public Egg(int x, int y) {
        super(new Sprite(SPRITEPATH), SPRITE_FRAMES);
        super.x = x;
        super.y = y;
    }

    @Override
    public void update() {

    }

    public boolean isColliding(AnimatedSpriteObject spriteObject) {
        return (this.x == spriteObject.getX() && this.y == spriteObject.getY());
    }
}




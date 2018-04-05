package nl.han.ica.Chickenroad;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Player extends AnimatedSpriteObject {
    private int size;
    private int levens;
    private Chicken_Road app;
    private boolean walk = false;

    public Player(int size, int levens, Chicken_Road app) {
        super(new Sprite("src/main/java/nl/han/ica/Chickenroad/media/kipwit.png"), 12);
        this.size = size;
        this.levens = levens;
        this.app = app;

        setCurrentFrameIndex(1);
    }

    @Override
    public void update() {
        if (getX()<=0) {
            setX(0);
        }
        if (getY()<=0) {
            setY(0);
        }
        if (getX()>=app.getWidth()-size) {
            setxSpeed(0);
            setX(app.getWidth() - size);
        }
        if (getY()>=app.getHeight()-size) {
            setySpeed(0);
            setY(app.getHeight() - size);
        }

    }
    @Override
    public void keyPressed(int keyCode, char key) {
            if (keyCode == app.LEFT) {
                x = x - size;
                setCurrentFrameIndex((int) app.random(3, 6));
            }
            if (keyCode == app.UP) {
                y = y - size;
                setCurrentFrameIndex((int) app.random(9, 12));
            }
            if (keyCode == app.RIGHT) {
                x = x + size;
                setCurrentFrameIndex((int) app.random(6, 9));
            }
            if (keyCode == app.DOWN) {
                y = y + size;
                setCurrentFrameIndex((int) app.random(0, 3));
            }
    }
}


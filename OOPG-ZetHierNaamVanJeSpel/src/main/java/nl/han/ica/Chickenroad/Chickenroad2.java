package nl.han.ica.Chickenroad;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.TextObject;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import processing.core.PApplet;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

@SuppressWarnings("serial")
public class Chickenroad extends GameEngine {

    private static final int AMOUNTOGEGGS = 10;
    private static final int CELLSWIDTH = 24;
    private static final int CELLSHEIGHT = 18;
    private static final int CELLSIZE = 50;
    private int eggsPickedUp;
    private Player speler;
    private TextObject dashboardText;
    private CopyOnWriteArrayList<Egg> eggs;

    public static void main(String[] args) {
        PApplet.main(new String[]{"nl.han.ica.Chickenroad.Chickenroad"});
    }

    @Override
    public void setupGame() {

        int worldWidth = 1200;
        int worldHeight = 900;
        eggs = new CopyOnWriteArrayList<>();
        createViewWithoutViewport(worldWidth, worldHeight);
        createDashboard(width);
        setupObject();
        createObjects();

    }

    private void createViewWithoutViewport(int screenWidth, int screenHeight) {
        View view = new View(screenWidth, screenHeight);
        view.setBackground(loadImage("src/main/java/nl/han/ica/Chickenroad/media/kfc.png"));
        setView(view);
        size(screenWidth, screenHeight);
    }

    @Override
    public void update() {
        for (Egg egg :
                eggs) {
            if (egg.isColliding(speler)) {
                increaseEggsPickedUp();
                this.deleteGameObject(egg);
                eggs.remove(egg);
            }
        }
    }

    private void setupObject() {
        Random random = new Random();
        for (int i = 0; i < AMOUNTOGEGGS; i++) {
            eggs.add(new Egg(random.nextInt(CELLSWIDTH) * CELLSIZE, random.nextInt(CELLSHEIGHT) * CELLSIZE));
        }
        speler = new Player(50, 3, this);
    }


    private void createObjects() {
        addGameObject(speler, width / 2, height);
        for (Egg egg :
                eggs) {
            addGameObject(egg);
        }
    }

    private void createDashboard(int dashboardWidth) {
        Dashboard dashboard = new Dashboard(100, 100, dashboardWidth, 100);
        dashboardText = new TextObject("", 20);
        dashboard.addGameObject(dashboardText);
        addDashboard(dashboard);
    }

    private void refreshDasboardText() {
        dashboardText.setText("Score: " + eggsPickedUp);
    }


    private void increaseEggsPickedUp() {
        eggsPickedUp++;
        refreshDasboardText();
    }
}
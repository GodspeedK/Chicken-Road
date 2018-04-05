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

    private static final int AMOUNTOGEGGS = 5;
    private static final int CELLSWIDTH = 24;
    private static final int CELLSHEIGHT = 18;
    private static final int CELLSIZE = 50;
    private int eggsPickedUp;
    private Player player;
    private TextObject dashboardText;
    private CopyOnWriteArrayList<Egg> eggs;
    private CopyOnWriteArrayList<Car> cars;

    public static void main(String[] args) {
        PApplet.main(new String[]{"nl.han.ica.Chickenroad.Chickenroad"});
    }

    @Override
    public void setupGame() {

        int worldWidth = 1200;
        int worldHeight = 900;
        eggs = new CopyOnWriteArrayList<>();
        cars = new CopyOnWriteArrayList<>();
        createViewWithoutViewport(worldWidth, worldHeight);
        createDashboard(width);
        setupObject();
        createPlayer();
        createGameObjects();

    }

    private void createViewWithoutViewport(int screenWidth, int screenHeight) {
        View view = new View(screenWidth, screenHeight);
        view.setBackground(loadImage("src/main/java/nl/han/ica/Chickenroad/media/grass.png"));
        setView(view);
        size(screenWidth, screenHeight);
    }

    @Override
    public void update() {
            for (Egg egg :
                    eggs) {
                if(!egg.isCollision())  {
                    for (Car car :
                            cars) {
                        if(car.isCollison() && player.isCollision())    {
                            System.exit(1);
                        }
                    }
                }else if (egg.isCollision()) {
                        increaseEggsPickedUp();
                        this.deleteGameObject(egg);
                        eggs.remove(egg);
                    }
                }
        if(eggs.isEmpty())  {
            createNewEggs();
        }
    }

    private void setupObject() {
        for (int i = 0; i < AMOUNTOGEGGS; i++) {
            cars.add(new Car(this,-4,width,i * 200));
        }
        player = new Player(50, 3, this);
    }

    private void createNewEggs()   {
        Random random = new Random();
        for (int i = 0; i < AMOUNTOGEGGS; i++) {
            eggs.add(new Egg(random.nextInt(CELLSWIDTH) * CELLSIZE, random.nextInt(CELLSHEIGHT) * CELLSIZE));
        }
        for (Egg egg :
                eggs) {
            addGameObject(egg);
        }
    }

    private void createPlayer() {
        addGameObject(player, width / 2, height);
    }

    private void createGameObjects() {

        for (Egg egg :
                eggs) {
            addGameObject(egg);
        }
        for (Car car :
                cars) {
            addGameObject(car);
        }
    }

    private void createDashboard(int dashboardWidth) {
        Dashboard dashboard = new Dashboard(0, 15, dashboardWidth, 100);
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
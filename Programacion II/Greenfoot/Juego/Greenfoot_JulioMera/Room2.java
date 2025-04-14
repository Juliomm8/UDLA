import greenfoot.*;

public class Room2 extends World
{
    private int score = GameState.score;
    private Hero hero;

    public Room2() {
        this("default");
    }

    public Room2(String spawnPoint) {
        super(1200, 800, 1);
        setBackground("room2_background.png");

        prepareWorld();
        spawnHero(spawnPoint);
        showScore();
        showHearts();
    }

    private void prepareWorld() {


        // Puerta para volver a Room1
        addObject(new Door("Room1"), 565, 120);
        
        addObject(new Dragon(), 850, 400); // Puedes ajustar la posición si lo necesitas

    }

    private void spawnHero(String spawnPoint)
    {
        hero = new Hero();

        switch (spawnPoint) {
            case "fromRoom1" -> addObject(hero, 570, 185); // aparece cerca de la puerta
            default -> addObject(hero, 570, 185); // posición por defecto
        }
    }

    private void showScore()
    {
        showText("Score: " + score, 100, 30);
    }

    public void showHearts()
    {
        removeObjects(getObjects(complete_heart.class));
    
        for (int i = 0; i < GameState.lives; i++) {
            addObject(new complete_heart(), 50 + i * 40, 70);
        }
    }


    public void addScore(int points)
    {
        score += points;
        GameState.score = score;
        showScore();
    }

    public void loseLife()
    {
        GameState.lives--;
        showHearts();
    
        if (GameState.lives <= 0) {
            hero.setDead();
        }
    }


    public boolean isGamePaused()
    {
        return false;
    }

    public void pauseGame()
    {
        // Pausar enemigos si los añades en Room2
    }
}

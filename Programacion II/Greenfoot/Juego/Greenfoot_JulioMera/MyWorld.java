import greenfoot.*;

/**
 * This class defines the game world, its size, and the objects it contains.
 * It handles score, player lives, enemy spawning, and the hero.
 */
public class MyWorld extends World
{
    private int score = 0;
    private int lives = 3;
    private Hero hero;
    private String selectedCharacter;
    private boolean gamePaused = false;

    private int totalEnemiesSpawned = 0;
    private int maxEnemies = 20;

    public MyWorld() {
        this("mage");
    }

    // Constructor with character selection
    public MyWorld(String character) {
        super(1200, 800, 1);
        selectedCharacter = character;

        prepareWorld();
        spawnHero();
        spawnEnemy();
        showScore();
        showHearts();
    }

    /**
     * Method to initialize decorative objects (optional).
     */
    private void prepareWorld() {
        // Add decorative objects here if needed
    }

    /**
     * Spawns an instance of the hero in the center of the world.
     */
    public void spawnHero() {
        if ("warrior".equals(selectedCharacter)) {
            hero = new Warrior(); // You need to create this class
        } else {
            hero = new Hero(); // Default: mage
        }
        addObject(hero, getWidth() / 2, getHeight() / 2);
    }

    /**
     * Creates an enemy at one of three predefined positions.
     */
    public void spawnEnemy() {
        Enemy_1 enemy = new Enemy_1();

        int spawnIndex = Greenfoot.getRandomNumber(3);
        int spawnX = 0;
        int spawnY = 0;

        switch (spawnIndex) {
            case 0: spawnX = 1200;  spawnY = 300; break;
            case 1: spawnX = 1200;  spawnY = 450; break;
            case 2: spawnX = 1200;  spawnY = 600; break;
        }

        addObject(enemy, spawnX, spawnY);
        totalEnemiesSpawned++;
    }

    /**
     * Called every game frame. 2% chance to spawn an enemy, up to a max limit.
     */
    public void act() {
        if (totalEnemiesSpawned < maxEnemies) {
            if (Greenfoot.getRandomNumber(100) < 2) {
                spawnEnemy();
            }
        }
    }

    /**
     * Adds points to the score and updates the display.
     */
    public void addScore(int points) {
        score += points;
        showScore();
    }

    /**
     * Displays the current score in the top-left corner.
     */
    private void showScore() {
        showText("Score: " + score, 100, 30);
    }

    /**
     * Displays heart icons based on current player lives.
     */
    public void showHearts() {
        removeObjects(getObjects(complete_heart.class));

        for (int i = 0; i < lives; i++) {
            complete_heart heart = new complete_heart();
            addObject(heart, 50 + i * 40, 70);
        }
    }

    /**
     * Reduces one life. If lives reach 0, the hero is removed and the game ends.
     */
    public void loseLife() {
        lives--;
        showHearts();

        if (lives <= 0) {
            hero.setDead();
        }
    }

    /**
     * Returns whether the game is paused.
     */
    public boolean isGamePaused() {
        return gamePaused;
    }

    /**
     * Pauses the game.
     */
    public void pauseGame() {
        gamePaused = true;
    }
}

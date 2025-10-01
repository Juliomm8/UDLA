import greenfoot.*;

public class Room1 extends World
{
    private Hero hero;
    private String selectedCharacter;
    private boolean gamePaused = false;

    private int totalEnemiesSpawned = 0;
    private int maxEnemies = 20;

    private int score = GameState.score;

    
    

    public Room1() {
        this("mage", "default");
    }

    public Room1(String character) {
        this(character, "default");
    }

    // NUEVO constructor que recibe punto de entrada
    public Room1(String character, String spawnPoint) {
        super(1200, 800, 1);
        setBackground("room1_background.png");

        if ("warrior".equals(character)) {
            showText("Character locked", getWidth() / 2, getHeight() / 2);
            Greenfoot.delay(100);
            Greenfoot.setWorld(new CharacterSelectWorld());
            return;
        }

        selectedCharacter = character;

        prepareWorld();
        spawnHero(spawnPoint);
        spawnEnemy();
        showScore();
        showHearts();
    }

    private void prepareWorld() {
        addObject(new Wall("wall_top_1.png"), 595, 80);
        addObject(new Wall("wall_top_2.png"), 586, 262);
        addObject(new Wall("wall_top_3.png"), 584, 176);

        addObject(new Wall("wall_bottom_1.png"), 835, 539);
        addObject(new Wall("wall_bottom_2.png"), 585, 635);
        addObject(new Wall("wall_bottom_3.png"), 233, 735);
        addObject(new Wall("wall_bottom_4.png"), 1069, 539);

        addObject(new Wall("wall_left.png"), 50, 400);
        addObject(new Wall("wall_right.png"), 1143, 310);

        // Puerta inferior
        addObject(new Door("Room2"), 953, 570);
    }

    // ✅ Nuevo spawnHero con lógica para punto de entrada
    public void spawnHero(String spawnPoint) {
        if ("warrior".equals(selectedCharacter)) {
            hero = new Warrior();
        } else {
            hero = new Hero();
        }

        switch (spawnPoint) {
            case "fromRoom2" -> addObject(hero, 953, 500); // justo en frente de la puerta
            default -> addObject(hero, 220, 180); // posición inicial por defecto
        }
    }

    public void spawnEnemy() {
        Enemy_1 enemy = new Enemy_1();

        int spawnIndex = Greenfoot.getRandomNumber(3);
        int spawnX = 1200;
        int spawnY = switch (spawnIndex) {
            case 0 -> 300;
            case 1 -> 450;
            default -> 600;
        };

        addObject(enemy, spawnX, spawnY);
        totalEnemiesSpawned++;
    }

    public void act() {
        if (totalEnemiesSpawned < maxEnemies && Greenfoot.getRandomNumber(100) < 2) {
            spawnEnemy();
        }
    }

    public void addScore(int points) {
        score += points;
        GameState.score = score;
        showScore();
    }

    private void showScore() {
        showText("Score: " + score, 100, 30);
    }

    public void showHearts() {
        removeObjects(getObjects(complete_heart.class));
    
        for (int i = 0; i < GameState.lives; i++) { // ✅ Usar GameState.lives en vez de una variable local
            addObject(new complete_heart(), 50 + i * 40, 70);
        }
    }


    public void loseLife()
    {
        GameState.lives--;
        showHearts();
    
        if (GameState.lives <= 0) {
            hero.setDead();
        }
    }


    public boolean isGamePaused() {
        return gamePaused;
    }

    public void pauseGame() {
        gamePaused = true;
    }
}

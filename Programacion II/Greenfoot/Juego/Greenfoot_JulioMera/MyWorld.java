import greenfoot.*;  

/**
 * Clase que define el mundo de juego, su tamaño y los objetos que contiene.
 * También maneja el spawn de enemigos.
 * 
 */
public class MyWorld extends World
{
    private int score = 0;

    public MyWorld()
    {
        super(1200, 800, 1);
        prepare();
        spawnHero(); // ✅ Solo uno
        spawnEnemy();
        showScore();
    }

    public boolean dentroDeLimites(int x, int y, int margen) {
        return x >= margen && x <= getWidth() - margen &&
               y >= margen && y <= getHeight() - margen;
    }

    private void prepare()
    {
        // Puedes agregar objetos al fondo aquí si quieres
    }

    public void spawnEnemy() {
        Enemy_1 enemy = new Enemy_1();
        int spawnIndex = Greenfoot.getRandomNumber(3);
        int spawnX = 0;
        int spawnY = 0;

        switch (spawnIndex) {
            case 0: spawnX = 1; spawnY = 450; break;
            case 1: spawnX = 1200; spawnY = 450; break;
            case 2: spawnX = 700; spawnY = 800; break;
        }

        addObject(enemy, spawnX, spawnY);
    }

    public void act() {
        if (Greenfoot.getRandomNumber(100) < 2) {
            spawnEnemy();
        }
    }

    public void spawnHero() {
        Hero hero = new Hero();
        addObject(hero, getWidth() / 2, getHeight() / 2);
    }

    public void addScore(int points) {
        score += points;
        showScore();
    }

    private void showScore() {
        showText("Score: " + score, 100, 30);
    }
}

import greenfoot.*;

/**
 * Clase que define el mundo de juego, su tamaño y los objetos que contiene.
 * Maneja el score, las vidas del jugador, el spawn de enemigos y del héroe.
 */
public class MyWorld extends World
{
    private int score = 0;
    private int lives = 3;
    private Hero hero;

    public MyWorld()
    {
        super(1200, 800, 1);
        prepare();          // Agrega decoraciones si se desea
        spawnHero();        // Coloca al jugador
        spawnEnemy();       // Crea el primer enemigo
        showScore();        // Score inicial
        showHearts();       // Vidas iniciales
    }

    /**
     * Verifica si una posición está dentro de los límites del mundo,
     * considerando un margen.
     */
    public boolean dentroDeLimites(int x, int y, int margen)
    {
        return x >= margen && x <= getWidth() - margen &&
               y >= margen && y <= getHeight() - margen;
    }

    /**
     * Método para inicializar decoraciones del mundo (opcional).
     */
    private void prepare()
    {
        // Puedes agregar objetos decorativos aquí si lo necesitas
    }

    /**
     * Agrega una instancia del héroe en el centro del mundo.
     */
    public void spawnHero()
    {
        hero = new Hero();
        addObject(hero, getWidth() / 2, getHeight() / 2);
    }

    /**
     * Crea un enemigo en una de tres posiciones predefinidas.
     */
    public void spawnEnemy()
    {
        Enemy_1 enemy = new Enemy_1();

        int spawnIndex = Greenfoot.getRandomNumber(3);
        int spawnX = 0;
        int spawnY = 0;

        switch (spawnIndex) {
            case 0: spawnX = 1;     spawnY = 450; break;
            case 1: spawnX = 1200;  spawnY = 450; break;
            case 2: spawnX = 700;   spawnY = 800; break;
        }

        addObject(enemy, spawnX, spawnY);
    }

    /**
     * Ejecutado en cada ciclo del mundo. 2% de probabilidad de spawnear un enemigo.
     */
    public void act()
    {
        if (Greenfoot.getRandomNumber(100) < 2) {
            spawnEnemy();
        }
    }

    /**
     * Suma puntos al score y actualiza el texto en pantalla.
     */
    public void addScore(int points)
    {
        score += points;
        showScore();
    }

    /**
     * Muestra el score en la esquina superior izquierda.
     */
    private void showScore()
    {
        showText("Score: " + score, 100, 30);
    }

    /**
     * Muestra corazones en pantalla según la cantidad de vidas actuales.
     */
    public void showHearts()
    {
        removeObjects(getObjects(complete_heart.class));

        for (int i = 0; i < lives; i++) {
            complete_heart heart = new complete_heart();
            addObject(heart, 50 + i * 40, 70);
        }
    }

    /**
     * Reduce una vida. Si llega a cero, elimina al jugador y detiene el juego.
     */
    public void loseLife()
    {
        lives--;
        showHearts();

        if (lives <= 0) {
            removeObject(hero);
            Greenfoot.stop(); // Puedes cambiar esto a un GameOver más adelante
        }
    }
}

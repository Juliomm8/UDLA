import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        prepare();
        spawnEnemy();
        
    }
    public boolean dentroDeLimites(int x, int y, int margen) {
    return x >= margen && x <= getWidth() - margen &&
           y >= margen && y <= getHeight() - margen;
    }
    private void prepare()
    {
    }
    
public void spawnEnemy() {
    Enemy_1 enemy = new Enemy_1();
    
    // Tres puntos de spawn
    int spawnIndex = Greenfoot.getRandomNumber(3); // Selecciona aleatoriamente entre 0, 1, 2
    int spawnX = 0;
    int spawnY = 0;
    
    if (spawnIndex == 0) {
        spawnX = 1; // Primer punto de spawn
        spawnY = 450;
    } else if (spawnIndex == 1) {
        spawnX = 1200; // Segundo punto de spawn
        spawnY = 450;
    } else if (spawnIndex == 2) {
        spawnX = 700; // Tercer punto de spawn
        spawnY = 800;
    }
    
    addObject(enemy, spawnX, spawnY); // Spawnea al enemigo en el punto seleccionado
}
public void act() {
    if (Greenfoot.getRandomNumber(100) < 2) { // 2% de probabilidad de spawn por ciclo
        spawnEnemy();
    }
}

}

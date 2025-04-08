import greenfoot.*;

/**
 * El nombre del héroe es "El Botánico Errante".
 * Este héroe se desplaza por el mundo y puede
 * disparar semillas para eliminar a los enemigos.
 * 
 * Controles:
 * - Flechas del teclado o WASD para moverse
 * - Barra espaciadora para disparar semillas
 * 
 * La clase Hero maneja la lógica de movimiento y disparo.
 * 
 * @author (Julio Mera)
 * @version (Abril 2025)
 */
public class Hero extends Actor
{
    private int shootCooldown = 0;
    private int speedMov = 3;
    private int cooldownTime = 20;
    private int baseSpeed = 2;
    private int runSpeed = 4;
    private int currentSpeed = 2;
    private int lastDirection = 0; 


    
    private GreenfootImage originalImage;
    private GreenfootImage mirroredImage;
    

    public Hero() {
        originalImage = getImage(); 
        mirroredImage = new GreenfootImage(originalImage);
        mirroredImage.mirrorHorizontally();
    }

    public void act()
    {
        movHero();
        shootSeed();

        if (shootCooldown > 0) {
            shootCooldown--;
        }
    }

public void movHero() {
    if (Greenfoot.isKeyDown("shift")) {
        currentSpeed = runSpeed;
    } else {
        currentSpeed = baseSpeed;
    }

    int newX = getX();
    int newY = getY();

    if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) {
        setImage(mirroredImage);
        newX -= currentSpeed;
        lastDirection = 180;
    }
    if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) {
        setImage(originalImage);
        newX += currentSpeed;
        lastDirection = 0;
    }
    if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")) {
        newY -= currentSpeed;
        lastDirection = 270;
    }
    if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")) {
        newY += currentSpeed;
        lastDirection = 90;
    }

    int margen = 100; // margen de seguridad para no salirse

    // Llama al método del mundo
    MyWorld mundo = (MyWorld)getWorld();
    if (mundo.dentroDeLimites(newX, newY, margen)) {
        setLocation(newX, newY);
    }
}



public void shootSeed() {
    if (shootCooldown > 0) return;

    boolean up = Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w");
    boolean down = Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s");
    boolean left = Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a");
    boolean right = Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d");

    int direction = -1;

    if (up && right) direction = 315;
    else if (up && left) direction = 225;
    else if (down && right) direction = 45;
    else if (down && left) direction = 135;
    else if (up) direction = 270;
    else if (down) direction = 90;
    else if (right) direction = 0;
    else if (left) direction = 180;
    else direction = lastDirection; // 🟢 Dispara en la última dirección si no hay movimiento

    if (Greenfoot.isKeyDown("space")) {
        SeedShot seed = new SeedShot();
        seed.setRotation(direction);

        // Posición desde la mano
        int offset = 16;
        double radians = Math.toRadians(direction);
        int dx = (int)(Math.cos(radians) * offset);
        int dy = (int)(Math.sin(radians) * offset);

        getWorld().addObject(seed, getX() + dx, getY() + dy);
        shootCooldown = cooldownTime;
    }
}

}

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
    private GreenfootImage originalImage;
    private GreenfootImage mirroredImage;
    private int speedMov = 2;

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
        if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) {
            setImage(mirroredImage);
            setLocation(getX() - speedMov, getY());
        }
        if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) {
            setImage(originalImage);
            setLocation(getX() + speedMov, getY());
        }
        if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - speedMov);
        }
        if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + speedMov);
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
    
        if (Greenfoot.isKeyDown("space") && direction != -1) {
            SeedShot seed = new SeedShot();
            seed.setRotation(direction);
            getWorld().addObject(seed, getX(), getY());
            shootCooldown = 15;
        }
}
}

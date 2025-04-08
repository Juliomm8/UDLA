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
    private int shootCooldown = 0; // tiempo de espera entre disparos

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
            setLocation(getX() - 3, getY());
        }
        if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) {
            setLocation(getX() + 3, getY());
        }
        if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - 3);
        }
        if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + 3);
        }
    }

    public void shootSeed() {
        if (shootCooldown > 0) return;

        int direction = -1;

        if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) {
            direction = 0;
        } else if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")) {
            direction = 90;
        } else if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) {
            direction = 180;
        } else if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")) {
            direction = 270;
        }

        if (Greenfoot.isKeyDown("space") && direction != -1) {
            SeedShot seed = new SeedShot();
            seed.setRotation(direction);
            getWorld().addObject(seed, getX(), getY());
            shootCooldown = 15;
        }
    }
}

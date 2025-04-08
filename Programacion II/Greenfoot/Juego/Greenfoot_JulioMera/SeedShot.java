import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SeedShot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SeedShot extends Actor
{
    /**
     * Act - do whatever the SeedShot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
 public void act()
    {
        move(8); // velocidad

        // Detectar colisión con enemigos primero
        if (isTouching(Enemy_1.class)) {
            removeTouching(Enemy_1.class);
            getWorld().removeObject(this);
            return; // detener ejecución del act() para evitar el error
        }

        // Luego verificar si llegó al borde
        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}

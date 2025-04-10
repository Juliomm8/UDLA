import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que maneja el comportamiento de las semillas disparadas por el héroe.
 */
public class SeedShot extends Actor
{
    /**
     * Act - hace que la semilla se mueva, detecte colisiones y se elimine si toca un enemigo o el borde del mundo.
     */
    public void act()
    {
        move(5); // velocidad de la semilla

        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}
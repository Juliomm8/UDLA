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
        move(8); // velocidad de la semilla

        // Detectar colisión con enemigos primero
        if (isTouching(Enemy_1.class)) {
            removeTouching(Enemy_1.class);  // Eliminar el enemigo al tocar la semilla
            getWorld().removeObject(this);  // Eliminar la semilla
            return; // Detener la ejecución del act() para evitar que siga haciendo más acciones
        }

        // Luego verificar si la semilla llegó al borde
        if (isAtEdge()) {
            getWorld().removeObject(this);  // Eliminar la semilla si sale del mundo
        }
    }
}
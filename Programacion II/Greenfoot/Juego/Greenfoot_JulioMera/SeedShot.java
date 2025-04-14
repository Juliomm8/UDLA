import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SeedShot extends Actor
{
    public void act()
    {
        move(5); // velocidad de la semilla

        // ✅ Detección de colisión con el Dragón
        if (isTouching(Dragon.class)) {
            Dragon dragon = (Dragon) getOneIntersectingObject(Dragon.class);
            if (dragon != null) {
                dragon.takeDamage(1); // Le baja un corazón
            }
            getWorld().removeObject(this); // Destruye la semilla
            return;
        }

        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}
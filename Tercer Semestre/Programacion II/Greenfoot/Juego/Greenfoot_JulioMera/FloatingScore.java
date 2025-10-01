import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FloatingScore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FloatingScore extends Actor
{
    private int life = 50; // Duración del texto (frames)

    public FloatingScore(int amount)
    {
        GreenfootImage img = new GreenfootImage("+" + amount, 24, Color.YELLOW, new Color(0,0,0,0));
        setImage(img);
    }

    public void act()
    {
        setLocation(getX(), getY() - 1); // Flota hacia arriba
        life--;

        if (life <= 0) {
            getWorld().removeObject(this);
        }
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FadeTransition here.
 * 
 * @author Julio Mera
 */
public class FadeTransition extends Actor
{
    private int alpha = 0;
    private boolean fading = false;
    private World nextWorld;

    public FadeTransition(World nextWorld)
    {
        this.nextWorld = nextWorld;
        GreenfootImage img = new GreenfootImage(1200, 800); // Tamaño del mundo
        img.setColor(Color.BLACK);
        img.fill();
        img.setTransparency(alpha);
        setImage(img);
    }

    public void startFade()
    {
        fading = true;
    }

public void act()
{
    if (fading) {
        alpha += 10;
        if (alpha >= 255) {
            alpha = 255; // <--- evita que se pase
            getImage().setTransparency(alpha);
            Greenfoot.setWorld(nextWorld);
        } else {
            getImage().setTransparency(alpha);
        }
    }
}

}

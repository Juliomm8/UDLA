import greenfoot.*;

public class LifePickup extends Actor
{
    public LifePickup()
    {
        GreenfootImage img = new GreenfootImage("heart.png");
        img.scale(18, 18); // un poco más pequeño que el corazón de HUD
        setImage(img);
    }

    public void act()
    {
        if (isTouching(Hero.class)) {
            Hero hero = (Hero) getOneIntersectingObject(Hero.class);
            if (hero != null) {
                hero.gainLife(); // le damos vida al héroe
            }
            getWorld().removeObject(this); // se destruye
        }
    }
}

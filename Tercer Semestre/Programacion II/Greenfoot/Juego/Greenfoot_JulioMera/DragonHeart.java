import greenfoot.*;

public class DragonHeart extends Actor
{
    private Dragon owner;

    public DragonHeart(Dragon owner)
    {
        this.owner = owner;
        
            GreenfootImage heart = new GreenfootImage("heart.png");
            heart.scale(12, 12); // Puedes probar con 10x10, 16x16, etc.
            setImage(heart);

    }

    public Dragon getOwner()
    {
        return owner;
    }

    public void act()
    {
        if (owner != null && getWorld() != null) {
            setLocation(owner.getX() + getXOffset(), owner.getY() - 80);
        }
    }

    private int getXOffset()
    {
        // Este valor será ajustado en Dragon cuando se agreguen los corazones
        return 0;
    }
}

import greenfoot.*;

public class SelectMageButton extends Actor
{
    public SelectMageButton()
    {
        setImage("select_mage.png"); // Imagen para el mago
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            MyWorld world = new MyWorld("mage");
            Greenfoot.setWorld(world);
        }
    }
}
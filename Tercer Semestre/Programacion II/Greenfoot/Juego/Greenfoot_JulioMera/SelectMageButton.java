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
            Room1 world = new Room1("mage");
            Greenfoot.setWorld(world);
        }
    }
}
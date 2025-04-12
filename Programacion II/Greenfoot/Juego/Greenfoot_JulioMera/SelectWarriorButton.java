import greenfoot.*;

public class SelectWarriorButton extends Actor
{
    public SelectWarriorButton()
    {
        setImage("select_warrior.png"); // Imagen para el guerrero
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            MyWorld world = new MyWorld("warrior");
            Greenfoot.setWorld(world);
        }
    }
}

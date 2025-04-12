import greenfoot.*;

public class RestartButton extends Actor
{
    public RestartButton()
    {
        setImage("restart.png"); // Usa una imagen de botón de reinicio
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
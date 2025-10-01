import greenfoot.*;

public class MainMenuButton extends Actor
{
    public MainMenuButton()
    {
        setImage("mainmenu.png"); // Asegúrate de tener esta imagen en /images
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new MainMenu());
        }
    }
}
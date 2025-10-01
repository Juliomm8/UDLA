import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartButton here.
 * 
 * @author Julio Mera

 */
public class StartButton extends Actor
{
    private boolean pressed = false;
    
    public StartButton()
    {
        setImage("StartButton.png"); // Asegúrate de tener esta imagen en la carpeta "images"
    }

     

    public void act()
    {
        if (Greenfoot.mouseClicked(this) && !pressed) {
            pressed = true;

            MainMenu menu = (MainMenu)getWorld();
            menu.stopMusic();

            // Crea el objeto de transición y lo coloca en pantalla
            FadeTransition transition = new FadeTransition(new CharacterSelectWorld());
            getWorld().addObject(transition, 600, 400);
            transition.startFade();
        }
    }
}

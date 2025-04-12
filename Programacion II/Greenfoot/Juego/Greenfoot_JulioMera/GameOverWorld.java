import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Pantalla que aparece cuando el jugador pierde todas las vidas.
 */
public class GameOverWorld extends World
{
    public GameOverWorld()
    {
        super(1200, 800, 1);
        setBackground("game_over_background.png"); // Reemplaza con tu imagen o deja color sólido

        RestartButton restart = new RestartButton();
        addObject(restart, getWidth()/2, 600);
        
        MainMenuButton menu = new MainMenuButton();
        addObject(menu, getWidth()/2, 700); // Un poco más abajo
        
    }
}

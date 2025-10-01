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
            // ✅ Reinicia vidas y puntaje
            GameState.lives = 3;
            GameState.score = 0;

            Greenfoot.setWorld(new Room1("mage", "default")); // Usa constructor completo
        }
    }
}

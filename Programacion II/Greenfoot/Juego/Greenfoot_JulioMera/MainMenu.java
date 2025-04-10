import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenu here.
 * 
 * @author Julio Mera
 */
public class MainMenu extends World
{
    private GreenfootSound menuMusic = new GreenfootSound("menu_music.wav");

    public MainMenu()
    {
        super(1200, 800, 1);
        setBackground("menu_background.jpg");
        addObject(new StartButton(), 600, 500);
        menuMusic.setVolume(50); // Puedes ajustar el volumen de 0 a 100
        menuMusic.playLoop();
        
                // Agregar botón de música en esquina superior derecha
        MusicToggleButton musicButton = new MusicToggleButton(menuMusic);
        addObject(musicButton, 1100, 50); // Puedes ajustar la posición
    }


    private void prepare()
    {
        setBackground("menu_background.jpg"); // Imagen de fondo en carpeta "images"
        addObject(new StartButton(), 600, 500); // Botón centrado abajo
    }
    
        public void stopped()
    {
        menuMusic.pause(); // Detiene la música si el usuario presiona "Pause"
    }

    public void started()
    {
        menuMusic.playLoop(); // Continúa si se reanuda
    }
    
    public void stopMusic()
{
    menuMusic.stop();
}

    
}


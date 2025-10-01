import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MusicToggleButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MusicToggleButton extends Actor
{
    private boolean isPlaying = true;
    private GreenfootSound music;

    public MusicToggleButton(GreenfootSound music)
    {
        this.music = music;
        setImage("music_on.png"); // Icono por defecto
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            toggleMusic();
        }
    }

    private void toggleMusic()
    {
        if (isPlaying) {
            music.pause(); // o music.stop();
            setImage("music_off.png");
        } else {
            music.playLoop();
            setImage("music_on.png");
        }

        isPlaying = !isPlaying;
    }
}


import greenfoot.*;

public class VictoryWorld extends World
{
    
    public VictoryWorld()
    {
        super(1200, 800, 1);
        setBackground("victory_background.png"); // reemplaza con tu imagen

        GreenfootImage pressR = new GreenfootImage("Press R to Restart", 48, Color.WHITE, new Color(0, 0, 0, 0));
        getBackground().drawImage(pressR, getWidth() / 2 - pressR.getWidth() / 2, 600);
        
        addObject(new DancerGirl("girl1", 1.0), 200, 700);  // tamaño normal
        addObject(new DancerGirl("girl2", 2.5), 400, 700);  // más grande
        addObject(new DancerGirl("girl3", 2.5), 600, 700);
        addObject(new DancerGirl("girl4", 2.5), 800, 700);
        addObject(new DancerGirl("girl5", 2.5), 1000, 700);


    }

    public void act()
    {
        if (Greenfoot.isKeyDown("r")) {
            GameState.lives = 3;
            GameState.score = 0;
            Greenfoot.setWorld(new Room1("mage", "default"));
        }
    }
}

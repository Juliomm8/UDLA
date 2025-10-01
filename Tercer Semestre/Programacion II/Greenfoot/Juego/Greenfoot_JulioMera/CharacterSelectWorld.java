import greenfoot.*;

public class CharacterSelectWorld extends World
{
    public CharacterSelectWorld()
    {
        super(1200, 800, 1);
        setBackground("character_select_bg.png"); // Opcional
        
        // Botones
        addObject(new SelectMageButton(), 400, 400);
        addObject(new SelectWarriorButton(), 800, 400);
    }
}
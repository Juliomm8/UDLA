import greenfoot.*;

public class SelectWarriorButton extends Actor
{
    public SelectWarriorButton()
    {
        setImage("select_warrior.png"); // Imagen para el guerrero
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            showLockedMessage();
        }
    }
        private void showLockedMessage() {
        World world = getWorld();
        world.showText("Character locked", world.getWidth() / 2, world.getHeight() - 50);
    }
}

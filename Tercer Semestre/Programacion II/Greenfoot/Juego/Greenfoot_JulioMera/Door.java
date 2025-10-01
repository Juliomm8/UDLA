import greenfoot.*;

public class Door extends Actor
{
    private String nextRoom;

    public Door(String nextRoom)
    {
        this.nextRoom = nextRoom;
        setImage("door_bottom.png"); // Usa tu sprite de puerta
    }

    public void act()
    {
        if (isTouching(Hero.class)) {
            switchToNextRoom();
        }
    }

    private void switchToNextRoom()
    {
        switch (nextRoom) {
            case "Room1" -> Greenfoot.setWorld(new Room1("mage", "fromRoom2"));
            case "Room2" -> Greenfoot.setWorld(new Room2("fromRoom1"));
        }

    }

}

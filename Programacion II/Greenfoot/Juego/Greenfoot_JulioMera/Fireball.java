import greenfoot.*;

public class Fireball extends Actor
{
    private GreenfootImage[] frames = new GreenfootImage[5];
    private int frameIndex = 0;
    private int frameCounter = 0;
    private int frameSpeed = 4;

    private int angle = 0;

    public Fireball()
    {
        for (int i = 0; i < frames.length; i++) {
            frames[i] = new GreenfootImage("fireball/fireball_" + i + ".png");
        }

        setImage(frames[0]);
    }

    public void addedToWorld(World world)
    {
        if (!world.getObjects(Hero.class).isEmpty()) {
            Hero hero = world.getObjects(Hero.class).get(0);
            int dx = hero.getX() - getX();
            int dy = hero.getY() - getY();
            angle = (int) Math.toDegrees(Math.atan2(dy, dx));
            setRotation(angle);
        }
    }

    public void act()
    {
        animate();
        move(4);

        if (getWorld() == null) return; // 🔐 seguridad por si fue eliminado antes

        if (isTouching(Hero.class)) {
            Hero hero = (Hero) getOneIntersectingObject(Hero.class);
            if (hero != null) {
                if (getWorld() instanceof Room1 room1) {
                    room1.loseLife();
                } else if (getWorld() instanceof Room2 room2) {
                    room2.loseLife();
                }
            }

            if (getWorld() != null) {
                getWorld().removeObject(this);
            }
            return;
        }

        if (getWorld() != null && isAtEdge()) {
            getWorld().removeObject(this);
        }
    }

    private void animate()
    {
        frameCounter++;
        if (frameCounter >= frameSpeed) {
            frameCounter = 0;
            frameIndex = (frameIndex + 1) % frames.length;
            setImage(frames[frameIndex]);
        }
    }
}

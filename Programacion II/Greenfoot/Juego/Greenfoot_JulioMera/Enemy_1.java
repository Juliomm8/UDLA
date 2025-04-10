import greenfoot.*;

public class Enemy_1 extends Actor
{
    private int moveSpeed = 1;
    private boolean spawned = false;

    public void act()
    {
        if (!spawned) {
            moveRandomly();
        } else {
            chaseHero();
        }
        checkHit();
    }

    private void moveRandomly()
    {
        int randomDirection = Greenfoot.getRandomNumber(360);
        setRotation(randomDirection);
        move(moveSpeed);

        if (Greenfoot.getRandomNumber(100) < 2) {
            spawned = true;
        }
    }

    private void chaseHero()
    {
        if (getWorld().getObjects(Hero.class).isEmpty()) return;

        Hero hero = (Hero) getWorld().getObjects(Hero.class).get(0);
        int dx = hero.getX() - getX();
        int dy = hero.getY() - getY();
        int angle = (int) Math.toDegrees(Math.atan2(dy, dx));

        setRotation(angle);
        move(moveSpeed);
    }

    private void checkHit()
    {
        if (isTouching(SeedShot.class)) {
            removeTouching(SeedShot.class);
            getWorld().addObject(new FloatingScore(10), getX(), getY());
            ((MyWorld)getWorld()).addScore(10);
            getWorld().removeObject(this);
        }
    }
}


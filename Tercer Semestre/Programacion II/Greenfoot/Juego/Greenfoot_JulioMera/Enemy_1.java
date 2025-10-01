import greenfoot.*;

public class Enemy_1 extends Actor
{
    private int moveSpeed = 1;
    private boolean spawned = false;
    
    private GreenfootImage[] flyFrames = new GreenfootImage[2];
    private int frameIndex = 0;
    private int animationCounter = 0;
    private int animationSpeed = 6;
    
        public Enemy_1()
    {
        flyFrames[0] = new GreenfootImage("crow_fly0.png");
        flyFrames[1] = new GreenfootImage("crow_fly1.png");
        setImage(flyFrames[0]);           // fotograma inicial
    }

    public void act()
    {
        if (((Room1)getWorld()).isGamePaused()) return;
        
        animate();  
        chaseHero();
    
        checkHit();
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
            ((Room1)getWorld()).addScore(10);
            getWorld().removeObject(this);
        }
    }
    
    private void animate()
    {
        animationCounter++;
        if (animationCounter >= animationSpeed) {
            animationCounter = 0;
            frameIndex = (frameIndex + 1) % flyFrames.length;
        }
    
        GreenfootImage frame = new GreenfootImage(flyFrames[frameIndex]);
    
        // ------------- orientación -------------
        if (!getWorld().getObjects(Hero.class).isEmpty()) {
            Hero hero = (Hero) getWorld().getObjects(Hero.class).get(0);
    
            /* Sprite base mira a la IZQUIERDA.
               Así que solo espejamos si el héroe está a la DERECHA. */
            if (hero.getX() > getX()) {
                frame.mirrorHorizontally();
            }
        }
        // ---------------------------------------
    
        setImage(frame);
    }

}


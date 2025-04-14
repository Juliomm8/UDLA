import greenfoot.*;

public class Dragon extends Actor {
    private GreenfootImage[] idleFrames = new GreenfootImage[6];
    private int idleIndex = 0;
    private int animationCounter = 0;
    private int animationSpeed = 6;

    private int maxHealth = 7;
    private int currentHealth = 7;

    private GreenfootImage[] breathFrames = new GreenfootImage[7];
    private int breathIndex = 0;
    private int breathCounter = 0;
    private int breathSpeed = 5;
    private boolean isBreathing = false;
    private int breathCooldown = 0;
    private final int breathDelay = 180;

    private GreenfootImage[] tailFrames = new GreenfootImage[13];
    private int tailIndex = 0;
    private int tailCounter = 0;
    private int tailSpeed = 5;
    private boolean isTailAttacking = false;
    private int tailCooldown = 0;
    private final int tailDelay = 150;

    private GreenfootImage[] walkFrames = new GreenfootImage[9];
    private int walkIndex = 0;
    private int walkCounter = 0;
    private int walkSpeed = 6;

    private boolean isDead = false;

    public Dragon() {
        for (int i = 0; i < idleFrames.length; i++)
            idleFrames[i] = new GreenfootImage("idle/dragon_idle_" + i + ".png");

        for (int i = 0; i < breathFrames.length; i++)
            breathFrames[i] = new GreenfootImage("breath/dragon_breath_" + i + ".png");

        for (int i = 0; i < tailFrames.length; i++)
            tailFrames[i] = new GreenfootImage("tail/dragon_tail_" + i + ".png");

        for (int i = 0; i < walkFrames.length; i++)
            walkFrames[i] = new GreenfootImage("walk/dragon_walk_" + i + ".png");

        setImage(idleFrames[0]);
        currentHealth = maxHealth;
    }

    public void act() {
        if (isDead) return;

        showHearts();

        if (!isBreathing && breathCooldown <= 0) {
            isBreathing = true;
            breathIndex = 0;
            breathCounter = 0;
        } else if (isBreathing) {
            playBreathAttack();
            return;
        } else {
            breathCooldown--;
        }

        if (!isTailAttacking && tailCooldown <= 0 && isHeroInRange(100)) {
            isTailAttacking = true;
            tailIndex = 0;
            tailCounter = 0;
        } else if (isTailAttacking) {
            playTailAttack();
            return;
        } else {
            tailCooldown--;
        }

        moveTowardHero();
        animateIdle();
    }

    private void animateIdle() {
        animationCounter++;
        if (animationCounter >= animationSpeed) {
            animationCounter = 0;
            idleIndex = (idleIndex + 1) % idleFrames.length;
            setImage(new GreenfootImage(idleFrames[idleIndex]));
        }
    }

    private void playWalkAnimation() {
        walkCounter++;
        if (walkCounter >= walkSpeed) {
            walkCounter = 0;
            walkIndex = (walkIndex + 1) % walkFrames.length;
            setImage(new GreenfootImage(walkFrames[walkIndex]));
        }
    }

    private void moveTowardHero() {
        if (getWorld() == null || getWorld().getObjects(Hero.class).isEmpty()) return;
        Hero hero = getWorld().getObjects(Hero.class).get(0);

        int dx = hero.getX() - getX();
        int dy = hero.getY() - getY();
        int distance = (int) Math.hypot(dx, dy);

        if (distance > 150) return;

        int newX = getX() + (int)(Math.signum(dx));
        int newY = getY() + (int)(Math.signum(dy));
        setLocation(newX, newY);

        playWalkAnimation();
    }

    private void playBreathAttack() {
        breathCounter++;
        if (breathCounter >= breathSpeed) {
            breathCounter = 0;
            if (breathIndex < breathFrames.length) {
                setImage(new GreenfootImage(breathFrames[breathIndex]));
                breathIndex++;
            } else {
                shootFireball();
                isBreathing = false;
                breathCooldown = breathDelay;
                idleIndex = 0;
            }
        }
    }

    private void shootFireball() {
        Fireball fb = new Fireball();
        getWorld().addObject(fb, getX(), getY());

        if (!getWorld().getObjects(Hero.class).isEmpty()) {
            Hero hero = getWorld().getObjects(Hero.class).get(0);
            int dx = hero.getX() - getX();
            int dy = hero.getY() - getY();
            int angle = (int) Math.toDegrees(Math.atan2(dy, dx));
            fb.setRotation(angle);
        }
    }

    private void playTailAttack() {
        tailCounter++;
        if (tailCounter >= tailSpeed) {
            tailCounter = 0;
            if (tailIndex < tailFrames.length) {
                setImage(new GreenfootImage(tailFrames[tailIndex]));
                tailIndex++;

                if (tailIndex == 3 && isTouching(Hero.class)) {
                    Hero hero = (Hero) getOneIntersectingObject(Hero.class);
                    if (hero != null) {
                        if (getWorld() instanceof Room1 r1) r1.loseLife();
                        else if (getWorld() instanceof Room2 r2) r2.loseLife();
                    }
                }
            } else {
                isTailAttacking = false;
                tailCooldown = tailDelay;
                idleIndex = 0;
            }
        }
    }

    private boolean isHeroInRange(int range) {
        if (getWorld() == null || getWorld().getObjects(Hero.class).isEmpty()) return false;
        Hero hero = getWorld().getObjects(Hero.class).get(0);
        int dx = hero.getX() - getX();
        int dy = hero.getY() - getY();
        return Math.hypot(dx, dy) < range;
    }

    public void takeDamage(int amount) {
        currentHealth -= amount;
        if (currentHealth <= 0) {
            currentHealth = 0;
            die();
        }
    }

    private void die() {
        isDead = true;
        World world = getWorld();
        if (world == null) return;

        for (Object obj : world.getObjects(DragonHeart.class)) {
            DragonHeart heart = (DragonHeart) obj;
            if (heart.getOwner() == this) {
                world.removeObject(heart);
            }
        }
        
        Greenfoot.setWorld(new VictoryWorld());

        world.addObject(new LifePickup(), getX(), getY() - 30);
        world.removeObject(this);
    }

    private void showHearts() {
        World world = getWorld();
        if (world == null) return;

        for (Object obj : world.getObjects(DragonHeart.class)) {
            DragonHeart heart = (DragonHeart) obj;
            if (heart.getOwner() == this) {
                world.removeObject(heart);
            }
        }

        int offset = (currentHealth - 1) * 8;
        for (int i = 0; i < currentHealth; i++) {
            DragonHeart heart = new DragonHeart(this);
            world.addObject(heart, getX() - offset + i * 16, getY() - 80);
        }
    }
}

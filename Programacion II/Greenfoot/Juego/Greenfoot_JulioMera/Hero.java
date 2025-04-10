import greenfoot.*;

/**
 * El nombre del héroe es "El Botánico Errante".
 * Este héroe se desplaza por el mundo y puede
 * disparar semillas para eliminar a los enemigos.
 * 
 * Controles:
 * - Flechas del teclado o WASD para moverse
 * - Barra espaciadora para disparar semillas
 * - Clic izquierdo para disparar hacia el mouse
 * 
 * @author Julio Mera
 * @version Abril 2025
 */
public class Hero extends Actor
{
    private int shootCooldown = 0;
    private final int cooldownTime = 20;
    private int currentSpeed = 2;
    private final int baseSpeed = 2;
    private final int runSpeed = 4;
    private int lastDirection = 0;

    private boolean facingRight = true;
    private boolean lastFacingRight = false; // ← fuerza updateImage en el primer act()

    // CONSTRUCTOR: se asegura de que se muestre desde el principio
    public Hero()
    {
        facingRight = true;
        lastFacingRight = false; // Así updateImage se ejecuta en el primer frame
    }

    public void act()
    {
        handleMovement();
        shootSeedKeyboard();
        aimAtMouse();
        shootMouse();
        updateImage();
        checkCollisionWithEnemies();

        if (shootCooldown > 0) {
            shootCooldown--;
        }
    }

    private void handleMovement()
    {
        currentSpeed = Greenfoot.isKeyDown("shift") ? runSpeed : baseSpeed;

        int newX = getX();
        int newY = getY();

        if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")) {
            facingRight = false;
            newX -= currentSpeed;
            lastDirection = 180;
        }

        if (Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")) {
            facingRight = true;
            newX += currentSpeed;
            lastDirection = 0;
        }

        if (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")) {
            newY -= currentSpeed;
            lastDirection = 270;
        }

        if (Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down")) {
            newY += currentSpeed;
            lastDirection = 90;
        }

        MyWorld mundo = (MyWorld)getWorld();
        if (mundo.dentroDeLimites(newX, newY, 100)) {
            setLocation(newX, newY);
        }
    }

    private void shootSeedKeyboard()
    {
        if (shootCooldown > 0) return;

        boolean up = Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up");
        boolean down = Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down");
        boolean left = Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left");
        boolean right = Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right");

        int direction = -1;

        if (up && right) direction = 315;
        else if (up && left) direction = 225;
        else if (down && right) direction = 45;
        else if (down && left) direction = 135;
        else if (up) direction = 270;
        else if (down) direction = 90;
        else if (right) direction = 0;
        else if (left) direction = 180;
        else direction = lastDirection;

        if (Greenfoot.isKeyDown("space") && direction != -1) {
            shoot(direction);
        }
    }

    private void shootMouse()
    {
        if (shootCooldown > 0) return;

        if (Greenfoot.mousePressed(null)) {
            SeedShot seed = new SeedShot();
            int offset = facingRight ? 20 : -20;
            getWorld().addObject(seed, getX() + offset, getY());

            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse != null) {
                seed.turnTowards(mouse.getX(), mouse.getY());
            }

            shootCooldown = cooldownTime;
        }
    }

    private void shoot(int direction)
    {
        SeedShot seed = new SeedShot();
        seed.setRotation(direction);
        int offset = 16;
        double radians = Math.toRadians(direction);
        int dx = (int)(Math.cos(radians) * offset);
        int dy = (int)(Math.sin(radians) * offset);

        getWorld().addObject(seed, getX() + dx, getY() + dy);
        shootCooldown = cooldownTime;
    }

    private void aimAtMouse()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            facingRight = mouse.getX() >= getX();
        }
    }

    private void updateImage()
    {
        if (facingRight != lastFacingRight) {
            String img = facingRight ? "hero_right.png" : "hero_left.png";
            setImage(new GreenfootImage(img));
            lastFacingRight = facingRight;
        }
    }

    private void checkCollisionWithEnemies()
    {
        if (isTouching(Enemy_1.class)) {
            removeTouching(Enemy_1.class);
            ((MyWorld)getWorld()).loseLife();
        }
    }
}

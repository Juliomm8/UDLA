import greenfoot.*;

/**
 * El nombre del héroe es "El Botánico Errante".
 * Se mueve por el mapa, apunta con el mouse y dispara semillas.
 * Usa animaciones Idle, Run y Attack.
 * 
 * @author Julio Mera
 * @version Abril 2025
 */
public class Hero extends Actor
{
    private final int speed = 2;
    private int shootCooldown = 0;
    private final int cooldownTime = 20;
    private int lastDirection = 0;

    private boolean facingRight = true;
    private boolean lastFacingRight = false;

    // Animación Idle
    private GreenfootImage[] idleFrames = new GreenfootImage[6];
    private int idleFrameIndex = 0;
    private int idleAnimationCounter = 0;
    private int idleAnimationSpeed = 5;

    // Animación Run
    private GreenfootImage[] runFrames = new GreenfootImage[8];
    private int runFrameIndex = 0;
    private int runAnimationCounter = 0;
    private int runAnimationSpeed = 4;

    // Animación Attack
    private GreenfootImage[] attackFrames = new GreenfootImage[8];
    private int attackFrameIndex = 0;
    private int attackAnimationCounter = 0;
    private int attackAnimationSpeed = 4;
    private boolean isAttacking = false;
    private boolean alreadyShotInAttack = false;
    private int shootDirection = 0;
    
    private GreenfootImage[] hitFrames = new GreenfootImage[4];
    private int hitFrameIndex = 0;
    private int hitAnimationCounter = 0;
    private int hitAnimationSpeed = 4;
    private boolean isHit = false;
    
    private GreenfootImage[] deathFrames = new GreenfootImage[7];
    private int deathFrameIndex = 0;
    private int deathAnimationCounter = 0;
    private int deathAnimationSpeed = 5;
    private boolean isDead = false;
    private int deathHoldFrames = 10;  
    
    private boolean fadeStarted = false;  




    public Hero()
    {
        for (int i = 0; i < idleFrames.length; i++) {
            idleFrames[i] = new GreenfootImage("Idle_" + i + ".png");
        }
        for (int i = 0; i < runFrames.length; i++) {
            runFrames[i] = new GreenfootImage("Run_" + i + ".png");
        }
        for (int i = 0; i < attackFrames.length; i++) {
            attackFrames[i] = new GreenfootImage("Attack1_" + i + ".png");
        }
        for (int i = 0; i < hitFrames.length; i++) {
        hitFrames[i] = new GreenfootImage("Hit_" + i + ".png");
        }
        for (int i = 0; i < deathFrames.length; i++) {
        deathFrames[i] = new GreenfootImage("Death_" + i + ".png");
        }

        facingRight = true;
        lastFacingRight = false;
    }

    public void act()
    {
        if (isDead) {
            playDeathAnimation();
            return;
        }
    
        if (isHit) {
            playHitAnimation();
            return;
        }
    
        checkCollisionWithEnemies();
    
        if (shootCooldown > 0) shootCooldown--;
    
        if (Greenfoot.isKeyDown("space") || Greenfoot.mousePressed(null)) {
            updateDirectionToMouse();
            shootTrigger();
        }
    
        boolean moving = Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("d") ||
                         Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("s") ||
                         Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("right") ||
                         Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("down");
    
        if (isAttacking) {
            playAttackAnimation();
        } else {
            if (moving) {
                handleMovement();
                updateDirectionToMouse();
                playRunAnimation();
            } else {
                updateDirectionToMouse();
                playIdleAnimation();
            }
        }
    }


    private void handleMovement()
    {
        int prevX = getX();
        int prevY = getY();
        int newX = prevX;
        int newY = prevY;
    
        // Movimiento horizontal
        if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")) {
            newX -= speed;
            lastDirection = 180;
        }
        if (Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")) {
            newX += speed;
            lastDirection = 0;
        }
    
        setLocation(newX, prevY);
        if (isTouching(Wall.class)) {
            setLocation(prevX, prevY); // Revierte el movimiento horizontal
        } else {
            prevX = getX(); // Actualiza solo si se pudo mover
        }
    
        // Movimiento vertical
        if (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")) {
            newY -= speed;
            lastDirection = 270;
        }
        if (Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down")) {
            newY += speed;
            lastDirection = 90;
        }
    
        setLocation(getX(), newY);
        if (isTouching(Wall.class)) {
            setLocation(getX(), prevY); // Revierte el movimiento vertical
        }
    }


    private void shootTrigger()
    {
        if (!isAttacking && shootCooldown == 0) {
            isAttacking = true;
            attackFrameIndex = 0;
            attackAnimationCounter = 0;
            alreadyShotInAttack = false;
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
    }

    private void updateDirectionToMouse()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            int dx = mouse.getX() - getX();
            int dy = mouse.getY() - getY();
            shootDirection = (int)Math.toDegrees(Math.atan2(dy, dx));
            facingRight = dx >= 0;
        }
    }

    private void checkCollisionWithEnemies()
    {
        if (isDead) return;
        
        if (isTouching(Enemy_1.class)) {
        removeTouching(Enemy_1.class);
        if (!isHit && !isAttacking) {
            isHit = true;
            hitFrameIndex = 0;
            hitAnimationCounter = 0;
        }
        ((Room1)getWorld()).loseLife();
        }
    }

    private void playIdleAnimation()
    {
        idleAnimationCounter++;
        if (idleAnimationCounter >= idleAnimationSpeed) {
            idleAnimationCounter = 0;
            idleFrameIndex = (idleFrameIndex + 1) % idleFrames.length;
            GreenfootImage frame = new GreenfootImage(idleFrames[idleFrameIndex]);
            if (!facingRight) frame.mirrorHorizontally();
            setImage(frame);
        }
    }

    private void playRunAnimation()
    {
        runAnimationCounter++;
        if (runAnimationCounter >= runAnimationSpeed) {
            runAnimationCounter = 0;
            runFrameIndex = (runFrameIndex + 1) % runFrames.length;
            GreenfootImage frame = new GreenfootImage(runFrames[runFrameIndex]);
            if (!facingRight) frame.mirrorHorizontally();
            setImage(frame);
        }
    }

    private void playAttackAnimation()
    {
        attackAnimationCounter++;
        if (attackAnimationCounter >= attackAnimationSpeed) {
            attackAnimationCounter = 0;

            if (attackFrameIndex < attackFrames.length) {
                GreenfootImage frame = new GreenfootImage(attackFrames[attackFrameIndex]);
                if (!facingRight) frame.mirrorHorizontally();
                setImage(frame);

                if (attackFrameIndex == 4 && !alreadyShotInAttack) {
                    shoot(shootDirection);
                    alreadyShotInAttack = true;
                }

                attackFrameIndex++;
            } else {
                isAttacking = false;
                attackFrameIndex = 0;
                alreadyShotInAttack = false;
            }
        }
    }
    private void playHitAnimation()
    {
        hitAnimationCounter++;
        if (hitAnimationCounter >= hitAnimationSpeed) {
            hitAnimationCounter = 0;
    
            if (hitFrameIndex < hitFrames.length) {
                GreenfootImage frame = new GreenfootImage(hitFrames[hitFrameIndex]);
                if (!facingRight) frame.mirrorHorizontally();
                setImage(frame);
                hitFrameIndex++;
            } else {
                isHit = false;
                hitFrameIndex = 0;
            }
        }
    }
    private void playDeathAnimation()
    {
        deathAnimationCounter++;
        if (deathAnimationCounter >= deathAnimationSpeed) {
            deathAnimationCounter = 0;
    
            if (deathFrameIndex < deathFrames.length) {
                GreenfootImage frame = new GreenfootImage(deathFrames[deathFrameIndex]);
                if (!facingRight) frame.mirrorHorizontally();
                setImage(frame);
                deathFrameIndex++;
            } else if (deathHoldFrames > 0) {
                // Espera unos frames con el texto visible
                getWorld().showText("Has muerto", getX(), getY() - 60);
                deathHoldFrames--;
            } else {
                if (!fadeStarted) {
                    // Texto ya mostrado; inicia fundido
                    FadeTransition fade = new FadeTransition(new GameOverWorld());
                    getWorld().addObject(fade,
                                         getWorld().getWidth() / 2,
                                         getWorld().getHeight() / 2);
                    fade.startFade();
                    fadeStarted = true;
                }
            }
        }
    }


    public void setDead()
    {
        isDead = true;
        isHit = false;
        hitFrameIndex = 0;
        deathFrameIndex = 0;
        deathAnimationCounter = 0;
        
        if (getWorld() instanceof Room1 room1) {
            room1.pauseGame();
        } else if (getWorld() instanceof Room2 room2) {
            room2.pauseGame();
        }


    }
    
        public void gainLife()
    {
        if (GameState.lives < 3) {
            GameState.lives++;
    
            if (getWorld() instanceof Room1 room1) {
                room1.showHearts();
            } else if (getWorld() instanceof Room2 room2) {
                room2.showHearts();
            }
        }
    }

    
}
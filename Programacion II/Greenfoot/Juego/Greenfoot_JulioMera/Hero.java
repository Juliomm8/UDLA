import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *  EL nombre del heroe es "El Botánico Errante".
 *  Este héroe se desplaza por el mundo y puede
 *  disparar semillas para eliminar a los enemigos.
 * 
 * Controles:
 * - Flechas del teclado o WASD para moverse. Check
 * - Barra espaciadora para disparar semillas
 * 
 * La clase Hero maneja la lógica de movimiento y disparo.
 *
 * @author (Julio Mera) 
 */

public class Hero extends Actor
{
    /**
     * Act - do whatever the Hero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        movHero();
        //shootSpeed();
    }
    
    public void movHero() {
    if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) move(-3);
    if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) move(3);
    if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")) setLocation(getX(), getY() - 3);
    if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")) setLocation(getX(), getY() + 3);
    }
    
    
}

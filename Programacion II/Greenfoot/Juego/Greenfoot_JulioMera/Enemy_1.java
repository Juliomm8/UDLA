import greenfoot.*;

public class Enemy_1 extends Actor
{
    private int moveSpeed = 2; // Velocidad de movimiento

    private boolean spawned = false; // Verificar si ya salió del spawn

    public void act() {
        if (!spawned) {
            moveRandomly(); // Movimiento aleatorio al principio
        } else {
            chaseHero(); // Perseguir al héroe después de haber salido
        }
    }

    // Movimiento aleatorio (cuando no se ha spawn)
    private void moveRandomly() {
        int randomDirection = Greenfoot.getRandomNumber(360); // Ángulo aleatorio
        setRotation(randomDirection);
        move(moveSpeed);
        
        // Después de mover un poco, marca como spawn y comienza a perseguir
        if (Greenfoot.getRandomNumber(100) < 2) { // Probabilidad de salir
            spawned = true;
        }
    }

    // Perseguir al héroe
    private void chaseHero() {
        Hero hero = (Hero) getWorld().getObjects(Hero.class).get(0); // Obtén al héroe
        int heroX = hero.getX();
        int heroY = hero.getY();

        // Obtener dirección hacia el héroe
        int deltaX = heroX - getX();
        int deltaY = heroY - getY();
        int direction = (int) Math.toDegrees(Math.atan2(deltaY, deltaX)); // Ángulo entre el enemigo y el héroe

        setRotation(direction); // Ajustar la rotación
        move(moveSpeed); // Moverse hacia el héroe
    }
}

import greenfoot.*;  

/**
 * El nombre del héroe es "El Botánico Errante".
 * Este héroe se desplaza por el mundo y puede
 * disparar semillas para eliminar a los enemigos.
 * 
 * Controles:
 * - Flechas del teclado o WASD para moverse
 * - Barra espaciadora para disparar semillas
 * 
 * La clase Hero maneja la lógica de movimiento y disparo.
 * 
 * @author (Julio Mera)
 * @version (Abril 2025)
 */
public class Hero extends Actor
{
    private int shootCooldown = 0;
    private int speedMov = 3; // Velocidad normal de movimiento
    private int cooldownTime = 20; // Tiempo de espera entre disparos
    private int baseSpeed = 2; // Velocidad base de movimiento
    private int runSpeed = 4; // Velocidad cuando corre (Shift)
    private int currentSpeed = 2; // Velocidad actual (base o correr)
    private int lastDirection = 0; // Dirección del último disparo

    private GreenfootImage originalImage;
    private GreenfootImage mirroredImage;
    
    public Hero() {
        originalImage = getImage();  // Obtener la imagen original del héroe
        mirroredImage = new GreenfootImage(originalImage);  // Crear una copia reflejada
        mirroredImage.mirrorHorizontally();  // Reflejar la imagen horizontalmente (para movimiento hacia la izquierda)
    }

    public void act()
    {
        movHero();  // Maneja el movimiento del héroe
        shootSeed();  // Maneja el disparo de semillas

        // Reducir el tiempo de cooldown para disparar
        if (shootCooldown > 0) {
            shootCooldown--;
        }
    }

    // Método para mover al héroe con las teclas WASD o flechas
    public void movHero() {
        if (Greenfoot.isKeyDown("shift")) {
            currentSpeed = runSpeed;  // Aumenta la velocidad cuando Shift está presionado
        } else {
            currentSpeed = baseSpeed;  // Velocidad normal
        }

        int newX = getX();
        int newY = getY();

        // Movimiento hacia la izquierda (y reflejar la imagen)
        if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) {
            setImage(mirroredImage);  // Refleja la imagen del héroe
            newX -= currentSpeed;
            lastDirection = 180;  // Guarda la dirección del último movimiento
        }
        
        // Movimiento hacia la derecha
        if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) {
            setImage(originalImage);  // Usa la imagen original para la dirección derecha
            newX += currentSpeed;
            lastDirection = 0;  // Dirección derecha
        }
        
        // Movimiento hacia arriba
        if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")) {
            newY -= currentSpeed;
            lastDirection = 270;  // Dirección hacia arriba
        }
        
        // Movimiento hacia abajo
        if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")) {
            newY += currentSpeed;
            lastDirection = 90;  // Dirección hacia abajo
        }

        int margen = 100;  // Margen de seguridad para no salir del mundo

        // Verifica si la nueva posición está dentro de los límites del mundo
        MyWorld mundo = (MyWorld)getWorld();
        if (mundo.dentroDeLimites(newX, newY, margen)) {
            setLocation(newX, newY);  // Mueve al héroe si está dentro de los límites
        }
    }

    // Método para disparar las semillas
    public void shootSeed() {
        if (shootCooldown > 0) return;  // Si el cooldown no ha terminado, no dispara

        boolean up = Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w");
        boolean down = Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s");
        boolean left = Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a");
        boolean right = Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d");

        int direction = -1;  // Inicializa la dirección como inválida

        // Combinaciones de teclas para dirección del disparo
        if (up && right) direction = 315;
        else if (up && left) direction = 225;
        else if (down && right) direction = 45;
        else if (down && left) direction = 135;
        else if (up) direction = 270;
        else if (down) direction = 90;
        else if (right) direction = 0;
        else if (left) direction = 180;
        else direction = lastDirection;  // Si no se mueve, dispara en la última dirección

        // Si se presiona la barra espaciadora, dispara la semilla
        if (Greenfoot.isKeyDown("space") && direction != -1) {
            SeedShot seed = new SeedShot();  // Crea una nueva semilla
            seed.setRotation(direction);  // Ajusta la dirección de la semilla
            int offset = 16;  // Distancia desde el héroe para el disparo
            double radians = Math.toRadians(direction);
            int dx = (int)(Math.cos(radians) * offset);  // Cálculo de la posición X
            int dy = (int)(Math.sin(radians) * offset);  // Cálculo de la posición Y

            getWorld().addObject(seed, getX() + dx, getY() + dy);  // Añade la semilla al mundo en la posición ajustada
            shootCooldown = cooldownTime;  // Inicia el cooldown entre disparos
        }
    }
}

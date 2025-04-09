import greenfoot.*;  

/**
 * Clase que define el mundo de juego, su tamaño y los objetos que contiene.
 * También maneja el spawn de enemigos.
 * 
 */
public class MyWorld extends World
{
    /**
     * Constructor para objetos de la clase MyWorld.
     * Crea el mundo con un tamaño de 1200x800 píxeles.
     */
    public MyWorld()
    {    
        super(1200, 800, 1); // Crea un mundo de 1200x800 celdas
        prepare();
        spawnEnemy(); // Llama al método para spawnear enemigos al iniciar
    }

    /**
     * Método para verificar si una posición está dentro de los límites del mundo.
     * 
     * @param x La coordenada X a verificar
     * @param y La coordenada Y a verificar
     * @param margen El margen desde el borde para evitar que los objetos se salgan
     * @return true si está dentro de los límites, false si está fuera.
     */
    public boolean dentroDeLimites(int x, int y, int margen) {
        return x >= margen && x <= getWidth() - margen &&  // Dentro del límite X
               y >= margen && y <= getHeight() - margen;  // Dentro del límite Y
    }

    /**
     * Prepara el mundo para el inicio del juego.
     * (En este caso, no se hace nada en este método, pero se puede agregar más lógica aquí).
     */
    private void prepare()
    {
        // Se pueden agregar objetos iniciales al mundo aquí si es necesario.
    }

    /**
     * Método para spawn de enemigos en posiciones específicas del mundo.
     * El enemigo será colocado en uno de tres puntos predefinidos.
     */
    public void spawnEnemy() {
        Enemy_1 enemy = new Enemy_1();
        
        // Tres puntos de spawn
        int spawnIndex = Greenfoot.getRandomNumber(3); // Selecciona aleatoriamente entre 0, 1, 2
        int spawnX = 0;
        int spawnY = 0;
        
        if (spawnIndex == 0) {
            spawnX = 1; // Primer punto de spawn
            spawnY = 450;
        } else if (spawnIndex == 1) {
            spawnX = 1200; // Segundo punto de spawn
            spawnY = 450;
        } else if (spawnIndex == 2) {
            spawnX = 700; // Tercer punto de spawn
            spawnY = 800;
        }
        
        addObject(enemy, spawnX, spawnY); // Spawnea al enemigo en el punto seleccionado
    }

    /**
     * Método llamado en cada ciclo de acción del mundo.
     * Se encarga de hacer que los enemigos aparezcan con cierta probabilidad.
     */
    public void act() {
        if (Greenfoot.getRandomNumber(100) < 2) { // 2% de probabilidad de spawn por ciclo
            spawnEnemy();  // Llama a spawnEnemy para agregar un enemigo
        }
    }
}

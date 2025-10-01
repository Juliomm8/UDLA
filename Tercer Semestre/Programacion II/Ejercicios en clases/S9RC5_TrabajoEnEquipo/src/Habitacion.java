public class Habitacion {
    // Número de la habitación (identificador)
    private int numero;
    // Estado de disponibilidad de la habitación (true = disponible, false = ocupada)
    private boolean disponible;

    // Constructor que recibe el número de habitación y la marca como disponible por defecto
    public Habitacion(int numero) {
        this.numero = numero;
        this.disponible = true;
    }

    // Devuelve el número de habitación
    public int getNumero() {
        return numero;
    }

    // Indica si la habitación está disponible
    public boolean estaDisponible() {
        return disponible;
    }

    // Marca la habitación como ocupada (no disponible)
    public void reservar() {
        this.disponible = false;
    }
}

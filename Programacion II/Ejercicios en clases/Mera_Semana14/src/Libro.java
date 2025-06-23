public class Libro extends Publicacion implements Prestable {
    private boolean prestado;

    // Constructor
    public Libro(String titulo, String autor) {
        super(titulo, autor);
        this.prestado = false;
    }

    // Implementación de los métodos de la interfaz Prestable
    @Override
    public void presta() throws NoDisponibleException {
        if (prestado) {
            throw new NoDisponibleException("El libro ya está prestado.");
        }
        prestado = true;
    }

    @Override
    public void devuelve() throws NoPrestadoException {
        if (!prestado) {
            throw new NoPrestadoException("El libro no está prestado.");
        }
        prestado = false;
    }

    @Override
    public boolean estaPrestado() {
        return prestado;
    }

    // Sobrescritura del método mostrarInformacion
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Estado: " + (prestado ? "Prestado" : "Disponible"));
    }
}

public class Libro extends Publicacion implements Prestable {
    private boolean enPrestamo;

    public Libro(String titulo, String autor) {
        super(titulo, autor);
        enPrestamo = false;
    }

    // Marca el libro como prestado si está disponible
    @Override
    public void prestar() throws NoDisponibleException {
        if (enPrestamo) {
            throw new NoDisponibleException("No se puede prestar: el libro ya fue retirado.");
        }
        enPrestamo = true;
    }

    // Marca el libro como disponible si estaba en préstamo
    @Override
    public void devolver() throws NoPrestadoException {
        if (!enPrestamo) {
            throw new NoPrestadoException("Imposible devolver: el libro no figura como prestado.");
        }
        enPrestamo = false;
    }

    // Retorna el estado actual de préstamo del libro
    @Override
    public boolean estaPrestado() {
        return enPrestamo;
    }

    // Muestra los detalles y disponibilidad del ejemplar
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Situación actual: " + (enPrestamo ? "No disponible (Prestado)" : "Disponible para préstamo"));
    }
}

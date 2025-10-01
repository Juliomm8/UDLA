public class Libro extends Publicacion implements Prestable {
    private boolean prestado;

    public Libro(String titulo, String autor) {
        super(titulo, autor);
        this.prestado = false;
    }

    @Override
    public void prestar() throws NoDisponibleException {
        if (prestado) {
            throw new NoDisponibleException("El libro ya está prestado.");
        }
        prestado = true;
    }

    @Override
    public void devolver() throws NoPrestadoException {
        if (!prestado) {
            throw new NoPrestadoException("El libro no está prestado.");
        }
        prestado = false;
    }

    @Override
    public boolean estaPrestado() {
        return prestado;
    }


    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Estado: " + (prestado ? "Prestado" : "Disponible"));
    }
}

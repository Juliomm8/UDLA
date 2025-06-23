public interface Prestable {
    void presta() throws NoDisponibleException;

    void devuelve() throws NoPrestadoException;

    boolean estaPrestado();
}

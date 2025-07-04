public interface Prestable {
    void prestar() throws NoDisponibleException;

    void devolver() throws NoPrestadoException;

    boolean estaPrestado();
}

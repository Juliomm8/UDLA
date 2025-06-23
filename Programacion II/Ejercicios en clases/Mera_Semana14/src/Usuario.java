import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private int id;
    private List<Publicacion> publicacionesPrestadas;

    // Constructor
    public Usuario(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.publicacionesPrestadas = new ArrayList<>();
    }

    // Prestar una publicación
    public void prestarPublicacion(Biblioteca biblioteca, Publicacion publicacion) {
        try {
            biblioteca.prestaPublicacion(publicacion);
            publicacionesPrestadas.add(publicacion);
            System.out.println("Publicación prestada con éxito.");
        } catch (NoDisponibleException e) {
            System.out.println(e.getMessage());
        }
    }

    // Devolver una publicación
    public void devolverPublicacion(Biblioteca biblioteca, Publicacion publicacion) {
        try {
            biblioteca.devuelvePublicacion(publicacion);
            publicacionesPrestadas.remove(publicacion);
            System.out.println("Publicación devuelta con éxito.");
        } catch (NoPrestadoException e) {
            System.out.println(e.getMessage());
        }
    }

    // Mostrar publicaciones prestadas
    public void mostrarPublicacionesPrestadas() {
        System.out.println("Publicaciones prestadas por " + nombre + ":");
        publicacionesPrestadas.forEach(Publicacion::mostrarInformacion);
    }
}

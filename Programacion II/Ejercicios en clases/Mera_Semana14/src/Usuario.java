import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private int id;
    private List<Publicacion> publicacionesPrestadas;

    public Usuario(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.publicacionesPrestadas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    }

    // Mostrar publicaciones prestadas
    public void mostrarPublicacionesPrestadas() {
        System.out.println("Publicaciones prestadas por " + nombre + ":");
        publicacionesPrestadas.forEach(Publicacion::mostrarInformacion);
    }
}

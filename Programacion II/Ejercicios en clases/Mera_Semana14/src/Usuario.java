import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String id;
    private final List<Publicacion> publicacionesPrestadas;

    public Usuario(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.publicacionesPrestadas = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        if (publicacion instanceof Revista) {
            System.out.println("Las revistas no se pueden prestar.");
            return;
        }
        try {
            biblioteca.prestarPublicacion(publicacion);
            publicacionesPrestadas.add(publicacion);
            System.out.println("Publicación "+ publicacion.getTitulo() +" a sido prestada con éxito.");
        } catch (NoDisponibleException e) {
            System.out.println(e.getMessage());
        }
    }

    public void devolverPublicacion(Biblioteca biblioteca, Publicacion publicacion) {
        try {
            biblioteca.devolverPublicacion(publicacion);
            publicacionesPrestadas.remove(publicacion);
            System.out.println("Publicación devuelta con éxito.");
        } catch (NoPrestadoException e) {
            System.out.println(e.getMessage());
        }
    }

    // Mostrar publicaciones prestadas
    public void mostrarPublicacionesPrestadas() {
        System.out.println("Publicaciones prestadas por " + nombre + ":");
        if (publicacionesPrestadas.isEmpty()) {
            System.out.println("No tiene publicaciones prestadas");
        } else {
            for (Publicacion publicacion : publicacionesPrestadas) {
                publicacion.mostrarInformacion();
            }
        }
    }
}
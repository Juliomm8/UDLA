import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String id;
    private final List<Publicacion> prestamosActivos;

    public Usuario(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.prestamosActivos = new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String nuevoId) {
        this.id = nuevoId;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    // Solicita préstamo de una publicación a la biblioteca
    public void prestarPublicacion(Biblioteca biblioteca, Publicacion publicacion) {
        if (publicacion instanceof Revista) {
            System.out.println("No es posible prestar revistas.");
            return;
        }
        try {
            biblioteca.prestarPublicacion(publicacion);
            prestamosActivos.add(publicacion);
            System.out.printf("Éxito: '%s' ha sido asignada a %s.\n", publicacion.getTitulo(), nombre);
        } catch (NoDisponibleException ex) {
            System.out.println("Error al prestar: " + ex.getMessage());
        }
    }

    // Solicita devolución de una publicación a la biblioteca
    public void devolverPublicacion(Biblioteca biblioteca, Publicacion publicacion) {
        try {
            biblioteca.devolverPublicacion(publicacion);
            if (prestamosActivos.remove(publicacion)) {
                System.out.println("Devolución realizada correctamente.");
            } else {
                System.out.println("Aviso: Esta publicación no estaba en la lista de préstamos activos.");
            }
        } catch (NoPrestadoException ex) {
            System.out.println("Error al devolver: " + ex.getMessage());
        }
    }

    // Lista todas las publicaciones actualmente prestadas al usuario
    public void mostrarPublicacionesPrestadas() {
        System.out.println("=== Préstamos de " + nombre + " ===");
        if (prestamosActivos.isEmpty()) {
            System.out.println("No hay préstamos registrados actualmente.");
        } else {
            for (Publicacion p : prestamosActivos) {
                p.mostrarInformacion();
            }
        }
    }
}

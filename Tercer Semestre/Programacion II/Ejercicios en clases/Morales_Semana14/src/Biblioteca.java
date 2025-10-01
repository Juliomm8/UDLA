import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private final List<Publicacion> publicaciones;

    public Biblioteca() {
        publicaciones = new ArrayList<>();
    }

    // Añade una nueva publicación al listado
    public void agregarPublicacion(Publicacion publicacion) {
        publicaciones.add(publicacion);
    }

    // Solicita el préstamo de una publicación (solo si es prestable)
    public void prestarPublicacion(Publicacion publicacion) throws NoDisponibleException {
        if (publicacion instanceof Prestable) {
            Prestable p = (Prestable) publicacion;
            p.prestar();
        } else {
            System.out.printf("Aviso: '%s' no se puede prestar (tipo no prestable).\n", publicacion.getTitulo());
        }
    }

    // Intenta devolver una publicación (solo si es prestable)
    public void devolverPublicacion(Publicacion publicacion) throws NoPrestadoException {
        if (publicacion instanceof Prestable) {
            Prestable p = (Prestable) publicacion;
            p.devolver();
        } else {
            System.out.println("Aviso: esta publicación no permite devolución por no ser prestable.");
        }
    }

    // Imprime la información de todas las publicaciones registradas
    public void mostrarPublicaciones() {
        if (publicaciones.isEmpty()) {
            System.out.println("[No hay publicaciones en el catálogo]");
        } else {
            for (Publicacion p : publicaciones) {
                p.mostrarInformacion();
            }
        }
    }
}
